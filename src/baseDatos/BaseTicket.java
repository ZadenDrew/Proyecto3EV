package baseDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tienda_videojuegos.Juegos;
import tienda_videojuegos.Ticket;

/**
 *
 * @author acabezaslopez
 */
public class BaseTicket {

    ConectarmyBase cb = new ConectarmyBase();

    public BaseTicket() {
    }

    public void insertaTicket(Ticket tk) {
        cb.connect();

        try {

            PreparedStatement st = cb.link.prepareStatement("insert into Ticket values (?,?,?)");
            st.setInt(1, calcularNum());
            st.setFloat(2, tk.getPrecio());
            st.setInt(3, tk.getUnidades());
            st.execute();
            cb.link.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ConectarmyBase.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        }
        cb.disconnect();
        this.mostrarTickets();
    }

    public ArrayList mostrarTickets() {
        ArrayList<Ticket> listaTickets = new ArrayList();
        cb.connect();
        ResultSet result;
        try {
            PreparedStatement st = cb.link.prepareStatement("SELECT * FROM Ticket");
            result = st.executeQuery();
            while (result.next()) {
                Ticket tk = new Ticket(result.getInt("num"), result.getFloat("precio"), result.getInt("unidades"));
                listaTickets.add(tk);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        cb.disconnect();
        return listaTickets;
    }

    public int calcularNum() {
        int num = 0;
        ResultSet result = null;
        try {
            PreparedStatement st = cb.link.prepareStatement("select max(num) as num from Ticket");
            result = st.executeQuery();
            if (result.next()) {
                num = result.getInt("num") + 1;
            }
        } catch (NullPointerException e) {
            System.out.println("Error ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return num;
    }

}
