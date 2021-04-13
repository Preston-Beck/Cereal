import models.BowlOfCereal;
import models.Cereal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BowlOfCerealTest {

    private BowlOfCereal breakfast;
    private Cereal cereal1;
    private Cereal cereal2;
    private List<String> ingredients1 = Arrays.asList("oats", "sugar", "marshmallows");
    private List<String> ingredients2 = Arrays.asList("corn", "sugar", "honey");
    private ArrayList<Cereal> cereals = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cereal1 = new Cereal("Luckycharms", "General Mills", "oats",
            false, true, 140, 2, 29, ingredients1);

        cereal2 = new Cereal("Honeycombs", "Post", "corn",
                false, true, 120, 3, 60, ingredients2);

        cereals.add(cereal1);
        cereals.add(cereal2);

        breakfast = new BowlOfCereal("skim milk", 3, true, cereals);

//        breakfast.addCereal(cereal);
    }


    @Test
    void setMilkTypeInvalid() {
        assertThrows(IllegalArgumentException.class, ()->
                breakfast.setMilkType("Monkey Milk"));
    }

    @Test
    void setMilkTypeUpperCase() {
        breakfast.setMilkType("Skim milk");
        assertEquals("skim milk", breakfast.getMilkType());
    }

    @Test
    void setBowlSizeLow() {
        assertThrows(IllegalArgumentException.class, ()->
                breakfast.setBowlSize(0));
    }

    @Test
    void setBowlSizeHigh() {
        assertThrows(IllegalArgumentException.class, ()->
                breakfast.setBowlSize(6));
    }

    @Test
    void getTotalCalories() {
        assertEquals(640, breakfast.getTotalCalories());
    }

    @Test
    void isNutFreeBowl() {
        assertEquals(true, breakfast.isNutFreeBowl());
    }

    @Test
    void getTotalServings() {
        assertEquals(5, breakfast.getTotalServings());
    }
}
