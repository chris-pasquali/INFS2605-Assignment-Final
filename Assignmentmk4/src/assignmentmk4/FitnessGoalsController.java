/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentmk4;


import assignmentmk4.*;
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
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Calvin
 */
public class FitnessGoalsController implements Initializable {

    @FXML
    private TextField bmi;
    @FXML
    private TextField steps;
    @FXML
    private TextField flights;
    @FXML
    private TextField ratio;
    @FXML
    private TextField heartRate;
    @FXML
    private TextField sleep;
    
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Initializes the controller class.
     */
    
    @FXML
    //Change DashBoard to FoodEntry Page
    private void returnHome(ActionEvent event) throws IOException {
        Parent FoodEntryParent = FXMLLoader.load(getClass().getResource("FitnessDashboard.fxml"));
        Scene FoodEntryScene = new Scene(FoodEntryParent);
        //This gets Stage Info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(FoodEntryScene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveGoals(ActionEvent event) throws IOException {
         try{
        Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessFanaticsDB.db");
//        String query = "UPDATE UserGoals1 SET (BMI, RATIO, STEPS, FLIGHTS, HEARTRATE, SLEEP) VALUES(?,?,?,?,?,?)";
        String query = "UPDATE UserGoals2 SET BMI=?, RATIO=?, STEPS=?, FLIGHTS=?, HEARTRATE=?, SLEEP=?";
        pst = conn.prepareStatement(query);
 
        pst.setString(1, bmi.getText());
        pst.setString(2, ratio.getText());
        pst.setString(3, steps.getText());
        pst.setString(4, flights.getText());
        pst.setString(5, heartRate.getText());
        pst.setString(6, sleep.getText());
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Data has been updated!");
        alert.showAndWait();
                
        pst.execute();
        clearFields();
        pst.close();
        
        
        }catch(Exception e){
            System.out.println("Error adding goals " + e);
        }
    
    }
    
    public void clearFields(){
        bmi.clear();
        ratio.clear();
        steps.clear();
        flights.clear();
        heartRate.clear();
        sleep.clear();
    }
}

