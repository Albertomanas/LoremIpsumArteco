package arteco.practica;

import arteco.practica.domain.Parser;

public class LoremIpsum {
    public static void main(String[] args){

        System.out.println("\n#####" + "\t Operaciones requeridas: \t" + "#####\n");

        System.out.println("5 primeros párrafos: \n" + Parser.parseLorem());
    }
}
