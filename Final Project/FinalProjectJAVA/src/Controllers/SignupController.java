package Controllers;

import Connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import org.apache.commons.lang3.RandomStringUtils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class SignupController {

    @FXML
    public TextField lastName;
    public TextField firstName;
    public TextField email;
    public RadioButton male;
    public RadioButton female;
    public Button signupButton;
    public ToggleGroup gender;
    public PasswordField password;


    public Connection connection;
    public ConnectionClass connectionClass;
    public PreparedStatement pst;

    private String userID;
    private static SignupController instance;


    public SignupController()
    {
        instance = this;
    }

    public static SignupController getInstance()
    {
        return instance;
    }

    public void setUserID(String user)
    {
        userID = user;
    }

    public String getUserID()
    {
        return userID;
    }


    //back to login screen
    @FXML
    public void toLoginEvent(ActionEvent event) throws IOException
    {
        Parent signupDetailsRoot = FXMLLoader.load(getClass().getResource("/resources/main.fxml"));
        Scene signupDetailsScene = new Scene(signupDetailsRoot,600,400);
        Stage signupDetailsStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        signupDetailsStage.setScene(signupDetailsScene);
        signupDetailsStage.show();
    }

    //signup function
    @FXML
    public void toSignupDetailsEvent(ActionEvent event) throws IOException, SQLException {

        String pswd,firstname,lastname,gender,emailad;

        connectionClass = new ConnectionClass();

        //generate user id
        setUserID(generateUserID());

        //get all info from textfields
        pswd = password.getText();
        firstname = firstName.getText();
        lastname = lastName.getText();
        gender = getGender();
        emailad = email.getText();

        //Saving Data to userauth table
        String insert = "INSERT INTO userauth(userid,password,FirstName,LastName,Gender,Email,Balance)"
                + "VALUES (?,?,?,?,?,?,?)";

        connection = connectionClass.getConnection();
        try{
            pst = connection.prepareStatement(insert);
            pst.setString(1,getUserID());
            pst.setString(2,pswd);
            pst.setString(3,firstname);
            pst.setString(4,lastname);
            pst.setString(5,gender);
            pst.setString(6,emailad);
            pst.setInt(7,0); //0 default balance

            pst.executeUpdate();


            //go to signup details page
            Parent signupDetailsRoot = FXMLLoader.load(getClass().getResource("/resources/signup2.fxml"));
            Scene signupDetailsScene = new Scene(signupDetailsRoot,600,400);
            Stage signupDetailsStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            signupDetailsStage.setScene(signupDetailsScene);
            signupDetailsStage.show();

        } catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    //get gender from radio button
    public String getGender()
    {
        String gen ="";
        if(male.isSelected())
        {
            gen = "Male";
        }
        else if(female.isSelected())
        {
            gen = "Female";
        }

        return gen;
    }

    //generate random number user id
    @FXML
    public String generateUserID() throws SQLException {

        connection = connectionClass.getConnection();

        String userid = "";

        ResultSet resultSet;
        do {
            userid = RandomStringUtils.randomNumeric(10);
            String query = "SELECT userid FROM userauth WHERE userid=?";
            PreparedStatement pst1 = connection.prepareStatement(query);
            pst1.setString(1,userid);
            resultSet = pst1.executeQuery();

        }while(resultSet.next());

        return userid;
    }

}
