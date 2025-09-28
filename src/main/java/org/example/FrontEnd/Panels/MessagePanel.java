package org.example.FrontEnd.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.text.View;
import javax.swing.text.html.HTMLEditorKit;

import org.example.FrontEnd.Frame.Frame;
import org.example.FrontEnd.Helper.textParser;

public class MessagePanel {
    BodyPanel bodyP = new BodyPanel();
    public static JPanel outerPanel = new JPanel();

    public static JScrollPane msgContainer() {
        JScrollPane scrollPane = new JScrollPane(outerPanel);
        outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.Y_AXIS));
        // outerPanel.add(panel, BorderLayout.EAST);
        outerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // outerPanel.setPreferredSize(new Dimension(650, 1000));
        // outerPanel.setMaximumSize(new Dimension(300, Short.MAX_VALUE));
        outerPanel.setOpaque(true);
        outerPanel.setBackground(new Color(42, 42, 62));

        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        scrollPane.setBackground(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        return scrollPane;
    }

    String parsedStr;
    final String htmlPrompt = """
            <html>
                <body>%s</body>
            </html>
            """;

   

    public void newMessagePanel(String text, String side, String file) {
        parsedStr = textParser.markDownParse(text);
        JPanel newOuter = new JPanel(new BorderLayout());
        JPanel imgPanel = new JPanel(new BorderLayout());
        newOuter.setBackground(null);
        imgPanel.setBackground(null);
        // JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBackground(null);
        panel.setOpaque(false);
        panel.setBackground(new Color(36, 36, 53));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 12, 0));

        JEditorPane pane = new JEditorPane() {
            @Override
            public boolean getScrollableTracksViewportWidth() {
                return getPreferredSize().width <= getParent().getSize().width;
            }
        };
        HTMLEditorKit kit = new HTMLEditorKit();

        kit.getStyleSheet().addRule("body {"
                + " font-family: 'Segoe UI', Arial, sans-serif;"
                + " font-size: 14px;"
                + " color: #f0f0f0;"
                + " background-color: transparent;"
                + " line-height: 1.6;"
                + " padding: 10px;"
                + " margin: 0;"
                + " word-wrap: break-word;"
                + " overflow-wrap: break-word;"
                + "}");
        kit.getStyleSheet().addRule("pre, code {"
                + " display: block;"
                + " white-space: pre-wrap;"
                + " word-break: break-word;"
                + " max-width: 100%;"
                + " background-color: #2e2e3a;"
                + " color: #e0e0e0;"
                + " padding: 8px;"
                + " border-radius: 6px;"
                + " font-family: Consolas, monospace;"
                + " font-size: 13px;"
                + " box-sizing: border-box;"
                + " overflow-x: auto;"
                + "}");
        kit.getStyleSheet().addRule("code { white-space: pre-wrap; word-break: break-word; }");

        pane.setEditorKit(kit);
        pane.setContentType("text/html");
        System.out.println(parsedStr);
        String finalString = htmlPrompt.replace("%s", parsedStr);

        // TODO: Terminar esta funcion que muestra las palabras una por una.
        // typeMessage(pane, finalString, 40);

        pane.setText(finalString);
        
        pane.setEditable(false);
        pane.setOpaque(true);
        pane.setBorder(null);
        int width = Frame.frame.getWidth() / 2;
        pane.setSize(new Dimension(width, Integer.MAX_VALUE));
        Dimension prefSize = pane.getPreferredSize();
        pane.setPreferredSize(new Dimension(width, prefSize.height));
        panel.add(pane);
        // Este componente se activa cuando el frame cambia de tamaño por el usario, Y
        // cambia el tamaño de los mensajes para que concuerden con el tamaño de el
        // frame
        pane.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {

                int width = Frame.frame.getWidth() / 2;

                pane.setSize(new Dimension(width, Integer.MAX_VALUE));

                // No se que como funciona esto, pero me ayuda a reajustar el tamaño del panel
                // donde esta el mensaje cuando se reajusta el tamaño del frame
                Dimension prefSize = pane.getUI().getRootView(pane).getPreferredSpan(View.Y_AXIS) > 0
                        ? new Dimension(width, (int) pane.getUI().getRootView(pane).getPreferredSpan(View.Y_AXIS))
                        : pane.getPreferredSize();

                pane.setPreferredSize(prefSize);

                pane.revalidate();
                pane.repaint();
            }
        });

        switch (side)

        {
            case "user":
                if (!text.isBlank()) {
                    newOuter.add(panel, BorderLayout.EAST);
                }

                if (file != null) {
                    imgPanel.add(newImagePanel(file), BorderLayout.EAST);
                    outerPanel.add(imgPanel);
                }

                // dynamicTextArea.setBackground(new Color(36, 36, 53));
                pane.setBackground(new Color(36, 36, 53));
                break;

            case "ia":

                // dynamicTextArea.setBackground(null);
                newOuter.add(panel, BorderLayout.WEST);
                pane.setBackground(new Color(36, 36, 53));
                break;
        }

        // dynamicTextArea.setLineWrap(true);

        // dynamicTextArea.setLineWrap(true);

        // dynamicTextArea.setForeground(new Color(255, 242, 241));

        // Aqui se muestra

        outerPanel.add(newOuter);

        // refrescar el panel
        outerPanel.revalidate();
        outerPanel.repaint();

        // envia al usuario al ultimo mensaje
        // SwingUtilities.invokeLater(() -> {
        // scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
        // });

    }

    public JPanel newImagePanel(String file) {
        JPanel newOuter = new JPanel(new BorderLayout());
        newOuter.setBackground(null);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));

        ImageIcon userImg = new ImageIcon(file);
        Image scaledImg = userImg.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        ImageIcon newuserImg = new ImageIcon(scaledImg);
        JLabel img = new JLabel(newuserImg);
        panel.setBackground(null);
        panel.add(img);
        newOuter.add(panel);
        return newOuter;
    }

    public void typeMessage(JEditorPane pane, String fullBodyHtml, int delay) {
        Timer timer = new Timer(delay, null);
        StringBuilder str = new StringBuilder();

        String[] words = parsedStr.split(" ");
        int[] index = { 0 };

        timer.addActionListener(e -> {
            if (index[0] < words.length) {
                str.append(words[index[0]++] + " ");

                // Wrap current content in full HTML template
                String wrapped = htmlPrompt.replace("%s", str);

                int width = Frame.frame.getWidth() / 2;
                pane.setSize(new Dimension(width, Integer.MAX_VALUE));

                Dimension prefSize = pane.getPreferredSize();
                pane.setPreferredSize(new Dimension(width, prefSize.height));

                pane.setText(wrapped);

                pane.revalidate();
                pane.repaint();
                SwingUtilities.invokeLater(() -> {
                    outerPanel.revalidate();
                    outerPanel.repaint();
                });

            } else {
                ((Timer) e.getSource()).stop();
            }
        });

        timer.start();
    }
}
