package dao;

import control.EnderecoController;
import model.Medico;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static model.utils.DateUtils.getStringFromDate1;

public class MedicoDao {
    public void salvar(Medico medico) {
        Conexao conexao = new Conexao();
        String sql = "INSERT INTO " +
                "medico (cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, senha, crm,codEnd) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, medico.getCpf());
            stmt.setString(2, medico.getNome());
            stmt.setString(3, medico.getSobrenome());
            stmt.setString(4, medico.getSexo());
            stmt.setString(5, getStringFromDate1(medico.getDataNascimento()));
            stmt.setString(6, medico.getTelefone());
            stmt.setString(7, medico.getCelular());
            stmt.setString(8, medico.getEmail());
            stmt.setString(9, medico.getSenha());
            stmt.setString(10, medico.getCrm());
            stmt.setString(11, medico.getEndereco().getCodEnd().toString());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            EnderecoController end = new EnderecoController();
            end.controlExcluirEnd(medico.getEndereco());
            e.printStackTrace();
        } catch (Exception ex) {
            EnderecoController end = new EnderecoController();
            end.controlExcluirEnd(medico.getEndereco());
            ex.printStackTrace();
        }
    }
}
