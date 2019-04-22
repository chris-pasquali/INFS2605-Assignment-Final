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
public class MedicalCheckUp {
    private StringProperty profession;
    private StringProperty notes;
    private StringProperty date;

    
    public MedicalCheckUp() {
        this("","","");
    }
    
    public MedicalCheckUp(String profession, String notes, String date) {
        this.profession = new SimpleStringProperty(profession);
        this.notes = new SimpleStringProperty(notes);
        this.date = new SimpleStringProperty(date);

    }
    
    public String getProfession() {
        return profession.get();
    }

    public String getNotes() {
        return notes.get();
    }
    
    public String getDate() {
        return date.get();
    }

    public StringProperty getProfessionProperty() {
        return date;
    }

    public void setProfessionType(String profession) {
        this.profession.set(profession);
    }
    
    public StringProperty getNotesProperty() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }
    
    public StringProperty getDateProperty() {
        return date;
    }

    public void setExerciseDate(String date) {
        this.date.set(date);
    }
    
}
