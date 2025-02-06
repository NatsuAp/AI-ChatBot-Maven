package org.example;
import org.example.BackEnd.FrameBuilder;
import org.example.BackEnd.Embeddings.EmbeddingsRequests;
import org.example.BackEnd.Helpers.WebScraper.OpenAiRequest.ImageRetrieval;
import org.example.BackEnd.Helpers.WebScraper.QuestionsParser;
import org.example.BackEnd.Helpers.WebScraper.azureOCR;
import org.example.BackEnd.Helpers.WebScraper.txtCreator;

import java.util.ArrayList;

import org.example.BackEnd.APIClient;
public class Main {
    public static void main(String[] args) {
      
        FrameBuilder in = new FrameBuilder(); // Se accede a la funcion que construye el frame
       // in.frameSetup(); //se llama a la funcion
        //APIClient temp = new APIClient();
        // temp.AIResponse();
       //QuestionsParser par = new QuestionsParser();
      // ArrayList<String> data =  par.questionParser();
      //txtCreator txt = new txtCreator();
       azureOCR ocr = new azureOCR();
       String str = ocr.OCRRequest("hello");
        // String str = txt.fileCreator(data);
       //EmbeddingsRequests emb = new EmbeddingsRequests();



        
        
    }


}