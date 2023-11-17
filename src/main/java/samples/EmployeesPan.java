package samples;

import java.sql.SQLException;
import java.text.ParseException;

import org.dwcj.App;
import org.dwcj.bbjplugins.gridexwidget.GridExWidget;
import org.dwcj.component.button.Button;
import org.dwcj.component.field.TextField;
import org.dwcj.component.field.DateField;
import org.dwcj.component.field.NumberField;
import org.dwcj.component.window.Panel;

// import org.dwcj.ui5.calendar.UI5Calendar;
// import org.dwcj.ui5.calendar.UI5Calendar.SelectionMode;

import com.basiscomponents.db.DataRow;
import com.basiscomponents.db.ResultSet;

public class EmployeesPan{
    public Panel employeesMitP; // alle panel
    private Panel topP;
    private Panel bottomP;
    public Panel tableMitP; //Tabelle
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
    private Panel threeBtnP;
    private Panel backBtnP;
    
    public NumberField employeesIDNF;
    public TextField vornameTf;
    public TextField nachnameTf;
    public TextField feedbackTf;
    public DateField terminDF;
    public DateField hinzugefuegtField;
    public TextField zielTF;
    public TextField schwerpunktTf;

    private Button savebtn;
    private Button deletbtn;
    private Button createbtn;

    private Button testEmpTablebtn;
    private Button editbtn;
    private Button backBtn;


    SingletonClass sing;
    Query query;
    GridExWidget grid ;
    MitarbeiterClass mit;

    public void run() {
        // UI5Calendar calendar = new UI5Calendar();

        // calendar.setSelectionMode(SelectionMode.MULTIPLE);
        // calendar.setHideWeekNumbers(true);

        sing = SingletonClass.getInstance();
        query = new Query();

        threeBtnP = new Panel().addClassName("threeBtnP");
        employeesMitP = new Panel().addClassName("employeesMitP").setVisible(false);
        tableMitP = new Panel().addClassName("tableMitP").setVisible(true);
        calendarMitP = new Panel().addClassName("calendarMitP").setVisible(true);
        insertP = new Panel().addClassName("insertP").setVisible(true);
        buttonP = new Panel().addClassName("buttonP").setVisible(true);
        topP = new Panel().addClassName("topP").setVisible(true);
        bottomP = new Panel().addClassName("bottomP").setVisible(true);

        employeesIDNF = new  NumberField("Employees ID:").addClassName("employeesIDNF");
        vornameTf = new TextField("Vorname").addClassName("vornameTf");
        nachnameTf = new TextField("Nachname").addClassName("nachnameTf");
        feedbackTf = new TextField("Feedback").addClassName("feedbackTf");
        terminDF = new DateField("Termin").addClassName("terminDF");
        hinzugefuegtField = new DateField("Hinzugefügt").addClassName("hinzugefuegtField");
        zielTF = new TextField("Goals:").addClassName("zielTF");
        schwerpunktTf = new TextField("Schwerpunkt").addClassName("schwerpunktTf");


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
        savebtn.onClick(e -> {
                update();
        });

        deletbtn = new Button("Delet").addClassName("deletbtn");
        deletbtn.onClick(e -> {
            deleteDataRow();
        });

        createbtn = new Button("Create").addClassName("createbtn");
        createbtn.onClick(e -> {
                create();
        });


        // calendarMitP.add(calendar);
        topP.add(tableMitP, calendarMitP);
        bottomP.add(insertP, threeBtnP, buttonP);
        tableMitP.add(testEmpTablebtn);
        insertP.add(employeesIDNF,  vornameTf, nachnameTf);
        threeBtnP.add(feedbackTf, terminDF);
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


    public void update(){ 
        query.updateEmp(genDataRow()); 
    }


    public void create() {      
        query.create(genDataRow());
    }


    public void felderfuellen(){
        ResultSet rs;
        try {
            rs = sing.readout("Select * from Mitarbeiter");
            DataRow data = rs.get(0);
            mit = new MitarbeiterClass(data);
            employeesIDNF.setText(data.getFieldAsString("MitarbeiterID"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public DataRow genDataRow() { 
        DataRow data = new DataRow();
        try {
            data.setFieldValue("MitarbeiterID", employeesIDNF.getText());
            data.setFieldValue("Vorname", vornameTf.getText());
            data.setFieldValue("Nachname", nachnameTf.getText());
            data.setFieldValue("Feedback", feedbackTf.getText());
            data.setFieldValue("Termin", terminDF.getText());
            data.setFieldValue("Ziele", "");
            data.setFieldValue("Schwerpunkt", "");
        } catch (ParseException e) {
            App.consoleLog("genDataRow ->" + e.getMessage());
        }
        return data;
    }

    public void deleteDataRow() {
        Double id = employeesIDNF.getValue();
        query.delete(id);
    }

    public void gridsetup() {
        try { 
            grid = new GridExWidget();
            ResultSet rs = sing.readout("SELECT * FROM Mitarbeiter");
            rs.first();
            grid.setData(rs, 1, true)
                .autoSizeColumns();
       } catch (SQLException e) {
           App.consoleLog("Gridsetup-> " + e.getMessage());
       }
   }

    
}