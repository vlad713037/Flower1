package by.viraz84.training;


import by.viraz84.training.flower.Flower;
import by.viraz84.training.flower.Gladiolus;
import by.viraz84.training.flower.Orchid;
import by.viraz84.training.flower.Rose;
import by.viraz84.training.srv.Bouquet;
import by.viraz84.training.srv.Freshness;
import org.junit.Test;
import org.junit.Assert;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;


public class BouquetTest {
    private Flower[] flowers;
    private int position;


    @Test
    public void testAdd() throws Exception {
        Flower[] a1 = new Flower[4];
        Bouquet b1 = new Bouquet(new Flower[4]);
        Flower rose1 = new Rose(9.5, 360, Freshness.FullFresh);
        Flower orchid1 = new Orchid(2.5, 200, Freshness.OldFresh);
        Flower gladiolus1 = new Gladiolus(10.5, 70, Freshness.FullFresh);
        a1[0] = rose1;
        a1[1] = orchid1;
        a1[2] = gladiolus1;
        b1.addFlower(rose1);
        b1.addFlower(orchid1);
        b1.addFlower(gladiolus1);
        Assert.assertArrayEquals(a1, b1.getFlowers());
        }

    @Test
    public void testBouquetPrice() {
        Bouquet b1 = new Bouquet(new Flower[30]);
        Flower rose1 = new Rose(9.5, 360, Freshness.FullFresh);
        Flower orchid1 = new Orchid(2.5, 200, Freshness.OldFresh);
        Flower gladiolus1 = new Gladiolus(10.5, 70, Freshness.FullFresh);
        b1.addFlower(rose1);
        b1.addFlower(orchid1);
        b1.addFlower(gladiolus1);
        double c = b1.getBouquetPrice();
        assertThat(c).isEqualTo(22.5);
    }

    @Test
    public void testFindByLength() {
        Flower rose1 = new Rose(9.5, 360,Freshness.FullFresh);
        Flower orchid1 = new Orchid(2.5,200,Freshness.OldFresh);
        Flower gladiolus1 = new Gladiolus(10.5,70,Freshness.FullFresh);
        Flower[] a1 = new Flower[3];
        a1[0]=rose1;
        a1[1]=orchid1;
        a1[2]=gladiolus1;
        List<Flower> actual = Bouquet.findByLength(a1,60, 300);
        List<Flower> expected = Arrays.asList(orchid1, gladiolus1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortByFreshness(){
        Flower rose1 = new Rose(9.5, 360,Freshness.OldFresh);
        Flower orchid1 = new Orchid(2.5,200,Freshness.MiddleFresh);
        Flower gladiolus1 = new Gladiolus(10.5,70,Freshness.FullFresh);
        Flower[] a1 = new Flower[3];
        a1[0]=rose1;
        a1[1]=orchid1;
        a1[2]=gladiolus1;
        List<Flower> actual = Bouquet.sortBouquetByFreshness(a1);
        List<Flower> expected = Arrays.asList(gladiolus1, orchid1, rose1);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void testAddExeption() throws Exception {
        Bouquet b1 = new Bouquet(new Flower[3]);
        Flower rose1 = new Rose(9.5, 360, Freshness.FullFresh);
        Flower orchid1 = null;
        b1.addFlower(rose1);
        b1.addFlower(orchid1);
    }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testFindByLengthEx() {
        Flower rose1 = new Rose(9.5, 360, Freshness.FullFresh);
        Flower orchid1 = new Orchid(2.5, 200, Freshness.OldFresh);
        Flower gladiolus1 = new Gladiolus(10.5, 70, Freshness.FullFresh);
        Flower[] a1 = new Flower[2];
        a1[0] = rose1;
        a1[1] = orchid1;
        a1[2] = gladiolus1;
        List<Flower> actual = Bouquet.findByLength(a1, 60, 300);
        List<Flower> expected = Arrays.asList(orchid1, gladiolus1);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testAdd_2() throws Exception {
        Flower[] a1 = new Flower[2];
        Bouquet b1 = new Bouquet(new Flower[2]);
        Flower rose1 = new Rose(9.5, 360, Freshness.FullFresh);
        Flower orchid1 = new Orchid(2.5, 200, Freshness.OldFresh);
        Flower gladiolus1 = new Gladiolus(10.5, 70, Freshness.FullFresh);
        a1[0] = rose1;
        a1[1] = null;
        b1.addFlower(rose1);
        assertThat(b1.getFlowers()).isEqualTo(a1);
        }

    @Test(expected = NullPointerException.class)
    public void testAdd_3() throws Exception {
        Flower[] a1 = new Flower[2];
        Bouquet b1 = new Bouquet(new Flower[2]);
        Flower rose1 = new Rose(9.5, 360, Freshness.FullFresh);
        Flower orchid1 = new Orchid(2.5, 200, Freshness.OldFresh);
        a1[0] = rose1;
        a1[1] = null;
        b1.addFlower(rose1);
        b1.addFlower(null);
        assertThat(b1.getFlowers()).isEqualTo(a1);
    }
}