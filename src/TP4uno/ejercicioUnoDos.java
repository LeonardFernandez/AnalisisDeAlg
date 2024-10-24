/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4uno;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leo
 */
public class ejercicioUnoDos {
    
    public static long medirTiempoEjecucion(Runnable metodo) {
        long inicio = System.nanoTime();
        metodo.run();
        long fin = System.nanoTime();
        return fin - inicio;
    }
    
    public static void main(String[] args) {
        long tiemposRecursivo =0;
        long tiemposIterativo =0;
        long mediaRecursivo=0;
        long mediaIterativo=0;
        long tiempoI=0;
        long tiempoR=0;
        ParteEntera recursivo=new ParteEntera();
        ParteEnteraIterativo iterativo=new ParteEnteraIterativo();
        long[] arregloIterativo=new long[15];
        long[] arregloRecursivo=new long[15];

        // Ejecutar y medir 15 veces Método 1
        for (int i = 0; i < 15; i++) {
            tiempoR=medirTiempoEjecucion(recursivo);
            arregloRecursivo[i]=tiempoR;
            tiemposRecursivo=tiemposRecursivo+tiempoR;
        }

        // Ejecutar y medir 15 veces Método 2
        for (int i = 0; i < 15; i++) {
            tiempoI=medirTiempoEjecucion(iterativo);
            arregloIterativo[i]=tiempoI;
            tiemposIterativo=tiemposIterativo+tiempoI;
        }
        
        mediaIterativo=tiemposIterativo/15;
        mediaRecursivo=tiemposRecursivo/15;
        System.out.println("Tiempo total de metodo recursivo: "+tiemposRecursivo+"ns");
        System.out.println("Tiempo total de metodo iterativo: "+tiemposIterativo+"ns");
        System.out.println("Media aritmetica metodo recursivo: "+mediaRecursivo+"ns");
        System.out.println("Media aritmetica metodo iterativo: "+mediaIterativo+"ns");
        System.out.println("TABLA RECURSIVA");
        for (int i = 0; i < 15; i++) {
            System.out.println(arregloRecursivo[i]+"ns"+"    "+Math.abs(arregloRecursivo[i]-mediaRecursivo)+"ns");
        }


        System.out.println("TABLA ITERATIVA");
        for (int i = 0; i < 15; i++) {
            System.out.println(arregloIterativo[i]+"ns"+"    "+Math.abs(arregloIterativo[i]-mediaIterativo)+"ns");
        }

    }
}
