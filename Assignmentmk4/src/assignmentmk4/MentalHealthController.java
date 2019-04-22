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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Calvin
 */
public class MentalHealthController implements Initializable {

    @FXML
    private TextArea thoughts;
  
    @FXML
    private Button saveThoughts;
    
    @FXML
    private DatePicker dateThoughts;
    
    @FXML
    private NumberAxis minutes;
    
    @FXML
    private CategoryAxis day;
    
    @FXML
    private DatePicker dateExercise;
    
    @FXML
    private Button saveExercise;
    
    @FXML
    private TextField typeExercise;
    
    @FXML
    private TextField minutesExercise;
    
    @FXML
    private BarChart<?, ?> mindfulness;
    
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    Database d = new Database();
    
    @FXML
    private TableView<mentalThoughts> mentalThoughtsList;

    @FXML
    private TableColumn<mentalThoughts, String> mentalThoughtsDateColumn;

    @FXML
    private TableColumn<mentalThoughts, String> mentalThoughtsColumn;
    
    
    @FXML
    private TableView<mentalExercises> mentalExerciseList;

    @FXML
    private TableColumn<mentalExercises, String> mentalExerciseDateColumn;
    
    @FXML
    private TableColumn<mentalExercises, String> mentalExerciseColumn;
    
    @FXML
    private TableColumn<mentalExercises, String> mentalExerciseMinutes;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          // TODO
        XYChart.Series set1 = new XYChart.Series<>();
        
        set1.getData().add(new XYChart.Data("MON",30));
        set1.getData().add(new XYChart.Data("TUES",10));
        set1.getData().add(new XYChart.Data("WED",60));
        set1.getData().add(new XYChart.Data("THURS",50));
        set1.getData().add(new XYChart.Data("FRI",45));
        set1.getData().add(new XYChart.Data("SAT",100));
        set1.getData().add(new XYChart.Data("SUN",120));
        
        mindfulness.getData().addAll(set1);
    }    

    @FXML
    private void saveThoughts(ActionEvent event)throws IOException {
        try{
        Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessFanaticsDB.db");
        String query = "INSERT INTO MentalThoughts (THOUGHTS, DATE) VALUES(?,?)";
        pst = conn.prepareStatement(query);
        
        pst.setString(1, thoughts.getText());
        pst.setString(2, (dateThoughts.getValue().toString()));
        
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


    @FXML
    private void saveExercise(ActionEvent event)throws IOException {
        try{
        Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessFanaticsDB.db");
        String query = "INSERT INTO MentalExercise (TYPE, TIME, DATE) VALUES(?,?,?)";
        pst = conn.prepareStatement(query);

        pst.setString(1, typeExercise.getText());
        pst.setString(2, minutesExercise.getText());
        pst.setString(3, (dateExercise.getValue().toString()));
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Data has been updated!");
        alert.showAndWait();
        
        pst.execute();
        
        pst.close();
        clearFields1();
        
        }catch(Exception e1){
            
         }
    }
    
    public void clearFields(){
        thoughts.clear();
        dateThoughts.setValue(null);
    }
    
    public void clearFields1(){
        typeExercise.clear();
        minutesExercise.clear();
        dateExercise.setValue(null);
    }
    
    @FXML
    public void initialize() {
    mentalThoughtsDateColumn.setCellValueFactory(
            cellData -> cellData.getValue().getMentalThoughtsDateProperty());
    mentalThoughtsColumn.setCellValueFactory(
            cellData -> cellData.getValue().getThoughtsProperty());

    mentalThoughtsList.setItems(this.getMentalThoughtsListData());

    mentalExerciseDateColumn.setCellValueFactory(
            cellData -> cellData.getValue().getExerciseDateProperty());
    mentalExerciseColumn.setCellValueFactory(
            cellData -> cellData.getValue().getExerciseTypeProperty());
    mentalExerciseMinutes.setCellValueFactory(
            cellData -> cellData.getValue().getExerciseTimeProperty());

    mentalExerciseList.setItems(this.getMentalExercisesListData());

    }
        
    private ObservableList<mentalThoughts> getMentalThoughtsListData() {
    List<mentalThoughts> MentalThoughtsListToReturn = new ArrayList<>();
    try {
        ResultSet rs = d.getResultSet("SELECT * FROM MentalThoughts");
//            ResultSet rs = d.getResultSet("SELECT * FROM FoodConsumption ORDER BY FOOD_CATEGORY DESC");
        while(rs.next()) {
            MentalThoughtsListToReturn.add(
                    new mentalThoughts(rs.getString("Thoughts"), rs.getString("Date")));
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    System.out.println(MentalThoughtsListToReturn);
    return FXCollections.observableArrayList(MentalThoughtsListToReturn);

    }
        
    private ObservableList<mentalExercises> getMentalExercisesListData() {
    List<mentalExercises> MentalExercisesListToReturn = new ArrayList<>();
    try {
        ResultSet rs = d.getResultSet("SELECT * FROM MentalExercise");
//            ResultSet rs = d.getResultSet("SELECT * FROM FoodConsumption ORDER BY FOOD_CATEGORY DESC");
        while(rs.next()) {
            MentalExercisesListToReturn.add(
                    new mentalExercises(rs.getString("TYPE"), rs.getString("TIME"), rs.getString("DATE")));
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    System.out.println(MentalExercisesListToReturn);
    return FXCollections.observableArrayList(MentalExercisesListToReturn);

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
