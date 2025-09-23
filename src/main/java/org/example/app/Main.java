package org.example.app;


import org.example.BackEnd.Requests.tesseract;
import org.example.BackEnd.Scripts.GettingStrings;
import org.example.BackEnd.Scripts.Sql.querys;
import org.example.BackEnd.Setup.EnvManager;
import org.example.BackEnd.Setup.GlobalSetup;
import org.example.FrontEnd.Frame.FrameBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
    
    public static void main(String[] args) throws SQLException {
        try{
            GlobalSetup.runSetup();
            FrameBuilder in = new FrameBuilder(); // Se accede a la funcion que construye el frame
            in.frameSetup(); // se llama a la funcion


        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
}