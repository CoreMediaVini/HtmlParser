package com.ey.htmlparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.*;

/**
 * Created by vvasund on 12.09.2017.
 */
public class ParseWeb {
    public ParseWeb() {

    }


    private String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }

    public static void main(String[] args)
    {
        ParseWeb parseWeb = new ParseWeb();

        ModelRowList modelRowList = new ModelRowList();
        Document doc;
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.showSaveDialog(null);

        File folder = f.getSelectedFile();

        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {

            if(parseWeb.getFileExtension(file).equals("htm"))
            {



                try {
//###############sample for google############################
          /*  doc = Jsoup.connect("http://google.com").get();

            // get page title
            String title = doc.title();
            System.out.println("title : " + title);

            // get all links
            Elements links = doc.select("a[href]");
            for (Element link : links) {

                // get the value from href attribute
                System.out.println("\nlink : " + link.attr("href"));
                System.out.println("text : " + link.text());
            }*/

//#########################Parsing html file###################################

                    File htmlFile = file;
                    InputStream inputStream = new FileInputStream(htmlFile);
                    doc = Jsoup.parse(htmlFile, "UTF-8", "");
                    Elements divs = doc.select("div[id^=results]");
                    Elements uls = divs.select("ul[class^=officers unstyled]");
                    Elements lis = uls.select("li");

                    String providerName = "MILLTOWN CORPORATE SERVICES";
                    for (Element each : lis) {
                        ModelRow modelRow = new ModelRow();
                        modelRow.classType = each.select("li").attr("class");
                        modelRow.statusLabel1 = each.select("span[class^=status label]").first().text();
                        String splitString = each.select("a").text();
                        modelRow.officer = splitString.split("  ")[0];
                        modelRow.companyName = splitString.split("  ")[1];
                        String ownElements=each.ownText();
                        modelRow.relation=ownElements.split(",")[0];
                        modelRow.country=ownElements.split(",")[1];
                        System.out.println(modelRow.relation);
                        System.out.println(modelRow.country);
                        // modelRow.companyName=each.select("a").after("span a a span").text();
                        modelRow.startDate = each.select("span[class^=start_date]").text();
                        modelRow.endDate = each.select("span[class^=end_date]").text();
                        modelRow.address = each.select("span[class^=address]").text();
                        modelRowList.addModelRowItem(modelRow);
                    }

                    PrintWriter printWriter = new PrintWriter(new File(file.getName()+".csv"));
                    StringBuilder stringBuilder = new StringBuilder();
                    String columnNameList = "ID,Officer,Relation,Status,Company,Country,Valid from,Valid to, Address;\n";
                    stringBuilder.append(columnNameList);
                    int count = 1;
                    for (ModelRow modelRow : modelRowList.getModelRowList()) {
                        String row = count + "," + modelRow.officer + "," +modelRow.relation+"," + modelRow.statusLabel1 + "," + modelRow.companyName+ ","+ modelRow.country + "," + modelRow.startDate + "," + modelRow.endDate + "," + modelRow.address + ";\n";
                        stringBuilder.append(row);
                        count++;
                    }

                    printWriter.write(stringBuilder.toString());
                    printWriter.close();
                    Elements ids = doc.select("li[class^=inactive]");
                }
                catch (IOException e) {

                }
                catch(NullPointerException e)
                {

                }
            }
        }

    }
}
