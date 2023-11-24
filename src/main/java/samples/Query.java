package samples;

import java.sql.SQLException;


import org.dwcj.App;

import com.basiscomponents.db.DataRow;
import com.basiscomponents.db.ResultSet;

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
            sqlInsert = "INSERT INTO mitarbeiter VALUES(?, ?, ?, ?, ?, ?, ?)";
            sing.pstmt = sing.con.prepareStatement(sqlInsert);
            sing.pstmt.setDouble(1, data.getFieldAsNumber(colMitarbeiter[0]));
            int count = 2;

            for (int i = 1; i < colMitarbeiter.length; i++){
                sing.pstmt.setString(count, data.getFieldAsString(colMitarbeiter[i]));
                count++;
            }
            
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
            // TODO Auto-generated catch block
            App.consoleLog("delet ->" + e.getMessage());
        }
    }

    //   public void getNextID(){
    //     EmployeesPan empl = new EmployeesPan();
    //     try {
    //         ResultSet rs = sing.readout("SELECT * FROM Mitarbeiter");
    //         Double id = Double.valueOf(rs.size()); 
    //         id++;
    //         App.consoleLog("last ID = " + id);
    //         empl.employeesIDNF.setValue(id); 
    //     } catch (SQLException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
    // }

    
}
