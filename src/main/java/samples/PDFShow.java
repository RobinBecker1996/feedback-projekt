package samples;


import java.io.File;
import java.io.IOException;
// "C:/Robin/Leistungsbeurteilung.pdf

public class PDFShow {

    public void pdfShow() {
        File pdfFile = new File("C:/Robin/feedback-projekt/src/main/resources/Leistungsbeurteilung.pdf");
        try {
            Process process = new ProcessBuilder("cmd", "/c", "start", pdfFile.getAbsolutePath()).start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
    
    

