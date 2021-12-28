package praktikum;


import org.junit.Assert;
import org.junit.Test;


public class BunTest {
     String name = "Бургер";
     float price = 7.1f;
     Bun bun = new Bun(name, price);

     @Test
    public void getNameTest() {
         Assert.assertEquals(name, bun.getName());
    }
    @Test
    public void getPriceTest() {
        Assert.assertEquals(price, bun.getPrice(),0.0001);
    }
}