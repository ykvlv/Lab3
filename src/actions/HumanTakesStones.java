package actions;

import gravity.Gravity;
import humans.Human;
import interfaces.Action;
import interfaces.IStorage;
import storages.StorageManager;

public class HumanTakesStones implements Action {
    StorageManager s;
    Gravity g;
    Human znaika;
    IStorage[] storages;
    public HumanTakesStones(StorageManager s, Gravity g, Human znaika, IStorage... storages) {
        this.s = s;
        this.g = g;
        this.znaika = znaika;
        this.storages = storages;
    }

    @Override
    public void runAction() {
        for (IStorage storage: storages) {
            while (!storage.isEmpty()) {
                s.takeSomething(znaika, storage);
                if (g.getGravity()) {
                    System.out.println("Ах вот кто ты!");
                    break;
                } else {
                    znaika.changeHope(-1);
                }
            }
        }
    }
}
