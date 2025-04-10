package org.example.FrontEnd.Labels;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LoadingLabel {

    public static JLabel loading() {
        ImageIcon loadingIcon = new ImageIcon("src\\main\\resources\\Images\\loading.gif"); // make sure the path is correct
        JLabel loadingLabel = new JLabel(loadingIcon);
        loadingLabel.setVisible(true);
        return loadingLabel;
    }
}
