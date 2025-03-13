package org.example;
import org.example.BackEnd.*;
import org.example.BackEnd.Embeddings.EmbeddingsRequests;
import org.example.BackEnd.Helpers.GettingStrings;
import org.example.BackEnd.Requests.APIClient;
import org.example.BackEnd.Setup.*;
import java.util.ArrayList;

import javax.swing.JTextField;

public class Main {
    static FrameBuilder in;
        public static void main(String[] args) {
          
              in = new FrameBuilder(); // Se accede a la funcion que construye el frame
        in.frameSetup(); //se llama a la funcion
        

        // Table table = new Table();
        // table.createTable();

        // APIClient client = new APIClient();
        // client.Chat("tell me a joke");

        //EmbeddingsRequests ie = new EmbeddingsRequests();
        // ie.embeddingsRequest("hola mundo");

        //System.out.println(ie.embeddingsRequest());

        // GettingStrings get = new GettingStrings();
        // get.guardarBD();

//        CompareEmb a = new CompareEmb();
//       String[][] str = a.Compare(ie.embeddingsRequest());
//          for (String strings : str[0]) {
//            System.out.println(strings);
//          }
        // insert in = new insert();
        // in.inserts(null, null);
    }
   public String textGetter(){
    return in.getFieldText();
   }
}