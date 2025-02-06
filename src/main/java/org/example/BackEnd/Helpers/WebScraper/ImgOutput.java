package org.example.BackEnd.Helpers.WebScraper;

public class ImgOutput {
    public String outputParse(String str){
        int x = 0;
        
        x = str.indexOf("```");
        try {
        String newStr=str.substring(x);
        newStr =newStr.replaceAll("```", "").strip();
        return newStr;
        } catch (Exception e) {
         
            System.out.println(x);
           
        }
      return "";

    }
}
