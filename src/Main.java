import gravity.Gravity;
import humans.*;
import interfaces.Storage;
import interfaces.Thing;
import storages.*;
import things.*;
import thingsAndStorages.*;

public class Main {
    public static void main(String[] args) {
        Human znaika = new Znaika(10, Mineral.MOONROCK);
        Human neznaika = new Neznaika(7, new Mineral.ArrayOfMinerals(3) {
            public Thing[] getElements() {
                return new Thing[]{this.elements[1]};
            }
        });
        Human.Characteristics chNeznaika = neznaika.new Characteristics(14);
        Human.Characteristics chZnaika = znaika.new Characteristics(150);
        Storage bottomCupboard = new Cupboard(false, Mineral.ROCKCRYSTAL, Mineral.FELDSPAR, Mineral.MICA, Mineral.IRONSTONE, Mineral.COPPERPYRITE, Mineral.SULFUR, Mineral.PYRITE, Mineral.CHALCOPYRITE, Mineral.ZINKBLENDE, Mineral.GALENA, Mineral.MAGNETICIRONORE);
        Storage topCupboard = new Cupboard(true, Mineral.DIAMOND, Mineral.APATITE, Mineral.HALITE);
        Ruler ruler = new Ruler();
        Storage drawer = new Drawer(ruler);
        Gravity znaikaRoomGravity = new Gravity(true, new Human[]{znaika, neznaika}, new Storage[]{bottomCupboard, topCupboard, ruler, drawer});
        StorageManager s = new StorageManager(znaikaRoomGravity);



        znaika.say("Надо доставать из шкафчика все хранящиеся минералы. Как только будет удалено существо, с которым взаимодействует лунит, невесомость исчезнет, и мы узнаем, что это за вещество");
        s.give(znaika, Mineral.MOONROCK, bottomCupboard);
        s.open(znaika, bottomCupboard);
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
        s.take(znaika, Mineral.MOONROCK, ruler);
        s.give(znaika, Mineral.MOONROCK, ruler);
        znaika.say("Нормально так жмыхнуло.");
        neznaika.say("Еще бы");
    }
}
