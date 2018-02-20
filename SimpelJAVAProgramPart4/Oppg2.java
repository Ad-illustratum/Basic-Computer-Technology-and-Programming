package gr02lab04;

import java.util.Scanner;

public class Oppg2 {
//lager metode som tar for seg alle utrekningar og  sender i retur antall loysingar på likninga

    public static double utrekning(double a, double b, double c) {
        if ((b * b - 4 * a * c) > 0) {//Brukar if,else if, else lokker for kvart mulig tilfelle
            return 2;
        } else if ((b * b - 4 * a * c) == 0) {
            return 1;
        } else {
            return 0;
        }
    }
//denne metoden presenterer valgmuligheiter og gir info 

    public static void intro() {
        System.out.println("Dette programmet finn ut kor mange loysinger ein annengradslikning har.\nTast inn verdier for a,b og c.");
        System.out.println("aX*X+bX+c=0");
    }
//Metode som kun tar imot input, er fin å bruke om ein skal ha mykje input

    public static double verdier(String symbol) { // sender med tekst om hva du skal skrive inn.
        System.out.print(symbol + " = ");
        Scanner inn = new Scanner(System.in);
        return inn.nextDouble();//returnerer input til main program og gir verdi til ein variabel.
    }

    public static void main(String[] args) {
        double a, b, c;
//Her gir bruker verdi til 2.grads X, 1.grads X og til 0.grads X
        intro();
        a = verdier("x^2");
        if (a == 0) {//har satt if lokke her, fordi uten ein X i 2.grad, er ikkje dette ein annengradslikning
            System.out.println("Dette er ingen 2.gradslikning fordi den ikkje inneheld ein variabel i 2.grad");
            System.exit(0);//om ein tastar 0 på variabel a vil brukar få feilmelding og programmet vil avslutte
        }
        b = verdier("x");
        c = verdier("k");
        System.out.printf("Denne likninga har %.0f loysingar", utrekning(a, b, c));//utskrift med antall loysingar fraa utrekningmetoden.

    }

}
