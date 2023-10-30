package samples;

import java.util.HashMap;


import org.dwcj.App;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.event.EventDispatcher;
import org.dwcj.component.event.EventListener;
import org.dwcj.component.field.TextField;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjAppInitializeException;

public class Login {
    private TextField NameTF;
    private TextField tf_Passwort;
    private String name = "";
    private final Frame frame;

    private final EventDispatcher dispatcher = new EventDispatcher();

    public Login() throws DwcjAppInitializeException {
        frame = new Frame()
        .addClassName("loginF");
    }

    public void run() {

        Panel panel = new Panel()
        .addClassName("loginP");


        NameTF = new TextField("Name").addClassName("NameTF");

        tf_Passwort = new TextField("Password").addClassName("PasswordTF");

        Button loginBtn = new Button("Login");

        loginBtn.setTheme(ButtonTheme.PRIMARY)
                .onClick(e -> {
                    try {
                        HashMap<String, Object> payload = new HashMap<>();
                        payload.put("user", name);
                        onLoginEvent(new LoginEvent(loginBtn, payload));
                        App.consoleLog("vor layout.run()");
                    } catch (Exception e1) {
                        App.consoleLog("Login btn -> " + e1.getMessage());
                    }
                });


        frame.add(panel);
        panel.add( NameTF, tf_Passwort, loginBtn);
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
}
