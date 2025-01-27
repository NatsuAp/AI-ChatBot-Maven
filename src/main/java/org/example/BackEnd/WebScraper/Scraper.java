package org.example.BackEnd.WebScraper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Scraper {
    
    public void scraper(){

        String path = "src\\main\\resources\\data.txt";

        File file = new File(path);
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while((line = reader.readLine())!=null){
                System.out.println(line);
                
                
            }
                
              
              
            
            
        } catch (Exception e) {
        
        }

    }
}
