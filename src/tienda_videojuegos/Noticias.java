package tienda_videojuegos;

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
public class Noticias {


    public static String pasarNoticia(){
        String noticia="";
        try{
            org.jsoup.nodes.Document doc=Jsoup.connect("https://www.eurogamer.es/news").get();
            noticia=doc.select(".latest .section-title .small-list .list-item .details .title").text();
        }catch(IOException ex){
            System.out.println("Error:"+ex);
        }

        return noticia;
    
    }
}

    