/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4uno;

/**
 *
 * @author Leo
 */
public class ParteEnteraIterativo implements Runnable{
    long h;
    
    public static long parte_entera_recursivo(long n) {
        long numero = 100000000;
        long bajo = 0;
        long alto = numero;
        long resultado = 0;
        boolean encontrado = false;

        // Realiza la busqueda binaria.
        while (bajo <= alto && !encontrado) {
            long medio = (bajo + alto) / 2;
            long cuadradoMedio = medio * medio;

            if (cuadradoMedio == numero) {
                resultado = medio; // Si medio^2 es igual al numero ingresado, entonces encontramos la raiz cuadrada exacta.
                encontrado = true;
            } else if (cuadradoMedio < numero) {
                bajo = medio + 1;
                resultado = medio; // Actualiza el resultado al mayor valor conocido cuya raiz cuadrada es < numero
            } else {
                alto = medio - 1;
            }
        }
        return resultado;
    }
    
    public void run(){
        parte_entera_recursivo(h);
    }
    
    public ParteEnteraIterativo(){
        h=10000;
    }
}
