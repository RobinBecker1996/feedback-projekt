package samples;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import org.dwcj.App;




public class PDFShow {
    int id = 1;
    String newpdf;
    SingletonClass sing = SingletonClass.getInstance();
    EmployeesPan emp ;
    

    public void pdfShow() {
        File pdfFile = new File(pdfclone());
        try {
            Process process = new ProcessBuilder("cmd", "/c", "start", pdfFile.getAbsolutePath()).start();
            process.waitFor();
            insertFeedback(newpdf);
        } catch (IOException | InterruptedException e) {
            App.consoleLog("pdfshow ->" + e.getMessage());
        }    
    }


    public String pdfclone() {  
        emp = new EmployeesPan();  
        try {
            newpdf = "C:/Robin/Leistungsbeurteilung"+ id + ".pdf";
            File fSrc = new File("C:/Robin/Leistungsbeurteilung.pdf"); // Quelldatei 
            File fDes = new File(newpdf); // Zieldatei
            id++;
            FileInputStream fis = new FileInputStream(fSrc); //Stream fuer Quelldatei
            FileOutputStream fos = new FileOutputStream(fDes); //Stream fuer Zieldatei
            byte buf[] = new byte[103424]; // Größe der pdf von kb in byte
            while ( fis.read(buf) != -1 ) { // solange lesen, bis EOF
                    fos.write(buf);    // Inhalt schreiben
                    fis.close();
                    fos.flush();
                    fos.close();
                }
            } catch (IOException e) {
                App.consoleLog("pdfclone ->" + e.getMessage());
            }
            return newpdf;
    }

    public void insertFeedback(String newpdf) {
        try {
            String sqlInsert = "";
            sqlInsert = "INSERT INTO Feedback (pfad, datum) value (?, CURRENT_DATE)";
            sing.pstmt = sing.con.prepareStatement(sqlInsert);
            sing.pstmt.setString(1, "C:/Robin/Leistungsbeurteilung"+ id + ".pdf");
            sing.pstmt.executeUpdate();
        } catch (SQLException e) {
            App.consoleLog("insertFeedback -> "  + e.getMessage());
        }
    }

}
    
    

