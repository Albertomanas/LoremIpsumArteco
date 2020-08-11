package arteco.practica.domain;


import java.util.*;

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
            // REVISAR, PUEDE CONTENER EN CASOS ;
            while (posicion != -1) { //indexOf si no encuentra nada devuelve -1
                contador ++;
                posicion = lorem.indexOf(".", posicion + 1);
            }
        }
        return contador;
    }

    //contador de párrafos
    public static Integer contarParrafos(String lorem) {
        int contador = 0;
        String saltoLinea = "\n";
        while (lorem.indexOf(saltoLinea) > -1) {
            lorem = lorem.substring(lorem.indexOf(saltoLinea) + saltoLinea.length());
            contador++;
        }
        return contador;
    }

    //limpiar texto de signos de puntuación
    public static String quitarSignos(String lorem) {
        lorem = lorem.replaceAll("[.,:;?!]", "").toLowerCase();
        return lorem;
    }

    //Lista de palindromos
    public static List<String> contarPalindromos(String lorem) {
        String texto = quitarSignos(lorem);
        ArrayList<String> filtrarPalindromo = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(texto);
        while (st.hasMoreTokens()) {
            //buscamos palabra por palabra
            String palabra = st.nextToken();
            int i = 0;
            int inc  = 0;
            int des = palabra.length() - 1;
            for (i = inc = 0; i <= des; i++) {
                //letra inicial == final pasa la condición y se almacena
                if (palabra.charAt(inc) == palabra.charAt(des)) {
                    inc++;
                    des--;
                }
            }
            //filtrar para que el palindromo sea > 1
            int mid = (inc + des)/2;
            if (i == mid + 1 && mid >= 1) {
                filtrarPalindromo.add(palabra);
            }
        }
        return filtrarPalindromo;
    }

    //Identificar tipos distintos de palabras que aparecen en el texto.
    public static HashMap<String, Integer> contarPalabrasRepetidas(String lorem) {
        HashMap<String, Integer> filtrarPalabras = new HashMap<>();
        String texto = quitarSignos(lorem);
        StringTokenizer st = new StringTokenizer(texto);

        while (st.hasMoreTokens()){
            String palabras = st.nextToken();
            filtrarPalabras.compute(palabras, (palabra, cantidad) -> (cantidad == null) ? 1 : cantidad +1);
        }
        return filtrarPalabras;
    }

    //Sacar las 5 palabras más frecuentadas en el texto.
    /*public static ArrayList<String> filtroTopCincoPalabras(HashMap filtro) {

        ArrayList filtrarPalabras = new ArrayList<>(filtro.keySet());
        Collections.sort(filtrarPalabras);
        return filtrarPalabras;
    }

     */

    /*public HashMap<String, Integer> filtroTopCincoPalabras(HashMap<String, Integer> filtro) {
        HashMap<String, Integer> filtrarPalabras = new HashMap<String, Integer>();

        while (filtrarPalabras.isEmpty() && filtrarPalabras.size() < 5) {
            int contador = 0;
            for (int valor : filtro.values()) {
                if (valor > contador) {
                    contador = valor;
                }
            }
            for (String palabra : filtro.keySet()) {
                if (filtro.get(palabra) == contador) {
                    return palabra;
                }
            }
            String freqWord = filtro.keySet();
            filtrarPalabras.put(freqWord, filtrarPalabras.get(freqWord));
        }
        return filtrarPalabras;
    }

     */
}
