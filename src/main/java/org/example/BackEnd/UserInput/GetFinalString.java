package org.example.BackEnd.UserInput;

import org.example.BackEnd.Embeddings.EmbeddingsRequests;
import org.example.BackEnd.Setup.CompareEmb;

public class GetFinalString {
    public String userInput;
    CompareEmb comp = new CompareEmb();
    EmbeddingsRequests emb = new EmbeddingsRequests();
    public String getPrompt(String userInput) {
        this.userInput = userInput;
        String prompt = userInput + " //  Here you have your examples: EXAMPLE 1 : ";
        String[][] preguntas = new String[5][5];
        int i = 1;
        for(String[] x: preguntas){
            i++;
            prompt = prompt + "EXAMPLE " + i + ":"; 
            for(String q: x){
                prompt = prompt + " " + q;
            }
        }
        System.out.println(prompt);

        
        return prompt;
        
    }
}
