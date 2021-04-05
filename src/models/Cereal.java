package models;

import javafx.scene.image.Image;
import java.util.ArrayList;

public class Cereal {
    private String name, brand, cerealBase;
    private boolean driedFruit, nutFree;
    private int caloriesPerServing, servings, healthRating;
    private Image img;
    private ArrayList<String> ingredients;
    private ArrayList<String> validCerealBase;

    public Cereal(String name, String brand, String cerealBase, boolean driedFruit,
                  boolean nutFree, int caloriesPerServing, int servings, int healthRating,
                  Image img, ArrayList<String> ingredients) {
        setValidCerealBase();
        setName(name);
        setBrand(brand);
        setCerealBase(cerealBase);
        setDriedFruit(driedFruit);
        setNutFree(nutFree);
        setCaloriesPerServing(caloriesPerServing);
        setServings(servings);
        setHealthRating(healthRating);
        setImg(img);
        setIngredients(ingredients);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() >= 2)
            this.name = name;
        else
            throw new IllegalArgumentException(name + " must be at least 2 characters long.");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if(brand.length() >= 2)
            this.brand = brand;
        else
            throw new IllegalArgumentException(brand + " must be at least 2 characters long.");
    }

    public String getCerealBase() {
        return cerealBase;
    }

    public void setCerealBase(String cerealBase) {
        if(this.getValidCerealBase().contains(cerealBase.toLowerCase()))
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

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        if(ingredients.size() >= 2)
            this.ingredients = ingredients;
        else
            throw new IllegalArgumentException("There must be a minimum of 2 ingredients.");
    }

    public ArrayList<String> getValidCerealBase() {
        return validCerealBase;
    }

    public void setValidCerealBase() {
        this.validCerealBase.add("wheat");
        this.validCerealBase.add("maize");
        this.validCerealBase.add("corn");
        this.validCerealBase.add("oats");
        this.validCerealBase.add("millet");
        this.validCerealBase.add("barley");
        this.validCerealBase.add("rice");
        this.validCerealBase.add("rye");
        this.validCerealBase.add("sorghum");
    }
}
