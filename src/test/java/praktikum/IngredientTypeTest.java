package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private int type;
    private String expected;

    public IngredientTypeTest(int type, String expected) {
        this.type = type;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {0, "SAUCE"},
                {1, "FILLING"},
        };
    }

    @Test
    public  void getIngredientTypeTest(){
        Assert.assertEquals(expected, IngredientType.values()[type].name());
    }
}
