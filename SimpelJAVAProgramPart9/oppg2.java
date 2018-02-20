/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr02lab09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author mikken
 */
public class oppg2 {

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
                System.out.print("Det finnes ingen bok med det nummeret.\nTrykk 'r' for aa returnere til menyen\nTrykk enter for aa prove paa nytt\n"); // info om valg til bruker
                a = inn.nextLine(); //innlesning fra tastatur
                tall = -1; //forsikring vist bruker har tastet 1 og ikke har opprettet noen objekter saa blir den ikke null slik at programmet krasjer. 
            } else {
                a = "r"; //vist tallet stemmer så går du ut av do while lokken
            }
        } while (!a.equalsIgnoreCase("r"));
        tall--; //trekker fra en fra tallet slik at det skal passe inn med arry plasseringen       
        return tall;//sender tilbake verdien på tallet
    }
//opretter ein metode som skal laste inn tidligere data.

    public static Bok[] lasteogstart(Bok[] b) throws FileNotFoundException, IOException, ClassNotFoundException {
        File fil = new File("bok.dat");//henter info ifraa bin fila som ligg i mappa

        if (fil.exists()) {//viss den finn fila leser den inn all info som er lagret og opretter eit objekt
            FileInputStream fis = new FileInputStream("bok.dat");//her leser eg inn
            ObjectInputStream ois = new ObjectInputStream(fis);//her opretter eg objektet 

            b = (Bok[]) ois.readObject();//her les eg inn info om kva tittel boke har
            Bok.nummer = ois.readInt();//antalleksemplar
            Bok.nummer = (int) ois.readDouble();//utsalgspris
            b = (Bok[]) ois.readObject();//forfattar

            ois.close();//lukker input'en

        }
        return b;//returnerer objekt arrayet
    }
//her er metode for aa lagre all info som har blitt tilfort programmet slik at det ikkje gaar tapt

    public static void lagreogavslutt(Bok[] b) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("bok.dat");//velger kva fil det skal skrivast til
        ObjectOutputStream oos = new ObjectOutputStream(fos);//lagrar informasjonen i binfila 'bok'

        oos.writeObject(b);//her skriv eg inn info om kva tittel boke har
        oos.writeInt(Bok.nummer);//antalleksemplar
        oos.writeDouble(Bok.nummer);//utsalgspris
        oos.writeObject(b);//forfattar

        oos.close();//lukkar output'en

    }
//lagar ein metode for aa velge mellom aa bruke tidligere lagra informasjon eller laga ei ny bokliste.

    public static String Valg(Scanner inn) {
        String val;
        int t = 0;
        do {
            System.out.println("Vil du bruke den tidligere lagrede boklista eller oprette ein ny?\ntast 'n' for ny og 'g' for den gamle. ");
            val = inn.next();
            if (val.equalsIgnoreCase("g")) {//Viss brukaren vil ha den gamle lista. vil dette kriteriet bli oppfylt og den gamle lista blir lasta inn
                t++;
            } else if (val.equalsIgnoreCase("n")) {
                t++;
            }
        } while (t == 0);

        return val;//returnerer valget til brukar
    }

    public static void meny() {//meny som viser kva valg ein har
        Scanner inn = new Scanner(System.in);
        System.out.println("Velkommen til meny for bibliotekboker.\n");
        System.out.println("Velg 'r': \t Registrerer ein ny bok.");
        System.out.println("Velg 's': \t Sal av ny bok.");
        System.out.println("Velg 'i': \t informasjon om bokene.");
        System.out.println("Velg 'n': \t Registrere nytt antall av eksemplar.");
        System.out.println("Velg 'q': \t for aa lagre og avslutte programmet.");

    }

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Scanner inn = new Scanner(System.in);
        String s;//Denne variabelen blir brukt til aa velge kva handling brukaren vil gjere
        int num;//kor mange registrerte boker
        int v, n;//dette er ein variabel som blir brukt til aa velge kva bok som skal registrerest som solgt.
        String val = Valg(inn);//her henter eg ein variabel som angir om eg vil laga ein ny liste eller oprette ein ny
        Bok[] b;//Her lagar eg ein objekt array

        if (val.equalsIgnoreCase("g")) {//Viss brukaren vil ha den gamle lista. vil dette kriteriet bli oppfylt og den gamle lista blir lasta inn

            b = new Bok[100];//Oprettar objektarray med plass til 100 boker
            b = lasteogstart(b);//innlasting av informasjon fraa binfila
        } else {

            b = new Bok[100];//Oprettar objektarray med plass til 100 boker
        }
        do {
            meny();//Skriv ut meny

            s = inn.next();//Leser inn val fraa brukar

            System.out.println("\n");
//registrering av ny bok
            if (s.equalsIgnoreCase("r")) { //if lokke vist valg blir lik 'r'

                num = Bok.nummer;//gjer verdi til num variabelen

                if (num < 100) {
                    b[num] = new Bok();//opretter eit nytt bok objekt
                    System.out.print("Skriv inn tittel på boka: ");
                    inn.nextLine();
                    b[num].settittel(inn.nextLine());//angir tittel
                    System.out.print("Skriv inn antall eksemplar: ");
                    b[num].settaleksemplar(inn.nextInt());//angir antalleksemplar
                    System.out.print("Skriv inn utsalgspris: ");
                    b[num].setutsalspris(inn.nextDouble());//angir utsalgspris
                    System.out.print("Skriv inn namn paa forfatter: ");
                    inn.nextLine();
                    b[num].setforfattar(inn.nextLine());//angir forfatter
                    //set inn denne slik at bruker kan trykke enter for aa gaa videre
                    System.out.println("\n");
                } else {
                    System.out.println("\nDet kan ikke bli registert flere boker!\nDu har 100 registrete boker.\nTrykk enter for aa forsette.");
                    inn.nextLine(); //feil melding til brukeren.
                }

            }
            if (s.equalsIgnoreCase("s")) {//if lokke vist valg blir lik 's'
                n = boknummer("boknummer paa boken du har solgt", inn);//forst maa enn finne ut hvilken bok en skal selge                
                if (n >= 0 && n < Bok.nummer) { // if lokke som ser til at du kan endre antall boker saa lenge objeket eksister
                    b[n].registrersal(); //bruker medtoden i classen for aa registrere salg av en bok
                }
            }//her lagar eg ei for lokke som printer ut informasjon om boker heilt til alle er komme med
            if (s.equalsIgnoreCase("i")) {
                for (int j = 0; j < Bok.nummer; j++) {
                    System.out.println("Tittel: " + b[j].gettittel());
                    System.out.println("Antall eksemplar: " + b[j].gettaleksemplar());
                    System.out.println("Forfatter: " + b[j].getforfattar());
                    System.out.println("Utsalgspris: " + b[j].getutsalspris());
                    System.out.println("\n");

                }
                inn.nextLine();
                inn.nextLine();// 2 inn nextLine gjer at eg kan trykke enter for aa gaa videre
            }
            if (s.equalsIgnoreCase("n")) {//Her kan bruker registrere nytt antall av boker
                n = boknummer("boknummer paa boken du onsker aa endre antallet paa", inn);  //velge hvilken bok nummer du skal endre antall
                if (n >= 0 && n < Bok.nummer) { // if lokke som ser til at du kan endre antall boker saa lenge objeket eksister
                    b[n].settaleksemplar(posheiltall("det nye totale antallet eksemplarer av boken", inn)); //bruker metoden for aa faa et heiltall og sender det til classen
                }
                inn.nextLine();//enter for aa gaa videre
            }

        } while (!s.equalsIgnoreCase("q"));//q for aa avslutte
        lagreogavslutt(b);//lagrer all informasjon som er tilfort
    }

}

//Bruker implements serialzable for aa gjere objektet om til binaerkode som kan flyttast imellom det originale objektet og det nye
class Bok implements Serializable {

    static int nummer;//Kvart objekt sitt eige nummer 
    String tittel;//tittelen til boka
    int taleksemplar;//kor mange boker eg har av denne typen
    double utsalspris;

    String forfattar;

    Bok() {//lagar ein konstruktor som gjer kvar bok sitt private nummer
        boknummer();
    }

    String gettittel() {//metode for aa returnere namn til main metode
        return tittel;
    }

    void settittel(String n) {//metoide for aa endre navn fraa main metode
        tittel = n;

    }

    int gettaleksemplar() {//metode for aa returnere namn til main metode
        return taleksemplar;
    }

    void settaleksemplar(int n) {//metoide for aa endre navn fraa main metode
        taleksemplar = n;

    }

    double getutsalspris() {//metode for aa returnere namn til main metode
        return utsalspris;
    }

    void setutsalspris(double n) {//metoide for aa endre navn fraa main metode
        utsalspris = n;

    }

    String getforfattar() {//metode for aa returnere namn til main metode
        return forfattar;
    }

    void setforfattar(String n) {//metoide for aa endre navn fraa main metode
        forfattar = n;

    }

    void registrersal() {//oppdaterer antall av denne typen bok. Har lagt inn sikring mot minustal
        if (taleksemplar > 0) {
            taleksemplar--;
        } else {
            System.out.println("Du Har ingen eksemplarer igjen av denne boken!");

        }

    }

    private void boknummer() {//gjer nummer til kvart objekt
        nummer = nummer + 1;
    }
}
