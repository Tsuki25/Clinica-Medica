package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import control.PacienteController;
import model.Endereco;
import model.Paciente;

public class ListaPacientesFrame extends JFrame {
    private JTable table;
    private JTextField searchField;

    public ListaPacientesFrame() {
        setTitle("Lista de Pacientes");
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

        // Adiciona ouvinte de evento de clique na tabela
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int linha = table.getSelectedRow();
                    if (linha != -1) {
                        Integer codPaciente = Integer.parseInt(table.getValueAt(linha, 0).toString());
                        PacienteFrame pacienteFrame = new PacienteFrame(codPaciente); //ABRE O FRAME DE EDICAO DE DADOS DO USUARIOS
                        pacienteFrame.setSize(530,870);
                        pacienteFrame.setVisible(true);
                        ListaPacientesFrame.this.setVisible(false);
                    }
                }
            }
        });

        // Atualiza a tabela com os dados dos pacientes
        updateTableData();
    }

    private DefaultTableModel createTableModel() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Cod. Paciente");
        tableModel.addColumn("CPF");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Sobrenome");
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
        tableModel.addColumn("Historico");
        tableModel.addColumn("Alergias");
        tableModel.addColumn("Medicamentos");
        tableModel.addColumn("Anotações");
        return tableModel;
    }

    private void updateTableData() {
        // Popula a tabela com os dados dos pacientes e endereços
        try {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); // Limpa a tabela antes de preenchê-la novamente

            PacienteController pc = new PacienteController();
            ArrayList<Paciente> resposta = pc.controlListarPacientes();

            for (Paciente paciente : resposta ) {
                Endereco endereco = paciente.getEndereco();
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
                ArrayList<Paciente> resposta = pc.controlListarPacientesBusca(textoBusca);

                for (Paciente paciente : resposta) {
                    Endereco endereco = paciente.getEndereco();
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

        } else {
            // Se a barra de pesquisa estiver vazia, atualize a tabela com todos os pacientes
            updateTableData();
        }
    }

}
