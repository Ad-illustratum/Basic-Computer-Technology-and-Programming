
package gr02lab06;

import java.util.Scanner;

public class Oppgave3 {

    public static void meny() {//lagar ein meny metode til aa presentere pprogrammet
        System.out.println("*******************************************************************************\nDette er eit program som beregner ut en tilnearming av\n"
                + "areale av en sirkel med hjelp av montecalro metoden\n*******************************************************************************");

    }

    public static double getdesimal(String navn, String maaleenhet, Scanner inn) {//en metode for å lese inn desimataltall og som sjekker tallet er mindre eller lik 0.       
        double tall; //oppretter en desimaltall variabel
        do {// do while lokke som kjorer til du faar et storre tall enn 0.
            System.out.print("\nSkriv inn " + navn + " i " + maaleenhet + ": ");// en oppen utskrift som hvor resten av teksten blir til sendt fra main programet
            tall = inn.nextDouble();//leser inn tall verdi
            if (tall <= 0) { // if lokke som gir feilmeldig vis tallet er mindre eller lik 0
                System.out.println("Du valgte negativ verdi eller 0!\nRadiusen kan ikke negativ eller 0 prøv igjen"); // utskrift feilmelding
            }
        } while (tall <= 0);
        inn.nextLine();//fjerner enter
        return tall; //sender tilbake verdien på tallet
    }

    public static int getheiltall(String navn, String maaleenhet, Scanner inn) {//en metode for å lese inn desimataltall og som sjekker tallet er mindre eller lik 0.       
        int tall; //oppretter en heiltall variabel
        do {// do while lokke som kjorer til du faar et storre tall enn 0.
            System.out.print("\nSkriv inn " + navn + " " + maaleenhet + ": ");// en oppen utskrift som hvor resten av teksten blir til sendt fra main programet
            tall = inn.nextInt();//leser inn tall verdi
            if (tall <= 0) { // if lokke som gir feilmeldig vis tallet er mindre eller lik 0
                System.out.println("Du valgte negativ verdi eller 0!\nAntall prikker kan ikke være negative eller 0 prøv igjen"); // utskrift feilmelding
            }
        } while (tall <= 0);
        inn.nextLine();//fjerner enter
        return tall; //sender tilbake verdien på tallet
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner inn = new Scanner(System.in); // oppretter en Scanner
        Montecarlo m1 = new Montecarlo(); // oppretter et objekt i montecarlo classen
        meny(); // bruker void metoden for aa skrive ut menyen
        m1.radius = getdesimal("radius", "meter", inn); //bruker getdesimal for aa faa et desimaltall til radius i objektet
        m1.antall = getheiltall("antall", "prikker", inn); //bruker getheiltall for aa faa et heiltall til antall i objektet
        m1.utregning(); //bruker metoden utregning i classen montecarlo for objektet

    }
}

class Montecarlo {

    private double  tilnaerming, punktx, punkty, innenfor = 0, sirkel; // oppretter desimal variabler som er private for classen
    double radius; // oppretter en desimal variabl
    int antall; // oppretter en heiltall variabl

    void utregning() { //oppretter en metode for ut regning og ut skrift siden mange av variablene er private
        for (int i = 0; i < antall; i++) { // en for lokke som kjorer programmet etter antall prikker som skal lages

            punktx = Math.floor(Math.random() * (radius + radius) - radius); //generer en x kordinat innfor firkanten
            punkty = Math.floor(Math.random() * (radius + radius) - radius); //generer en y kordinat innfor firkanten
            if (Math.pow(punktx, 2) + Math.pow(punkty, 2) <= Math.pow(radius, 2)) { //if lokke som sjekker om punketet er innen for sirklen
                innenfor++; // legger til en  i innenfor hvist punket er innenfor sirkelen
            }
        }
        tilnaerming = Math.pow((2 * radius), 2) * (innenfor / antall); // formel for aa regne ut en tilnaerming av sirkeln
        sirkel = Math.PI * radius * radius;//utregning av en vanlig sirkel
        //utskrift til brukeren        
        System.out.printf("\nTilnearmings verdi med bruk av Montecarlo metoden\nTilnearming  \t= %.3fm", tilnaerming); 
        System.out.printf("\nVanlig ut regning av arealet av en sirkel\nNoyaktig  \t= %.3fm", sirkel);
        System.out.printf("\nAvik  \t\t= %.3fm\n\n", (Math.abs(tilnaerming - sirkel))); // bruker absolutt verdi av tallet som blir regnet ut som avvik
    }
        //oppgaven kunne ha vert skrevet i et lite hovedprogram men har valg a legge det i en klasse. 
}       //forbedring kunne ha vert aa gjort slik at du ikke kan ha samme punkt i sirkel for aa fa programet mer noyaktig.