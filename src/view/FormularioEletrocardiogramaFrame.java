package view;

import control.EletrocardiogramaController;
import control.EntregaController;
import model.enums.TipoDiagnosticoPadrao;
import model.exames.Eletrocardiograma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static control.PacienteController.getNomePacienteForId;
import static dao.FuncionarioDao.getNomeFuncionarioForId;
import static java.util.Objects.isNull;

public class FormularioEletrocardiogramaFrame extends JFrame {
    private JTextField tfCodFuncionario, tfNomeFuncionario;
    private JTextField tfAltura;
    private JTextField tfFuncaoCardiaca;
    private JTextField tfRitmoCardiaco;
    private JComboBox<TipoDiagnosticoPadrao> cbDiagnostico;
    private JTextField tfConclusoes;
    private JTextField tfPeso;
    private JTextField tfConvenio;
    private JTextField tfCodPaciente, tfNomePaciente;
    private JTextField tfCodExame;
    private JLabel lbCodExame;
    private JButton btnSalvar;
    private JButton btnLimpar;
    private JButton btnBusca;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnSalvarEdicao;
    private JButton btnCancelarEdicao;
    private JButton btnVoltar;
    private JButton btnResultado;

    public FormularioEletrocardiogramaFrame() {
        setBackground(SystemColor.activeCaptionBorder);
        setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(SystemColor.activeCaptionBorder);
        setContentPane(mainPanel);

        JLabel tfEletro = new JLabel("Eletrocardiograma");
        tfEletro.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        tfEletro.setBounds(176, 22, 180, 25);
        add(tfEletro);

        tfConclusoes = new JTextField();
        tfConclusoes.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfConclusoes.setColumns(10);
        tfConclusoes.setBounds(20, 464, 459, 135);
        add(tfConclusoes);

        tfPeso = new JTextField();
        tfPeso.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfPeso.setColumns(10);
        tfPeso.setBounds(63, 212, 60, 20);
        add(tfPeso);

        JLabel lbConvenio = new JLabel("Convênio:");
        lbConvenio.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbConvenio.setBounds(20, 245, 65, 14);
        add(lbConvenio);

        tfConvenio = new JTextField();
        lbConvenio.setLabelFor(tfConvenio);
        tfConvenio.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfConvenio.setColumns(10);
        tfConvenio.setBounds(83, 242, 111, 20);
        add(tfConvenio);

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

        JLabel lbAltura = new JLabel("Altura: ");
        lbAltura.setLabelFor(tfAltura);
        lbAltura.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbAltura.setBounds(20, 187, 50, 14);
        add(lbAltura);

        tfAltura = new JTextField();
        tfAltura.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfAltura.setColumns(10);
        tfAltura.setBounds(63, 184, 60, 20);
        add(tfAltura);

        JLabel lbPeso = new JLabel("Peso:");
        lbPeso.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbPeso.setBounds(20, 217, 33, 14);
        add(lbPeso);

        JLabel lblNewLabel = new JLabel("Informações Básicas");
        lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lblNewLabel.setBounds(20, 125, 267, 14);
        add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 142, 490, 2);
        add(separator);

        JLabel lblResultados = new JLabel("Resultados");
        lblResultados.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lblResultados.setBackground(SystemColor.textHighlight);
        lblResultados.setBounds(20, 290, 267, 14);
        add(lblResultados);

        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setBounds(10, 307, 490, 2);
        add(separator_1_1);

        tfFuncaoCardiaca = new JTextField();
        tfFuncaoCardiaca.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfFuncaoCardiaca.setColumns(10);
        tfFuncaoCardiaca.setBounds(122, 353, 65, 20);
        add(tfFuncaoCardiaca);

        JLabel lbRitmoCardiaco = new JLabel("Ritmo Cardiaco: ");
        lbRitmoCardiaco.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbRitmoCardiaco.setBounds(20, 325, 103, 14);
        add(lbRitmoCardiaco);

        tfRitmoCardiaco = new JTextField();
        lbRitmoCardiaco.setLabelFor(tfRitmoCardiaco);
        tfRitmoCardiaco.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfRitmoCardiaco.setColumns(10);
        tfRitmoCardiaco.setBounds(118, 322, 69, 20);
        add(tfRitmoCardiaco);

        JLabel lbDiagnostico = new JLabel("Diagnostico:");
        lbDiagnostico.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbDiagnostico.setBounds(20, 389, 77, 14);
        add(lbDiagnostico);

        JLabel lbFuncaoCardiaca = new JLabel("Função Cardiaca: ");
        lbFuncaoCardiaca.setLabelFor(tfFuncaoCardiaca);
        lbFuncaoCardiaca.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbFuncaoCardiaca.setBounds(20, 356, 117, 14);
        add(lbFuncaoCardiaca);

        cbDiagnostico = new JComboBox<>(TipoDiagnosticoPadrao.values());
        lbDiagnostico.setLabelFor(cbDiagnostico);
        cbDiagnostico.setBounds(107, 384, 150, 22);
        add(cbDiagnostico);

        JLabel lbInfoConclusoes = new JLabel("Conclusões");
        lbInfoConclusoes.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbInfoConclusoes.setBackground(SystemColor.textHighlight);
        lbInfoConclusoes.setBounds(20, 434, 267, 14);
        add(lbInfoConclusoes);

        JSeparator separator_1_1_1 = new JSeparator();
        separator_1_1_1.setBounds(10, 451, 490, 2);
        add(separator_1_1_1);

        btnSalvar = new JButton();
        btnSalvar.setIcon(new ImageIcon(getClass().getResource("/view/icons/salvar-arquivo.png")));
        btnSalvar.setBackground(SystemColor.windowBorder);
        btnSalvar.setForeground(SystemColor.desktop);
        btnSalvar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EletrocardiogramaController ec = new EletrocardiogramaController();
                ec.controlSalvar(FormularioEletrocardiogramaFrame.this);

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
                ListaExamesFrame listaExamesFrame = new ListaExamesFrame();
                listaExamesFrame.setSize(1600, 900);
                listaExamesFrame.setVisible(true);
                FormularioEletrocardiogramaFrame.this.setVisible(false);
            }
        });
        btnBusca.setBounds(336, 775, 38, 38);
        add(btnBusca);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(10, 58, 490, 2);
        add(separator_2);
    }


   public FormularioEletrocardiogramaFrame(Integer codExame){
        this();//chama o construtor padrão
        Eletrocardiograma eletrocardiograma = getDadosExame(codExame);

        btnLimpar.setVisible(false);//Deixa os botões do outro formulario ocultos
        btnSalvar.setVisible(false);

       lbCodExame = new JLabel("Código Exame:");
       lbCodExame.setFont(new Font("Bahnschrift", Font.BOLD, 14));
       lbCodExame.setBounds(20, 780, 110, 20);
       add(lbCodExame);

       tfCodExame = new JTextField();
       lbCodExame.setLabelFor(tfCodExame);
       tfCodExame.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
       tfCodExame.setColumns(10);
       tfCodExame.setBounds(125, 778, 75, 20);
       tfCodExame.setBorder(BorderFactory.createLineBorder(new Color(96, 8, 166)));
       tfCodExame.setBackground(new Color(226, 207, 241));
       tfCodExame.setEditable(false);
       add(tfCodExame);

        preencherCampos(eletrocardiograma);// preenche o formulario com os dados
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
                    EntregaController ecc = new EntregaController();
                    ecc.controlExcluirEntregaForExame(eletrocardiograma.getCodExame());

                    EletrocardiogramaController ec = new EletrocardiogramaController();
                    ec.controlExcluirEletrocardiograma(eletrocardiograma);
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
                EletrocardiogramaController ec = new EletrocardiogramaController();
                Eletrocardiograma eletrocardiogramaAtualizado =  ec.controlAtualizarEletrocardiograma(FormularioEletrocardiogramaFrame.this, eletrocardiograma);

                if(!isNull(eletrocardiogramaAtualizado)){
                    preencherCampos(eletrocardiogramaAtualizado);
                    JOptionPane.showMessageDialog(null, "Exame atualizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
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
                preencherCampos(eletrocardiograma);
                btnCancelarEdicao.setVisible(false);
                btnSalvarEdicao.setVisible(false);
            }
        });
        btnCancelarEdicao.setBounds(384, 775, 38, 38);
        add(btnCancelarEdicao);

        btnResultado = new JButton();
        btnResultado.setIcon(new ImageIcon(getClass().getResource("/view/icons/resultados.png")));
        btnResultado.setBackground(SystemColor.windowBorder);
        btnResultado.setForeground(SystemColor.desktop);
        btnResultado.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnResultado.setBounds(288, 775, 38, 38);
        btnResultado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FormularioEntregasFrame novoFrame = new FormularioEntregasFrame(eletrocardiograma);
                novoFrame.setSize(530, 870);
                novoFrame.setVisible(true);
                FormularioEletrocardiogramaFrame.this.setVisible(false);
            }
        });
        add(btnResultado);

        btnVoltar = new JButton();
        btnVoltar.setIcon(new ImageIcon(getClass().getResource("/view/icons/voltar.png")));
        btnVoltar.setBackground(SystemColor.windowBorder);
        btnVoltar.setForeground(SystemColor.desktop);
        btnVoltar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnVoltar.setBounds(240, 775, 38, 38);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame novoFrame = new MainFrame();
                novoFrame.setSize(530, 870);
                novoFrame.setVisible(true);
                FormularioEletrocardiogramaFrame.this.setVisible(false);
            }
        });
        add(btnVoltar);

    }

    private void preencherCampos(Eletrocardiograma eletro){
        // SETA OS VALORES DOS CAMPOS DE ACORDO COM O RECUPERADO DO BANCO DE DADOS
        tfCodExame.setText(eletro.getCodExame().toString());
        tfCodPaciente.setText(eletro.getCodPaciente().toString());
        tfNomePaciente.setText(getNomePacienteForId(Integer.parseInt(tfCodPaciente.getText())));
        tfPeso.setText(eletro.getPeso().toString());
        tfAltura.setText(eletro.getAltura().toString());
        tfConvenio.setText(eletro.getConvenio().toString());
        tfRitmoCardiaco.setText(eletro.getRitmoCardiaco());
        tfFuncaoCardiaca.setText(eletro.getFuncaoCardiaca().toString());
        tfConclusoes.setText(eletro.getConclusoes());
        tfCodFuncionario.setText(eletro.getCodFuncionario().toString());
        tfNomeFuncionario.setText(getNomeFuncionarioForId(Integer.parseInt(tfCodFuncionario.getText())));

        cbDiagnostico.setSelectedItem(eletro.getDiagnostico());
    }

    private void setStatusEdicaoCampos(Boolean status){
        Color borderEditavel = new Color(66, 64, 64);
        Color borderIneditavel = new Color(96, 8, 166);
        Color bgEditavel = new Color(238, 240, 242);
        Color bgIneditavel = new Color(226, 207, 241);

        if(status) alterCoresCampos(borderEditavel, bgEditavel);
        else alterCoresCampos(borderIneditavel, bgIneditavel);

        tfCodPaciente.setEditable(status);
        tfPeso.setEditable(status);
        tfAltura.setEditable(status);
        tfConvenio.setEditable(status);
        tfRitmoCardiaco.setEditable(status);
        tfFuncaoCardiaca.setEditable(status);
        tfConclusoes.setEditable(status);
        tfCodFuncionario.setEditable(status);

        cbDiagnostico.setEnabled(status);
    }

    private Eletrocardiograma getDadosExame(Integer codExame) {
        EletrocardiogramaController ec = new EletrocardiogramaController();
        return ec.controlBuscarEletrocardiogramaForId(codExame);
    }

    private void alterCoresCampos(Color corBorda, Color corFundo){

        cbDiagnostico.setBackground(corFundo);
        ((JLabel) cbDiagnostico.getRenderer()).setOpaque(true); // Torna o fundo do item selecionado visível
        cbDiagnostico.setBorder(BorderFactory.createLineBorder(corBorda));
        cbDiagnostico.setForeground(Color.BLACK);

        tfCodPaciente.setBorder(BorderFactory.createLineBorder(corBorda));
        tfCodPaciente.setBackground(corFundo);

        tfCodFuncionario.setBorder(BorderFactory.createLineBorder(corBorda));
        tfCodFuncionario.setBackground(corFundo);

        tfPeso.setBorder(BorderFactory.createLineBorder(corBorda));
        tfPeso.setBackground(corFundo);

        tfAltura.setBorder(BorderFactory.createLineBorder(corBorda));
        tfAltura.setBackground(corFundo);

        tfConvenio.setBorder(BorderFactory.createLineBorder(corBorda));
        tfConvenio.setBackground(corFundo);

        tfRitmoCardiaco.setBorder(BorderFactory.createLineBorder(corBorda));
        tfRitmoCardiaco.setBackground(corFundo);

        tfFuncaoCardiaca.setBorder(BorderFactory.createLineBorder(corBorda));
        tfFuncaoCardiaca.setBackground(corFundo);

        tfConclusoes.setBorder(BorderFactory.createLineBorder(corBorda));
        tfConclusoes.setBackground(corFundo);
    }

    private void limparCampos() {
        tfCodPaciente.setText("");
        tfNomePaciente.setText("");
        tfCodFuncionario.setText("");
        tfNomeFuncionario.setText("");
        tfPeso.setText("");
        tfAltura.setText("");
        tfConvenio.setText("");
        tfRitmoCardiaco.setText("");
        tfFuncaoCardiaca.setText("");
        tfConclusoes.setText("");
        cbDiagnostico.setSelectedIndex(0);
    }

    public JTextField getTfCodFuncionario() {
        return tfCodFuncionario;
    }

    public void setTfCodFuncionario(JTextField tfCodFuncionario) {
        this.tfCodFuncionario = tfCodFuncionario;
    }

    public JTextField getTfAltura() {
        return tfAltura;
    }

    public void setTfAltura(JTextField tfNome) {
        this.tfAltura = tfNome;
    }

    public JTextField getTfFuncaoCardiaca() {
        return tfFuncaoCardiaca;
    }

    public void setTfFuncaoCardiaca(JTextField tfFuncaoCardiaca) {
        this.tfFuncaoCardiaca = tfFuncaoCardiaca;
    }

    public JTextField getTfRitmoCardiaco() {
        return tfRitmoCardiaco;
    }

    public void setTfRitmoCardiaco(JTextField tfRitmoCardiaco) {
        this.tfRitmoCardiaco = tfRitmoCardiaco;
    }

    public TipoDiagnosticoPadrao getCbDiagnostico() {
        return (TipoDiagnosticoPadrao) cbDiagnostico.getSelectedItem();
    }

    public void setCbDiagnostico(JComboBox<TipoDiagnosticoPadrao> cbDiagnostico) {
        this.cbDiagnostico = cbDiagnostico;
    }

    public JTextField getTfConclusoes() {
        return tfConclusoes;
    }

    public void setTfConclusoes(JTextField tfConclusoes) {
        this.tfConclusoes = tfConclusoes;
    }

    public JTextField getTfPeso() {
        return tfPeso;
    }

    public void setTfPeso(JTextField tfPeso) {
        this.tfPeso = tfPeso;
    }

    public JTextField getTfConvenio() {
        return tfConvenio;
    }

    public void setTfConvenio(JTextField tfConvenio) {
        this.tfConvenio = tfConvenio;
    }

    public JTextField getTfCodPaciente() {
        return tfCodPaciente;
    }

    public void setTfCodPaciente(JTextField tfCodPaciente) {
        this.tfCodPaciente = tfCodPaciente;
    }
}
