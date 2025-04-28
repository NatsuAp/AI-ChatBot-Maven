package org.example.FrontEnd.Helper;

import org.example.FrontEnd.Panels.MessagePanel;
import org.example.FrontEnd.Panels.SearchboxPanel;

public class addNewMessage {
    
    public static void addMessage(String str, String side){
        MessagePanel mp = new MessagePanel();

        mp.newMessagePanel(str, side);
        
    }
}
