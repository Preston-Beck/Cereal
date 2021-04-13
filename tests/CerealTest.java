import models.Cereal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CerealTest {

    private Cereal cereal;
    private List<String> ingredients = Arrays.asList("oats", "sugar", "marshmallows");

    @BeforeEach
    void setUp() {
        cereal = new Cereal("Luckycharms", "General Mills", "oats",
                false, true, 140, 2, 29, ingredients);
    }

    @Test
    void setNameInvalid() {
        assertThrows(IllegalArgumentException.class, ()->
                cereal.setName(" C "));
    }

    @Test
    void setBrandInvalid() {
        assertThrows(IllegalArgumentException.class, ()->
                cereal.setBrand(" B "));
    }

    @Test
    void setCerealBaseInvalid() {
        assertThrows(IllegalArgumentException.class, ()->
                cereal.setCerealBase("Pizza"));
    }

    @Test
    void setCerealBaseValid() {
        cereal.setCerealBase("oats");
        assertEquals("oats", cereal.getCerealBase());
    }

    @Test
    void setCaloriesPerServingInvalid() {
        assertThrows(IllegalArgumentException.class, ()->
                cereal.setCaloriesPerServing(49));
    }

    @Test
    void setServingsUnder() {
        assertThrows(IllegalArgumentException.class, ()->
                cereal.setServings(0));
    }

    @Test
    void setServingsOver() {
        assertThrows(IllegalArgumentException.class, ()->
                cereal.setServings(11));
    }

    @Test
    void setServings() {
        cereal.setServings(5);
        assertEquals(5, cereal.getServings());
    }


    @Test
    void setHealthRatingUnder() {
        assertThrows(IllegalArgumentException.class, ()->
                cereal.setHealthRating(-1));
    }

    @Test
    void setHealthRatingOver() {
        assertThrows(IllegalArgumentException.class, ()->
                cereal.setHealthRating(101));
    }

    @Test
    void setHealthRating() {
        cereal.setHealthRating(50);
        assertEquals(50, cereal.getHealthRating());
    }

    @Test
    void setIngredients() {
        assertEquals(ingredients, cereal.getIngredients());
    }
}