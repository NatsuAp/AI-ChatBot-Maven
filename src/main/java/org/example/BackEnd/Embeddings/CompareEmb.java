package org.example.BackEnd.Embeddings;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
        public static String[][] Compare(String embedding) {
            
            // Coneccion con la base de Datos

            String[][] res = new String[5][6];
            ResultSet a = null;

            try {

            PreparedStatement st = conn
            .prepareStatement("SELECT ID, Question, AnswerC, Answer, Explanation," +
            "(Embedding <=> ?::vector) AS distance " +
            "FROM preguntas " +
            "ORDER BY distance ASC " +
            "LIMIT 5");
            st.setString(1, embedding);

            // PreparedStatement st = conn
            //         .prepareStatement("SELECT ID, (Embedding <=> ?) AS distance " +
            //                 "FROM DUMMIE " +
            //                 "ORDER BY distance ASC " +
            //                 "LIMIT 5");
            // st.setString(1, embedding);
            a = st.executeQuery();
            int i = 0;
            while (a.next()) {

                for (int j = 0; j < 5; j++) {
                    res[i][j] = a.getString(j + 1); //TODO: Validar el tipo para poder utilizar el metodo especifico del tipo que se quiere hacer
                }
                i++;
            }
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
