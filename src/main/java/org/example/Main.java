package org.example;

import org.example.BackEnd.*;
import org.example.BackEnd.Requests.APIClient;

public class Main {
    public static FrameBuilder in;
    public static void main(String[] args) {
        APIClient.setup();
        in = new FrameBuilder(); // Se accede a la funcion que construye el frame
        in.frameSetup(); // se llama a la funcion
       
        
      
    }
    

}