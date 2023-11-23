package samples;

import java.sql.SQLException;
import java.util.HashMap;


import org.dwcj.App;
import org.dwcj.bbjplugins.gridexwidget.GridExWidget;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.event.EventDispatcher;
import org.dwcj.component.event.EventListener;
import org.dwcj.component.field.TextField;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjAppInitializeException;
import org.dwcj.exceptions.DwcjException;


public class Login {
    private TextField NameTF;
    private TextField tf_Passwort;
    private String name = "";
    private final Frame frame;
    private int id;
    GridExWidget grid = new GridExWidget();
    GridClass gridclass = new GridClass();
   

    Button empbtn;
    EmployeesOverviewPan empover;
    SingletonClass sing = SingletonClass.getInstance();

    private final EventDispatcher dispatcher = new EventDispatcher();

    public Login() throws DwcjAppInitializeException {
        frame = new Frame()
        .addClassName("loginF");
    }

    public void run() {
        Panel p = new Panel()
        .addClassName("loginP");

        NameTF = new TextField("Name").addClassName("NameTF");

        tf_Passwort = new TextField("Password").addClassName("PasswordTF");

        Button loginBtn = new Button("Login");
        empbtn = new Button("empbtn");

        loginBtn.setTheme(ButtonTheme.PRIMARY)
                .onClick(e -> {
                    try {
                        Overview over = new Overview();
                        sing.connect();
                        HashMap<String, Object> payload = new HashMap<>();
                        payload.put("user", name);
                        onLoginEvent(new LoginEvent(loginBtn, payload));
                        App.consoleLog("vor layout.run()");
                        gridclass.adminGridSetup();
                    } catch (Exception e1) {
                        App.consoleLog("Login btn -> " + e1.getMessage());
                    }
                });

                
        empbtn.onClick(e -> {
            try {
                sing.connect();
                empover = new EmployeesOverviewPan();
                frame.destroy();
                empover.run();
                gridclass.empGridSetup();
            } catch (SQLException | DwcjException e1) {
                
            }   
        });


        frame.add(p);
        p.add(NameTF, tf_Passwort, loginBtn, empbtn);
    }

    private void onLoginEvent(LoginEvent event) {
        this.dispatcher.dispatchEvent(event);
        App.consoleLog("destroy Frame");
        frame.destroy();
    }

    public Login onLogin(EventListener<LoginEvent> listener) {
        this.dispatcher.addEventListener(LoginEvent.class, listener);
        return this;
    }
     
//     public void adminGridSetup() {
//         Overview over = new Overview();
//         over.tableP.add(over.ogrid);
//         try {    
//             ResultSet rs = sing.readout("SELECT * FROM Mitarbeiter");
//             rs.first();
//             over.ogrid.setData(rs, 1, true)
//                 .autoSizeColumns();
//        } catch (SQLException e) {
//            App.consoleLog("Gridsetup-> " + e.getMessage());
//        }
//    }

//    public void empGridSetup() {
//         EmployeesOverviewPan empO = new EmployeesOverviewPan();
//         empO.empOverTableP.add(empO.grid);
//         try {    
//             ResultSet rs = sing.readout("SELECT * FROM Mitarbeiter WHERE Vorname = 'Robin'");
//             empO.grid.setData(rs, 1, true)
//                 .autoSizeColumns();
//        } catch (SQLException e) {
//            App.consoleLog("Gridsetup-> " + e.getMessage());
//        }
//    }

//    public void gridrefresh(){
//     try {
//         ResultSet rs = sing.readout("SELECT * FROM Mitarbeiter");
//         rs.first();
//         grid.setData(rs, 1, true)
//             .autoSizeColumns();
//     } catch (SQLException e) {
//         App.consoleLog("gridRefresh -> " + e.getMessage());
//     }
//     }

//     public void empgridrefresh(){
//         try {
//             ResultSet rs = sing.readout("SELECT * FROM Mitarbeiter WHERE MitarbeiterID = 1");
//             rs.first();
//             grid.setData(rs, 1, true)
//                 .autoSizeColumns();
//         } catch (SQLException e) {
//             App.consoleLog("gridRefresh -> " + e.getMessage());
//         }
//         }
   
}
