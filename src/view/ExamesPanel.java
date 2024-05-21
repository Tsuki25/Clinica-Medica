package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExamesPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    JButton btnEletro;
    JButton btnEco;
    JButton btnErgonometrico;
    JButton btnHolter;


    public ExamesPanel(JFrame pacienteFrame) {
        setBackground(SystemColor.activeCaptionBorder);
        setLayout(null);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 55, 480, 2);
        add(separator);

        btnEletro = new JButton();
        btnEletro.setText("Eletrocardiograma");
        btnEletro.setIcon(null);
        btnEletro.setForeground(SystemColor.desktop);
        btnEletro.setFont(new Font("Bahnschrift", Font.BOLD, 16));
        btnEletro.setBackground(SystemColor.windowBorder);
        btnEletro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FormularioEletrocardiogramaFrame eletroFrame = new FormularioEletrocardiogramaFrame();
                eletroFrame.setResizable(true);
                eletroFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                eletroFrame.setBounds(100, 100, 450, 300);
                eletroFrame.setSize(530,870);
                eletroFrame.setVisible(true);
                pacienteFrame.setVisible(false);
            }
        });
        btnEletro.setBounds(146, 90, 214, 38);
        add(btnEletro);

        JLabel lblExames = new JLabel("Exames");
        lblExames.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        lblExames.setBounds(226, 25, 72, 20);
        add(lblExames);

        btnEco = new JButton();
        btnEco.setText("Ecocardiograma");
        btnEco.setForeground(SystemColor.desktop);
        btnEco.setFont(new Font("Bahnschrift", Font.BOLD, 16));
        btnEco.setBackground(SystemColor.windowBorder);
        btnEco.setBounds(146, 170, 214, 38);
        add(btnEco);

        btnErgonometrico = new JButton();
        btnErgonometrico.setText("Teste Ergonomêtrico");
        btnErgonometrico.setForeground(SystemColor.desktop);
        btnErgonometrico.setFont(new Font("Bahnschrift", Font.BOLD, 16));
        btnErgonometrico.setBackground(SystemColor.windowBorder);
        btnErgonometrico.setBounds(146, 250, 214, 38);
        add(btnErgonometrico);

        btnHolter = new JButton();
        btnHolter.setText("Holter 24 Horas");
        btnHolter.setForeground(SystemColor.desktop);
        btnHolter.setFont(new Font("Bahnschrift", Font.BOLD, 16));
        btnHolter.setBackground(SystemColor.windowBorder);
        btnHolter.setBounds(146, 330, 214, 38);
        add(btnHolter);
    }
}
