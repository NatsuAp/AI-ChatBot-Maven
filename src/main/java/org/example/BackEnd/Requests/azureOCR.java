package org.example.BackEnd.Requests;

import java.io.File;
import java.util.Arrays;

import com.azure.ai.vision.imageanalysis.ImageAnalysisClient;
import com.azure.ai.vision.imageanalysis.ImageAnalysisClientBuilder;
import com.azure.ai.vision.imageanalysis.models.DetectedTextLine;
import com.azure.ai.vision.imageanalysis.models.DetectedTextWord;
import com.azure.ai.vision.imageanalysis.models.ImageAnalysisOptions;
import com.azure.ai.vision.imageanalysis.models.ImageAnalysisResult;
import com.azure.ai.vision.imageanalysis.models.VisualFeatures;
import com.azure.core.credential.KeyCredential;
import com.azure.core.util.BinaryData;

public class azureOCR {
    static String endpoint = "https://hacknet-vision-consanjose.cognitiveservices.azure.com/";
    static String key = "6VS8SKYPdi4ZGs3ltxYQNDdpMJEogk30g0L4N0ghqFdD0B8YWNHUJQQJ99BBACHYHv6XJ3w3AAAFACOGRYBw";

    public static String AzureRequest(String str) {
     String text="";
        // Create a synchronous client using API key authentication
        ImageAnalysisClient client = new ImageAnalysisClientBuilder()
                .endpoint(endpoint)
                .credential(new KeyCredential(key))
                .buildClient();
        ImageAnalysisResult result = client.analyze(
                BinaryData.fromFile(new File(str).toPath()), // imageData: Image file loaded into memory as BinaryData
                Arrays.asList(VisualFeatures.READ), // visualFeatures
                null); // options: There are no options for READ visual feature

        // Print analysis results to the console

        for (DetectedTextLine line : result.getRead().getBlocks().get(0).getLines()) {
            text+= line.getText() + "\n";


        }

        return text;
    }
}
