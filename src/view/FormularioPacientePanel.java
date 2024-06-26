package view;

import control.AgendamentoController;
import control.EnderecoController;
import control.PacienteController;
import model.Endereco;
import model.Paciente;
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

public class FormularioPacientePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField tfCpf;
    private JTextField tfCodPaciente;
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
    private JTextField tfAlergia;
    private JTextField tfMedicamentosUtilizados;
    private JTextField tfAnotacoes;
    private JTextField tfHistorico;
    JFormattedTextField ftfDtNasc;
    private JComboBox<Sexo> cbSexo;
    private JComboBox<String> cbEstado;

    // BOTOES
    JButton btnSalvar;
    JButton btnLimpar;
    JButton btnBusca;
    JButton btnEditar;
    JButton btnExcluir;
    JButton btnSalvarEdicao;
    JButton btnCancelarEdicao;
    JButton btnVoltar;

    String[] siglas = {
            "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR",
            "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"
    };

    public FormularioPacientePanel(JFrame pacienteFrame) {
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

        cbSexo = new JComboBox<>(Sexo.values());
        lbSexo.setLabelFor(cbSexo);
        cbSexo.setBounds(63, 125, 117, 22);
        add(cbSexo);

        JLabel lbDataNascimento = new JLabel("Data de Nascimento: ");
        lbDataNascimento.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbDataNascimento.setBounds(215, 129, 117, 14);
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

        cbEstado = new JComboBox<>(siglas);
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

        JLabel lblInformaesMedicas = new JLabel("Informações Médicas");
        lblInformaesMedicas.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lblInformaesMedicas.setBackground(SystemColor.textHighlight);
        lblInformaesMedicas.setBounds(20, 471, 267, 14);
        add(lblInformaesMedicas);

        JSeparator separator_1_1_1 = new JSeparator();
        separator_1_1_1.setBounds(10, 488, 480, 2);
        add(separator_1_1_1);

        JLabel lbAlergias = new JLabel("Alergias:");
        lbAlergias.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbAlergias.setBounds(20, 510, 54, 14);
        add(lbAlergias);

        tfAlergia = new JTextField();
        lbAlergias.setLabelFor(tfAlergia);
        tfAlergia.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfAlergia.setColumns(10);
        tfAlergia.setBounds(74, 507, 396, 22);
        add(tfAlergia);

        JLabel lbMedicamentoUtilizados = new JLabel("Medicamento utilizados:");
        lbMedicamentoUtilizados.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbMedicamentoUtilizados.setBounds(20, 541, 141, 14);
        add(lbMedicamentoUtilizados);

        tfMedicamentosUtilizados = new JTextField();
        lbMedicamentoUtilizados.setLabelFor(tfMedicamentosUtilizados);
        tfMedicamentosUtilizados.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfMedicamentosUtilizados.setColumns(10);
        tfMedicamentosUtilizados.setBounds(160, 540, 310, 40);
        add(tfMedicamentosUtilizados);

        JLabel lbHistrico = new JLabel("Histórico:");
        lbHistrico.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbHistrico.setBounds(20, 592, 141, 14);
        add(lbHistrico);

        JLabel lbAnotacoes = new JLabel("Anotações:");
        lbAnotacoes.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbAnotacoes.setBounds(20, 671, 141, 14);
        add(lbAnotacoes);

        tfHistorico = new JTextField();
        lbHistrico.setLabelFor(tfHistorico);
        tfHistorico.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfHistorico.setBounds(20, 605, 450, 50);
        add(tfHistorico);

        tfAnotacoes = new JTextField();
        tfAnotacoes.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfAnotacoes.setBounds(20, 684, 450, 50);
        add(tfAnotacoes);

        btnSalvar = new JButton();
        btnSalvar.setIcon(new ImageIcon(getClass().getResource("/view/icons/salvar-arquivo.png")));
        btnSalvar.setBackground(SystemColor.windowBorder);
        btnSalvar.setForeground(SystemColor.desktop);
        btnSalvar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Endereco endereco;
                EnderecoController enderecoController = new EnderecoController();
                endereco = enderecoController.controlSalvar(FormularioPacientePanel.this);
                PacienteController pacienteController = new PacienteController();
                pacienteController.controlSalvar(FormularioPacientePanel.this, endereco);

                JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
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
                ListaPacientesFrame listaPacienteFrame = new ListaPacientesFrame();
                listaPacienteFrame.setSize(1600,900);
                listaPacienteFrame.setVisible(true);
                pacienteFrame.setVisible(false);
            }
        });
        btnBusca.setBounds(336, 742, 38, 38);
        add(btnBusca);
    }

    public FormularioPacientePanel(JFrame pacienteFrame, Integer codPaciente){
        this(pacienteFrame);//chama o construtor padrão com o formulário de cadastro do paciente
        Paciente paciente = getDadosPaciente(codPaciente);

        JLabel lbCodPaciente = new JLabel("Cod. Paciente:");
        lbCodPaciente.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbCodPaciente.setBounds(200, 25, 100, 14);
        add(lbCodPaciente);

        tfCodPaciente = new JTextField();
        lbCodPaciente.setLabelFor(tfCodPaciente);
        tfCodPaciente.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfCodPaciente.setBounds(310, 22, 50, 20);
        add(tfCodPaciente);
        tfCodPaciente.setEditable(false);
        tfCodPaciente.setColumns(10);

        btnLimpar.setVisible(false);//Deixa os botões do outro formulario ocultos
        btnSalvar.setVisible(false);

        preencherCampos(paciente);// preenche o formulario com os dados do paciente

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
                    AgendamentoController ac = new AgendamentoController();
                    ac.controlExcluirAgendamentoForPaciente(paciente.getCodPaciente());

                    PacienteController pc = new PacienteController();
                    pc.controlExcluirPaciente(paciente);
                    JOptionPane.showMessageDialog(null, "Paciente excluido com sucesso");
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
                PacienteController pc = new PacienteController();
                Paciente pacienteAtualizado =  pc.controlAtualizarPaciente(FormularioPacientePanel.this, paciente);
                preencherCampos(pacienteAtualizado);
                JOptionPane.showMessageDialog(null, "Paciente atualizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

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
                preencherCampos(paciente);
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

    private void preencherCampos(Paciente paciente){
        // SETA OS VALORES DOS CAMPOS DE ACORDO COM O RECUPERADO DO BANCO DE DADOS
        Endereco endereco = paciente.getEndereco();

        tfCpf.setText(paciente.getCpf());
        tfCodPaciente.setText(paciente.getCodPaciente().toString());
        tfNome.setText(paciente.getNome());
        tfSobrenome.setText(paciente.getSobrenome());
        cbSexo.setSelectedItem(paciente.getSexoObj().getDescricao());
        ftfDtNasc.setText(getStringFromDate2(paciente.getDataNascimento()));
        tfTelefone.setText(paciente.getTelefone());
        tfCelular.setText(paciente.getCelular());
        tfEmail.setText(paciente.getEmail());
        tfLogradouro.setText(endereco.getLogradouro());
        tfCep.setText(endereco.getCep().toString());
        tfBairro.setText(endereco.getBairro());
        tfCidade.setText(endereco.getCidade());
        tfNumero.setText(endereco.getNumero().toString());
        tfComplemento.setText(endereco.getComplemento());
        cbEstado.setSelectedItem(endereco.getEstado());
        tfAlergia.setText(paciente.getAlergias());
        tfMedicamentosUtilizados.setText(paciente.getMedicamentosUtilizados());
        tfHistorico.setText(paciente.getHistorico());
        tfAnotacoes.setText(paciente.getAnotacoes());
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
        tfAlergia.setEditable(status);
        tfMedicamentosUtilizados.setEditable(status);
        tfHistorico.setEditable(status);
        tfAnotacoes.setEditable(status);
    }

    private void limparCampos() {
        tfCpf.setText("");
        tfNome.setText("");
        tfSobrenome.setText("");
        tfTelefone.setText("");
        tfCelular.setText("");
        tfEmail.setText("");
        tfLogradouro.setText("");
        tfCep.setText("");
        tfBairro.setText("");
        tfCidade.setText("");
        tfNumero.setText("");
        tfComplemento.setText("");
        tfAlergia.setText("");
        tfMedicamentosUtilizados.setText("");
        tfAnotacoes.setText("");
        tfHistorico.setText("");
        ftfDtNasc.setText("");
        cbEstado.setSelectedIndex(0);
        cbSexo.setSelectedIndex(0);
    }

    private Paciente getDadosPaciente(Integer codPaciente) {
        PacienteController pc = new PacienteController();
        return pc.controlBuscarPacienteForId(codPaciente);
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

        tfAlergia.setBorder(BorderFactory.createLineBorder(corBorda));
        tfAlergia.setBackground(corFundo);

        tfMedicamentosUtilizados.setBorder(BorderFactory.createLineBorder(corBorda));
        tfMedicamentosUtilizados.setBackground(corFundo);

        tfHistorico.setBorder(BorderFactory.createLineBorder(corBorda));
        tfHistorico.setBackground(corFundo);

        tfAnotacoes.setBorder(BorderFactory.createLineBorder(corBorda));
        tfAnotacoes.setBackground(corFundo);
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

    public JTextField getTfAlergia() {
        return tfAlergia;
    }

    public void setTfAlergia(JTextField tfAlergia) {
        this.tfAlergia = tfAlergia;
    }

    public JTextField getTfMedicamentosUtilizados() {
        return tfMedicamentosUtilizados;
    }

    public void setTfMedicamentosUtilizados(JTextField tfMedicamentosUtilizados) {
        this.tfMedicamentosUtilizados = tfMedicamentosUtilizados;
    }

    public JTextField getTfAnotacoes() {
        return tfAnotacoes;
    }

    public void setTfAnotacoes(JTextField tfAnotacoes) {
        this.tfAnotacoes = tfAnotacoes;
    }

    public JTextField getTfHistorico() {
        return tfHistorico;
    }

    public void setTfHistorico(JTextField tfHistorico) {
        this.tfHistorico = tfHistorico;
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

    public JTextField getTfCodPaciente() {
        return tfCodPaciente;
    }

    public void setTfCodPaciente(JTextField tfCodPaciente) {
        this.tfCodPaciente = tfCodPaciente;
    }
}