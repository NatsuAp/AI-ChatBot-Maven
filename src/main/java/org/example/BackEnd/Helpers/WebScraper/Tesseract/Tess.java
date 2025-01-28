package org.example.BackEnd.Helpers.WebScraper.Tesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
public class Tess {
    public String textRetrieve(String path){
        
        
        try{
            URL url = new URL(path);
            InputStream in = url.openStream();
            Tesseract tesseract = new Tesseract();
            tesseract.setDatapath("C:\\Users\\User\\AppData\\Local\\Programs\\Tesseract-OCR\\tessdata");
            tesseract.setLanguage("eng");
            tesseract.setPageSegMode(6);
            String str = tesseract.doOCR(ImageIO.read(in));
            return str;
        }
        catch(TesseractException | IOException e){
            System.out.println("Error en tesseract");
           e.printStackTrace(); 
            
        }
        return "";
    }
    
}
