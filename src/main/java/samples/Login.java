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

import com.basiscomponents.db.ResultSet;

public class Login {
    private TextField NameTF;
    private TextField tf_Passwort;
    private String name = "";
    private final Frame frame;
   

    Button empbtn;
    EmployeesOverviewPan empover;
    SingletonClass sing = SingletonClass.getInstance();
    GridExWidget grid; 

    private final EventDispatcher dispatcher = new EventDispatcher();

    public Login() throws DwcjAppInitializeException {
        frame = new Frame()
        .addClassName("loginF");
    }

    public void run() {
        // grid = new GridExWidget();
        Panel p = new Panel()
        .addClassName("loginP");

        NameTF = new TextField("Name").addClassName("NameTF");

        tf_Passwort = new TextField("Password").addClassName("PasswordTF");

        Button loginBtn = new Button("Login");
        empbtn = new Button("empbtn");

        loginBtn.setTheme(ButtonTheme.PRIMARY)
                .onClick(e -> {
                    try {
                        sing.connect();
                        // gridsetup();
                        HashMap<String, Object> payload = new HashMap<>();
                        payload.put("user", name);
                        onLoginEvent(new LoginEvent(loginBtn, payload));
                        App.consoleLog("vor layout.run()");
                    } catch (Exception e1) {
                        App.consoleLog("Login btn -> " + e1.getMessage());
                    }
                });

                
        empbtn.onClick(e -> {
            try {
                empover = new EmployeesOverviewPan();
                frame.destroy();
                empover.run();
            } catch (DwcjException e1) {
                e1.printStackTrace();
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

    public void gridsetup() {
        try { 
            sing.connect();
            grid = new GridExWidget();
            ResultSet rs = sing.readout("SELECT * FROM Mitarbeiter");
            rs.first();
            grid.setData(rs, 0 , true)
                .autoSizeColumns();
       } catch (SQLException e) {
           App.consoleLog("Gridsetup-> " + e.getMessage());
       }
   }
     
}
