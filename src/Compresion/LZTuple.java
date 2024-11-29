/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Compresion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leo
 */
public class LZTuple {

    int offset;     //Pasos hacia atras
    int length;     //Cuantos caracteres toma a partir de offset
    char nextChar;  //Siguiente caracter

    LZTuple(int offset, int length, char nextChar) {
        this.offset = offset;
        this.length = length;
        this.nextChar = nextChar;
    }

    @Override
    public String toString() {
        return "(" + offset + ", " + length + ", '" + nextChar + "')";
    }

    public static List<LZTuple> compress(String input, int windowSize) {
        List<LZTuple> compressed = new ArrayList<>();
        int cursor = 0;
        int tamanioInput=input.length();

        while (cursor < tamanioInput) {
            int matchLength = 0;
            int matchOffset = 0;
            char nextChar = input.charAt(cursor);

            // Buscar coincidencias en la ventana de búsqueda
            int inicioVentBusqueda = Math.max(0, cursor - windowSize);
            //Recorremos la ventana de busqueda
            for (int cursorBusqueda = inicioVentBusqueda; cursorBusqueda < cursor; cursorBusqueda++) {
                int numCoincidencias = 0; //numero de coincidencias encontradas entre ventana de busqueda y ventana post-cursor
                /*Mientras 
                1. se evaluen coincidencias dentro de la ventanaBusqueda
                2. no nos pasemos de la longitud del input*/
                while (numCoincidencias < (cursor - cursorBusqueda) && cursor + numCoincidencias < tamanioInput && input.charAt(cursorBusqueda + numCoincidencias) == input.charAt(cursor + numCoincidencias)) {
                    numCoincidencias++;
                }

                if (numCoincidencias > matchLength) {
                    matchLength = numCoincidencias;
                    matchOffset = cursor - cursorBusqueda;
                }
            }

            // Siguiente carácter después de la coincidencia
            if (cursor + matchLength < tamanioInput) {
                nextChar = input.charAt(cursor + matchLength);
            } else {
                nextChar = '\0'; // Final del texto
            }

            // Agregar la tripleta a la lista comprimida
            compressed.add(new LZTuple(matchOffset, matchLength, nextChar));
            cursor += matchLength + 1; // Avanzar el cursor
        }

        return compressed;
    }

    public static void main(String[] args) {
        String input = "acabca";
        int windowSize = 5;

        List<LZTuple> compressed = compress(input, windowSize);

        System.out.println("Texto original: " + input);
        System.out.println("Texto comprimido: " + compressed);
    }
}
