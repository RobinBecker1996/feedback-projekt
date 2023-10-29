package samples;

import org.dwcj.component.button.Button;
import org.dwcj.component.listbox.ListBox;
import org.dwcj.component.window.Panel;

public class FeedbackPan {
    private Panel feedbackP;
    private Panel formularP;
    private Panel tableP;
    private Panel buttonP;
    private Panel calendarP;
    private Panel feedtableP;

    private ListBox selectLB;
    private Button newFormular;

    public void run() {
        feedbackP = new Panel().addClassName("feedbackP").setVisible(false);
        formularP = new Panel().addClassName("formularP").setVisible(false);
        tableP = new Panel().addClassName("tableP").setVisible(false);
        buttonP = new Panel().addClassName("buttonP").setVisible(false);
        calendarP = new Panel().addClassName("calendarP").setVisible(false);
        feedtableP = new Panel().addClassName("feedtableP").setVisible(false);

        selectLB = new ListBox().addClassName("selectLB");
        newFormular = new Button("New Formular").addClassName("newFormular");
    }
}
