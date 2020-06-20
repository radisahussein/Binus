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
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Label balLabel;

    public Connection connection;
    public ConnectionClass connectionClass;
    public PreparedStatement pst;

    private static HomeController instance;

    public HomeController()
    {
        instance = this;
    }

    public static HomeController getInstance()
    {
        return instance;
    }

    //init function to load bal
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        	connectionClass = new ConnectionClass();
        	connection = connectionClass.getConnection();
        	ResultSet resultSet;



        try {
            String query = "SELECT * from userauth WHERE userid=?";
            pst = connection.prepareStatement(query);
            pst.setString(1,LoginController.getInstance().getUserID());
            resultSet = pst.executeQuery();
            while(resultSet.next())
            {
                balLabel.setText(resultSet.getString("Balance"));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //setter getter

    //Set balance label
    public void setBalance(String bal)
    {
        this.balLabel.setText(bal);
    }

    //get balance of userid
    public int getBalance(String id){

        int curBal = 0;
        ResultSet resultSet;

        //get balance
        String query = "SELECT * from userauth WHERE userid=?";
        try {
            pst = connection.prepareStatement(query);
            pst.setString(1,id);
            resultSet = pst.executeQuery();
            while(resultSet.next())
            {
                curBal = resultSet.getInt("Balance");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return curBal;

    }


    //quit function to Login
    @FXML
    public void toLoginEvent(ActionEvent event) throws IOException
    {
        Parent loginRoot = FXMLLoader.load(getClass().getResource("/resources/main.fxml"));
        Scene loginScene = new Scene(loginRoot,600,400);

        Stage loginStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        loginStage.setScene(loginScene);
        loginStage.show();
    }

    //function to deposit screen
    public void toDepositEvent(ActionEvent event) throws IOException
    {
        Parent depositRoot = FXMLLoader.load(getClass().getResource("/resources/deposit.fxml"));
        Scene depositScene = new Scene(depositRoot,600,400);

        Stage depositStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        depositStage.setScene(depositScene);
        depositStage.show();
    }

    //function to withdraw screen
    public void toWithdrawEvent(ActionEvent event) throws IOException
    {
        Parent withdrawRoot = FXMLLoader.load(getClass().getResource("/resources/withdraw.fxml"));
        Scene withdrawScene = new Scene(withdrawRoot,600,400);

        Stage withdrawStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        withdrawStage.setScene(withdrawScene);
        withdrawStage.show();

    }

    //function to transaction history screen
    public void toTransHistoryEvent(ActionEvent event) throws IOException
    {
        Parent transRoot = FXMLLoader.load(getClass().getResource("/resources/transHistory.fxml"));
        Scene transScene = new Scene(transRoot,600,400);

        Stage transStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        transStage.setScene(transScene);
        transStage.show();
    }

    //function to transfer screen
    public void toTransferEvent(ActionEvent event) throws IOException {
        Parent transRoot = FXMLLoader.load(getClass().getResource("/resources/transfer.fxml"));
        Scene transScene = new Scene(transRoot,600,400);

        Stage transStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        transStage.setScene(transScene);
        transStage.show();
    }

    //random number generator for transaction ID
    public String generateTransactionID() throws SQLException
    {
        connection = connectionClass.getConnection();

        String transactionID = "";

        ResultSet resultSet;
        do {
            transactionID = RandomStringUtils.randomNumeric(10);
            String query = "SELECT transactionid FROM transactions WHERE transactionid=?";
            PreparedStatement pst1 = connection.prepareStatement(query);
            pst1.setString(1,transactionID);
            resultSet = pst1.executeQuery();

        }while(resultSet.next());

        return transactionID;

    }

    //database insertion for transaction
    public void insertTransaction(String transID, String type, String senderID, String receiverID, int bal) throws SQLException {
        String insert = "INSERT INTO transactions(transactionid,Type,senderid,receiverid,amount)"
                + "VALUES (?,?,?,?,?)";
        connection = connectionClass.getConnection();
        pst = connection.prepareStatement(insert);
        pst.setString(1,transID);
        pst.setString(2,type);
        pst.setString(3,senderID);
        pst.setString(4,receiverID);
        pst.setInt(5,bal);

        pst.executeUpdate();
    }

    //update bal function
    public void updateBal(int curBal, String id) throws SQLException {
        String update = "UPDATE userauth SET Balance = ? WHERE userid = ?";
        pst = connection.prepareStatement(update);
        pst.setInt(1,curBal);
        pst.setString(2,id);
        pst.executeUpdate();
    }

}
