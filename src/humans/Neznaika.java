package humans;

import things.Mineral;

public class Neznaika extends Human {

    public Neznaika(int hope) {
        super(hope);
    }

    public Neznaika(int hope, Mineral.ArrayOfMinerals minerals) {
        super(hope, minerals.getElements());
    }

    @Override
    public String translation() {
        return "Незнайка";
    }

}
