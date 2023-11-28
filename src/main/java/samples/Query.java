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
            sing.pstmt.setDouble(7, data.getFieldAsNumber(colMitarbeiter[0]));

            for (int i = 1; i < colMitarbeiter.length; i++){
                sing.pstmt.setString(i, data.getFieldAsString(colMitarbeiter[i]));
            } 

            sing.pstmt.executeUpdate();
        } catch (SQLException e) {
            App.consoleLog("rs Update -> " + e.getMessage());
            App.msgbox("Sie m\u00fcssen alle felder ausf\u00fcllen");
        }
    }


    public void create(DataRow data) {
        try {
            String sqlInsert = "";
            sqlInsert = "INSERT INTO mitarbeiter (Vorname, Nachname, feedback)VALUES( ?, ?, ?)";
            sing.pstmt = sing.con.prepareStatement(sqlInsert);
            // sing.pstmt.setDouble(1, data.getFieldAsNumber(colMitarbeiter[0]));
            // int count = 1;
            // for (int i = 1; i < 3; i++){
                sing.pstmt.setString(1, data.getFieldAsString("Vorname"));
                sing.pstmt.setString(2, data.getFieldAsString("Nachname"));
                sing.pstmt.setString(3, data.getFieldAsString("Feedback"));
                // count++;
            // }

            // for (int i = 1; i < colMitarbeiter.length; i++){
            //     sing.pstmt.setString(count, data.getFieldAsString(colMitarbeiter[i]));
            //     count++;
            // }
            
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
