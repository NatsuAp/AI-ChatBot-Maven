package org.example.BackEnd.Requests.Gemini;

import com.google.genai.Chat;
import com.google.genai.Client;
import io.github.cdimascio.dotenv.Dotenv;
import com.google.common.collect.ImmutableList;
import com.google.genai.types.Content;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.GoogleSearch;
import com.google.genai.types.HarmBlockThreshold;
import com.google.genai.types.HarmCategory;
import com.google.genai.types.Part;
import com.google.genai.types.SafetySetting;
import com.google.genai.types.ThinkingConfig;
import com.google.genai.types.Tool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GeminiApi {
   static Dotenv env = Dotenv.load();
    static Client client;
    static Content content;
    static Tool googleSearchTool;
    static GenerateContentConfig config;
    static ImmutableList<SafetySetting> safetySettings;

    public static void clientSetup(){
        try{
            client =  Client.builder().apiKey(env.get("GOOGLE_API_KEY")).build();

            safetySettings =
                    ImmutableList.of(
                            SafetySetting.builder()
                                    .category(HarmCategory.Known.HARM_CATEGORY_HATE_SPEECH)
                                    .threshold(HarmBlockThreshold.Known.BLOCK_ONLY_HIGH)
                                    .build(),
                            SafetySetting.builder()
                                    .category(HarmCategory.Known.HARM_CATEGORY_DANGEROUS_CONTENT)
                                    .threshold(HarmBlockThreshold.Known.BLOCK_LOW_AND_ABOVE)
                                    .build());

            content = Content.fromParts(Part.fromText("""
                        You are a helpful AI chatbot assistant specialized in answering questions related to the AP College Board Computer Science curriculum. You possess in-depth knowledge of programming concepts, algorithms, data structures, and computer science principles outlined in the AP syllabus. Your goal is to provide clear, concise, and informative responses to students seeking help with their AP Computer Science coursework.

                        Aside from user input, you will receive additional System input containing relevant facts, explanations, or answers retrieved from a knowledge base. Use this System input to ensure your answers are accurate and grounded. Always answer using the system input given to you, do not answer on your own. If you do not find sufficient information in the System input or your own understanding, respond with a brief statement of uncertainty (e.g., 'I'm not sure').

                        When answering, strictly use the context provided by the System input and your existing knowledge of AP Computer Science. Do not fabricate details or references. If older parts of the conversation become irrelevant or too large, summarize them if needed to keep answers concise. Remember to be polite, clear, and precise while assisting students with their AP Computer Science questions."""));


            googleSearchTool = Tool.builder().googleSearch(GoogleSearch.builder()).build();
            config =
                    GenerateContentConfig.builder()
                            // Sets the thinking budget to 0 to disable thinking mode
                            .thinkingConfig(ThinkingConfig.builder().thinkingBudget(0))
                            .candidateCount(1)
                            .maxOutputTokens(1024)
                            .safetySettings(safetySettings)
                            .systemInstruction(content)
                            .tools(googleSearchTool)
                            .build();
        }
        catch(Exception e){

            e.printStackTrace();

        }

    }


    public static String chat(String msg, String img) throws IOException {
        GenerateContentResponse response = null;
        if(img!=null){
            byte[] imageBytes = Files.readAllBytes(Paths.get(img));

            content = Content.fromParts(
                    Part.fromText(msg),
                    Part.fromBytes(imageBytes, "image/jpeg"));
            response = client.models.generateContent("gemini-2.5-flash", content, config);
        }else{
            response = client.models.generateContent("gemini-2.5-flash", msg, config);

        }


        return response.text();
    }
}
