package org.example.BackEnd.Scripts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.example.BackEnd.Requests.EmbeddingsRequests;
import org.example.BackEnd.Scripts.Sql.querys;

public class GettingStrings {

    querys insert = new querys();

    public static void guardarBD() {
        String path = "src/main/resources/Data/newestData.txt";
        File file = new File(path);
        String todo = "";
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                todo += scanner.nextLine();
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        // int c = 1;
        String[] preguntas = todo.split("#########################################################");
        // Para meter separar las preguntas y despues llamar la funcion que conecta con
        // la base de datos
        ArrayList<String> arr = new ArrayList<>();
        for (String x : preguntas) {
            String[] individual = x.split("###");
            System.out.println(individual[0]);
            Questions question = new Questions(individual[0], individual[1], individual[2], individual[3],
                    "Explanation: " + individual[5]);
            // Para el embedding

            System.out.println(individual[0]);
            System.out.println("ESTE PROMP TIENE " + String.valueOf(x.length()) + "LETRAS");
            arr.add(question.ID + " ### " + question.Question + " ### "+
                    question.AnswerC + " ### " + question.Answer + " ### " +
                    question.Explanation + " ### " + EmbeddingsRequests.getEmbedding(x));

        }
        try(FileWriter writer = new FileWriter("src/main/resources/Data/dataFile.txt")){
            //querys.inserts(question, EmbeddingsRequests.getEmbedding(x));
            for(String x : arr) {
                writer.write(x);
                writer.write("\n");
                writer.write("##################################");
                writer.write("\n");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("acabo exitosamente");
    }
}
