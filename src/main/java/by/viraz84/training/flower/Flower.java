package by.viraz84.training.flower;

import by.viraz84.training.srv.Freshness;

public abstract class Flower {
    private final String name;
    private final double price;
    private final int stalk;
    private final Freshness fresh;


    protected Flower(String name, double price, int stalk, Freshness fresh) {
        this.name = name;
        this.price = price;
        this.stalk = stalk;
        this.fresh = fresh;
    }

    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getStalk(){
        return stalk;
    }
    public Freshness getFresh(){
        return fresh;
    }

// TEST
}

