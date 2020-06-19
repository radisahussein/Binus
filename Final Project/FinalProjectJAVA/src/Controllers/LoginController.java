package Controllers;

import Connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {
    @FXML
    private TextField loginID;
    @FXML
    private PasswordField loginPIN;
    @FXML
    private Label connectionStatus;

    //setter getter

    //set connectionStatus label
    public void setConnectionStatus(String msg)
    {
        connectionStatus.setText(msg);
    }

    //get userID from textfield
    public String getUserID()
    {
        return loginID.getText();
    }

    //get password from textfield
    public String getPassword(){return loginPIN.getText();}


    private static LoginController instance;

    public LoginController()
    {
        instance = this;
    }

    public static LoginController getInstance()
    {
        return instance;
    }


    //function to signup screen
    @FXML
    public void toSignupEvent(ActionEvent event) throws IOException
    {
        Parent signupRoot = FXMLLoader.load(getClass().getResource("/resources/signup.fxml"));
        Scene signupScene = new Scene(signupRoot,600,400);

        Stage signupStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        signupStage.setScene(signupScene);
        signupStage.show();

    }

    //function to main home screen after login
    @FXML
    public void toHomeEvent(ActionEvent event) throws IOException
    {
        Parent homeRoot = FXMLLoader.load(getClass().getResource("/resources/home.fxml"));
        Scene homeScene = new Scene(homeRoot,600,400);

        Stage homeStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        homeStage.setScene(homeScene);
        homeStage.show();
    }

    //function validate login info
    public void loginEvent(ActionEvent actionEvent)
    {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        try {
            Statement statement=connection.createStatement();
            String sql = "SELECT * FROM userauth WHERE userid = '"+getUserID()+"' AND password ='"+getPassword()+"';";
            ResultSet resultSet = statement.executeQuery(sql);

            if(resultSet.next())
            {
                try {
                    toHomeEvent(actionEvent);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            else
            {
                setConnectionStatus("Invalid ID / Password!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
