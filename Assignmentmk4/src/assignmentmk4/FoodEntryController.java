/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentmk4;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class FoodEntryController implements Initializable {
    
    //List is for category choicebox
    //Lis1 is for meals choicebox
    ObservableList list = FXCollections.observableArrayList();
    ObservableList list1 = FXCollections.observableArrayList();
    
    @FXML
    private Text mealTxt;
    
    @FXML
    private TextField meals;
    
    @FXML
    private Text categoryTxt;
    
    @FXML
    private ChoiceBox<String> categories;
    
    @FXML
    private Text servingsTxt;
    
    @FXML
    private TextField servings;
    
    @FXML 
    private DatePicker foodDatePicker;
    
    @FXML
    private ChoiceBox<String> mealCB;  
    
    @FXML
    private Text heading;
    
    @FXML
    private Label Result;
    
    @FXML
    private Text food;
    
    @FXML TextField foodItem;
    
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    @FXML
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
        loadData();

    }    
    
    @FXML
    //insert new food
    private void saveFoodEntry(ActionEvent event) throws SQLException {
        
        
        String date = foodDatePicker.getValue().toString();
        String mealSelected = mealCB.getValue();
        String categorySelected = categories.getValue();
        String foodItemSelected = foodItem.getText();
        String servingsSelected = servings.getText();
        int servingsAmount = Integer.parseInt(servingsSelected);
        
        System.out.println(date);
        System.out.println(mealSelected);
        System.out.println(categorySelected);
        System.out.println(foodItemSelected);
        System.out.println(servingsAmount);
    
        try {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessFanaticsDB.db");
        String query = "INSERT INTO FoodConsumption1 (MEAL_TIME, FOOD_CATEGORY, SERVINGS, FOOD_ITEM, DATE) VALUES(?,?,?,?,?)";
        pst = conn.prepareStatement(query);
        
        pst = conn.prepareStatement(query);
        
        pst.setString(1, mealCB.getValue());
        pst.setString(2, categories.getValue());
        pst.setString(3, servings.getText());
        pst.setString(4, foodItem.getText());
        pst.setString(5, (foodDatePicker.getValue().toString()));
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Data has been updated!");
        alert.showAndWait();
        
        pst.execute();
        pst.close();
        
        clearFields(); 
        System.out.println("Food Consumption has been added!");
        
        }catch(Exception e1){
            System.out.println("Error occured with adding Food Consumption" + e1);
        }        
    }
    
    private void loadData() {
        list.removeAll(list);
        String a = "Vegetables";
        String b = "Fruit";
        String c = "Dairy";
        String d = "Protein";
        String e = "Carbohydrates";
        list.addAll(a,b,c,d,e);
        categories.getItems().addAll(list);
        
        list1.removeAll(list1);
        String meal1 = "Breakfast";
        String meal2 = "Lunch";
        String meal3 = "Dinner";
        list1.addAll(meal1, meal2, meal3);
        mealCB.getItems().addAll(list1);
    }  
    
      public void clearFields(){
        mealCB.setValue(null);
        categories.setValue(null);
        servings.clear();
        foodItem.clear();
        foodDatePicker.setValue(null);
    }
}