package arteco.practica.domain;


import java.util.Scanner;
import java.util.StringTokenizer;

public class Text {

    //contador de palabras por linea
    public static Integer contarPalabras(String lorem) {
        Scanner sc = new Scanner(lorem);
        int contador = 0;
        while(sc.hasNext()) {
            sc.next();
            contador ++;
        }
        sc.close();
        return contador;
    }

    //contador de frases.
    public static Integer contarFrases(String lorem) {
        int contador = 0, posicion;
        lorem = lorem.trim();
        // eliminar posibles espacios en blanco del inicio y el final
        if (lorem.isEmpty()) { //solo si la cadena está vacía
            contador = 0;
        } else {
            posicion = lorem.indexOf(".");
            while (posicion != -1) {
                contador ++;
                posicion = lorem.indexOf(".", posicion + 1);
            }
        }
        return contador;
    }


}

