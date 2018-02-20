package fr02lab08;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Oppgave3 {

    public static int antalldager(int year, int month, GregorianCalendar cal) {//metode som angir antall dager i manden sender aar maaned og gregoriankalender til metoden

        int mdag = 31;// max dager i en maaned
        boolean skuddar = cal.isLeapYear(year);//sjekker om det er skuddaar

        if (month == 3 || month == 5 || month == 8 || month == 10) {// disse mandene har bare 30 dager
            mdag = 30;
        }
        if (month == 1) { // februar har bare 28 dager til vanlig
            mdag = 28;
        }
        if (month == 1 && skuddar) { // ved skudd aar har februar 29 dager 
            mdag = 29;
        }
        return mdag; //retunerer max dager.
    }

    public static void main(String[] args) {

        Scanner inn = new Scanner(System.in); // oppretter en Scanner for innlesning fra tastatur       
        String s;//oppretter en string 
        Calendar cal = new GregorianCalendar(); // oppretter en kalender for bruk til tid og dato
        String[] dagavuke = {"nei", "sundag", "mandag", "tirsdag", "onsdag", "torsdag", "fredag", "laurdag"}; //lager et array med dagene inni
        int month, year, dag, maxd;// oppretter heltalls verdier
        do { //lager en dowhile lokke som ser til at datoen stemmer
            System.out.println("Skriv inn dato(dd.mm.yyyy)"); //info til brukeren om at han maa skrive inn en dato i denne rekeførlgen
            s = inn.nextLine(); // leser datoen in som en streng.
            String[] s1 = s.split("[:. ;,*-+/]");// spliter strenger. tar hoyde for at brukeren kan bruke andre symboler en hva som er oppgitt
            //symbolene som blir splittet på er de i mellom [] om en bruker flere eller bare enn saa vil det bli tatt bort.
            dag = Integer.parseInt(s1[0]); //converterer det forste heltallet(dag) til en int verdi
            month = Integer.parseInt(s1[1]) - 1;//converterer det andre heltallet(maande) til en int verdi og trekker fra en for aa faa det til aa stemme med calendar classen
            year = Integer.parseInt(s1[2]);//converterer det tredje heltallet(aar) til en int verdi
            maxd = antalldager(year, month, (GregorianCalendar) cal); // bruker metoden til aa sjekke hvor mange dager det er i manden
            if (month < 0 || month > 11 && dag < 0 || dag > maxd) {
                // vist datoen ikke eksisterer faar brukeren en feil melding paa det
                System.out.println("denne datoen eksisterer ikke! Prove igjen.");
            }

        } while (month < 0 || month > 11 && dag < 0 || dag > maxd);

        cal.set(year, month, dag); // setter verdiene inn i calendaren
        // utskrift til brukeren
        System.out.println("\nDenne datoen var ein " + dagavuke[cal.get(Calendar.DAY_OF_WEEK)]);
        System.out.println("Vekenummeret til datoen er " + cal.get(Calendar.WEEK_OF_YEAR));

    }
}
