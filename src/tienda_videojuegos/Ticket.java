package tienda_videojuegos;

import baseDatos.BaseTicket;

/**
 *
 * @author acabezaslopez
 */
public class Ticket {

    private float precio;
    private int unidades;
    private int num = 0;
    BaseTicket bt2 = new BaseTicket();

    public Ticket() {
    }

    public Ticket(int num, float precio, int unidades) {
        this.precio = precio;
        this.unidades = unidades;
        this.num = bt2.ultimoNum(bt2.mostrarTickets()) + 1;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return ("Ticket -> \n" + " unidades=" + unidades + "\tprecio=" + precio + "\ntotal=" + precio * unidades);
    }

}
