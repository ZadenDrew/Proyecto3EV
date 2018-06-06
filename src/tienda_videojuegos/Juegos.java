package tienda_videojuegos;

/**
 *
 * @author andrea
 */
public class Juegos {

    private String nombre, consola, codigo;
    private float precio;
    private int unidades;
/**
 * Constructor por defecto de la clase Juegos
 */
    public Juegos() {
    }
/**
 * Constructor por parámetros de la clase Juegos
 * @param codigo
 * @param nombre
 * @param consola
 * @param precio
 * @param unidades 
 */
    public Juegos(String codigo, String nombre, String consola, float precio, int unidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.consola = consola;
        this.precio = precio;
        this.unidades = unidades;
    }
/**
 * Getter que devuelve un String nombre
 * @return nombre
 */
    public String getNombre() {
        return nombre;
    }
/**
 * Setter de nombre
 * @param nombre 
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
 * Getter que devuelve un String  consola
 * @return consola
 */
    public String getConsola() {
        return consola;
    }
/**
 * Setter de consola
 * @param consola 
 */
    public void setConsola(String consola) {
        this.consola = consola;
    }
/**
 * Getter que devuelve un String  codigo
 * @return codigo
 */
    public String getCodigo() {
        return codigo;
    }
/**
 * Setter de codigo
 * @param codigo 
 */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
 * 
 * @return String de Juegos
 */
    @Override
    public String toString() {
        return ("Juegos ->\ncodigo= " + codigo + ", \nnombre= " + nombre + ", \nconsola= " + consola + ", \nprecio= " + precio + ", \nunidades= " + unidades);
    }

}
