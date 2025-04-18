package org.example.app;
import org.example.BackEnd.Requests.APIClient;
import org.example.BackEnd.Setup.EnvManager;
import org.example.FrontEnd.Frame.FrameBuilder;



public class Main {
    
    public static void main(String[] args) {
       
        APIClient.setup();
        EnvManager.loadEnv();
        FrameBuilder in = new FrameBuilder(); // Se accede a la funcion que construye el frame
        in.frameSetup(); // se llama a la funcion
       
    }
}