/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import static Inicio.incio.lblKmRecorridos;
import static Inicio.incio.miJlabel;
import static Inicio.incio.pintarFiguras;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Wcastañeda
 */
public class algoritmoDijkstra {

    //son variables de diferentes tipos
    private final datosDeGraficos arboles;
    private int subTope;
    private nodo nodoAuxiliar = null;
    private double auxiliarAcumulado;
    private double subTotalAcumulado;
    private final nodo Nodo[]; //alamcenamos los datos en el nodo
    private final int tope;
    private int origen;
    private final int nodoFinal;//nodoFinal o el Destino

    //inicializamos el constructos y le damos los diferentes parametros
    //estos parametros se dieron cuando se ejecuta el algoritmo de Dijkstra
    public algoritmoDijkstra(datosDeGraficos arboles, int tope, int permanente, int nodoFin) {
        this.arboles = arboles;
        this.tope = tope;
        this.Nodo = new nodo[tope];
        this.origen = permanente;
        this.nodoFinal = nodoFin;
    }

    //obtenemos los datos domo acumulado y nombre
    public double getAcumulado() {
        return Nodo[nodoFinal].getAcumulado();
    }

    public int getNombre() {
        return Nodo[nodoFinal].getNombre();
    }

    public void dijkstra() {
        //iniciamos con un for para darle todas las propiedades
        //a los nodos
        try {
            for (int i = 0; i < tope; i++) {//creamos el vector nodo del tamaño del numero de nodos pintados
                Nodo[i] = new nodo();
            }
            //le damos el color a los nodos de origen
            miJlabel.paint(miJlabel.getGraphics());
            pintarFiguras(tope, arboles);
            pintarDibujos.seleccionNodo(miJlabel.getGraphics(),
                    arboles.getCordeX(origen),
                    arboles.getCordeY(origen), null, Color.GREEN);//pinta el color del nodo de origen

            //si el nodo es visitado o no, para que lo haga visible
            Nodo[origen].setVisitado(true);
            Nodo[origen].setNombre(origen);

            do {
                //hacemos una comparacion de los acumulados como de los auxiliares
                subTotalAcumulado = 0;
                auxiliarAcumulado = 2000000000;
                Nodo[origen].setEtiqueta(true);
                for (int j = 0; j < tope; j++) {
                    if (arboles.getmAdyacencia(j, origen) == 1) {
                        subTotalAcumulado = Nodo[origen].getAcumulado() + arboles.getmCoeficiente(j, origen);
                        //si el nodo es vistado
                        if (subTotalAcumulado <= Nodo[j].getAcumulado() && Nodo[j].isVisitado() == true && Nodo[j].isEtiqueta() == false) {
                            Nodo[j].setAcumulado((int) subTotalAcumulado);
                            Nodo[j].setVisitado(true);
                            Nodo[j].setNombre(j);
                            Nodo[j].setPredecesor(Nodo[origen]);
                            //si el nodo no es visitado
                        } else if (Nodo[j].isVisitado() == false) {
                            Nodo[j].setAcumulado((int) subTotalAcumulado);
                            Nodo[j].setVisitado(true);
                            Nodo[j].setNombre(j);
                            Nodo[j].setPredecesor(Nodo[origen]);
                        }
                    }
                }

                //encontramos el camino mas corto
                for (int i = 0; i < tope; i++) {// buscamos cual de los nodos visitados tiene el acumulador menor para escogerlo
                    //obtiene el total acumulado y el auxiliar acumulado y los compara
                    //aca elige el camino mas corto
                    if (Nodo[i].isVisitado() == true && Nodo[i].isEtiqueta() == false) {//es visitado o no
                        if (Nodo[i].getAcumulado() <= auxiliarAcumulado) {
                            origen = Nodo[i].getNombre();
                            auxiliarAcumulado = Nodo[i].getAcumulado();
                        }
                    }
                }
                subTope++;
                lblKmRecorridos.setText("" + subTope);
            } while (subTope < tope + 1);
            
            nodoAuxiliar = Nodo[nodoFinal];
            if (nodoAuxiliar.getPredecesor() == null) {
                JOptionPane.showMessageDialog(null, "No se pudo llegar al nodo " + nodoFinal);
            }
            //pintamos los caminos recorridos o que tenemos que recorrer
            while (nodoAuxiliar.getPredecesor() != null) {//obtiene las coordenadas de las lineas
                pintarDibujos.pintaCamino(miJlabel.getGraphics(),
                        arboles.getCordeX(nodoAuxiliar.getNombre()),
                        arboles.getCordeY(nodoAuxiliar.getNombre()),
                        arboles.getCordeX(nodoAuxiliar.getPredecesor().getNombre()),
                        arboles.getCordeY(nodoAuxiliar.getPredecesor().getNombre()),
                        Color.BLUE);
                //obtiene el nodo seleccionado y le da un color
                pintarDibujos.seleccionNodo(miJlabel.getGraphics(),
                        arboles.getCordeX(nodoAuxiliar.getNombre()),
                        arboles.getCordeY(nodoAuxiliar.getNombre()),
                        null, Color.BLUE);
                nodoAuxiliar = nodoAuxiliar.getPredecesor();
            }//termina el while rrecorriendo los caminos
            
            //le damos el color al nodo del destino
            pintarDibujos.seleccionNodo(miJlabel.getGraphics(),
                    arboles.getCordeX(nodoFinal),
                    arboles.getCordeY(nodoFinal),
                    null, Color.RED);//Pintamos el nodo del destino

        } catch (Exception e) {

            System.out.println("ERROR: " + e);

        }

    }
}
