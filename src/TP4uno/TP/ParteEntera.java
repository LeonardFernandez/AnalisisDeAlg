/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4uno;

/**
 *
 * @author Leo
 */
public class ParteEntera implements Runnable{
    long h;
    public static long parte_entera(long n) {
        if (n < 2) {// Casos triviales (n=0 o 1)
            return n;
        }

        long x = n;//
        long y = (x + 1) / 2;

        while (y < x) {
            x = y;
            y = (x + n / x) / 2;
        }

        return x;
    }
    
    public void run(){
        parte_entera(h);
    }
    
    public ParteEntera(){
        h=10000;
    }
}
