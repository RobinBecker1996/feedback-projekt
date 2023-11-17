package samples;

import org.dwcj.App;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.textarea.TextArea;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;
// import org.dwcj.ui5.calendar.UI5Calendar;
// import org.dwcj.ui5.calendar.UI5Calendar.SelectionMode;

public class EmployeesOverviewPan extends App{
    private Frame frameEmp;
    private Panel navbarEmpP;
    private Panel profilMenuEmpP;
    private Panel menubarEmpP;


    private Panel empOverBackP;
    private Panel empOverTopP;
    private Panel empOverTableP;
    private Panel empOverCalendarP;
    private Panel empOverBottomP;
    private Panel empOverTextAreaP;
    private Panel zielSchwepunktBtnP;

    private Button zielbtn;

    private Button logoutBtn;
    private Button overviewbtn;
    private Button feedbackbtn;
    private Button menuIconbtn;
    private Label titleEmp;
    private Label basisiconEmp;

    private boolean empFeedTestB;
    private boolean menuBarB;

    private TextArea zielTA;
    private TextArea schwerpunktTA;

    EmpFeedbackPan empFeed = new EmpFeedbackPan();
    Login log;

    public void run() throws DwcjException{
        App.setTheme("dark-pure");

        // UI5Calendar calendar = new UI5Calendar();
        // calendar.setSelectionMode(SelectionMode.MULTIPLE);
        // calendar.setHideWeekNumbers(true);

        log = new Login();
        empFeedTestB = false;
        menuBarB = true;

        frameEmp = new Frame().addClassName("frameEmp");

        zielSchwepunktBtnP = new Panel().addClassName("zielSchwepunktBtnP");

        zielbtn = new Button("add").addClassName("zielbtn");
        

        titleEmp = new Label("Employees").addClassName("titleEmp");
        basisiconEmp = new Label("<html><img src='" + "https://i.ibb.co/1n4n1Nh/logo.png" + "'</img></html>").addClassName("basisiconEmp");

        menuIconbtn = new Button("<html><bbj-icon-button name='menu-2' data-drawer-toggle><bbj-icon-button></html>").addClassName("menuIconbtn");

        zielTA = new TextArea().setAttribute("label", "Meine Ziele:");
        schwerpunktTA = new TextArea().setAttribute("label", "Letzter schwerpunkt:");

        navbarEmpP = new Panel().addClassName("navbarEmpP");
        profilMenuEmpP = new Panel().addClassName("profilMenuEmpP")
        .add(menuIconbtn);
        menubarEmpP = new Panel().addClassName("menubarP");

        empOverBackP = new Panel().addClassName("empOverBackP");
        empOverTopP = new Panel().addClassName("empOverTopP");
        empOverTableP = new Panel().addClassName("empOverTableP");
        empOverCalendarP = new Panel().addClassName("calendarP");
        empOverBottomP = new Panel().addClassName("empOverBottomP");
        empOverTextAreaP = new Panel().addClassName("empOverTextAreaP").add(zielTA, schwerpunktTA);

        overviewbtn = new Button("\u00dcbersicht").addClassName("ubersichtsbtn");
        feedbackbtn = new Button("Feedback").addClassName("feedbackbtn");
        logoutBtn = new Button("<html><bbj-icon name='logout'></bbj-icon></html>").addClassName("logoutBtn").setTheme(ButtonTheme.DANGER);


        logoutBtn.onClick(e -> {
            frameEmp.destroy();
            log.run();
        });

        menuIconbtn.onClick(e -> {
            menutest();
        });


        overviewbtn.onClick(e ->{
            runtest();
            empFeed.empFeedbackBackP.setVisible(false);
            empOverBackP.setVisible(true);
        });

        feedbackbtn.onClick(e -> {
            runtest();
            empOverBackP.setVisible(false);
            empFeed.empFeedbackBackP.setVisible(true);
        });

        zielSchwepunktBtnP.add(zielbtn);

        navbarEmpP.add(basisiconEmp, titleEmp);
        frameEmp.add(navbarEmpP, profilMenuEmpP, menubarEmpP, empOverBackP);
        menubarEmpP.add(overviewbtn, feedbackbtn, logoutBtn);


        empOverBackP.add(empOverTopP, empOverBottomP);
        empOverTopP.add(empOverTableP,empOverCalendarP);
        // empOverCalendarP.add(calendar);
        empOverBottomP.add(empOverTextAreaP, zielSchwepunktBtnP);

    }

    public void runtest(){
        if(empFeedTestB == false){
            empFeed.run();
            frameEmp.add(empFeed.empFeedbackBackP);
            empFeedTestB = true;
        }
    }

    public void  menutest(){
        if (menuBarB == true){
            menubarEmpP.setVisible(false);
            menuBarB = false;
        }else if (menuBarB == false){
            menubarEmpP.setVisible(true);
            menuBarB = true;
        }
    }

}
