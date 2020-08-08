package arteco.practica;

import arteco.practica.domain.Parser;
import arteco.practica.domain.Text;

public class LoremIpsum {
    public static void main(String[] args){

        String lorem = Parser.parseLorem();

        System.out.println("\n#####" + "\t Operaciones requeridas: \t" + "#####\n");

        System.out.println("5 primeros párrafos: \n\n" + lorem + "\n");

        System.out.println("El texto contiene: " + Text.contarPalabras(lorem) + " palabras." + "\n");

        System.out.println("El texto contiene: " + Text.contarFrases(lorem) + " frases." + "\n");

        System.out.println("El texto contiene: " + Text.contarParrafos(lorem) + " parrafos." + "\n");

    }
}
