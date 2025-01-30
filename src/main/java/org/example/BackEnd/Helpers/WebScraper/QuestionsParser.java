package org.example.BackEnd.Helpers.WebScraper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.example.BackEnd.Helpers.WebScraper.Tesseract.Tess;

public class QuestionsParser {
public String[] questionParser(){
        String path = "src\\main\\resources\\data.txt";
        File file = new File(path);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            ArrayList<String> list = new ArrayList<>();
            String line;
            String[] data = new String[334];
            String str="";
            while((line = reader.readLine())!=null){
                list.add(line);
            }
            int i = 0;
            int k=0;
            try {
                Tess tesseract = new Tess();
                
                String url="";
                int x=0;
                while(true){
                    for(int j = 0; j<7;j++){
                        if(j!=6){
                            line = list.get(i);
                            while(line.contains("<img src=\"")){
                                x=line.indexOf("<img src=\"");
                                for(int l=x+10;l<line.length();l++){
                                    if(line.charAt(l)!='\"'){
                                        url+=String.valueOf(line.charAt(l));
                                    }else{
                                       
                                       line = line.replaceFirst("<img src=\"" + url+ "\"/>",tesseract.textRetrieve(url));
                                       url="";
                                        break;
                                    }

                                   
                                }
                               
                            }
                                
                            
                            str+=line+" ### ";
                        }
                        i++;
                    }
                    data[k]=str;
                    str="";
                    k++;
                }
            } catch (IndexOutOfBoundsException e) {
                
            }
            
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

}
