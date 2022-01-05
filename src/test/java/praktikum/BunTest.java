package praktikum;


import org.junit.Assert;
import org.junit.Test;


public class BunTest {
    private String name = "Бургер";
    private float price = 7.1f;
    private Bun bun = new Bun(name, price);

    @Test
    public void getNameTest() {
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(price, bun.getPrice(), 0.0001);
    }
}