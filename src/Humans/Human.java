package Humans;

import Storages.Storage;
import Things.Thing;

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
    public boolean have(Thing thing) {
        return things.contains(thing);
    }
    public void changeHope(int hope) {
        if (this.hope + hope >= 0 && this.hope + hope <= 10) {
            this.hope += hope;
        } else if (hope < 0) {
            this.hope = 0;
        } else if (hope > 0) {
            this.hope = 10;
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
}
