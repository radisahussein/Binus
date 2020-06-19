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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class WithdrawController implements Initializable {

    @FXML
    private Label statusLabel;
    @FXML
    private Label balanceLabel;
    @FXML
    private TextField withdrawAmt;
    private String transactionID;
    public Connection connection;
    public ConnectionClass connectionClass;
    public PreparedStatement pst;

    //setter getter

    //get withdraw amount from textfield
    public String getWithdrawAmt()
    {
        return withdrawAmt.getText();
    }

    //set balance label
    public void setBalanceLabel(String bal)
    {
        balanceLabel.setText(bal);
    }

    //set status label
    public void setStatusLabel(String msg)
    {
        statusLabel.setText(msg);
    }

    //set transactionID
    public void setTransactionID(String id)
    {
        transactionID = id;
    }

    //get transaction id
    public String getTransactionID()
    {
        return transactionID;
    }


    //init function to load bal
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        //get balance and display label
        connectionClass = new ConnectionClass();
        connection = connectionClass.getConnection();
        ResultSet resultSet;

        String curBal = "";

        String query = "SELECT * from userauth WHERE userid=?";
        try {
            pst = connection.prepareStatement(query);
            pst.setString(1,LoginController.getInstance().getUserID());
            resultSet = pst.executeQuery();
            while(resultSet.next())
            {
                curBal = resultSet.getString("Balance");
            }

            setBalanceLabel(curBal);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //function to go back to home screen
    public void toHomeEvent(ActionEvent event) throws IOException
    {
        LoginController.getInstance().toHomeEvent(event);
    }

    //withdraw function
    public void withdrawEvent(ActionEvent event)
    {

        connectionClass = new ConnectionClass();
        connection = connectionClass.getConnection();


        //getting amount and determining the new balance
        int curBal = 0;
        int withdrawBal = Integer.parseInt(getWithdrawAmt());
        if(withdrawBal > 0)
        {
            try {

                //Get Bal
                curBal = HomeController.getInstance().getBalance(LoginController.getInstance().getUserID());


                if(withdrawBal <= curBal)
                {
                    //update new balance
                    curBal -= withdrawBal;
                    HomeController.getInstance().updateBal(curBal,LoginController.getInstance().getUserID());

                    //create transaction
                    setTransactionID(HomeController.getInstance().generateTransactionID());

                    //insert transaction
                    HomeController.getInstance().insertTransaction(getTransactionID(),
                    		"Withdraw",
                    		LoginController.getInstance().getUserID(),
                    		LoginController.getInstance().getUserID(),
                    		withdrawBal*-1);

                    //go home
                    toHomeEvent(event);
                }

                else {
                    setStatusLabel("Withdraw amount cannot be more than current balance!");
                }


            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }

        }
        else
        {
            setStatusLabel("Withdraw Amount cannot be below 0!");
        }


    }


}
