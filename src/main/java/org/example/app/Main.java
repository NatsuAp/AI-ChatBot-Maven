package org.example.app;

import org.example.BackEnd.Setup.GlobalSetup;
import org.example.FrontEnd.Frame.FrameBuilder;
import java.sql.SQLException;


public class Main {
    
    public static void main(String[] args) throws SQLException {
            if(GlobalSetup.runSetup("online")){
                FrameBuilder in = new FrameBuilder(); // Se accede a la funcion que construye el frame
                in.frameSetup(); // se llama a la funcion
            }
    }
}