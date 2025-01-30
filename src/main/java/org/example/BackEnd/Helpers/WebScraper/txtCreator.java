package org.example.BackEnd.Helpers.WebScraper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class txtCreator {
public String fileCreator(String[] lines){
    String path = "src\\main\\resources\\Images\\newerData.txt";
    File file = new File(path);
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        for (String string : lines) {
            writer.write(string);
            writer.newLine();
        }
        return "Done Succesfully";
    } catch (Exception e) {
        e.printStackTrace();
        return "Something went wrong";
        
    }
}
}
