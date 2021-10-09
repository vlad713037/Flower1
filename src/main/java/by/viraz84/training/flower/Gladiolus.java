package by.viraz84.training.flower;

import by.viraz84.training.srv.Freshness;

public class Gladiolus extends Flower {
    private final static String name = "Gladiolus";

    public Gladiolus(double price, int stalk, Freshness fresh) {

        super(name, price, stalk, fresh);
    }
}