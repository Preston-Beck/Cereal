package utilities;

import models.Cereal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class startingCereals {
    private static final List<String> luckyCharmsIngredients = Arrays.asList("oats", "sugar", "marshmallows");
    private static final List<String> captainCrunchIngredients = Arrays.asList("corn flour", "sugar", "oat flour", "palm oil", "salt");
    private static final List<String> oatmealCrispIngredients = Arrays.asList("oats", "sugar", "oat and honey clusters", "honey", "almond pieces");

    public static ArrayList<Cereal> getStartingCereals() {
        ArrayList<Cereal> cereals = new ArrayList<>();
        cereals.add(new Cereal("lucky charms", "General Mills", "oats", false, true, 140, 2, 29, luckyCharmsIngredients));
        cereals.add(new Cereal("captain crunch", "Quaker Oats", "corn", false, true, 144, 1, 35, captainCrunchIngredients));
        cereals.add(new Cereal("oatmeal crisp", "General Mills", "oats", false, false, 240, 3, 70, oatmealCrispIngredients));
        return cereals;
    }
}
