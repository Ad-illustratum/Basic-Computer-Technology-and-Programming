
package gr02lab06;

import java.util.Scanner;

public class Oppggave1 {

    public static void main(String[] args) {
//her har eg berre trengt aa oprette eit objekt og koyre ein metode. fordi all handlinga foregaar i metoden.
        Gjett g1 = new Gjett();
        g1.provlykken();
    }
}

class Gjett {
/*Opretter ein teller som skal telje kor mange gonger ein har provd aa gjette, tal som er det tallet ein skal fram til og 
  heiltal som er variabelen tal omgjort til eit heiltal*/
    int teller;    
    int heiltall;
    
//denne metoden gjer verdi til ein variabel og omgjer denne til eit heiltal og returnerer
    int randomtal() {        
        heiltall = (int) Math.floor(Math.random() * 11 ); //generer et heltall fra 0 til 10.
        return heiltall;
    }

    void provlykken() {//det er her all handlinga skjer. Her sjekker metoden om talet som brukar har tasta inn er lik det tilfeldige talet.
        Scanner inn = new Scanner(System.in);
        int k , n=0;//opretter heiltal k som brukest som input verdi og n som blir brukt til aa hoppe ut av lokken
        int m = randomtal();//henter eit tilfeldig tal ifraa randomtal() metoden        
        do {//bruker ei do/while lokke
            System.out.println("Prov lykken tast inn et heiltal 0 mellom 10");
            k = inn.nextInt();
            teller++;//teller antall gonger brukar har provd aa faa riktig tal
            System.out.println(m);
            if (k == m) {//om brukar har tasta inn riktig tal vil denne utskriften komme.
                System.out.println("\nTallet " + m + " var riktig!"+"\nDu gjettet " + teller + " gonger for du gjetta riktig tal!");
                n++;
            }
        }while(n==0);//kriterie for aa komme ut av lokken.
    }
}