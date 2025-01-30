package org.example.BackEnd.Helpers.WebScraper;

public class ImgOutput {
    public String outputParse(String str){
        int x = 0;
        int y = str.lastIndexOf("```");
        x = str.indexOf("```");
        String newStr=str.substring(x,y);
        newStr =newStr.replace("```", "").strip();
        return newStr;

    }
}
