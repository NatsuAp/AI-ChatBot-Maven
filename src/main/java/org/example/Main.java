package org.example;

import org.example.BackEnd.*;
import org.example.BackEnd.Embeddings.EmbeddingsRequests;
import org.example.BackEnd.Helpers.GettingStrings;
import org.example.BackEnd.Requests.APIClient;
import org.example.BackEnd.Setup.*;
import org.example.FrontEnd.Buttons.AttachButton;
import org.example.FrontEnd.Panels.AttachPanel;
import org.example.FrontEnd.Panels.SearchboxPanel;
import org.example.FrontEnd.TextArea.Searchbox;

import java.util.ArrayList;

import javax.swing.JTextField;

public class Main {
    static FrameBuilder in;
    AttachButton at = new AttachButton();
    public String sendFile(){
        return at.getFile();
    }
    
    public static void main(String[] args) {

        in = new FrameBuilder(); // Se accede a la funcion que construye el frame
        in.frameSetup(); // se llama a la funcion
       
        
      
    }
    

}