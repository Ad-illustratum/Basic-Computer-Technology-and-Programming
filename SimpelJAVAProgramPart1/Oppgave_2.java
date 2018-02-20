
package gr02lab01;

public class Oppgave_2 {


    public static void main(String[] args) {

        int rand1, rand2;
        // oppretter to int int verdier for det er helt som en trenger i dette programmet
        System.out.print("\nDu trakk: ");
        // oppretter en randomgenerator fra 0-3 
        rand1 = (int) Math.floor(Math.random() * 4);
        //skriver ut hvilken sort du fikk hvor de er rangsert fra 0-3
        // har valgt if og else if lokke siden da blir det et mindre program.
        if (rand1 == 0) { //har brukt print slik at det kommer etter du trakk.
            System.out.print("spar ");
        } else if (rand1 == 1) {
            System.out.print("hjerter ");
        } else if (rand1 == 2) {
            System.out.print("klover ");
        } else if (rand1 == 3) {
            System.out.print("ruter ");
        }
        //oppretter en randomgenerator fra 1-13 i og med en kortstokk består av 13 kort pr sort
        rand2 = (int) Math.floor(Math.random() * 13 + 1);
        //skriver ut alt etter hvilke tall du fikk
        if (rand2 == 1) {//har bruk print slik det kommer etter hvilke sort du fikk.
            System.out.print("ess");
        } else if (rand2 != 1 && rand2 != 11 && rand2 != 12 && rand2 != 13) {
            System.out.print(rand2);
        } else if (rand2 == 11) {
            System.out.print("knekt");
        } else if (rand2 == 12) {
            System.out.print("dame");
        } else if (rand2 == 13) {
            System.out.print("konge");
        }
        System.out.println("\n"); // for å få mellomrom til build
    }

}
