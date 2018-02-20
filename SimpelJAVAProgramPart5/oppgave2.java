
package lab5try3;

import java.util.Scanner;

public class oppgave2 {

    public static void main(String[] args) {
        Scanner inn = new Scanner(System.in);
        String a;//opretter ein variabel som kan brukast for input fraa brukar
        Bilar b1 = new Bilar("Opel");//Opretter eit nytt objekt med navn "Opel"
        Bilar b2 = new Bilar("Mazda");//Opretter eit nytt objekt med navn "Mazda"
        Bilar b3 = new Bilar("Ford");//Opretter eit nytt objekt med navn "Ford"
        System.out.println("Dette programmet tel kor mange gonger bilmerka Opel, Mazda og Ford blir nevnt\nTast inn 'q' for aa avslutte programmet\n");
        do {//opretter ei do while lokke, der bruker kan taste inn tekst, lokken koyrer til 'q' blir tastet inn.
            System.out.println("Tast inn tekst:");
            a = inn.nextLine();//input fraa brukar
            b1.delinga(a);//bruker delinga metoden for aa telje kor mange gonger b1(Opel) blir nevnt
            b2.delinga(a);//bruker delinga metoden for aa telje kor mange gonger b2(Mazda) blir nevnt
            b3.delinga(a);//bruker delinga metoden for aa telje kor mange gonger b3(Ford) blir nevnt

        }while (!"q".equalsIgnoreCase(a));
        //utprint av antall gonger kvart bilmerke blir nevnt
        System.out.println("Antall biler av merket " + b1.merke + " er " + b1.teller);
        System.out.println("Antall biler av merket " + b2.merke + " er " + b2.teller);
        System.out.println("Antall biler av merket " + b3.merke + " er " + b3.teller);
    }

}

class Bilar {

    String merke;//navn paa kvart objekt
    int teller = 0;//antall gonger kvart objekt blir nevnt
    String[] oppdelt;//Array for aa dele opp setningene og skille ut kvart enkelt ord.
    
    
    Bilar(String a) {//lagar ein konstruktor som definerer kvart objekt utifraa kva navn dei har
        merke = a;

    }

    void delinga(String a) {//sender tekststrengene inn i denne metoden for aa splitte opp alle ordene etter mellomrom

        oppdelt = a.split(" ");//splitter mellom kvart mellomrom
//lagar ei for lokke til aa telje kor mange gonger kvart objekt blir nevnt i teksten
        for (int i = oppdelt.length - 1; i >= 0; i--) {
            if (oppdelt[i].equalsIgnoreCase(merke)) {//ignorerer om det blir brukt store eller smaa bokstaver 
                teller++;//opptelling av kor mange gonger kvart objekt blir nevnt
            }
        }
    }
}
