package samples;

import javax.swing.plaf.metal.MetalBorders.ScrollPaneBorder;

import org.dwcj.App;
import org.dwcj.annotation.AppTitle;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.button.Button;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/styles.css")
@AppTitle("DWCJ Hello World")

public class HelloWorldJava extends App {
    private Frame frame;
    private Panel navbarP;
    private Panel profilMenüP;
    private Panel menübarP;
    private Panel overviewP;
    private Panel tableP;
    private Panel calendarP;


    private Button overviewbtn;
    private Button feedbackbtn;
    private Button employeesbtn;
    private Label menüIcon;
    private Label title;
    private Label basisicon;

    // private Boolean empB;
    private int countEmp;

    MitarbeiterPan mit = new MitarbeiterPan();


    @Override
    public void run() throws DwcjException {
        App.setTheme("dark-pure");
        countEmp = 0;
        frame = new Frame().addClassName("frame");

        title = new Label("Feedback").addClassName("title");

        basisicon = new Label("<html><img src='" + "https://i.ibb.co/1n4n1Nh/logo.png" + "'</img></html>").addClassName("basisicon");

        tableP = new Panel().addClassName("tableP");

        menüIcon = new Label("<html><bbj-icon-button name='menu-2' data-drawer-toggle><bbj-icon-button></html>").addClassName("menüIcon");

        calendarP = new Panel().addClassName("calendarP");


        navbarP = new Panel().addClassName("navbarP").add(basisicon, title);

        profilMenüP = new Panel().addClassName("profilMenüP")
        .add(menüIcon);

        overviewP = new Panel().addClassName("übersichtsP");

        menübarP = new Panel().addClassName("menübarP");
        overviewbtn = new Button("Übersicht").addClassName("übersichtsbtn");
        feedbackbtn = new Button("Feedback").addClassName("feedbackbtn");
        employeesbtn = new Button("Mitarbeiter").addClassName("employeesbtn");

        menüIcon.onMouseEnter(e -> {
            menübarP.setVisible(true);
            menübarP.setVisible(false);
        });

        overviewbtn.onClick(e -> {
            mit.employeesMitP.setVisible(false);
            overviewP.setVisible(true);
            App.consoleLog(mit.employeesMitP.isVisible().toString());
        });

        employeesbtn.onClick(e -> {
            overviewP.setVisible(false);
            // changTab();
            mit.run();
            mit.employeesMitP.setVisible(true);
            frame.add(mit.employeesMitP);
        });

        overviewP.add(tableP, calendarP);
        frame.add(navbarP, profilMenüP, menübarP, overviewP);
        menübarP.add(overviewbtn, employeesbtn, feedbackbtn);
    }

    public void changTab(){
        if (mit == null){


                ;
            }
    }

}
