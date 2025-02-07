package org.example.BackEnd.Setup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Table {
    String urlDB = "jdbc:postgresql://hacknet.cncguc2ysbs8.us-east-1.rds.amazonaws.com:5432/HACKNETDB";
public void createTable(){
  // Coneccion con la base de Datos
        Properties props = new Properties();
        //FALTA USER Y PASSWORD
        Connection conn;
        try {
            conn = DriverManager.getConnection(urlDB, props);
            Statement st = conn.createStatement();
            st.executeQuery("CREATE TABLE Data (\r\n" + //
                    "    ID Text,\r\n" + //
                    "    Question varchar(255),\r\n" + //
                    "    AnswerC varchar(255),\r\n" + //
                    "    Answer varchar(255),\r\n" + //
                    "    Explanation varchar(255)\r\n" + //
                    "    Embedding vector(1536)\r\n" + //
                    ");");
                    System.out.println("Se creo la tabla exitosamente");
        } catch (SQLException e) {
            System.out.println("No se puedo crear la tabla");
            e.printStackTrace();
        }
        // https://jdbc.postgresql.org/documentation/use/

}
}
