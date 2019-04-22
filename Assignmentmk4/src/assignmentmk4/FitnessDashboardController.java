/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentmk4;

import assignmentmk4.Database;
import assignmentmk4.Food;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chrispasquali
 */
//public class FitnessDashboardController implements Initializable {
public class FitnessDashboardController  {
    
    @FXML
    private Label stepsTxt;
    
    @FXML
    private Label stairs;
    
    @FXML
    private Label BMI;
    
    @FXML
    private Label heartRate;
    
    @FXML
    private Label fatRatio;
    
    @FXML
    private Label sleep;
    
    @FXML
    private Label stepGoals;
    
    @FXML
    private Label stairsGoals;
    
    @FXML
    private Label bmiGoals;
    
    @FXML
    private Label heartRateGoal;
    
    @FXML
    private Label fatRatioGoals;
    
    @FXML
    private Label sleepGoals;
    
    @FXML
    private DatePicker datePicker;
    
    @FXML
    private TableView<Food> foodList;

    @FXML
    private TableColumn<Food, String> mealTimeColumn;

    @FXML
    private TableColumn<Food, String> foodCategoryColumn;

    @FXML
    private TableColumn<Food, String> servingsColumn;
    
    @FXML
    private TableColumn<Food, String> dateColumn;
    
    @FXML
    private TableColumn<Food, String> foodItemColumn;
    
    
    
    @FXML
    private TableView<AerobicExercise> aerobicExerciseList;

    @FXML
    private TableColumn<AerobicExercise, String> aerobicDateColumn;

    @FXML
    private TableColumn<AerobicExercise, String> aerobicTypeColumn;

    @FXML
    private TableColumn<AerobicExercise, String> aerobicDistanceColumn;
    
    @FXML
    private TableColumn<AerobicExercise, String> aerobicTimeColumn;
    
    
    @FXML
    private TableView<FitnessGoals> fitnessGoalsList;

    @FXML
    private TableColumn<FitnessGoals, String> stepsGoalsColumn;

    @FXML
    private TableColumn<FitnessGoals, String> flightsGoalsColumn;

    @FXML
    private TableColumn<FitnessGoals, String> bmiGoalsColumn;
    
    @FXML
    private TableColumn<FitnessGoals, String> heartRateGoalsColumn;
    
    @FXML
    private TableColumn<FitnessGoals, String> fatRatioGoalsColumn;

    @FXML
    private TableColumn<FitnessGoals, String> sleepGoalsColumn;
    
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
    
    @FXML
    private TableView<MedicalCheckUp> medicalCheckUpList;

    @FXML
    private TableColumn<MedicalCheckUp, String> medicalCheckUpDateColumn;

    @FXML
    private TableColumn<MedicalCheckUp, String> medicalProfessionColumn;
    
    @FXML
    private TableColumn<MedicalCheckUp, String> medicalNotesColumn;
    
    @FXML
    private TableView<ResistanceExercise> resistanceExerciseList;

    @FXML
    private TableColumn<ResistanceExercise, String> resistanceDateColumn;

    @FXML
    private TableColumn<ResistanceExercise, String> resistanceTypeColumn;
    
    @FXML
    private TableColumn<ResistanceExercise, String> resistanceTimeColumn;
    
    @FXML
    private TableView<GymAttendance> gymAttendanceList;

    @FXML
    private TableColumn<GymAttendance, String> attendanceDateColumn;
    
    @FXML
    private TableColumn<GymAttendance, String> attendanceSessionsColumn;
    
    Database d = new Database();
    
    
    @FXML
    public void datePicker (ActionEvent actionEvent) throws SQLException {
        String date = datePicker.getValue().toString();
        Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessFanaticsDB.db");
        //System.out.println(date);
            
        try {
//          String getSteps = "SELECT * from UserData where ID = 1 AND DATE ="+ datePicker.getValue().toString();
            String getSteps = "SELECT * from UserData where ID = 1";
            String getStairs = "SELECT * from UserData where ID = 2";
            String getBMI = "SELECT * from UserData where ID = 3";
            String getHeartRate = "SELECT * from UserData where ID = 4";
            String getFatRatio = "SELECT * from UserData where ID = 5";
            String getSleep = "SELECT * from UserData where ID = 6";
            
            String getStepGoals = "SELECT STEPS from UserGoals1";
            String getStairGoals = "SELECT FLIGHTS from UserGoals1";
            String getBMIGoals = "SELECT BMI from UserGoals1";
            String getHeartRateGoals = "SELECT HEARTRATE from UserGoals1";
            String getSleepGoals = "SELECT SLEEP from UserGoals1";
            String getFatRatioGoals = "SELECT RATIO from UserGoals1";
            
            PreparedStatement st = conn.prepareStatement(getSteps);
            PreparedStatement st1 = conn.prepareStatement(getStairs);
            PreparedStatement st2 = conn.prepareStatement(getBMI);
            PreparedStatement st3 = conn.prepareStatement(getHeartRate);
            PreparedStatement st4 = conn.prepareStatement(getFatRatio);
            PreparedStatement st5 = conn.prepareStatement(getSleep);
            
            //Retrieving goals from DB
            PreparedStatement st6 = conn.prepareStatement(getStepGoals);
            PreparedStatement st7 = conn.prepareStatement(getStairGoals);
            PreparedStatement st8 = conn.prepareStatement(getBMIGoals);
            PreparedStatement st9 = conn.prepareStatement(getHeartRateGoals);
            PreparedStatement st10 = conn.prepareStatement(getSleepGoals);
            PreparedStatement st11 = conn.prepareStatement(getFatRatioGoals);
            
//            st.setString(3, date);
            ResultSet rs = st.executeQuery();
            ResultSet rs1 = st1.executeQuery();
            ResultSet rs2 = st2.executeQuery();
            ResultSet rs3 = st3.executeQuery();
            ResultSet rs4 = st4.executeQuery();
            ResultSet rs5 = st5.executeQuery();
            
            ResultSet rs6 = st6.executeQuery();
            ResultSet rs7 = st7.executeQuery();
            ResultSet rs8 = st8.executeQuery();
            ResultSet rs9 = st9.executeQuery();
            ResultSet rs10 = st10.executeQuery();
            ResultSet rs11 = st11.executeQuery();
            
            while(rs.next()) {
                    System.out.println(rs.getString(3));
                    String displaySteps = rs.getString(3);
                    stepsTxt.setText(displaySteps);
                    
                    System.out.println(rs1.getString(3));
                    String displayStairs = rs1.getString(3);
                    stairs.setText(displayStairs);
                    
                    System.out.println(rs2.getString(3));
                    String displayBMI = rs2.getString(3);
                    BMI.setText(displayBMI);
                    
                    System.out.println(rs3.getString(3));
                    String displayHeartRate = rs3.getString(3);
                    heartRate.setText(displayHeartRate);
                    
                    System.out.println(rs4.getString(3));
                    String displayFatRatio = rs4.getString(3);
                    fatRatio.setText(displayFatRatio);
                    
                    System.out.println(rs5.getString(3));
                    String displaySleep = rs5.getString(3);
                    sleep.setText(displaySleep);
                    
                    System.out.println(rs6.getString(1));
                    stepGoals.setText("Goal For Steps: " +rs6.getString(1));
                    stairsGoals.setText("Goal For Flights of Stairs: " + rs7.getString(1));
                    bmiGoals.setText("Goal for BMI " + rs8.getString(1));
                    heartRateGoal.setText("Goal for Heart Rate: " + rs9.getString(1));
                    sleepGoals.setText("Goal for Sleep: " + rs10.getString(1));
                    fatRatioGoals.setText("Goal for Fat Ratio: " + rs11.getString(1));
                    
                    System.out.println(date);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
        @FXML
        public void initialize() {
        mealTimeColumn.setCellValueFactory(
                cellData -> cellData.getValue().getMealTimeProperty());
        foodCategoryColumn.setCellValueFactory(
                cellData -> cellData.getValue().getFoodCategoryProperty());
        servingsColumn.setCellValueFactory(
                cellData -> cellData.getValue().getServingsProperty());
        foodItemColumn.setCellValueFactory(
                cellData -> cellData.getValue().getFoodItemProperty());
        dateColumn.setCellValueFactory(
                cellData -> cellData.getValue().getDateProperty());
        foodList.setItems(this.getFoodListData());
        
        aerobicDateColumn.setCellValueFactory(
                cellData -> cellData.getValue().getAerobicDateProperty());
        aerobicTypeColumn.setCellValueFactory(
                cellData -> cellData.getValue().getAerobicTypeProperty());
        aerobicDistanceColumn.setCellValueFactory(
                cellData -> cellData.getValue().getAerobicDistanceProperty());
        aerobicTimeColumn.setCellValueFactory(
                cellData -> cellData.getValue().getAerobicTimeProperty());
        aerobicExerciseList.setItems(this.getAerobicExerciseListData());
        
        stepsGoalsColumn.setCellValueFactory(
            cellData -> cellData.getValue().getStepsGoalsProperty());
        flightsGoalsColumn.setCellValueFactory(
            cellData -> cellData.getValue().getFlightsGoalsProperty());
        bmiGoalsColumn.setCellValueFactory(
            cellData -> cellData.getValue().getBmiGoalsProperty());
        heartRateGoalsColumn.setCellValueFactory(
            cellData -> cellData.getValue().getHeartRateGoalsProperty());
        fatRatioGoalsColumn.setCellValueFactory(
            cellData -> cellData.getValue().getRatioGoalsProperty());
        sleepGoalsColumn.setCellValueFactory(
            cellData -> cellData.getValue().getSleepGoalsProperty());

        fitnessGoalsList.setItems(this.getFitnessGoalsListData());

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
        
        medicalCheckUpDateColumn.setCellValueFactory(
                cellData -> cellData.getValue().getDateProperty());
        medicalProfessionColumn.setCellValueFactory(
                cellData -> cellData.getValue().getProfessionProperty());
        medicalNotesColumn.setCellValueFactory(
                cellData -> cellData.getValue().getNotesProperty());

        medicalCheckUpList.setItems(this.getCheckUpListData());
        
        resistanceDateColumn.setCellValueFactory(
                cellData -> cellData.getValue().getResistanceDateProperty());
        resistanceTypeColumn.setCellValueFactory(
                cellData -> cellData.getValue().getResistanceTypeProperty());
        resistanceTimeColumn.setCellValueFactory(
                cellData -> cellData.getValue().getResistanceTimeProperty());
        resistanceExerciseList.setItems(this.getResistanceExerciseListData());
        
        attendanceDateColumn.setCellValueFactory(
                cellData -> cellData.getValue().getAtttendanceDateProperty());
        attendanceSessionsColumn.setCellValueFactory(
                cellData -> cellData.getValue().getSessionsProperty());
        gymAttendanceList.setItems(this.getGymAttendanceListData());
        
        }
        
        private ObservableList<Food> getFoodListData() {
        List<Food> foodListToReturn = new ArrayList<>();
        try {
            ResultSet rs = d.getResultSet("SELECT * FROM FoodConsumption1");
//            ResultSet rs = d.getResultSet("SELECT * FROM FoodConsumption ORDER BY FOOD_CATEGORY DESC");
            while(rs.next()) {
                foodListToReturn.add(
                        new Food(rs.getString("MEAL_TIME"), rs.getString("FOOD_CATEGORY"), rs.getString("SERVINGS"), rs.getString("FOOD_ITEM"), rs.getString("DATE")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(foodListToReturn);
        return FXCollections.observableArrayList(foodListToReturn);
        }
        
        private ObservableList<AerobicExercise> getAerobicExerciseListData() {
        List<AerobicExercise> AerobicExerciseListToReturn = new ArrayList<>();
        try {
            ResultSet rs = d.getResultSet("SELECT * FROM AerobicExercise");
//            ResultSet rs = d.getResultSet("SELECT * FROM FoodConsumption ORDER BY FOOD_CATEGORY DESC");
            while(rs.next()) {
                AerobicExerciseListToReturn.add(
                        new AerobicExercise(rs.getString("TYPE"), rs.getString("DISTANCE"), rs.getString("TIME"), rs.getString("DATE")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(AerobicExerciseListToReturn);
        return FXCollections.observableArrayList(AerobicExerciseListToReturn);
        }    
        
        private ObservableList<ResistanceExercise> getResistanceExerciseListData() {
        List<ResistanceExercise> ResistanceExerciseListToReturn = new ArrayList<>();
        try {
            ResultSet rs = d.getResultSet("SELECT * FROM ResistanceExercise");
            while(rs.next()) {
                ResistanceExerciseListToReturn.add(
                        new ResistanceExercise(rs.getString("TYPE"),rs.getString("TIME"), rs.getString("DATE")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(ResistanceExerciseListToReturn);
        return FXCollections.observableArrayList(ResistanceExerciseListToReturn);
        } 
        
        private ObservableList<FitnessGoals> getFitnessGoalsListData() {
        List<FitnessGoals> FitnessGoalsListToReturn = new ArrayList<>();
        try {
            ResultSet rs = d.getResultSet("SELECT * FROM UserGoals1");
//            ResultSet rs = d.getResultSet("SELECT * FROM FoodConsumption ORDER BY FOOD_CATEGORY DESC");
            while(rs.next()) {
                FitnessGoalsListToReturn.add(
                        new FitnessGoals(rs.getString("BMI"), rs.getString("RATIO"), rs.getString("STEPS"), rs.getString("FLIGHTS"), rs.getString("HEARTRATE"), rs.getString("SLEEP")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(FitnessGoalsListToReturn);
        return FXCollections.observableArrayList(FitnessGoalsListToReturn);
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
        
        private ObservableList<MedicalCheckUp> getCheckUpListData() {
        List<MedicalCheckUp> CheckUpListToReturn = new ArrayList<>();
        try {
            ResultSet rs = d.getResultSet("SELECT * FROM MedicalCheckUp");
    //            ResultSet rs = d.getResultSet("SELECT * FROM FoodConsumption ORDER BY FOOD_CATEGORY DESC");
            while(rs.next()) {
                CheckUpListToReturn.add(
                        new MedicalCheckUp(rs.getString("PROFESSION"), rs.getString("NOTES"), rs.getString("DATE")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(CheckUpListToReturn);
        return FXCollections.observableArrayList(CheckUpListToReturn);

        }
        
        private ObservableList<GymAttendance> getGymAttendanceListData() {
        List<GymAttendance> GymAttendanceListToReturn = new ArrayList<>();
        try {
            ResultSet rs = d.getResultSet("SELECT * FROM GymAttendance");
    //            ResultSet rs = d.getResultSet("SELECT * FROM FoodConsumption ORDER BY FOOD_CATEGORY DESC");
            while(rs.next()) {
                GymAttendanceListToReturn.add(
                        new GymAttendance(rs.getString("SESSIONS"),rs.getString("DATE")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(GymAttendanceListToReturn);
        return FXCollections.observableArrayList(GymAttendanceListToReturn);

        }
    
    
        @FXML
        private void updateFoodEntry(ActionEvent event) throws IOException {
            Parent FoodEntryParent = FXMLLoader.load(getClass().getResource("FoodEntry.fxml"));
            Scene FoodEntryScene = new Scene(FoodEntryParent);
            //This gets Stage Info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(FoodEntryScene);
            window.show();  
        }   
        @FXML
        private void updateAerobicEntry(ActionEvent event) throws IOException {
            Parent FoodEntryParent = FXMLLoader.load(getClass().getResource("AerobicExercise.fxml"));
            Scene FoodEntryScene = new Scene(FoodEntryParent);
            //This gets Stage Info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(FoodEntryScene);
            window.show();  
        }    
    
        @FXML
        private void viewMentalHealthEntry(ActionEvent event) throws IOException {
            Parent FoodEntryParent = FXMLLoader.load(getClass().getResource("MentalHealth.fxml"));
            Scene FoodEntryScene = new Scene(FoodEntryParent);
            //This gets Stage Info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(FoodEntryScene);
            window.show();  
        } 

        @FXML
        private void viewHealthCheckUp(ActionEvent event) throws IOException {
            Parent FoodEntryParent = FXMLLoader.load(getClass().getResource("MedicalCheckUp.fxml"));
            Scene FoodEntryScene = new Scene(FoodEntryParent);
            //This gets Stage Info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(FoodEntryScene);
            window.show();  
        } 

        @FXML
        private void viewGoals(ActionEvent event) throws IOException {
            Parent FoodEntryParent = FXMLLoader.load(getClass().getResource("FitnessGoals.fxml"));
            Scene FoodEntryScene = new Scene(FoodEntryParent);
            //This gets Stage Info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(FoodEntryScene);
            window.show();  
        }
        
        @FXML
        private void updateResistanceEntry(ActionEvent event) throws IOException {
            Parent FoodEntryParent = FXMLLoader.load(getClass().getResource("ResistanceExercise.fxml"));
            Scene FoodEntryScene = new Scene(FoodEntryParent);
            //This gets Stage Info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(FoodEntryScene);
            window.show();  
        }
        
        @FXML
        private void updateGymAttendance(ActionEvent event) throws IOException {
            Parent FoodEntryParent = FXMLLoader.load(getClass().getResource("GymAttendance.fxml"));
            Scene FoodEntryScene = new Scene(FoodEntryParent);
            //This gets Stage Info
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(FoodEntryScene);
            window.show();  
        }
    
}
