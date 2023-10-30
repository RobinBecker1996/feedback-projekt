package samples;

import org.dwcj.component.button.Button;
import org.dwcj.component.window.Panel;

public class EmpFeedbackPan {
    private Panel empFeedbackBackP;
    private Panel empFeedbackTopP;
    private Panel empFeedbackTableEmpP;
    private Panel empFeedbackCenterP;
    private Panel empFeedbackFormP;
    private Panel empFeedbackTableFeedP;
    private Panel empFeedbackCalendarP;
    private Panel empFeedbackBtnP;

    private Button sendbtn;

    public void run() {
        empFeedbackBackP = new Panel().addClassName("empFeedbackBackP").setVisible(false);
        empFeedbackTopP = new Panel().addClassName("empFeedbackTopP");
        empFeedbackTableEmpP = new Panel().addClassName("empFeedbackTableEmpP");
        empFeedbackCenterP = new Panel().addClassName("empFeedbackCenterP");
        empFeedbackFormP = new Panel().addClassName("empFeedbackFormP");
        empFeedbackTableFeedP = new Panel().addClassName("empFeedbackTableFeedP");
        empFeedbackCalendarP = new Panel().addClassName("empFeedbackCalendarP");
        empFeedbackBtnP = new Panel().addClassName("empFeedbackBtnP");

        sendbtn = new Button("Senden");

        empFeedbackBackP.add(empFeedbackTopP, empFeedbackCenterP, empFeedbackBtnP);
        empFeedbackTopP.add(empFeedbackTableEmpP);
        empFeedbackCenterP.add(empFeedbackFormP, empFeedbackTableFeedP, empFeedbackCalendarP);
        empFeedbackBtnP.add(sendbtn);
    }
}
