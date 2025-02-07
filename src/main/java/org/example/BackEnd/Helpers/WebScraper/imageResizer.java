package org.example.BackEnd.Helpers.WebScraper;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class imageResizer {

    //clase para subir las dimensiones de las imagenes para azureOCR

    public BufferedImage imgResized(BufferedImage img){
        BufferedImage outputImage = null;
        if(img.getWidth()<49 && img.getHeight() < 49){
            Image resultingImage = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                outputImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = outputImage.createGraphics();
                g2d.drawImage(resultingImage, 0, 0, null);
                g2d.dispose();
        }
        
        if(img.getHeight()<50){
            
            Image resultingImage = img.getScaledInstance(img.getWidth(), 50, Image.SCALE_SMOOTH);
            outputImage = new BufferedImage(img.getWidth(), 50, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = outputImage.createGraphics();
            g2d.drawImage(resultingImage, 0, 0, null);
            g2d.dispose();
        }else{
            if(img.getWidth()<50){
            
                Image resultingImage = img.getScaledInstance(50, img.getHeight(), Image.SCALE_SMOOTH);
                outputImage = new BufferedImage(50, img.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = outputImage.createGraphics();
                g2d.drawImage(resultingImage, 0, 0, null);
                g2d.dispose();
            }
                
            
        }
            
        
        
        return outputImage;
    }
}
