package samples;


import org.dwcj.component.button.Button;
import org.dwcj.component.window.Panel;
import org.dwcj.ui5.calendar.UI5Calendar;
import org.dwcj.ui5.calendar.UI5Calendar.SelectionMode;

public class EmpFeedbackPan {
    public Panel empFeedbackBackP;
    private Panel empFeedbackTopP;
    private Panel empFeedbackTableEmpP;
    private Panel empFeedbackCenterP;
    private Panel empFeedbackFormP;
    private Panel empFeedbackTableFeedP;
    private Panel empFeedbackCalendarP;
    private Panel empFeedbackBtnP;

    private Button sendbtn;
    private Button testbtn;

    public void run() {
        PDFShow pdf = new PDFShow();
        UI5Calendar calendar = new UI5Calendar();

        calendar.setSelectionMode(SelectionMode.MULTIPLE);
        calendar.setHideWeekNumbers(true);

        testbtn = new Button("Test");

        empFeedbackBackP = new Panel().addClassName("empFeedbackBackP").setVisible(false);
        empFeedbackTopP = new Panel().addClassName("empFeedbackTopP");
        empFeedbackTableEmpP = new Panel().addClassName("empFeedbackTableEmpP");
        empFeedbackCenterP = new Panel().addClassName("empFeedbackCenterP");
        empFeedbackFormP = new Panel().addClassName("empFeedbackFormP");
        empFeedbackTableFeedP = new Panel().addClassName("empFeedbackTableFeedP");
        empFeedbackCalendarP = new Panel().addClassName("empFeedbackCalendarP");
        empFeedbackBtnP = new Panel().addClassName("empFeedbackBtnP");

        sendbtn = new Button("Senden");
        testbtn.onClick(e -> {
            pdf.pdfShow();
        });

        empFeedbackBackP.add(empFeedbackTopP, empFeedbackCenterP, empFeedbackBtnP);
        empFeedbackTopP.add(empFeedbackTableEmpP);
        empFeedbackCalendarP.add(calendar);
        empFeedbackFormP.add(testbtn);
        empFeedbackCenterP.add(empFeedbackFormP, empFeedbackTableFeedP, empFeedbackCalendarP);
        empFeedbackBtnP.add(sendbtn);
    }
}
