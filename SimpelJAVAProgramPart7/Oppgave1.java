
package gr02lab07;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Oppgave1 {

    public static long oppdateretiden(Calendar cal) { //oppretter en metode som oppdaterer tiden til et gitt oyeblikk
        cal = Calendar.getInstance();
        return cal.getTimeInMillis(); // sender tilbake oyblikks tiden i millisekunder, variabel long.
    }

    public static void main(String[] args) {

        Scanner inn = new Scanner(System.in); //inn lesning fra tastatur
        Calendar cal = new GregorianCalendar(); // oppretter en kalender for bruk til tid og dato
        //oppretter variabler
        long start = 0, stopp = 0, start1; //gir en verdi 
        String valg; // oppretter en string variabel
        int i = 0; // oppretter en tellevariabel for a telle runder

        do { //dowhile lokke avslutteses ved at brukeren trykker 'q' 
            System.out.print("Start stoppeklokken ved aa trykke 's': "); //info til brukeren
            valg = inn.nextLine(); //leser inn valg fra brukeren         
            if (valg.equalsIgnoreCase("s")) { // vist valg er lik 's' 
                start = oppdateretiden(cal); // sa starter stoppeklokken aa gaa
                System.out.print("For runde tid trykk 's'.\nFor aa avslutte trykk 'q'\nskriv inn valge  ditt: "); //valg til brukeren om han vil ta ny runde tid eller avslutte
                do { // dowhile lokke som kjorer frem til brukeren trykker 'q'
                    start1 = oppdateretiden(cal); // tar start som brukes til aa regne runde tid
                    valg = inn.next(); // leser inn fra tastatur
                    if (valg.equalsIgnoreCase("q") || valg.equalsIgnoreCase("s")) { // vist vlag = q eller s saa blir der skrvet ut runde tid
                        stopp = oppdateretiden(cal); // stopp tiden 
                        i++; //legger til en på i for runde nummer
                        System.out.printf("rounde %1d: %02d:%02d:%02d ", i, (stopp - start1) / 60 / 1000 % 60, (stopp - start1) / 1000 % 60, (stopp - start1) / 10 % 100);
                    }   // formatert utskrift for aa fa rett utskrift
                } while (!valg.equalsIgnoreCase("q"));
            }
        } while (!valg.equalsIgnoreCase("q"));
        System.out.println("\n\nStoppeklokka blei stoppa."); // utskrift til brukeren 
        System.out.printf("\nSamla tid: %02d:%02d:%02d", ((stopp - start) / 60 / 1000 % 60), (stopp - start) / 1000 % 60, (stopp - start) / 10 % 100); // formateretutskrift for aa faa ønsket utskrift
        System.out.printf("\nDato: %02d.%02d.%02d\n", cal.get(Calendar.DAY_OF_MONTH), (cal.get(Calendar.MONTH) + 1), cal.get(Calendar.YEAR)); // formaterutskrift for aa faa ønsket utskrift
    }
    
}
