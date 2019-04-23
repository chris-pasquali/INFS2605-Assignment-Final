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
public class AerobicExercise {
    
    private StringProperty aerobicDate;
    private StringProperty aerobicType;
    private StringProperty aerobicDistance;
    private StringProperty aerobicTime;
    
    public AerobicExercise() {
        this("","","","");
    }
    
    public AerobicExercise(String aerobicDate, String aerobicType, String aerobicDistance, String aerobicTime) {
        this.aerobicDate = new SimpleStringProperty(aerobicDate);
        this.aerobicType = new SimpleStringProperty(aerobicType);
        this.aerobicDistance = new SimpleStringProperty(aerobicDistance);
        this.aerobicTime = new SimpleStringProperty(aerobicTime);
    }
    
    public String getAerobicDate() {
        return aerobicDate.get();
    }

    public String getAerobicType() {
        return aerobicType.get();
    }

    public String getAerobicDistance() {
        return aerobicDistance.get();
    }
    
    public String getAerobicTime() {
        return aerobicTime.get();
    }
    
    public StringProperty getAerobicDateProperty() {
        return aerobicDate;
    }

    public void setAerobicDate(String aerobicDate) {
        this.aerobicDate.set(aerobicDate);
    }
    
    public StringProperty getAerobicTypeProperty() {
        return aerobicType;
    }

    public void setAerobicType(String aerobicType) {
        this.aerobicType.set(aerobicType);
    }
    
    public StringProperty getAerobicDistanceProperty() {
        return aerobicDistance;
    }

    public void setAerobicDistance(String aerobicDistance) {
        this.aerobicDistance.set(aerobicDistance);
    }
    
    public StringProperty getAerobicTimeProperty() {
        return aerobicTime;
    }

    public void setAerobicTime(String aerobicTime) {
        this.aerobicTime.set(aerobicTime);
    }
    
    
}
