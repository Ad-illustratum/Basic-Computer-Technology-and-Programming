/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr02lab10;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Erlend
 */
public class oppg1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame vindu = new JFrame("Bytting av tekst"); //oppretter et vindu med navn Bytting av tekst
        vindu.setSize(400, 400); // seter storrelsen paa vinduet
        GridLayout gl = new GridLayout(5, 1); // bruker grid layout for a faa boksene ned 1 og 1 vertikalt
        vindu.setLayout(gl); // setter gridlayouten til vinduet
        vindu.setLocationRelativeTo(null); //setter vinduet i midten av skjermen
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // legger til at naar du krysser ut programet avsluttes det

        JTextField b1 = new JTextField("tekstfelt1"); // oppretter en tekststreng med tekst
        b1.setHorizontalAlignment(JTextField.CENTER);   //setter teksten i senter
        JTextField b2 = new JTextField("tekstfelt2");// oppretter en tekststreng med tekst
        b2.setHorizontalAlignment(JTextField.CENTER); //setter teksten i senter
        JTextField b3 = new JTextField("tekstfelt3");// oppretter en tekststreng med tekst
        b3.setHorizontalAlignment(JTextField.CENTER); //setter teksten i senter
        JTextField b4 = new JTextField("tekstfelt4");// oppretter en tekststreng med tekst
        b4.setHorizontalAlignment(JTextField.CENTER); //setter teksten i senter
        JButton bytt = new JButton("Flytt paa teksten");// oppretter en knapp til aa trykke paa for aa utfore hadlingen

        //legger alt til i vinduet
        vindu.add(b1);
        vindu.add(b2);
        vindu.add(b3);
        vindu.add(b4);
        vindu.add(bytt);

        //legger til en lytte klasse paa knappen
        bytt.addActionListener(new Byttklasse(b1, b2, b3, b4));

        //setter alt synling
        vindu.setVisible(true);
    }
}

class Byttklasse implements ActionListener { // klasse som utforer onsket handling

    //datafelt for variablene
    JTextField b1, b2, b3, b4;
    String a;

    //konstruktor som faar til sendt tekst feltene og setter dem til de lokale variablene
    public Byttklasse(JTextField b1, JTextField b2, JTextField b3, JTextField b4) {
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;

    }

    @Override // metodte som utforer handling nar du trykker paa knappen
    public void actionPerformed(ActionEvent e) {
        a = b1.getText(); // matte bruke en string slik at all tekst ble likt i programet
        b1.setText(b4.getText()); // kopierer teksten fra hver av 
        b4.setText(b3.getText());
        b3.setText(b2.getText());
        b2.setText(a);

    }
}
//en kan endre teksten i boksene uten at det har noe aa si for programmet
