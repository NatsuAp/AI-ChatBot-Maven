package org.example.FrontEnd.Async;

import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.example.BackEnd.input.InputHandler;
import org.example.FrontEnd.ErrorHandler;
import org.example.FrontEnd.Buttons.AttachButton;
import org.example.FrontEnd.Buttons.MessageButton;
import org.example.FrontEnd.Helper.addNewMessage;
import org.example.FrontEnd.Panels.AttachPanel;
import org.example.FrontEnd.Panels.SearchboxPanel;

public class Worker {
    private static String ans = "";
    private static int x = 0;

    public static SwingWorker<String, Void> createWorker(String input, String file) {
        return new SwingWorker<>() {

            @Override
            protected String doInBackground() throws Exception {

                try {
                    ans = InputHandler.Query(input, file); // Esta funcion corre el proceso de creacion de embedding del
                                                           // input del
                    // usuario,
                    // lo compara y manda el request a la IA
                } catch (IndexOutOfBoundsException e) {
                    x = ErrorHandler.badImage();

                }

                return ans;
            }

            @Override
            protected void done() {
                SearchboxPanel.buttonSet(true);
                if (x == 1) {
                    return;
                }
                try {
                    ans = get();
                    addNewMessage.addMessage(input, "user");
                    addNewMessage.addMessage(ans, "ia");
                }

                catch (InterruptedException | ExecutionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        };
    }

}
