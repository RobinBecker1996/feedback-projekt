package samples;



import org.dwcj.component.button.Button;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Panel;
import org.dwcj.ui5.calendar.UI5Calendar;
import org.dwcj.ui5.calendar.UI5Calendar.SelectionMode;



public class EmpFeedbackPan {
    public Panel empFeedbackBackP;
    private Panel empFeedbackTopP;
    public Panel empFeedbackTableEmpP;
    private Panel empFeedbackCenterP;
    private Panel empFeedbackFormP;
    private Panel empFeedbackCalendarP;
    private Panel empFeedbackBtnP;
    private Panel btnP;


   
    private Button testbtn;
    private Label img;

    public void run() {
        UI5Calendar calendar = new UI5Calendar();
        calendar.setSelectionMode(SelectionMode.MULTIPLE);
        calendar.setHideWeekNumbers(true);

        img = new Label("<html><img src=http://localhost:8888/Screen-Feedback.png></img></html>")
        .addClassName("pdfimg");

        testbtn = new Button("Test").addClassName("testbtnpdf");

        empFeedbackBackP = new Panel().addClassName("empFeedbackBackP").setVisible(false);
        empFeedbackTopP = new Panel().addClassName("empFeedbackTopP");
        empFeedbackTableEmpP = new Panel().addClassName("empFeedbackTableEmpP");
        empFeedbackCenterP = new Panel().addClassName("empFeedbackCenterP");
        empFeedbackFormP = new Panel().addClassName("empFeedbackFormP");
      
        empFeedbackCalendarP = new Panel().addClassName("feedcalendarP");
        empFeedbackBtnP = new Panel().addClassName("empFeedbackBtnP");
        btnP = new Panel().addClassName("btnP");

        
        testbtn.onClick(e -> {
            // pdf.pdfShow();
        });

        empFeedbackBackP.add(empFeedbackTopP, empFeedbackCenterP, empFeedbackBtnP);
        empFeedbackTopP.add(empFeedbackTableEmpP, empFeedbackCalendarP);
        empFeedbackCalendarP.add(calendar);
        empFeedbackFormP.add(img);
        btnP.add(testbtn);
        empFeedbackCenterP.add(empFeedbackFormP, btnP);
    }


   
}
