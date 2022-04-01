/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg.ListaPuntos;

/**
 *
 * @author Wcastañeda
 */
public class Nodo {

    ClsAlumno dato;
    Nodo enlace;

    //cerar en contructo inicial
    public Nodo(ClsAlumno x) {
        dato = x;
        enlace = null;
    }

    //crear un segundo constructor para crear nodo y enlazar
    public Nodo(ClsAlumno x, Nodo n) {
        dato = x;
        enlace = n;
    }

    public ClsAlumno getDato() {
        return dato;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlaceNodo(Nodo enlace) {
        this.enlace = enlace;
    }

    public Nodo() {
    }
    
}
