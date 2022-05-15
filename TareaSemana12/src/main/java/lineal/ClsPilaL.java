/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineal;

import java.util.*;

/**
 *
 * @author Wcastañeda
 */
public class ClsPilaL {
    //declaramos las propiedades
    private static final int INICIAL = 19;
    private int cima;
    private ArrayList pilaArrayList;
    
    //declaramos el contructor
    public ClsPilaL() {
        cima = -1;
        pilaArrayList = new ArrayList();
    }

    //operaciones que modifican la pila
    public void insertar(Object elemento) throws Exception {
        cima++;
        pilaArrayList.add(elemento);
    }

    //desapilar, quitar, POP elemento de la pila
    public Object quitarCima() throws Exception {
        Object aux;
        if (pilaVacia()) {
            throw new Exception("La pila vacia, no se puede sacar");
        }
        aux = pilaArrayList.get(cima);
        pilaArrayList.remove(cima);
        cima--;
        return aux;
    }

    public Object cimaPila() throws Exception {
        if (pilaVacia()) {
            throw new Exception("Lo siento, la pila esta vacia");
        }
        return pilaArrayList.get(cima);
    }

    public boolean pilaVacia() {
        return cima == -1;
    }

    //limpiar la pila
    public void limpiarPila() throws Exception {
        while (!pilaVacia()) {
            quitarCima();
        }

    }
}
