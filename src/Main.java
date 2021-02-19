import Gravity.Gravity;
import Humans.*;
import Storages.*;
import Things.*;
import ThingsAndStorages.*;

public class Main {
    public static void main(String[] args) {
        //а если еще комит
        Human znaika = new Znaika(10, Mineral.MOONROCK);
        Storage bottomCupboard = new Cupboard(Mineral.ROCKCRYSTAL, Mineral.FELDSPAR, Mineral.MICA, Mineral.IRONSTONE, Mineral.COPPERPYRITE, Mineral.SULFUR, Mineral.PYRITE, Mineral.CHALCOPYRITE, Mineral.ZINKBLENDE, Mineral.GALENA, Mineral.MAGNETICIRONORE);
        Storage topCupboard = new Cupboard(Mineral.DIAMOND, Mineral.APATITE, Mineral.HALITE);
        ThingAndStorage ruler = new Ruler();
        Storage drawer = new Drawer(ruler);
        Gravity znaikaRoomGravity = new Gravity(true, znaika, bottomCupboard, topCupboard, ruler, drawer);
        StorageManager s = new StorageManager(znaikaRoomGravity);

        s.give(znaika, Mineral.MOONROCK, bottomCupboard);
        s.take(znaika, Mineral.ROCKCRYSTAL, bottomCupboard);
        s.take(znaika, Mineral.FELDSPAR, bottomCupboard);
        s.take(znaika, Mineral.MICA, bottomCupboard);
        s.take(znaika, Mineral.IRONSTONE, bottomCupboard);
        s.take(znaika, Mineral.COPPERPYRITE, bottomCupboard);
        s.take(znaika, Mineral.SULFUR, bottomCupboard);
        s.take(znaika, Mineral.PYRITE, bottomCupboard);
        s.take(znaika, Mineral.CHALCOPYRITE, bottomCupboard);
        znaika.changeHope(-2);
        s.take(znaika, Mineral.ZINKBLENDE, bottomCupboard);
        s.take(znaika, Mineral.GALENA, bottomCupboard);
        s.take(znaika, Mineral.DIAMOND, topCupboard);
        s.take(znaika, Mineral.APATITE, topCupboard);
        znaika.changeHope(-2);
        s.take(znaika, Mineral.HALITE, topCupboard);
        znaika.changeHope(-5);
        znaika.printHope();
        s.take(znaika, Mineral.MAGNETICIRONORE, bottomCupboard);
        znaika.changeHope(7);

        s.take(znaika, ruler, drawer);
        s.give(znaika, Mineral.MAGNETICIRONORE, ruler);
        s.take(znaika, Mineral.MOONROCK, bottomCupboard);
        s.give(znaika, Mineral.MOONROCK, ruler);

    }
}
