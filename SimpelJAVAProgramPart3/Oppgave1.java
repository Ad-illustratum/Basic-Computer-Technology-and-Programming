package gr02lab03;

import java.util.Scanner;

public class Oppgave1 {

    public static void main(String[] args) {
        String tekst, snudd = "";//deklarer String for original inputtekst og ein for den snudde teksten
        Scanner inn = new Scanner(System.in);//input frå bruker

        System.out.print("Dette er eit program som snur all tekst du skriver inn.\n\nSkriv inn tekst:\t");//bruker info
        tekst = inn.nextLine(); //innlesning fra tastatur
        int lengde = tekst.length();//bruker lengden på teksten til å definere kor mange runder for-lokken min ska koyre

        //Lager ei for lokke som begynner på den siste bokstaven i ordet/setningen og tar med seg alle bokstavene, heilt til begynnelsen på ordet
        for (int i = lengde - 1; i >= 0; i--) {
            snudd += tekst.charAt(i);
        }
        System.out.println("\nDen snudde teksten:\t" + snudd + "\n"); //utskrift til brukeren
    }

}
