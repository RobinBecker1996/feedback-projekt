package samples;

import java.sql.SQLException;

import org.dwcj.App;
import org.dwcj.bbjplugins.gridexwidget.GridExWidget;

import com.basiscomponents.db.ResultSet;

public class GridClass {
    SingletonClass sing = SingletonClass.getInstance();
    // GridExWidget empGrid = new GridExWidget();
    GridExWidget grid = new GridExWidget();
    EmployeesPan empl = new EmployeesPan();



    public void empGridSetup() {
        EmployeesOverviewPan empO = new EmployeesOverviewPan();
        empO.empOverTableP.add(empO.grid);
        try {    
            ResultSet rs = sing.readout("SELECT * FROM Mitarbeiter WHERE Vorname = 'Robin'");
            empO.grid.setData(rs, 1, true)
                .autoSizeColumns();
       } catch (SQLException e) {
           App.consoleLog("Gridsetup-> " + e.getMessage());
       }
   }


   public void adminGridSetup() {
        Overview over = new Overview();
        over.tableP.add(over.ogrid);
        try {    
            ResultSet rs = sing.readout("SELECT * FROM Mitarbeiter");
            rs.first();
            over.ogrid.setData(rs, 1, true)
                .autoSizeColumns();
        } catch (SQLException e) {
        App.consoleLog("Gridsetup-> " + e.getMessage());
        }
    }


    

  
}
