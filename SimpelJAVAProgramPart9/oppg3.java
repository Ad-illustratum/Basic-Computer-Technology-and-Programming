/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr02lab09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author mikken
 */
public class oppg3 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        File fil = new File("tekst.txt");//her henter eg info fraa ei tekstfil som inneheld den teksten eg skal analysere
        Scanner inn = new Scanner(fil);//Ved hjelp av ein Scanner kan eg lese igjennom all tekst i fila

        int teller = 0;//telleren holder tellinga paa kor mange gonger java blir nevnt

        while (inn.hasNext()) {//saa lenge det er tekst vil denne lokka koyre. den skiller teksten mellom kvart mellomrom
            String litenskrift = inn.next().toLowerCase();//gjer all tekst om til smaa bokstaver for aa ikkje maatte skille mellom smaa og store bokstaver
            if (litenskrift.contains("java")) {//bruker contains metoden for aa sjekke om ordet inneheld "java"
                teller++;//adderer antall gonger nevnt java med 1
            }
        }
        System.out.println("Antall gonger ordet 'java' er nevnt: " + teller);//printer ut kor mange gonger java er nevnt
    }

}
