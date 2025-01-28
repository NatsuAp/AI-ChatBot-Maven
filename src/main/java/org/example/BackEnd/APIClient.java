package org.example.BackEnd;
import java.util.*;


import java.util.*;
import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.*;
import com.azure.core.credential.AzureKeyCredential;
import java.sql.*;



public class APIClient {

    public void Chat(String pregunta) {
        String apiKey = "";
        String url = "https://hacknet-colsanjose.openai.azure.com/";
        String urlDB = "jdbc:postgresql://hacknet.cncguc2ysbs8.us-east-1.rds.amazonaws.com:5432/HACKNETDB";

        // Coneccion con la base de Datos
        Properties props = new Properties();
        //FALTA USER Y PASSWORD
        Connection conn;
        try {
            conn = DriverManager.getConnection(urlDB, props);
            Statement st = conn.createStatement();
            st.executeQuery("CREATE TABLE AfanaProfe (\r\n" + //
                    "    PersonID int,\r\n" + //
                    "    LastName varchar(255),\r\n" + //
                    "    FirstName varchar(255),\r\n" + //
                    "    Address varchar(255),\r\n" + //
                    "    City varchar(255)\r\n" + //
                    ");");
        } catch (SQLException e) {
            System.out.println("no funciono brou");
            e.printStackTrace();
        }
        // https://jdbc.postgresql.org/documentation/use/


        OpenAIClient client = new OpenAIClientBuilder()
                .credential(new AzureKeyCredential(apiKey))
                .endpoint(url)
                .buildClient();

        List<ChatRequestMessage> chatMessages = new ArrayList<>();
        chatMessages.add(new ChatRequestSystemMessage("pregunta"));

        ChatCompletions chatCompletions = client.getChatCompletions("gpt-4o-mini",
                new ChatCompletionsOptions(chatMessages));
        System.out.printf("Model ID=%s is created at %s.%n", chatCompletions.getId(), chatCompletions.getCreatedAt());
        for (ChatChoice choice : chatCompletions.getChoices()) {
            ChatResponseMessage message = choice.getMessage();
            System.out.printf("Index: %d, Chat Role: %s.%n", choice.getIndex(), message.getRole());
            System.out.println("Message:");
            System.out.println(message.getContent());
        }

     }

}
