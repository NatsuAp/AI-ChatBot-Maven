package org.example.FrontEnd;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class setFilechooser {
public JFileChooser fileChooser(){
    JFileChooser fileChooser = new JFileChooser();
    //Filtro que solo acepta imagenes
    FileNameExtensionFilter filter =
                new FileNameExtensionFilter("Image Files", "png", "jpg", "jpeg");
        fileChooser.setFileFilter(filter);

        //Remueve la capacidad de recibir cualquier tipo de archivo
        fileChooser.setAcceptAllFileFilterUsed(false);
    return fileChooser;
}
}
