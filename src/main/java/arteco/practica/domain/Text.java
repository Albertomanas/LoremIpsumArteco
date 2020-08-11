package arteco.practica.domain;


import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

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

    //Identificar y sacar las 5 palabras más repetidas del texto.
    public static Map<String, Integer> topCincoPalabrasRepetidas(String lorem) {
        HashMap<String, Integer> filtrarPalabras = new HashMap<>();
        String texto = quitarSignos(lorem);
        StringTokenizer st = new StringTokenizer(texto);

        while (st.hasMoreTokens()){
            String palabras = st.nextToken();
            filtrarPalabras.compute(palabras, (palabra, cantidad) -> (cantidad == null) ? 1 : cantidad +1);
        }
        //LinkedMap para que salga ordenado
        LinkedHashMap mapaOrdenado = filtrarPalabras.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(5)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (key, value) -> value,
                        LinkedHashMap::new));
        return mapaOrdenado;
    }

}
