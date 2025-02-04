package org.example.BackEnd.Embeddings;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.EmbeddingItem;
import com.azure.ai.openai.models.Embeddings;
import com.azure.ai.openai.models.EmbeddingsOptions;
import com.azure.ai.openai.models.EmbeddingsUsage;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.Configuration;

import java.util.Arrays;
public class EmbeddingsRequests {
public void embeddingsRequest(){
    String azureOpenaiKey = "";
    String endpoint = "https://hacknet-colsanjose.openai.azure.com/";
    String deploymentOrModelId = "text-embedding-ada-002";

    OpenAIClient client = new OpenAIClientBuilder()
        .credential(new AzureKeyCredential(azureOpenaiKey))
        .endpoint(endpoint)
        .buildClient();

    EmbeddingsOptions embeddingsOptions = new EmbeddingsOptions(Arrays.asList("Zelaya cv"));

    Embeddings embeddings = client.getEmbeddings(deploymentOrModelId, embeddingsOptions);

    for (EmbeddingItem item : embeddings.getData()) {
        System.out.printf("Index: %d.%n", item.getPromptIndex());
        System.out.println("Embedding as base64 encoded string: " +  item.getEmbeddingAsString());
        System.out.println("Embedding as list of floats: ");
        for (Float embedding : item.getEmbedding()) {
            System.out.printf("%f;", embedding);
        }
    }

    EmbeddingsUsage usage = embeddings.getUsage();
    System.out.printf(
        "Usage: number of prompt token is %d and number of total tokens in request and response is %d.%n",
        usage.getPromptTokens(), usage.getTotalTokens());
}
}
