package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass
{
    public Connection connection;

    public Connection getConnection()
    {
        String dbName="dbatm";
        String userName="root";
        String password="";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/"+dbName,userName,password);

        } catch(Exception e){
            e.printStackTrace();
        }


        return connection;
    }


}
