/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg.ListaPuntos;

import java.util.Scanner;

/**
 *
 * @author Wcastañeda
 */
public class ClsLista {

    public Nodo primero;//esta sera la cabeza

    public ClsLista() {
        primero = null;
    }

    //funcion para obtener numero
//    private int leerEntero() {
//        System.out.println("Ingrese valor -1 para terminar");
//        return Integer.parseInt(new Scanner(System.in).nextLine());
//    }
//
//    public ClsLista crearLista() {
//        int x;
//        primero = null;
//        do {
//            x = leerEntero();
//            if (x != -1) {
//                primero = new Nodo(x, primero);
//            }
//        } while (x != -1);
//        return this;
//    }
    public ClsLista insertarCabezaLista(ClsAlumno entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = primero;//enlaza nuevo nodo al frente de la lista(lo apunta)
        primero = nuevo;//nueve primero y lo apunta al nodo nuevo
        return this;//retorna la referencia del objeto lista
    }

    public void visualizar() {
        Nodo n;
        int k = 0;
        n = primero;
        System.out.println("PROCESO DE INSERTAR ALUMNO POR CABEZA");
        while (n != null) {
            System.out.println(n.dato.getCarnet() + " ");
            System.out.println(n.dato.getNombre() + " ");
            System.out.println(n.dato.getPromedio() + " ");
            System.out.println("--------------------");
            n = n.enlace;
            k++;
            System.out.print((k % 15 != 0 ? " " : "\n"));
        }
    }

    public ClsLista insertarUltimo(Nodo ultimo, ClsAlumno entrada) {
        ultimo = new Nodo(entrada);

        if (primero == null) {
            primero = ultimo;
        } else {
            Nodo aux = primero;
            while (aux.enlace != null) {
                aux = aux.enlace;
            }
            aux.enlace = ultimo;
        }
        return this;
    }

    public Nodo buscarLista(String destino) {
        Nodo indice;
        for (indice = primero; indice != null; indice = indice.enlace) {
            if (destino.equals(indice.dato.getCarnet())) {//valorBuscar.equals (indice.dato)
//                System.out.println("prueba de impresion buscador");
                return indice;

            }
        }
        return null;
    }

    //insertar la lista
    public ClsLista insertarLista(String valorBuscarInsertar, ClsAlumno entrada) {
        Nodo nuevo, anterior;
        anterior = buscarLista(valorBuscarInsertar);
        if (anterior != null) {
            nuevo = new Nodo(entrada);
            nuevo.enlace = anterior.enlace;
            anterior.enlace = nuevo;
        }
        return this;
    }

    //buscar por poscicion
    public Nodo buscarPoscicion(int poscicion) {
        Nodo indice;
        int i;
        if (poscicion < 0) {
            return null;
        }
        indice = primero;
        for (i = 1; (i < poscicion) && (indice != null); i++) {
            indice = indice.enlace;
        }
        return indice;
    }

    public void eliminar(String entrada) {
        Nodo actual, anterior;
        boolean encontrado;
        //inicializar los apuntadores
        actual = primero;
        anterior = null;
        encontrado = false;
        //buscar en el nodo
        while ((actual != null) && (!encontrado)) {
            encontrado = (actual.dato.getCarnet().equals(entrada));//equals
            if (!encontrado) {
                anterior = actual;
                actual = actual.enlace;
            }
        }
        //enlazar del nodo anterior con el siguiente nodo
        if (actual != null) {
            //distingue que el nodo no sea la cabeza
            if (actual == primero) {
                primero = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
            actual = null;//ya que es una variable local no es necesario
        }
    }

}
