package application.model;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * JUnit tests for Article class.
 *
 * @author noah
 */
public class ArticleTest {

    ArrayList<Article> articleList = new ArrayList<>();
    ArrayList<String> articleNameList = new ArrayList<>();
    ArrayList<String> articlePriceList = new ArrayList<>();

    @Before
    public void setUp(){

        articleNameList.add("SD Card 64GB");
        articleNameList.add("**Ä B  C**");
        articleNameList.add("M oi");
        articleNameList.add(null);
        articleNameList.add("Andy");

        articlePriceList.add("1534");
        articlePriceList.add("14.73");
        articlePriceList.add("0");
        articlePriceList.add(null);
        articlePriceList.add("-4234");


        Article article1 = new Article( articleNameList.get(0), articlePriceList.get(0));
        Article article2 = new Article( articleNameList.get(1), articlePriceList.get(1));
        Article article3 = new Article( articleNameList.get(2), articlePriceList.get(2));
        Article article4 = new Article( articleNameList.get(3), articlePriceList.get(3));
        Article article5 = new Article( articleNameList.get(4), articlePriceList.get(4));

        articleList.add(article1);
        articleList.add(article2);
        articleList.add(article3);
        articleList.add(article4);
        articleList.add(article5);

    }

    @Test
    public void testId() {

        for (Article a : articleList){
            assertNotNull(a);
            assertEquals( 'P', a.getId().charAt(0) );

            if (a.getId().length() == 9) {
                boolean b = a.getId().substring(1).matches("[0-9]+");
                assertTrue(b);
            } else assertTrue(false);

            assertTrue(!a.getId().contains(" ") && !a.getId().contains("\n"));
            assertTrue(!a.getId().equals("P00000000"));

        }

    }

    @Test
    public void testName(){

        int i = 0;
        for (Article a : articleList){
            assertEquals(articleNameList.get(i), a.getName());
            i++;
        }

    }

    @Test
    public void testPrice(){

        int i = 0;
        for (Article a : articleList){
            if (a.getPrice() != null){
             double price = Double.parseDouble(a.getPrice());
                assertTrue(price >= 0);
                if(Double.parseDouble(a.getPrice()) < 0){
                    assertEquals(0, a.getPrice());
                }
            } else {
                assertEquals(articlePriceList.get(i), a.getPrice());
            }
            i++;
        }

    }

}
