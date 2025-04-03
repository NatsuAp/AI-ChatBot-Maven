package org.example.BackEnd.Requests;
import java.util.*;



import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.*;
import com.azure.core.credential.AzureKeyCredential;
import java.sql.*;


//System.getenv("AZURE_API_KEY");
public class APIClient {

    public static void Chat(String pregunta, String dataBaseANS) {
        String apiKey = ""; 
        String url = "https://hacknet-colsanjose.openai.azure.com/";
      
        OpenAIClient client = new OpenAIClientBuilder()
                .credential(new AzureKeyCredential(apiKey))
                .endpoint(url)
                .buildClient();

        List<ChatRequestMessage> chatMessages = new ArrayList<>();
        chatMessages.add(new ChatRequestSystemMessage("You are an helpful AI Chatbot assistant specialized in answering questions related to the AP College Board Computer Science curriculum. You possess in-depth knowledge of programming concepts, algorithms, data structures, and computer science principles outlined in the AP syllabus. Your goal is to provide clear, concise, and informative responses to students seeking help with their AP Computer Science coursework. Aside from user Input you are going to receive System input which content should be related to the question the user asked, use it in order to answer the user's questions"));
        chatMessages.add(new ChatRequestUserMessage(pregunta));
        chatMessages.add(new ChatRequestAssistantMessage("This may help you: "+ dataBaseANS ));
        
        ChatCompletions chatCompletions = client.getChatCompletions("gpt-4o-mini",
                new ChatCompletionsOptions(chatMessages));
        System.out.printf("Model ID=%s is created at %s.%n", chatCompletions.getId(), chatCompletions.getCreatedAt());
        for (ChatChoice choice : chatCompletions.getChoices()) {
            ChatResponseMessage message = choice.getMessage();
            System.out.printf("Index: %d, Chat Role: %s.%n", choice.getIndex(), message.getRole());
            System.out.println("Message:");
            System.out.println(message.getContent());
        }

     }

}
