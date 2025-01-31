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
        String azureKey = "DbJJJ2a7jiUDtSZo4aFulZzZX2W3TPQNQvJW2gKHVL0ciZhdXyJiJQQJ99BAACHYHv6XJ3w3AAABACOGh5pr";
        OpenAIClient client = new OpenAIClientBuilder()
                .credential(new KeyCredential(azureKey))
                .endpoint("https://hacknet-colsanjose.openai.azure.com/")
                .buildClient();

        List<ChatRequestMessage> chatMessages = new ArrayList<>();
        chatMessages.add(new ChatRequestSystemMessage("You are a helpful assistant that reads text in images and answers in the following format: \"This is what I see in the image: ```(Text in image)```\""));
        chatMessages.add(new ChatRequestUserMessage(Arrays.asList(
                new ChatMessageTextContentItem("What text do you see in this image"),
                new ChatMessageImageContentItem(
                        new ChatMessageImageUrl(str))
        )));

        ChatCompletionsOptions chatCompletionsOptions = new ChatCompletionsOptions(chatMessages);
        chatCompletionsOptions.setMaxTokens(2048);
        ChatCompletions chatCompletions = client.getChatCompletions(modelId, chatCompletionsOptions);
        System.out.println(chatCompletions.getChoices().get(0).getMessage().getContent());
        return chatCompletions.getChoices().get(0).getMessage().getContent();
    }
}
