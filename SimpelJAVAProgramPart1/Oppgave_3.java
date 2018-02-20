
package gr02lab01;

import java.io.IOException;
import java.util.Scanner;

public class Oppgave_3 {

    public static void main(String[] args) throws IOException {
        Scanner inn = new Scanner(System.in);
        double r1 = -1, r2 = -1, sump, sums; // oppretter variabler gir r1 og r2 en midlertidig negative værdi siden de skal brukes i while lokke.
        char valg = 'e'; // oppretter varibale for bokstaver og gir den en midlertidig verdi siden den skal brukes i while lokke
        //bruker innformasjon
        System.out.println("Dette programet regner ut serie og parallell kobling av motstander");
        System.out.println("Velg serie eller parallell(s/p) eller du kan avslutte programmet med å trykke (q)");
        while (valg != 'p' && valg != 's' && valg != 'q') {
            //laget en while lokke slik at brukeren ikke kommer lengre vist han ikke gjør som info'en sier
            valg = (char) System.in.read();

        }   // her har vi en if og if else lokke. en for serie med betingelse s og en for parallell med betigelse p eller du kan hoppe over og avslutte hvist du trykker q
        if (valg == 's') {
            while (r1 < 0 && r2 < 0) {
                // betingelsen for og komme ut av denne while lokken er at r1 og r2 må være større enn 0
                System.out.println("skrive inn første motstanden(R1)");
                r1 = inn.nextDouble();
                //skriv inn første varibel
                System.out.println("skrive inn første motstanden(R2)");
                r2 = inn.nextDouble();
                // skriv inn andre variablen
                if (r1 <= 0 || r2 <= 0) { // har laget en if blokk som gir feil melding til bruken 
                    System.out.println("Der finnes ikke negative motstand eller motstander som er null. Prøv på nytt!");
                    r1 = -1;// setter er r1 og r2 lik -1 slik at whillokken vil forsette og gå til den for to posetive verdier som er større enn 0
                    r2 = -1;
                }
            }
            sums = r1 + r2; //her legger sammen r1 + r2
            System.out.println("\nSystemet var seriekoblet.\n");//så kommer ut skrift blokken slik den var oppgitt til å være
            System.out.println("Resistans 1 har motstand: " + r1 + " ohm");
            System.out.println("Resistans 2 har motstand: " + r2 + " ohm\n");
            System.out.format("\nDen totale motstanden i systemet er:%10.3f ohm\n\n", sums); //brukte format her siden vi bare skulle ta med 3 desimaltall.

        } else if (valg == 'p') {
            while (r1 < 0 && r2 < 0) {
                // betingelsen for og komme ut av denne while lokken er at r1 og r2 må være større enn 0
                System.out.println("skrive inn første motstanden(R1)");
                r1 = inn.nextDouble();
                //skriv inn første varibel
                System.out.println("skrive inn første motstanden(R2)");
                r2 = inn.nextDouble();
                // skriv inn andre variablen
                if (r1 <= 0 || r2 <= 0) { // har laget en if blokk som gir feil melding til bruken 
                    System.out.println("Der finnes ikke negative motstand eller motstander som er null. Prøv på nytt!");
                    r1 = -1;// setter er r1 og r2 lik -1 slik at whillokken vil forsette og gå til den for to posetive verdier som er større enn 0
                    r2 = -1;
                }
            }
            sump = (r1 * r2) / (r1 + r2); // har vi brukt formel for to motstander i parallell.
            System.out.println("\nSystemet var parallellkoblet.\n");//så kommer ut skrift blokken slik den var oppgitt til å være
            System.out.println("Resistans 1 har motstand: " + r1 + " ohm");
            System.out.println("Resistans 2 har motstand: " + r2 + " ohm\n");
            System.out.format("Den totale motstanden i systemet er:%10.3f ohm\n\n", sump);//brukte format her siden vi bare skulle ta med 3 desimaltall.
        }
        System.out.println("Programet er avsluttet\n");// har lagt inn en liten bruker info hvist du trykker q eller når du er ferdig å kjøre programet
    }

}
