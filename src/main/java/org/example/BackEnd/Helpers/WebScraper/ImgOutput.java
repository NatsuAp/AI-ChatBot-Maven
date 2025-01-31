package org.example.BackEnd.Helpers.WebScraper;

public class ImgOutput {
    public String outputParse(String str){
        int x = 0;
        int y = str.lastIndexOf("```");
        x = str.indexOf("```");
        try {
        String newStr=str.substring(x,y);
        newStr =newStr.replace("```", "").strip();
        return newStr;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(x);
            System.out.println(y);
        }
      return "";

    }
}
