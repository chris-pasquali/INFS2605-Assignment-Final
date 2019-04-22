/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentmk4;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author chris_pasquali
 */
public class mentalExercises {
    private StringProperty exerciseType;
    private StringProperty exerciseTime;
    private StringProperty exerciseDate;

    
    public mentalExercises() {
        this("","","");
    }
    
    public mentalExercises(String exerciseType, String exerciseTime, String exerciseDate) {
        this.exerciseType = new SimpleStringProperty(exerciseType);
        this.exerciseTime = new SimpleStringProperty(exerciseTime);
        this.exerciseDate = new SimpleStringProperty(exerciseDate);

    }
    
    public String getExerciseType() {
        return exerciseType.get();
    }

    public String getExerciseTime() {
        return exerciseTime.get();
    }
    
    public String getExerciseDate() {
        return exerciseDate.get();
    }

    public StringProperty getExerciseTypeProperty() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType.set(exerciseType);
    }
    
    public StringProperty getExerciseTimeProperty() {
        return exerciseTime;
    }

    public void setExerciseTime(String exerciseTime) {
        this.exerciseTime.set(exerciseTime);
    }
    
    public StringProperty getExerciseDateProperty() {
        return exerciseDate;
    }

    public void setExerciseDate(String exerciseDate) {
        this.exerciseDate.set(exerciseDate);
    }
}
