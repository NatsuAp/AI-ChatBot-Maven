package org.example.BackEnd.Embeddings;

import java.util.Arrays;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.EmbeddingItem;
import com.azure.ai.openai.models.Embeddings;
import com.azure.ai.openai.models.EmbeddingsOptions;
import com.azure.core.credential.AzureKeyCredential;

public class EmbeddingsDummie {
    public String embeddingsD(String embRequest ) {
        String azureOpenaiKey = "DbJJJ2a7jiUDtSZo4aFulZzZX2W3TPQNQvJW2gKHVL0ciZhdXyJiJQQJ99BAACHYHv6XJ3w3AAABACOGh5pr";
        String endpoint = "https://hacknet-colsanjose.openai.azure.com/";
        String deploymentOrModelId = "text-embedding-ada-002";
        OpenAIClient client;
        client = new OpenAIClientBuilder()
                .credential(new AzureKeyCredential(azureOpenaiKey))
                .endpoint(endpoint)
                .buildClient();

        EmbeddingsOptions embeddingsOptions = new EmbeddingsOptions(null);
        Embeddings embeddings= null;
        try {
            embeddingsOptions = new EmbeddingsOptions(Arrays.asList(embRequest));
            embeddings = client.getEmbeddings(deploymentOrModelId, embeddingsOptions);
        } catch (Exception e) {

        }

        
        
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

    public String sumaEmb(String emb1, String emb2) {
        String emb = "[";
        emb1 = emb1.substring(1, emb1.length() - 1);
        emb2 = emb2.substring(1, emb2.length() - 1);
        String[] emb11 = emb1.split(",");
        String[] emb22 = emb2.split(",");
        for (int i = 0; i < emb11.length; i++) {
            Float x = Float.parseFloat(emb11[i]);
            Float y = Float.parseFloat(emb22[i]);
            Float res = (x + y) / 2;
            String r = String.valueOf(res);
            emb = emb + r + ",";
        }
        emb = emb.substring(0, emb.length() - 1);
        emb = emb + "]";
        return emb;
    }
}
