package Gravity;

import Storages.*;
import Things.*;

import java.util.Arrays;

public class Gravity {
    private static boolean gravity = true;
    private static Storage[] storages;

    public Gravity(Storage... storages) {
        Gravity.storages = storages;
    }

    public static void checkGravity() {
        for (Storage storage : storages) {
            if (storage.have(Mineral.MOONROCK) && storage.have(Mineral.MAGNETICIRONORE)) {
                if (gravity) {
                    System.out.println("Внимание: На дворе невесомость");
                }
                gravity = false;
                break;
            } else if (storage.have(Mineral.MOONROCK) || storage.have(Mineral.MAGNETICIRONORE)) {
                if (!gravity) {
                    System.out.println("Внимание: Действует сила тяжести");
                }
                gravity = true;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Gravity{" +
                "gravity=" + gravity +
                ", storages=" + Arrays.toString(storages) +
                '}';
    }
}
