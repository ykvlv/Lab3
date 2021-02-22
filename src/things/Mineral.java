package things;

import interfaces.Thing;

import java.util.Random;


public enum Mineral implements Thing {
    MOONROCK("Лунный камень"),
    ROCKCRYSTAL("Горный хрусталь"),
    FELDSPAR("Полевой шпат"),
    MICA("Слюда"),
    IRONSTONE("Бурый железняк"),
    COPPERPYRITE("Медный колчедан"),
    SULFUR("Сера"),
    PYRITE("Пирит"),
    CHALCOPYRITE("Халькопирит"),
    ZINKBLENDE("Цинковая обманка"),
    GALENA("Свинцовый блеск"),
    MAGNETICIRONORE("Магнитный железняк"),
    DIAMOND("Алмаз"),
    APATITE("Апатит"),
    HALITE("Галит");

    Mineral(String translation){
        this.translation = translation;
    }

    private final String translation;

    @Override
    public String translation() {
        return this.translation;
    }

    public static class ArrayOfMinerals {
        public final Thing[] elements;

        public ArrayOfMinerals(int count) {
            Mineral[] m = Mineral.values();
            Random rnd = new Random();
            Mineral[] e = new Mineral[count];
            for (int i = 0; i < count; i++) {
                e[i] = m[rnd.nextInt(m.length)];
            }
            this.elements = e;
        }

        public Thing[] getElements() {
            return this.elements;

        }
    }
}