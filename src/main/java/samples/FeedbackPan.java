package samples;


import org.dwcj.component.button.Button;
import org.dwcj.component.window.Panel;
import org.dwcj.ui5.calendar.UI5Calendar;
import org.dwcj.ui5.calendar.UI5CalendarDate;
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
        PDFShow pdf = new PDFShow();
        UI5Calendar calendar = new UI5Calendar();
        UI5CalendarDate ui5CalendarDate = new UI5CalendarDate().setValue("Nov 15, 2023");
        UI5CalendarDate ui5CalendarDate2 = new UI5CalendarDate().setValue("Nov 20, 2023");
        calendar.setDate(ui5CalendarDate);
        calendar.setDate(ui5CalendarDate2);
            


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
        

  
        Button pdftestbtn = new Button("\u00d6ffnen");

        pdftestbtn.onClick(e -> {
                pdf.pdfShow();
            });


        feedbackP.add(feedtopP, centerP, feedbottomP);
        feedtopP.add(feedtableEmpP);
        calendarFeedP.add(calendar);
        formularP.add(pdftestbtn);
        centerP.add(formularP, feedtableP, calendarFeedP);
        feedbottomP.add(newFormularbtn, editfeedbtn, savefeedbtn);
    }


   
}
