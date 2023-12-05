package samples;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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

import com.basiscomponents.db.ResultSet;


public class Login {
    private TextField nameTF;
    private TextField tf_Passwort;
    private String name = "";
    private final Frame frame;
    String vorname;
    String passwort;

    GridExWidget grid = new GridExWidget();
    GridClass gridclass = new GridClass();
    HashMap<Double, Object> mykey = new HashMap<>(); 
    HashMap<String, String> myMap = new HashMap<>(); 

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

        nameTF = new TextField("Name").addClassName("nameTF");

        tf_Passwort = new TextField("Password").addClassName("PasswordTF");

        Button loginBtn = new Button("Login");
        empbtn = new Button("empbtn");

        loginBtn.setTheme(ButtonTheme.PRIMARY)
                .onClick(e -> {
                    try {
                        // HashingClass hashing = new HashingClass();
                        // hashing.getPassword();
                        sing.connect();
                        HashMap<String, Object> payload = new HashMap<>();
                        payload.put("user", name);
                        // onLoginEvent(new LoginEvent(loginBtn, myMap));
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
        p.add(nameTF, tf_Passwort, loginBtn, empbtn);
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


    
    public void genMap() {
        try {
            // HashMap<String, String> myMap = new HashMap<>(); 
            ResultSet rs;
            rs = sing.readout("SELECT * FROM Mitarbeiter");
        while (rs.next()) {
            vorname = rs.getString(1);
            passwort = rs.getString(4);
            //Create array resembling the primary key
            myMap.put("Vorname",vorname);
            myMap.put("Passwort", passwort);
            // HashMap<Double, Object> mykey = new HashMap<>(); 
            //Store to Map the key and the value
            Double id = rs.getDouble(0);
            mykey.put(id, myMap);
        }//TODO Wahrscheinlich besser nur eine Hasmap nutzen <- nö brauch zwei
        // return myMap;
         } catch (SQLException e) {
            App.consoleLog("genMap -> " + e.getMessage());
        }
    }

    public void passwortTest() {
        genMap();
        String name = nameTF.getText();
        if(name.equals(myMap.get("Vorname"))){
            
        }
        
    }
     
   
}
