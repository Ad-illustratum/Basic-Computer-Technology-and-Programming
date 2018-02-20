/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr02lab09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class oppg1 {

    public static void main(String[] args) throws FileNotFoundException {

        File t = new File("lab9.txt"); //oppretter objekt til filen lab9.txt
        Scanner inn = new Scanner(t);   //Opprettar objekt for a lese fra fil.
        int i = 0; // oppretter en tellevariablel som leser hvor mange linjer det er
        double min = 0, max = 0, mid = 0, temp; // variabler som trengs

        while (inn.hasNext()) { // while lokke som leser helt til der er tomt
            inn.nextInt(); //leser inn verdier fra  filen og legger dei til i hver sin variabel.
            temp = inn.nextDouble();
            min = min + temp;
            temp = inn.nextDouble();
            mid = mid + temp;
            temp = inn.nextDouble();
            max = max + temp;
            i++;
        }
        //utskrift til bruker
        System.out.printf("Gjennomsnittet av minimumstemperaturene: %.2f", min / i);
        System.out.printf("\nGjennomsnittet av gjennomsnittstemperaturene: %.2f", mid / i);
        System.out.printf("\nGjennomsnittet av maksimumstemperaturene: %.2f\n", max / i);

    }

}
