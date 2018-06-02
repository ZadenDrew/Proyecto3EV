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
            st.setInt(1, tk.getNum());
            st.setFloat(2, tk.getPrecio());
            st.setInt(3, tk.getUnidades());

            st.execute();
            cb.link.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ConectarmyBase.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        }
        cb.disconnect();

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

    public int ultimoNum(ArrayList<Ticket> listaTickets) {
        int ultimo = 0;
        for (int i = 0; i < listaTickets.size(); i++) {
            listaTickets.get(i).getNum();
            if ((i + 1) == listaTickets.size()) {
                break;
            }
            if (listaTickets.get(i).getNum() > listaTickets.get(i + 1).getNum()) {
                ultimo = listaTickets.get(i).getNum();
            } else {
                ultimo = listaTickets.get(i + 1).getNum();
            }

        }
        return ultimo;
    }
}
