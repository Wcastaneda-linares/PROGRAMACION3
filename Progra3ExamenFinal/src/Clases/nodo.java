/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Wcastañeda
 */
public class nodo {

    private int nombre;
    private boolean visitado;
    private boolean etiqueta;
    private int acumulado; //lleva el acumulado de cada nodo
    private nodo predecesor;

    public nodo() {
        this.nombre = 1;
        this.visitado = false;
        this.etiqueta = false;
        this.predecesor = null;
        this.acumulado = 0;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public boolean isEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(boolean etiqueta) {
        this.etiqueta = etiqueta;
    }

    public int getAcumulado() {
        return acumulado;
    }

    public void setAcumulado(int acumulado) {
        this.acumulado = acumulado;
    }

    public nodo getPredecesor() {
        return predecesor;
    }

    public void setPredecesor(nodo predecesor) {
        this.predecesor = predecesor;
    }
    
    
}
