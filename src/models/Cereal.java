package models;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;

public class Cereal {
    private String name, brand, cerealBase;
    private boolean driedFruit, nutFree;
    private int caloriesPerServing, servings, healthRating;
//    private Image img;
    private List<String> ingredients;
    private ArrayList<String> validCerealBase;

    public Cereal(String name, String brand, String cerealBase, boolean driedFruit,
                  boolean nutFree, int caloriesPerServing, int servings, int healthRating,
                  List<String> ingredients) {
        setName(name);
        setBrand(brand);
        setCerealBase(cerealBase);
        setDriedFruit(driedFruit);
        setNutFree(nutFree);
        setCaloriesPerServing(caloriesPerServing);
        setServings(servings);
        setHealthRating(healthRating);
//        setImg(name);
        setIngredients(ingredients);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.toLowerCase().trim();
        if(name.length() >= 2)
            this.name = name;
        else
            throw new IllegalArgumentException(name + " must be at least 2 characters long.");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        brand = brand.toLowerCase().trim();
        if(brand.length() >= 2)
            this.brand = brand;
        else
            throw new IllegalArgumentException(brand + " must be at least 2 characters long.");
    }

    public String getCerealBase() {
        return cerealBase;
    }

    public void setCerealBase(String cerealBase) {
        ArrayList <String> validCerealBase = new ArrayList<>();
        validCerealBase.add("wheat");
        validCerealBase.add("maize");
        validCerealBase.add("corn");
        validCerealBase.add("oats");
        validCerealBase.add("millet");
        validCerealBase.add("barley");
        validCerealBase.add("rice");
        validCerealBase.add("rye");
        validCerealBase.add("sorghum");

        if(validCerealBase.contains(cerealBase.toLowerCase()))
            this.cerealBase = cerealBase;
        else
            throw new IllegalArgumentException(cerealBase + " is not a member of the valid " +
                    "cereal bases (wheat, maize, corn, oats, millet, barley, rice, rye, sorghum).");
    }

    public boolean isDriedFruit() {
        return driedFruit;
    }

    public void setDriedFruit(boolean driedFruit) {
        this.driedFruit = driedFruit;
    }

    public boolean isNutFree() {
        return nutFree;
    }

    public void setNutFree(boolean nutFree) {
        this.nutFree = nutFree;
    }

    public int getCaloriesPerServing() {
        return caloriesPerServing;
    }

    public void setCaloriesPerServing(int caloriesPerServing) {
        if(caloriesPerServing >= 50)
            this.caloriesPerServing = caloriesPerServing;
        else
            throw new IllegalArgumentException(caloriesPerServing + " must be at least 50 calories.");
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        if(servings >= 1 && servings <= 10)
            this.servings = servings;
        else
            throw new IllegalArgumentException(servings + " must be between 1 and 10.");
    }

    public int getHealthRating() {
        return healthRating;
    }

    public void setHealthRating(int healthRating) {
        if(healthRating >= 0 && healthRating <= 100)
            this.healthRating = healthRating;
        else
            throw new IllegalArgumentException(healthRating + " is not a valid rating. Ratings must be between 0 and 100.");
    }

//    public Image getImg() {
//        return img;
//    }

//    public void setImg(String name) {
//        Image img =
//    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        if(ingredients.size() >= 2)
            this.ingredients = ingredients;
        else
            throw new IllegalArgumentException("There must be a minimum of 2 ingredients.");
    }
}
