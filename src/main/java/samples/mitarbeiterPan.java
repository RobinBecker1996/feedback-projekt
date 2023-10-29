package samples;

import org.dwcj.component.button.Button;
import org.dwcj.component.field.DateField;
import org.dwcj.component.field.NumberField;
import org.dwcj.component.field.TextField;
import org.dwcj.component.window.Panel;

public class MitarbeiterPan{
    private Panel topP;
    private Panel bottomP;
    public Panel employeesMitP; // alle panel
    private Panel tableMitP; //Tabelle
    private Panel calendarMitP; //Kaledner und TextArea
    private Panel insertP; // Formular + Button
    private Panel buttonP;

    private NumberField employeesIDNF;
    private DateField terminDF;
    private DateField addedDF;
    private TextField zielTF;
    private TextField feedbackinfo;

    private Button savebtn;
    private Button deletbtn;
    private Button createbtn;

    public boolean empB = false;

    public void run() {
        empB = true;
        // public Panel employeesMitP;
        employeesMitP = new Panel().addClassName("employeesMitP");
        // employeesMitP.add(topP, bottomP);

        tableMitP = new Panel().addClassName("tableMitP");
        calendarMitP = new Panel().addClassName("calendarMitP");
        insertP = new Panel().addClassName("insertP");
        buttonP = new Panel().addClassName("buttonP");
        topP = new Panel().addClassName("topP");
        bottomP = new Panel().addClassName("bottomP");

        employeesIDNF = new NumberField("Employees ID:").addClassName("employeesIDNF");
        terminDF = new DateField("Termin:").addClassName("terminDF");
        addedDF = new DateField("Added:").addClassName("addedDF");
        zielTF = new TextField("Goals:").addClassName("zielTF");
        feedbackinfo = new TextField("Feedback infos:").addClassName("feedbackinfo");


        savebtn = new Button("Save").addClassName("savebtn");
        deletbtn = new Button("Delet").addClassName("deletbtn");
        createbtn = new Button("Create").addClassName("createbtn");



        topP.add(tableMitP, calendarMitP);
        bottomP.add(insertP, buttonP);
        insertP.add(employeesIDNF, terminDF, addedDF, zielTF, feedbackinfo);
        buttonP.add(savebtn, deletbtn, createbtn);
        employeesMitP.add(topP, bottomP);

    }

    public void destroyPanel() {
        topP.destroy();;
        bottomP.destroy();;
        employeesMitP.destroy();;
        tableMitP.destroy();;
        calendarMitP.destroy();;
        insertP.destroy();;
        buttonP.destroy();;
    }

    public Panel getPanel(){
        return  employeesMitP;
    }

}