package samples;

import org.dwcj.component.textarea.TextArea;
import org.dwcj.component.window.Panel;

public class EmployeesOverviewPan {
    public Panel empOverbackP;
    private Panel empOvertopP;
    private Panel empOverTableP;
    private Panel empOverCalendarP;
    private Panel empOverBottomP;
    private Panel empOverZieleP;

    private TextArea zielTA;


    public void run() {
        empOverbackP = new Panel().addClassName("empOverbackP");
        empOvertopP = new Panel().addClassName("empOvertopP");
        empOverTableP = new Panel().addClassName("empOverTableP");
        empOverCalendarP = new Panel().addClassName("empOverCalendarP");
        empOverBottomP = new Panel().addClassName("empOverBottomP");
        empOverZieleP = new Panel().addClassName("empOverZieleP");

        zielTA = new TextArea().addClassName("zielTA").setAttribute("label", "Meine Ziele");


        empOverbackP.add(empOvertopP, empOverBottomP);
        empOvertopP.add(empOverTableP, empOverCalendarP);
        empOverBottomP.add(empOverZieleP);
        empOverZieleP.add(zielTA);
    }

}
