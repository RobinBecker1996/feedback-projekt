package samples;

import org.dwcj.App;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
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

    private Button logoutBtn;
    private Button overviewbtn;
    private Button feedbackbtn;
    private Button employeesbtn;
    private Button menüIconbtn;
    private Label title;
    private Label basisicon;

    private boolean empTestB;
    private boolean feedTestB;
    private boolean menüBarB;

    private EmployeesPan empl = new EmployeesPan();
    private FeedbackPan feed = new FeedbackPan();
    private Login log;


    @Override
    public void run() throws DwcjException {
    App.setTheme("dark-pure");
    log = new Login();
        empTestB = false;
        feedTestB = false;
        menüBarB = true;

        frame = new Frame().addClassName("frame");

        title = new Label("Feedback").addClassName("title");

        basisicon = new Label("<html><img src='" + "https://i.ibb.co/1n4n1Nh/logo.png" + "'</img></html>").addClassName("basisicon");

        tableP = new Panel().addClassName("tableP");

        menüIconbtn = new Button("<html><bbj-icon-button name='menu-2' data-drawer-toggle><bbj-icon-button></html>").addClassName("menüIconbtn");

        calendarP = new Panel().addClassName("calendarP");

        navbarP = new Panel().addClassName("navbarP").add(basisicon, title);

        profilMenüP = new Panel().addClassName("profilMenüP")
        .add(menüIconbtn);

        overviewP = new Panel().addClassName("übersichtsP");

        menübarP = new Panel().addClassName("menübarEmpP");

        overviewbtn = new Button("Übersicht").addClassName("übersichtsbtn");
        feedbackbtn = new Button("Feedback").addClassName("feedbackbtn");
        employeesbtn = new Button("Mitarbeiter").addClassName("employeesbtn");
        logoutBtn = new Button("Logout").addClassName("logoutBtn").setTheme(ButtonTheme.DANGER);

        logoutBtn.onClick(e -> {
            frame.destroy();
            log.run();
        });


        menüIconbtn.onClick(e -> {
            menütest();
        });

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
        menübarP.add(overviewbtn, employeesbtn, feedbackbtn, logoutBtn);
    }

    public void runtest(){
        if (empTestB == false){
            empl.run();
            frame.add(empl.employeesMitP, empl.backP);
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
