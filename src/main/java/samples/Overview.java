package samples;

import org.dwcj.App;
import org.dwcj.component.button.Button;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;

public class Overview extends App{
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
    // private Label menüIcon;
    private Button menüIconbtn;
    private Label title;
    private Label basisicon;

    // private Boolean empBEmployees
    private boolean empTestB;
    private boolean feedTestB;
    private boolean overviewB;
    private boolean menüBarB;

    private EmployeesPan empl = new EmployeesPan();
    private FeedbackPan feed = new FeedbackPan();


    @Override
    public void run() throws DwcjException {
    App.setTheme("dark-pure");

        empTestB = false;
        feedTestB = false;
        overviewB = false;
        menüBarB = true;

        frame = new Frame().addClassName("frame");

        title = new Label("Feedback").addClassName("title");

        basisicon = new Label("<html><img src='" + "https://i.ibb.co/1n4n1Nh/logo.png" + "'</img></html>").addClassName("basisicon");

        tableP = new Panel().addClassName("tableP");

        menüIconbtn = new Button("<html><bbj-icon-button name='menu-2' data-drawer-toggle><bbj-icon-button></html>").addClassName("menüIconbtn");
        // menüIcon = new Label("<html><bbj-icon-button name='menu-2' data-drawer-toggle><bbj-icon-button></html>").addClassName("menüIcon");


        calendarP = new Panel().addClassName("calendarP");


        navbarP = new Panel().addClassName("navbarP").add(basisicon, title);

        profilMenüP = new Panel().addClassName("profilMenüP")
        .add(menüIconbtn);
        // profilMenüP = new Panel().addClassName("profilMenüP")
        // .add(menüIcon);

        overviewP = new Panel().addClassName("übersichtsP");

        menübarP = new Panel().addClassName("menübarP");
        overviewbtn = new Button("Übersicht").addClassName("übersichtsbtn");
        feedbackbtn = new Button("Feedback").addClassName("feedbackbtn");
        employeesbtn = new Button("Mitarbeiter").addClassName("employeesbtn");

        menüIconbtn.onClick(e -> {
            menütest();
        });
        // menüIcon.addMouseEnterListener(e -> {
        //     menütest();
        // });

        overviewbtn.onClick(e ->{
            runtest();
            feed.feedbackP.setVisible(false);
            empl.employeesMitP.setVisible(false);
            overviewP.setVisible(true);
        });

        employeesbtn.onClick(e -> {
            runtest();
            feed.feedbackP.setVisible(false);
            overviewP.setVisible(false);
            empl.employeesMitP.setVisible(true);
        });

        feedbackbtn.onClick(e -> {
            runtest();
            overviewP.setVisible(false);
            empl.employeesMitP.setVisible(false);
            feed.feedbackP.setVisible(true);
        });

        overviewP.add(tableP, calendarP);
        frame.add(navbarP, profilMenüP, menübarP, overviewP);
        menübarP.add(overviewbtn, employeesbtn, feedbackbtn);
    }

    public void runtest(){
        if (empTestB == false){
            empl.run();
            frame.add(empl.employeesMitP);
            empTestB = true;
        }
        if(feedTestB == false){
            feed.run();
            frame.add(feed.feedbackP);
            feedTestB = true;
        }
    }

    public void  menütest(){
        if (menüBarB == true){
            menübarP.setVisible(false);
            menüBarB = false;
        }else if (menüBarB == false){
            menübarP.setVisible(true);
            menüBarB = true;
        }
    }
}
