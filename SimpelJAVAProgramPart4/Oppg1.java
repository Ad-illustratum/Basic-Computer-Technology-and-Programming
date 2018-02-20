package gr02lab04;

import java.util.Scanner;

public class Oppg1 {

    public static void velkomst() { //en metode for meny. som gir deg alle alternativene du har
        System.out.print("\n******************************************************\nDette er et program som renger ut arealet.\nVelg 1 for aa regne "
                + "arealet av en sikre.\nVelg 2 for aa regne arealet av en trekant.\nVelg 3 for aa regne arealet av en kvadrat.\nVelg 0 for aa avslutte"
                + " programmet.\n******************************************************\nVelg program: ");
    }

    public static double getinfo(String navn, String symbol) {//en metode for å lese inn desimataltall og som sjekker tallet er mindre eller lik 0.
        Scanner inn = new Scanner(System.in);//oppretter en scanner for aa lese inn tall
        double tall; //oppretter en desimaltall verdi
        do {// do while lokke som kjorer til du faar et storre tall enn 0.
            System.out.print("\nSkriv inn verdi for " + navn + ". " + symbol + " = ");// en oppen utskrift som hvor resten av teksten blir til sendt fra main programet
            tall = inn.nextDouble();//leser inn tall verdi
            if (tall <= 0) { // if lokke som gir feilmeldig vis tallet er mindre eller lik 0
                System.out.println("Du valgte negativ verdi eller 0! prøv igjen"); // utskrift
            }
        } while (tall <= 0);
        return tall; //sender tilbake verdien på tallet
    }

    public static double sirkel(double r) {//en metode  for aa regner ut arealet av en sirkel
        return r * r * Math.PI;//for variabelen fra hovedet programet
    }

    public static double trekant(double g, double h) {//en metode  for aa regner ut arealet av en trekan
        return g * h / 2;//for variabelene fra hovedet programet
    }

    public static double kvadrat(double s) {//en metode  for aa regner ut arealet av en kvadrat
        return s * s; //for variabelen fra hovedet programet
    }

    public static void resultat(double svar, String figur) {//en metode som skriver ut resultatet 
        Scanner inn = new Scanner(System.in);//oppretter scanner i metoden for for aa skrive inn
        System.out.printf("\nArealet av %s er %.3f\n\n", figur, svar); // skriver ut det som blir sendt inn
        System.out.println("trykk enter for aa forsette!");// melding til bruker
        inn.nextLine(); // du maa trykke enter for aa forsette.
    }

    public static void main(String[] args) {
        Scanner inn = new Scanner(System.in); //oppretter en Scanner for å kunne lese inn tall i hovedprogramet.
        int verdi; //oppretter et heiltall varialbel
        double t1, t2, svar;//oppretter desimal variabler.
        do {//setter programmet i do-while lokke slik at det kjorer til det får null inn på int verdien.
            velkomst();//skriver ut menyen/velkosmten
            verdi = inn.nextInt();// innlesning fra tastatur
            switch (verdi) { // en switch for valg av type program.
                case 1:
                    t1 = getinfo("radius", "r");//bruker metoden getinfo for aa faa tallverdi til t1
                    svar = sirkel(t1);//sender t1 til metoden sirkel for aa regne ut arealet aa lager det i svar
                    resultat(svar, "sirkel"); // sender svar til resultat og skriver det ut
                    break;
                case 2:
                    t1 = getinfo("grunnflate", "g");//bruker metoden getinfo for aa faa tallverdi til t1
                    t2 = getinfo("høyde", "h");//bruker metoden getinfo for aa faa tallverdi til t2
                    svar = trekant(t1, t2);//sender t1 og t2 til metoden trekant for aa regne ut arealet aa lager det i svar
                    resultat(svar, "trekant");// sender svar til resultat og skriver det ut
                    break;
                case 3:
                    t1 = getinfo("side", "s");//bruker metoden getinfo for aa faa tallverdi til t1
                    svar = kvadrat(t1);//sender t1 til metoden kvadrat for aa regne ut arealet aa lager det i svar
                    resultat(svar, "kvadrat");// sender svar til resultat og skriver det ut
                    break;
                default:
                       }
        
        } while (verdi != 0);
   
    }

}

