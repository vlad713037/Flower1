package by.viraz84.training.run;

import by.viraz84.training.flower.*;
import by.viraz84.training.srv.Bouquet;
import by.viraz84.training.srv.Freshness;

public class Main {
    public static void main(String[] args) {
        Bouquet bouquet = new Bouquet(new Flower[2]);

        Flower rose = new Rose(9.5, 360, Freshness.FullFresh);
        Flower astra = new Astra(5.3,100,Freshness.MiddleFresh);
        Flower orchid = new Orchid(2.3,50,Freshness.OldFresh);
        Flower gladiolus = new Gladiolus(10.5,250,Freshness.FullFresh);
        Flower tulip = new Tulip(1.5,250,Freshness.MiddleFresh);

        bouquet.addFlower(rose);
        bouquet.addFlower(astra);
        bouquet.addFlower(orchid);
        bouquet.addFlower(gladiolus);
        bouquet.addFlower(tulip);


        Bouquet.printBouquet(bouquet.getFlowers());
        System.out.println("Price of this bouquet " + bouquet.getBouquetPrice() + " $");
        Bouquet.findByLength(bouquet.getFlowers(),60,300);
        Bouquet.sortBouquetByFreshness(bouquet.getFlowers());
   }
}
