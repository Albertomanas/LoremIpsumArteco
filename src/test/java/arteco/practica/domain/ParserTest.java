package arteco.practica.domain;

import static  org.junit.Assert.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;

import javax.lang.model.util.Elements;

public class ParserTest {

    private String testHtml;

    @Before
    public void init() {
        this.testHtml = Parser.parseLorem();
    }
    @Test
    public void probarHtmlTest() {
        //Verificar notnull
        assertNotNull(testHtml);
    }
}
