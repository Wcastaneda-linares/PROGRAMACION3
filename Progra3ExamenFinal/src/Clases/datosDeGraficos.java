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
public class datosDeGraficos {

    //acá recibe la matriz de adyacencia y de los coeficientes
    private final double matrizCoeficiente[][] = new double[51][51];
    private final int matrizAdyacencia[][] = new int[51][51];
    private final int coordenadaX[] = new int[51];
    private final int coordenadaY[] = new int[51];
    private final String nombre[] = new String[51];
    private int enArbol[];

    public datosDeGraficos() {

    }

    public double getmCoeficiente(int i, int j) {
        return matrizCoeficiente[i][j];
    }

    public int getmAdyacencia(int i, int j) {
        return matrizAdyacencia[i][j];
    }

    public int getCordeX(int i) {
        return coordenadaX[i];
    }

    public int getCordeY(int i) {
        return coordenadaY[i];
    }

    public String getNombre(int i) {
        return nombre[i];
    }

    public int getEnArbol(int i) {
        return enArbol[i];
    }

    public void setmCoeficiente(int i, int j, double mCoeficiente) {
        this.matrizCoeficiente[i][j] = mCoeficiente;
    }

    public void setmAdyacencia(int i, int j, int mAdyacencia) {
        this.matrizAdyacencia[i][j] = mAdyacencia;
    }

    public void setCordeX(int i, int cordeX) {
        this.coordenadaX[i] = cordeX;
    }

    public void setCordeY(int i, int cordeY) {
        this.coordenadaY[i] = cordeY;
    }

    public void setNombre(int i, String nombre) {
        this.nombre[i] = nombre;
    }

    public void setEnArbol(int i, int enArbol) {
        this.enArbol[i] = enArbol;
    }

    public void crearArbol(int i) {
        enArbol = new int[i];
    }
}
