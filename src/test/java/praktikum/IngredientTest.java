package praktikum;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType type;
    private String name;
    private float price;
    private double delta = 0.0001;


    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.FILLING, "cutlet", 200.5f}
        };
    }


    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), delta);
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
    }
}