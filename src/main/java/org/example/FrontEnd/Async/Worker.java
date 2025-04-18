package org.example.FrontEnd.Async;

import javax.swing.SwingWorker;

import org.example.BackEnd.input.InputHandler;
import org.example.FrontEnd.Buttons.AttachButton;
import org.example.FrontEnd.Buttons.MessageButton;
import org.example.FrontEnd.Panels.AttachPanel;
import org.example.FrontEnd.Panels.SearchboxPanel;

public class Worker {
    public static SwingWorker<Void, Void> createWorker(String input, String file) {
        return new SwingWorker<>() {

            @Override
            protected Void doInBackground() throws Exception {

                try {
                    InputHandler.Query(input, file); // Esta funcion corre el proceso de creacion de embedding del input del
                                               // usuario,
                    // lo compara y manda el request a la IA
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void done() {

                SearchboxPanel.buttonSet(true);
                
                

            }

        };
    }

}
