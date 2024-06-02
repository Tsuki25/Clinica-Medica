package view;

import control.EntregaController;
import model.EntregaExame;
import model.enums.TipoExame;
import model.exames.Ecocardiograma;
import model.exames.Eletrocardiograma;
import model.exames.Ergonometrico;
import model.exames.Holter;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import static control.PacienteController.getNomePacienteForId;
import static dao.ExameDao.getPacienteFromExame;
import static dao.FuncionarioDao.getNomeFuncionarioForId;
import static java.util.Objects.isNull;
import static model.utils.DateUtils.getStringFromDate2;

public class FormularioEntregasFrame extends JFrame {
    private JTextField tfCodFuncionario, tfNomeFuncionario;
    private JTextField tfCodPaciente, tfNomePaciente;
    private JTextField tfRetiradoPor;
    private JTextField tfCodExame, tfNomeExame;
    private JFormattedTextField ftfDataRetirada, ftfHorarioRetirada;
    private JTextField tfCodEntrega;
    private JLabel lbCodEntrega, lbDataRetirada, lbHorarioRetirada;
    private JButton btnSalvar;
    private JButton btnLimpar;
    private JButton btnBusca;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnSalvarEdicao;
    private JButton btnCancelarEdicao;
    private JButton btnVoltar;

    public FormularioEntregasFrame() {
        setBackground(SystemColor.activeCaptionBorder);
        setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(SystemColor.activeCaptionBorder);
        setContentPane(mainPanel);

        JLabel lbEntrega = new JLabel("Entrega de Exames");
        lbEntrega.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        lbEntrega.setBounds(176, 22, 180, 25);
        add(lbEntrega);

        JLabel lbCodFuncionario = new JLabel("Código Funcionário:");
        lbCodFuncionario.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbCodFuncionario.setBounds(20, 83, 146, 14);
        add(lbCodFuncionario);

        tfCodFuncionario = new JTextField();
        lbCodFuncionario.setLabelFor(tfCodFuncionario);
        tfCodFuncionario.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfCodFuncionario.setBounds(158, 80, 59, 20);
        tfCodFuncionario.setColumns(10);
        tfCodFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeFuncionario = getNomeFuncionarioForId(Integer.parseInt(tfCodFuncionario.getText()));
                tfNomeFuncionario.setText(nomeFuncionario);
            }
        });
        add(tfCodFuncionario);

        JLabel lbNomeFuncionario = new JLabel("Nome Funcionário:");
        lbNomeFuncionario.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbNomeFuncionario.setBounds(250, 83, 130, 20);
        add(lbNomeFuncionario);

        tfNomeFuncionario = new JTextField();
        tfNomeFuncionario.setEditable(false);
        tfNomeFuncionario.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfNomeFuncionario.setColumns(10);
        tfNomeFuncionario.setBounds(385, 80, 100, 20);
        tfNomeFuncionario.setBorder(BorderFactory.createLineBorder(new Color(96, 8, 166)));
        tfNomeFuncionario.setBackground(new Color(226, 207, 241));
        add(tfNomeFuncionario);

        JLabel lblNewLabel = new JLabel("Informações da Retirada");
        lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lblNewLabel.setBounds(20, 125, 267, 14);
        add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 142, 490, 2);
        add(separator);

        JLabel lbCodPaciente = new JLabel("Código Paciente:");
        lbCodPaciente.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbCodPaciente.setBounds(20, 159, 134, 14);
        add(lbCodPaciente);

        tfCodPaciente = new JTextField();
        lbCodPaciente.setLabelFor(tfCodPaciente);
        tfCodPaciente.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfCodPaciente.setColumns(10);
        tfCodPaciente.setBounds(143, 156, 59, 20);
        tfCodPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomePaciente = getNomePacienteForId(Integer.parseInt(tfCodPaciente.getText()));
                tfNomePaciente.setText(nomePaciente);
            }
        });
        add(tfCodPaciente);

        JLabel lbNomePaciente = new JLabel("Nome Paciente:");
        lbNomePaciente.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbNomePaciente.setBounds(250, 159, 120, 20);
        add(lbNomePaciente);

        tfNomePaciente = new JTextField();
        tfNomePaciente.setEditable(false);
        tfNomePaciente.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfNomePaciente.setColumns(10);
        tfNomePaciente.setBounds(365, 156, 120, 20);
        tfNomePaciente.setBorder(BorderFactory.createLineBorder(new Color(96, 8, 166)));
        tfNomePaciente.setBackground(new Color(226, 207, 241));
        add(tfNomePaciente);

        JLabel lbCodExame = new JLabel("Cod. Exame:");
        lbCodExame.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbCodExame.setBounds(20, 187, 130, 20);
        add(lbCodExame);

        tfCodExame = new JTextField();
        lbCodExame.setLabelFor(tfCodExame );
        tfCodExame.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfCodExame.setBounds(143, 184, 59, 20);
        tfCodExame.setColumns(10);
        add(tfCodExame);

        JLabel lbNomeExame = new JLabel("Nome Exame:");
        lbNomeExame.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbNomeExame.setBounds(250, 187, 130, 20);
        add(lbNomeExame);

        tfNomeExame = new JTextField();
        tfNomeExame.setEditable(false);
        tfNomeExame.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfNomeExame.setColumns(10);
        tfNomeExame.setBounds(345, 184, 140, 20);
        tfNomeExame.setBorder(BorderFactory.createLineBorder(new Color(96, 8, 166)));
        tfNomeExame.setBackground(new Color(226, 207, 241));
        add(tfNomeExame);

        JLabel lbRetiradoPor = new JLabel("Retirado Por: ");
        lbRetiradoPor.setLabelFor(tfRetiradoPor);
        lbRetiradoPor.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbRetiradoPor.setBounds(20, 217, 90, 14);
        add(lbRetiradoPor);

        tfRetiradoPor = new JTextField();
        tfRetiradoPor.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfRetiradoPor.setColumns(10);
        tfRetiradoPor.setBounds(120, 212, 120, 20);
        add(tfRetiradoPor);

        lbDataRetirada = new JLabel("Data de Retirada: ");
        lbDataRetirada.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbDataRetirada.setBounds(20, 245, 117, 14);
        lbDataRetirada.setVisible(false);
        add(lbDataRetirada);

        ftfDataRetirada = new JFormattedTextField();
        lbDataRetirada.setLabelFor(ftfDataRetirada);
        MaskFormatter maskFormatter;
        try {
            maskFormatter = new MaskFormatter("##/##/####"); // Define a máscara para o formato da data
            maskFormatter.install(ftfDataRetirada); // Aplica a máscara ao JFormattedTextField
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ftfDataRetirada.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        ftfDataRetirada.setBounds(147, 240, 134, 20);
        ftfDataRetirada.setVisible(false);
        add(ftfDataRetirada);

        lbHorarioRetirada = new JLabel("Horário Retirada:");
        lbHorarioRetirada.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbHorarioRetirada.setBounds(20, 273, 130, 14);
        lbHorarioRetirada.setVisible(false);
        add(lbHorarioRetirada);

        MaskFormatter timeFormatter = null;
        try {
            timeFormatter = new MaskFormatter("##:##");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ftfHorarioRetirada = new JFormattedTextField(timeFormatter);
        ftfHorarioRetirada.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        ftfHorarioRetirada.setBounds(130, 268, 38, 20);
        ftfHorarioRetirada.setVisible(false);
        add(ftfHorarioRetirada);

        btnSalvar = new JButton();
        btnSalvar.setIcon(new ImageIcon(getClass().getResource("/view/icons/salvar-arquivo.png")));
        btnSalvar.setBackground(SystemColor.windowBorder);
        btnSalvar.setForeground(SystemColor.desktop);
        btnSalvar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EntregaController ec = new EntregaController();
                ec.controlSalvar(FormularioEntregasFrame.this);

                limparCampos();
            }
        });
        btnSalvar.setBounds(432, 775, 38, 38);
        add(btnSalvar);

        btnLimpar = new JButton();
        btnLimpar.setIcon(new ImageIcon(getClass().getResource("/view/icons/limpar.png")));
        btnLimpar.setForeground(SystemColor.desktop);
        btnLimpar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnLimpar.setBackground(SystemColor.windowBorder);
        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        btnLimpar.setBounds(384, 775, 38, 38);
        add(btnLimpar);

        btnBusca = new JButton();
        btnBusca.setIcon(new ImageIcon(getClass().getResource("/view/icons/lupa.png")));
        btnBusca.setForeground(SystemColor.desktop);
        btnBusca.setFont(new Font("Bahnschrift", Font.PLAIN, 5));
        btnBusca.setBackground(SystemColor.windowBorder);
        btnBusca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListaEntregaFrame listaEntregaFrame = new ListaEntregaFrame();
                listaEntregaFrame.setSize(1600, 900);
                listaEntregaFrame.setVisible(true);
                FormularioEntregasFrame.this.setVisible(false);
            }
        });
        btnBusca.setBounds(336, 775, 38, 38);
        add(btnBusca);

        btnVoltar = new JButton();
        btnVoltar.setIcon(new ImageIcon(getClass().getResource("/view/icons/voltar.png")));
        btnVoltar.setBackground(SystemColor.windowBorder);
        btnVoltar.setForeground(SystemColor.desktop);
        btnVoltar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnVoltar.setBounds(288, 775, 38, 38);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame novoFrame = new MainFrame();
                novoFrame.setSize(530, 870);
                novoFrame.setVisible(true);
                FormularioEntregasFrame.this.setVisible(false);
            }
        });
        add(btnVoltar);

    }

    public FormularioEntregasFrame(Object exameChave) {
        setBackground(SystemColor.activeCaptionBorder);
        setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(SystemColor.activeCaptionBorder);
        setContentPane(mainPanel);

        JLabel lbEntrega = new JLabel("Entrega de Exames");
        lbEntrega.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        lbEntrega.setBounds(176, 22, 180, 25);
        add(lbEntrega);

        JLabel lbCodFuncionario = new JLabel("Código Funcionário:");
        lbCodFuncionario.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbCodFuncionario.setBounds(20, 83, 146, 14);
        add(lbCodFuncionario);

        tfCodFuncionario = new JTextField();
        lbCodFuncionario.setLabelFor(tfCodFuncionario);
        tfCodFuncionario.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfCodFuncionario.setBounds(158, 80, 59, 20);
        tfCodFuncionario.setColumns(10);
        tfCodFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeFuncionario = getNomeFuncionarioForId(Integer.parseInt(tfCodFuncionario.getText()));
                tfNomeFuncionario.setText(nomeFuncionario);
            }
        });
        add(tfCodFuncionario);

        JLabel lbNomeFuncionario = new JLabel("Nome Funcionário:");
        lbNomeFuncionario.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbNomeFuncionario.setBounds(250, 83, 130, 20);
        add(lbNomeFuncionario);

        tfNomeFuncionario = new JTextField();
        tfNomeFuncionario.setEditable(false);
        tfNomeFuncionario.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfNomeFuncionario.setColumns(10);
        tfNomeFuncionario.setBounds(385, 80, 100, 20);
        tfNomeFuncionario.setBorder(BorderFactory.createLineBorder(new Color(96, 8, 166)));
        tfNomeFuncionario.setBackground(new Color(226, 207, 241));
        add(tfNomeFuncionario);

        JLabel lblNewLabel = new JLabel("Informações da Retirada");
        lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lblNewLabel.setBounds(20, 125, 267, 14);
        add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 142, 490, 2);
        add(separator);

        JLabel lbCodPaciente = new JLabel("Código Paciente:");
        lbCodPaciente.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbCodPaciente.setBounds(20, 159, 134, 14);
        add(lbCodPaciente);

        tfCodPaciente = new JTextField();
        lbCodPaciente.setLabelFor(tfCodPaciente);
        tfCodPaciente.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfCodPaciente.setColumns(10);
        tfCodPaciente.setBounds(143, 156, 59, 20);
        tfCodPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomePaciente = getNomePacienteForId(Integer.parseInt(tfCodPaciente.getText()));
                tfNomePaciente.setText(nomePaciente);
            }
        });
        add(tfCodPaciente);

        JLabel lbNomePaciente = new JLabel("Nome Paciente:");
        lbNomePaciente.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbNomePaciente.setBounds(250, 159, 120, 20);
        add(lbNomePaciente);

        tfNomePaciente = new JTextField();
        tfNomePaciente.setEditable(false);
        tfNomePaciente.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfNomePaciente.setColumns(10);
        tfNomePaciente.setBounds(365, 156, 120, 20);
        tfNomePaciente.setBorder(BorderFactory.createLineBorder(new Color(96, 8, 166)));
        tfNomePaciente.setBackground(new Color(226, 207, 241));
        add(tfNomePaciente);

        JLabel lbCodExame = new JLabel("Cod. Exame:");
        lbCodExame.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbCodExame.setBounds(20, 187, 130, 20);
        add(lbCodExame);

        tfCodExame = new JTextField();
        lbCodExame.setLabelFor(tfCodExame );
        tfCodExame.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfCodExame.setBounds(143, 184, 59, 20);
        tfCodExame.setColumns(10);
        add(tfCodExame);

        JLabel lbNomeExame = new JLabel("Nome Exame:");
        lbNomeExame.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbNomeExame.setBounds(250, 187, 130, 20);
        add(lbNomeExame);

        tfNomeExame = new JTextField();
        tfNomeExame.setEditable(false);
        tfNomeExame.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfNomeExame.setColumns(10);
        tfNomeExame.setBounds(345, 184, 140, 20);
        tfNomeExame.setBorder(BorderFactory.createLineBorder(new Color(96, 8, 166)));
        tfNomeExame.setBackground(new Color(226, 207, 241));
        add(tfNomeExame);

        JLabel lbRetiradoPor = new JLabel("Retirado Por: ");
        lbRetiradoPor.setLabelFor(tfRetiradoPor);
        lbRetiradoPor.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbRetiradoPor.setBounds(20, 217, 90, 14);
        add(lbRetiradoPor);

        tfRetiradoPor = new JTextField();
        tfRetiradoPor.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfRetiradoPor.setColumns(10);
        tfRetiradoPor.setBounds(120, 212, 120, 20);
        add(tfRetiradoPor);

        JLabel lbDataRetirada = new JLabel("Data de Retirada: ");
        lbDataRetirada.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbDataRetirada.setBounds(20, 245, 117, 14);
        lbDataRetirada.setVisible(false);
        add(lbDataRetirada);

        ftfDataRetirada = new JFormattedTextField();
        lbDataRetirada.setLabelFor(ftfDataRetirada);
        MaskFormatter maskFormatter;
        try {
            maskFormatter = new MaskFormatter("##/##/####"); // Define a máscara para o formato da data
            maskFormatter.install(ftfDataRetirada); // Aplica a máscara ao JFormattedTextField
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ftfDataRetirada.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        ftfDataRetirada.setBounds(336, 240, 134, 20);
        ftfDataRetirada.setVisible(false);
        add(ftfDataRetirada);

        JLabel lbHorarioRetirada = new JLabel("Horário Retirada:");
        lbHorarioRetirada.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbHorarioRetirada.setBounds(20, 273, 130, 14);
        lbHorarioRetirada.setVisible(false);
        add(lbHorarioRetirada);

        MaskFormatter timeFormatter = null;
        try {
            timeFormatter = new MaskFormatter("##:##");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ftfHorarioRetirada = new JFormattedTextField(timeFormatter);
        ftfHorarioRetirada.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        ftfHorarioRetirada.setBounds(150, 268, 38, 20);
        ftfHorarioRetirada.setVisible(false);
        add(ftfHorarioRetirada);

        btnSalvar = new JButton();
        btnSalvar.setIcon(new ImageIcon(getClass().getResource("/view/icons/salvar-arquivo.png")));
        btnSalvar.setBackground(SystemColor.windowBorder);
        btnSalvar.setForeground(SystemColor.desktop);
        btnSalvar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EntregaController ec = new EntregaController();
                ec.controlSalvar(FormularioEntregasFrame.this);

                limparCampos();
            }
        });
        btnSalvar.setBounds(432, 775, 38, 38);
        add(btnSalvar);

        btnLimpar = new JButton();
        btnLimpar.setIcon(new ImageIcon(getClass().getResource("/view/icons/limpar.png")));
        btnLimpar.setForeground(SystemColor.desktop);
        btnLimpar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnLimpar.setBackground(SystemColor.windowBorder);
        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        btnLimpar.setBounds(384, 775, 38, 38);
        add(btnLimpar);

        btnBusca = new JButton();
        btnBusca.setIcon(new ImageIcon(getClass().getResource("/view/icons/lupa.png")));
        btnBusca.setForeground(SystemColor.desktop);
        btnBusca.setFont(new Font("Bahnschrift", Font.PLAIN, 5));
        btnBusca.setBackground(SystemColor.windowBorder);
        btnBusca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListaEntregaFrame listaEntregaFrame = new ListaEntregaFrame();
                listaEntregaFrame.setSize(1600, 900);
                listaEntregaFrame.setVisible(true);
                FormularioEntregasFrame.this.setVisible(false);
            }
        });
        btnBusca.setBounds(336, 775, 38, 38);
        add(btnBusca);

        btnVoltar = new JButton();
        btnVoltar.setIcon(new ImageIcon(getClass().getResource("/view/icons/voltar.png")));
        btnVoltar.setBackground(SystemColor.windowBorder);
        btnVoltar.setForeground(SystemColor.desktop);
        btnVoltar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnVoltar.setBounds(288, 775, 38, 38);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame novoFrame = new MainFrame();
                novoFrame.setSize(530, 870);
                novoFrame.setVisible(true);
                FormularioEntregasFrame.this.setVisible(false);
            }
        });
        add(btnVoltar);

        preencherExame(exameChave);
    }


    public FormularioEntregasFrame(Integer codEntrega){
        this();//chama o construtor padrão
        EntregaExame entrega = getDadosEntrega(codEntrega);

        btnLimpar.setVisible(false);//Deixa os botões do outro formulario ocultos
        btnSalvar.setVisible(false);
        btnVoltar.setBounds(288, 775, 38, 38);

        tfCodPaciente.setBorder(BorderFactory.createLineBorder(new Color(96, 8, 166)));
        tfCodPaciente.setBackground(new Color(226, 207, 241));

        tfCodExame.setBorder(BorderFactory.createLineBorder(new Color(96, 8, 166)));
        tfCodExame.setBackground(new Color(226, 207, 241));

        lbCodEntrega = new JLabel("Código de Entrega:");
        lbCodEntrega.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbCodEntrega.setBounds(20, 780, 135, 20);
        add(lbCodEntrega);

        tfCodEntrega = new JTextField();
        lbCodEntrega.setLabelFor(tfCodEntrega);
        tfCodEntrega.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        tfCodEntrega.setColumns(10);
        tfCodEntrega.setBounds(160, 782, 75, 20);
        tfCodEntrega.setBorder(BorderFactory.createLineBorder(new Color(96, 8, 166)));
        tfCodEntrega.setBackground(new Color(226, 207, 241));
        tfCodEntrega.setEditable(false);
        add(tfCodEntrega);

        lbDataRetirada.setVisible(true);
        lbHorarioRetirada.setVisible(true);
        ftfDataRetirada.setVisible(true);
        ftfHorarioRetirada.setVisible(true);

        preencherCampos(entrega);// preenche o formulario com os dados
        setStatusEdicaoCampos(false); //Deixa todos os campos editaveis(true) ou não editaveis(false)

        btnEditar = new JButton();
        btnEditar.setIcon(new ImageIcon(getClass().getResource("/view/icons/editar.png")));
        btnEditar.setBackground(SystemColor.windowBorder);
        btnEditar.setForeground(SystemColor.desktop);
        btnEditar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnEditar.setBounds(432, 775, 38, 38);
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setStatusEdicaoCampos(true);
                btnEditar.setVisible(false);
                btnExcluir.setVisible(false);
                btnCancelarEdicao.setVisible(true);
                btnSalvarEdicao.setVisible(true);
            }
        });
        add(btnEditar);

        btnExcluir = new JButton();
        btnExcluir.setIcon(new ImageIcon(getClass().getResource("/view/icons/lata-de-lixo.png")));
        btnExcluir.setForeground(SystemColor.desktop);
        btnExcluir.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnExcluir.setBackground(SystemColor.windowBorder);
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o registro?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (confirmacao == JOptionPane.YES_OPTION) {
                    EntregaController ec = new EntregaController();
                    ec.controlExcluirEntrega(entrega);
                    JOptionPane.showMessageDialog(null, "Exame excluido com sucesso");
                    limparCampos();
                }
            }
        });
        btnExcluir.setBounds(384, 775, 38, 38);
        add(btnExcluir);

        btnSalvarEdicao = new JButton(); // APARECE NO LUGAR DO btnEditar
        btnSalvarEdicao.setIcon(new ImageIcon(getClass().getResource("/view/icons/confirmar.png")));
        btnSalvarEdicao.setBackground(SystemColor.windowBorder);
        btnSalvarEdicao.setForeground(SystemColor.desktop);
        btnSalvarEdicao.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnSalvarEdicao.setBounds(432, 775, 38, 38);
        btnSalvarEdicao.setVisible(false);
        btnSalvarEdicao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EntregaController ec = new EntregaController();
                EntregaExame entregaAtualizado =  ec.controlAtualizarEntrega(FormularioEntregasFrame.this);

                if(!isNull(entregaAtualizado)){
                    preencherCampos(entregaAtualizado);
                    JOptionPane.showMessageDialog(null, "Entrega atualizada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Dados inválidos ou vazios", "ERRO!", JOptionPane.INFORMATION_MESSAGE);
                }

                setStatusEdicaoCampos(false);
                btnEditar.setVisible(true);
                btnExcluir.setVisible(true);
                btnCancelarEdicao.setVisible(false);
                btnSalvarEdicao.setVisible(false);
            }
        });
        add(btnSalvarEdicao);

        btnCancelarEdicao = new JButton(); // APARECE NO LUGAR DO btnExcluir
        btnCancelarEdicao.setIcon(new ImageIcon(getClass().getResource("/view/icons/cancelar.png")));
        btnCancelarEdicao.setForeground(SystemColor.desktop);
        btnCancelarEdicao.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnCancelarEdicao.setBackground(SystemColor.windowBorder);
        btnCancelarEdicao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setStatusEdicaoCampos(false);
                btnEditar.setVisible(true);
                btnExcluir.setVisible(true);
                preencherCampos(entrega);
                btnCancelarEdicao.setVisible(false);
                btnSalvarEdicao.setVisible(false);
            }
        });
        btnCancelarEdicao.setBounds(384, 775, 38, 38);
        add(btnCancelarEdicao);

    }

    private void preencherCampos(EntregaExame entrega){
        // SETA OS VALORES DOS CAMPOS DE ACORDO COM O RECUPERADO DO BANCO DE DADOS
        Integer codPaciente = getPacienteFromExame(entrega.getCodExame());

        tfCodPaciente.setText(codPaciente.toString());
        tfNomePaciente.setText(getNomePacienteForId(Integer.parseInt(tfCodPaciente.getText())));
        tfCodFuncionario.setText(entrega.getCodResponsavel().toString());
        tfNomeFuncionario.setText(getNomeFuncionarioForId(Integer.parseInt(tfCodFuncionario.getText())));
        tfCodExame.setText(entrega.getCodExame().toString());
        tfRetiradoPor.setText(entrega.getRetiradoPor());
        ftfDataRetirada.setText(getStringFromDate2(entrega.getDataRetirada()));
        ftfHorarioRetirada.setText(entrega.getHorarioRetirada().toString());
        tfCodEntrega.setText(entrega.getCodEntrega().toString());
    }

    private void setStatusEdicaoCampos(Boolean status){
        Color borderEditavel = new Color(66, 64, 64);
        Color borderIneditavel = new Color(96, 8, 166);
        Color bgEditavel = new Color(238, 240, 242);
        Color bgIneditavel = new Color(226, 207, 241);

        if(status) alterCoresCampos(borderEditavel, bgEditavel);
        else alterCoresCampos(borderIneditavel, bgIneditavel);

        tfCodFuncionario.setEditable(status);
        tfRetiradoPor.setEditable(status);
        ftfDataRetirada.setEditable(status);
        ftfHorarioRetirada.setEditable(status);

    }

    private EntregaExame getDadosEntrega(Integer codEntrega) {
        EntregaController ec = new EntregaController();
        return ec.controlBuscarEntregaForId(codEntrega);
    }

    private void alterCoresCampos(Color corBorda, Color corFundo){

        tfCodFuncionario.setBorder(BorderFactory.createLineBorder(corBorda));
        tfCodFuncionario.setBackground(corFundo);

        tfRetiradoPor.setBorder(BorderFactory.createLineBorder(corBorda));
        tfRetiradoPor.setBackground(corFundo);

        ftfDataRetirada.setBorder(BorderFactory.createLineBorder(corBorda));
        ftfDataRetirada.setBackground(corFundo);

        ftfHorarioRetirada.setBorder(BorderFactory.createLineBorder(corBorda));
        ftfHorarioRetirada.setBackground(corFundo);

    }

    private void limparCampos() {
        tfCodPaciente.setText("");
        tfNomePaciente.setText("");
        tfCodFuncionario.setText("");
        tfNomeFuncionario.setText("");
        tfRetiradoPor.setText("");
        tfCodExame.setText("");
        tfNomeExame.setText("");
        ftfDataRetirada.setText("");
        ftfHorarioRetirada.setText("");
    }

    private void preencherExame(Object exameChave){
        if (exameChave instanceof Eletrocardiograma) {
            Eletrocardiograma exame = (Eletrocardiograma) exameChave;
            tfCodPaciente.setText(exame.getCodPaciente().toString());
            tfCodExame.setText(exame.getCodExame().toString());
            tfNomeExame.setText(TipoExame.ELETROCARDIOGRAMA.getTipo());

        } else if (exameChave instanceof Ecocardiograma) {
            Ecocardiograma exame = (Ecocardiograma) exameChave;
            tfCodPaciente.setText(exame.getCodPaciente().toString());
            tfCodExame.setText(exame.getCodExame().toString());
            tfNomeExame.setText(TipoExame.ECOCARDIOGRAMA.getTipo());

        } else if (exameChave instanceof Ergonometrico){
            Ergonometrico exame = (Ergonometrico) exameChave;
            tfCodPaciente.setText(exame.getCodPaciente().toString());
            tfCodExame.setText(exame.getCodExame().toString());
            tfNomeExame.setText(TipoExame.ERGOMETRICO.getTipo());

        }else if(exameChave instanceof Holter) {
            Holter exame = (Holter) exameChave;
            tfCodPaciente.setText(exame.getCodPaciente().toString());
            tfCodExame.setText(exame.getCodExame().toString());
            tfNomeExame.setText(TipoExame.HOLTER.getTipo());
        }
    }

    public JTextField getTfCodFuncionario() {
        return tfCodFuncionario;
    }

    public void setTfCodFuncionario(JTextField tfCodFuncionario) {
        this.tfCodFuncionario = tfCodFuncionario;
    }

    public JTextField getTfNomeFuncionario() {
        return tfNomeFuncionario;
    }

    public void setTfNomeFuncionario(JTextField tfNomeFuncionario) {
        this.tfNomeFuncionario = tfNomeFuncionario;
    }

    public JTextField getTfCodPaciente() {
        return tfCodPaciente;
    }

    public void setTfCodPaciente(JTextField tfCodPaciente) {
        this.tfCodPaciente = tfCodPaciente;
    }

    public JTextField getTfNomePaciente() {
        return tfNomePaciente;
    }

    public void setTfNomePaciente(JTextField tfNomePaciente) {
        this.tfNomePaciente = tfNomePaciente;
    }

    public JTextField getTfRetiradoPor() {
        return tfRetiradoPor;
    }

    public void setTfRetiradoPor(JTextField tfRetiradoPor) {
        this.tfRetiradoPor = tfRetiradoPor;
    }

    public JTextField getTfCodExame() {
        return tfCodExame;
    }

    public void setTfCodExame(JTextField tfCodExame) {
        this.tfCodExame = tfCodExame;
    }

    public JTextField getTfNomeExame() {
        return tfNomeExame;
    }

    public void setTfNomeExame(JTextField tfNomeExame) {
        this.tfNomeExame = tfNomeExame;
    }

    public JFormattedTextField getFtfDataRetirada() {
        return ftfDataRetirada;
    }

    public void setFtfDataRetirada(JFormattedTextField ftfDataRetirada) {
        this.ftfDataRetirada = ftfDataRetirada;
    }

    public JFormattedTextField getFtfHorarioRetirada() {
        return ftfHorarioRetirada;
    }

    public void setFtfHorarioRetirada(JFormattedTextField ftfHorarioRetirada) {
        this.ftfHorarioRetirada = ftfHorarioRetirada;
    }

    public JTextField getTfCodEntrega() {
        return tfCodEntrega;
    }

    public void setTfCodEntrega(JTextField tfCodEntrega) {
        this.tfCodEntrega = tfCodEntrega;
    }
}
