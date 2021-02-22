package gravity;

import humans.Human;
import interfaces.Storage;
import things.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Gravity {
    private final ArrayList<Storage> storages = new ArrayList<>();
    private boolean gravity;
    private final ArrayList<Human> humans = new ArrayList<>();

    public Gravity(boolean gravity, Human[] humans, Storage[] storages) {
        this.gravity = gravity;
        this.storages.addAll(Arrays.asList(storages));
        this.humans.addAll(Arrays.asList(humans));
    }

    private void humansCanFly(boolean bool) {

        class HumanStr {
            private final ArrayList<String> string;

            public HumanStr() {
                this.string = new ArrayList<>();
                humans.forEach((Human h) -> string.add(h.translation()));
            }

        }

        HumanStr humans =new HumanStr();
        System.out.print(String.join(", ", humans.string));
        System.out.println(bool ? " FLEW UP" : " FELL DOWN");
    }

    public void checkGravity() {
        for (Storage storage : storages) {
            if (storage.have(Mineral.MOONROCK) && storage.have(Mineral.MAGNETICIRONORE)) {
                if (gravity) {
                    System.out.println("Внимание: На дворе невесомость");
                    humansCanFly(true);
                }
                gravity = false;
                break;
            } else if (storage.have(Mineral.MOONROCK) || storage.have(Mineral.MAGNETICIRONORE)) {
                if (!gravity) {
                    System.out.println("Внимание: Действует сила тяжести");
                    humansCanFly(false);
                }
                gravity = true;
                break;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gravity gravity1 = (Gravity) o;
        return gravity == gravity1.gravity && Objects.equals(storages, gravity1.storages) && Objects.equals(humans, gravity1.humans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storages, gravity, humans);
    }

    @Override
    public String toString() {
        return "Gravity{" +
                "storages=" + storages +
                ", gravity=" + gravity +
                ", humans=" + humans +
                '}';
    }
}
