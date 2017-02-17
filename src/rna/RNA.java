/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rna;

import java.util.Arrays;

/**
 *
 * @author Jose Arcos
 */
public class RNA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        float polarizacion = 1.5F;
        int[][] entradas = {{-1,-1}, {-1,1}, {1,-1}, {1,1}};
        int[][] pesos = {{1,1}};
        int[] salidas = {0, 0, 0, 1};
        double b = -1.0;
        double a, wp;
//        int[][] rel = multimatriz(entradas, pesos);
        for (int[] entrada : entradas) {
            wp = entrada[0] + entrada[1] + b;
            a = hardlim( wp );
            System.out.println("Entadas: (" + entrada[0] + ",\t" + entrada[1] + ") \t=>\t" + a);
        }
        System.out.println("Hola Mundo");

    }

    public static int[][] multimatriz(int[][] m1, int[][] m2) {

        int fil_m1 = m1.length;
        int col_m1 = m1[0].length;

        int fil_m2 = m2.length;
        int col_m2 = m2[0].length;

        if (col_m1 != fil_m2) {
            throw new RuntimeException("No se pueden multiplicar las matrices");
        }

        int[][] multiplicacion = new int[fil_m1][col_m2];

        for (int x = 0; x < multiplicacion.length; x++) {
            for (int y = 0; y < multiplicacion[x].length; y++) {
                for (int z = 0; z < col_m1; z++) {
                    multiplicacion[x][y] += m1[x][z] * m2[z][y];
                }
            }
        }

        return multiplicacion;

    }

    public static int hardlim(double w) {
        if (w > 0.0) {
            return 1;
        } else {
            return 0;
        }
    }

}
