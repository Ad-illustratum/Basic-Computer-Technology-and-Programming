package lab5try3;

import java.util.Scanner;

public class oppgave1 {

    public static void menu() { //lagar ein meny metode til aa presentere pprogrammet
        System.out.println("Velkommen dette er programm som regner ut.");
        System.out.println("areal eller omkrets av en sikel, trekant eller fikrkant.");
        System.out.println("Du har 4 valg:\n");
        System.out.println("Trykk 's' for aa regne areal eller omkrets av en sirkel.");
        System.out.println("Trykk 't' for aa regne areal eller omkrets av en rettvinklet trekant.");
        System.out.println("Trykk 'k' for aa regne areal eller omkrets av en firkant.");
        System.out.println("Trykk 'q' for aa avslutte.\n");
        System.out.print("skriv inn ditt valg: ");
    }

    public static double getinfo(String navn, String figur, Scanner inn) {//en metode for å lese inn desimaltal og som sjekker tallet er mindre eller lik 0.       
        double tall; //oppretter en desimaltall verdi
        do {// do while lokke som kjorer til du faar et storre tall enn 0.
            System.out.print("\nSkriv inn " + navn + " av " + figur + ": ");// en oppen utskrift som hvor resten av teksten blir til sendt fra main programet
            tall = inn.nextDouble();//leser inn tall verdi
            if (tall <= 0) { // if lokke som gir feilmeldig vis tallet er mindre eller lik 0
                System.out.println("Du valgte negativ verdi eller 0! prøv igjen"); // utskrift
            }
        } while (tall <= 0);
        inn.nextLine();//fjerner enter
        return tall; //sender tilbake verdien på tallet
    }

    public static void utskrift(String figur, double areal, double omkrets, Scanner inn) { //metode for aa skrive ut resultatet
        System.out.printf("\nArealet av %s: %.3f\nOmkretsen av %s: %.3f\n", figur, areal, figur, omkrets);
        System.out.println("\nTrykk enter for aa forsette");
        inn.nextLine();
    }

    public static void main(String[] args) {
        Trekant t1 = new Trekant(); // oppretter et objekt for trekant
        Sirkel s1 = new Sirkel();//oppretter et objekt for sirkel
        Firkant k1 = new Firkant();//oppretter et objekt for firkant
        String a; //oppretter en streng variabel
        Scanner inn = new Scanner(System.in);//oppretter en scanner
        do { //en do while som kjører helt til a bli lik q
            menu(); // bruker metoden menu
            a = inn.nextLine(); //innskriving til a
            if (a.equalsIgnoreCase("s")) { //if lokke vis a blir lik 's'
                s1.radius = getinfo("radius", "sirkelen", inn); //bruker getinfo metode for aa sette verdi paa radius
                s1.Regnut(); // bruker metoden regnut i classen sirkel
                utskrift("sirkel", s1.areal, s1.omkrets, inn);//bruker metoden utskrift til aa skrive ut resultat
            } else if (a.equalsIgnoreCase("t")) {//if lokke vis a blir lik 't'
                t1.hoyde = getinfo("katet 1 (hoyden)", "trekanten", inn);//bruker getinfo metode for aa sette verdi paa hoyden
                t1.grunnflate = getinfo("katet 2 (grunnflaten)", "trekanten", inn);//bruker getinfo metode for aa sette verdi paa grunnflaten
                t1.Regnut();// bruker metoden regnut i classen trekant
                utskrift("rettvinklet trekanten", t1.areal, t1.omkrets, inn);//bruker metoden utskrift til aa skrive ut resultat
            } else if (a.equalsIgnoreCase("k")) {//if lokke vis a blir lik 'k'
                k1.bredde = getinfo("bredde", "firkant", inn);//bruker getinfo metode for aa sette verdi paa bredde
                k1.lengde = getinfo("lengde", "firkant", inn);//bruker getinfo metode for aa sette verdi paa lendge
                k1.Regnut(); // bruker metoden regnut i classen firkant
                utskrift("fikanten", k1.areal, k1.omkrets, inn);//bruker metoden utskrift til aa skrive ut resultat
            }
        } while (!a.equalsIgnoreCase("q"));
    }

}

class Trekant { //oppreten en classe trekant
    //oppretter variabler
    double grunnflate, hoyde, areal, omkrets;

    void Regnut() { //en metode for aa regne ut areal og omkrets
        areal = grunnflate * hoyde / 2;
        omkrets = grunnflate + hoyde + Math.sqrt(grunnflate * grunnflate + hoyde * hoyde);
    }
}

class Firkant {//oppreten en classe firkant
    //oppretter variabler
    double lengde, bredde, areal, omkrets;

    void Regnut() {//en metode for aa regne ut areal og omkrets
        areal = lengde * bredde;
        omkrets = 2 * lengde + 2 * bredde;
    }
}

class Sirkel {//oppreten en classe sirkel
    //oppretter variabler
    double radius, areal, omkrets;

    void Regnut() {//en metode for aa regne ut areal og omkrets
        areal = Math.PI * radius * radius;
        omkrets = Math.PI * radius * 2;
    }
}
