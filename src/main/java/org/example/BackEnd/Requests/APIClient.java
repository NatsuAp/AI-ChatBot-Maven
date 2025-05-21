package org.example.BackEnd.Requests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.example.BackEnd.Setup.EnvManager;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.ChatChoice;
import com.azure.ai.openai.models.ChatCompletions;
import com.azure.ai.openai.models.ChatCompletionsOptions;
import com.azure.ai.openai.models.ChatMessageImageContentItem;
import com.azure.ai.openai.models.ChatMessageImageUrl;
import com.azure.ai.openai.models.ChatMessageTextContentItem;
import com.azure.ai.openai.models.ChatRequestAssistantMessage;
import com.azure.ai.openai.models.ChatRequestMessage;
import com.azure.ai.openai.models.ChatRequestSystemMessage;
import com.azure.ai.openai.models.ChatRequestUserMessage;
import com.azure.ai.openai.models.ChatResponseMessage;
import com.azure.core.credential.AzureKeyCredential;

public class APIClient {
    static List<ChatRequestMessage> chatMessages = new ArrayList<>();

    public static void setup() {
        chatMessages.add(new ChatRequestSystemMessage(
                """
                        You are a helpful AI chatbot assistant specialized in answering questions related to the AP College Board Computer Science curriculum. You possess in-depth knowledge of programming concepts, algorithms, data structures, and computer science principles outlined in the AP syllabus. Your goal is to provide clear, concise, and informative responses to students seeking help with their AP Computer Science coursework.

                        Aside from user input, you will receive additional System input containing relevant facts, explanations, or answers retrieved from a knowledge base. Use this System input to ensure your answers are accurate and grounded. Always answer using the system input given to you, do not answer on your own. If you do not find sufficient information in the System input or your own understanding, respond with a brief statement of uncertainty (e.g., 'I'm not sure').

                        When answering, strictly use the context provided by the System input and your existing knowledge of AP Computer Science. Do not fabricate details or references. If older parts of the conversation become irrelevant or too large, summarize them if needed to keep answers concise. Remember to be polite, clear, and precise while assisting students with their AP Computer Science questions."""));
    }

    public static void addMesaggeHistory(String user, String assistant) {
        chatMessages.add(new ChatRequestUserMessage(user));
        chatMessages.add(new ChatRequestAssistantMessage(assistant));
    }

    public static String Chat(String pregunta, String dataBaseANS, String imgEncode) {

        String apiKey = EnvManager.get("AZURE_OPENAI_KEY");
        String url = EnvManager.get("AZURE_OPENAI_ENDPOINT");
        String str = "";
        OpenAIClient client = new OpenAIClientBuilder()
                .credential(new AzureKeyCredential(apiKey))
                .endpoint(url)
                .buildClient();


        if (imgEncode != null) {
            chatMessages.add(new ChatRequestUserMessage(Arrays.asList(
                    new ChatMessageTextContentItem(pregunta),
                    new ChatMessageImageContentItem(
                            new ChatMessageImageUrl("data:image/png;base64, " + imgEncode)))));
        } else {
            chatMessages.add(new ChatRequestUserMessage(pregunta));
        }
        
        chatMessages.add(new ChatRequestSystemMessage("Answers retrieved: " + dataBaseANS));

        ChatCompletions chatCompletions = client.getChatCompletions("gpt-4o-mini",
                new ChatCompletionsOptions(chatMessages));
        System.out.printf("Model ID=%s is created at %s.%n", chatCompletions.getId(), chatCompletions.getCreatedAt());
        for (ChatChoice choice : chatCompletions.getChoices()) {
            ChatResponseMessage message = choice.getMessage();
            System.out.printf("Index: %d, Chat Role: %s.%n", choice.getIndex(), message.getRole());
            System.out.println("Message:");
            str = message.getContent();
            System.out.println(str);
            

        }
        return str;
    }

}
