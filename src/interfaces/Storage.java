package interfaces;

import exceptions.CannotBeChangedException;

public interface Storage {
    void give(Thing thing);
    void take(Thing thing);
    boolean have(Thing thing);
    String translation();
    boolean opened();
    void openClose() throws CannotBeChangedException;
}
