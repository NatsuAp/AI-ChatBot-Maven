package org.example.BackEnd.Helpers.WebScraper;

import com.azure.ai.vision.imageanalysis.ImageAnalysisClient;
import com.azure.ai.vision.imageanalysis.ImageAnalysisClientBuilder;
import com.azure.ai.vision.imageanalysis.models.DetectedTextLine;
import com.azure.ai.vision.imageanalysis.models.DetectedTextWord;
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
import java.util.Arrays;

public class azureOCR {
    //Image img = OGlogo.getImage().getScaledInstance(100,99,Image.SCALE_SMOOTH);
public String OCRRequest(String str){
    String key = "";
    String endpoint = "https://hacknet-vision-consanjose.cognitiveservices.azure.com/";
    Image img = null;
    try {
        URL imageUrl = new URL("https://img.crackap.com/ap/computer-science-a/br23/p0082-04.jpg");
        BufferedImage originalImage = ImageIO.read(imageUrl);
        if(originalImage.getHeight()< 50){
            img = originalImage.getScaledInstance(originalImage.getWidth(), 50, Image.SCALE_SMOOTH);
        }else{
            img = originalImage.getScaledInstance(50, originalImage.getHeight(), Image.SCALE_SMOOTH);
        }






// Create a synchronous client using API key authentication
    ImageAnalysisClient client = new ImageAnalysisClientBuilder()
            .credential(new KeyCredential(key))
            .endpoint(endpoint)
            .buildClient();


//    ImageAnalysisResult result = client.analyzeFromUrl(
//            str, // imageUrl: the URL of the image to analyze
//            Arrays.asList(VisualFeatures.READ), // visualFeatures
//            null); // options: There are no options for READ visual feature
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedImage bufferedImage = (BufferedImage) img;
        ImageIO.write(bufferedImage, "png", baos);
        byte[] bytes = baos.toByteArray();
        BinaryData binaryData = BinaryData.fromBytes(bytes);
    ImageAnalysisResult result = client.analyze(
            binaryData, // imageData: Image file loaded into memory as BinaryData
            Arrays.asList(VisualFeatures.READ), // visualFeatures
            null); // options: There are no options for READ visual feature

// Print analysis results to the console

    String text = "";
    for (DetectedTextLine line : result.getRead().getBlocks().get(0).getLines()) {
        text += line.getText()+ "\n";
        System.out.println(line.getText());

    }

    return text;
    }
    catch(Exception e){
        e.printStackTrace();
        return null;
    }

}
}
