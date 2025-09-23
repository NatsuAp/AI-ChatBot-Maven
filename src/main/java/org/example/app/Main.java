package org.example.app;

import org.apache.commons.text.similarity.CosineSimilarity;
import org.example.BackEnd.Embeddings.CompareEmb;
import org.example.BackEnd.Requests.Azure.EmbeddingsRequests;
import org.example.BackEnd.Scripts.GettingStrings;
import org.example.BackEnd.Scripts.Sql.querys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
    
    public static void main(String[] args) throws SQLException {
//       Dotenv env = Dotenv.load();
//        APIClient.setup();
//        EnvManager.loadEnv();
//
//        if(GeminiApi.clientSetup()){
//            FrameBuilder in = new FrameBuilder(); // Se accede a la funcion que construye el frame
//            in.frameSetup(); // se llama a la funcion
//        }

    String ques = "Consider the following program description.  A programmer plans to write a program that simulates a small card game (no more than four players). Each player will have a hand of ten cards, in which each card has a suit and a value. The game will involve either adding cards to a hand or discarding cards. The first player to have zero cards left in his hand is the winner. In the simulation, as the game is in progress, each player's hand is displayed on the screen.  The programmer plans to have a short class whose  main  method has just two statements:  did not see any text  The  Game  class will have several objects: a  Display , a  Deck , a  Card , and a  PlayerGroup . The  PlayerGroup  will have a list of  Player s, and each  Player  will have a  Hand  of  Card s.  Which is a reasonable data structure for a   Hand  object? Each hand starts with ten cards, and the number of cards can only go down. There should be a mechanism for removing a card, displaying a card, and for detecting a winning hand (no cards left in it).  I Card[] hand;\n" +
            "//will initially contain 10 Cards\n" +
            "int numCards;\n" +
            "//player wins when numCards is 0\n" +
            "II boolean[] hand;\n" +
            "//will contain 52 boolean values, of which\n" +
            "//10 are initially true. All other values are false.\n" +
            "//The true values represent the cards initially in\n" +
            "//the Hand. A card is \"removed\" from the hand by\n" +
            "int numTrue;\n" +
            "//changing an array value from true to false.\n" +
            "//player wins when numTrue is 0\n" +
            "III ArrayList<Card> hand; //an ArrayList that will initially contain\n" +
            "//10 Cards. A Card is removed by removing it\n" +
            "//from the ArrayList. Player wins when hand. size() == O\n" +
            " ### A. I only  B. II only  C. III only  D. I and III only  E. I, II, and III";
        querys.getConnection();
        System.out.println(CompareEmb.Compare(EmbeddingsRequests.getEmbedding(ques)));

    }
}