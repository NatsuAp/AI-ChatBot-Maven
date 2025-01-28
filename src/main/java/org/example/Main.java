package org.example;
import org.example.BackEnd.FrameBuilder;
import org.example.BackEnd.Helpers.WebScraper.LineRemover;
import org.example.BackEnd.Helpers.WebScraper.QuestionsParser;
import org.example.BackEnd.APIClient;
import org.example.BackEnd.Helpers.*;
public class Main {
    public static void main(String[] args) {
        FrameBuilder in = new FrameBuilder(); // Se accede a la funcion que construye el frame
       // in.frameSetup(); //se llama a la funcion
        APIClient temp = new APIClient();
        // temp.AIResponse();
        QuestionsParser par = new QuestionsParser();
       String[]data =  par.questionParser();
       System.out.println(data[21]);
    }

}