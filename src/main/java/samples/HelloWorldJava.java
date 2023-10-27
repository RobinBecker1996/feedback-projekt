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
    ScrollPaneBorder scroll;

    MitarbeiterPan mit;

    @Override
    public void run() throws DwcjException {
        App.setTheme("dark-pure");

        mit = new MitarbeiterPan();

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

        menübarP = new Panel().addClassName("menübarP");
        overviewbtn = new Button("Übersicht").addClassName("übersichtsbtn");
        feedbackbtn = new Button("Feedback").addClassName("feedbackbtn");
        employeesbtn = new Button("Mitarbeiter").addClassName("employeesbtn");

        menüIcon.onMouseEnter(e -> {
            if (!menübarP.isVisible()){
                menübarP.setVisible(true);
            }else{
                menübarP.setVisible(false);
            }
        });

        overviewbtn.onClick(e -> {
            mit.employeesMitP.setVisible(false);
            overviewP.setVisible(true);
        });


        employeesbtn.onClick(e -> {
            overviewP.setVisible(false);
            mit.run();
            mit.employeesMitP.setVisible(true);
            // overviewP.destroy();
            frame.add(mit.employeesMitP);
        });

        overviewP.add(tableP, calendarP);
        frame.add(navbarP, profilMenüP, menübarP, overviewP);
        menübarP.add(overviewbtn, employeesbtn, feedbackbtn);
    }



}
