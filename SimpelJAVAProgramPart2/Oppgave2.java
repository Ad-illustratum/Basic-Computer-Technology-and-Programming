package gr02lab02;

public class Oppgave2 {

    public static void main(String[] args) {
        int tern1, tern2, like = 0, syv = 0, tolv = 0; // Oppretter variabler for terninger
        double n, m; //Midlertidig 

        for (int i = 1; i <= 100; i++) {
            n = (Math.random() * 6); // Kaster terning 1
            tern1 = (int) Math.ceil(n);// runder opp fra 0 til 1

            m = (Math.random() * 6); // Kaster terning 2
            tern2 = (int) Math.ceil(m);// runder opp fra 0 til 1

            if (tern1 == tern2) {     // Sjekker om terning 1 og terning 2 er like, og legger til 1 vist de er like legger vi til 1 i teller for like
                like++;
            }
            if (tern1 + tern2 == 7) { // Sjekker om summen av terningene er 7, vist summen er 7 legger vi til 1 i teller for 7'ere
                syv++;
            }
            if (tern1 + tern2 == 12) { // Sjekker om summen av terningene er 12, vist summen er 12 legger vi til 1 i teller for 12'ere
                tolv++;
            }
        }
        // Printer ut resultat av kastene
        System.out.println("Det var " + like + " like kast\n");
        System.out.println("Det var " + syv + " kast med summen 7\n");
        System.out.println("Det var " + tolv + " kast med summen 12");

    }

}
