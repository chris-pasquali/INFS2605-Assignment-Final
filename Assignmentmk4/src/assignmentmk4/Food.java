/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentmk4;

//import javafx.beans.property.IntegerProperty;
//import javafx.beans.property.SimpleIntegerProperty;

import assignmentmk4.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author chris_pasquali
 */
public class Food {
    
//    private StringProperty foodID;
    private StringProperty mealTime;
    private StringProperty foodCategory;
    private StringProperty servings;
    private StringProperty foodItem;
    private StringProperty date;
    
    public Food() {
        this("","","","","");
    }

    public Food(String mealTime, String foodCategory, String servings, String foodItem, String date) {
        this.mealTime = new SimpleStringProperty(mealTime);
        this.foodCategory = new SimpleStringProperty(foodCategory);
        this.servings = new SimpleStringProperty(servings);
        this.foodItem = new SimpleStringProperty(foodItem);
        this.date = new SimpleStringProperty(date);
    }

    public String getMealTime() {
        return mealTime.get();
    }

    public String getFoodCategory() {
        return foodCategory.get();
    }

    public String getServings() {
        return servings.get();
    }
    
    public String getFoodItem() {
        return foodItem.get();
    }
    
    public String getDate() {
        return date.get();
    }

    public StringProperty getMealTimeProperty() {
        return mealTime;
    }

    public void setMealTime(String mealTime) {
        this.mealTime.set(mealTime);
    }

    public StringProperty getFoodCategoryProperty() {
        return foodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        this.foodCategory.set(foodCategory);
    }

    public StringProperty getServingsProperty() {
        return servings;
    }

    public void setServings(String servings) {
        this.servings.set(servings);
    }
    
    public StringProperty getFoodItemProperty() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem.set(foodItem);
    }
    
    public StringProperty getDateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    } 
}
