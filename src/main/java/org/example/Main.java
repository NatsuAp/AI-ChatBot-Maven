package org.example;
import org.example.BackEnd.*;
import org.example.BackEnd.Embeddings.EmbeddingsRequests;
import org.example.BackEnd.Helpers.GettingStrings;
import org.example.BackEnd.Requests.APIClient;
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
       String[][] str = a.Compare(ie.embeddingsRequest("Consider the  Card  and  Deck  classes below, which are used to create a  Deck of Card  objects.  public class Card\r\n" + //
                    "{\r\n" + //
                    "private String suit;\r\n" + //
                    "private String value;\r\n" + //
                    "public Card(String aSuit, String aValue)\r\n" + //
                    "{\r\n" + //
                    "suit = aSuit;\r\n" + //
                    "value = aValue;\r\n" + //
                    "//Other methods not shown.\r\n" + //
                    "}\r\n" + //
                    "public class Deck\r\n" + //
                    "ArrayList<Card> deck;\r\n" + //
                    "public Deck()\r\n" + //
                    "{\r\n" + //
                    "getCards () ;\r\n" + //
                    "}\r\n" + //
                    "public void getCards ()\r\n" + //
                    "{ /* implementation not shown */ }\r\n" + //
                    "//Other methods not shown.\r\n" + //
                    "    The programmer tests the constructor of the  Deck  class with the  DeckTester  class shown below.  public class DeckTester\r\n" + //
                    "{\r\n" + //
                    "public static void main(String[] args)\r\n" + //
                    "{\r\n" + //
                    "Deck d = new Deck() ;\r\n" + //
                    "}\r\n" + //
                    "   When the code is run, a  NullPointerException  is thrown. Which of the following could be the cause of the error? "));
          for (String strings : str[0]) {
            System.out.println(strings);
          }
        // insert in = new insert();
        // in.inserts(null, null);
      


        
        
    }


}