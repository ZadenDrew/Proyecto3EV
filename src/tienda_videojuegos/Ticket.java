package tienda_videojuegos;

/**
 *
 * @author acabezaslopez
 */
public class Ticket {

    private float precio;
    private int unidades;
    private static int num = 0;

    public Ticket() {
    }

    public Ticket(int num, float precio, int unidades) {
        this.precio = precio;
        this.unidades = unidades;
        this.num = num + 1;
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

    @Override
    public String toString() {
        return ("Ticket -> \n" + " unidades=" + unidades + "\tprecio=" + precio + "\ntotal=" + precio * unidades);
    }

}
