package org.example.FrontEnd.Buttons;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.Border;

import org.example.BackEnd.Requests.azureOCR;
import org.example.FrontEnd.setFilechooser;
import org.example.FrontEnd.Panels.AttachPanel;

public class AttachButton {
    String dummyFile;
    File file;

    public JButton sendButton() {
        setFilechooser fl = new setFilechooser();
        JFileChooser fileChooser = fl.fileChooser();
        ImageIcon clip = new ImageIcon("src/main/resources/Images/Clip.png"); // imagen
        JButton button = new JButton(clip); // Recibe como parametro la imagen
        Border border = BorderFactory.createEmptyBorder(0, 0, 4, 7); // Declaracion parametros de borde invisible

        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false); // Para quitar los bordes, rellenos usuales del boton y dejar solo la imagen
        button.setBorder(null);
        button.setOpaque(false);

        button.addMouseListener(new MouseAdapter() { // Detector de eventos
            @Override
            public void mouseEntered(MouseEvent e) { // si pasas el mouse por el boton
                button.setFocusPainted(true);
                button.setBorder(border);
            }

            @Override
            public void mouseExited(MouseEvent e) { // Cuando quitas el mouse del boton
                button.setBorderPainted(false);
                button.setContentAreaFilled(false);
                button.setFocusPainted(false);
                button.setBorder(null);
                button.setOpaque(false);
            }

            @Override
            public void mousePressed(MouseEvent e) { // Cuando clickeas
                button.setBackground(Color.LIGHT_GRAY);
                button.setOpaque(true);

                // Aqui falta la funcion que llame a enviar cualquier imagen
            }

            public void mouseReleased(MouseEvent e) {
                button.setOpaque(false);

                int response = fileChooser.showOpenDialog(button);
                if (response == JFileChooser.APPROVE_OPTION) {
                    file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    dummyFile = file.toString();
                    AttachPanel at = new AttachPanel();
                    at.setVisible();
                    azureOCR ocr = new azureOCR();
                    // ocr.AzureRequest(String.valueOf(file));
                    File pathFile = new File("src\\main\\resources\\UserImages\\");
                   
                    // try {

                    // //Files.copy(file.toPath(), pathFile.toPath(),
                    // StandardCopyOption.REPLACE_EXISTING);

                    // } catch (IOException error) {
                    // error.printStackTrace();
                    // }
                }

            }
        });

        return button;
    }

    public void setFile() {
        if (file != null) {
            file = null;
        }
    }

    public String getFile() {
        if (dummyFile != null) {
            return dummyFile;
        }
        return null;

    }
}
