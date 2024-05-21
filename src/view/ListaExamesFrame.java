package view;

import control.EletrocardiogramaController;
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
import static dao.FuncionarioDao.getNomeFuncionarioForId;

public class ListaExamesFrame extends JFrame{

    private JTable table;
    private JTextField searchField;

    public ListaExamesFrame() {
        setTitle("Lista de Exames");
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
                        Integer codExame = Integer.parseInt(table.getValueAt(linha, 0).toString());// passar codFuncionario, crm, cri
                        FormularioEletrocardiogramaFrame formularioEletrocardiogramaFrame = new FormularioEletrocardiogramaFrame(codExame); //ABRE O FRAME DE EDICAO DE DADOS
                        formularioEletrocardiogramaFrame.setSize(530,870);
                        formularioEletrocardiogramaFrame.setVisible(true);
                        ListaExamesFrame.this.setVisible(false);
                    }
                }
            }
        });

        // Atualiza a tabela com os dados dos pacientes
        updateTableData();
    }

    private DefaultTableModel createTableModel() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Cod. Exame");
        tableModel.addColumn("Cod. Paciente");
        tableModel.addColumn("Nome Paciente");
        tableModel.addColumn("Peso");
        tableModel.addColumn("Altura");
        tableModel.addColumn("Convênio");
        tableModel.addColumn("Ritmo Cardiaco");
        tableModel.addColumn("Função Cardiaca");
        tableModel.addColumn("Diagnostico");
        tableModel.addColumn("Conclusões");
        tableModel.addColumn("Cod. Responsável");
        tableModel.addColumn("Nome Responsável");
        return tableModel;
    }

    private void updateTableData() {
        // Popula a tabela com os dados
        try {
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); // Limpa a tabela antes de preenchê-la novamente

            EletrocardiogramaController ec = new EletrocardiogramaController();
            ArrayList<Eletrocardiograma> eletrocardiogramas = ec.controlListarEletrocardiogramas();


            for (Eletrocardiograma eletro:eletrocardiogramas) {
                tableModel.addRow(new String[]{
                        eletro.getCodExame().toString(),
                        eletro.getCodPaciente().toString(),
                        getNomePacienteForId(eletro.getCodPaciente()),
                        eletro.getPeso().toString(),
                        eletro.getAltura().toString(),
                        eletro.getConvenio(),
                        eletro.getRitmoCardiaco(),
                        eletro.getFuncaoCardiaca().toString(),
                        eletro.getDiagnosticoText(),
                        eletro.getConclusoes(),
                        eletro.getCodFuncionario().toString(),
                        getNomeFuncionarioForId(eletro.getCodFuncionario())
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

                EletrocardiogramaController ec = new EletrocardiogramaController();
                ArrayList<Eletrocardiograma> eletrocardiogramas = ec.controlListarEletrocardiogramasBusca(textoBusca);

                for (Eletrocardiograma eletro: eletrocardiogramas) {
                    tableModel.addRow(new String[]{
                            eletro.getCodExame().toString(),
                            eletro.getCodPaciente().toString(),
                            getNomePacienteForId(eletro.getCodPaciente()),
                            eletro.getPeso().toString(),
                            eletro.getAltura().toString(),
                            eletro.getConvenio(),
                            eletro.getRitmoCardiaco(),
                            eletro.getFuncaoCardiaca().toString(),
                            eletro.getDiagnosticoText(),
                            eletro.getConclusoes(),
                            eletro.getCodFuncionario().toString(),
                            getNomeFuncionarioForId(eletro.getCodFuncionario())
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
