package org.example.BackEnd.UserInput;

import org.example.BackEnd.Embeddings.CompareEmb;
import org.example.BackEnd.Embeddings.EmbeddingsRequests;

public class GetFinalString {
    public String userInput;
    String[][] output = new String[5][6];
   
    EmbeddingsRequests emb = new EmbeddingsRequests();

    public String getPrompt(String userInput) {
        this.userInput = userInput;
        String prompt = userInput;
        String str="";
        int i = 1;
        output = CompareEmb.Compare(emb.getEmbedding(prompt));
        for (String[] strings : output) {
            str = str + "Result " + i + "\n";
            for (String string : strings) {
                str = str + string +  "\n";
            }
            System.out.println(str);
            i++;
        }
        return str;

    }
}
