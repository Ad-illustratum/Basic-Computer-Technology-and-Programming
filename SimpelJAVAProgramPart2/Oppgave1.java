package gr02lab02;

import java.util.Scanner;

public class Oppgave1 {

    public static void main(String[] args) {

        Scanner inn = new Scanner(System.in); // Oppretter scanner for lesing av variabler

        int linjer, tegn; // oppretter variabler for hel tall
        char symbol; // oppretter variabel for symbol

        System.out.println("Programm for tegning av rombe.");

        System.out.print("Skriv hvilke type tegn eller bokstav du vil bruke i romben:\t");
        symbol = inn.next().charAt(0); // leser kunn inn første tegn som blir tastet inn 

        System.out.print("Skriv antall tegn per linje:\t");
        tegn = inn.nextInt(); // leser inn antall teign på horrisontal linje

        System.out.print("Skriv antall horisontale linjer:\t");
        linjer = inn.nextInt();// leser inn antall vertikale liner

        System.out.println("\nHorisontale linjer:\t" + linjer + "\nTegn pr. linje:\t\t" + tegn + "\nTegn/Symbol:\t\t" + symbol + "\n");
        for (int i = 0; i < linjer; i++) {  // for lokke som teller linjer nedover
            for (int o = 0; o < i; o++) { // for lokke som teller mellom slik at det blir formet som en rombe
                System.out.print(" ");
            }
            for (int p = 0; p < tegn; p++) {//for lokke som skriver ut antall symbol per linje etter valgt antall
                System.out.print(symbol);
            }
            System.out.println("");

        }
        System.out.println("");
    }

}
