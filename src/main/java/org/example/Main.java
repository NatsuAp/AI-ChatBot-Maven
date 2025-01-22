package org.example;
import org.example.BackEnd.FrameBuilder;
import org.example.BackEnd.APIClient;

public class Main {
    public static void main(String[] args) {
        FrameBuilder in = new FrameBuilder(); // Se accede a la funcion que construye el frame
        in.frameSetup(); //se llama a la funcion
        APIClient temp = new APIClient();
        temp.AIResponse();

    }

}