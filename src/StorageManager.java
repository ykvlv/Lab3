import exceptions.CannotBeChangedException;
import gravity.Gravity;
import humans.Human;
import interfaces.Storage;
import interfaces.Thing;
import things.*;

public class StorageManager {
    private final Gravity subscriber;

    public StorageManager(Gravity gravity) {
        this.subscriber = gravity;
    }

    public void give(Human sender, Thing thing, Storage receiver) {
        if (!sender.have(thing)) {
            System.out.printf("У %s нету %s в инвентаре%n", sender.translation(), thing.translation());
        } else if (!receiver.opened()) {
            System.out.printf("Доступ к %s ограничен%n", receiver.translation());
        } else {
            sender.give(thing);
            receiver.take(thing);
            System.out.printf("%s положил %s в %s%n", sender.translation(), thing.translation(), receiver.translation());
            updateSubscriber(thing);
        }
    }

    public void take(Human receiver, Thing thing, Storage sender) {
        if (sender.have(thing) && receiver.opened()) {
            sender.give(thing);
            receiver.take(thing);
            System.out.printf("%s достал %s из %s%n", receiver.translation(), thing.translation(), sender.translation());
            updateSubscriber(thing);
        } else {
            System.out.printf("У %s нету %s или доступ %s ограничен%n", sender.translation(), thing.translation(), receiver.translation());
        }
    }

    public void open(Human human, Storage storage) {
        try {
            storage.openClose();
            if (storage.opened()) {
                System.out.printf("%s открыл %s%n", human.translation(), storage.translation());
            } else if (!storage.opened()) {
                System.out.printf("%s закрыл %s%n", human.translation(), storage.translation());
            }
        } catch (CannotBeChangedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateSubscriber(Thing thing) {
        if (thing == Mineral.MOONROCK || thing == Mineral.MAGNETICIRONORE) {
            subscriber.checkGravity();
        }
    }
}
