package org.example.BackEnd.Setup;

public class config {
    public static String getEnv(String name) {
        String value = System.getenv(name);
        if (value == null || value.isEmpty()) {
            throw new IllegalStateException("Missing required env var: " + name);
        }
        return value;
    }
}
