package samples;

import java.awt.Desktop;

import java.io.File;
import java.io.IOException;

import org.dwcj.App;

public class PDFShow {

    public void pdfShow() {
        File pdfFile = new File("C:/Robin/Leistungsbeurteilung.pdf");
            try {
                Desktop desktop = Desktop.getDesktop();
                if (desktop != null && desktop.isSupported(Desktop.Action.OPEN)) {
                        desktop.open(pdfFile);
                }else {
                    App.consoleLog("PDF-Datei kann nicht angezeigt werden!");
                }
            }
            catch (IOException ex) {
                App.consoleLog("pdf test -> " + ex.getMessage());
            }
    }
    
}
