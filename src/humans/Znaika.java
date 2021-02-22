package humans;

import interfaces.Thing;

public class Znaika extends Human {

    public Znaika(int hope, Thing... things) {
        super(hope, things);
    }

    @Override
    public String translation() {
        return "Знайка";
    }

}
