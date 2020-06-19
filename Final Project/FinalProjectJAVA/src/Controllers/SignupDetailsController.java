package Controllers;


import Connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignupDetailsController implements Initializable {

    @FXML
    private Label IDdetails;
    @FXML
    private Label BalanceDetails;

    public Connection connection;
    public ConnectionClass connectionClass;
    public PreparedStatement pst;


    //init function to load balance
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        connectionClass = new ConnectionClass();
        connection = connectionClass.getConnection();

        IDdetails.setText(SignupController.getInstance().getUserID());

        //get and display balance
        int curBal = 0;

        try {
            curBal = HomeController.getInstance().getBalance(SignupController.getInstance().getUserID());
            BalanceDetails.setText(Integer.toString(curBal));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    //back to login screen
    public void toLoginEvent(ActionEvent event) throws IOException {
        Parent loginRoot = FXMLLoader.load(getClass().getResource("/resources/main.fxml"));
        Scene loginScene = new Scene(loginRoot,600,400);

        Stage loginStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        loginStage.setScene(loginScene);
        loginStage.show();
    }
}


