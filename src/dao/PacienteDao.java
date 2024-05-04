package dao;

import control.EnderecoController;
import model.Endereco;
import model.Paciente;
import model.enums.Sexo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static model.utils.DateUtils.*;

public class PacienteDao {
    public void salvar(Paciente paciente) {
        Conexao conexao = new Conexao();
        String sql = "INSERT INTO " +
                "paciente (cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, historico, alergias, medicamentosUtilizados, anotacoes, codEnd) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, paciente.getCpf());
            stmt.setString(2, paciente.getNome());
            stmt.setString(3, paciente.getSobrenome());
            stmt.setString(4, paciente.getSexo());
            stmt.setString(5, getStringFromDate1(paciente.getDataNascimento()));
            stmt.setString(6, paciente.getTelefone());
            stmt.setString(7, paciente.getCelular());
            stmt.setString(8, paciente.getEmail());
            stmt.setString(9, paciente.getHistorico());
            stmt.setString(10, paciente.getAlergias());
            stmt.setString(11, paciente.getMedicamentosUtilizados());
            stmt.setString(12, paciente.getAnotacoes());
            stmt.setString(13, paciente.getEndereco().getCodEnd().toString());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            EnderecoController end = new EnderecoController();
            end.controlExcluirEnd(paciente.getEndereco());
            e.printStackTrace();
        } catch (Exception ex) {
            EnderecoController end = new EnderecoController();
            end.controlExcluirEnd(paciente.getEndereco());
            ex.printStackTrace();
        }
    }

    public ArrayList<Paciente> listarPacientes() {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;
        ArrayList<Paciente> pacientes;

        try {
            stmt = conexao.getConn().prepareStatement("select * from paciente");

            ResultSet rs = stmt.executeQuery();
            pacientes = new ArrayList<Paciente>();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setCodPaciente(rs.getInt("codPaciente"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setNome(rs.getString("nome"));
                paciente.setSobrenome(rs.getString("sobrenome"));
                paciente.setDataNascimento(getDateFromString2(rs.getString("dataNascimento")));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setCelular(rs.getString("celular"));
                paciente.setEmail(rs.getString("email"));
                paciente.setSexo(Sexo.valueOf(rs.getString("sexo").toUpperCase()));
                paciente.setHistorico(rs.getString("historico"));
                paciente.setAlergias(rs.getString("alergias"));
                paciente.setMedicamentosUtilizados(rs.getString("medicamentosUtilizados"));
                paciente.setAnotacoes(rs.getString("anotacoes"));
                pacientes.add(paciente);
            }

            rs.close();
            stmt.close();
            return pacientes;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Paciente getPacienteForId(Integer codPaciente){
        Conexao conexao = new Conexao();
        PreparedStatement stmt;

        try {
            stmt = conexao.getConn().prepareStatement("select * from paciente where codPaciente = ?");
            stmt.setString(1, codPaciente.toString());
            ResultSet rs = stmt.executeQuery();

            rs.next();
            Paciente paciente = new Paciente();
            paciente.setCodPaciente(rs.getInt("codPaciente"));
            paciente.setCpf(rs.getString("cpf"));
            paciente.setNome(rs.getString("nome"));
            paciente.setSobrenome(rs.getString("sobrenome"));
            paciente.setDataNascimento(getDateFromString2(rs.getString("dataNascimento")));
            paciente.setTelefone(rs.getString("telefone"));
            paciente.setCelular(rs.getString("celular"));
            paciente.setEmail(rs.getString("email"));
            paciente.setSexo(Sexo.valueOf(rs.getString("sexo").toUpperCase()));
            paciente.setHistorico(rs.getString("historico"));
            paciente.setAlergias(rs.getString("alergias"));
            paciente.setMedicamentosUtilizados(rs.getString("medicamentosUtilizados"));
            paciente.setAnotacoes(rs.getString("anotacoes"));
            paciente.setEndereco(new Endereco(rs.getInt("codEnd")));

            rs.close();
            stmt.close();
            return paciente;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void excluirPaciente(String cpf){
        Conexao conexao = new Conexao();
        String sql = "DELETE FROM paciente WHERE cpf = ?";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, cpf);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
