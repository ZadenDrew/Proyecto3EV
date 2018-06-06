package tienda_videojuegos;

import java.io.IOException;
import org.jsoup.Jsoup;

/**
 *
 * @author acabezaslopez
 */
public class Noticias {

    public static String pasarNoticia() {
        String noticia = null;
        try {
            org.jsoup.nodes.Document doc = Jsoup.connect("https://www.eurogamer.es/news").get();
            noticia = doc.select(".latest .section-title .small-list .list-item .details .title").text();
        } catch (IOException ex) {
            System.out.println("Error:" + ex);
        }

        return noticia;

    }
}
