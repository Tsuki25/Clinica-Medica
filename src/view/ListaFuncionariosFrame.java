package view;

import control.EnfermeiroController;
import control.MedicoController;
import control.PacienteController;
import control.RecepcionistaController;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ListaFuncionariosFrame extends JFrame{

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

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(sorter);

        // Ordena a tabela na ordem crescente pela primeira coluna "Cod. Funcionario"
        sorter.setSortKeys(java.util.List.of(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
        sorter.sort();

        // Adiciona o evento de dois clicks à tabela
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int linha = table.getSelectedRow();
                    if (linha != -1) {
                        Integer codFuncionario = Integer.parseInt(table.getValueAt(linha, 0).toString());// passar codFuncionario, crm, cri
                        String crm = table.getValueAt(linha, 4).toString();// se crm vazio e cri cheio -> enfermerio
                        String cri = table.getValueAt(linha, 5).toString();  // se crm cheio e cri vazio -> medico
                        // se crm e cri vazios recepcionista
                        PacienteFrame pacienteFrame = new PacienteFrame(codFuncionario, crm, cri); //ABRE O FRAME DE EDICAO DE DADOS DO USUARIOS
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
        // Popula a tabela com os dados
        try {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); // Limpa a tabela antes de preenchê-la novamente

            RecepcionistaController rc = new RecepcionistaController();
            EnfermeiroController ec = new EnfermeiroController();
            MedicoController mc = new MedicoController();

            ArrayList<Recepcionista> recepcionistas = rc.controlListarRecepcionistas();
            ArrayList<Enfermeiro> enfermeiros = ec.controlListarEnfermeiros();
            ArrayList<Medico> medicos = mc.controlListarMedicos();

            for (Recepcionista recepcionista : recepcionistas ) {
                Endereco endereco = recepcionista.getEndereco();
                tableModel.addRow(new String[]{
                        recepcionista.getCodFuncionario().toString(),
                        recepcionista.getCpf(),
                        recepcionista.getNome(),
                        recepcionista.getSobrenome(),
                        "",//CRM
                        "",//CIP
                        recepcionista.getSexo(),
                        recepcionista.getDataNascimento().toString(),
                        recepcionista.getTelefone(),
                        recepcionista.getCelular(),
                        recepcionista.getEmail(),
                        endereco.getCep().toString(),
                        endereco.getLogradouro(),
                        endereco.getBairro(),
                        endereco.getCidade(),
                        endereco.getEstado(),
                        endereco.getNumero().toString(),
                        endereco.getComplemento()
                });
            }

            for (Enfermeiro enfermeiro : enfermeiros ) {
                Endereco endereco = enfermeiro.getEndereco();
                tableModel.addRow(new String[]{
                        enfermeiro.getCodFuncionario().toString(),
                        enfermeiro.getCpf(),
                        enfermeiro.getNome(),
                        enfermeiro.getSobrenome(),
                        "",//CRM
                        enfermeiro.getCip(),//CIP
                        enfermeiro.getSexo(),
                        enfermeiro.getDataNascimento().toString(),
                        enfermeiro.getTelefone(),
                        enfermeiro.getCelular(),
                        enfermeiro.getEmail(),
                        endereco.getCep().toString(),
                        endereco.getLogradouro(),
                        endereco.getBairro(),
                        endereco.getCidade(),
                        endereco.getEstado(),
                        endereco.getNumero().toString(),
                        endereco.getComplemento()
                });
            }

            for (Medico medico : medicos ) {
                Endereco endereco = medico.getEndereco();
                tableModel.addRow(new String[]{
                        medico.getCodFuncionario().toString(),
                        medico.getCpf(),
                        medico.getNome(),
                        medico.getSobrenome(),
                        medico.getCrm(),//CRM
                        "",//CIP
                        medico.getSexo(),
                        medico.getDataNascimento().toString(),
                        medico.getTelefone(),
                        medico.getCelular(),
                        medico.getEmail(),
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
    }

    private void busca() {
        String textoBusca = searchField.getText().trim();

        if (!textoBusca.isEmpty()) {
            // A BUSCA PODE SER REALIZADO POR CODIGO, CPF, NOME, SOBRENOME
            try {
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.setRowCount(0); // Limpa a tabela antes de preenchê-la novamente

                RecepcionistaController rc = new RecepcionistaController();
                EnfermeiroController ec = new EnfermeiroController();
                MedicoController mc = new MedicoController();

                ArrayList<Recepcionista> recepcionistas = rc.controlListarRecepcionistasBusca(textoBusca);
                ArrayList<Enfermeiro> enfermeiros = ec.controlListarEnfermeirosBusca(textoBusca);
                ArrayList<Medico> medicos = mc.controlListarMedicosBusca(textoBusca);

                for (Recepcionista recepcionista : recepcionistas ) {
                    Endereco endereco = recepcionista.getEndereco();
                    tableModel.addRow(new String[]{
                            recepcionista.getCodFuncionario().toString(),
                            recepcionista.getCpf(),
                            recepcionista.getNome(),
                            recepcionista.getSobrenome(),
                            "",//CRM
                            "",//CIP
                            recepcionista.getSexo(),
                            recepcionista.getDataNascimento().toString(),
                            recepcionista.getTelefone(),
                            recepcionista.getCelular(),
                            recepcionista.getEmail(),
                            endereco.getCep().toString(),
                            endereco.getLogradouro(),
                            endereco.getBairro(),
                            endereco.getCidade(),
                            endereco.getEstado(),
                            endereco.getNumero().toString(),
                            endereco.getComplemento()
                    });
                }

                for (Enfermeiro enfermeiro : enfermeiros ) {
                    Endereco endereco = enfermeiro.getEndereco();
                    tableModel.addRow(new String[]{
                            enfermeiro.getCodFuncionario().toString(),
                            enfermeiro.getCpf(),
                            enfermeiro.getNome(),
                            enfermeiro.getSobrenome(),
                            "",//CRM
                            enfermeiro.getCip(),//CIP
                            enfermeiro.getSexo(),
                            enfermeiro.getDataNascimento().toString(),
                            enfermeiro.getTelefone(),
                            enfermeiro.getCelular(),
                            enfermeiro.getEmail(),
                            endereco.getCep().toString(),
                            endereco.getLogradouro(),
                            endereco.getBairro(),
                            endereco.getCidade(),
                            endereco.getEstado(),
                            endereco.getNumero().toString(),
                            endereco.getComplemento()
                    });
                }

                for (Medico medico : medicos ) {
                    Endereco endereco = medico.getEndereco();
                    tableModel.addRow(new String[]{
                            medico.getCodFuncionario().toString(),
                            medico.getCpf(),
                            medico.getNome(),
                            medico.getSobrenome(),
                            medico.getCrm(),//CRM
                            "",//CIP
                            medico.getSexo(),
                            medico.getDataNascimento().toString(),
                            medico.getTelefone(),
                            medico.getCelular(),
                            medico.getEmail(),
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

}
