package samples;

import org.dwcj.App;
import org.dwcj.component.button.Button;
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
    private Panel overviewEmpP;
    private Panel tableEmpP;
    private Panel calendarEmpP;


    private Button overviewbtn;
    private Button feedbackbtn;
    private Button menüIconbtn;
    private Label titleEmp;
    private Label basisiconEmp;

    private boolean empTestB;
    private boolean feedTestB;
    private boolean overviewB;
    private boolean menüBarB;

    private TextArea zielTA;


    public void run() throws DwcjException{
        App.setTheme("dark-pure");

        empTestB = false;
        feedTestB = false;
        overviewB = false;
        menüBarB = true;

        frameEmp = new Frame().addClassName("frameEmp");

        titleEmp = new Label("Feedback").addClassName("titleEmp");

        basisiconEmp = new Label("<html><img src='" + "https://i.ibb.co/1n4n1Nh/logo.png" + "'</img></html>").addClassName("basisiconEmp");

        menüIconbtn = new Button("<html><bbj-icon-button name='menu-2' data-drawer-toggle><bbj-icon-button></html>").addClassName("menüIconbtn");

        calendarEmpP = new Panel().addClassName("calendarEmpP");

        tableEmpP = new Panel().addClassName("tableEmpP");

        navbarEmpP = new Panel().addClassName("navbarEmpP");

        profilMenüEmpP = new Panel().addClassName("profilMenüEmpP")
        .add(menüIconbtn);

        overviewEmpP = new Panel().addClassName("übersichtsP");

        menübarEmpP = new Panel().addClassName("menübarEmpP");
        overviewbtn = new Button("Übersicht").addClassName("overviewbtn");
        feedbackbtn = new Button("Feedback").addClassName("feedbackbtn");


        menüIconbtn.onClick(e -> {
            menütest();
        });


        overviewbtn.onClick(e ->{
            runtest();

        });

        feedbackbtn.onClick(e -> {
            runtest();
            overviewEmpP.setVisible(false);

        });

        navbarEmpP.add(basisiconEmp, titleEmp);
        overviewEmpP.add(tableEmpP, calendarEmpP);
        frameEmp.add(navbarEmpP, profilMenüEmpP, menübarEmpP, overviewEmpP);
        menübarEmpP.add(overviewbtn, feedbackbtn);

        zielTA = new TextArea().addClassName("zielTA").setAttribute("label", "Meine Ziele");



    }

    public void runtest(){
        if(feedTestB == false){
            // feed.run();
            // frame.add(feed.feedbackP);
            feedTestB = true;
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
