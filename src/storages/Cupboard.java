package storages;

import interfaces.Storage;
import interfaces.Thing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Cupboard implements Storage {
    private final ArrayList<Thing> things = new ArrayList<>();
    private boolean open = true;

    public Cupboard(boolean open, Thing... things) {
        this.open = open;
        this.things.addAll(Arrays.asList(things));
    }


    @Override
    public String translation() {
        return "Шкаф";
    }

    @Override
    public boolean opened() {
        return open;
    }

    @Override
    public void openClose() {
        open = !open;
    }

    @Override
    public void give(Thing thing) {
        things.remove(thing);
    }

    @Override
    public void take(Thing thing) {
        things.add(thing);
    }

    @Override
    public boolean have(Thing thing) {
        return things.contains(thing);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cupboard cupboard = (Cupboard) o;
        return Objects.equals(things, cupboard.things);
    }

    @Override
    public int hashCode() {
        return Objects.hash(things);
    }

    @Override
    public String toString() {
        return "Cupboard{" +
                ", things=" + things +
                '}';
    }
}
