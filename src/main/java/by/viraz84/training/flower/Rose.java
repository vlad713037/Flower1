package by.viraz84.training.flower;

import by.viraz84.training.srv.Freshness;

public class Rose extends Flower {
    private final static String name = "Rose";
    public Rose(double price, int stalk, Freshness fresh) {

        super(name, price, stalk, fresh);
    }
}
