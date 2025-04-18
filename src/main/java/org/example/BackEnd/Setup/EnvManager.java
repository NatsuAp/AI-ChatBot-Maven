package org.example.BackEnd.Setup;

import java.util.HashMap;
import java.util.Map;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvManager {
       private static final Map<String, String> env = new HashMap<>();
    private static final Dotenv dotenv = Dotenv.load();
    private static final String[] EnvKeys = {
            "AZURE_OPENAI_KEY",
            "AZURE_OPENAI_ENDPOINT",
            "AZURE_OCR_KEY",
            "AZURE_OCR_ENDPOINT"
    };

    public static void loadEnv() {
        for (String key : EnvKeys) {
            String str = EnvManager.dotenv.get(key);
            env.put(key, str);
        }
        
    }
    public static String get(String key) {
        return env.get(key);
    }
}
