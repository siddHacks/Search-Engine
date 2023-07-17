package com.Accio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static Connection connection = null;
    public static Connection getConnection(){
        if(connection != null){
            return connection;
        }
        String user = "root";
        String pwd = "1234";
        String db = "searchengineapp";
        return getConnection(user,pwd,db);
    }
    private static Connection getConnection(String user,String pwd,String database){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + database + "?user=" + user + "&password=" + pwd);
        }catch(SQLException | ClassNotFoundException sqlException){
            sqlException.printStackTrace();
        }
        return connection;
    }
}
