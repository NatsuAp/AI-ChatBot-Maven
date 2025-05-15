package org.example.BackEnd.Scripts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.example.BackEnd.Embeddings.EmbeddingsRequests;

public class GettingStrings {

    org.example.BackEnd.Scripts.Sql.insert insert = new org.example.BackEnd.Scripts.Sql.insert();

    public void guardarBD() {
        String path = "src\\main\\resources\\newestData.txt";
        File file = new File(path);
        String todo = "";
        try (Scanner scanner = new Scanner(file);) {
            while (scanner.hasNextLine()) {
                todo = todo + scanner.nextLine();
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        // int c = 1;
        String[] preguntas = todo.split("#########################################################");
        // Para meter separar las preguntas y despues llamar la funcion que conecta con
        // la base de datos
        for (String x : preguntas) {
            String[] individual = x.split("###");
            System.out.println(individual[0]);
            Questions question = new Questions(individual[0], individual[1], individual[2], individual[3],
                    "Explanation: " + individual[5]);
            // Para el embedding

            System.out.println(individual[0]);
            System.out.println("ESTE PROMP TIENE " + String.valueOf(x.length()) + "LETRAS");
            insert.inserts(question, EmbeddingsRequests.getEmbedding(x));
        }
        System.out.println("LO LOGRASTE HPTAAAA");
    }
}
