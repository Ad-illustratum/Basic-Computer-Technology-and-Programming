package gr02lab02;

import java.util.Scanner;

public class Oppgave3 {

    public static void main(String[] args) {

        Scanner inn = new Scanner(System.in);
        int antall = -1, i; // oppretter en teller variabel. 
        double total = 0; // oppretter en variabel for summen av motstandene.
        char valg = 'e'; // oppretter en varibel for bokstaver setter den lik en bokstav slik at while lokken vil starte.

        System.out.print("Programm for utrekning av motstander i serie eller paralell kobling.\n\n"); // Velkomstmelding til bruker.        
        System.out.print("Velg serie eller paralell(s/p) eller du kan avslutte programmet med å trykke (q): "); // brukermelding om valg.

        while (valg != 'p' && valg != 's' && valg != 'q') { // while lokke der kreterie for å komme vidre er at du valg blir lik p, q eller s.
            valg = inn.next().charAt(0); // Innlesning av om bruker ønsker å regne motstander i paralell eller i serie eller ønsker å avslutte,  
            //ignorerer bokstaver etter forste bokstav. saa det vil si at du kan skrive serie eller paralell og komme vidre
            if (valg != 'p' && valg != 's' && valg != 'q') { // feil melding vist noe annet enn p, q eller s er forste bokstav som blir tast inn
                System.out.print("Du valgte feil. Prove igjen.\nVelg serie eller paralell(s/p) eller du kan avslutte programmet med å trykke (q): ");
            }
        }
        if (valg == 'q') { // vis du trykker q avsluttes programmet
            System.out.println("\nDu har avsluttet programmet\n"); // melding om at programmet er avsluttet
            System.exit(0); // avslutter programmet
        }
        System.out.print("\nSkrive inn antall motstander: "); // melding om hva du skal trykke inn

        while (antall <= 0) {// lager en while lokke slik at bruker må bruke rett verdi
            antall = inn.nextInt(); // leser inn antall motstander du hvil bruke
            if (antall <= 0) {
                System.out.print("Du ga ugyldig verdi\nSkrive inn antall motstander: ");//feil melding
            }
        }
        double[] list = new double[antall]; // oppretter en liste som lager antall motstander du skal legge sammen
        System.out.println("");// mellom rom

        for (i = 0; i < antall; i++) { // lager en for lokke som teller gjennom antall inn lesninger

            System.out.print("Skriv inn resistansen til " + (i + 1) + " motstand:\t"); // melding om hvilken motstand brukeren skriver inn
            list[i] = inn.nextDouble(); // lager motstands verdiene i listen
            if (list[i] <= 0) { // fjerner motstanden fra listen vis det er en ugyldig verdi
                System.out.println("Ikke gyldig verdi, skriv på nytt");
                i--;
            }
        }
        if (valg == 's') { // if lokke for serie kobling
            System.out.println("\nSystemet var koblet i serie\n");// melding om hvordan systemet var koblet
            for (i = 0; i < antall; i++) { // skriver ut motstands verdie fra listen kronolaagisk
                System.out.println(" Resistans " + (i + 1) + " har motstand:  " + list[i] + " Ω");
                total += list[i]; // henter en og en verdi fra listen og + dem in i total
            }
            System.out.printf("\nDen samla motstanden i systemet er: %.3f Ω\n\nProgramet er avsluttet\n", total); // skriver ut motstands verdiene med plass til 3 desimaler
        }
        if (valg == 'p') { // if lokke for paralell kobling 
            System.out.println("\nSystemet var koblet i Parallell\n");// melding om hvordan systemet var koblet
            for (i = 0; i < antall; i++) { // skriver ut motstands verdie fra listen kronolaagisk
                System.out.println(" Resistans " + (i + 1) + " har motstand:  " + list[i] + " Ω");
                total += (1 / list[i]);// henter en og en verdi fra listen og deler motstand på 1 og + dem in i total
            }
            total = (1 / total);
            System.out.printf("\nDen samla motstanden i systemet er: %.3f Ω\n\nProgramet er avsluttet\n", total);// skriver ut motstands verdiene med plass til 3 desimaler
        }
    }
}
