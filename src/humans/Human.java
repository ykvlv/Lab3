package humans;

import exceptions.*;
import interfaces.Storage;
import interfaces.Thing;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Human implements Storage {
    private int hope = 5;
    private final ArrayList<Thing> things = new ArrayList<>();

    public Human(int hope) {
        this.hope = hope;
    }

    public Human(int hope, Thing... things) {
        this.hope = hope;
        this.things.addAll(Arrays.asList(things));
    }

    @Override
    public String translation() {
        return "Человек";
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
    public boolean opened() {
        return true;
    }

    @Override
    public void openClose() throws CannotBeChangedException {
        throw new CannotBeChangedException(translation() + " нельзя " + (opened() ? "закрыть" : "открыть") + " для обмена");
    }

    @Override
    public boolean have(Thing thing) {
        return things.contains(thing);
    }

    public void changeHope(int hope) {
        int min = 0, max = 10;
        if (this.hope + hope < min && this.hope + hope > max) {
            throw new OutOfIntervalException("Выход за пределы [" + min + ", " + max + "]");
        } else {
            this.hope += hope;
        }
    }

    public void printHope() {
        System.out.printf("Уровень надежды %s %d/10%n", this.translation(), hope);
    }

    public int getHope() {
        return hope;
    }

    public void say(String str) {
        System.out.printf("%s говорит: %s%n", translation(), str);
    }

    public class Characteristics {
        public int iq = 100;

        public Characteristics(int iq) {
            this.iq = iq;
        }

        public Characteristics() {

        }
    }
}
