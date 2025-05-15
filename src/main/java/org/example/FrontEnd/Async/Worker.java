package org.example.FrontEnd.Async;

import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;
import org.example.BackEnd.input.InputHandler;
import org.example.FrontEnd.FrontHandlers.ErrorHandler;
import org.example.FrontEnd.Helper.addNewMessage;
import org.example.FrontEnd.Panels.SearchboxPanel;

public class Worker {
    private static String ans = "";
    private static int x = 0;
    
    public static SwingWorker<String, Void> createWorker(String input, String file) {
        return new SwingWorker<>() {

            @Override
            protected String doInBackground() throws Exception {

                try {
                    // Esta funcion corre el proceso de creacion de embedding del input del usuario, lo compara y manda el request a la IA
                    ans = InputHandler.Query(input, file); 
                                                           
                     
                    
                } catch (IndexOutOfBoundsException e) {
                    x = ErrorHandler.badImage();

                }

                return ans;
            }

            @Override
            protected void done() {
                SearchboxPanel.buttonSet(true);
                //Si hubo algun error durante el worker, se detiene
                if (x == 1) {
                    return;
                }
                try {
                    ans = get();
                    addNewMessage.addMessage(input, file,  "user");
                    addNewMessage.addMessage(ans, file,  "ia");
                }

                catch (InterruptedException | ExecutionException e) {
                    
                    e.printStackTrace();
                    
                    System.out.println("");
                }

            }

        };
    }

}
