package by.viraz84.training.flower;

import by.viraz84.training.srv.Freshness;

public class Orchid extends Flower {
    private final static String name = "Orchid";
    public Orchid(double price, int stalk, Freshness fresh) {

        super(name, price, stalk, fresh);
    }
}
