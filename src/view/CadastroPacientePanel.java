package view;

import javax.swing.*;
import java.awt.Font;
import javax.swing.text.MaskFormatter;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class CadastroPacientePanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfCpf;
	private JTextField tfNome;
	private JTextField tfSobrenome;
	private JTextField tfTelefone;
	private JTextField tfCelular;
	private JTextField tfEmail;
	private JTextField tfLogradouro;
	private JTextField tfCep;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfNumero;
	private JTextField tfComplemento;
	
	String[] siglas = {
            "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR",
            "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"
        };

	/**
	 * Create the panel.
	 */
	public CadastroPacientePanel() {
		setBackground(SystemColor.activeCaptionBorder);
		setLayout(null);
		
		JLabel lbCpf = new JLabel("CPF:");
		lbCpf.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		lbCpf.setBounds(20, 25, 33, 14);
		add(lbCpf);
		
		tfCpf = new JTextField();
		lbCpf.setLabelFor(tfCpf);
		tfCpf.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		tfCpf.setBounds(63, 22, 117, 20);
		add(tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lbNome = new JLabel("Nome: ");
		lbNome.setLabelFor(lbNome);
		lbNome.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lbNome.setBounds(20, 100, 39, 14);
		add(lbNome);
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		tfNome.setColumns(10);
		tfNome.setBounds(63, 97, 117, 20);
		add(tfNome);
		
		JLabel lbSobrenome = new JLabel("Sobrenome: ");
		lbSobrenome.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lbSobrenome.setBounds(215, 100, 72, 14);
		add(lbSobrenome);
		
		tfSobrenome = new JTextField();
		tfSobrenome.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		tfSobrenome.setColumns(10);
		tfSobrenome.setBounds(290, 97, 180, 20);
		add(tfSobrenome);
		
		JLabel lbSexo = new JLabel("Sexo:");
		lbSexo.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		lbSexo.setBounds(20, 130, 33, 14);
		add(lbSexo);
		
		JComboBox cbSexo = new JComboBox();
		lbSexo.setLabelFor(cbSexo);
		cbSexo.setBounds(63, 125, 117, 22);
		add(cbSexo);
		
		cbSexo.addItem("MASCULINO");
        cbSexo.addItem("FEMININO");
        
        JLabel lbDataDeNascimento = new JLabel("Data de Nascimento: ");
        lbDataDeNascimento.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbDataDeNascimento.setBounds(215, 129, 117, 14);
        add(lbDataDeNascimento);
        
        JFormattedTextField ftfDtNasc = new JFormattedTextField();
        lbDataDeNascimento.setLabelFor(ftfDtNasc);
        MaskFormatter maskFormatter;
        try {
            maskFormatter = new MaskFormatter("##/##/####"); // Define a máscara para o formato da data
            maskFormatter.install(ftfDtNasc); // Aplica a máscara ao JFormattedTextField
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ftfDtNasc.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        ftfDtNasc.setBounds(336, 126, 134, 20);
        add(ftfDtNasc);
        
        tfTelefone = new JTextField();
        tfTelefone.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfTelefone.setColumns(10);
        tfTelefone.setBounds(272, 198, 198, 20);
        add(tfTelefone);
        
        JLabel lbTelefone = new JLabel("Telefone: ");
        lbTelefone.setLabelFor(tfTelefone);
        lbTelefone.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbTelefone.setBounds(215, 201, 54, 14);
        add(lbTelefone);
        
        JLabel lbCelular = new JLabel("Celular: ");
        lbCelular.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbCelular.setBounds(20, 201, 54, 14);
        add(lbCelular);
        
        tfCelular = new JTextField();
        tfCelular.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfCelular.setColumns(10);
        tfCelular.setBounds(69, 198, 111, 20);
        add(tfCelular);
        
        JLabel lblNewLabel = new JLabel("Informações Básicas");
        lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lblNewLabel.setBounds(20, 67, 267, 14);
        add(lblNewLabel);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 84, 480, 2);
        add(separator);
        
        JLabel lblContato = new JLabel("Contato");
        lblContato.setBackground(SystemColor.textHighlight);
        lblContato.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lblContato.setBounds(20, 168, 267, 14);
        add(lblContato);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(10, 185, 480, 2);
        add(separator_1);
        
        tfEmail = new JTextField();
        tfEmail.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfEmail.setColumns(10);
        tfEmail.setBounds(258, 229, 212, 20);
        add(tfEmail);
        
        JLabel lbEmail = new JLabel("Email: ");
        lbEmail.setLabelFor(tfEmail);
        lbEmail.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbEmail.setBounds(215, 232, 54, 14);
        add(lbEmail);
        
        JLabel lblEndereo = new JLabel("Endereço");
        lblEndereo.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lblEndereo.setBackground(SystemColor.textHighlight);
        lblEndereo.setBounds(20, 270, 267, 14);
        add(lblEndereo);
        
        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setBounds(10, 287, 480, 2);
        add(separator_1_1);
        
        tfLogradouro = new JTextField();
        tfLogradouro.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfLogradouro.setColumns(10);
        tfLogradouro.setBounds(95, 338, 174, 20);
        add(tfLogradouro);
        
        JLabel lbBairro = new JLabel("Bairro: ");
        lbBairro.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbBairro.setBounds(20, 369, 54, 14);
        add(lbBairro);
        
        JLabel lbCep = new JLabel("CEP: ");
        lbCep.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbCep.setBounds(20, 303, 54, 14);
        add(lbCep);
        
        tfCep = new JTextField();
        lbCep.setLabelFor(tfCep);
        tfCep.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfCep.setColumns(10);
        tfCep.setBounds(51, 300, 72, 20);
        add(tfCep);
        
        tfBairro = new JTextField();
        tfBairro.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfBairro.setColumns(10);
        tfBairro.setBounds(63, 366, 206, 20);
        add(tfBairro);
        
        JLabel lbEstado = new JLabel("Estado:");
        lbEstado.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbEstado.setBounds(290, 341, 54, 14);
        add(lbEstado);
        
        JLabel lbLogradouro = new JLabel("Logradouro: ");
        lbLogradouro.setLabelFor(tfLogradouro);
        lbLogradouro.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbLogradouro.setBounds(20, 341, 87, 14);
        add(lbLogradouro);
        
        tfCidade = new JTextField();
        tfCidade.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfCidade.setColumns(10);
        tfCidade.setBounds(63, 394, 206, 20);
        add(tfCidade);
        
        JLabel lbCidade = new JLabel("Cidade: ");
        lbCidade.setLabelFor(tfCidade);
        lbCidade.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbCidade.setBounds(20, 397, 54, 14);
        add(lbCidade);
        
        JComboBox<String> cbEstado = new JComboBox<>(siglas);
        lbEstado.setLabelFor(cbEstado);
        cbEstado.setBounds(336, 336, 47, 22);
        add(cbEstado);
        
        JLabel lbNumero = new JLabel("Número:");
        lbNumero.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbNumero.setBounds(290, 368, 54, 14);
        add(lbNumero);
        
        tfNumero = new JTextField();
        tfNumero.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfNumero.setColumns(10);
        tfNumero.setBounds(346, 365, 37, 20);
        add(tfNumero);
        
        tfComplemento = new JTextField();
        tfComplemento.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfComplemento.setColumns(10);
        tfComplemento.setBounds(105, 422, 164, 20);
        add(tfComplemento);
        
        JLabel lbComplemento = new JLabel("Complemento:");
        lbComplemento.setLabelFor(tfComplemento);
        lbComplemento.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbComplemento.setBounds(20, 425, 87, 14);
        add(lbComplemento);
        
        JLabel lblInformaesMdicas = new JLabel("Informações Médicas");
        lblInformaesMdicas.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lblInformaesMdicas.setBackground(SystemColor.textHighlight);
        lblInformaesMdicas.setBounds(20, 464, 267, 14);
        add(lblInformaesMdicas);
        
        JSeparator separator_1_1_1 = new JSeparator();
        separator_1_1_1.setBounds(10, 481, 480, 2);
        add(separator_1_1_1);
        
	
	}
}
