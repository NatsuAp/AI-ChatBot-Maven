package org.example.FrontEnd.FrontHandlers;

import javax.swing.JOptionPane;

public class ErrorHandler {
    public static int badImage() {
        JOptionPane.showMessageDialog(
                null, //
                "La imagen no tiene texto o es muy borrosa, intentalo de nuevo con una mejor imagen",
                "Error!",
                JOptionPane.WARNING_MESSAGE

        );
        return 1;
    }

}
