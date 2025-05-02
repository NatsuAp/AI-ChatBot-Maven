package org.example.FrontEnd.Helper;

import org.example.FrontEnd.Panels.MessagePanel;
import org.example.FrontEnd.Panels.SearchboxPanel;

public class addNewMessage {
    
    public static void addMessage(String str, String side){
        //Instanciamiento de messagepanel
        MessagePanel mp = new MessagePanel();
        //Funcion de la clase crea un mensaje de panel nuevo siempre
        mp.newMessagePanel(str, side);
        
    }
}
