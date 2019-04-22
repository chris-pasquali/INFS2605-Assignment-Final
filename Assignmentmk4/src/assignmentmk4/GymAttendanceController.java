/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentmk4;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Calvin
 */
public class GymAttendanceController implements Initializable {

    @FXML
    private LineChart<?, ?> GymAttendance;
    @FXML
    private NumberAxis sessions;
    @FXML
    private CategoryAxis day;
    @FXML
    private TextField sessionsAttendance;
    @FXML
    private DatePicker dateAttendance;
    @FXML
    private Button saveAttendance;
    
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        XYChart.Series set1 = new XYChart.Series<>();
        
        set1.getData().add(new XYChart.Data("MON",1));
        set1.getData().add(new XYChart.Data("TUES",2));
        set1.getData().add(new XYChart.Data("WED",0));
        set1.getData().add(new XYChart.Data("THURS",1));
        set1.getData().add(new XYChart.Data("FRI",0));
        set1.getData().add(new XYChart.Data("SAT",1));
        set1.getData().add(new XYChart.Data("SUN",1));
        
        GymAttendance.getData().addAll(set1);
    }    

    @FXML
    private void saveAttendance(ActionEvent event) throws IOException {
        try{
        Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessFanaticsDB.db");
        String query = "INSERT INTO GymAttendance (SESSIONS, DATE) VALUES(?,?)";
        pst = conn.prepareStatement(query);
        
        pst.setString(1, sessionsAttendance.getText());
        pst.setString(2, (dateAttendance.getValue().toString()));
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Data has been updated!");
        alert.showAndWait();
        
        pst.execute();
        
        pst.close();
        clearFields3();
        
        }catch(Exception e1){
            
         }
    }
    
      public void clearFields3(){
        sessionsAttendance.clear();
        dateAttendance.setValue(null);
    }
      
    @FXML
    private void returnHome(ActionEvent event) throws IOException {
        Parent FoodEntryParent = FXMLLoader.load(getClass().getResource("FitnessDashboard.fxml"));
        Scene FoodEntryScene = new Scene(FoodEntryParent);
        //This gets Stage Info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(FoodEntryScene);
        window.show();
        
    }
    
}
