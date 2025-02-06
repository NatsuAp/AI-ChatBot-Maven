package org.example.BackEnd.Helpers.WebScraper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.example.BackEnd.Helpers.WebScraper.OpenAiRequest.ImageRetrieval;

public class QuestionsParser {
    public ArrayList<String> questionParser() {
        String path = "src\\main\\resources\\newData.txt";
        File file = new File(path);
        azureOCR ocr = new azureOCR();
        ImageRetrieval imgRet = new ImageRetrieval();
        ImgOutput out = new ImgOutput();
        ArrayList<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            ArrayList<String> list = new ArrayList<>();
            String line;

            String str = "";
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            int i = 0;

            try {

                String temp = "";
                String url = "";
                int x = 0;
                while (true) {
                    for (int j = 0; j < 7; j++) {
                        if (j != 6) {
                            line = list.get(i);
                            while (line.contains("<img src=\"")) {
                                x = line.indexOf("<img src=\"");
                                for (int l = x + 10; l < line.length(); l++) {
                                    if (line.charAt(l) != '\"') {
                                        url += String.valueOf(line.charAt(l));
                                    } else {
                                       // temp = imgRet.ImgRequest(url);
                                        System.out.println(url);
                                       // line = line.replaceFirst("<img src=\"" + url + "\"/>", out.outputParse(temp));

                                        line = line.replaceFirst("<img src=\"" + url + "\"/>", ocr.OCRRequest(url));

                                        url = "";
                                        break;
                                    }

                                }

                            }

                            str += line + " ### ";
                        }
                        i++;
                    }
                    data.add(str);
                    str = "";

                }
            } catch (IndexOutOfBoundsException e) {
                return data;

            }

        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();

        }
        return null;
    }

}
