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

public class TransferController implements Initializable {

    @FXML
    private TextField receiverInput;
    @FXML
    private Label balanceLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private TextField transferInput;

    private String transactionID;
    public Connection connection;
    public ConnectionClass connectionClass;
    public PreparedStatement pst;

    //setter getters
    public void setBalanceLabel(String bal)
    {
        balanceLabel.setText(bal);
    }

    public void setStatusLabel(String msg)
    {
        statusLabel.setText(msg);
    }

    public void setTransactionID(String id)
    {
        transactionID = id;
    }

    public String getTransferAmt()
    {
        return transferInput.getText();
    }

    public String getReceiverID()
    {
        return receiverInput.getText();
    }

    public String getTransactionID()
    {
        return transactionID;
    }


    //init function to load bal
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        //get balance and display label
        int curBal = 0;
        try {
            curBal = HomeController.getInstance().getBalance(LoginController.getInstance().getUserID());
            setBalanceLabel(Integer.toString(curBal));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    //transfer function
    public void transferEvent(ActionEvent event) {
        connectionClass = new ConnectionClass();
        connection = connectionClass.getConnection();

        //getting amount and determining the new balance
        int curSenderBal = 0;
        int curReceiverBal = 0;
        int transferAmt = Integer.parseInt(getTransferAmt());
        String receiverID = getReceiverID();
        if (transferAmt > 0) {
            try {
                //get balance of sender
                curSenderBal = HomeController.getInstance().getBalance(LoginController.getInstance().getUserID());

                //get balance of receiver
                curReceiverBal = HomeController.getInstance().getBalance(receiverID);

                if (transferAmt <= curSenderBal)
                {
                    if (idExists(receiverID))
                    {
                        //update sender new balance
                        curSenderBal -= transferAmt;
                        HomeController.getInstance().updateBal(curSenderBal,LoginController.getInstance().getUserID());

                        //update receiver new balance
                        curReceiverBal += transferAmt;
                        HomeController.getInstance().updateBal(curReceiverBal,receiverID);

                        //create transaction
                        setTransactionID(HomeController.getInstance().generateTransactionID());

                        //Insert Transaction
                        HomeController.getInstance().insertTransaction(getTransactionID(),
                        		"Transfer",LoginController.getInstance().getUserID(),getReceiverID(),transferAmt);

                        //back to home
                        toHomeEvent(event);

                    }
                    else
                    {
                        setStatusLabel("Invalid Account Number!");
                    }
                }
                else
                {
                    setStatusLabel("Transfer amount exceeds balance!");
                }


            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }
        }
        else {
            setStatusLabel("Amount cannot be below zero!");
        }
        }

    //back to home
    public void toHomeEvent(ActionEvent event) throws IOException {
        LoginController.getInstance().toHomeEvent(event);
    }

    //check to see if id exists in database
    public boolean idExists(String id) throws SQLException {

        //get balance and display label
        connectionClass = new ConnectionClass();
        connection = connectionClass.getConnection();
        ResultSet resultSet;

        String query = "SELECT userid FROM userauth WHERE userid=?";
        pst = connection.prepareStatement(query);
        pst.setString(1,id);
        resultSet = pst.executeQuery();

        if (resultSet.next())
        {
            return true;
        }

        return false;

    }

}
