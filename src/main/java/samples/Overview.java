package samples;


import org.dwcj.App;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.ui5.calendar.UI5Calendar;
import org.dwcj.ui5.calendar.UI5Calendar.SelectionMode;

public class Overview extends App{
    private Frame frame;
    private Panel navbarP;
    private Panel profilMenuP;
    private Panel menubarP;
    private Panel overviewP;
    private Panel tableP;
    private Panel calendarP;

    private Button logoutBtn;
    private Button overviewbtn;
    private Button feedbackbtn;
    private Button employeesbtn;
    private Button menuIconbtn;
    private Label title;
    private Label basisicon;

    private boolean empTestB;
    private boolean feedTestB;
    private boolean menuBarB;

    private EmployeesPan empl = new EmployeesPan();
    private FeedbackPan feed = new FeedbackPan();
    private Login log;


    @Override
    public void run() throws DwcjException {
        UI5Calendar calendar = new UI5Calendar();

        App.setTheme("dark-pure");
        log = new Login();
        empTestB = false;
        feedTestB = false;
        menuBarB = true;

        calendar.setSelectionMode(SelectionMode.MULTIPLE);
        calendar.setHideWeekNumbers(true);

        frame = new Frame().addClassName("frame");

        title = new Label("Feedback").addClassName("title");
        basisicon = new Label("<html><img src='" + "https://i.ibb.co/1n4n1Nh/logo.png" + "'</img></html>").addClassName("basisicon");

        tableP = new Panel().addClassName("tableP");
        menuIconbtn = new Button("<html><bbj-icon-button name='menu-2' data-drawer-toggle><bbj-icon-button></html>").addClassName("menuIconbtn");
        calendarP = new Panel().addClassName("calendarP");
        navbarP = new Panel().addClassName("navbarP").add(basisicon, title);
        profilMenuP = new Panel().addClassName("profilMenuP")
        .add(menuIconbtn);
        overviewP = new Panel().addClassName("ubersichtsP");
        menubarP = new Panel().addClassName("menubarP");


        overviewbtn = new Button("Übersicht").addClassName("ubersichtsbtn");
        feedbackbtn = new Button("Feedback").addClassName("feedbackbtn");
        employeesbtn = new Button("Mitarbeiter").addClassName("employeesbtn");
        try {
            logoutBtn = new Button("<html><bbj-icon name='logout'></bbj-icon></html>").addClassName("logoutBtn").setTheme(ButtonTheme.DANGER);
        } catch (Exception e) {
            e.getMessage();
        }


        logoutBtn.onClick(e -> {
            frame.destroy();
            log.run();
        });


        menuIconbtn.onClick(e -> {
            menutest();
        });

        overviewbtn.onClick(e ->{
            runtest();
            feed.feedbackP.setVisible(false);
            empl.employeesMitP.setVisible(false);
            empl.backP.setVisible(false);
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

        calendarP.add(calendar);
        overviewP.add(tableP, calendarP);
        frame.add(navbarP, profilMenuP, menubarP, overviewP);
        menubarP.add(overviewbtn, feedbackbtn, employeesbtn, logoutBtn);
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

    public void  menutest(){
        if (menuBarB == true){
            menubarP.setVisible(false);
            menuBarB = false;
        }else if (menuBarB == false){
            menubarP.setVisible(true);
            menuBarB = true;
        }
    }
}
