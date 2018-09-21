package com.example.alvinafandi.eatiwul;

public class Food {
    String foodId;
    String foodName;
    String foodDescription;
    String foodAddress;
    private Food(){

    }

    public Food(String foodId, String foodName, String foodDescription, String foodAddress) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodDescription = foodDescription;
        this.foodAddress = foodAddress;
    }

    public String getFoodId() {
        return foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public String getFoodAddress() {
        return foodAddress;
    }
}
