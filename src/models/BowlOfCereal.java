package models;

import java.util.ArrayList;

public class BowlOfCereal {
    private String milkType;
    private int bowlSize;
    private boolean freshFruit;
    private ArrayList<Cereal> cereals;
    private ArrayList<String> validMilkTypes;

    public BowlOfCereal(String milkType, int bowlSize, boolean freshFruit) {
        setMilkType(milkType);
        setBowlSize(bowlSize);
        setFreshFruit(freshFruit);
    }

    public String getMilkType() {
        return milkType;
    }

    public void setMilkType(String milkType) {
        this.validMilkTypes.add("whole milk");
        this.validMilkTypes.add("skim milk");
        this.validMilkTypes.add("low-fat milk");
        this.validMilkTypes.add("oat milk");
        this.validMilkTypes.add("almond milk");
        milkType = milkType.toLowerCase();

        if(validMilkTypes.contains(milkType))
            this.milkType = milkType;
        else
            throw new IllegalArgumentException(milkType + " is not a valid milk type." +
                    " Our stock is limited to whole milk, skim milk, low-fat milk, oat milk " +
                    "and almond milk.");
    }

    public int getBowlSize() {
        return bowlSize;
    }

    public void setBowlSize(int bowlSize) {
        if(bowlSize >= 1 && bowlSize <= 5)
            this.bowlSize = bowlSize;
        else
            throw new IllegalArgumentException(bowlSize + " is not a valid bowl size. The sizes range from 1 to 5.");
    }

    public boolean isFreshFruit() {
        return freshFruit;
    }

    public void setFreshFruit(boolean freshFruit) {
        this.freshFruit = freshFruit;
    }

    public ArrayList<Cereal> getCereals() {
        return cereals;
    }

    public void setCereals(ArrayList<Cereal> cereals) {
        this.cereals = cereals;
    }

    public void addCereal(Cereal newCereal){
        cereals.add(newCereal);
    }

    public int getTotalCalories(){
        int totalCalories = 0;
        for (Cereal cereal : cereals) {
            int servings = cereal.getServings();
            int calories = cereal.getCaloriesPerServing();
            totalCalories += calories * servings;
        }
        return totalCalories;
    }

    public boolean isNutFreeBowl(){
        for(Cereal cereal : cereals){
            if(!cereal.isNutFree())
                return false;
        }
        return true;
    }

    public int getTotalServings(){
        int totalServings = 0;
        for(Cereal cereal : cereals){
            totalServings += cereal.getServings();
        }
        return totalServings;
    }

//    public String eatCereal(int servingsEaten){
//        int servingsToBeEaten = servingsEaten;
//        int totalServings = getTotalServings();
//        while(totalServings > 0 && servingsEaten > 0){
//            totalServings --;
//            servingsEaten --;
//        }
//        servingsEaten = servingsToBeEaten
//        return String.format("%d servings were eaten");
//    }
}
