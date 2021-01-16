import Gravity.Gravity;
import Humans.Znaika;
import Storages.*;
import Things.*;

public class Main {
    public static void main(String[] args) {
        Znaika znaika = new Znaika(10, Mineral.MOONROCK);
        Cupboard bottomCupboard = new Cupboard(Mineral.ROCKCRYSTAL, Mineral.FELDSPAR, Mineral.MICA, Mineral.IRONSTONE, Mineral.COPPERPYRITE, Mineral.SULFUR, Mineral.PYRITE, Mineral.CHALCOPYRITE, Mineral.ZINKBLENDE, Mineral.GALENA, Mineral.MAGNETICIRONORE);
        Cupboard topCupboard = new Cupboard(Mineral.DIAMOND, Mineral.APATITE, Mineral.HALITE);
        Ruler ruler = new Ruler();
        Drawer drawer = new Drawer(ruler);
        Gravity gravity = new Gravity(znaika, bottomCupboard, topCupboard, ruler, drawer);

        Cupboard.checkDoors();
        Cupboard.changeDoors();
        znaika.give(Mineral.MOONROCK, bottomCupboard);
        znaika.take(Mineral.ROCKCRYSTAL, bottomCupboard);
        znaika.take(Mineral.FELDSPAR, bottomCupboard);
        znaika.take(Mineral.MICA, bottomCupboard);
        znaika.take(Mineral.IRONSTONE, bottomCupboard);
        znaika.take(Mineral.COPPERPYRITE, bottomCupboard);
        znaika.take(Mineral.SULFUR, bottomCupboard);
        znaika.take(Mineral.PYRITE, bottomCupboard);
        znaika.take(Mineral.CHALCOPYRITE, bottomCupboard);
        znaika.take(Mineral.ZINKBLENDE, bottomCupboard);
        znaika.changeHope(-2);
        znaika.take(Mineral.GALENA, bottomCupboard);
        znaika.take(Mineral.DIAMOND, topCupboard);
        znaika.take(Mineral.APATITE, topCupboard);
        znaika.changeHope(-2);
        znaika.take(Mineral.HALITE, topCupboard);
        znaika.changeHope(-5);
        znaika.printHope();
        znaika.take(Mineral.MAGNETICIRONORE, bottomCupboard);
        znaika.changeHope(7);

        znaika.take(ruler, drawer);
        znaika.give(Mineral.MAGNETICIRONORE, ruler);
        znaika.take(Mineral.MOONROCK, bottomCupboard);
        znaika.give(Mineral.MOONROCK, ruler);

    }
}
