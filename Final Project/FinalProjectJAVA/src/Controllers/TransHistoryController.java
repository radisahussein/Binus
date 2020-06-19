package Controllers;

import Connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TransHistoryController implements Initializable {

    @FXML
    private TableView<ModelTable> tableView;
    @FXML
    private TableColumn<ModelTable,String> TransCol;
    @FXML
    private TableColumn<ModelTable,String> TypeCol;
    @FXML
    private TableColumn<ModelTable,String> ReceiverCol;
    @FXML
    private TableColumn<ModelTable,String> SenderCol;
    @FXML
    private TableColumn<ModelTable,String> AmountCol;

    public Connection connection;
    public PreparedStatement pst;
    public ConnectionClass connectionClass;


    ObservableList<ModelTable> obList = FXCollections.observableArrayList();

    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        connectionClass = new ConnectionClass();
        connection = connectionClass.getConnection();

        String execute = "SELECT * FROM transactions WHERE senderid = ? OR receiverid = ?";
        try {
            pst = connection.prepareStatement(execute);
            pst.setString(1,LoginController.getInstance().getUserID());
            pst.setString(2,LoginController.getInstance().getUserID());

            ResultSet rs = pst.executeQuery();

            while(rs.next())
            {
                obList.add(new ModelTable(rs.getString("transactionid"),
                        rs.getString("type"),
                        rs.getString("receiverID"),
                        rs.getString("senderID"),
                        rs.getString("amount")));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        TransCol.setCellValueFactory(new PropertyValueFactory<>("transID"));
        TypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        ReceiverCol.setCellValueFactory(new PropertyValueFactory<>("receiverID"));
        SenderCol.setCellValueFactory(new PropertyValueFactory<>("senderID"));
        AmountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));

        tableView.setItems(obList);
    }



    public void toHomeEvent(ActionEvent event) throws IOException
    {
        Parent homeRoot = FXMLLoader.load(getClass().getResource("/resources/home.fxml"));
        Scene homeScene = new Scene(homeRoot,600,400);

        Stage homeStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        homeStage.setScene(homeScene);
        homeStage.show();
    }
}
