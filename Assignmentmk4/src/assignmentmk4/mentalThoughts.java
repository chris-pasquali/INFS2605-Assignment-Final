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
public class mentalThoughts {
    private StringProperty thoughts;
    private StringProperty mentalDate;

    
    public mentalThoughts() {
        this("","");
    }
    
    public mentalThoughts(String thoughts, String mentalDate) {
        this.thoughts = new SimpleStringProperty(thoughts);
        this.mentalDate = new SimpleStringProperty(mentalDate);

    }
    
    public String getThoughts() {
        return thoughts.get();
    }

    public String getMentalDate() {
        return mentalDate.get();
    }

    public StringProperty getThoughtsProperty() {
        return thoughts;
    }

    public void setThoughts(String thoughts) {
        this.thoughts.set(thoughts);
    }
    
    public StringProperty getMentalThoughtsDateProperty() {
        return mentalDate;
    }

    public void setMentalDate(String mentalDate) {
        this.mentalDate.set(mentalDate);
    }
}
