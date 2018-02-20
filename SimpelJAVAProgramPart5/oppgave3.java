package lab5try3;

import java.util.Scanner; // importer Scanner classen

public class oppgave3 {

    public static void meny() {//lagar ein meny metode til aa presentere pprogrammet
        System.out.println("*******************************************************************************\nDette er eit program som beregner spenningsfallet ut ifraa\neit fordelingsskap og ut til ei angitt lengde"
                + "\nBrukar maa taste inn nodvendige verdier\nTast (q) for aa avslutte programmet\nTast enter for aa fortsette\n*******************************************************************************");
    }

    public static double getinfo(String navn, String maaleenhet, Scanner inn) {//en metode for å lese inn desimataltall og som sjekker tallet er mindre eller lik 0.       
        double tall; //oppretter en desimaltall verdi
        do {// do while lokke som kjorer til du faar et storre tall enn 0.
            System.out.print("\nSkriv inn " + navn + " i " + maaleenhet + ": ");// en oppen utskrift som hvor resten av teksten blir til sendt fra main programet
            tall = inn.nextDouble();//leser inn tall verdi
            if (tall <= 0) { // if lokke som gir feilmeldig vis tallet er mindre eller lik 0
                System.out.println("Du valgte negativ verdi eller 0! prøv igjen"); // utskrift
            }
        } while (tall <= 0);
        inn.nextLine();//fjerner enter
        return tall; //sender tilbake verdien på tallet
    }

    public static void utskrift(double spenningsfall, double minstetversnitt, String godkjent) { // en metode for utskrift av resultat
        System.out.printf("\nSpenningsfall i kabelen er: %.2fV\n", spenningsfall);
        System.out.println(godkjent);
        System.out.printf("Minste tverrsnitt ein kan bruke i denne kretsen er: %.2fmm^2\n\n", minstetversnitt);
    }

    public static void main(String[] args) {

        Scanner inn = new Scanner(System.in); //oppretter en Scanner
        Dimensjonering d1 = new Dimensjonering(); // oppretter et objekt i classen dimensjonering
        String a; //oppretter en string

        while (1 == 1) {//lagar ei lokke som koyrer heilt til det blir tastet inn "q"
            meny(); //bruker metoden meny
            a = inn.nextLine(); // leser inn text Streng
            if (a.equalsIgnoreCase("q")) { // hvist text Strengen er lik q avsluttes while lokken
                System.exit(0); // avslutter programmet
            }
            d1.straumforingsevne(inn); //bruker metoden i classen dimensjonering til aa besteme rho i objektet
            d1.tverrsnitt = getinfo("tversnittet", "mm^2", inn); // bruker metoden getinfo til til aa gi verdi til tverrsnitt i objekte
            d1.u = getinfo("spenning", "volt", inn); // bruker metoden getinfo til til aa gi verdi til u i objekte
            d1.p = getinfo("effekten", "watt", inn); // bruker metoden getinfo til til aa gi verdi til p i objekte
            d1.lengde = getinfo("lengden", "meter", inn);// bruker metoden getinfo til til aa gi verdi til lengde i objekte
            utskrift(d1.spenningsfall(), d1.minstetverrsnitt(), d1.spenningprosent()); // sender verdi fra objekte til utskrift metoden.

        }
    }
}

class Dimensjonering {
//deklarer alle verdiane objektet bestaar av 

    double tverrsnitt, rho, lengde, p, u;
//lagar ingen konstruktor, da dette ikkje er nodvendig her

    void straumforingsevne(Scanner inn) {//Lagar ein metode for aa fastslaa kva material som er brukt og bruker verdien til dette metallet        
        System.out.print("Kva metall er kabelen laga av?\ntast 'k' for kopar og 'a' for aluminium: ");
        String b;//variabel til aa fastslaa materialet

        do {//Lokke for aa velge mellom kopar og aluminium
            b = inn.nextLine();
            if (b.equalsIgnoreCase("k")) {
                rho = 0.0018;
            }
            if (b.equalsIgnoreCase("a")) {
                rho = 0.03;
            }
        } while (b.equalsIgnoreCase("k") && b.equalsIgnoreCase("a"));//kriterier for aa avslutte lokken
    }

    double spenningsfall() {//utrekningsmetode for aa finne spenningsfallet i kretsen
        double x = (p * rho * lengde * 2) / (tverrsnitt * u);
        return x;//returnerer verdien for spenningsfall
    }

    String spenningprosent() {//metode for utrekning av spenningsfall i % og sender en text streng tilbake
        double x = (((p * rho * lengde * 2) / (tverrsnitt * u)) * 100) / u;
        String godkjent;
        if (x >= 3) {//gir melding til brukar om kretsen vil bli godkjent eller ikkje
            godkjent = "Spenningsfallet er over 3% og er defor ikkje godkjent i forhold til NEK400";
        } else {
            godkjent = "Spenningsfallet er under 3% og er derfor godkjent i forhold til NEK400";
        }
        return godkjent;
    }

    double minstetverrsnitt() {//rekner ut kva det absolutt minste tverrsnitt kan vere for denne kretsen
        double x = (p * rho * lengde * 2) / (3 * u);
        return x;//returner svar
        /*Det eg kunne ha lagt til i denne metoden er at eg kunne gitt brukar beskjed om kva 
        som er det nermeste standardiserte tverrsnittet(rundet av oppover) som kan bli brukt.
        fordi du vil som oftest faa eit tverrsnitt som ikkje blir produsert. */
    }
}
