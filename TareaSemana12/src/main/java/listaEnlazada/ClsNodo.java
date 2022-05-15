/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaEnlazada;

/**
 *
 * @author Wcastañeda
 */
public class ClsNodo {

    //creamos el contenedor del dato y llamamos nodo
    Object elemento;
    ClsNodo siguiente;

    //contructor para pasar datos
    ClsNodo(Object element) {
        elemento = element;
        siguiente = null;
    }
}
