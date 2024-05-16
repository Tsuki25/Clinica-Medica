package view;

import control.AgendamentoController;
import model.Agendamento;
import model.enums.StatusAgendamento;
import model.enums.TipoExame;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import static control.PacienteController.getNomePacienteForId;
import static dao.FuncionarioDao.getNomeFuncionarioForId;
import static model.utils.DateUtils.getStringFromDate2;

public class FormularioAgendamentoPanel extends JPanel {
    private JComboBox<TipoExame> cbExames;
    private JComboBox<StatusAgendamento> cbStatus;
    private JTextField tfCodPaciente, tfNomePaciente, tfCodFuncionario, tfNomeFuncionario;
    private JFormattedTextField ftfDataAgendamento, ftfHorarioAgendamento;
    private JButton btnSalvar;
    private JButton btnLimpar;
    private JButton btnBusca;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnSalvarEdicao;
    private JButton btnCancelarEdicao;
    private JButton btnNovoCadastro;
    private JLabel lbStatus;

    public FormularioAgendamentoPanel(JFrame pacienteFrame) {
        setBackground(SystemColor.activeCaptionBorder);
        setLayout(null);

        JLabel lbExames = new JLabel("Exame:");
        lbExames.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbExames.setBounds(20, 87, 60, 14);
        add(lbExames);

        cbExames = new JComboBox<>(TipoExame.values());
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
        tfCodPaciente.setBounds(115, 213, 45, 20);
        tfCodPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomePaciente = getNomePacienteForId(Integer.parseInt(tfCodPaciente.getText()));
                tfNomePaciente.setText(nomePaciente);
            }
        });
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
        tfNomePaciente.setBorder(BorderFactory.createLineBorder(new Color(96, 8, 166)));
        tfNomePaciente.setBackground(new Color(226, 207, 241));
        add(tfNomePaciente);

        JLabel lbCodFuncionario = new JLabel("Código Funcionário:");
        lbCodFuncionario.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        lbCodFuncionario.setBounds(20, 320, 120, 14);
        add(lbCodFuncionario);

        tfCodFuncionario = new JTextField();
        tfCodFuncionario.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tfCodFuncionario.setColumns(10);
        tfCodFuncionario.setBounds(137, 317, 45, 20);
        tfCodFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeFuncionario = getNomeFuncionarioForId(Integer.parseInt(tfCodFuncionario.getText()));
                tfNomeFuncionario.setText(nomeFuncionario);
            }
        });
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
        tfNomeFuncionario.setBorder(BorderFactory.createLineBorder(new Color(96, 8, 166)));
        tfNomeFuncionario.setBackground(new Color(226, 207, 241));
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

        lbStatus = new JLabel("Status:");
        lbStatus.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbStatus.setBounds(20, 449, 60, 14);
        lbStatus.setVisible(false);
        add(lbStatus);

        cbStatus = new JComboBox<>(StatusAgendamento.values());
        cbStatus.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        cbStatus.setBounds(74, 443, 115, 26);
        cbStatus.setVisible(false);
        add(cbStatus);

        btnSalvar = new JButton();
        btnSalvar.setIcon(new ImageIcon(getClass().getResource("/view/icons/salvar-arquivo.png")));
        btnSalvar.setBackground(SystemColor.windowBorder);
        btnSalvar.setForeground(SystemColor.desktop);
        btnSalvar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AgendamentoController ac = new AgendamentoController();
                ac.controlSalvar(FormularioAgendamentoPanel.this);

                limparCampos();
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
                limparCampos();
            }
        });
        btnLimpar.setBounds(384, 433, 38, 38);
        add(btnLimpar);

        btnBusca = new JButton();
        btnBusca.setIcon(new ImageIcon(getClass().getResource("/view/icons/lupa.png")));
        btnBusca.setForeground(SystemColor.desktop);
        btnBusca.setFont(new Font("Bahnschrift", Font.PLAIN, 5));
        btnBusca.setBackground(SystemColor.windowBorder);
        btnBusca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListaAgendamentosFrame listaAgendamentosFrame = new ListaAgendamentosFrame();
                listaAgendamentosFrame.setSize(1600,900);
                listaAgendamentosFrame.setVisible(true);
                pacienteFrame.setVisible(false);
            }
        });
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


    public FormularioAgendamentoPanel(JFrame pacienteFrame, Integer codAgendamento){
        this(pacienteFrame);//chama o construtor padrão
        Agendamento agendamento = getDadosAgendamento(codAgendamento);

        btnLimpar.setVisible(false);//Deixa os botões do outro formulario ocultos
        btnSalvar.setVisible(false);
        lbStatus.setVisible(true);
        cbStatus.setVisible(true);

        preencherCampos(agendamento);// preenche o formulario com os dados
        setStatusEdicaoCampos(false); //Deixa todos os campos editaveis(true) ou não editaveis(false)

        btnEditar = new JButton();
        btnEditar.setIcon(new ImageIcon(getClass().getResource("/view/icons/editar.png")));
        btnEditar.setBackground(SystemColor.windowBorder);
        btnEditar.setForeground(SystemColor.desktop);
        btnEditar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnEditar.setBounds(432, 433, 38, 38);
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
                    ac.controlExcluirAgendamento(agendamento);
                    JOptionPane.showMessageDialog(null, "Agendamento excluido com sucesso");
                    limparCampos();
                }
            }
        });
        btnExcluir.setBounds(384, 433, 38, 38);
        add(btnExcluir);

        btnSalvarEdicao = new JButton(); // APARECE NO LUGAR DO btnEditar
        btnSalvarEdicao.setIcon(new ImageIcon(getClass().getResource("/view/icons/confirmar.png")));
        btnSalvarEdicao.setBackground(SystemColor.windowBorder);
        btnSalvarEdicao.setForeground(SystemColor.desktop);
        btnSalvarEdicao.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnSalvarEdicao.setBounds(432, 433, 38, 38);
        btnSalvarEdicao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AgendamentoController ac = new AgendamentoController();
                Agendamento agendamentoAtualizado =  ac.controlAtualizarAgendamento(FormularioAgendamentoPanel.this, agendamento);
                preencherCampos(agendamentoAtualizado);
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
                preencherCampos(agendamento);
                btnCancelarEdicao.setVisible(false);
                btnSalvarEdicao.setVisible(false);
            }
        });
        btnCancelarEdicao.setBounds(384, 433, 38, 38);
        add(btnCancelarEdicao);

        btnNovoCadastro = new JButton();
        btnNovoCadastro.setIcon(new ImageIcon(getClass().getResource("/view/icons/adicionar.png")));
        btnNovoCadastro.setBackground(SystemColor.windowBorder);
        btnNovoCadastro.setForeground(SystemColor.desktop);
        btnNovoCadastro.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnNovoCadastro.setBounds(288, 433, 38, 38);
        btnNovoCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PacienteFrame novoFrame = new PacienteFrame();
                novoFrame.setSize(530, 870);
                novoFrame.setVisible(true);
                pacienteFrame.setVisible(false);
            }
        });
        add(btnNovoCadastro);

    }

    private void preencherCampos(Agendamento agendamento){
        // SETA OS VALORES DOS CAMPOS DE ACORDO COM O RECUPERADO DO BANCO DE DADOS

        cbExames.setSelectedItem(agendamento.getExame());
        cbStatus.setSelectedItem(agendamento.getStatus());
        tfCodPaciente.setText(agendamento.getCodPaciente().toString());
        tfNomePaciente.setText(getNomePacienteForId(Integer.parseInt(tfCodPaciente.getText())));
        tfCodFuncionario.setText(agendamento.getCodFuncionario().toString());
        tfNomeFuncionario.setText(getNomeFuncionarioForId(Integer.parseInt(tfCodFuncionario.getText())));
        ftfDataAgendamento.setText(getStringFromDate2(agendamento.getDataAgendamento()));
        ftfHorarioAgendamento.setText(agendamento.getHorarioAgendamento().toString());
    }

    private void setStatusEdicaoCampos(Boolean status){
        Color borderEditavel = new Color(66, 64, 64);
        Color borderIneditavel = new Color(96, 8, 166);
        Color bgEditavel = new Color(238, 240, 242);
        Color bgIneditavel = new Color(226, 207, 241);

        if(status) alterCoresCampos(borderEditavel, bgEditavel);
        else alterCoresCampos(borderIneditavel, bgIneditavel);


        cbExames.setEnabled(status);
        cbStatus.setEnabled(status);
        tfCodPaciente.setEditable(status);
        tfCodFuncionario.setEditable(status);
        ftfDataAgendamento.setEditable(status);
        ftfHorarioAgendamento.setEditable(status);
    }

    private void limparCampos() {
        cbExames.setSelectedIndex(0);
        cbStatus.setSelectedIndex(0);
        tfCodPaciente.setText("");
        tfNomePaciente.setText("");
        tfCodFuncionario.setText("");
        tfNomeFuncionario.setText("");
        ftfDataAgendamento.setValue("");
        ftfHorarioAgendamento.setValue("");
    }

    private Agendamento getDadosAgendamento(Integer codAgendamento) {
        AgendamentoController ac = new AgendamentoController();
        return ac.controlBuscarAgendamentoForId(codAgendamento);
    }

    private void alterCoresCampos(Color corBorda, Color corFundo){

        cbExames.setBackground(corFundo);
        ((JLabel) cbExames.getRenderer()).setOpaque(true); // Torna o fundo do item selecionado visível
        cbExames.setBorder(BorderFactory.createLineBorder(corBorda));
        cbExames.setForeground(Color.BLACK);

        cbStatus.setBackground(corFundo);
        ((JLabel) cbStatus.getRenderer()).setOpaque(true); // Torna o fundo do item selecionado visível
        cbStatus.setBorder(BorderFactory.createLineBorder(corBorda));
        cbStatus.setForeground(Color.BLACK);

        tfCodPaciente.setBorder(BorderFactory.createLineBorder(corBorda));
        tfCodPaciente.setBackground(corFundo);

        tfCodFuncionario.setBorder(BorderFactory.createLineBorder(corBorda));
        tfCodFuncionario.setBackground(corFundo);

        ftfDataAgendamento.setBorder(BorderFactory.createLineBorder(corBorda));
        ftfDataAgendamento.setBackground(corFundo);

        ftfHorarioAgendamento.setBorder(BorderFactory.createLineBorder(corBorda));
        ftfHorarioAgendamento.setBackground(corFundo);
    }

    public TipoExame getCbExames() {
        return (TipoExame) cbExames.getSelectedItem();
    }

    public void setCbExames(JComboBox<TipoExame> cbExames) {
        this.cbExames = cbExames;
    }

    public StatusAgendamento getCbStatus() {
        return (StatusAgendamento) cbStatus.getSelectedItem();
    }

    public void setCbStatus(JComboBox<StatusAgendamento> cbStatus) {
        this.cbStatus = cbStatus;
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

    public JFormattedTextField getFtfDataAgendamento() {
        return ftfDataAgendamento;
    }

    public void setFtfDataAgendamento(JFormattedTextField ftfDataAgendamento) {
        this.ftfDataAgendamento = ftfDataAgendamento;
    }

    public JFormattedTextField getFtfHorarioAgendamento() {
        return ftfHorarioAgendamento;
    }

    public void setFtfHorarioAgendamento(JFormattedTextField ftfHorarioAgendamento) {
        this.ftfHorarioAgendamento = ftfHorarioAgendamento;
    }
}