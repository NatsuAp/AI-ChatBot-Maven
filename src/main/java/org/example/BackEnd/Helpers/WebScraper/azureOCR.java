package org.example.BackEnd.Helpers.WebScraper;

import com.azure.ai.vision.imageanalysis.ImageAnalysisClient;
import com.azure.ai.vision.imageanalysis.ImageAnalysisClientBuilder;
import com.azure.ai.vision.imageanalysis.models.ImageAnalysisOptions;
import com.azure.ai.vision.imageanalysis.models.ImageAnalysisResult;
import com.azure.ai.vision.imageanalysis.models.VisualFeatures;
import com.azure.core.credential.KeyCredential;

import java.util.Arrays;

public class azureOCR {
public String OCRRequest(String str){
    String key = "";
    String endpoint = "https://hacknet-colsanjose.openai.azure.com/";


// Create a synchronous client using API key authentication
    ImageAnalysisClient client = new ImageAnalysisClientBuilder()
            .credential(new KeyCredential(key))
            .endpoint(endpoint)
            .buildClient();

    // Generate a caption for an input image buffer. This is a synchronous (blocking) call.
    // BEGIN: caption-url-snippet
    ImageAnalysisResult result = client.analyzeFromUrl(
            "https://img.crackap.com/ap/computer-science-a/br23/p0086-02.jpg", // imageUrl: the URL of the image to analyze
            Arrays.asList(VisualFeatures.READ), // visualFeatures
            new ImageAnalysisOptions().setGenderNeutralCaption(true)); // Esta linea no es necesaria pero no se como hacerle para quitarla y que siga funcionando :)

    // Print analysis results to the console
    System.out.println("Image analysis results:");
    System.out.println(" Caption:");
    System.out.println("   \"" + result.getCaption().getText() + "\", Confidence "
            + String.format("%.4f", result.getCaption().getConfidence()));
   return "   \"" + result.getCaption().getText() + "\", Confidence " + String.format("%.4f", result.getCaption().getConfidence());

}
}
