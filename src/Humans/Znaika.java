package Humans;

import Storages.*;
import Things.Thing;
import Gravity.Gravity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Znaika extends Human {
    private final ArrayList<Thing> things = new ArrayList<>();

    public Znaika(int hope, Thing... things) {
        super(hope);
        this.things.addAll(Arrays.asList(things));
    }

    @Override
    public String translation() {
        return "Знайка";
    }

    @Override
    public void give(Thing thing, Storage storage) {
        if (this.have(thing) && (!(storage instanceof Cupboard) || Cupboard.getDoors())) {
            things.remove(thing);
            storage.take(thing, this);
            System.out.printf("%s положил %s в %s%n", this.translation(), thing.translation(), storage.translation());

            Gravity.checkGravity();
        } else {
            System.out.printf("У %s нету %s, или доступ к %s ограничен%n", this.translation(), thing.translation(), storage.translation());
        }
    }

    @Override
    public void take(Thing thing, Storage storage) {
        if (storage.have(thing)) {
            storage.give(thing, this);
            things.add(thing);
            System.out.printf("%s взял %s из %s%n", this.translation(), thing.translation(), storage.translation());

            Gravity.checkGravity();
        } else {
            System.out.printf("У %s нету %s, или доступ к %s ограничен%n", storage.translation(), thing.translation(), storage.translation());
        }

    }

    @Override
    public boolean have(Thing thing) {
        return things.contains(thing);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Znaika znaika = (Znaika) o;
        return Objects.equals(things, znaika.things) && Objects.equals(getHope(), znaika.getHope());
    }

    @Override
    public int hashCode() {
        return Objects.hash(things, getHope());
    }

    @Override
    public String toString() {
        return "Znaika{" +
                "hope=" + getHope() +
                ", things=" + things +
                '}';
    }
}
