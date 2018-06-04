package tienda_videojuegos;

import baseDatos.BaseTicket;

/**
 *
 * @author acabezaslopez
 */
public class Ticket {

    private int num;
    private float precio;
    private int unidades;

    public Ticket() {
    }

    public Ticket(int num, float precio, int unidades) {
        this.num = num;
        this.precio = precio;
        this.unidades = unidades;

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
        return ("Ticket -> \n" + " nº =" + num + " unidades=" + unidades + "\tprecio=" + precio + "\ntotal=" + precio * unidades);
    }

}
