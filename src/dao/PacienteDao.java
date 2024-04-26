package dao;

import model.Paciente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            stmt.setString(5, getStringFromDate(paciente.getDataNascimento()));
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
            e.printStackTrace();
        }
    }
}
