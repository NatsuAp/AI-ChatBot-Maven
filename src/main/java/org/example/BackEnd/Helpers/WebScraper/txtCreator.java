package org.example.BackEnd.Helpers.WebScraper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class txtCreator {
public String fileCreator(ArrayList<String> lines){
    String path = "src\\main\\resources\\Images\\newerData.txt";
    File file = new File(path);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        for (String string : lines) {
            if(lines!=null){
                writer.write(string);
                writer.newLine();
            }
           
        }
        return "Done Succesfully";
    } catch (Exception e) {
        e.printStackTrace();
        return "Something went wrong";
        
    }
}
}
