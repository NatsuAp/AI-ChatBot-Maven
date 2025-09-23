package org.example.BackEnd.Embeddings;

import com.pgvector.PGvector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


import static org.example.BackEnd.Scripts.Sql.querys.conn;

public class CompareEmb {
    static String urlDB = "jdbc:postgresql://hacknet.cncguc2ysbs8.us-east-1.rds.amazonaws.com:5432/HACKNETDB";
        int number;
        public CompareEmb(int number){
            this.number = number;
        }

        public int currentNumber(){
            return this.number;
        }
    
        public static String[][] Compare(String emb) {
            
            // Coneccion con la base de Datos

            String[][] res = new String[5][6];
            ResultSet a = null;

            try {

            PreparedStatement st = conn
            .prepareStatement("SELECT ID, Question, AnswerC, Answer, Explanation," +
            "1 - (Embedding <=> ?::vector) AS cosine_similarity " +
            "FROM preguntas " +
            "ORDER BY embedding <=> ?::vector " +
            "LIMIT 5");
                PGvector v = new PGvector(emb);
                st.setObject(1, v);   // for similarity column
                st.setObject(2, v);
            st.setString(1, emb);

            // PreparedStatement st = conn
            //         .prepareStatement("SELECT ID, (Embedding <=> ?) AS distance " +
            //                 "FROM DUMMIE " +
            //                 "ORDER BY distance ASC " +
            //                 "LIMIT 5");
            // st.setString(1, embedding);
                long id = 1;
                String content = "";
                double cosSim = 0;
                try (ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        id = rs.getLong("id");
                        content = rs.getString("content");
                        cosSim = rs.getDouble("cosine_similarity");

                    }

                }
                System.out.println(id);
                System.out.println("-------");
                System.out.println(content);
                System.out.println("-------");
                System.out.println(cosSim   );
            st.close();
            System.out.println(" hecho");
        } catch (SQLException e) {
            System.out.println("FALLO LA COMPARACION");
            e.printStackTrace();
        }
        // https://jdbc.postgresql.org/documentation/use/

        return res;

    }
}
