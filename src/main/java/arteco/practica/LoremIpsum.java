package arteco.practica;

import arteco.practica.domain.Parser;
import arteco.practica.domain.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class LoremIpsum {
        public static void main(String[] args){

            String lorem = Parser.parseLorem();

            System.out.println("\n#####" + "\t Operaciones requeridas: \t" + "#####\n");

            System.out.println("5 primeros párrafos: \n\n" + lorem + "\n");

            System.out.println("El texto contiene: " + Text.contarPalabras(lorem) + " palabras." + "\n");

            System.out.println("El texto contiene: " + Text.contarFrases(lorem) + " frases." + "\n");

            System.out.println("El texto contiene: " + Text.contarParrafos(lorem) + " parrafos." + "\n");

            System.out.println("\n#####" + "\t Palindromos: \t" + "#####\n");

            System.out.println("El texto contiene: " + Text.contarPalindromos(lorem).size() + " palindromos." + "\n");

            System.out.println("Los cuales son: " + Text.contarPalindromos(lorem) + "\n");

            System.out.println("\n#####" + "\t 5 palabras más frecuentadas en el texto: \t" + "#####\n");

            System.out.println("Las cuales son: " + Text.topCincoPalabrasRepetidas(lorem) + "\n");

            System.out.println("\n#####" + "\t 5 tuplas más frecuentadas en el texto: \t" + "#####\n");

            System.out.println("Las cuales son: " + Text.topTuplasRepetidas(lorem) + "\n");

        }
}
