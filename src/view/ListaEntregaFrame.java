package view;

import control.EletrocardiogramaController;
import control.EntregaController;
import model.EntregaExame;
import model.exames.Eletrocardiograma;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static control.PacienteController.getNomePacienteForId;
import static dao.EletrocardiogramaDao.getPacienteForExame;
import static dao.FuncionarioDao.getNomeFuncionarioForId;

public class ListaEntregaFrame extends JFrame{
    private JTable table;
    private JTextField searchField;

    public ListaEntregaFrame() {
        setTitle("Exames Entregues");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
                        Integer codEntrega = Integer.parseInt(table.getValueAt(linha, 0).toString());
                        FormularioEntregasFrame formularioEntregasFrame = new FormularioEntregasFrame(codEntrega); //ABRE O FRAME DE EDICAO DE DADOS
                        formularioEntregasFrame.setSize(530,870);
                        formularioEntregasFrame.setVisible(true);
                        ListaEntregaFrame.this.setVisible(false);
                    }
                }
            }
        });

        // Atualiza a tabela com os dados dos pacientes
        updateTableData();
    }

    private DefaultTableModel createTableModel() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Cod. Entrega");
        tableModel.addColumn("Cod. Paciente");
        tableModel.addColumn("Nome Paciente");
        tableModel.addColumn("Cod. Exame");
        tableModel.addColumn("Retirado por");
        tableModel.addColumn("Data da retirada");
        tableModel.addColumn("Horario da retirada");
        tableModel.addColumn("Cod. Responsável");
        tableModel.addColumn("Nome Responsável");
        return tableModel;
    }

    private void updateTableData() {
        // Popula a tabela com os dados
        try {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); // Limpa a tabela antes de preenchê-la novamente

            EntregaController ec = new EntregaController();
            ArrayList<EntregaExame> entregas = ec.controlListarEntregas();


            for (EntregaExame entrega:entregas) {
                Integer codPaciente = getPacienteForExame(entrega.getCodExame());
                tableModel.addRow(new String[]{
                        entrega.getCodEntrega().toString(),
                        codPaciente.toString(),
                        getNomePacienteForId(codPaciente),
                        entrega.getCodExame().toString(),
                        entrega.getRetiradoPor(),
                        entrega.getDataRetirada().toString(),
                        entrega.getHorarioRetirada().toString(),
                        entrega.getCodResponsavel().toString(),
                        getNomeFuncionarioForId(entrega.getCodResponsavel())
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

                EntregaController ec = new EntregaController();
                ArrayList<EntregaExame> entregas = ec.controlListarEntregasBusca(textoBusca);


                for (EntregaExame entrega:entregas) {
                    Integer codPaciente = getPacienteForExame(entrega.getCodExame());
                    tableModel.addRow(new String[]{
                            entrega.getCodEntrega().toString(),
                            codPaciente.toString(),
                            getNomePacienteForId(codPaciente),
                            entrega.getCodExame().toString(),
                            entrega.getRetiradoPor(),
                            entrega.getDataRetirada().toString(),
                            entrega.getHorarioRetirada().toString(),
                            entrega.getCodResponsavel().toString(),
                            getNomeFuncionarioForId(entrega.getCodResponsavel())
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
