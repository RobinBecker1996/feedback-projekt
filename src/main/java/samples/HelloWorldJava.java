package samples;

import org.dwcj.App;
import org.dwcj.annotation.AppTitle;
import org.dwcj.annotation.InlineStyleSheet;

import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/styles.css")
@AppTitle("DWCJ Hello World")

public class HelloWorldJava extends App {
    Overview over;
    EmployeesOverviewPan empover;

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
        } catch (Exception e) {

        }
    }


}

