package by.viraz84.training.flower;

import by.viraz84.training.srv.Freshness;

public class Tulip extends Flower {
    private final static String name = "Tulip";
    public Tulip(double price, int stalk, Freshness fresh) {
        super(name, price, stalk, fresh);
    }
}
