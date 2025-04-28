package org.example.FrontEnd.Async;

import javax.swing.SwingWorker;

import org.example.BackEnd.input.InputHandler;
import org.example.FrontEnd.Buttons.AttachButton;
import org.example.FrontEnd.Buttons.MessageButton;
import org.example.FrontEnd.Helper.addNewMessage;
import org.example.FrontEnd.Panels.AttachPanel;
import org.example.FrontEnd.Panels.SearchboxPanel;

public class Worker {
    static String ans="";
    public static SwingWorker<String, Void> createWorker(String input, String file) {
        return new SwingWorker<>() {

            @Override
            protected String doInBackground() throws Exception {
                
                try {
                   ans =  InputHandler.Query(input, file); // Esta funcion corre el proceso de creacion de embedding del input del
                                               // usuario,
                    // lo compara y manda el request a la IA
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return ans;
            }

            @Override
            protected void done() {
                try {
                    SearchboxPanel.buttonSet(true);

                    ans = get();
                    addNewMessage.addMessage(input, "user");
                    addNewMessage.addMessage(ans, "ia");
                    
                } catch (Exception e) {
                    // TODO: handle exception}
                    e.printStackTrace();
                }
               
                
                
            }

        };
    }

}
