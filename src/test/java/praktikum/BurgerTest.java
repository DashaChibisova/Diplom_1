package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends TestData {

    @Mock
    private Ingredient mockIngredient;

    @Mock
    private Bun mockBun;

    @Test
    public void addIngredientTest() {
        addIngredientMock(2);
        int expected = 2;
        Assert.assertEquals(expected, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        addIngredientMock(2);
        burger.removeIngredient(0);
        int expectedSize = 1;
        int expectedPrice = 2;
        Assert.assertEquals(expectedSize, burger.ingredients.size());
        Assert.assertEquals(expectedPrice, burger.ingredients.get(0).price, delta);
    }

    @Test
    public void moveIngredientTest() {
        addIngredientMock(3);
        int index = 0;
        int newIndex = 2;
        int expected = 3;
        burger.moveIngredient(index, newIndex);
        Assert.assertEquals(expected, burger.ingredients.get(2).price, delta);
    }

    @Test
    public void getPriceTest() {
        addIngredientMock(2);
        float expected = 10;
        when(mockBun.getPrice()).thenReturn(2f);
        burger.setBuns(mockBun);
        when(mockIngredient.getPrice()).thenReturn(3f);
        Assert.assertEquals(expected, burger.getPrice(), delta);
    }

    @Test
    public void getReceiptTest() {
        addIngredientMock(1);
        burger.setBuns(mockBun);
        String nameBurger = "Burger";
        String nameIngredient = "food";
        float price = 100.6f;
        String priceChek = "100,599998";
        String chek = "(==== " + nameBurger + " ====)\r\n" +
                "= sauce " + nameIngredient + " =\r\n" +
                "(==== " + nameBurger + " ====)\r\n" +
                "\r\n" + "Price: " + priceChek + "" + "\r\n";

        IngredientType type = IngredientType.SAUCE;
        when(mockBun.getName()).thenReturn(nameBurger);
        when(mockIngredient.getType()).thenReturn(type);
        when(mockIngredient.getName()).thenReturn(nameIngredient);
        when(burger.getPrice()).thenReturn(price);
        Assert.assertEquals(chek, burger.getReceipt());

    }

    private void addIngredientMock(int count) {
        for (int i = 1; i <= count; i++) {
            mockIngredient.price = i;
            burger.addIngredient(mockIngredient);
        }
    }
}