package samples;

import org.dwcj.App;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.textarea.TextArea;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;

public class EmployeesOverviewPan extends App{
    private Frame frameEmp;
    private Panel navbarEmpP;
    private Panel profilMenüEmpP;
    private Panel menübarEmpP;


    private Panel empOverBackP;
    private Panel empOverTopP;
    private Panel empOverTableP;
    private Panel empOverCalendarP;
    private Panel empOverBottomP;
    private Panel empOverTextAreaP;

    private Button logoutBtn;
    private Button overviewbtn;
    private Button feedbackbtn;
    private Button menüIconbtn;
    private Label titleEmp;
    private Label basisiconEmp;

    private boolean empTestB;
    private boolean empFeedTestB;
    private boolean overviewB;
    private boolean menüBarB;

    private TextArea zielTA;

    EmpFeedbackPan empFeed = new EmpFeedbackPan();
    Login log;

    public void run() throws DwcjException{
        App.setTheme("dark-pure");

        log = new Login();
        empTestB = false;
        empFeedTestB = false;
        overviewB = false;
        menüBarB = true;

        frameEmp = new Frame().addClassName("frameEmp");

        titleEmp = new Label("Employees").addClassName("titleEmp");
        basisiconEmp = new Label("<html><img src='" + "https://i.ibb.co/1n4n1Nh/logo.png" + "'</img></html>").addClassName("basisiconEmp");

        menüIconbtn = new Button("<html><bbj-icon-button name='menu-2' data-drawer-toggle><bbj-icon-button></html>").addClassName("menüIconbtn");

        navbarEmpP = new Panel().addClassName("navbarEmpP");
        profilMenüEmpP = new Panel().addClassName("profilMenüEmpP")
        .add(menüIconbtn);
        menübarEmpP = new Panel().addClassName("menübarEmpP");

        empOverBackP = new Panel().addClassName("empOverBackP");
        empOverTopP = new Panel().addClassName("empOverTopP");
        empOverTableP = new Panel().addClassName("empOverTableP");
        empOverCalendarP = new Panel().addClassName("empOverCalendarP");
        empOverBottomP = new Panel().addClassName("empOverBottomP");
        empOverTextAreaP = new Panel().addClassName("empOverTextAreaP");

        overviewbtn = new Button("Übersicht").addClassName("overviewbtn");
        feedbackbtn = new Button("Feedback").addClassName("feedbackbtn");
        logoutBtn = new Button("Logout").addClassName("logoutBtn").setTheme(ButtonTheme.DANGER);


        logoutBtn.onClick(e -> {
            frameEmp.destroy();
            log.run();
        });

        menüIconbtn.onClick(e -> {
            menütest();
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

        navbarEmpP.add(basisiconEmp, titleEmp);
        frameEmp.add(navbarEmpP, profilMenüEmpP, menübarEmpP, empOverBackP);
        menübarEmpP.add(overviewbtn, feedbackbtn, logoutBtn);


        empOverBackP.add(empOverTopP, empOverBottomP);
        empOverTopP.add(empOverTableP,empOverCalendarP);
        empOverBottomP.add(empOverTextAreaP);

        zielTA = new TextArea().addClassName("zielTA").setAttribute("label", "Meine Ziele");



    }

    public void runtest(){
        if(empFeedTestB == false){
            empFeed.run();
            frameEmp.add(empFeed.empFeedbackBackP);
            empFeedTestB = true;
        }
    }

    public void  menütest(){
        if (menüBarB == true){
            menübarEmpP.setVisible(false);
            menüBarB = false;
        }else if (menüBarB == false){
            menübarEmpP.setVisible(true);
            menüBarB = true;
        }
    }

}
