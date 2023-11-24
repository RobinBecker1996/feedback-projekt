package samples;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

public class PDFClass {

    public BufferedImage image; 

   
   public void show() throws IOException{ 
       // File file = new File("C:/Robin/Leistungsbeurteilung.pdf");
        PDDocument document = Loader.loadPDF(new File(("C:/Robin/Leistungsbeurteilung.pdf")));

        
        PDFRenderer renderer = new PDFRenderer(document);
        image = renderer.renderImageWithDPI(0, 300);
        ImageIO.write(image, "png", new File("C:/Robin/Screen-Feedback.png"));
        document.close();

        // PDDocument document = PDDocument.load(file);
    }

}
