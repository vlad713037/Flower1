package by.viraz84.training.srv;

import by.viraz84.training.flower.Flower;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bouquet implements InBouquet {
    private static final Logger LOGGER = LoggerFactory.getLogger(Bouquet.class);


    private Flower[] flowers;
    private int position;


    public Bouquet(Flower[] flowers){
        LOGGER.trace ("Creating object", flowers);
        this.flowers = Arrays.copyOf(flowers, flowers.length);
        position = 0;
    }

    public Flower[] getFlowers() {
        return this.flowers;
    }

    @Override
    public void addFlower(Flower flower) {
        LOGGER.debug("The length of our array BEFORE check  {} ",flowers.length);
        checkArrayLength();
        LOGGER.debug("The length of our array AFTER check {} ",flowers.length);
        LOGGER.info("Adding {} flower {}",position+1,flower.getName());
        flowers[position] = flower;
        position++;

    }

    @Override
    public double getBouquetPrice() {
        double result = 0;
        for (Flower fl : this.flowers){
            LOGGER.debug("Price for a {} flower", fl);
            if (fl != null) {
                LOGGER.info("Summa all added flowers  {} ", result);
                result += fl.getPrice();
            } else {
                LOGGER.warn("__Flower not found__");
                break;
            }
        }
        LOGGER.info("ALL PRICE of Bouquet  {} ", result);
        return result;
    }

    public void checkArrayLength() {
        LOGGER.trace("flowers.length  {} < position(+2)  {}",flowers.length, position);
        if (flowers.length < position + 2){
            int item = flowers.length;
            if (flowers.length == 0){
                item = 2;
            }
            LOGGER.info("Our new array {} length", flowers.length);
            flowers = Arrays.copyOf(flowers, item*2);
        }
    }

    public static void printBouquet(Flower[] flowers){
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (Flower fl : flowers){
            if (fl != null){
            str.append(" ");
            str.append(fl.getName());
            str.append(" ");
            }
        }
        str.append("]");
        System.out.println(str);
    }

    public static List<Flower> findByLength(Flower[] flowers,  int a, int b){
        List<Flower> flo = new ArrayList<>();
        LOGGER.trace("Creating List<Flower> for findByLength");
        for (Flower fl : flowers){
            if (fl != null) {
                LOGGER.debug("Checking flower length {} ", fl);
                if (fl.getStalk() >= a && fl.getStalk() <=b){
                    LOGGER.info("Satisfies the parameters of the flower {}, add it in List", fl);
                    flo.add(fl);
                }
            } else {
                LOGGER.warn("__Flower not found__");
                break;
            }
        }
        System.out.println("Satisfying the search conditions " + flo.size()+":");
        for (Flower ff : flo){
            System.out.println("\t"+ff.getName()+" ");
        }
        return flo;
    }

    public static List<Flower> sortBouquetByFreshness(Flower[] flowers){
        List<Flower> flo = new ArrayList<>();
        LOGGER.trace("Creating List<Flower> for sort");
        for (Flower fl : flowers){
            if (fl != null) {
                LOGGER.debug("Checking Freshness FullFresh for {} ", fl);
                if (fl.getFresh() == Freshness.FullFresh){
                    LOGGER.info("Freshness  FullFresh of the flower {}, add it in List", fl);
                    flo.add(fl);
                }
            } else {
                LOGGER.warn("__Flower not found__");
                break;
            }
        }
        for (Flower fl : flowers){
            if (fl != null) {
                LOGGER.debug("Checking Freshness MiddleFresh for {} ", fl);
                if (fl.getFresh() == Freshness.MiddleFresh){
                    LOGGER.info("Freshness  MiddleFresh of the flower {}, add it in List", fl);
                    flo.add(fl);
                }
            }
            else {
                LOGGER.warn("__Flower not found__");
                break;
            }
        }
        for (Flower fl : flowers){
            if (fl != null) {
                LOGGER.debug("Checking Freshness OldFresh for {} ", fl);
                if (fl.getFresh() == Freshness.OldFresh){
                    LOGGER.info("Freshness  OldFresh of the flower {}, add it in List", fl);
                    flo.add(fl);
                }
            }
            else {
                LOGGER.warn("__Flower not found__");
                break;
            }
        }
        System.out.println("Sorted bouquet by freshness: ");
        for (Flower ff : flo){
            System.out.println("\t"+ff.getName()+"  "+ ff.getFresh());
        }
        return flo;
    }

}
