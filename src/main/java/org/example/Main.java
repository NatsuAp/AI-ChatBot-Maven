package org.example;
import org.example.BackEnd.*;
import org.example.BackEnd.Embeddings.EmbeddingsRequests;
import org.example.BackEnd.Helpers.GettingStrings;
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

        EmbeddingsRequests ie = new EmbeddingsRequests();
        // ie.embeddingsRequest("hola mundo");

        //System.out.println(ie.embeddingsRequest());

        // GettingStrings get = new GettingStrings();
        // get.guardarBD();

        CompareEmb a = new CompareEmb();
        a.Compare(ie.embeddingsRequest("""
                Question: 1 ### 1.  Which of the following pairs of declarations will cause an error message?  I. double x = 14.7;
int y = x;
  II. double x = 14.7;
int y = (int) x;
  III. int x = 14;
double y = x;
 ### A. None  B. I only  C. II only  D. III only  E. I and III only ### Correct Answer:  B ### Explanation: ### When  x  is converted to an integer, as in segment I, information is lost. Java requires that an explicit cast to an  int  be made, as in segment II. Note that segment II will cause  x  to be truncated: The value stored in  y  is  14 . By requiring the explicit cast, Java doesnât let you do this accidentally. In segment III,  y  will contain the value  14.0 . No explicit cast to a  double  is required since no information is lost. ### 

                """));
        // insert in = new insert();
        // in.inserts(null, null);
      


        
        
    }


}