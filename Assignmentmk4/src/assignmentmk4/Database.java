/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentmk4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public static void connect() throws SQLException{
		//write the four lines which connect your program to the database
        Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessFanaticsDB.db");
        Statement st = conn.createStatement();
        String createQuery = "CREATE TABLE IF NOT EXISTS UserData "
                + "(ID INTEGER PRIMARY KEY autoincrement, "
                + "CATEGORY TEXT, "
                + "SUM_NUMBER INTEGER, "
                + "DATE TEXT"
                +");";
        st.execute(createQuery); 
        
//        For FOOD_ID:
//         1 = Vegetables
//         2 = Fruit
//         3 = Dairy
//         4 = Proteins
//         5 = Carbohydrates
        String createFoodQuery = "CREATE TABLE IF NOT EXISTS FoodConsumption1"
                + "(MEAL_TIME TEXT, "
                + "FOOD_CATEGORY TEXT, "
                + "SERVINGS TEXT, "
                + "DATE TEXT"
                +");";
        st.execute(createFoodQuery);
        
        String createAerobicQuery = "CREATE TABLE IF NOT EXISTS AerobicExercise"
                + "(TYPE TEXT,"
                + "DISTANCE TEXT,"
                + "TIME TEXT,"
                + "DATE TEXT"
                +");";
        st.execute(createAerobicQuery);
        
        String createMentalThoughts = "CREATE TABLE IF NOT EXISTS MentalThoughts"
                + "(THOUGHTS TEXT,"
                + "DATE TEXT"
                +");";
        st.execute(createMentalThoughts);
        
        String createMentalExercise = "CREATE TABLE IF NOT EXISTS MentalExercise"
                + "(TYPE TEXT,"
                + "TIME TEXT,"
                + "DATE TEXT"
                +");";
        st.execute(createMentalExercise);
        
        String createCheckUp = "CREATE TABLE IF NOT EXISTS MedicalCheckUp"
                + "(PROFESSION TEXT,"
                + "NOTES TEXT,"
                + "DATE TEXT"
                +");";
        st.execute(createCheckUp);
        
        String createGymAttendance = "CREATE TABLE IF NOT EXISTS GymAttendance"
                + "(SESSIONS TEXT,"
                + "DATE TEXT"
                +");";
        st.execute(createGymAttendance); 
        
        String createUserGoals = "CREATE TABLE IF NOT EXISTS UserGoals1"
                + "(BMI TEXT,"
                + "RATIO TEXT,"
                + "STEPS TEXT,"
                + "FLIGHTS TEXT,"
                + "HEARTRATE TEXT,"
                + "SLEEP TEXT"
                +");";
        st.execute(createUserGoals); 
        
        String createResistanceQuery = "CREATE TABLE IF NOT EXISTS ResistanceExercise"
                + "(TYPE TEXT,"
                + "TIME TEXT,"
                + "DATE TEXT"
                +");";
        st.execute(createResistanceQuery);
            
        st.close();
        conn.close();
	}
	
	public static void insertData() throws SQLException{
            //write the SQL query and the java code to insert all four pets
            Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessFanaticsDB.db");
            Statement st = conn.createStatement();

            String insertSteps = "INSERT OR IGNORE INTO UserData (ID, CATEGORY, SUM_NUMBER, DATE) "
                    + "VALUES (1, 'STEPS', 10000, '2019-04-19');";
            st.execute(insertSteps);
            
            String insertStairs = "INSERT OR IGNORE INTO UserData (ID, CATEGORY, SUM_NUMBER, DATE) "
                    + "VALUES (2, 'STAIRS', 7, '2019-04-19');";
            st.execute(insertStairs);
            
            String insertBMI = "INSERT OR IGNORE INTO UserData (ID, CATEGORY, SUM_NUMBER, DATE) "
                    + "VALUES (3, 'BMI', 26, '2019-04-19');";
            st.execute(insertBMI);
            
            String insertHeartRate = "INSERT OR IGNORE INTO UserData (ID, CATEGORY, SUM_NUMBER, DATE) "
                    + "VALUES (4, 'HEART RATE', 100 , '2019-04-19');";
            st.execute(insertHeartRate);
            
            String insertFatRatio = "INSERT OR IGNORE INTO UserData (ID, CATEGORY, SUM_NUMBER, DATE) "
                    + "VALUES (5, 'FAT RATIO', 25, '2019-04-19');";
            st.execute(insertFatRatio);
            
            String insertSleep = "INSERT OR IGNORE INTO UserData (ID, CATEGORY, SUM_NUMBER, DATE) "
                    + "VALUES (6, 'SLEEP', 8, '2019-04-19');";
            st.execute(insertSleep);
            
            
            String insertSteps1 = "INSERT OR IGNORE INTO UserData (ID, CATEGORY, SUM_NUMBER, DATE) "
                    + "VALUES (1, 'STEPS', 9000, '2019-04-10');";
            st.execute(insertSteps1);
            
            String insertStairs1 = "INSERT OR IGNORE INTO UserData (ID, CATEGORY, SUM_NUMBER, DATE) "
                    + "VALUES (2, 'STAIRS', 9, '2019-04-10');";
            st.execute(insertStairs1);
            
            String insertBMI1 = "INSERT OR IGNORE INTO UserData (ID, CATEGORY, SUM_NUMBER, DATE) "
                    + "VALUES (3, 'BMI', 24, '2019-04-10');";
            st.execute(insertBMI1);
            
            String insertHeartRate1 = "INSERT OR IGNORE INTO UserData (ID, CATEGORY, SUM_NUMBER, DATE) "
                    + "VALUES (4, 'HEART RATE', 85 , '2019-04-10');";
            st.execute(insertHeartRate1);
            
            String insertFatRatio1 = "INSERT OR IGNORE INTO UserData (ID, CATEGORY, SUM_NUMBER, DATE) "
                    + "VALUES (5, 'FAT RATIO', 21, '2019-04-10');";
            st.execute(insertFatRatio1);
            
            String insertSleep1 = "INSERT OR IGNORE INTO UserData (ID, CATEGORY, SUM_NUMBER, DATE) "
                    + "VALUES (6, 'SLEEP', 7.5, '2019-04-10');";
            st.execute(insertSleep1);
            
            
            //Inserting Food Here
            String insertBreakfast = "INSERT OR IGNORE INTO FoodConsumption1 (MEAL_TIME, FOOD_CATEGORY, SERVINGS, DATE) "
                    + "VALUES ('Breakfast', 'Fruit', '2','2019-04-19' )";
            st.execute(insertBreakfast);
            
            String insertLunch = "INSERT OR IGNORE INTO FoodConsumption1 (MEAL_TIME, FOOD_CATEGORY, SERVINGS, DATE)"
                    + "VALUES ('Lunch', 'Protein', '1', '2019-04-19' )";
            st.execute(insertLunch);
            
//            String insertGoals = "INSERT OR IGNORE INTO UserGoals1 (BMI, RATIO, STEPS, FLIGHTS, HEARTRATE, SLEEP)"
//                    + "VALUES ('25', '25', '11000', '9', '90', '7')";
//            st.execute(insertGoals);
            st.close();
            conn.close();
        }
        
        public static void getSteps(String date) throws SQLException {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessFanaticsDB.db");
            String getSteps = "SELECT STEPS from UserData where DATE = '" + date + "'"; 
            PreparedStatement st = conn.prepareStatement(getSteps);
            st.setString(1, date);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getString(3));
                String displaySteps = rs.getString(3);
            }
        }
        
        public ResultSet getResultSet(String sqlstatement) throws SQLException {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:fitnessFanaticsDB.db");
            java.sql.Statement statement = conn.createStatement();
            ResultSet RS = statement.executeQuery(sqlstatement);
            return RS;
    }
}
