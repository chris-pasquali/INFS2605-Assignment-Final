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
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
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
 * @author chris_pasquali
 */
public class ResistanceExerciseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField type;
    @FXML
    private TextField time;
    @FXML
    private DatePicker date;
    @FXML
    private BarChart<?, ?> BenchPress;
    @FXML
    private BarChart<?, ?> LegPress;
    @FXML
    private BarChart<?, ?> DeadLift;
    @FXML
    private CategoryAxis BenchPressx;
    @FXML
    private NumberAxis BenchPressy;
    @FXML
    private CategoryAxis LegPressx;
    @FXML
    private NumberAxis LegPressy;
    @FXML
    private CategoryAxis DeadLiftx;
    @FXML
    private NumberAxis DeadLifty;
    
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series set1 = new XYChart.Series<>();
        
        set1.getData().add(new XYChart.Data("JAN",50));
        set1.getData().add(new XYChart.Data("FEB",32));
        set1.getData().add(new XYChart.Data("MAR",25));
        set1.getData().add(new XYChart.Data("APR",34));
        set1.getData().add(new XYChart.Data("MAY",31));
        set1.getData().add(new XYChart.Data("JUN",45));
        set1.getData().add(new XYChart.Data("JUL",76));
        set1.getData().add(new XYChart.Data("AUG",87));
        set1.getData().add(new XYChart.Data("SEP",20));
        set1.getData().add(new XYChart.Data("OCT",62));
        set1.getData().add(new XYChart.Data("NOV",12));
        set1.getData().add(new XYChart.Data("DEC",34));
     
        
        BenchPress.getData().addAll(set1);
        
        XYChart.Series set2 = new XYChart.Series<>();
        
        set2.getData().add(new XYChart.Data("JAN",40));
        set2.getData().add(new XYChart.Data("FEB",22));
        set2.getData().add(new XYChart.Data("MAR",35));
        set2.getData().add(new XYChart.Data("APR",44));
        set2.getData().add(new XYChart.Data("MAY",51));
        set2.getData().add(new XYChart.Data("JUN",25));
        set2.getData().add(new XYChart.Data("JUL",66));
        set2.getData().add(new XYChart.Data("AUG",77));
        set2.getData().add(new XYChart.Data("SEP",50));
        set2.getData().add(new XYChart.Data("OCT",42));
        set2.getData().add(new XYChart.Data("NOV",22));
        set2.getData().add(new XYChart.Data("DEC",14));
     
        
        LegPress.getData().addAll(set2);
        
        XYChart.Series set3 = new XYChart.Series<>();
        
        set3.getData().add(new XYChart.Data("JAN",43));
        set3.getData().add(new XYChart.Data("FEB",39));
        set3.getData().add(new XYChart.Data("MAR",55));
        set3.getData().add(new XYChart.Data("APR",14));
        set3.getData().add(new XYChart.Data("MAY",91));
        set3.getData().add(new XYChart.Data("JUN",95));
        set3.getData().add(new XYChart.Data("JUL",86));
        set3.getData().add(new XYChart.Data("AUG",37));
        set3.getData().add(new XYChart.Data("SEP",60));
        set3.getData().add(new XYChart.Data("OCT",12));
        set3.getData().add(new XYChart.Data("NOV",52));
        set3.getData().add(new XYChart.Data("DEC",44));
     
        
        DeadLift.getData().addAll(set3);
    }    
    
    @FXML
    private void saveResistanceExercise(ActionEvent event) throws SQLException {
        try{
        Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessFanaticsDB.db");
        String query = "INSERT INTO ResistanceExercise (TYPE, TIME, DATE) VALUES(?,?,?)";
        pst = conn.prepareStatement(query);
        
        pst = conn.prepareStatement(query);
        
        pst.setString(1, type.getText());
        pst.setString(2, time.getText());
        pst.setString(3, (date.getValue().toString()));
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Data has been updated!");
        alert.showAndWait();
        
        pst.execute();
        
        pst.close();
        clearFields2();
        
        }catch(Exception e1){
            
        }
    }
    
    //ClearFields Method
    public void clearFields2(){
        type.clear();
        time.clear();
        date.setValue(null);
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
