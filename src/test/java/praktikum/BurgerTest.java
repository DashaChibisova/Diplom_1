package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    private double delta = 0.0001;

    @Mock
    private Ingredient mokIngredient;

    @Mock
    private Bun mokBun;
    @Mock
    private Burger mokBurger;

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
        when(mokBun.getPrice()).thenReturn(2f);
        burger.setBuns(mokBun);
        when(mokIngredient.getPrice()).thenReturn(3f);
        Assert.assertEquals(expected, burger.getPrice(), delta);
    }

    //Хз хренова цена
    @Test
    public void getReceiptTest() {
        addIngredientMock(1);
        burger.setBuns(mokBun);
        String nameBurger = "Burger";
        String nameIngredient = "food";
        String price = "100.6";
        IngredientType type = IngredientType.SAUCE;
        when(mokBun.getName()).thenReturn(nameBurger);
        when(mokIngredient.getType()).thenReturn(type);
        when(mokIngredient.getName()).thenReturn(nameIngredient);
        when(burger.getPrice()).thenReturn(Float.valueOf(price));
        Assert.assertThat(burger.getReceipt(), containsString(nameBurger));
        Assert.assertThat(burger.getReceipt(), containsString(String.valueOf(type).toLowerCase()));
        Assert.assertThat(burger.getReceipt(), containsString(nameIngredient));
       // Assert.assertThat(burger.getReceipt(), containsString(price));

    }

    private void addIngredientMock(int count) {
        for (int i = 1; i <= count; i++) {
            mokIngredient.price = i;
            burger.addIngredient(mokIngredient);
        }
    }
}