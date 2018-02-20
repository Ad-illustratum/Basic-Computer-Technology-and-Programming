package gr02lab03;

import java.util.Scanner;

public class Oppgave2 {

    public static void main(String[] args) {

        Scanner inn = new Scanner(System.in); //oppretter en scanner for å lese fra tastatur

        System.out.print("Dette er et program som lager tilfeldige tall fra 0-10 etter hvor mange brukeren vil ha, og regner ut gjennnomsnittet.\n"
                + "Og lager en liste over tall som ble generet. Skriv inn antall tilfeldige tall: ");//bruker melding

        int antall = inn.nextInt(); //deklarer og setter den til verdien lest inn fra tastatur

        double total = 0; // oppretter en double variabel og setter den lik 0

        int[] list = new int[antall]; // oppretter en samle liste og setter lengden på den lik antall
        int[] telleliste = new int[11];// oppretter en liste som teller antall tall med verdi fra 0 til 10

        for (int i = 0; i < antall; i++) { //forlokke som kjører antall ganger du har satt antall til
            list[i] = (int) Math.floor(Math.random() * 11);//generer et random tall mellom 0 og 10 og lager det i list på sin plass       
            total += list[i]; // legger plusser på hvert tall til total etterhvert som de blir generet
            telleliste[list[i]]++; // teller opp antall tall av hvert tall i telleliste og oker verdien med en hver gang tallet kommer, siden array starter på verdi 0
        }

        System.out.printf("\nGjennomsnittet av elementa er: %.3f \n\n", (total / antall));//utskrift av gjennomsnittet

        for (int i = 0; i < telleliste.length; i++) { // forlokke for aa skrive ut
            System.out.println(i + " verdien " + telleliste[i]); // skriver ut antall mellom 0-10 tall som har blitt generet.         
        }

        System.out.println(); // for det estatiske
    }

}
