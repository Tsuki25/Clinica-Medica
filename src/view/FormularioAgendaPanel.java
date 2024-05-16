package view;

import control.AgendaController;
import control.AgendamentoController;
import control.PacienteController;
import model.Agenda;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import static dao.FuncionarioDao.getNomeFuncionarioForId;
import static model.utils.DateUtils.getStringFromDate2;

public class FormularioAgendaPanel extends JPanel {
    private JTextField tfCodFuncionario, tfNomeFuncionario, tfMotivo;
    private JFormattedTextField ftfDataReserva, ftfIntervaloInicio, ftfIntervaloFim;
    private JButton btnSalvar;
    private JButton btnLimpar;
    private JButton btnBusca;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnSalvarEdicao;
    private JButton btnCancelarEdicao;
    private JButton btnNovoCadastro;

    public FormularioAgendaPanel(JFrame pacienteFrame) {
        setBackground(SystemColor.activeCaptionBorder);
        setLayout(null);

        tfCodFuncionario = new JTextField();
        tfCodFuncionario.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        tfCodFuncionario.setColumns(10);
        tfCodFuncionario.setBounds(158, 99, 72, 20);

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
        lbNomeFuncionario.setBounds(20, 130, 134, 14);
        add(lbNomeFuncionario);

        tfNomeFuncionario = new JTextField();
        tfNomeFuncionario.setEditable(false);
        tfNomeFuncionario.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        tfNomeFuncionario.setColumns(10);
        tfNomeFuncionario.setBounds(152, 127, 117, 20);
        tfNomeFuncionario.setBorder(BorderFactory.createLineBorder(new Color(96, 8, 166)));
        tfNomeFuncionario.setBackground(new Color(226, 207, 241));
        add(tfNomeFuncionario);

        JLabel lbDataReserva = new JLabel("Data de reserva:");
        lbDataReserva.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbDataReserva.setBounds(20, 216, 117, 14);
        add(lbDataReserva);

        MaskFormatter dateFormatter = null;
        try {
            dateFormatter = new MaskFormatter("##/##/####");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ftfDataReserva = new JFormattedTextField(dateFormatter);
        ftfDataReserva.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        ftfDataReserva.setBounds(140, 213, 80, 20);
        add(ftfDataReserva);

        JLabel lbIntervaloInicio = new JLabel("De:");
        lbIntervaloInicio.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbIntervaloInicio.setBounds(20, 244, 38, 14);
        add(lbIntervaloInicio);

        MaskFormatter timeFormatter = null;
        try {
            timeFormatter = new MaskFormatter("##:##");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ftfIntervaloInicio = new JFormattedTextField(timeFormatter);
        ftfIntervaloInicio.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        ftfIntervaloInicio.setBounds(54, 241, 40, 20);
        add(ftfIntervaloInicio);

        JLabel lbIntervaloFim = new JLabel("Até:");
        lbIntervaloFim.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbIntervaloFim.setBounds(20, 272, 38, 14);
        add(lbIntervaloFim);

        ftfIntervaloFim = new JFormattedTextField(timeFormatter);
        ftfIntervaloFim.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        ftfIntervaloFim.setBounds(54, 269, 40, 20);
        add(ftfIntervaloFim);

        JLabel lbCodFuncionario = new JLabel("Código Funcionario:");
        lbCodFuncionario.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lbCodFuncionario.setBounds(20, 102, 146, 14);
        add(lbCodFuncionario);

        tfMotivo = new JTextField();
        tfMotivo.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        tfMotivo.setColumns(10);
        tfMotivo.setBounds(10, 338, 480, 71);
        add(tfMotivo);

        btnSalvar = new JButton();
        btnSalvar.setIcon(new ImageIcon(getClass().getResource("/view/icons/salvar-arquivo.png")));
        btnSalvar.setBackground(SystemColor.windowBorder);
        btnSalvar.setForeground(SystemColor.desktop);
        btnSalvar.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AgendaController ac = new AgendaController();
                if(ac.controlSalvar(FormularioAgendaPanel.this)){// Se for inserido com sucesso, limpa os campos
                    JOptionPane.showMessageDialog(null, "Agenda realizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    limparCampos();
                }

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
                ListaAgendaFrame listaAgendaFrame = new ListaAgendaFrame();
                listaAgendaFrame.setSize(1600,900);
                listaAgendaFrame.setVisible(true);
                pacienteFrame.setVisible(false);
            }
        });
        btnBusca.setBounds(336, 433, 38, 38);
        add(btnBusca);

        JLabel lbTitle = new JLabel("Agenda");
        lbTitle.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        lbTitle.setBounds(215, 22, 79, 25);
        add(lbTitle);

        JLabel lblNewLabel = new JLabel("Periodo:");
        lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lblNewLabel.setBounds(20, 177, 267, 14);
        add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 194, 480, 2);
        add(separator);

        JLabel lblContato = new JLabel("Reservado para:");
        lblContato.setBackground(SystemColor.textHighlight);
        lblContato.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lblContato.setBounds(20, 65, 267, 14);
        add(lblContato);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(10, 82, 480, 2);
        add(separator_1);

        JLabel lblMotivo = new JLabel("Motivo:");
        lblMotivo.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        lblMotivo.setBounds(20, 311, 267, 14);
        add(lblMotivo);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(10, 328, 480, 2);
        add(separator_2);

    }

    public FormularioAgendaPanel(JFrame pacienteFrame, Integer codAgenda){
        this(pacienteFrame);//chama o construtor padrão
        Agenda agenda = getDadosAgenda(codAgenda);

        btnLimpar.setVisible(false);//Deixa os botões do outro formulario ocultos
        btnSalvar.setVisible(false);

        preencherCampos(agenda);// preenche o formulario com os dados
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
                    AgendaController ac = new AgendaController();
                    ac.controlExcluirAgenda(agenda);
                    JOptionPane.showMessageDialog(null, "Agenda excluido com sucesso");
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
                /*AgendamentoController ac = new AgendamentoController();
                Agendamento agendamentoAtualizado =  ac.controlAtualizarAgendamento(FormularioAgendaPanel.this, agendamento);
                preencherCampos(agendamentoAtualizado);
                JOptionPane.showMessageDialog(null, "Paciente atualizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                setStatusEdicaoCampos(false);
                btnEditar.setVisible(true);
                btnExcluir.setVisible(true);
                btnCancelarEdicao.setVisible(false);
                btnSalvarEdicao.setVisible(false);*/
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
                preencherCampos(agenda);
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

    private void preencherCampos(Agenda agenda){
        // SETA OS VALORES DOS CAMPOS DE ACORDO COM O RECUPERADO DO BANCO DE DADOS
        tfCodFuncionario.setText(agenda.getCodFuncionario().toString());
        tfNomeFuncionario.setText(getNomeFuncionarioForId(Integer.parseInt(tfCodFuncionario.getText())));
        ftfDataReserva.setText(getStringFromDate2(agenda.getDataReserva()));
        ftfIntervaloInicio.setText(agenda.getHorarioInicio().toString());
        ftfIntervaloFim.setText(agenda.getHorarioFim().toString());
        tfMotivo.setText(agenda.getMotivo());
    }

    private void setStatusEdicaoCampos(Boolean status){
        Color borderEditavel = new Color(66, 64, 64);
        Color borderIneditavel = new Color(96, 8, 166);
        Color bgEditavel = new Color(238, 240, 242);
        Color bgIneditavel = new Color(226, 207, 241);

        if(status) alterCoresCampos(borderEditavel, bgEditavel);
        else alterCoresCampos(borderIneditavel, bgIneditavel);

        tfCodFuncionario.setEditable(status);
        ftfDataReserva.setEditable(status);
        ftfIntervaloInicio.setEditable(status);
        ftfIntervaloFim.setEditable(status);
        tfMotivo.setEditable(status);
    }

    private Agenda getDadosAgenda(Integer codAgenda) {
        AgendaController ac = new AgendaController();
        return ac.controlBuscarAgendaForId(codAgenda);
    }

    private void alterCoresCampos(Color corBorda, Color corFundo){
        tfCodFuncionario.setBorder(BorderFactory.createLineBorder(corBorda));
        tfCodFuncionario.setBackground(corFundo);

        ftfDataReserva.setBorder(BorderFactory.createLineBorder(corBorda));
        ftfDataReserva.setBackground(corFundo);

        ftfIntervaloInicio.setBorder(BorderFactory.createLineBorder(corBorda));
        ftfIntervaloInicio.setBackground(corFundo);

        ftfIntervaloFim.setBorder(BorderFactory.createLineBorder(corBorda));
        ftfIntervaloFim.setBackground(corFundo);

        tfMotivo.setBorder(BorderFactory.createLineBorder(corBorda));
        tfMotivo.setBackground(corFundo);
    }

    private void limparCampos() {
        tfCodFuncionario.setText("");
        tfNomeFuncionario.setText("");
        tfMotivo.setText("");
        ftfDataReserva.setValue("");
        ftfIntervaloInicio.setValue("");
        ftfIntervaloFim.setValue("");
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

    public JFormattedTextField getFtfDataReserva() {
        return ftfDataReserva;
    }

    public void setFtfDataReserva(JFormattedTextField ftfDataReserva) {
        this.ftfDataReserva = ftfDataReserva;
    }

    public JFormattedTextField getFtfIntervaloInicio() {
        return ftfIntervaloInicio;
    }

    public void setFtfIntervaloInicio(JFormattedTextField ftfIntervaloInicio) {
        this.ftfIntervaloInicio = ftfIntervaloInicio;
    }

    public JFormattedTextField getFtfIntervaloFim() {
        return ftfIntervaloFim;
    }

    public void setFtfIntervaloFim(JFormattedTextField ftfIntervaloFim) {
        this.ftfIntervaloFim = ftfIntervaloFim;
    }

    public JTextField getTfMotivo() {
        return tfMotivo;
    }

    public void setTfMotivo(JTextField tfMotivo) {
        this.tfMotivo = tfMotivo;
    }
}