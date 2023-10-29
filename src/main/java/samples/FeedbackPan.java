package samples;

import org.dwcj.component.button.Button;
import org.dwcj.component.listbox.ListBox;
import org.dwcj.component.window.Panel;

public class FeedbackPan {
    private Panel feedbackP;
    private Panel formularP;
    private Panel tableEmpP;
    private Panel topP;
    private Panel centerP;
    private Panel bottomP;
    private Panel buttonP;
    private Panel calendarP;
    private Panel feedtableP;

    private Button newFormularbtn;
    private Button savebtn;
    private Button editbtn;

    public void run() {
        feedbackP = new Panel().addClassName("feedbackP").setVisible(false);
        formularP = new Panel().addClassName("formularP").setVisible(false);
        tableEmpP = new Panel().addClassName("tableP").setVisible(false);
        topP = new Panel().addClassName("topP").setVisible(false);
        centerP = new Panel().addClassName("centerP").setVisible(false);
        bottomP = new Panel().addClassName("bottomP").setVisible(false);
        buttonP = new Panel().addClassName("buttonP").setVisible(false);
        calendarP = new Panel().addClassName("calendarP").setVisible(false);
        feedtableP = new Panel().addClassName("feedtableP").setVisible(false);

        newFormularbtn = new Button("New Formular").addClassName("newFormular");
        savebtn = new Button("savebtn").addClassName("newFormular");
        editbtn = new Button("editbtn").addClassName("newFormular");

        feedbackP.add(topP, centerP, bottomP);
        topP.add(tableEmpP);
        centerP.add(formularP, feedtableP, calendarP);
        bottomP.add(newFormularbtn, editbtn, savebtn);
    }
}
