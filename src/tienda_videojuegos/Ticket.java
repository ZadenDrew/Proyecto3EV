package tienda_videojuegos;


/**
 *
 * @author acabezaslopez
 */
public class Ticket {

    private int num;
    private float precio;
    private int unidades;
/**
 * Constructor por defecto de la clase Ticket
 */
    public Ticket() {
    }
/**
 * Constructor por parámetros de la clase Ticket
 * @param num
 * @param precio
 * @param unidades 
 */
    public Ticket(int num, float precio, int unidades) {
        this.num = num;
        this.precio = precio;
        this.unidades = unidades;

    }
/**
 * Getter que devuelve un float precio
 * @return precio
 */
    public float getPrecio() {
        return precio;
    }
/**
 * Setter de precio
 * @param precio 
 */
    public void setPrecio(float precio) {
        this.precio = precio;
    }
/**
 * Getter que devuelve un int unidades
 * @return unidades
 */
    public int getUnidades() {
        return unidades;
    }
/**
 * Setter de unidades
 * @param unidades 
 */
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
/**
 * Getter de devuelve un int num
 * @return num
 */
    public int getNum() {
        return num;
    }
/**
 * Setter de num
 * @param num 
 */
    public void setNum(int num) {
        this.num = num;
    }
/**
 * 
 * @return String de un Ticket
 */
    @Override
    public String toString() {
        return ("Ticket  nº " + num + " -> \nunidades=" + unidades + "\nprecio=" + precio + "\ntotal=" + precio * unidades);
    }

}
