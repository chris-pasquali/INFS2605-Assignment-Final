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
public class ResistanceExercise {
    private StringProperty resistanceDate;
    private StringProperty resistanceType;
    private StringProperty resistanceTime;
    
    public ResistanceExercise() {
        this("","","");
    }
    
    public ResistanceExercise(String resistanceDate, String resistanceType, String resistanceTime) {
        this.resistanceDate = new SimpleStringProperty(resistanceDate);
        this.resistanceType = new SimpleStringProperty(resistanceType);
        this.resistanceTime = new SimpleStringProperty(resistanceTime);
    }
    
    public String getResistanceDate() {
        return resistanceDate.get();
    }

    public String getResistanceType() {
        return resistanceType.get();
    }
    
    public String getResistanceTime() {
        return resistanceTime.get();
    }
    
    public StringProperty getResistanceDateProperty() {
        return resistanceDate;
    }

    public void setResistanceDate(String resistanceDate) {
        this.resistanceDate.set(resistanceDate);
    }
    
    public StringProperty getResistanceTypeProperty() {
        return resistanceType;
    }

    public void setResistanceType(String resistanceType) {
        this.resistanceType.set(resistanceType);
    }
    
    public StringProperty getResistanceTimeProperty() {
        return resistanceTime;
    }

    public void setResistanceTime(String resistanceTime) {
        this.resistanceTime.set(resistanceTime);
    }
}
