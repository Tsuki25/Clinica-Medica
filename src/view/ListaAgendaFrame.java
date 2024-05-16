package view;

import control.AgendaController;
import model.Agenda;

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

public class ListaAgendaFrame extends JFrame{

    private JTable table;
    private JTextField searchField;

    public ListaAgendaFrame() {
        setTitle("Agendas Reservadas");
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
                    int linha = table.getSelectedRow();
                    if (linha != -1) {
                        Integer codAgenda = Integer.parseInt(table.getValueAt(linha, 0).toString());
                        String dataReserva = table.getValueAt(linha, 1).toString();
                        PacienteFrame agendaEditionFrame = new PacienteFrame(codAgenda, dataReserva); //ABRE O FRAME DE EDICAO DA AGENDA
                        agendaEditionFrame.setSize(530,870);
                        agendaEditionFrame.setVisible(true);
                        ListaAgendaFrame.this.setVisible(false);
                    }
                }
            }
        });

        // Atualiza a tabela com os dados dos pacientes
        updateTableData();
    }

    private DefaultTableModel createTableModel() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Cod. Agenda");
        tableModel.addColumn("Data da reserva");
        tableModel.addColumn("De");
        tableModel.addColumn("Até");
        tableModel.addColumn("Motivo");
        tableModel.addColumn("Cod. Funcionario");
        tableModel.addColumn("Nome Funcionario");
        return tableModel;
    }

    private void updateTableData() {
        // Popula a tabela com os dados
        try {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); // Limpa a tabela antes de preenchê-la novamente

            AgendaController ac = new AgendaController();
            ArrayList<Agenda> agendas = ac.controlListarAgendas();

            for (Agenda agenda : agendas) {
                tableModel.addRow(new String[]{
                        agenda.getCodAgenda().toString(),
                        agenda.getDataReserva().toString(),
                        agenda.getHorarioInicio().toString(),
                        agenda.getHorarioFim().toString(),
                        agenda.getMotivo(),
                        agenda.getCodFuncionario().toString(),
                        getNomeFuncionarioForId(agenda.getCodFuncionario()),
                });
            }
        } catch (Exception e) {
            e.printStackTrace(); // TEMPORARIO
        }
    }

    private void busca() {
        String textoBusca = searchField.getText().trim();

        if (!textoBusca.isEmpty()) {
            try {
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.setRowCount(0); // Limpa a tabela antes de preenchê-la novamente

                AgendaController ac = new AgendaController();
                ArrayList<Agenda> agendas = ac.controlListarAgendasBusca(textoBusca);

                for (Agenda agenda : agendas) {
                    tableModel.addRow(new String[]{
                            agenda.getCodAgenda().toString(),
                            agenda.getDataReserva().toString(),
                            agenda.getHorarioInicio().toString(),
                            agenda.getHorarioFim().toString(),
                            agenda.getMotivo(),
                            agenda.getCodFuncionario().toString(),
                            getNomeFuncionarioForId(agenda.getCodFuncionario()),
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
