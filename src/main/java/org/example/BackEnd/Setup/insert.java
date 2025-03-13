package org.example.BackEnd.Setup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.example.BackEnd.Embeddings.EmbeddingsDummie;
import org.example.BackEnd.Helpers.Questions;

public class insert {
    String urlDB = "jdbc:postgresql://hacknet.cncguc2ysbs8.us-east-1.rds.amazonaws.com:5432/HACKNETDB";
    EmbeddingsDummie emb = new EmbeddingsDummie();
    public void inserts(Questions question, String embedding) {
        // Coneccion con la base de Datos
        Properties props = new Properties();
        props.setProperty("user", "hacknet_colsanjose");
        props.setProperty("password", "235711");
        props.setProperty("stringtype", "unspecified");
        // FALTA USER Y PASSWORD
        //
       // String[] a = new String[] {"Mat", "Fis", "Comp", "Ing", "Esp", "EdF", "Art", "Leng", "Soc", "Lit", "Calc", "Est", "Per", "Hon", "Sql"};

        Connection conn;
        try {
            conn = DriverManager.getConnection(urlDB, props);
            PreparedStatement st = conn
                    .prepareStatement("INSERT INTO DATA (ID, Question, AnswerC, Answer, Explanation, Embedding) VALUES (?, ?, ?, ?, ?, ?)");
            st.setString(1, question.ID.trim());
            st.setString(2, question.Question.trim());
            st.setString(3, question.AnswerC.trim());
            st.setString(4, question.Answer.trim());
            st.setString(5, question.Explanation.trim());
            st.setString(6, embedding.trim());
            st.executeUpdate();
            st.close();

            // for(String x: a){
            //     PreparedStatement st = conn
            //          .prepareStatement("INSERT INTO DUMMIE (ID, Embedding) VALUES (?, ?)");
            //     st.setString(1, x);
            //     st.setString(2, emb.embeddingsD(x).trim());
            //     st.executeUpdate();
            //     st.close();
            // System.out.println("Insert hecho");
            // }
            
            
        } catch (SQLException e) {
            System.out.println("FALLO EL INSERT");
            e.printStackTrace();
        }
        // https://jdbc.postgresql.org/documentation/use/

    }
}
