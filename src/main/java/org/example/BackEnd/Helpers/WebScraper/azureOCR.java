package org.example.BackEnd.Helpers.WebScraper;

import com.azure.ai.vision.imageanalysis.ImageAnalysisClient;
import com.azure.ai.vision.imageanalysis.ImageAnalysisClientBuilder;
import com.azure.ai.vision.imageanalysis.models.DetectedTextLine;
import com.azure.ai.vision.imageanalysis.models.DetectedTextWord;
import com.azure.ai.vision.imageanalysis.models.ImageAnalysisOptions;
import com.azure.ai.vision.imageanalysis.models.ImageAnalysisResult;
import com.azure.ai.vision.imageanalysis.models.VisualFeatures;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import com.azure.ai.vision.imageanalysis.models.ImageAnalysisResult;
import com.azure.ai.vision.imageanalysis.models.VisualFeatures;
import com.azure.core.credential.KeyCredential;
import com.azure.core.util.BinaryData;

import javax.imageio.ImageIO;

import org.example.BackEnd.Helpers.imageResizer;

import java.util.Arrays;

public class azureOCR {
    //Image img = OGlogo.getImage().getScaledInstance(100,99,Image.SCALE_SMOOTH);
public String OCRRequest(String str){
    imageResizer resizer = new imageResizer();
    String key = "";
    String endpoint = "https://hacknet-vision-consanjose.cognitiveservices.azure.com/";
    Image img = null;
    ImageAnalysisClient client = new ImageAnalysisClientBuilder()
    .credential(new KeyCredential(key))
    .endpoint(endpoint)
    .buildClient();

    ImageAnalysisResult result = null;
    int i = 1;
    try {
        URL imageUrl = new URL(str);
        
        BufferedImage originalImage = ImageIO.read(imageUrl);
        if(originalImage.getWidth()<50 || originalImage.getHeight()<50){
            BufferedImage newImg = resizer.imgResized(originalImage);

            ImageIO.write(newImg, "jpg", new File("src\\main\\resources\\FileImages\\image_"+ i + ".jpg"));
            i++;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
       
        ImageIO.write(newImg, "png", baos);
        byte[] bytes = baos.toByteArray();
        BinaryData binaryData = BinaryData.fromBytes(bytes);
            result = client.analyze(
            binaryData, // imageData: Image file loaded into memory as BinaryData
            Arrays.asList(VisualFeatures.READ), // visualFeatures
            null); // options: There are no options for READ visual feature
        }else{
            result = client.analyzeFromUrl(
            str, // imageUrl: the URL of the image to analyze
            Arrays.asList(VisualFeatures.READ), // visualFeatures
            new ImageAnalysisOptions().setGenderNeutralCaption(true)); // options:  Set to 'true' or 'false' (relevant for CAPTION or DENSE_CAPTIONS visual features)

        }
       
       

        
        
        






    String text = "";
   try {
    for (DetectedTextLine line : result.getRead().getBlocks().get(0).getLines()) {
        text += line.getText()+ "\n";
       

    }
   } catch (IndexOutOfBoundsException e) {
    System.out.println("no readable text ");
    return null;
   }
    

    return text;
    }
    catch(Exception e){
        e.printStackTrace();
        return null;
    }

}
}
