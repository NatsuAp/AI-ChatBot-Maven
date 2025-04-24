package org.example.FrontEnd.Panels;

import java.awt.*;
import javax.swing.*;

public class MessagePanel {
        public static JPanel messagePanel() {
                JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
                JPanel outerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                JTextArea dynamicTextArea = new JTextArea(
                                "SLF4J: Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".\r\n" + //
                                                "SLF4J: Defaulting to no-operation (NOP) logger implementation\r\n" + //
                                                "SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                panel.setBackground(null);

                panel.setOpaque(false);
                dynamicTextArea.setLineWrap(true);
                dynamicTextArea.setBounds(0,0, 400, 400);
                dynamicTextArea.setLineWrap(true); // Enable line wrapping
                dynamicTextArea.setWrapStyleWord(true); // Wrap at word boundaries
                dynamicTextArea.setEditable(false); // Make it read-only
                //dynamicTextArea.setBackground(new Color(0, 0, 0, 0)); 
                dynamicTextArea.setForeground(new Color(12,223,233));
                // Remove the border of the text area
                dynamicTextArea.setBorder(null);
                panel.add(dynamicTextArea);
                // Outer panel to constrain the size
               
                outerPanel.add(panel);
                outerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // For visualization
                outerPanel.setPreferredSize(new Dimension(650, 1000)); // Height will adjust
                outerPanel.setMaximumSize(new Dimension(300, Short.MAX_VALUE));
                outerPanel.setOpaque(false);

                return outerPanel;
        }
}
