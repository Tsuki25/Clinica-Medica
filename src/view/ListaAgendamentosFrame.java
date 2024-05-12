package view;

import control.*;
import dao.FuncionarioDao;
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

import static dao.FuncionarioDao.getNomeFuncionarioForId;

public class ListaAgendamentosFrame extends JFrame{

    private JTable table;
    private JTextField searchField;

    public ListaAgendamentosFrame() {
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

        sorter.setSortKeys(java.util.List.of(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
        sorter.sort();

        // Adiciona o evento de clicks à tabela
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                   /* int linha = table.getSelectedRow();
                    if (linha != -1) {
                        Integer codFuncionario = Integer.parseInt(table.getValueAt(linha, 0).toString());// passar codFuncionario, crm, cri
                        String crm = table.getValueAt(linha, 4).toString();// se crm vazio e cri cheio -> enfermerio
                        String cri = table.getValueAt(linha, 5).toString();  // se crm cheio e cri vazio -> medico
                        // se crm e cri vazios recepcionista
                        PacienteFrame pacienteFrame = new PacienteFrame(codFuncionario, crm, cri); //ABRE O FRAME DE EDICAO DE DADOS DO USUARIOS
                        pacienteFrame.setSize(530,870);
                        pacienteFrame.setVisible(true);
                        //ListaFuncionariosFrame.this.setVisible(false);
                    }*/
                }
            }
        });

        // Atualiza a tabela com os dados dos pacientes
        updateTableData();
    }

    private DefaultTableModel createTableModel() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Cod. Agendamento");
        tableModel.addColumn("Data Agendamento");
        tableModel.addColumn("Horario Agendamento");
        tableModel.addColumn("Exame");
        tableModel.addColumn("Cod. Paciente");
        tableModel.addColumn("Nome Paciente");
        tableModel.addColumn("Cod. Funcionario");
        tableModel.addColumn("Nome Funcionario");
        tableModel.addColumn("Status");
        return tableModel;
    }

    private void updateTableData() {
        // Popula a tabela com os dados
        try {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); // Limpa a tabela antes de preenchê-la novamente

            AgendamentoController ac = new AgendamentoController();
            PacienteController pc = new PacienteController();

            ArrayList<Agendamento> agendamentos = ac.controlListarAgendamentos();

            for (Agendamento agendamento : agendamentos) {
                tableModel.addRow(new String[]{
                        agendamento.getCodAgendamento().toString(),
                        agendamento.getDataAgendamento().toString(),
                        agendamento.getHorarioAgendamento().toString(),
                        agendamento.getExame().getTipo(),
                        agendamento.getCodPaciente().toString(),
                        pc.controlGetNomePacienteForId(agendamento.getCodPaciente()),
                        agendamento.getCodFuncionario().toString(),
                        getNomeFuncionarioForId(agendamento.getCodFuncionario()),
                        agendamento.getStatus().getDescricao()
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

                AgendamentoController ac = new AgendamentoController();
                PacienteController pc = new PacienteController();

                ArrayList<Agendamento> agendamentos = ac.controlListarAgendamentosBusca(textoBusca);

                for (Agendamento agendamento : agendamentos) {
                    tableModel.addRow(new String[]{
                            agendamento.getCodAgendamento().toString(),
                            agendamento.getDataAgendamento().toString(),
                            agendamento.getHorarioAgendamento().toString(),
                            agendamento.getExame().getTipo(),
                            agendamento.getCodPaciente().toString(),
                            pc.controlGetNomePacienteForId(agendamento.getCodPaciente()),
                            agendamento.getCodFuncionario().toString(),
                            getNomeFuncionarioForId(agendamento.getCodFuncionario()),
                            agendamento.getStatus().getDescricao()
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            // Se a barra de pesquisa estiver vazia, atualize a tabela com todos os pacientes
            updateTableData();
        }
    }

}
