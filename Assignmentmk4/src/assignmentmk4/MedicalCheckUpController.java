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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chris_pasquali
 */
public class MedicalCheckUpController implements Initializable {
@FXML
    private TextField professionCheckUp;
    @FXML
    private TextArea notesCheckUp;
    @FXML
    private DatePicker dateCheckUp;
    @FXML
    private Button saveCheckUp;
    
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }  
    
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
    
    public void clearFields(){
        professionCheckUp.clear();
        notesCheckUp.clear();
        dateCheckUp.setValue(null);
    }

    @FXML
    private void saveCheckUp(ActionEvent event) throws IOException {
         try{
        Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessFanaticsDB.db");
        String query = "INSERT INTO MedicalCheckUp (PROFESSION, NOTES, DATE) VALUES(?,?,?)";
        pst = conn.prepareStatement(query);
        
        pst = conn.prepareStatement(query);
        
        pst.setString(1, professionCheckUp.getText());
        pst.setString(2, notesCheckUp.getText());
        pst.setString(3, (dateCheckUp.getValue().toString()));
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Data has been updated!");
        alert.showAndWait();
        
        pst.execute();
        
        pst.close();
        clearFields();
        
        }catch(Exception e1){
            
         }
    }
    
}
