package org.example.BackEnd.input;

import org.example.BackEnd.Embeddings.CompareEmb;
import org.example.BackEnd.Requests.Azure.EmbeddingsRequests;

public class GetFinalString {

    public static String getPrompt(String userInput) {
        String[][] output = new String[5][6];
        String prompt = userInput;
        String str="";
        int i = 1;
        output = CompareEmb.Compare(EmbeddingsRequests.getEmbedding(prompt));
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
