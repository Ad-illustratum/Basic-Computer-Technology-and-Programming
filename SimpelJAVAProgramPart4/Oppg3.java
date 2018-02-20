package gr02lab04;

import java.util.Scanner;

public class Oppg3 {

    public static void meny() { //en metode for meny. som gir deg alle alternativene du har og velkommest melding.

        System.out.println("******************************************************************************************************************\nDette er er program som kan regne ut spenningsfall i ledere,\nog tar hensyn til om det staar i fohold til nek 400."
                + "\nProgrammet har 4 alternativ alt etter hva du har av info.\n******************************************************************************************************************");
        System.out.print("Trykk 1 hvist du har strum, spenning, lengde av kabel, faseforskyving i grader, tverrsnitt og leder i kopper.\nTrykk 2 hvist du har strum, spenning, lengde av kabel, faseforskyving i grader, tverrsnitt og leder i aluminum."
                + "\nTrykk 3 hvist du har effekt, lengde av kabel, spenning, tverrsnitt og leder i kopper.\nTrykk 4 hvist du har effekt, lengde av kabel, spenning, tverrsnitt og leder i aluminum\nTrykk 0 for aa avslutte programmet"
                + "\n******************************************************************************************************************\nVelg program:");
    }

    public static double getinfo(String navn, String symbol) {//en metode for å lese inn desimataltall og som sjekker tallet er mindre eller lik 0.
        Scanner inn = new Scanner(System.in);//oppretter en scanner for aa lese inn tall
        double tall; //oppretter en desimaltall verdi
        do {// do while lokke som kjorer til du faar et storre tall enn 0.
            System.out.print("\nSkriv inn " + navn + ". " + symbol + " = ");// en oppen utskrift som hvor resten av teksten blir til sendt fra main programet
            tall = inn.nextDouble();//leser inn tall verdi
            if (tall <= 0) { // if lokke som gir feilmeldig vis tallet er mindre eller lik 0
                System.out.println("Du valgte negativ verdi eller 0! prøv igjen"); // utskrift
            }
        } while (tall <= 0);
        return tall; //sender tilbake verdien på tallet
    }

    public static double ledertap1(double p, double matrial, double l, double u, double a) {//en metode  for aa regne ut spnnings tapet i den ene formelen.
        return (p * matrial * l * 2) / (a * u);//for tall verdiene fra main. sender tilbake utregningen.
    }

    public static double ledertap2(double i, double matrial, double l, double theta, double a) { //en metode for aa regne ut spnnings tapet i den andre formelen.
        return 2 * i * matrial * l * Math.cosh(Math.toRadians(theta)) / a;//for tall verdiene fra main. sender tilbake utregningen.
    }

    public static String nek400(double u, double deltau) {  //en metode for aa sjekke om spennings fallet er over eller under 3%.
        String a;//oppretter en string 
        double avvik = deltau * 100 / u;//oppreter en desimatall variabel, og setter den lik utregning av prosenttallet som du verdiene fra main programet
        if (avvik <= 3) {// if else lokke. sjekker om spennings fall % er mindre eller større enn 3
            a = "ja.";
        } else {
            a = "nei.";
        }
        return a;//returnerer ja eller nei iform av en string
    }

    public static void resultat(double deltau, double u, String nek) { //en metode for utskrift av oppgitt ut skrift.
        System.out.printf("\nI denne leder har du et tap paa %.3fv.\nSpenningen i motsatt ende av forsyningen er spenningen %.3f volt.", deltau, u - deltau);
        System.out.println("\nOppfyller lederen kravet til nek400 paa mindre enn 3% spenningsfall: " + nek);
    }

    public static void main(String[] args) {

        Scanner inn = new Scanner(System.in); //oppretter en Scanner for å kunne lese inn tall i hovedprogramet.
        String nek;//oppretter en tekst streng.
        double i, p, l, theta, a, u, matrial, deltau;//oppretter desimal variabler.
        int program; //oppretter et heiltall
        do { //setter programmet i do-while lokke slik at det kjorer til det får null inn på int verdien.
            meny();//skriver ut menyen
            program = inn.nextInt(); //leser inn hel tall som bestemmer program
            if (program < 5 && 0 < program) { //lager en if lokke med betingelse at valget av program er innen for de 4 alternativene
                l = getinfo("lengden på lederen", "l"); //bruker metoden getinfo for aa faa tallverdi til l
                a = getinfo("tverrsnittet på lederen", "A");//bruker metoden getinfo for aa faa tallverdi til a
                u = getinfo("spenningen", "V");//bruker metoden getinfo for aa faa tallverdi til u
                if (program == 1 || program == 3) {//laget en if else lokke som avgjor hvilket mentall du bruker
                    matrial = 0.0018;// for program 1 og 3 er det kopper som gjelder
                } else {
                    matrial = 0.03;//for program 2 og 4 er det almium som gjelder
                }
                if (program == 1 || program == 2) {//lager en if else lokke som skillder programmene fra hverander. program 1 og 2 bruker samme formelen
                    i = getinfo("belastningsstrumen", "I");//bruker metoden getinfo for aa faa tallverdi til i
                    theta = getinfo("vinkelen", "Theta");//bruker metoden getinfo for aa faa tallverdi til theta
                    deltau = ledertap2(i, matrial, l, theta, a);//bruker metoden ledertap2 for aa regne ut spenningtapet i lederen
                } else { // program 3 og 4 bruker samme formel 
                    p = getinfo("lasteeffekten", "W");//bruker metoden getinfo for aa faa tallverdi til p
                    deltau = ledertap1(p, matrial, l, u, a);//bruker metoden ledertap1 for aa regne ut spenningtapet i lederen
                }
                nek = nek400(u, deltau);//bruker metoden nek400 som av gjor om spenningsfallet er i henhold til kravet. faar ja eller nei i tekst streng til bakke i nek
                resultat(deltau, u, nek);//bruker metoden resultat til å skrive ut resultatet med til brukeren  
                System.out.println("\nTrykk enter for å forsette!");// info
                inn.nextLine();//fanger enteren i bufferen
                inn.nextLine();// for å gå videre.
            }

        } while (program != 0);

    }
}
