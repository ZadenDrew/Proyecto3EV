package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import javax.swing.JOptionPane;
import tienda_videojuegos.Juegos;

/**
 *
 * @author andrea
 */
public class ConectarmyBase {

    public DataSource dataSource;
    public String db = "mibase.db";
    public String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/acabezaslopez/NetBeansProjects/tienda_videojuegos/" + db;
//    public String user = "AndreaBase";
//    public String pass = "012345C";
    public Connection link;
    public PreparedStatement stmt;
    public ArrayList<Juegos> listaJuegos = new ArrayList();

    public ConectarmyBase() {

    }

    public void connect() {

        try {

            Class.forName("org.sqlite.JDBC");

            link = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\andrea\\Documents\\NetBeansProjects\\tienda_videojuegos\\mibase.db");
            link.setAutoCommit(false);
            if (link != null) {
                System.out.println("Conectado.");
            }
        } catch (SQLException exsq) {
            System.out.println("Error: " + exsq);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error : " + ex);
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex);

        }

    }

    public void disconnect() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            System.out.println("aaaaaaaaaa");
            if (link != null) {
                link.close();
            }
            System.out.println("Conexión cerrada.");
        } catch (SQLException ex) {
            System.out.println("Error: aaaaaaaa" + ex);
        }
    }

    public void insert(Juegos j) {
        connect();

        try {

            PreparedStatement st = link.prepareStatement("insert into Juegos values (?,?,?,?,?)");
            st.setString(1, j.getCodigo());
            st.setString(2, j.getNombre());
            st.setString(3, j.getConsola());
            st.setFloat(4, j.getPrecio());
            st.setInt(5, j.getUnidades());
            st.execute();
            link.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ConectarmyBase.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        }
        disconnect();
        this.mostrarJuegos();
    }

    public ArrayList mostrarJuegos() {
        ArrayList<Juegos> listaJuegos = new ArrayList();
        connect();
        ResultSet result;
        try {
            PreparedStatement st = link.prepareStatement("SELECT * FROM Juegos");
            result = st.executeQuery();
            while (result.next()) {
                Juegos usu = new Juegos(result.getString("codigo"), result.getString("nombre"),
                        result.getString("consola"), result.getFloat("precio"), result.getInt("unidades"));
                listaJuegos.add(usu);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        disconnect();
        return listaJuegos;
    }

    public void modify(String codigo) {
        connect();
        try {

            String nombre = JOptionPane.showInputDialog("dame el nombre:");
            String consola = JOptionPane.showInputDialog("dame el nombre de la consola:");
            String precio = JOptionPane.showInputDialog("dame el precio:");
            String unidades = JOptionPane.showInputDialog("dame las unidades:");
            stmt = link.prepareStatement("UPDATE Juegos set nombre = '" + nombre + "' , consola = '" + consola + "' ,precio = '" + precio + "',unidades = '" + unidades + "' where codigo='" + codigo + "';");

            stmt.executeUpdate();
            link.commit();

            System.out.println("La fila ha sido modificada con éxito.");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        disconnect();
    }

    public void venta(String codigo,int unidades) {
        connect();
        try {
            stmt = link.prepareStatement("UPDATE Juegos set unidades = '" + unidades + "' where codigo='" + codigo + "';");
            stmt.executeUpdate();
            link.commit();

            System.out.println("La venta ha sido realizada con éxito.");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        disconnect();
    }

    public void delete(String codigo) {
        connect();

        try {

            Statement st = link.createStatement();

            String delete = "DELETE from JUEGOS where codigo='" + codigo + "';";
            st.executeUpdate(delete);
            link.commit();

            System.out.println("Filas borradas con éxito.");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        disconnect();
    }

    public Juegos buscar(String s, int op) {

        connect();
        ResultSet result;
        String busca = null;
        Juegos usu = null;
        try {

            Statement st = link.createStatement();
            if (op == 1) {
                busca = "SELECT * from JUEGOS where codigo='" + s + "';";
            }

            if (op == 2) {
                busca = "SELECT * from JUEGOS where nombre='" + s + "';";
            }

            result = st.executeQuery(busca);
            while (result.next()) {
                usu = new Juegos(result.getString("codigo"), result.getString("nombre"),
                        result.getString("consola"), result.getFloat("precio"), result.getInt("unidades"));
                link.commit();

                System.out.println("Filas encontrada con éxito.");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }

        disconnect();
        return usu;
    }

}
