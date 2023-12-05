package samples;

import java.sql.SQLException;


import org.dwcj.App;

import com.basiscomponents.db.DataRow;

public class Query {

    SingletonClass sing = SingletonClass.getInstance();
    EmployeesPan emp = new EmployeesPan();
    
    String[] colMitarbeiter = {"MitarbeiterID", "Vorname", "Nachname", "Feedback", "Termin", "Ziele", "Schwerpunkt"};

    public void updateEmp(DataRow data) {
        try {
            String sqlStatment = "";
            sqlStatment = "UPDATE mitarbeiter SET Vorname = ?, Nachname = ?, Feedback = ?, Termin = ?, Ziele = ?, Schwerpunkt = ? Where  MitarbeiterID = ?;";
            sing.pstmt = sing.con.prepareStatement(sqlStatment);
            sing.pstmt.setDouble(7, data.getFieldAsNumber("MitarbeiterID")); 
            sing.pstmt.setString(1, data.getFieldAsString("Vorname")); 
            sing.pstmt.setString(2, data.getFieldAsString("Nachname")); 
            sing.pstmt.setString(3, data.getFieldAsString("Feedback")); 
            sing.pstmt.setString(4, data.getFieldAsString("Termin")); 
            sing.pstmt.setString(5, data.getFieldAsString("Ziele")); 
            sing.pstmt.setString(6, data.getFieldAsString("Schwerpunkt")); 

            sing.pstmt.executeUpdate();
        } catch (SQLException e) {
            App.consoleLog("rs Update -> " + e.getMessage());
            App.msgbox("Sie m\u00fcssen alle felder ausf\u00fcllen");
        }
    }


    public void create(DataRow data) {
        try {
            // String sqlInsert = "";
            String sqlInsert = "INSERT INTO mitarbeiter (Vorname, Nachname, feedback)VALUES( ?, ?, ?)";
            sing.pstmt = sing.con.prepareStatement(sqlInsert);
            sing.pstmt.setString(1, data.getFieldAsString("Vorname"));
            sing.pstmt.setString(2, data.getFieldAsString("Nachname"));
            sing.pstmt.setString(3, data.getFieldAsString("Feedback"));

          
                
            sing.pstmt.executeUpdate();
        } catch (SQLException e) {
            App.consoleLog("new Create -> "  + e.getMessage());
            App.msgbox("Sie m\u00fcssen alle felder ausf\u00fcllen");
        }
    }

       public void createAC(DataRow dataAC) {
        try {
            String sqlInsertAcount = "INSERT INTO account (Vorname, Nachname, Passwort, Email, Freigabe)VALUES(?, ?, ?, ?, ?)";         
            sing.pstmt = sing.con.prepareStatement(sqlInsertAcount);
            sing.pstmt.setString(1, dataAC.getFieldAsString("Vorname"));
            sing.pstmt.setString(2, dataAC.getFieldAsString("Nachname"));
            sing.pstmt.setString(3, dataAC.getFieldAsString("Passwort"));
            sing.pstmt.setString(4, dataAC.getFieldAsString("Email"));
            sing.pstmt.setString(5, dataAC.getFieldAsString("Freigabe"));
                
            sing.pstmt.executeUpdate();
        } catch (SQLException e) {
            App.consoleLog("new Create -> "  + e.getMessage());
            App.msgbox("Sie m\u00fcssen alle felder ausf\u00fcllen");
        }
    }


    public void delete(Double id){
        try {
            String sqldelet = "Delete from mitarbeiter where MitarbeiterID = ?";
            sing.pstmt = sing.con.prepareStatement(sqldelet);
            sing.pstmt.setDouble(1, id);
            sing.pstmt.executeQuery();
        } catch (SQLException e) {
            App.consoleLog("delet ->" + e.getMessage());
        }
    }
   
}
