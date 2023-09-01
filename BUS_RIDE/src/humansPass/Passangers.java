package humansPass;

/**
 * Пассажиры что едут в автобусе. Каждый имеет возможность взять с собой одну собаку.
 */
public class Passangers {
    private int amoutOfPassangers;
    private int amoutOfDogs;

    public void setAmoutOfPassangers(int amoutOfPassangers) {
        this.amoutOfPassangers = amoutOfPassangers;
    }

    public int getAmoutOfPassangers() {
        return amoutOfPassangers;
    }

    public void setAmoutOfDogs(int amoutOfDogs) {
        this.amoutOfDogs = amoutOfDogs;
    }

    public int getAmoutOfDogs() {

        if (amoutOfDogs > amoutOfPassangers) {
            System.out.println("Каждая собака должна ехать в сопровождении не меньше чем одного человека");
        }
        return amoutOfDogs;
    }
}
