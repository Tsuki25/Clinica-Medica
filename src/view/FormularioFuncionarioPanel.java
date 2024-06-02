package view;

import control.*;
import model.*;
import model.enums.Sexo;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import javax.swing.text.MaskFormatter;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import static model.utils.DateUtils.getStringFromDate2;

public class FormularioFuncionarioPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField tfCpf;
    private JTextField tfCodFuncionario;
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

    JFormattedTextField ftfDtNasc;

    private JLabel lbCrm;
    private JTextField tfCrm;
    private JLabel lbCip;
    private JTextField tfCip;
    private JPasswordField tfSenha;

    private JComboBox<Sexo> cbSexo;
    private JComboBox<String> cbEstado;

    JButton btnSalvar;
    JButton btnLimpar;
    JButton btnBusca;
    JButton btnEditar;
    JButton btnExcluir;
    JButton btnSalvarEdicao;
    JButton btnCancelarEdicao;
    JButton btnVoltar;

    JRadioButton rdbtnRecepcionista;
    JRadioButton rdbtnEnfermeiro;
    JRadioButton rdbtnMedico;

    String[] siglas = {
            "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR",
            "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"
    };


    public FormularioFuncionarioPanel(JFrame pacienteFrame){
        setBackground(SystemColor.activeCaptionBorder);
        setLayout(null);

        JLabel lbTitle = new JLabel("Funcionários");
        lbTitle.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        lbTitle.setBounds(186, 22, 127, 25);
        add(lbTitle);

        rdbtnRecepcionista = new JRadioButton("Recepcionista");
        rdbtnRecepcionista.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        rdbtnRecepcionista.setBackground(SystemColor.activeCaptionBorder);
        rdbtnRecepcionista.setBounds(95, 54, 109, 23);
        rdbtnRecepcionista.setSelected(true);
        add(rdbtnRecepcionista);

        rdbtnEnfermeiro = new JRadioButton("Enfermeiro");
        rdbtnEnfermeiro.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        rdbtnEnfermeiro.setBackground(SystemColor.activeCaptionBorder);
        rdbtnEnfermeiro.setBounds(206, 54, 91, 23);
        add(rdbtnEnfermeiro);

        rdbtnMedico = new JRadioButton("Médico");
        rdbtnMedico.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        rdbtnMedico.setBackground(SystemColor.activeCaptionBorder);
        rdbtnMedico.setBounds(304, 54, 72, 23);
        add(rdbtnMedico);

        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnRecepcionista);
        group.add(rdbtnEnfermeiro);
        group.add(rdbtnMedico);

        rdbtnRecepcionista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbCrm.setVisible(false);
                tfCrm.setVisible(false);
                lbCip.setVisible(false);
                tfCip.setVisible(false);

            }
        });

        rdbtnEnfermeiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfCrm.setVisible(false);
                tfCip.setVisible(true);
                lbCrm.setVisible(false);
                lbCip.setVisible(true);
            }
        });

        rdbtnMedico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfCrm.setVisible(true);
                tfCip.setVisible(false);
                lbCrm.setVisible(true);
                lbCip.setVisible(false);
            }
        });

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(10, 87, 480, 2);
        add(separator_2);

        JLabel lbCpf = new JLabel("CPF:");
        lbCpf.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbCpf.setBounds(20, 112, 33, 14);
        add(lbCpf);

        tfCpf = new JTextField();
        lbCpf.setLabelFor(tfCpf);
        tfCpf.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfCpf.setBounds(63, 109, 117, 20);
        add(tfCpf);
        tfCpf.setColumns(10);

        JLabel lbNome = new JLabel("Nome: ");
        lbNome.setLabelFor(lbNome);
        lbNome.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbNome.setBounds(20, 187, 39, 14);
        add(lbNome);

        tfNome = new JTextField();
        tfNome.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfNome.setColumns(10);
        tfNome.setBounds(63, 184, 117, 20);
        add(tfNome);

        JLabel lbSobrenome = new JLabel("Sobrenome: ");
        lbSobrenome.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbSobrenome.setBounds(215, 187, 72, 14);
        add(lbSobrenome);

        tfSobrenome = new JTextField();
        tfSobrenome.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfSobrenome.setColumns(10);
        tfSobrenome.setBounds(290, 184, 180, 20);
        add(tfSobrenome);

        JLabel lbSexo = new JLabel("Sexo:");
        lbSexo.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbSexo.setBounds(20, 217, 33, 14);
        add(lbSexo);

        cbSexo = new JComboBox<>(Sexo.values());
        lbSexo.setLabelFor(cbSexo);
        cbSexo.setBounds(63, 212, 117, 22);
        add(cbSexo);

        JLabel lbDataNascimento = new JLabel("Data de Nascimento: ");
        lbDataNascimento.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbDataNascimento.setBounds(215, 216, 117, 14);
        add(lbDataNascimento);

        ftfDtNasc = new JFormattedTextField();
        lbDataNascimento.setLabelFor(ftfDtNasc);
        MaskFormatter maskFormatter;
        try {
            maskFormatter = new MaskFormatter("##/##/####"); // Define a máscara para o formato da data
            maskFormatter.install(ftfDtNasc); // Aplica a máscara ao JFormattedTextField
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ftfDtNasc.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        ftfDtNasc.setBounds(336, 213, 134, 20);
        add(ftfDtNasc);

        tfTelefone = new JTextField();
        tfTelefone.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfTelefone.setColumns(10);
        tfTelefone.setBounds(272, 285, 198, 20);
        add(tfTelefone);

        JLabel lbTelefone = new JLabel("Telefone: ");
        lbTelefone.setLabelFor(tfTelefone);
        lbTelefone.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbTelefone.setBounds(215, 288, 54, 14);
        add(lbTelefone);

        JLabel lbCelular = new JLabel("Celular: ");
        lbCelular.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbCelular.setBounds(20, 288, 54, 14);
        add(lbCelular);

        tfCelular = new JTextField();
        tfCelular.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfCelular.setColumns(10);
        tfCelular.setBounds(69, 285, 111, 20);
        add(tfCelular);

        JLabel lblNewLabel = new JLabel("Informações Básicas");
        lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lblNewLabel.setBounds(20, 154, 267, 14);
        add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 171, 480, 2);
        add(separator);

        JLabel lblContato = new JLabel("Contato");
        lblContato.setBackground(SystemColor.textHighlight);
        lblContato.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lblContato.setBounds(20, 255, 267, 14);
        add(lblContato);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(10, 272, 480, 2);
        add(separator_1);

        tfEmail = new JTextField();
        tfEmail.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfEmail.setColumns(10);
        tfEmail.setBounds(258, 316, 212, 20);
        add(tfEmail);

        JLabel lbEmail = new JLabel("Email: ");
        lbEmail.setLabelFor(tfEmail);
        lbEmail.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbEmail.setBounds(215, 319, 54, 14);
        add(lbEmail);

        JLabel lblEndereo = new JLabel("Endereço");
        lblEndereo.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lblEndereo.setBackground(SystemColor.textHighlight);
        lblEndereo.setBounds(20, 357, 267, 14);
        add(lblEndereo);

        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setBounds(10, 374, 480, 2);
        add(separator_1_1);

        tfLogradouro = new JTextField();
        tfLogradouro.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfLogradouro.setColumns(10);
        tfLogradouro.setBounds(95, 425, 174, 20);
        add(tfLogradouro);

        JLabel lbBairro = new JLabel("Bairro: ");
        lbBairro.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbBairro.setBounds(20, 456, 54, 14);
        add(lbBairro);

        JLabel lbCep = new JLabel("CEP: ");
        lbCep.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbCep.setBounds(20, 390, 54, 14);
        add(lbCep);

        tfCep = new JTextField();
        lbCep.setLabelFor(tfCep);
        tfCep.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfCep.setColumns(10);
        tfCep.setBounds(51, 387, 72, 20);
        add(tfCep);

        tfBairro = new JTextField();
        tfBairro.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfBairro.setColumns(10);
        tfBairro.setBounds(63, 453, 206, 20);
        add(tfBairro);

        JLabel lbEstado = new JLabel("Estado:");
        lbEstado.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbEstado.setBounds(290, 428, 54, 14);
        add(lbEstado);

        JLabel lbLogradouro = new JLabel("Logradouro: ");
        lbLogradouro.setLabelFor(tfLogradouro);
        lbLogradouro.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbLogradouro.setBounds(20, 428, 87, 14);
        add(lbLogradouro);

        tfCidade = new JTextField();
        tfCidade.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfCidade.setColumns(10);
        tfCidade.setBounds(63, 481, 206, 20);
        add(tfCidade);

        JLabel lbCidade = new JLabel("Cidade: ");
        lbCidade.setLabelFor(tfCidade);
        lbCidade.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbCidade.setBounds(20, 484, 54, 14);
        add(lbCidade);

        cbEstado = new JComboBox<>(siglas);
        lbEstado.setLabelFor(cbEstado);
        cbEstado.setBounds(336, 423, 47, 22);
        add(cbEstado);

        JLabel lbNumero = new JLabel("Número:");
        lbNumero.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbNumero.setBounds(290, 455, 54, 14);
        add(lbNumero);

        tfNumero = new JTextField();
        tfNumero.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfNumero.setColumns(10);
        tfNumero.setBounds(346, 452, 37, 20);
        add(tfNumero);

        tfComplemento = new JTextField();
        tfComplemento.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfComplemento.setColumns(10);
        tfComplemento.setBounds(105, 509, 164, 20);
        add(tfComplemento);

        JLabel lbComplemento = new JLabel("Complemento:");
        lbComplemento.setLabelFor(tfComplemento);
        lbComplemento.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbComplemento.setBounds(20, 512, 87, 14);
        add(lbComplemento);

        JLabel lbInfoEspecificaFunc = new JLabel("Informações Especificas");
        lbInfoEspecificaFunc.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbInfoEspecificaFunc.setBackground(SystemColor.textHighlight);
        lbInfoEspecificaFunc.setBounds(20, 558, 267, 14);
        add(lbInfoEspecificaFunc);

        JSeparator separator_1_1_1 = new JSeparator();
        separator_1_1_1.setBounds(10, 575, 480, 2);
        add(separator_1_1_1);

        JLabel lbSenha = new JLabel("Senha: ");
        lbSenha.setLabelFor(tfSenha);
        lbSenha.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbSenha.setBounds(20, 591, 87, 14);
        add(lbSenha);

        tfSenha = new JPasswordField();
        tfSenha.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfSenha.setBounds(60, 588, 174, 20);
        add(tfSenha);

        tfCrm = new JTextField();
        tfCrm.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfCrm.setColumns(10);
        tfCrm.setBounds(63, 623, 167, 20);
        tfCrm.setVisible(false);
        add(tfCrm);

        lbCrm = new JLabel("CRM: ");
        lbCrm.setLabelFor(tfCrm);
        lbCrm.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbCrm.setBounds(20, 627, 54, 14);
        lbCrm.setVisible(false);
        add(lbCrm);

        tfCip = new JTextField();
        tfCip.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfCip.setColumns(10);
        tfCip.setBounds(63, 623, 167, 20);
        tfCip.setVisible(false);
        add(tfCip);

        lbCip = new JLabel("CIP: ");
        lbCip.setLabelFor(tfCip);
        lbCip.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbCip.setBounds(20, 627, 54, 14);
        lbCip.setVisible(false);
        add(lbCip);



        btnSalvar = new JButton();
        btnSalvar.setIcon(new ImageIcon(getClass().getResource("/view/icons/salvar-arquivo.png")));
        btnSalvar.setBackground(SystemColor.windowBorder);
        btnSalvar.setForeground(SystemColor.desktop);
        btnSalvar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Endereco endereco;
                EnderecoController enderecoController = new EnderecoController();
                endereco = enderecoController.controlSalvar(FormularioFuncionarioPanel.this);

                if (rdbtnRecepcionista.isSelected()) {
                    RecepcionistaController recepcionistaController = new RecepcionistaController();
                    recepcionistaController.controlSalvar(FormularioFuncionarioPanel.this, endereco);

                }else if(rdbtnEnfermeiro.isSelected()){
                    EnfermeiroController enfermeiroController = new EnfermeiroController();
                    enfermeiroController.controlSalvar(FormularioFuncionarioPanel.this, endereco);

                }else{
                    MedicoController medicoController = new MedicoController();
                    medicoController.controlSalvar(FormularioFuncionarioPanel.this, endereco);
                }

                JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
            }
        });
        btnSalvar.setBounds(432, 742, 38, 38);
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
        btnLimpar.setBounds(384, 742, 38, 38);
        add(btnLimpar);

        btnBusca = new JButton();
        btnBusca.setIcon(new ImageIcon(getClass().getResource("/view/icons/lupa.png")));
        btnBusca.setForeground(SystemColor.desktop);
        btnBusca.setFont(new Font("Bahnschrift", Font.PLAIN, 5));
        btnBusca.setBackground(SystemColor.windowBorder);
        btnBusca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListaFuncionariosFrame listaFuncionarioFrame = new ListaFuncionariosFrame();
                listaFuncionarioFrame.setSize(1600,900);
                listaFuncionarioFrame.setVisible(true);
                pacienteFrame.setVisible(false);
            }
        });
        btnBusca.setBounds(336, 742, 38, 38);
        add(btnBusca);


    }

    public FormularioFuncionarioPanel(JFrame pacienteFrame, Integer codFuncionario, String crm, String cip){
        this(pacienteFrame);//chama o construtor padrão com o formulário de cadastro do paciente
        Object funcionario = getDadosFuncionario(codFuncionario, crm, cip);

        JLabel lbCodFuncionario = new JLabel("Cod. Funcionario:");
        lbCodFuncionario.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbCodFuncionario.setBounds(200, 112, 120, 14);
        add(lbCodFuncionario);

        tfCodFuncionario = new JTextField();
        lbCodFuncionario.setLabelFor(tfCodFuncionario);
        tfCodFuncionario.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfCodFuncionario.setBounds(330, 109, 50, 20);
        add(tfCodFuncionario);
        tfCodFuncionario.setEditable(false);//NÃO É POSSIVEL EDITAR O CPF
        tfCodFuncionario.setColumns(10);

        // VERIFICA O TIPO DE FUNCIONARIO QUE SERA EDITADO
        if(funcionario instanceof Medico){
            Medico funcionarioAux = (Medico) funcionario;
            preencherCampos(funcionarioAux);// preenche o formulario com os dados do medico
        }else if(funcionario instanceof Enfermeiro){
            Enfermeiro funcionarioAux = (Enfermeiro) funcionario;
            preencherCampos(funcionarioAux);// preenche o formulario com os dados do enfermeiro
        }else{
            Recepcionista funcionarioAux = (Recepcionista) funcionario;
            preencherCampos(funcionarioAux);// preenche o formulario com os dados do recepcionista
        }

        btnLimpar.setVisible(false);//Deixa os botões do outro formulario ocultos
        btnSalvar.setVisible(false);
        rdbtnEnfermeiro.setVisible(false);
        rdbtnMedico.setVisible(false);
        rdbtnRecepcionista.setVisible(false);

        tfCpf.setEditable(false);//NÃO É POSSIVEL EDITAR O CPF
        setStatusEdicaoCampos(false); //Deixa todos os campos editaveis(true) ou não editaveis(false)

        btnEditar = new JButton();
        btnEditar .setIcon(new ImageIcon(getClass().getResource("/view/icons/editar.png")));
        btnEditar .setBackground(SystemColor.windowBorder);
        btnEditar .setForeground(SystemColor.desktop);
        btnEditar .setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnEditar .setBounds(432, 742, 38, 38);
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

                    if(funcionario instanceof Medico){
                        Medico funcionarioAux = (Medico) funcionario;

                        AgendamentoController ac = new AgendamentoController();
                        AgendaController agc = new AgendaController();
                        ac.controlExcluirAgendamentoForFuncionario(funcionarioAux.getCodFuncionario());
                        agc.controlExcluirAgendaForFuncionario(funcionarioAux.getCodFuncionario());

                        MedicoController mc = new MedicoController();
                        mc.controlExcluirMedico(funcionarioAux);

                    }else if(funcionario instanceof Enfermeiro){
                        Enfermeiro funcionarioAux = (Enfermeiro) funcionario;

                        AgendamentoController ac = new AgendamentoController();
                        AgendaController agc = new AgendaController();
                        ac.controlExcluirAgendamentoForFuncionario(funcionarioAux.getCodFuncionario());
                        agc.controlExcluirAgendaForFuncionario(funcionarioAux.getCodFuncionario());

                        EnfermeiroController ec = new EnfermeiroController();
                        ec.controlExcluirEnfermeiro(funcionarioAux);

                    }else{
                        Recepcionista funcionarioAux = (Recepcionista) funcionario;
                        RecepcionistaController rc = new RecepcionistaController();
                        rc.controlExcluirRecepcionista(funcionarioAux);
                    }

                    JOptionPane.showMessageDialog(null, "Funcionario excluido com sucesso");
                    limparCampos();
                }
            }
        });
        btnExcluir.setBounds(384, 742, 38, 38);
        add(btnExcluir);

        btnSalvarEdicao = new JButton(); // APARECE NO LUGAR DO btnEditar
        btnSalvarEdicao.setIcon(new ImageIcon(getClass().getResource("/view/icons/confirmar.png")));
        btnSalvarEdicao.setBackground(SystemColor.windowBorder);
        btnSalvarEdicao.setForeground(SystemColor.desktop);
        btnSalvarEdicao.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnSalvarEdicao.setBounds(432, 742, 38, 38);
        btnSalvarEdicao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(funcionario instanceof Medico){
                    MedicoController mc = new MedicoController();
                    Medico funcionarioAtualizado =  mc.controlAtualizarMedico(FormularioFuncionarioPanel.this);
                    preencherCampos(funcionarioAtualizado);// preenche o formulario com os dados do medico atualizado

                }else if(funcionario instanceof Enfermeiro){
                    EnfermeiroController ec = new EnfermeiroController();
                    Enfermeiro funcionarioAtualizado =  ec.controlAtualizarEnfermeiro(FormularioFuncionarioPanel.this);
                    preencherCampos(funcionarioAtualizado);// preenche o formulario com os dados do medico atualizado

                }else{
                    RecepcionistaController rc = new RecepcionistaController();
                    Recepcionista funcionarioAtualizado =  rc.controlAtualizarRecepcionista(FormularioFuncionarioPanel.this);
                    preencherCampos(funcionarioAtualizado);// preenche o formulario com os dados do medico atualizado
                }

                JOptionPane.showMessageDialog(null, "Funcionario atualizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

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
                if(funcionario instanceof Medico){
                    Medico funcionarioAux = (Medico) funcionario;
                    preencherCampos(funcionarioAux);// preenche o formulario com os dados do medico
                }else if(funcionario instanceof Enfermeiro){
                    Enfermeiro funcionarioAux = (Enfermeiro) funcionario;
                    preencherCampos(funcionarioAux);// preenche o formulario com os dados do enfermeiro
                }else{
                    Recepcionista funcionarioAux = (Recepcionista) funcionario;
                    preencherCampos(funcionarioAux);// preenche o formulario com os dados do recepcionista
                }
                btnCancelarEdicao.setVisible(false);
                btnSalvarEdicao.setVisible(false);
            }
        });
        btnCancelarEdicao.setBounds(384, 742, 38, 38);
        add(btnCancelarEdicao);

        btnVoltar = new JButton();
        btnVoltar.setIcon(new ImageIcon(getClass().getResource("/view/icons/voltar.png")));
        btnVoltar.setBackground(SystemColor.windowBorder);
        btnVoltar.setForeground(SystemColor.desktop);
        btnVoltar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnVoltar.setBounds(288, 742, 38, 38);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame novoFrame = new MainFrame();
                novoFrame.setSize(530, 870);
                novoFrame.setVisible(true);
                pacienteFrame.setVisible(false);
            }
        });
        add(btnVoltar);

    }


    private void preencherCampos(Medico funcionario){
        // SETA OS VALORES DOS CAMPOS DE ACORDO COM O RECUPERADO DO BANCO DE DADOS
        Endereco endereco = funcionario.getEndereco();

        lbCrm.setVisible(true);
        tfCrm.setVisible(true);
        lbCip.setVisible(false);
        tfCip.setVisible(false);

        tfCpf.setText(funcionario.getCpf());
        tfCodFuncionario.setText(funcionario.getCodFuncionario().toString());
        tfNome.setText(funcionario.getNome());
        tfSobrenome.setText(funcionario.getSobrenome());
        cbSexo.setSelectedItem(funcionario.getSexoObj().getDescricao());
        ftfDtNasc.setText(getStringFromDate2(funcionario.getDataNascimento()));
        tfTelefone.setText(funcionario.getTelefone());
        tfCelular.setText(funcionario.getCelular());
        tfEmail.setText(funcionario.getEmail());
        tfLogradouro.setText(endereco.getLogradouro());
        tfCep.setText(endereco.getCep().toString());
        tfBairro.setText(endereco.getBairro());
        tfCidade.setText(endereco.getCidade());
        tfNumero.setText(endereco.getNumero().toString());
        tfComplemento.setText(endereco.getComplemento());
        cbEstado.setSelectedItem(endereco.getEstado());
        tfSenha.setText(funcionario.getSenha());
        tfCrm.setText(funcionario.getCrm());
    }

    private void preencherCampos(Enfermeiro funcionario){
        // SETA OS VALORES DOS CAMPOS DE ACORDO COM O RECUPERADO DO BANCO DE DADOS
        Endereco endereco = funcionario.getEndereco();

        lbCrm.setVisible(false);
        tfCrm.setVisible(false);
        lbCip.setVisible(true);
        tfCip.setVisible(true);

        tfCpf.setText(funcionario.getCpf());
        tfCodFuncionario.setText(funcionario.getCodFuncionario().toString());
        tfNome.setText(funcionario.getNome());
        tfSobrenome.setText(funcionario.getSobrenome());
        cbSexo.setSelectedItem(funcionario.getSexoObj().getDescricao());
        ftfDtNasc.setText(getStringFromDate2(funcionario.getDataNascimento()));
        tfTelefone.setText(funcionario.getTelefone());
        tfCelular.setText(funcionario.getCelular());
        tfEmail.setText(funcionario.getEmail());
        tfLogradouro.setText(endereco.getLogradouro());
        tfCep.setText(endereco.getCep().toString());
        tfBairro.setText(endereco.getBairro());
        tfCidade.setText(endereco.getCidade());
        tfNumero.setText(endereco.getNumero().toString());
        tfComplemento.setText(endereco.getComplemento());
        cbEstado.setSelectedItem(endereco.getEstado());
        tfSenha.setText(funcionario.getSenha());
        tfCip.setText(funcionario.getCip());
    }

    private void preencherCampos(Recepcionista funcionario){
        // SETA OS VALORES DOS CAMPOS DE ACORDO COM O RECUPERADO DO BANCO DE DADOS
        Endereco endereco = funcionario.getEndereco();

        lbCrm.setVisible(false);
        tfCrm.setVisible(false);
        lbCip.setVisible(false);
        tfCip.setVisible(false);

        tfCpf.setText(funcionario.getCpf());
        tfCodFuncionario.setText(funcionario.getCodFuncionario().toString());
        tfNome.setText(funcionario.getNome());
        tfSobrenome.setText(funcionario.getSobrenome());
        cbSexo.setSelectedItem(funcionario.getSexoObj().getDescricao());
        ftfDtNasc.setText(getStringFromDate2(funcionario.getDataNascimento()));
        tfTelefone.setText(funcionario.getTelefone());
        tfCelular.setText(funcionario.getCelular());
        tfEmail.setText(funcionario.getEmail());
        tfLogradouro.setText(endereco.getLogradouro());
        tfCep.setText(endereco.getCep().toString());
        tfBairro.setText(endereco.getBairro());
        tfCidade.setText(endereco.getCidade());
        tfNumero.setText(endereco.getNumero().toString());
        tfComplemento.setText(endereco.getComplemento());
        cbEstado.setSelectedItem(endereco.getEstado());
        tfSenha.setText(funcionario.getSenha());
    }

    private void setStatusEdicaoCampos(Boolean status){
        Color borderEditavel = new Color(66, 64, 64);
        Color borderIneditavel = new Color(96, 8, 166);
        Color bgEditavel = new Color(238, 240, 242);
        Color bgIneditavel = new Color(226, 207, 241);

        if(status) alterCoresCampos(borderEditavel, bgEditavel);
        else alterCoresCampos(borderIneditavel, bgIneditavel);


        tfNome.setEditable(status);
        tfSobrenome.setEditable(status);
        cbSexo.setEnabled(status);
        ftfDtNasc.setEditable(status);
        tfTelefone.setEditable(status);
        tfCelular.setEditable(status);
        tfEmail.setEditable(status);
        tfLogradouro.setEditable(status);
        tfCep.setEditable(status);
        tfBairro.setEditable(status);
        tfCidade.setEditable(status);
        tfNumero.setEditable(status);
        tfComplemento.setEditable(status);
        cbEstado.setEnabled(status);
        tfCrm.setEditable(status);
        tfCip.setEditable(status);
        tfSenha.setEditable(status);
    }

    private void limparCampos() {
        tfCpf.setText("");
        tfNome.setText("");
        tfSobrenome.setText("");
        ftfDtNasc.setText("");
        tfTelefone.setText("");
        tfCelular.setText("");
        tfEmail.setText("");
        tfLogradouro.setText("");
        tfCep.setText("");
        tfBairro.setText("");
        tfCidade.setText("");
        tfNumero.setText("");
        tfComplemento.setText("");
        tfCrm.setText("");
        tfCip.setText("");
        tfSenha.setText("");
    }

    private Object getDadosFuncionario(Integer codFuncionario, String crm, String cip) {
        if(!crm.isEmpty()){// CRM PREENCHIDO
            MedicoController mc = new MedicoController();
            return mc.controlBuscarMedicoForId(codFuncionario);

        }else if(!cip.isEmpty()){//CRI PREENCHIDO
            EnfermeiroController ec = new EnfermeiroController();
            return ec.controlBuscarEnfermeiroForId(codFuncionario);

        }else{
            RecepcionistaController rc = new RecepcionistaController();
            return rc.controlBuscarRecepcionistaForId(codFuncionario);
        }

    }


    private void alterCoresCampos(Color corBorda, Color corFundo){
        tfNome.setBorder(BorderFactory.createLineBorder(corBorda));
        tfNome.setBackground(corFundo);

        tfSobrenome.setBorder(BorderFactory.createLineBorder(corBorda));
        tfSobrenome.setBackground(corFundo);

        cbSexo.setBackground(corFundo);
        ((JLabel) cbSexo.getRenderer()).setOpaque(true); // Torna o fundo do item selecionado visível
        cbSexo.setBorder(BorderFactory.createLineBorder(corBorda));
        cbSexo.setForeground(Color.BLACK);

        ftfDtNasc.setBorder(BorderFactory.createLineBorder(corBorda));
        ftfDtNasc.setBackground(corFundo);

        tfTelefone.setBorder(BorderFactory.createLineBorder(corBorda));
        tfTelefone.setBackground(corFundo);

        tfCelular.setBorder(BorderFactory.createLineBorder(corBorda));
        tfCelular.setBackground(corFundo);

        tfEmail.setBorder(BorderFactory.createLineBorder(corBorda));
        tfEmail.setBackground(corFundo);

        tfLogradouro.setBorder(BorderFactory.createLineBorder(corBorda));
        tfLogradouro.setBackground(corFundo);

        tfCep.setBorder(BorderFactory.createLineBorder(corBorda));
        tfCep.setBackground(corFundo);

        tfBairro.setBorder(BorderFactory.createLineBorder(corBorda));
        tfBairro.setBackground(corFundo);

        tfCidade.setBorder(BorderFactory.createLineBorder(corBorda));
        tfCidade.setBackground(corFundo);

        tfNumero.setBorder(BorderFactory.createLineBorder(corBorda));
        tfNumero.setBackground(corFundo);

        tfComplemento.setBorder(BorderFactory.createLineBorder(corBorda));
        tfComplemento.setBackground(corFundo);

        cbEstado.setBackground(corFundo);
        ((JLabel) cbEstado.getRenderer()).setOpaque(true); // Torna o fundo do item selecionado visível
        cbEstado.setBorder(BorderFactory.createLineBorder(corBorda));
        cbEstado.setForeground(Color.BLACK);

        tfCrm.setBorder(BorderFactory.createLineBorder(corBorda));
        tfCrm.setBackground(corFundo);

        tfCip.setBorder(BorderFactory.createLineBorder(corBorda));
        tfCip.setBackground(corFundo);

        tfSenha.setBorder(BorderFactory.createLineBorder(corBorda));
        tfSenha.setBackground(corFundo);
    }

    public JTextField getTfCpf() {
        return tfCpf;
    }

    public void setTfCpf(JTextField tfCpf) {
        this.tfCpf = tfCpf;
    }

    public JTextField getTfNome() {
        return tfNome;
    }

    public void setTfNome(JTextField tfNome) {
        this.tfNome = tfNome;
    }

    public JTextField getTfSobrenome() {
        return tfSobrenome;
    }

    public void setTfSobrenome(JTextField tfSobrenome) {
        this.tfSobrenome = tfSobrenome;
    }

    public JTextField getTfTelefone() {
        return tfTelefone;
    }

    public void setTfTelefone(JTextField tfTelefone) {
        this.tfTelefone = tfTelefone;
    }

    public JTextField getTfCelular() {
        return tfCelular;
    }

    public void setTfCelular(JTextField tfCelular) {
        this.tfCelular = tfCelular;
    }

    public JTextField getTfEmail() {
        return tfEmail;
    }

    public void setTfEmail(JTextField tfEmail) {
        this.tfEmail = tfEmail;
    }

    public JTextField getTfLogradouro() {
        return tfLogradouro;
    }

    public void setTfLogradouro(JTextField tfLogradouro) {
        this.tfLogradouro = tfLogradouro;
    }

    public JTextField getTfCep() {
        return tfCep;
    }

    public void setTfCep(JTextField tfCep) {
        this.tfCep = tfCep;
    }

    public JTextField getTfBairro() {
        return tfBairro;
    }

    public void setTfBairro(JTextField tfBairro) {
        this.tfBairro = tfBairro;
    }

    public JTextField getTfCidade() {
        return tfCidade;
    }

    public void setTfCidade(JTextField tfCidade) {
        this.tfCidade = tfCidade;
    }

    public JTextField getTfNumero() {
        return tfNumero;
    }

    public void setTfNumero(JTextField tfNumero) {
        this.tfNumero = tfNumero;
    }

    public JTextField getTfComplemento() {
        return tfComplemento;
    }

    public void setTfComplemento(JTextField tfComplemento) {
        this.tfComplemento = tfComplemento;
    }

    public Sexo getCbSexo() {
        return (Sexo) cbSexo.getSelectedItem();
    }

    public void setCbSexo(Sexo sexo) {
        cbSexo.setSelectedItem(sexo);
    }

    public JComboBox<String> getCbEstado() {
        return cbEstado;
    }

    public void setCbEstado(JComboBox<String> cbEstado) {
        this.cbEstado = cbEstado;
    }

    public JFormattedTextField getFtfDtNasc() {
        return ftfDtNasc;
    }

    public void setFtfDtNasc(JFormattedTextField ftfDtNasc) {
        this.ftfDtNasc = ftfDtNasc;
    }

    public JTextField getTfCrm() {
        return tfCrm;
    }

    public void setTfCrm(JTextField tfCrm) {
        this.tfCrm = tfCrm;
    }

    public JTextField getTfCip() {
        return tfCip;
    }

    public void setTfCip(JTextField tfCip) {
        this.tfCip = tfCip;
    }

    public JPasswordField getTfSenha() {
        return tfSenha;
    }

    public void setTfSenha(JPasswordField tfSenha) {
        this.tfSenha = tfSenha;
    }

}