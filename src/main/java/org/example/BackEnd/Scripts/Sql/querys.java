package org.example.BackEnd.Scripts.Sql;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;


import com.openai.models.embeddings.Embedding;
import com.pgvector.PGvector;
import io.github.cdimascio.dotenv.Dotenv;

public class querys {
    static Dotenv env = Dotenv.load();
    public static Connection conn = null;

    public static boolean  getConnectionLocal() {

        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres",env.get("SQLPASSWORD"));
            PGvector.addVectorType(conn);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }
    public static boolean  getConnectionOnline() {

        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://chatdata.postgres.database.azure.com:5432/postgres?user="+env.get("SQLUSER")+"&password="+env.get("SQLPASSWORD")+"&sslmode=require");
            PGvector.addVectorType(conn);
            return true;
        } catch (Exception e) {
            System.out.println("error de conexion");
            System.out.println(e);
            return false;
        }

    }

    public static void create(){
        Statement statement;

        String query = "CREATE EXTENSION IF NOT EXISTS vector";

        try {
            statement = conn.createStatement();
            statement.executeUpdate(query);
            PGvector.registerTypes(conn);
            query = "create table preguntas (ID TEXT, Question TEXT, AnswerC TEXT, Answer TEXT, Explanation TEXT, Embedding VECTOR(1536))";

            statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void inserts() throws SQLException {
        ArrayList<String> arr = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/Data/dataFile.txt")))) {
            String line;
            while((line = reader.readLine())!=null){
                arr.add(line);
            }
            for(int i = 0; i<arr.size();i=i+2){
                line = arr.get(i);
                String parts[] = line.split(" ### ");
                PreparedStatement st = conn
                        .prepareStatement("INSERT INTO preguntas (ID, Question, AnswerC, Answer, Explanation, Embedding) VALUES (?, ?, ?, ?, ?, ?::vector)");
                st.setString(1, parts[0].trim());
                st.setString(2, parts[1].trim());
                st.setString(3, parts[2].trim());
                st.setString(4, parts[3].trim());
                st.setString(5, parts[4].trim());
                st.setString(6, parts[5].trim());
                st.executeUpdate();
                st.close();
            }





        } catch (SQLException e) {
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("ErrorCode: " + e.getErrorCode());
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // https://jdbc.postgresql.org/documentation/use/

    }

    public static void select() throws SQLException{
        String query = "select * from preguntas";

        try {
            PreparedStatement st = conn.prepareStatement(query);
                st.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
