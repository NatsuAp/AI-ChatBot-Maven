package org.example.BackEnd.Scripts;

import java.io.*;
import java.util.ArrayList;

public class getDataFile {

    public static void run(){

        String full = "";
        File datafile = new File("src/main/resources/Data/newestData.txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(datafile))){

            String line;
            while((line = reader.readLine()) != null){
                full += line;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        File file = new File("src/main/resources/DataFile.txt");
        ArrayList<String> questionsArr = new ArrayList<>();
        String[] preguntas = full.split("#########################################################");

        for (String x : preguntas) {
            String[] individual = x.split("###");
            System.out.println(individual[0]);
            Questions question = new Questions(individual[0], individual[1], individual[2], individual[3],
                    "Explanation: " + individual[5]);

        }
        try(FileWriter writer = new FileWriter(file)){
            System.out.println("");
        }catch(Exception e){
            System.out.println(e);
        }

}}
