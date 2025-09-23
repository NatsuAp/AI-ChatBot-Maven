package org.example.BackEnd.Requests;

import net.sourceforge.tess4j.Tesseract;

import java.io.File;

public class tesseract {
    public static Tesseract tesseract;
    public static void tesseractSetup(){
        tesseract = new Tesseract();
        tesseract.setDatapath("src/main/resources/tesseract/Tess4J/tessdata");
    }
    public static String tesseractRequest(String file){
        String text;
        try{
            text = tesseract.doOCR(new File(file));
            return text;
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

}
