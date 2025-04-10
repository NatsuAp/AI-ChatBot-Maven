package org.example.FrontEnd.Buttons;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class loading {
    public static JProgressBar loading() {
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressBar.setVisible(true);
        ImageIcon loadingIcon = new ImageIcon("src\\main\\resources\\Images\\loading.gif"); // make sure the path is correct
        JLabel loadingLabel = new JLabel(loadingIcon);
        loadingLabel.setVisible(true);
    }
}
