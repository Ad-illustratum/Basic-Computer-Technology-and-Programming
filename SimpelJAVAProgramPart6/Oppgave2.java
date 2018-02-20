
package gr02lab06;

import java.util.Scanner;

public class Oppgave2 {

    public static void main(String[] args) {
        Scanner inn = new Scanner(System.in); //oppretter en Scanner for aa lese inn fra tasttur
        String valg; // oppretter en texst streng variabel
        Terning[] t = new Terning[3]; //oppretter en liste for 3 objekter
        t[0] = new Terning(); // oppretter objekt 1 i listen
        t[1] = new Terning(); // oppretter objekt 2 i listen
        t[2] = new Terning(); // oppretter objekt 3 i listen
        int like; //opprettter en heltalls variabel
        do { //oppretter en do while lokke som kjorer frem til valg = 'q' 
            //velkomst melding til brukeren
            System.out.println("Velkommen!\nDette er et program som simulerer hvor mange ganger 3 terninger "
                    + "far samme tall verdi.\n\nTrykk enter for aa simulere eller trykk 'q' for aa avslutte");
            valg = inn.nextLine(); // leser inn fra tastaturet til valg.
            like = 0; // heltalls variablen til null her slik at vist du kjorer programet flere gang saa starter den pa 0.
            for (int i = 0; i < 1000; i++) { // bruker en for lokke som teller opp til 1000 siden alle tre treinger skulle kastes 1000 ganger
                for (int j = 0; j < 3; j++) { // oppretter en for lokke som kjorer gjennom alle objektene
                    t[j].kast(); // bruker metoden kast i klassen Terning 
                }
                if (t[0].getnub() == t[1].getnub() && t[2].getnub() == t[1].getnub()) {
                    like++; // if lokke som blir kjort vist alle 3 treningene har samme verdi og legger till 
                }
            }// utskrift av antall like treninger
            System.out.println("antall ganger alle tre terningene har samme verdi: " + like + "\n");
        } while (!valg.equalsIgnoreCase("q"));
    }
}

class Terning { // oppretter en classe terning

    private int tall; // oppretter en int variabel som kunn gjelder for denne klassen

    void kast() { // en medtode som setter tall lik et tilfeldig tall.
        tall = (int) Math.floor(Math.random() * 6 + 1); //generer et heltall mellom 1-6. 
    }

    int getnub() { // metode som sender verdien til tall til denne klassen til en annen klasse.
        return tall;
    }
}
