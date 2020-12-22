/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesventa.modelo;

/**
 *
 * @author
 */
public class Categoria {
    private int id;
    private String nombreCategoria;

    public Categoria(int id, String categoria) {
        this.id = id;
        this.nombreCategoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    // getter y setter
    @Override
    public String toString() {
       return nombreCategoria;
    }
}
