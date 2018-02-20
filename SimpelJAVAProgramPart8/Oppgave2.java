package fr02lab08;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Oppgave2 {

    public static long oppdateretiden(Calendar cal) { //oppretter en metode som oppdaterer tiden til et gitt oyeblikk
        cal = Calendar.getInstance();
        return cal.getTimeInMillis(); // sender tilbake oyblikks tiden i millisekunder, variabel long.
    }

    public static void main(String[] args) {
        // TODO code application logic here

        Calendar cal = new GregorianCalendar(); // oppretter en kalender for bruk til tid og dato
        long start, stopp; // oppretter to long variabler
        String valg; // oppretter en string for tekst
        Scanner inn = new Scanner(System.in); // inn lesning fra tastatur
        int a, b; // heiltall variabler

        do {//do while lokke som avsluttes naar brukeren trykker 'q'
            //info til brukeren
            System.out.println("Dette er et program som generer et tilfeldigit\nheiltall og måler hvor lang tid du bruker på aa skrive det inn.\nTrykk 's' for aa starte\nTrykk 'q' for aa avslutte");
            valg = inn.nextLine(); // innlesning om han vil starte

            if (valg.equalsIgnoreCase("s")) { // if lokke som ser at brukeren vil kjore programet
                start = oppdateretiden(cal); //tar tiden i det programet begynner.
                a = (int) Math.floor(Math.random() * 101); //generer et heltall fra 0 til 100.
                System.out.print("\nSkriv inn heiltallet: " + a + "\nSkriv inn heiltallet saa fort saa mulig: "); // skriver ut tallet til brukeren
                do { //dowhile lokke som ser om tallet som brukeren skriver inn er likt med det generete                   
                    b = inn.nextInt(); // innlesning av tall
                    inn.nextLine();    //fjerner enter               
                } while (a != b);
                stopp = oppdateretiden(cal); //faar tiden etter han har klart aa skrive inn rett tall.
                //skriver ut 
                System.out.printf("Du brukte: %02d:%02d:%02d på aa skrive inn heiltallet.\n\n", (stopp - start) / 60 / 1000 % 60, (stopp - start) / 1000 % 60, (stopp - start) / 10 % 100);
            }
        } while (!valg.equalsIgnoreCase("q"));

    }
}
