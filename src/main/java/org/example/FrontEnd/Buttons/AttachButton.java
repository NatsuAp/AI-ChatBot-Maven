package org.example.FrontEnd.Buttons;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.example.FrontEnd.Labels.imageLabels;
import org.example.FrontEnd.Panels.AttachPanel;

public class AttachButton {

    public static File file;
    //Declaracion fileChooser
    public JFileChooser fileChooser(){
        JFileChooser fileChooser = new JFileChooser();
        //Filtro que solo acepta imagenes
        //"png", "jpg",
        FileNameExtensionFilter filter =
                    new FileNameExtensionFilter("Image Files", "jpeg", "jpg");
            fileChooser.setFileFilter(filter);
    
            //Remueve la capacidad de recibir cualquier tipo de archivo
            fileChooser.setAcceptAllFileFilterUsed(false);
        return fileChooser;
    }
    public JButton sendButton() {
        
        JFileChooser fileChooser = fileChooser();
        ImageIcon clip = new ImageIcon("src/main/resources/Images/Clip.png"); // imagen
        JButton button = new JButton(clip); // Recibe como parametro la imagen
        

        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false); // Para quitar los bordes, rellenos usuales del boton y dejar solo la imagen
        button.setBorder(null);
        button.setOpaque(false);

        button.addMouseListener(new MouseAdapter() { // Detector de eventos
            @Override
            public void mouseEntered(MouseEvent e) { // si pasas el mouse por el boton
                button.setOpaque(true);
                button.setBackground(new Color(255, 255, 255, 30));
                button.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 40), 1));
            }

            @Override
            public void mouseExited(MouseEvent e) { // Cuando quitas el mouse del boton
                button.setOpaque(false);
                button.setBackground(null);
                button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            }

            @Override
            public void mousePressed(MouseEvent e) { // Cuando clickeas
                button.setBackground(Color.LIGHT_GRAY);
                button.setOpaque(true);

               
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(!button.isEnabled()){
                    return;
                }
                button.setOpaque(false);

                int response = fileChooser.showOpenDialog(button);   //Guarda lo que hizo el usuario
                if (response == JFileChooser.APPROVE_OPTION) {  //Si el usuario selecciono una imagen, entra en el condicional
                    file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    AttachPanel.setVisible();
                    try {
                        imageLabels.setImage(file.toString());
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(
                                null, // 
                                "Ocurrio un error al intentar cargar la imagen", 
                                "Error desconocido!", 
                                JOptionPane.WARNING_MESSAGE 
                                                            
                        );
                        AttachButton.setFile();
                    }

                    //azureOCR ocr = new azureOCR();
                    // ocr.AzureRequest(String.valueOf(file));
                   // File pathFile = new File("src\\main\\resources\\UserImages\\");

                    
                }

            }
        });

        return button;
    }

    public static void setFile() {
        if (file != null) {
            file = null;
        }
    }

    public static String getFile() {
        if (file != null) {
            return file.toString();
        }
        return null;

    }
}
