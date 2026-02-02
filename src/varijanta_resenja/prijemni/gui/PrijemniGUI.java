package varijanta_resenja.prijemni.gui;

import varijanta_resenja.prijemni.OrganizacijaPrijemnogIspita;
import varijanta_resenja.prijemni.izuzeci.PrijemniException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PrijemniGUI extends JFrame {
    private JPanel mojPanel;
    private JButton ucitajButton;
    private JButton ispisiButton;
    private JButton izadjiButton;
    private JTextField textFieldNazivFajla;
    private JTextArea textArea1;

    private OrganizacijaPrijemnogIspita organizacijaPrijemnog = new OrganizacijaPrijemnogIspita();

    public PrijemniGUI(){
        setContentPane(mojPanel);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Prijemni ispit");
        ucitajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nazivFajla = textFieldNazivFajla.getText();

                try {
                    organizacijaPrijemnog.ucitajIzFajlaUListu(nazivFajla);
                } catch (PrijemniException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        izadjiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        ispisiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(null);

                List<String> naziviUstanova = organizacijaPrijemnog.vratiUspesnePrijemneIspite();

                if (!naziviUstanova.isEmpty())
                    for (String naziv : naziviUstanova)
                        textArea1.append(naziv + System.lineSeparator());
                else {
                    JOptionPane.showMessageDialog(null, "Nema ustanova koje ispunjavaju ovaj uslov.", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        new PrijemniGUI().setVisible(true);
    }
}
