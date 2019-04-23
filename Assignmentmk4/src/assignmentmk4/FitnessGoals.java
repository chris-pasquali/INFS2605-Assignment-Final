/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentmk4;


import assignmentmk4.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author chris_pasquali
 */
public class FitnessGoals {
    private StringProperty bmiGoals;
    private StringProperty ratioGoals;
    private StringProperty stepsGoals;
    private StringProperty flightsGoals;
    private StringProperty heartRateGoals;
    private StringProperty sleepGoals;

    
    public FitnessGoals() {
        this("","","","","","");
    }
    
    public FitnessGoals(String bmiGoals, String ratioGoals, String stepsGoals, String flightsGoals, String heartRateGoals, String sleepGoals) {
        this.bmiGoals = new SimpleStringProperty(bmiGoals);
        this.ratioGoals = new SimpleStringProperty(ratioGoals);
        this.stepsGoals = new SimpleStringProperty(stepsGoals);
        this.flightsGoals = new SimpleStringProperty(flightsGoals);
        this.heartRateGoals = new SimpleStringProperty(heartRateGoals);
        this.sleepGoals = new SimpleStringProperty(sleepGoals);

    }
    
    public String getBmiGoals() {
        return bmiGoals.get();
    }

    public String getRatioGoals() {
        return ratioGoals.get();
    }
    
    public String getStepsGoals() {
        return stepsGoals.get();
    }
    
    public String getFlightsGoals() {
        return flightsGoals.get();
    }
    
    public String getHeartRateGoals() {
        return heartRateGoals.get();
    }    
    
    public String getSleepGoals() {
        return sleepGoals.get();
    }

    public StringProperty getBmiGoalsProperty() {
        return bmiGoals;
    }

    public void setBmiGoals(String bmiGoals) {
        this.bmiGoals.set(bmiGoals);
    }
    
    public StringProperty getRatioGoalsProperty() {
        return ratioGoals;
    }

    public void setRatioGoals(String ratioGoals) {
        this.ratioGoals.set(ratioGoals);
    }
    
    public StringProperty getStepsGoalsProperty() {
        return bmiGoals;
    }

    public void setStepsGoals(String stepsGoals) {
        this.stepsGoals.set(stepsGoals);
    }
    
    public StringProperty getFlightsGoalsProperty() {
        return flightsGoals;
    }

    public void setFlightsGoals(String flightsGoals) {
        this.flightsGoals.set(flightsGoals);
    }
    
    public StringProperty getHeartRateGoalsProperty() {
        return heartRateGoals;
    }

    public void setHeartRateGoals(String heartRateGoals) {
        this.heartRateGoals.set(heartRateGoals);
    }
    
    public StringProperty getSleepGoalsProperty() {
        return sleepGoals;
    }

    public void setSleepGoals(String sleepGoals) {
        this.sleepGoals.set(sleepGoals);
    }
}
