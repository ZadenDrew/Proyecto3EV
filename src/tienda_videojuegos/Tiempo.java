package com.mycompany.tiempo_exm;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import static sun.util.logging.LoggingSupport.log;

/**
 *
 * @author acabezaslopez
 */
public class Tiempo {

    public void titulo() {
        try {
            Document doc = Jsoup.connect("https://weather.com/es-ES/tiempo/hoy/l/SPXX0084:1:SP").get();
            System.out.println(doc.title());
            Elements newsHeadlines = doc.select("#mp-itn b a");
            for (Element headline : newsHeadlines) {
                log("%s\n\t%s",
                        headline.attr("title"), headline.absUrl("href"));
            }
        } catch (IOException ex) {
            Logger.getLogger(Tiempo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void grados() {
        try {
            Document doc = Jsoup.connect("https://weather.com/es-ES/tiempo/hoy/l/SPXX0084:1:SP").get();
            System.out.println(doc.body().addClass("span class"));
            Elements newsHeadlines = doc.select("#mp-itn b a");
            for (Element headline : newsHeadlines) {
                log("%s\n\t%s",
                        headline.attr("today_nowcard-temp"), headline.absUrl("href"));
            }
        } catch (IOException ex) {
            Logger.getLogger(Tiempo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void tiempo() {
        try {
            Document doc = Jsoup.connect("https://weather.com/es-ES/tiempo/hoy/l/SPXX0084:1:SP").get();
            System.out.println(doc.body());
            Elements newsHeadlines = doc.select("#mp-itn b a");
            for (Element headline : newsHeadlines) {
                log("%s\n\t%s",
                        headline.attr("today_nowcard-phrase"), headline.absUrl("href"));
            }
        } catch (IOException ex) {
            Logger.getLogger(Tiempo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}