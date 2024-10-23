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
        ParteEntera recursivo=new ParteEntera();
        ParteEnteraIterativo iterativo=new ParteEnteraIterativo();

        // Ejecutar y medir 15 veces Método 1
        for (int i = 0; i < 15; i++) {
            tiemposRecursivo=tiemposRecursivo+medirTiempoEjecucion(recursivo);
        }

        // Ejecutar y medir 15 veces Método 2
        for (int i = 0; i < 15; i++) {
            tiemposIterativo=tiemposIterativo+medirTiempoEjecucion(iterativo);
        }
        
        mediaIterativo=tiemposIterativo/15;
        mediaRecursivo=tiemposRecursivo/15;
        System.out.println("Tiempo total de metodo recursivo: "+tiemposRecursivo+"ns");
        System.out.println("Tiempo total de metodo iterativo: "+tiemposIterativo+"ns");
        System.out.println("Media aritmetica metodo recursivo: "+mediaRecursivo+"ns");
        System.out.println("Media aritmetica metodo iterativo: "+mediaIterativo+"ns");
    }
}
