/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

/**
 *
 * @author Wclinares
 */
public class ej4 {
    static int DAC_Max(int a[], int index, int l) {
        int max;

        if (index >= l - 2) {
            if (a[index] > a[index + 1]) {
                return a[index];
            } else {
                return a[index + 1];
            }
        }

        max = DAC_Max(a, index + 1, l);

        if (a[index] > max) {
            return a[index];
        } else {
            return max;
        }
    }

    static int DAC_Min(int a[], int index, int l) {
        int min;
        if (index >= l - 2) {
            if (a[index] < a[index + 1]) {
                return a[index];
            } else {
                return a[index + 1];
            }
        }

        min = DAC_Min(a, index + 1, l);

        if (a[index] < min) {
            return a[index];
        } else {
            return min;
        }
    }

    public static void main(String[] args) {
        int min, max;

        int a[] = {70, 250, 50, 80, 140, 12, 14};
        max = DAC_Max(a, 0, 7);
        min = DAC_Min(a, 0, 7);

        System.out.printf("El numero minimo en "
                + "la matriz dada es : %d\n", min);
        System.out.printf("El numero maximo "
                + "en la matriz dada es : %d", max);
    }
}
