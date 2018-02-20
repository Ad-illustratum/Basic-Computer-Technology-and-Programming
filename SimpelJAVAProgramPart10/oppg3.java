/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr02lab10;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 *
 * @author Erlend
 */
public class oppg3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame vindu = new JFrame("Spenningsfall utrekning"); //oppretter et vindu med navn Bytting av tekst
        vindu.setSize(450, 300); // seter storrelsen paa vinduet
        GridLayout gl = new GridLayout(7, 2); // bruker grid layout for a faa boksene ned 1 og 1 vertikalt
        vindu.setLayout(gl); // setter gridlayouten til vinduet
        vindu.setLocationRelativeTo(null); //oppner vinduet i  midten av skjermen
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // legger til at naar du krysser ut programet avsluttes det

        JLabel a1 = new JLabel("Type material:"); //oppretter en tekst block
        String[] s = {"Aluminium", "Kopar"};//oppretter en string 
        JComboBox valg = new JComboBox(s);//oppretteren kombobox
        JLabel a2 = new JLabel("Effekten(w) er lik ");//oppretter en tekst block
        JTextField b1 = new JTextField("0"); // oppretter en tekststreng med tekst
        b1.setHorizontalAlignment(JTextField.CENTER); //setter teksten i senter
        JLabel a3 = new JLabel("lengden(m) er lik ");//oppretter en tekst block
        JTextField b2 = new JTextField("0");// oppretter en tekststreng med tekst
        b2.setHorizontalAlignment(JTextField.CENTER); //setter teksten i senter
        JLabel a4 = new JLabel("Tverrsnittareal(mm^2) er lik ");//oppretter en tekst block
        JTextField b3 = new JTextField("0");// oppretter en tekststreng med tekst
        b3.setHorizontalAlignment(JTextField.CENTER); //setter teksten i senter
        JLabel a5 = new JLabel("Spenningen(v) er lik ");//oppretter en tekst block
        JTextField b4 = new JTextField("0");// oppretter en tekststreng med tekst
        b4.setHorizontalAlignment(JTextField.CENTER); //setter teksten i senter
        JButton regnutt = new JButton("Rekn ut");// oppretter en knapp til aa trykke paa for aa utfore hadlingen
        JLabel a6 = new JLabel("");//oppretter en tekst block
        a6.setHorizontalAlignment(JLabel.CENTER); //setter teksten i senter
        JLabel a7 = new JLabel("Godkjent i henhold til NEK400:");//oppretter en tekst block
        a7.setHorizontalAlignment(JLabel.CENTER); //setter teksten i senter
        JLabel a8 = new JLabel("");//oppretter en tekst block
        a8.setHorizontalAlignment(JLabel.CENTER); //setter teksten i senter

        //legger alt til i vinduet
        vindu.add(a1);
        vindu.add(valg);
        vindu.add(a2);
        vindu.add(b1);
        vindu.add(a3);
        vindu.add(b2);
        vindu.add(a4);
        vindu.add(b3);
        vindu.add(a5);
        vindu.add(b4);
        vindu.add(regnutt);
        vindu.add(a6);
        vindu.add(a7);
        vindu.add(a8);

        //legger til en lytte klasse paa knappen
        regnutt.addActionListener(new Regnuttklasse(valg, b1, b2, b3, b4, a6, a8));

        //setter alt synling
        vindu.setVisible(true);

    }

}

class Regnuttklasse implements ActionListener {

    //datafelt med variablene
    JComboBox valg;
    JTextField b1, b2, b3, b4;
    JLabel a6, a8;
    double p, rho, v, l, a, avvik;

    //konstruktor som setter variablene
    public Regnuttklasse(JComboBox valg, JTextField b1, JTextField b2, JTextField b3, JTextField b4, JLabel a6, JLabel a8) {
        this.valg = valg;
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
        this.a6 = a6;
        this.a8 = a8;
    }

    //metode som sjekker om alle stringe kan konverters til desimaltall vist ikke setter den tekst feltet blankt
    public void tall() {

        try {
            p = Double.parseDouble(b1.getText());
        } catch (NumberFormatException e) {
            b1.setText("");
        }
        try {
            l = Double.parseDouble(b2.getText());
        } catch (NumberFormatException e) {
            b2.setText("");
        }
        try {
            a = Double.parseDouble(b3.getText());
        } catch (NumberFormatException e) {
            b3.setText("");
        }
        try {
            v = Double.parseDouble(b4.getText());
        } catch (NumberFormatException e) {
            b4.setText("");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //sjekker hvilket matriall brukeren har valgt
        if (valg.getSelectedIndex() == 0) {
            rho = 0.3;
        } else {
            rho = 0.0175;
        }
        //bruker metoden tall 
        tall();

        //sjekker at alle feltene er ut fylt
        if (b1.getText().length() > 0 && b2.getText().length() > 0 && b3.getText().length() > 0 && b4.getText().length() > 0) {

            //vist brukeren har tastet null blir der gitt feil medling
            if (p == 0 || l == 0 || a == 0 || v == 0) {
                a6.setText("Du kan ikke bruke 0.");
                a8.setText("");
                //vist der er negative verdier far brukeren en feil meding
            } else if (p < 0 || l < 0 || a < 0 || v < 0) {
                a6.setText("Du kan ikke bruke negative verdier");
                a8.setText("");
            } else {
                //utregning av spenningsfallet
                DecimalFormat decimalformat = new DecimalFormat("#.##"); // bruker desimalformat for aa av grense svaret til 2 desimaler
                String tallsomstring = decimalformat.format((p * rho * l * 2) / a / v);
                a6.setText("DeltaU: " + tallsomstring + " v");
                avvik = ((p * rho * l * 2) / a / v) * 100 / v;
                if (avvik <= 3) {
                    a8.setText("ja");
                } else {
                    a8.setText("nei");
                }
            }
            //vist der mangler tekst blir der skrevet ut en feil melding
        } else {
            a6.setText("Fyll alle felt med tall.");
            a8.setText("(Husk aa bruk punktum for desimaler)");
        }
    }
}
