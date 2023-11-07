package samples;



import org.dwcj.component.button.Button;
import org.dwcj.component.window.Panel;
import org.dwcj.ui5.calendar.UI5Calendar;
import org.dwcj.ui5.calendar.UI5Calendar.SelectionMode;

public class FeedbackPan {
    public Panel feedbackP;
    private Panel formularP;
    private Panel feedtableEmpP;
    private Panel feedtopP;
    private Panel centerP;
    private Panel feedbottomP;
    private Panel calendarFeedP;
    private Panel feedtableP;

    private Button newFormularbtn;
    private Button savefeedbtn;
    private Button editfeedbtn;




    public void run() {
        UI5Calendar calendar = new UI5Calendar();

        calendar.setSelectionMode(SelectionMode.MULTIPLE);
        calendar.setHideWeekNumbers(true);

        feedbackP = new Panel().addClassName("feedbackP").setVisible(false);
        formularP = new Panel().addClassName("formularP").setVisible(true);
        feedtableEmpP = new Panel().addClassName("feedtableEmpP").setVisible(true);
        feedtopP = new Panel().addClassName("feedtopP").setVisible(true);
        centerP = new Panel().addClassName("centerP").setVisible(true);
        feedbottomP = new Panel().addClassName("feedbottomP").setVisible(true);
        calendarFeedP = new Panel().addClassName("calendarFeedP").setVisible(true);
        feedtableP = new Panel().addClassName("feedtableP").setVisible(true);

        newFormularbtn = new Button("New Formular").addClassName("newFormular");
        savefeedbtn = new Button("Save").addClassName("savefeedbtn");
        editfeedbtn = new Button("Edit").addClassName("editfeedbtn");



        feedbackP.add(feedtopP, centerP, feedbottomP);
        feedtopP.add(feedtableEmpP);
        calendarFeedP.add(calendar);
        centerP.add(formularP, feedtableP, calendarFeedP);
        feedbottomP.add(newFormularbtn, editfeedbtn, savefeedbtn);
    }
}
