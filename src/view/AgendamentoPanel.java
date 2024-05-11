package view;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class AgendamentoPanel extends JPanel {
    private JComboBox<String> cbExames, cbStatus;
    private JTextField tfCodPaciente, tfNomePaciente, tfCodFuncionario, tfNomeFuncionario;
    private JFormattedTextField ftfDataAgendamento, ftfHorarioAgendamento;
    private JButton btnSalvar, btnLimpar, btnBusca;

    String[] exames = {
            "Ecocardiograma", "Eletrocardiograma", "Teste Ergonometrico", "Holter 24 Horas"
    };

    String[] status = {
            "Agendado", "Realizado", "Cancelado"
    };

    public AgendamentoPanel(JFrame pacienteFrame) {
        setBackground(SystemColor.activeCaptionBorder);
        setLayout(null);

        JLabel lbExames = new JLabel("Exame:");
        lbExames.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbExames.setBounds(20, 87, 60, 14);
        add(lbExames);

        cbExames = new JComboBox<>(exames);
        cbExames.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        cbExames.setBounds(74, 81, 200, 26);
        add(cbExames);

        JLabel lbCodPaciente = new JLabel("Código Paciente:");
        lbCodPaciente.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbCodPaciente.setBounds(20, 216, 100, 14);
        add(lbCodPaciente);

        tfCodPaciente = new JTextField();
        tfCodPaciente.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfCodPaciente.setColumns(10);
        tfCodPaciente.setBounds(137, 317, 45, 20);
        add(tfCodPaciente);

        JLabel lbNomePaciente = new JLabel("Nome Paciente:");
        lbNomePaciente.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbNomePaciente.setBounds(20, 244, 92, 14);
        add(lbNomePaciente);

        tfNomePaciente = new JTextField();
        tfNomePaciente.setEditable(false);
        tfNomePaciente.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfNomePaciente.setColumns(10);
        tfNomePaciente.setBounds(115, 241, 164, 20);
        add(tfNomePaciente);

        JLabel lbCodFuncionario = new JLabel("Código Funcionário:");
        lbCodFuncionario.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbCodFuncionario.setBounds(20, 320, 120, 14);
        add(lbCodFuncionario);

        tfCodFuncionario = new JTextField();
        tfCodFuncionario.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfCodFuncionario.setColumns(10);
        tfCodFuncionario.setBounds(115, 213, 45, 20);
        add(tfCodFuncionario);

        JLabel lbNomeFuncionario = new JLabel("Nome Funcionário:");
        lbNomeFuncionario.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbNomeFuncionario.setBounds(20, 351, 120, 14);
        add(lbNomeFuncionario);

        tfNomeFuncionario = new JTextField();
        tfNomeFuncionario.setEditable(false);
        tfNomeFuncionario.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfNomeFuncionario.setColumns(10);
        tfNomeFuncionario.setBounds(132, 348, 147, 20);
        add(tfNomeFuncionario);

        JLabel lbDataAgendamento = new JLabel("Data Agendamento:");
        lbDataAgendamento.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbDataAgendamento.setBounds(20, 115, 120, 14);
        add(lbDataAgendamento);

        MaskFormatter dateFormatter = null;
        try {
            dateFormatter = new MaskFormatter("##/##/####");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ftfDataAgendamento = new JFormattedTextField(dateFormatter);
        ftfDataAgendamento.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        ftfDataAgendamento.setBounds(137, 112, 67, 20);
        add(ftfDataAgendamento);

        JLabel lbHorarioAgendamento = new JLabel("Horário Agendamento:");
        lbHorarioAgendamento.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbHorarioAgendamento.setBounds(20, 143, 130, 14);
        add(lbHorarioAgendamento);

        MaskFormatter timeFormatter = null;
        try {
            timeFormatter = new MaskFormatter("##:##");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ftfHorarioAgendamento = new JFormattedTextField(timeFormatter);
        ftfHorarioAgendamento.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        ftfHorarioAgendamento.setBounds(150, 140, 38, 20);
        add(ftfHorarioAgendamento);

        JLabel lbStatus = new JLabel("Status:");
        lbStatus.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbStatus.setBounds(20, 449, 60, 14);
        add(lbStatus);

        cbStatus = new JComboBox<>(status);
        cbStatus.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        cbStatus.setBounds(74, 443, 100, 26);
        add(cbStatus);

        btnSalvar = new JButton();
        btnSalvar.setIcon(new ImageIcon(getClass().getResource("/view/icons/salvar-arquivo.png")));
        btnSalvar.setBackground(SystemColor.windowBorder);
        btnSalvar.setForeground(SystemColor.desktop);
        btnSalvar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnSalvar.setBounds(432, 433, 38, 38);
        add(btnSalvar);

        btnLimpar = new JButton();
        btnLimpar.setIcon(new ImageIcon(getClass().getResource("/view/icons/limpar.png")));
        btnLimpar.setForeground(SystemColor.desktop);
        btnLimpar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnLimpar.setBackground(SystemColor.windowBorder);
        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnLimpar.setBounds(384, 433, 38, 38);
        add(btnLimpar);

        btnBusca = new JButton();
        btnBusca.setIcon(new ImageIcon(getClass().getResource("/view/icons/lupa.png")));
        btnBusca.setForeground(SystemColor.desktop);
        btnBusca.setFont(new Font("Bahnschrift", Font.PLAIN, 5));
        btnBusca.setBackground(SystemColor.windowBorder);
        btnBusca.setBounds(336, 433, 38, 38);
        add(btnBusca);

        JLabel lbAgendamento = new JLabel("Agendamento");
        lbAgendamento.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        lbAgendamento.setBounds(187, 23, 135, 14);
        add(lbAgendamento);

        JSeparator separator = new JSeparator();
        separator.setBounds(229, 50, 151, 0);
        add(separator);

        JLabel lblPaciente = new JLabel("Paciente");
        lblPaciente.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lblPaciente.setBounds(20, 183, 267, 14);
        add(lblPaciente);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(10, 200, 480, 2);
        add(separator_2);

        JSeparator separator_2_1 = new JSeparator();
        separator_2_1.setBounds(10, 50, 480, 2);
        add(separator_2_1);

        JLabel lblResponsvelPeloExame = new JLabel("Responsável pelo Exame");
        lblResponsvelPeloExame.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lblResponsvelPeloExame.setBounds(20, 287, 267, 14);
        add(lblResponsvelPeloExame);

        JSeparator separator_2_2 = new JSeparator();
        separator_2_2.setBounds(10, 304, 480, 2);
        add(separator_2_2);
    }
}