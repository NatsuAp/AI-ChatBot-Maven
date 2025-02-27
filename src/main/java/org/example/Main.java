package org.example;
import org.example.BackEnd.*;
import org.example.BackEnd.Embeddings.EmbeddingsRequests;
import org.example.BackEnd.Helpers.GettingStrings;
import org.example.BackEnd.Setup.Table;
import org.example.BackEnd.APIClient;
import org.example.BackEnd.FrameBuilder;
import org.example.BackEnd.Setup.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      
        // FrameBuilder in = new FrameBuilder(); // Se accede a la funcion que construye el frame
        // in.frameSetup(); //se llama a la funcion
        

        // Table table = new Table();
        // table.createTable();
        // APIClient client = new APIClient();
        // client.Chat("tell me a joke");
        // EmbeddingsRequests ie = new EmbeddingsRequests();
        // ie.embeddingsRequest("hola mundo");
        //System.out.println(ie.embeddingsRequest());

        GettingStrings get = new GettingStrings();
        get.guardarBD();
       
      


        
        
    }


}