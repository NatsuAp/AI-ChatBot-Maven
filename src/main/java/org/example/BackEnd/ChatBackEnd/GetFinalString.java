package org.example.BackEnd.ChatBackEnd;

public class GetFinalString {
    public String main(String[] emb, String userInput) {
        String concatenado = "";
        for(String x: emb){
            concatenado = x + "--" + concatenado;
        }
        String res = userInput + "Aca tienes algunos ejemplos de preguntas similares para que tengas una guia" + concatenado;
        return "";
        
    }
}
