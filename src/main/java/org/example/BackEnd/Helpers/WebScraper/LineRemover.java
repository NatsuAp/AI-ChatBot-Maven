package org.example.BackEnd.Helpers.WebScraper;

import java.io.*;
import java.util.ArrayList;

public class LineRemover {

    public void lineRemover() {
        String path = "src\\main\\resources\\data.txt"; // Documento de Texto con las preguntas, (Sacado con Python)
        ArrayList<String> list = new ArrayList<String>();
        File file = new File(path);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {
                line = line.strip();
                if (line != "") {
                    list.add(line);
                }

            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i));
                writer.write("\n");

            }
            writer.close();

        } catch (Exception e) {
            System.out.printf("Error in scraper\n");
            System.out.printf(e.getMessage());

        }

    }
    
}
