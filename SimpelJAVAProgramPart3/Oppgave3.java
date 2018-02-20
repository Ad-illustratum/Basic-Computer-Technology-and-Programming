package gr02lab03;

import java.util.Scanner;

public class Oppgave3 {

    public static void main(String[] args) {

        Scanner inn = new Scanner(System.in); //Oppretter scanner for innlesing fra tastatur

        int score = 0; //Oppretter en variabel for antall matcher mellom navnene, setter denne til 0 for aa legge til +1 for hver match

        //Printer ut velkommsttekst og instukser til bruker for programmet, ber saa bruker skrive det fulle navnet til forste person
        System.out.print("Dette programmet sammenligner 2 navn for aa gi en pekepinn om noen kan vere i slekt.\nProgrammet tar hogde for eventuelle mellomnavn."
                + "\nSkriv i folgende format: Fornavn (Mellomnavn) Etternavn\nDu kan ha flere mellomnavn\n\nSkriv inn navnet paa forste person: ");

        String[] navn1 = inn.nextLine().split("[\\s]"); //Bruker skriver her inn det forste navnet, splitter det direkte og lagrer navnet i en tabell, hvert navn/mellomnavn/etternavn separert
        //NB Lagrer ikke teksten i sin helhet i en string, kun i tabell, da vi skal kun sammenligne navnene med hverandre

        System.out.print("Skriv inn navnet paa andre person: "); //Ber bruker skrive inn navnet til den andre personen        
        String[] navn2 = inn.nextLine().split("[\\s]"); //Bruker skriver her inn det andre navnet, splitter og lagrer navnet direkte i en tabell.
        //Funkjsonen .split("[\\s]") splitter teksten hver gang det skrives inn en aapen luke, eller space

        for (int i = 1; i < navn1.length; i++) { //For lokke som hopper over fornavn og teller fra evt. mellomnav og til etternavn, stopper naar vi har gott gjennom alle mellomnavn og etternavn fra forste person
            for (int o = 1; o < navn2.length; o++) { //For lokke som er like forige, men for navn nr 2, denne kjorer gjennom navn 2, og om igjen naar den forste for lokke kjorer igjen
                if (navn1[i].equalsIgnoreCase(navn2[o])) { //Vist mellomnavnet eller etternavnet er lik navnet vi sammenligner det med kjorer vi innholdet if lokka
                    score++; //Legger her til 1 paa scoren som en rangeringen om personene kan vere i slekt
                }
            }
        }
        switch (score) { //Bruker en switch som har forskjellige utfall for hvor mange navn som ble sammenlignet var like
            case 0:
                System.out.println("\n0 matcher: Det er liten sannsylighet for att de er i slekt");
                break; //Vist det var ingen like mellomnavn/etternavn skrives denne beskjeden, med "liten" sannynlighet i forhold til navn
            case 1:
                System.out.println("\n1 match: Det er mulighet for att de er i slekt");
                break; //Er det 1 match mellom mellomnavn/etternavn er det en mulighet for att personene er i slekt, vi printer da denne beskjeden
            default:
                System.out.println("\n2 eller flere matcher: Det er hoy sannsynlighet for att de er i slekt"); //Er det mer enn 1 match (2 og oppover) mellom navnene printer vi denne beskjden, det er da ogsaa okt sjanse for at personene er i slekt
        }   //Bruker break; for aa stoppe switch lokka, ellers printes neste linje ut, dette stopper ogsaa programmet

    }

}
