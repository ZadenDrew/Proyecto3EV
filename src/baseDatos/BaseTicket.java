package baseDatos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tienda_videojuegos.Juegos;

/**
 *
 * @author acabezaslopez
 */
public class BaseTicket {

    ConectarmyBase cb = new ConectarmyBase();

//    public void insertaTicket(Ticket tk) {
//        cb.connect();
//
//        try {
//
//            PreparedStatement st = cb.link.prepareStatement("insert into Juegos values (?,?,?,?,?)");
//            st.setString(1, tk.getNum());
//            st.setString(2, tk.getPrecio());
//            st.setString(3, tk.getUnidades());
//
//            st.execute();
//            cb.link.commit();
//        } catch (SQLException ex) {
//            Logger.getLogger(ConectarmyBase.class.getName()).log(Level.SEVERE, null, ex);
//            System.err.println(ex.getMessage());
//        }
//        cb.disconnect();
//
//    }
}
