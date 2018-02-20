package gr02lab07;

import java.util.Scanner;

public class Oppgave2 {

    public static void meny() { //  info om valg til bruker

        System.out.print("\nTrykk 'r' for aa registre ny bok\nTrykk 's' for aa registere salg av en bok\nTrykk 'i' for info om bokene\n"
                + "Trykk 'n' for aa endre antall på en type bok\nTrykk 'q' for avslutte\nSkriv inn valg her: ");
    }

    public static double posdesimal(String info, Scanner inn) {//en metode for å lese inn desimataltall og som sjekker tallet er mindre eller lik 0.       
        double tall; //oppretter en desimaltall variabel
        do {// do while lokke som kjorer til du faar et storre tall enn 0.
            System.out.print("Skriv inn " + info + ": ");// en oppen utskrift som hvor resten av teksten blir til sendt fra main programet
            tall = inn.nextDouble();//leser inn tall verdi
            if (tall <= 0) { // if lokke som gir feilmeldig vis tallet er mindre eller lik 0
                System.out.println("Du valgte negativ verdi eller 0!\nPprøv igjen"); // utskrift feilmelding
            }
        } while (tall <= 0);
        inn.nextLine();//fjerner enter
        return tall; //sender tilbake verdien på tallet
    }

    public static int posheiltall(String info, Scanner inn) {//en metode for å lese inn desimataltall og som sjekker tallet er mindre enn 0.       
        int tall; //oppretter en heiltall variabel
        do {// do while lokke som kjorer til du faar et storre tall enn -1.
            System.out.print("Skriv inn " + info + ": ");// en oppen utskrift som hvor resten av teksten blir til sendt fra main programet
            tall = inn.nextInt();//leser inn tall verdi
            if (tall < 0) { // if lokke som gir feilmeldig vis tallet er mindre eller lik 0
                System.out.println("Du valgte negativ verdi eller 0!\nPrøv igjen"); // utskrift feilmelding
            }
        } while (tall <= 0);
        inn.nextLine();//fjerner enter
        return tall; //sender tilbake verdien på tallet
    }

    public static int boknummer(String info, Scanner inn) { //en metode som leser inn heiltall og finner ut om det kan brukes.
        int tall; // oppretter en tall variabel
        String a; // oppretter en string 
        do { // oppretter en dowhile lokke med kritire at a='r' vist tallet stemmer går og vist brukeren velger det.
            System.out.print("\nSkriv inn " + info + ": "); //info til bruker om va han skal skrive inn
            tall = inn.nextInt(); //bruker skriver inn et tall mellom 1 og 100 trekker fra en pga arry begynner paa 0
            inn.nextLine(); // fjerner enter
            if (tall <= 0 || tall > Bok.nummer) { // iflokke som gir feil med aa mulighet for aa avslutte dowhile lokken
                System.out.print("Det finnes ingen bok med det nummeret.\nTrykk 'r' for aa returnere til menyen\nTrykk enter for aa prove paa nytt\nSkriv inn her: "); // info om valg til bruker
                a = inn.nextLine(); //innlesning fra tastatur
                tall = -1; //forsikring vist bruker har tastet 1 og ikke har opprettet noen objekter saa blir den ikke null slik at programmet krasjer. 
            } else {
                a = "r"; //vist tallet stemmer så går du ut av do while lokken
            }
        } while (!a.equalsIgnoreCase("r"));
        tall--; //trekker fra en fra tallet slik at det skal passe inn med arry plasseringen       
        return tall;//sender tilbake verdien på tallet
    }

    public static int registreboken(int i, Scanner inn, Bok b[]) {
        if (i < 100 && i >= 0) { //if else lokke vist saa lenge der er mindre enn 100 boker far du opprette nye, vist der er flere faar bruker beskjed om det.
            b[i] = new Bok(); //oppretter et nytt objekt
            System.out.print("\nSkriv inn tittel på boken: ");//info til brukeren                    
            b[i].setTittel(inn.nextLine());//leser innfra tastaturet og lagerer det i objektet
            System.out.print("Skriv inn forfatter av boken: ");//info til brukeren
            b[i].setForfattar(inn.nextLine());//leser innfra tastaturet og lagerer det i objektet
            b[i].setTaleksemplar(posheiltall("antall eksemplar av boken", inn)); //bruker metoden posheiltall og lager tallet i 
            b[i].setUtsallpris(posdesimal("utsalgsprisen på boken", inn));//leser innfra tastaturet og lagerer det i objektet
            i++;//plusser på en paa i slik neste gang der skal registers en ny bok er det i et nytt objekt
        } else {
            System.out.println("\nDer kan ikke bli registert flere boker!\nDu har 100 registrete boker.\nTrykk enter for aa forsette.");
            inn.nextLine(); //feil melding til brukeren.
        }
        return i; //sender tilbake i slik at den blir oppdatert pa hvor mange objekter 
    }

    public static void liste(Scanner inn, Bok b[]) {
        for (int n = 0; n < Bok.nummer; n++) { // for lokke som skriver ut alle bokene
            System.out.println("\nBoknummer " + b[n].boknum);
            System.out.println("Tittel: " + b[n].getTittel());
            System.out.println("Forfattar: " + b[n].getForfattar());
            System.out.println("Eksmeplarer: " + b[n].getTaleksemplar());
            System.out.println("Slagspris: " + b[n].getUtsallpris());
        }
        System.out.println("\nAntall bøker registret: " + Bok.nummer + "\nTrykk enter for aa forsette"); // skriver ut antall boker du har
        inn.nextLine(); // trykke enter for aa forsette
    }

    public static void main(String[] args) {
        Scanner inn = new Scanner(System.in); //oppretter en Scanner for innlesing fra tastatur
        int i = 0, n; //oppretter variabler n og i. setter i lik 0.
        String valg; // oppretter en string variabel
        Bok b[] = new Bok[100];//oppretter arry med plass til objekter i 
        System.out.println("Dette er et oversikts program for en bokhandler\nProgrammet har 5 alternativ");
        do { //dowhile lokke som blir avslutte vist valg blir 'q'
            meny();//Skriver ut meny til brukeren
            valg = inn.nextLine(); //leser inn fra brukeren
            if (valg.equalsIgnoreCase("r")) { //if lokke vist valg blir lik 'r'
                i = registreboken(i, inn, b); //bruker metoden 
            }
            if (valg.equalsIgnoreCase("s")) {//if lokke vist valg blir lik 's'
                n = boknummer("boknummer paa boken du har solgt", inn);//forst maa enn finne ut hvilken bok en skal selge                
                if (n >= 0 && n < Bok.nummer) { // if lokke som ser til at du kan endre antall boker saa lenge objeket eksister
                    b[n].registrersal(inn); //bruker medtoden i classen for aa registrere salg av en bok
                }
            }
            if (valg.equalsIgnoreCase("i")) {//if lokke vist valg blir lik 'i'                
                liste(inn, b); //bruker metoden liste for aa skrive ut alle registrete boker
            }
            if (valg.equalsIgnoreCase("n")) {//if lokke vist valg blir lik 'n'
                n = boknummer("boknummer paa boken du onsker aa endre antallet paa", inn);  //velge hvilken bok nummer du skal endre antall
                if (n >= 0 && n < Bok.nummer) { // if lokke som ser til at du kan endre antall boker saa lenge objeket eksister
                    b[n].setTaleksemplar(posheiltall("det totale antallet eksemplarer av boken", inn)); //bruker metoden for aa faa et heiltall og sender det til classen
                }
            }
        } while (!valg.equalsIgnoreCase("q"));
    }
}

class Bok { // bok class

    //datafelt variabler
    static int nummer;
    private String tittel;
    private int taleksemplar;
    private double utsallpris;
    private String forfattar;
    int boknum;

    public Bok() { //konstruktor
        boknummer(); //bruker metoden boknummer hver gang der blir opp rettet et nytt objekt til classen
        boknum = nummer; //setter nummer lik for boknunummer for hvert objekt
    }

    public void setTittel(String tittel) { //metode for aa sette tittel
        this.tittel = tittel;
    }

    public void setTaleksemplar(int taleksemplar) {//metode for aa sette taleksemplar
        this.taleksemplar = taleksemplar;
    }

    public void setUtsallpris(double utsallpris) {//metode for aa sette utsalgspris
        this.utsallpris = utsallpris;
    }

    public void setForfattar(String forfattar) {//metode for aa sette forfatter
        this.forfattar = forfattar;
    }

    public String getTittel() {//metode for aa hente tittel
        return tittel;
    }

    public int getTaleksemplar() {//metode for aa hente taleksemplar
        return taleksemplar;
    }

    public double getUtsallpris() {//metode for aa hente utsalgspris
        return utsallpris;
    }

    public String getForfattar() {//metode for aa hente forfatter
        return forfattar;
    }

    public void registrersal(Scanner inn) {//metode for aa registrere salg av en bok 
        if (taleksemplar > 0) { // en if else lokke som ser om du har flere boker igjen
            taleksemplar--; //trekker fra en på antallet av boker
            if (taleksemplar == 0) { // if else lokke hvist du har solgt den siste boken får du medling
                System.out.println("Du har solgt den siste boken av nummer: " + boknum);//info bruker
            } else { //info bruker
                System.out.println("Du har solgt en bok av nrummer: " + boknum + ". Du har igjen " + taleksemplar + " eksemplarar igjen");
            }
        } else {//info bruker
            System.out.println("Du kan ikke slege en bok du ikke har!");
        }
        System.out.println("Trykk enter for aa fortsette"); //info bruker
        inn.nextLine(); //innlesing av enter for aa komme seg videre 
    }

    public static void boknummer() { // metode for aa legge til en i den static variabelen
        nummer++;
    }
}
