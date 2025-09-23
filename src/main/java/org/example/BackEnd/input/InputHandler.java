package org.example.BackEnd.input;

import org.example.BackEnd.Requests.Gemini.GeminiApi;
import org.example.BackEnd.Requests.tesseract;

import java.io.IOException;

public class InputHandler {
public static String Query(String input, String file) throws IOException {

        String finalMsg;
        String results;
        String imgStr;
        String answer;
        String encodedImg = null;
        if (input.isBlank()) {
            input = "Help me";
        }
    if (file != null) {
        imgStr = tesseract.tesseractRequest(file);
        results = GetFinalString.getPrompt(imgStr);
    } else {
        results = GetFinalString.getPrompt(input);
    }


        finalMsg="System input: " + results + "\n"+ "User input: " + input;
    System.out.println(file);
        answer = GeminiApi.chat(finalMsg, file);
        //APIClient.addMesaggeHistory(input, answer);
        return answer;
    }
}
