package org.example.FrontEnd.Panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
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
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
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
                <head>
                    <style>
                        body {
                            color: #f0f0f0;
                            font-family: Segoe UI, Arial, sans-serif;
                            font-size: 14px;
                            background-color: transparent;
                            line-height: 1.6;
                            padding: 10px;
                            margin: 0;
                            word-wrap: break-word;
                            overflow-wrap: break-word;
                            width: 100%;
                        }
                        pre, code {
                            background-color: #2e2e3a;
                            color: #e0e0e0;
                            padding: 8px;
                            border-radius: 6px;
                            font-family: Consolas, monospace;
                            font-size: 13px;
                            word-break: break-all;
                            overflow-x: hidden;
                        }
                        h1, h2, h3 {
                            margin-top: 1em;
                            margin-bottom: 0.5em;
                            color: #ffffff;
                        }
                        a {
                            color: #4fc3f7;
                            text-decoration: none;
                        }
                        a:hover {
                            text-decoration: underline;
                        }
                        p {
                            margin-bottom: 1em;
                        }
                    </style>
                </head>
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

        kit.getStyleSheet().addRule("""
                    code {
                        white-space: pre-wrap;
                        word-wrap: break-word;
                        background-color: #2e2e3a;
                        color: #e0e0e0;
                        padding: 2px 4px;
                        border-radius: 4px;
                        display: inline-block;
                        font-family: Consolas, monospace;
                        font-size: 12px;
                    }
                """);
        kit.getStyleSheet().addRule("body { font-family: Consolas; font-size: 12px; }");
        kit.getStyleSheet().addRule("pre, code { white-space: pre-wrap; word-wrap: break-word; }");

        pane.setEditorKit(kit);
        pane.setContentType("text/html");
        System.out.println(parsedStr);
        String finalString = htmlPrompt.replace("%s", parsedStr);

        // TODO: Terminar esta funcion que muestra las palabras una por una.
         //typeMessage(pane, finalString, 40);

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
               System.out.println(width);
                pane.setSize(new Dimension(width, Integer.MAX_VALUE));

//No se que como funciona esto, pero me ayuda a reajustar el tamaño del panel donde esta el mensaje cuando se reajusta el tamaño del frame
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
