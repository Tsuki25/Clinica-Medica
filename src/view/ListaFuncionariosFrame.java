package view;

import control.EnfermeiroController;
import control.MedicoController;
import control.PacienteController;
import control.RecepcionistaController;
import model.Endereco;
import model.Paciente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ListaFuncionariosFrame extends JFrame{
    /*
    private JTable table;
    private JTextField searchField;

    public ListaFuncionariosFrame() {
        setTitle("Lista de Funcionarios");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        getContentPane().add(mainPanel);

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());

        searchField = new JTextField(20);
        searchField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busca();
            }
        });
        searchPanel.add(new JLabel("Buscar: "));
        searchPanel.add(searchField);

        mainPanel.add(searchPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane();
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        DefaultTableModel tableModel = createTableModel();
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(true);
        scrollPane.setViewportView(table);

        // Adiciona o evento de dois clicks à tabela
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int linha = table.getSelectedRow();
                    if (linha != -1) {
                        Integer codPaciente = Integer.parseInt(table.getValueAt(linha, 0).toString());
                        PacienteFrame pacienteFrame = new PacienteFrame(codPaciente); //ABRE O FRAME DE EDICAO DE DADOS DO USUARIOS
                        pacienteFrame.setSize(530,870);
                        pacienteFrame.setVisible(true);
                        ListaFuncionariosFrame.this.setVisible(false);
                    }
                }
            }
        });

        // Atualiza a tabela com os dados dos pacientes
        updateTableData();
    }

    private DefaultTableModel createTableModel() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Cod. Funcionario");
        tableModel.addColumn("CPF");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Sobrenome");
        tableModel.addColumn("CRM");
        tableModel.addColumn("CIP");
        tableModel.addColumn("Sexo");
        tableModel.addColumn("Data de Nascimento");
        tableModel.addColumn("Telefone");
        tableModel.addColumn("Celular");
        tableModel.addColumn("Email");
        tableModel.addColumn("CEP");
        tableModel.addColumn("Logradouro");
        tableModel.addColumn("Bairro");
        tableModel.addColumn("Cidade");
        tableModel.addColumn("Estado");
        tableModel.addColumn("Numero");
        tableModel.addColumn("Complemento");
        return tableModel;
    }

    private void updateTableData() {
        // Popula a tabela com os dados dos pacientes e endereços
        try {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); // Limpa a tabela antes de preenchê-la novamente

            RecepcionistaController rc = new RecepcionistaController();
            EnfermeiroController ec = new EnfermeiroController();
            MedicoController mc = new MedicoController();
            ArrayList<Object[]> recepcionistas = rc.controlListarRecepcionista();
            ArrayList<Object[]> enfermeiros = rc.controlListarEnfermeiros();
            ArrayList<Object[]> medicos = rc.controlListarMedicos();

            for (Object[] dados : resposta) {
                Paciente paciente = (Paciente) dados[0];
                Endereco endereco = (Endereco) dados[1];

                tableModel.addRow(new String[]{
                        paciente.getCodPaciente().toString(),
                        paciente.getCpf(),
                        paciente.getNome(),
                        paciente.getSobrenome(),
                        paciente.getSexo(),
                        paciente.getDataNascimento().toString(),
                        paciente.getTelefone(),
                        paciente.getCelular(),
                        paciente.getEmail(),
                        endereco.getCep().toString(),
                        endereco.getLogradouro(),
                        endereco.getBairro(),
                        endereco.getCidade(),
                        endereco.getEstado(),
                        endereco.getNumero().toString(),
                        endereco.getComplemento(),
                        paciente.getHistorico(),
                        paciente.getAlergias(),
                        paciente.getMedicamentosUtilizados(),
                        paciente.getAnotacoes()
                });
            }
        } catch (Exception e) {
            e.printStackTrace(); // TEMPORARIO
        }
    }

    private void busca() {
        String textoBusca = searchField.getText().trim();

        if (!textoBusca.isEmpty()) {
            // A BUSCA PODE SER REALIZADO POR CODIGO, CPF, NOME, SOBRENOME
            try {
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.setRowCount(0); // Limpa a tabela antes de preenchê-la novamente

                PacienteController pc = new PacienteController();
                ArrayList<Object[]> resposta = pc.controlListarPacientesBusca(textoBusca);

                for (Object[] dados : resposta) {
                    Paciente paciente = (Paciente) dados[0];
                    Endereco endereco = (Endereco) dados[1];

                    tableModel.addRow(new String[]{
                            paciente.getCodPaciente().toString(),
                            paciente.getCpf(),
                            paciente.getNome(),
                            paciente.getSobrenome(),
                            paciente.getSexo(),
                            paciente.getDataNascimento().toString(),
                            paciente.getTelefone(),
                            paciente.getCelular(),
                            paciente.getEmail(),
                            endereco.getCep().toString(),
                            endereco.getLogradouro(),
                            endereco.getBairro(),
                            endereco.getCidade(),
                            endereco.getEstado(),
                            endereco.getNumero().toString(),
                            endereco.getComplemento()
                    });
                }
            } catch (Exception e) {
                e.printStackTrace(); // TEMPORARIO
            }

        } else {
            // Se a barra de pesquisa estiver vazia, atualize a tabela com todos os pacientes
            updateTableData();
        }
    }
    */
}
