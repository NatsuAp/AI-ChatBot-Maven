package org.example.BackEnd.Helpers;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;

public class Base64Coder {
public static String encode(String file){
    byte[] fileContent;
    String encodedImg="";
    try {
        fileContent = FileUtils.readFileToByteArray(new File(file));
        encodedImg = Base64.getEncoder().encodeToString(fileContent);
    } catch (IOException e) {
        JOptionPane.showMessageDialog(
                                null, // 
                                "Ocurrio un error al intentar cargar la imagen", 
                                "Error desconocido!", 
                                JOptionPane.WARNING_MESSAGE 
                                                            
                        );
        e.printStackTrace();
    }
     
     return encodedImg;
}
}
