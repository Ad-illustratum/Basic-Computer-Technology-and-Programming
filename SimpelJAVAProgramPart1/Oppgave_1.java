
package gr02lab01;

import java.util.Scanner;

public class Oppgave_1 {

    public static void main(String[] args) {
        double u, i, r, p; //oppretter variabler
        Scanner inn = new Scanner(System.in); // av lesning fra tastatur

        System.out.println("Dette er et simpelt regne program som regner motstand og effekt");
        //Leser inn verdien for sturm fra tastatur
        System.out.print("\nSkrive inn ampere/strum \t");
        i = inn.nextDouble();
        // Leser inn verdien for spenning fra tastatur
        System.out.print("\nSkrive inn volt/spenningen \t");
        u = inn.nextDouble();

        //lager en if blokk som tar hensyn til hvist strumen er null
        if (i != 0) {
            r = u / i;
            p = u * i;
            System.out.println("\nmotstand\t " + r + " Ohm");
            System.out.println("effekt\t\t " + p + " W\n");
        } else if (i == 0) {
            p = u * i;
            // hvist strummen blir 0 hvil du få ikke definer pga alt du deler med null er tull 
            System.out.println("\nmotstand\t " + "ikke definert");
            System.out.println("effekt\t\t " + p + " W\n");

        }
    }

}
