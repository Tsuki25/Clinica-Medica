package view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import control.PacienteController;
import model.Endereco;
import model.Paciente;

public class ListaPacientesPanel extends JPanel {
    private JTable table;

    public ListaPacientesPanel() {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(1600, 1600));
        add(scrollPane);

        DefaultTableModel tableModel = createTableModel();
        table = new JTable(tableModel);
        scrollPane.setViewportView(table);

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
            PacienteController pc = new PacienteController();
            ArrayList<Object[]> resposta = pc.controlListarPacientes();

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
            e.printStackTrace(); // Trate as exceções apropriadamente
        }
    }

    public void addNewRow(Object[] valores) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.addRow(valores);
    }
}
