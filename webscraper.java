// package jsoup;

import java.io.*;
import java.util.*; 

import org.jsoup.Jsoup; 
import org.jsoup.Connection; 
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class webscraper {
    public static void main(String[] args) throws IOException {
        Document doc1 = Jsoup.connect("https://www.walmart.com/reviews/product/549377034").get();
        Elements names1 = doc1.getElementsByClass("f6 gray pr2 mb2");
        Elements reviews1 = doc1.getElementsByClass("tl-m mb3 db-m");

        Document doc2 = Jsoup.connect("https://www.walmart.com/reviews/product/549377034?page=2").get();
        Elements names2 = doc2.getElementsByClass("f6 gray pr2 mb2"); 
        Elements reviews2 = doc2.getElementsByClass("tl-m mb3 db-m");

        Document doc3 = Jsoup.connect("https://www.walmart.com/reviews/product/549377034?page=3").get();
        Elements names3 = doc3.getElementsByClass("f6 gray pr2 mb2");
        Elements reviews3 = doc3.getElementsByClass("tl-m mb3 db-m");

        Document doc4 = Jsoup.connect("https://www.walmart.com/reviews/product/549377034?page=4").get();
        Elements names4 = doc4.getElementsByClass("f6 gray pr2 mb2");
        Elements reviews4 = doc4.getElementsByClass("tl-m mb3 db-m");

        Document doc5 = Jsoup.connect("https://www.walmart.com/reviews/product/549377034?page=5").get();
        Elements names5 = doc5.getElementsByClass("f6 gray pr2 mb2");
        Elements reviews5 = doc5.getElementsByClass("tl-m mb3 db-m");

        DataCollector dc = new DataCollector(); 
        ArrayList<String> users = new ArrayList<String>();
        ArrayList<String> cmts = new ArrayList<String>();
        // System.out.println(users.size());
        for (Element n1:names1) {
            users.add(n1.text()); 
        }
        // System.out.println(users.size());
        for (Element n2:names2) {
            users.add(n2.text()); 
        }
        // System.out.println(users.size());
        for (Element n3:names3) {
            users.add(n3.text()); 
        }
        // System.out.println(users.size());
        for (Element n4:names4) {
            users.add(n4.text()); 
        }
        // System.out.println(users.size());
        for (Element n5:names5) {
            users.add(n5.text()); 
        }
        // System.out.println(users.size());

        for (Element r1:reviews1) {
            cmts.add(r1.text()); 
        }
        for (Element r2:reviews2) {
            cmts.add(r2.text()); 
        }
        for (Element r3:reviews3) {
            cmts.add(r3.text()); 
        }
        for (Element r4:reviews4) {
            cmts.add(r4.text()); 
        }
        for (Element r5:reviews5) {
            cmts.add(r5.text()); 
        }
        dc.prepareAdvertisement("/Users/pingyaoliu/Downloads/unit2project/comments.txt", users, cmts); 
        String usersString = String.join("", users); 
        System.out.println(usersString); 
        // String cmtsString = String.join("\n", cmts); 
        // System.out.println(cmtsString); 
    }


}
