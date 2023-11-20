package samples;

import java.sql.SQLException;

import org.dwcj.App;
import org.dwcj.annotation.AppTitle;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.bbjplugins.gridexwidget.GridExWidget;
import org.dwcj.exceptions.DwcjException;

import com.basiscomponents.db.ResultSet;

@InlineStyleSheet("context://css/styles.css")
@InlineStyleSheet("context://css/menubar.css")
@InlineStyleSheet("context://css/login.css")
@AppTitle("DWCJ Hello World")

public class HelloWorldJava extends App {
    Overview over;
    EmployeesOverviewPan empover;
    GridExWidget grid;
    SingletonClass sing = SingletonClass.getInstance();

    @Override
    public void run() throws DwcjException {
        over = new Overview();
        final Login login = new Login();
        login.run();
        login.onLogin(this::login);
    }

    public void login(LoginEvent event) {
        try {
            over.run();
            gridsetup();
            over.tableP.add(grid);
        } catch (Exception e) {

        }
    }

    public void gridsetup() {
        try {    
            ResultSet rs = sing.readout("SELECT * FROM Mitarbeiter");
            rs.first();
            grid.setData(rs, 1, true)
                .autoSizeColumns();
       } catch (SQLException e) {
           App.consoleLog("Gridsetup-> " + e.getMessage());
       }
   }


}

