package samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.dwcj.App;

import com.basiscomponents.db.ResultSet;



public class SingletonClass {
    
    String url;
    String username;
    String password;
    Connection con;
    PreparedStatement pstmt;
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
            App.consoleLog("con -> " + e.getMessage());
        }
        url = "jdbc:mariadb://localhost:3306/Feedbackdb";
        username = "root";
        password = "admin123";
        App.consoleLog("Connection");
        return con = DriverManager.getConnection(url, username, password);
    }

    public ResultSet readout(String sqlStatment) throws SQLException{
        rs = new ResultSet();
        pstmt = con.prepareStatement(sqlStatment);
        rs = new ResultSet(pstmt.executeQuery());
        return rs;
    }

    public void update(String sqlStatment) throws SQLException{
        pstmt = con.prepareStatement(sqlStatment);
        pstmt.executeUpdate();
    }

    public void delete(String sqlStatment) throws SQLException{
        pstmt = con.prepareStatement(sqlStatment);
        pstmt.executeQuery();
    }

    public void closConnection() throws SQLException {
        App.consoleLog("close Connection");
        pstmt.close();
        con.close();
    }
}
