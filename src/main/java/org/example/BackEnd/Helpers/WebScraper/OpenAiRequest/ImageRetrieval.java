package org.example.BackEnd.Helpers.WebScraper.OpenAiRequest;
import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.ChatCompletions;
import com.azure.ai.openai.models.ChatCompletionsOptions;
import com.azure.ai.openai.models.ChatMessageImageContentItem;
import com.azure.ai.openai.models.ChatMessageImageUrl;
import com.azure.ai.openai.models.ChatMessageTextContentItem;
import com.azure.ai.openai.models.ChatRequestMessage;
import com.azure.ai.openai.models.ChatRequestSystemMessage;
import com.azure.ai.openai.models.ChatRequestUserMessage;
import com.azure.core.credential.KeyCredential;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ImageRetrieval {
    public String ImgRequest(String str){

        //String openAIKey = "";
        String modelId = "gpt-4o-mini";
        String azureKey = "";
        OpenAIClient client = new OpenAIClientBuilder()
                .credential(new KeyCredential(azureKey))
                .endpoint("https://hacknet-colsanjose.openai.azure.com/")
                .buildClient();

        List<ChatRequestMessage> chatMessages = new ArrayList<>();
        chatMessages.add(new ChatRequestSystemMessage("You are a helpful assistant that reads text in images"));
        chatMessages.add(new ChatRequestUserMessage(Arrays.asList(
                new ChatMessageTextContentItem("What text do you see in this image"),
                new ChatMessageImageContentItem(
                        new ChatMessageImageUrl(str))
        )));

        ChatCompletionsOptions chatCompletionsOptions = new ChatCompletionsOptions(chatMessages);
        chatCompletionsOptions.setMaxTokens(2048);
        ChatCompletions chatCompletions = client.getChatCompletions(modelId, chatCompletionsOptions);

        return chatCompletions.getChoices().get(0).getMessage().getContent();
    }
}
