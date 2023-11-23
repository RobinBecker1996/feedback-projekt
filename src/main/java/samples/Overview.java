package samples;



import java.sql.SQLException;

import org.dwcj.App;
import org.dwcj.bbjplugins.gridexwidget.GridExWidget;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.ui5.calendar.UI5Calendar;
import org.dwcj.ui5.calendar.UI5Calendar.SelectionMode;

import com.basiscomponents.db.DataRow;
import com.basiscomponents.db.ResultSet;



public class Overview extends App{
    private Frame frame;
    private Panel navbarP;
    private Panel profilMenuP;
    private Panel menubarP;
    private Panel overviewP;
    public  Panel tableP;
    private Panel calendarP;

    private Button logoutBtn;
    private Button overviewbtn;
    private Button feedbackbtn;
    private Button employeesbtn;
    private Button menuIconbtn;
    private Label title;
    private Label basisicon;

    private boolean empTestB;
    private boolean feedTestB;
    private boolean menuBarB;
    private boolean overgridB;

    private EmployeesPan empl = new EmployeesPan();
    private FeedbackPan feed = new FeedbackPan();
    private Login log;
    private SingletonClass sing;
    public GridExWidget grid;  
    public GridExWidget feedgrid;  
    public GridExWidget ogrid;  
    public MitarbeiterClass mit;
    public GridClass gridclass = new GridClass();

    Double id;


    @Override
    public void run() throws DwcjException {
        App.setTheme("dark-pure");
        grid = new GridExWidget();
        ogrid = new GridExWidget();
        feedgrid = new GridExWidget();
        
        sing = SingletonClass.getInstance();
        log = new Login();


        empTestB = false;
        feedTestB = false;
        menuBarB = true;

        overgridB = false;
        // Ä = "/u00c4";
        // Ü = "/u00dc";
        // Ö = "/u00d6";
        // ü = "/u00fc";
        // ä = "/u00e4";
        // ö = "/u00f6";
        // ß = "/u00df";

        UI5Calendar calendar = new UI5Calendar();
        calendar.setSelectionMode(SelectionMode.MULTIPLE);
        calendar.setHideWeekNumbers(true);
      

        Button dbtest = new Button("dbtest");
       

        frame = new Frame().addClassName("frame");
        // frame.add(grid);
        title = new Label("Feedback").addClassName("title");
        basisicon = new Label("<html><img src='" + "https://i.ibb.co/1n4n1Nh/logo.png" + "'</img></html>").addClassName("basisicon");


        tableP = new Panel().addClassName("tableP");
        calendarP = new Panel().addClassName("calendarP");
        navbarP = new Panel().addClassName("navbarP").add(basisicon, title);
        menuIconbtn = new Button("<html><bbj-icon-button name='menu-2' data-drawer-toggle><bbj-icon-button></html>").addClassName("menuIconbtn");
        profilMenuP = new Panel().addClassName("profilMenuP")
        .add(menuIconbtn);
        overviewP = new Panel().addClassName("ubersichtsP");
        menubarP = new Panel().addClassName("menubarP");
        overviewbtn = new Button( "\u00dcbersicht").addClassName("ubersichtsbtn");
        feedbackbtn = new Button("Feedback").addClassName("feedbackbtn");
        employeesbtn = new Button("Mitarbeiter").addClassName("employeesbtn");

        try {
            logoutBtn = new Button("<html><bbj-icon name='logout'></bbj-icon></html>").addClassName("logoutBtn").setTheme(ButtonTheme.DANGER);
        } catch (Exception e) {
            
        }


        logoutBtn.onClick(e -> {
            frame.destroy();
            try {
                sing.closConnection();
                log.run();
            } catch (SQLException e1) {
                App.consoleLog("Logoutbtn -> " + e1.getMessage());
            }
        });


        menuIconbtn.onClick(e -> {
            menutest();
        });

        overviewbtn.onClick(e ->{
            runtest();
            feed.feedbackP.setVisible(false);
            empl.employeesMitP.setVisible(false);
            empl.backP.setVisible(false);
            overviewP.setVisible(true);
            overgridrefresh();
        });

        employeesbtn.onClick(e -> {
            runtest();
            feed.feedbackP.setVisible(false);
            overviewP.setVisible(false);
            empl.backP.setVisible(false);
            empl.employeesMitP.setVisible(true);            
            empl.gridsetup();
        });

        feedbackbtn.onClick(e -> {
            runtest();
            overviewP.setVisible(false);
            empl.employeesMitP.setVisible(false);
            empl.backP.setVisible(false);
            feed.feedbackP.setVisible(true);
            feed.gridsetup();
        });


        calendarP.add(calendar);
        overviewP.add(tableP, calendarP);
        // tableP.add(gridsetup(grid));
        frame.add(navbarP, profilMenuP, menubarP, overviewP);
        menubarP.add(overviewbtn, feedbackbtn, employeesbtn, logoutBtn);
    }

    public void runtest(){
        if (empTestB == false){
            empl.run();
            frame.add(empl.employeesMitP, empl.backP);
            empTestB = true;
        }
        if(feedTestB == false){
            feed.run();
            frame.add(feed.feedbackP);
            feedTestB = true;
        }
    }

    public void  menutest(){
        if (menuBarB == true){
            menubarP.setVisible(false);
            menuBarB = false;
        }else if (menuBarB == false){
            menubarP.setVisible(true);
            menuBarB = true;
        }
    }

//     public void gridsetup() {
//         try {
//             if (gridB == false){    
//                 empl.tableMitP.add(empl.grid);
//                 ResultSet rs = sing.readout("SELECT * FROM Mitarbeiter");
//                 rs.first();
//                 empl.grid.setData(rs, 1, true)
//                     .autoSizeColumns();
//                 gridB = true;
//                 empl.grid.onRowSelect(e -> {
//                     getID();
//                 });
//             }else{
//                 gridrefresh();
//             }
//        } catch (SQLException e) {
//            App.consoleLog("Gridsetup-> " + e.getMessage());
//        }
//    }

   
//    public void feedgridsetup() {
//         try {
//             if (feedgridB == false){    
//                 feed.feedtableEmpP.add(grid);
//                 // empl.tableMitP.add(grid);
//                 ResultSet rs = sing.readout("SELECT * FROM Mitarbeiter");
//                 rs.first();
//                 grid.setData(rs, 1, true)
//                     .autoSizeColumns();
//                 feedgridB = true;
//             }else{
//                 gridrefresh();
//             }
//        } catch (SQLException e) {
//            App.consoleLog("Gridsetup-> " + e.getMessage());
//        }
//    }

   public void ridsetup() {
        try {
            if (overgridB == false){    
                tableP.add(grid);
                ResultSet rs = sing.readout("SELECT * FROM Mitarbeiter");
                rs.first();
                grid.setData(rs, 1, true)
                    .autoSizeColumns();
                overgridB = true;
            }else{
                gridrefresh();
            }
       } catch (SQLException e) {
           App.consoleLog("Gridsetup-> " + e.getMessage());
       }
   }

//    public void getID(){
//         DataRow data = empl.grid.getSelectedRow();
//         id = Double.parseDouble(data.getFieldAsString("MitarbeiterID"));
//         empl.employeesIDNF.setValue(id); 
//    }

    public void overgridrefresh(){
    try {
        ResultSet rs = sing.readout("SELECT * FROM Mitarbeiter");
        rs.first();
        ogrid.setData(rs, 1, true)
            .autoSizeColumns();
    } catch (SQLException e) {
        App.consoleLog("gridRefresh -> " + e.getMessage());
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
