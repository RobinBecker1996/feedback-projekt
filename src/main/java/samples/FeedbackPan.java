package samples;


import java.sql.SQLException;

import org.dwcj.App;
import org.dwcj.bbjplugins.gridexwidget.GridExWidget;
import org.dwcj.component.button.Button;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Panel;
import org.dwcj.ui5.calendar.UI5Calendar;
import org.dwcj.ui5.calendar.UI5CalendarDate;

import com.basiscomponents.db.ResultSet;

import org.dwcj.ui5.calendar.UI5Calendar.SelectionMode;

public class FeedbackPan {
    public Panel feedbackP;
    private Panel formularP;
    public Panel feedtableEmpP;
    private Panel feedtopP;
    private Panel centerP;
    private Panel feedbottomP;
    private Panel calendarFeedP;

    private Button newFormularbtn;
    private Button savefeedbtn;
    private Button editfeedbtn;
    private Label img;

    private Boolean feedgridB;

    SingletonClass sing = SingletonClass.getInstance();
    GridClass gridclass = new GridClass();
    GridExWidget grid = new GridExWidget();
    PDFClass pdfclass = new PDFClass();


    public void run() {

        feedgridB = false;

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
       

        newFormularbtn = new Button("New Formular").addClassName("newFormular");
        savefeedbtn = new Button("Save").addClassName("savefeedbtn");
        editfeedbtn = new Button("Edit").addClassName("editfeedbtn");
        

  
        Button pdftestbtn = new Button("\u00d6ffnen");

        pdftestbtn.onClick(e -> {
                // pdf.pdfShow();
            });

        
        feedbackP.add(feedtopP, centerP, feedbottomP);
        feedtopP.add(feedtableEmpP, calendarFeedP);

        calendarFeedP.add(calendar);
        // formularP.add(pdftestbtn);
        img = new Label("<html><img src=http://localhost:8888/Screen-Feedback.png></img></html>")
        .addClassName("pdfimg");
        formularP.add(img);
        centerP.add(formularP);
        feedbottomP.add(newFormularbtn, editfeedbtn, savefeedbtn);
    }

    

    public void gridsetup() {
        try {
            if (feedgridB == false){    
                feedtableEmpP.add(grid);
                ResultSet rs = sing.readout("SELECT * FROM Mitarbeiter");
                rs.first();
                grid.setData(rs, 1, true)
                    .autoSizeColumns();
                feedgridB = true;
            }else{
                gridrefresh();
            }
        } catch (SQLException e) {
           App.consoleLog("Gridsetup-> " + e.getMessage());
        }
    }


   public void gridrefresh(){
        try {
            ResultSet rs = sing.readout("SELECT * FROM Mitarbeiter");
            rs.first();
            grid.setData(rs, 1, true)
                .autoSizeColumns();
        } catch (SQLException e) {
            App.consoleLog("gridRefresh -> " + e.getMessage());
        }
    }

    
    
   
}
