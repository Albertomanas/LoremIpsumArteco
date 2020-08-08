package arteco.practica.domain;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser {

    private static String loremIpsum = "";

    public static String parseLorem() {

        Document doc = null;
        try {
            doc = Jsoup.connect("https://es.lipsum.com/feed/html").get();

            Elements lipsums = doc.select("#lipsum p"); // filtro por ID

            for(Element lipsum : lipsums) { // Saca cada parrafo
                loremIpsum += (lipsum.text()).concat("\n");
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
        return loremIpsum;
    }

    /*public static String getLorem() {
        return parseLorem(loremIpsum);
    }

     */

}
