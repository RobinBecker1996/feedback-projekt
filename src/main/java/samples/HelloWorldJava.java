package samples;

import org.dwcj.App;
import org.dwcj.annotation.AppTitle;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
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

    .übersichtsbtn, .feedbackbtn, .employeesbtn{
        height: 80px;
        padding-left: 2px;
        color: #d40f2f;
    }

    .menüIcon{
        display: contents;
    }

    .tableP {
        height: 250px;
        background-color: white;
        width: 50%;
        margin: 5px;
    }

    .calendarP {
        display: flex;
        height: 388px;
        background-color: blue;
        width: 30%;
        margin-left: 149px;
        margin-top: 20px;
    }

    .übersichtsP {
        display: flex;
    }

    .title {
        display: flex;
        justify-content: center;
        margin-top: -27px;
        font-size: 20px;
    }

    .basisicon {
        display: flex;
        height: 31px;
    }


    """)
@AppTitle("DWCJ Hello World")
public class HelloWorldJava extends App {
    private Panel navbarP;
    private Panel profilMenüP;
    private Panel menübarP;
    private Panel overviewP;
    private Panel tableP;
    private Panel calendarP;
    private Frame frame;

    private Button overviewbtn;
    private Button feedbackbtn;
    private Button employeesbtn;
    private Label menüIcon;
    private Label title;
    private Label basisicon;


    @Override
    public void run() throws DwcjException {
        App.setTheme("dark-pure");

        title = new Label("Feedback").addClassName("title");

        basisicon = new Label("<html><img src='" + "https://i.ibb.co/1n4n1Nh/logo.png" + "'</img></html>").addClassName("basisicon");

        tableP = new Panel().addClassName("tableP");

        menüIcon = new Label("<html><bbj-icon-button name='menu-2' data-drawer-toggle><bbj-icon-button></html>").addClassName("menüIcon");

        calendarP = new Panel().addClassName("calendarP");

        frame = new Frame().addClassName("frame");

        navbarP = new Panel().addClassName("navbarP").add(basisicon, title);

        profilMenüP = new Panel().addClassName("profilMenüP")
        .add(menüIcon);

        overviewP = new Panel().addClassName("übersichtsP");

        employeesbtn.onClick(e -> {

        });


        menübarP = new Panel().addClassName("menübarP");
        overviewbtn = new Button("Übersicht").addClassName("übersichtsbtn");
        feedbackbtn = new Button("Feedback").addClassName("feedbackbtn");
        employeesbtn = new Button("Mitarbeiter").addClassName("employeesbtn");

        overviewP.add(tableP, calendarP);
        frame.add(navbarP, profilMenüP, menübarP, overviewP);
        menübarP.add(overviewbtn, employeesbtn, feedbackbtn);
    }



}
