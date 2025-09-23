package org.example.BackEnd.Setup;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.BackEnd.Requests.Azure.APIClient;
import org.example.BackEnd.Requests.Gemini.GeminiApi;
import org.example.BackEnd.Requests.tesseract;
import org.example.BackEnd.Scripts.Sql.querys;

public class GlobalSetup {
    public static Dotenv env;
    public static void runSetup(){
            querys.getConnection();
            env = Dotenv.load();
            APIClient.setup();
            GeminiApi.clientSetup();
            tesseract.tesseractSetup();
    }
}
