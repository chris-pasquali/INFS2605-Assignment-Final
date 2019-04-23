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
public class GymAttendance {
   private StringProperty sessions;
    private StringProperty attendanceDate;

    
    public GymAttendance() {
        this("","");
    }
    
    public GymAttendance(String sessions, String attendanceDate) {
        this.sessions = new SimpleStringProperty(sessions);
        this.attendanceDate = new SimpleStringProperty(attendanceDate);

    }
    
    public String getSessions() {
        return sessions.get();
    }

    public String getAttendanceDate() {
        return attendanceDate.get();
    }

    public StringProperty getSessionsProperty() {
        return sessions;
    }

    public void setSessions(String sessions) {
        this.sessions.set(sessions);
    } 
    
    public StringProperty getAtttendanceDateProperty() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate.set(attendanceDate);
    }
}
