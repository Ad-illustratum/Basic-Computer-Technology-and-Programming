package fr02lab08;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Oppgave1 {

    public static void main(String[] args) throws InterruptedException {

        String[] dag = {"nei", "sundag", "mandag", "tirsdag", "onsdag", "torsdag", "fredag", "laurdag"}; //lager et array som innholder alle dagene        
        do { //evighets loop          
            Calendar cal = new GregorianCalendar(); // oppretter en kalender for bruk til tid og dato
            //onsket utskrift  
            System.out.printf("%s, %02d:%02d\n", dag[cal.get(Calendar.DAY_OF_WEEK)], cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
            TimeUnit.SECONDS.sleep(60); // bruker time unit til aa la programet vente i noykatik 60 sek for det kjorer vidrere
        } while (true);

    }
}
