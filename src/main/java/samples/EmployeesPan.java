package samples;

import org.dwcj.component.button.Button;
import org.dwcj.component.field.DateField;
import org.dwcj.component.field.NumberField;
import org.dwcj.component.field.TextField;
import org.dwcj.component.window.Panel;
import org.dwcj.ui5.calendar.UI5Calendar;
import org.dwcj.ui5.calendar.UI5Calendar.SelectionMode;

public class EmployeesPan{
    public Panel employeesMitP; // alle panel
    private Panel topP;
    private Panel bottomP;
    private Panel tableMitP; //Tabelle
    private Panel calendarMitP; //Kaledner und TextArea
    private Panel insertP; // Formular + Button
    private Panel buttonP;

    public Panel backP;
    private Panel twoTopP;
    private Panel oneEmptableP;
    private Panel empCenterP;
    private Panel empFormP;
    private Panel schwerpunkP;
    private Panel twocalendarP;
    private Panel twoBottomP;
    private Panel twoBtnP;
    private Panel backBtnP;

    private NumberField employeesIDNF;
    private DateField terminDF;
    private DateField addedDF;
    private TextField zielTF;
    private TextField feedbackinfo;

    private Button savebtn;
    private Button deletbtn;
    private Button createbtn;

    private Button testEmpTablebtn;
    private Button editbtn;
    private Button backBtn;



    public void run() {
        UI5Calendar calendar = new UI5Calendar();

        calendar.setSelectionMode(SelectionMode.MULTIPLE);
        calendar.setHideWeekNumbers(true);

        employeesMitP = new Panel().addClassName("employeesMitP").setVisible(false);
        tableMitP = new Panel().addClassName("tableMitP").setVisible(true);
        calendarMitP = new Panel().addClassName("calendarMitP").setVisible(true);
        insertP = new Panel().addClassName("insertP").setVisible(true);
        buttonP = new Panel().addClassName("buttonP").setVisible(true);
        topP = new Panel().addClassName("topP").setVisible(true);
        bottomP = new Panel().addClassName("bottomP").setVisible(true);

        employeesIDNF = new NumberField("Employees ID:").addClassName("employeesIDNF");
        terminDF = new DateField("Termin:").addClassName("terminDF");
        addedDF = new DateField("Added:").addClassName("addedDF");
        zielTF = new TextField("Goals:").addClassName("zielTF");
        feedbackinfo = new TextField("Feedback infos:").addClassName("feedbackinfo");


        backP = new Panel().addClassName("backP").setVisible(false);
        twoTopP = new Panel().addClassName("twoTopP");
        oneEmptableP = new Panel().addClassName("oneEmptableP");
        empCenterP = new Panel().addClassName("empCenterP");
        empFormP = new Panel().addClassName("empFormP");
        schwerpunkP = new Panel().addClassName("schwerpunkP");
        twocalendarP = new Panel().addClassName("calendarP");
        twoBottomP = new Panel().addClassName("twoBottomP");
        twoBtnP = new Panel().addClassName("twoBtnP");
        backBtnP = new Panel().addClassName("backBtnP");


        editbtn = new Button("Edit");
        backBtn = new Button("<<");

        backBtn.onClick(e -> {
            backP.setVisible(false);
            employeesMitP.setVisible(true);
        });

        testEmpTablebtn = new Button("test")
                    .onClick(e -> {
                        employeesMitP.setVisible(false);
                        backP.setVisible(true);
                    });


        savebtn = new Button("Save").addClassName("savebtn");
        deletbtn = new Button("Delet").addClassName("deletbtn");
        createbtn = new Button("Create").addClassName("createbtn");


        calendarMitP.add(calendar);
        topP.add(tableMitP, calendarMitP);
        bottomP.add(insertP, buttonP);
        tableMitP.add(testEmpTablebtn);
        insertP.add(employeesIDNF, terminDF, addedDF, zielTF, feedbackinfo);
        buttonP.add(savebtn, deletbtn, createbtn);
        employeesMitP.add(topP, bottomP);

        // Zweites Panel "info Panel"
        backP.add(twoTopP, empCenterP, twoBottomP);
        twoTopP.add(oneEmptableP);
        empCenterP.add(empFormP, schwerpunkP, twocalendarP);
        // twoBottomP.add(editbtn);
        twoBottomP.add(twoBtnP, backBtnP);
        backBtnP.add(backBtn);
        twoBtnP.add(editbtn);


    }


}