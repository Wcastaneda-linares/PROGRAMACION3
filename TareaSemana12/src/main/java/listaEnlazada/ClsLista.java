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
public class ClsLista {
    //declaramos cima de tipo nodo
    private ClsNodo cima;

    //constructor
    //pila la inicializammos en null
    public ClsLista() {
        cima = null;
    }

    
    public boolean pilaVacia() {
        return cima == null;
    }

    //recibe el elemento
    public void insertar(Object elemento) {
        ClsNodo nuevo;
        nuevo = new ClsNodo(elemento);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    //elemento que queremos quitar
    public Object quitar() throws Exception {
        if (pilaVacia()) {
            throw new Exception("La pila esta vacia");
        }
        Object aux = cima.elemento;
        cima = cima.siguiente;
        return aux;
    }

    //usuamos el elemento de la cima y devolvemos el resultado
    public Object cimaPila() throws Exception {
        if (pilaVacia()) {
            throw new Exception("No se puede leer");
        }
        return cima.elemento;
    }

    //se hace una iteracion poniendo en null el siguiente elemento
    public void limpiarPila() {
        ClsNodo t;
        while (!pilaVacia()) {
            t = cima;
            cima = cima.siguiente;
            t.siguiente = null;
        }
    }
}
