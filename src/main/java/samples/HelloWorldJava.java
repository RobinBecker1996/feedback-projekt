package samples;

import org.dwcj.App;
import org.dwcj.annotation.AppTitle;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.Expanse;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;

/**
 * A simple HelloWorld app.
 */
@InlineStyleSheet(/* css */"""
    .frame {
        display: inline;

    }

    .navbarP{
        background-color: #101418;
        height:32px;
        width: 100%;
    }

    .profilMenüP{
        display:flex;
        background-color: black;
        height: 60px;
        width: 100%;
    }

    .menübarP{
        background-color: #333F4D;
        height:80px;
    }

    .übersichtsbtn, .feedbackbtn, .mitarbeiterbtn{
        height: 80px;
        padding-left: 2px;
        color: #d40f2f;
    }

    .menüIcon{
        display: contents;
    }

    """)
@AppTitle("DWCJ Hello World")
public class HelloWorldJava extends App {
    private Panel navbarP;
    private Panel profilMenüP;
    private Panel menübarP;
    private Frame frame;

    private Button übersichtbtn;
    private Button feedbackbtn;
    private Button mitarbeiterbtn;
    private Label menüIcon;

    @Override
    public void run() throws DwcjException {
    App.setTheme("dark-pure");
    menüIcon = new Label("<html><bbj-icon-button name='menu-2' data-drawer-toggle><bbj-icon-button></html>").addClassName("menüIcon");

    frame = new Frame().addClassName("frame");
    navbarP = new Panel().addClassName("navbarP");
    profilMenüP = new Panel().addClassName("profilMenüP")
    .add(menüIcon);

        menüIcon.addMouseExitListener(e ->{
            // if (!profilMenüP.isVisible()) {
                menübarP.setVisible(false);
            // }else{
                // profilMenüP.setVisible(true);
            // }
        });

    menübarP = new Panel().addClassName("menübarP");

    übersichtbtn = new Button("Übersicht").addClassName("übersichtsbtn");
    feedbackbtn = new Button("Feedback").addClassName("feedbackbtn");
    mitarbeiterbtn = new Button("Mitarbeiter").addClassName("mitarbeiterbtn");


        frame.add(navbarP, profilMenüP, menübarP);
        menübarP.add(übersichtbtn, feedbackbtn, mitarbeiterbtn);
    }

}
