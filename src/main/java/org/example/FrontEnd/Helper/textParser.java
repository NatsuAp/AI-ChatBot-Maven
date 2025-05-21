package org.example.FrontEnd.Helper;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;


public class textParser {

    public static String markDownParse(String str){
        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        Node document = parser.parse(str);
        String html = renderer.render(document);
        return html;
    }
}
