package org.example;
import org.example.BackEnd.Requests.APIClient;
import org.example.FrontEnd.Frame.FrameBuilder;

public class Main {
    
    public static void main(String[] args) {
        //String key = System.getProperty("AZURE_API_KEY");
        //System.out.println(key);
        APIClient.setup();
        FrameBuilder in = new FrameBuilder(); // Se accede a la funcion que construye el frame
        in.frameSetup(); // se llama a la funcion
    }
}