package samples;

import org.dwcj.component.button.Button;
import org.dwcj.component.field.DateField;
import org.dwcj.component.field.NumberField;
import org.dwcj.component.field.TextField;
import org.dwcj.component.window.Panel;

public class MitarbeiterPan {
    private Panel topP;
    private Panel bottomP;
    public Panel employeesP; // alle panel
    private Panel tableP; //Tabelle
    private Panel calendarP; //Kaledner und TextArea
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

    public void run() {
        employeesP = new Panel().addClassName("employeesP").setVisible(false);
        tableP = new Panel().addClassName("tableP");
        calendarP = new Panel().addClassName("calendarP");
        insertP = new Panel().addClassName("insertP");
        buttonP = new Panel().addClassName("buttonP");
        topP = new Panel().addClassName("topP");
        bottomP = new Panel().addClassName("bottomP");

        employeesIDNF = new NumberField("Employees ID").addClassName("employeesIDNF");
        terminDF = new DateField("Termin").addClassName("terminDF");
        addedDF = new DateField("Added").addClassName("addedDF");
        zielTF = new TextField("Ziele").addClassName("zielTF");
        feedbackinfo = new TextField("Feedback infos").addClassName("feedbackinfo");

        savebtn = new Button("Save").addClassName("savebtn");
        deletbtn = new Button("Delet").addClassName("deletbtn");
        createbtn = new Button("Create").addClassName("createbtn");



        insertP.add(employeesIDNF, terminDF, addedDF, zielTF, feedbackinfo);
        buttonP.add(savebtn, deletbtn, createbtn);
        topP.add(tableP, calendarP);
        bottomP.add(insertP, buttonP);
        employeesP.add(topP, bottomP);



    }

}
