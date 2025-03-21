package org.example.BackEnd.UserInput;

import org.example.BackEnd.Embeddings.EmbeddingsRequests;


public class GetFinalString {
    public String userInput;
   
    EmbeddingsRequests emb = new EmbeddingsRequests();
    public String getPrompt(String userInput) {
        this.userInput = userInput;
        String prompt = userInput + " //  Aca tienes algunos ejemplos para que te guies con tu respuesta: EJEMPLO 1 : ";
        String[][] preguntas = new String[5][5];
        int i = 1;
        for(String[] x: preguntas){
            for(String q: x){
                prompt = prompt + " " + q;
            }
            prompt = prompt + "EJEMPLO " + i + ":"; 
        }

        
        return prompt;
        
    }
}
