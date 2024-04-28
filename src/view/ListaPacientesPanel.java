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
        scrollPane.setPreferredSize(new Dimension(950, 950));
        add(scrollPane);

        table = new JTable();
        table.setModel(getDataColumns());
        scrollPane.setViewportView(table);

    }
    private DefaultTableModel getDataColumns() {
        DefaultTableModel tableModel = new DefaultTableModel();

        // Adicionando as colunas à tabela
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

        // Populando a tabela com os dados dos pacientes e endereços
        PacienteController pc = new PacienteController();
        ArrayList<Object[]> resposta = pc.controlListarPacientes();

        for (Object[] dados : resposta) {
            Paciente paciente = (Paciente) dados[0];
            Endereco endereco = (Endereco) dados[1];

            tableModel.addRow(new Object[] {
                    paciente.getCodPaciente(),
                    paciente.getCpf(),
                    paciente.getNome(),
                    paciente.getSobrenome(),
                    paciente.getSexo(),
                    paciente.getDataNascimento(),
                    paciente.getTelefone(),
                    paciente.getCelular(),
                    paciente.getEmail(),
                    endereco.getCep(),
                    endereco.getLogradouro(),
                    endereco.getBairro(),
                    endereco.getCidade(),
                    endereco.getEstado(),
                    endereco.getNumero(),
                    endereco.getComplemento(),
                    paciente.getHistorico(),
                    paciente.getAlergias(),
                    paciente.getMedicamentosUtilizados(),
                    paciente.getAnotacoes()
            });
        }
        return tableModel;
    }

    public void addNewRow(Object[] valores) {
        ((DefaultTableModel) table.getModel()).addRow(valores);
    }
}
