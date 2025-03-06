package org.example.BackEnd.Helpers;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.example.BackEnd.Embeddings.EmbeddingsRequests;

public class GettingStrings {
    EmbeddingsRequests emb = new EmbeddingsRequests();
    org.example.BackEnd.Setup.insert insert = new org.example.BackEnd.Setup.insert();

    public void guardarBD() {
        String path = "src\\main\\resources\\n" + //
                        "ewestData.txt";
        File file = new File(path);
        String todo = "";
        try(Scanner scanner = new Scanner(file);) {
        while(scanner.hasNextLine()){
            todo = todo+scanner.nextLine();
        }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        

        

        int c = 1;
        String[] preguntas = todo.split("#########################################################");
        String concatenado = "";
        //Para meter separar las preguntas y despues llamar la funcion que conecta con la base de datos
        for(String x: preguntas){
            
            String [] individual= x.split("###");
            System.out.println(individual[0]);
            Questions question = new Questions(individual[0], individual[1], individual[2], individual[3], "Explanation: " +individual[5]);
            //Para el embedding
            for(String q : individual){
                concatenado = q+concatenado;
            }
            concatenado = concatenado.trim();
            
            insert.inserts(question, emb.embeddingsRequest(concatenado));
            c = c+1;
        }
        System.out.println("LO LOGRASTE HPTAAAA");
    }
}
