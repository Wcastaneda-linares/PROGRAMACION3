/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.util.Arrays;

/**
 *
 * @author Wclinares
 */
public class EliminarDuplicados {

    public static void main(String[] args) {
        int[][] test = new int[][]{
            {1, 1, 2, 2, 3, 4, 5},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 2, 3, 4, 5, 6, 7},
            {1, 2, 1, 1, 1, 1, 1},};

        for (int[] num : test) {
            eliminarDuplicadosDelArreglo(num);
            System.out.println("\n");
        }
    }

    public static void eliminarDuplicadosDelArreglo(int[] indice) {

        Arrays.sort(indice);
        System.out.println("Arreglo Original = " + Arrays.toString(indice));
        int Cont_de_duplicados = 0;
        int antes = indice[0];
        for (int i = 0; i < indice.length - 1; i++) {
            if (antes == indice[i + 1]) {
                Cont_de_duplicados++;
            }
            antes = indice[i + 1];
        }

        int contador = 0;
        int[] resultado = new int[indice.length - Cont_de_duplicados];
        antes = indice[0];
        resultado[contador] = antes;
        for (int i = 0; i < indice.length - 1; i++) {
            if (antes != indice[i + 1]) {
                resultado[++contador] = indice[i + 1];
            }
            antes = indice[i + 1];
        }

        Arrays.sort(resultado);
        System.out.println("Despues de eliminar los duplicados " + Arrays.toString(resultado));
    }
}
