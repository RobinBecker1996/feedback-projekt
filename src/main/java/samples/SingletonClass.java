package samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.dwcj.App;



public class SingletonClass {
    
    private String url;
    private String username;
    private String password;
    private Connection con;
    private PreparedStatement pstmt;
    ResultSet rs;

    private static SingletonClass instance;
    private SingletonClass() {

    }

    public static SingletonClass getInstance() {
        if(instance == null) {
            instance = new SingletonClass();
        }
        return instance;
    }


    public Connection connect() throws SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            App.consoleLog("con -> " + e.getMessage());
            
        }
        url = "jdbc:mariadb://localhost:3306/Feedbackdb";
        username = "root";
        password = "admin123";
        App.consoleLog("Connection");
        return con = DriverManager.getConnection(url, username, password);
    }

    // public ResultSet readout(String sqlStatment) throws SQLException{
    //     con.prepareStatement()
    // }

    public void closConnection() throws SQLException {
        App.consoleLog("close Connection");
        con.close();
    }
}
