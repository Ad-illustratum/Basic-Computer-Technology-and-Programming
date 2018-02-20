/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr02lab10;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 *
 * @author Erlend
 */
public class oppg2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        JFrame vindu = new JFrame("Motstands utregning"); //oppretter et vindu med navn Bytting av tekst
        vindu.setSize(400, 300); // seter storrelsen paa vinduet
        GridLayout gl = new GridLayout(4, 2); // bruker grid layout for a faa boksene ned 1 og 1 vertikalt
        vindu.setLayout(gl); // setter gridlayouten til vinduet
        vindu.setLocationRelativeTo(null); //oppner vinduet i  midten av skjermen
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // legger til at naar du krysser ut programet avsluttes det

        JLabel a1 = new JLabel("Type motstands krets:");//oppretter en tekst blokk
        String[] s = {"Parallell", "Serie"};//oppretter en string 
        JComboBox valg = new JComboBox(s);//oppretteren kombobox
        JLabel a2 = new JLabel("Motstand 1(R1) er lik ");//oppretter en tekst block
        JTextField b1 = new JTextField("0"); // oppretter en tekststreng med tekst
        b1.setHorizontalAlignment(JTextField.CENTER); //setter teksten i senter
        JLabel a3 = new JLabel("Motstand 2(R2) er lik ");//oppretter en tekst block
        JTextField b2 = new JTextField("0");// oppretter en tekststreng med tekst
        b2.setHorizontalAlignment(JTextField.CENTER); //setter teksten i senter
        JButton regnut = new JButton("Rekn ut");// oppretter en knapp til aa trykke paa for aa utfore hadlingen
        JLabel a4 = new JLabel("");//oppretter en tekst block
        a4.setHorizontalAlignment(JLabel.CENTER); //setter teksten i senter

        //legger alt til i vinduet
        vindu.add(a1);
        vindu.add(valg);
        vindu.add(a2);
        vindu.add(b1);
        vindu.add(a3);
        vindu.add(b2);
        vindu.add(regnut);
        vindu.add(a4);

        //legger til en lytte klasse paa knappen
        regnut.addActionListener(new Regnutklasse(b1, b2, valg, a4));

        //setter alt synling
        vindu.setVisible(true);
    }

}

class Regnutklasse implements ActionListener {

    //datafelt med variablene
    JTextField b1, b2;
    JComboBox valg;
    JLabel a4;
    int num;
    double r1, r2;

    //konstruktor som setter variablene
    public Regnutklasse(JTextField b1, JTextField b2, JComboBox valg, JLabel a4) {
        this.b1 = b1;
        this.b2 = b2;
        this.valg = valg;
        this.a4 = a4;
    }

    //metode som sjekker om alle stringe kan konverters til desimaltall vist ikke setter den tekst feltet blankt
    public void sjekk() {

        try {
            r1 = Double.parseDouble(b1.getText());
        } catch (NumberFormatException e) {
            b1.setText("");
        }
        try {
            r2 = Double.parseDouble(b2.getText());
        } catch (NumberFormatException e) {
            b2.setText("");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //faar tallverdien fra indexen paa stringen
        num = valg.getSelectedIndex();

        //bruker metoden sjekk 
        sjekk();

        //sjekker at alle feltene er ut fylt
        if (b1.getText().length() > 0 && b2.getText().length() > 0) {

            //hvist indexsen er 1
            if (num == 1) {
                if (r1 < 0 || r2 < 0) {
                    a4.setText("fins ikke negativ motstand");
                } else {
                    DecimalFormat decimalformat = new DecimalFormat("#.##");// bruker desimalformat for aa av grense svaret til 2 desimaler
                    String tallsomstring = decimalformat.format((r1 + r2));
                    a4.setText(tallsomstring + " Ohm");
                }
            }
            //hvist indexsen er 0
            if (num == 0) {
                if (r1 + r2 == 0 || r1 * r2 == 0) {//feil melding hvist nevner eller teller blir null
                    a4.setText("Dette gaar ikke");
                } else if (r1 < 0 || r2 < 0) { // feil melding vist tallet er negativt
                    a4.setText("fins ikkje negativ motstand");
                } else { // ut regning
                    DecimalFormat decimalformat = new DecimalFormat("#.##");// bruker desimalformat for aa av grense svaret til 2 desimaler
                    String tallsomstring = decimalformat.format(((r1 * r2) / (r1 + r2)));
                    a4.setText(tallsomstring + " Ohm");
                }
            }
        } else {
             //vist der mangler tekst blir der skrevet ut en feil melding
            a4.setText("Fyll alle felt med tall.");
        }

    }
}
