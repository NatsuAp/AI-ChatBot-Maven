package org.example.BackEnd.input;

import javax.swing.ImageIcon;

import org.example.BackEnd.Helpers.Base64Coder;
import org.example.BackEnd.Requests.APIClient;
import org.example.BackEnd.Requests.azureOCR;

public class InputHandler {
     static ImageIcon arrow = new ImageIcon("src\\main\\resources\\Images\\Send.png");
public static String Query(String input, String file) { 
                                    

        String results;
        String imgStr;
        String answer;
        String encodedImg = null;
        if (input.isBlank()) {
            input = "Help me";
        }

        if (file != null) {
            encodedImg = Base64Coder.encode(file);
            imgStr = azureOCR.OcrRequest(file);
            results = GetFinalString.getPrompt(imgStr);
        } else {
            results = GetFinalString.getPrompt(input);
        }

        answer = APIClient.Chat(input, results, encodedImg);
        APIClient.addMesaggeHistory(input, answer);
        return answer;
    }
}
