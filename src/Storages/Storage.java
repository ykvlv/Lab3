package Storages;

import Things.Thing;

public interface Storage {
    void give(Thing thing, Storage storage);
    void take(Thing thing, Storage storage);
    boolean have(Thing thing);
    String translation();
}
