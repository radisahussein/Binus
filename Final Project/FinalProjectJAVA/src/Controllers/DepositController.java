package Controllers;

import Connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.ResourceBundle;


public class DepositController implements Initializable{

    public Connection connection;
    public ConnectionClass connectionClass;
    private String transactionID;

    @FXML
    private Label balanceLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private TextField depositInput;

    //init function to load bal
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        //get balance and display label
        try {
            int curBal = HomeController.getInstance().getBalance(LoginController.getInstance().getUserID());
            setBalanceLabel(Integer.toString(curBal));


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    //setter getters

    //get deposit amt from textfield
    public String getDepositAmt()
    {
        return depositInput.getText();
    }

    //set status label
    public void setStatusLabel(String label)
    {
        statusLabel.setText(label);
    }

    //set transaction id
    public void setTransactionID(String id)
    {
        transactionID = id;
    }

    //get transaction id
    public String getTransactionID()
    {
        return transactionID;
    }

    //set bal label
    public void setBalanceLabel(String text)
    {
        balanceLabel.setText(text);
    }

    //deposit function
    @FXML
    public void depositEvent(ActionEvent event)
    {
        connectionClass = new ConnectionClass();
        connection = connectionClass.getConnection();

        //getting amount and determining the new balance
        int curBal = 0;
        int depositBal = Integer.parseInt(getDepositAmt());
        if(depositBal > 0)
        {
            try {
                //get balance
                curBal = HomeController.getInstance().getBalance(LoginController.getInstance().getUserID());

                //update new balance
                curBal += depositBal;
                HomeController.getInstance().updateBal(curBal,LoginController.getInstance().getUserID());

                //create transaction
                setTransactionID(HomeController.getInstance().generateTransactionID());

                //insert transaction
                HomeController.getInstance().insertTransaction(getTransactionID(),
                		"Deposit",LoginController.getInstance().getUserID(),
                		LoginController.getInstance().getUserID(),
                		depositBal);


                toHomeEvent(event);

            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }

        }
        else
        {
            setStatusLabel("Deposit Amount cannot be below 0!");
        }

    }

    //back to home screen event
    public void toHomeEvent(ActionEvent event) throws IOException {
        LoginController.getInstance().toHomeEvent(event);
    }

}



