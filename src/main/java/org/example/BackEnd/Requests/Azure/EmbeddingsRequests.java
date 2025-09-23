package org.example.BackEnd.Requests.Azure;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.EmbeddingItem;
import com.azure.ai.openai.models.Embeddings;
import com.azure.ai.openai.models.EmbeddingsOptions;
import com.azure.core.credential.AzureKeyCredential;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.*;

public class EmbeddingsRequests {
    static Dotenv env = Dotenv.load();
    public static String getEmbedding(String embRequest ) {
        String azureOpenaiKey = env.get("AZURE_OPENAI_KEY");
        String endpoint = env.get("AZURE_OPENAI_ENDPOINT");
        String deploymentOrModelId = "text-embedding-3-small";
        OpenAIClient client;
        client = new OpenAIClientBuilder()
                .endpoint(endpoint)
                .credential(new AzureKeyCredential(azureOpenaiKey))
                .buildClient();
//         client = new OpenAIClientBuilder()
//                .credential(new KeyCredential(env.get("OPENAI_KEY")))
//                .buildClient();
        EmbeddingsOptions embeddingsOptions = new EmbeddingsOptions(null);
        // String chunk1 = "";
       //  String chunk2 = "";
        Embeddings embeddings= null;
        try {
            embeddingsOptions = new EmbeddingsOptions(Arrays.asList(embRequest));
            embeddings = client.getEmbeddings(deploymentOrModelId, embeddingsOptions);
        } catch (Exception e) {

            // chunk1 = embRequest.substring(0, embRequest.length() / 2);
            // chunk2 = embRequest.substring(embRequest.length() / 2, embRequest.length());
            // chunk1 = embeddingsRequest(chunk1);
            // chunk2 = embeddingsRequest(chunk2);
            // System.out.println("ENTRO PERO SE SOLUCIONO");
            // return sumaEmb(chunk1, chunk2);
            System.out.println(e);
        }

        
        // "'[12.12,14.14]'"
        String emb = "[";

        for (EmbeddingItem item : embeddings.getData()) {
            for (Float embedding : item.getEmbedding()) {
                emb = emb + embedding.toString() + ",";

            }
            emb = emb.substring(0, emb.length() - 1);
            emb = emb + "]";
        }
        
        return emb;
    }


}
