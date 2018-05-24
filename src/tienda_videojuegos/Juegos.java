package tienda_videojuegos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andrea
 */
public class Juegos {

    private String nombre, consola, codigo;
    private float precio;
    private int unidades;
    private List<Juegos> listaJuego = new ArrayList();

    public Juegos() {
    }

    public Juegos(String codigo, String nombre, String consola, float precio, int unidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.consola = consola;        
        this.precio = precio;
        this.unidades = unidades;
    }

    public void crearLista(Juegos j) {
        listaJuego.add(j);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public List<Juegos> getListaJuego() {
        return listaJuego;
    }

    public void setListaJuego(List<Juegos> listaJuego) {
        this.listaJuego = listaJuego;
    }

    @Override
    public String toString() {
        return ("Juegos \n nombre= " + nombre + ", consola= " + consola + ", codigo= " + codigo + ", precio= " + precio + ", unidades= " + unidades + ", listaJuego= " + listaJuego);
    }

}
