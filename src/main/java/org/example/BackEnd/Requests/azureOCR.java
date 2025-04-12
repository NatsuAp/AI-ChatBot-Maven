package org.example.BackEnd.Requests;

import java.io.File;
import java.util.Arrays;

import com.azure.ai.vision.imageanalysis.ImageAnalysisClient;
import com.azure.ai.vision.imageanalysis.ImageAnalysisClientBuilder;
import com.azure.ai.vision.imageanalysis.models.DetectedTextLine;
import com.azure.ai.vision.imageanalysis.models.ImageAnalysisResult;
import com.azure.ai.vision.imageanalysis.models.VisualFeatures;
import com.azure.core.credential.KeyCredential;
import com.azure.core.util.BinaryData;

import io.github.cdimascio.dotenv.Dotenv;

public class azureOCR {
    static Dotenv dotenv = Dotenv.load();
    static String endpoint = dotenv.get("AZURE_OCR_ENDPOINT");
    static String key = dotenv.get("AZURE_OCR_KEY");
 
    public static String AzureRequest(String str) {
        String text = "";
        // Creacion cliente
        ImageAnalysisClient client = new ImageAnalysisClientBuilder()
                .endpoint(endpoint)
                .credential(new KeyCredential(key))
                .buildClient();
        ImageAnalysisResult result = client.analyze(
                BinaryData.fromFile(new File(str).toPath()), // Carga la imagen como datos binarios
                Arrays.asList(VisualFeatures.READ),
                null);
        //Concatenar el texto en la imagen
        for (DetectedTextLine line : result.getRead().getBlocks().get(0).getLines()) {
            text += line.getText() + "\n";

        }

        return text;
    }
}
