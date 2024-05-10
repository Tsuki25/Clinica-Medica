package dao;

import control.EnderecoController;
import model.Enfermeiro;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static model.utils.DateUtils.getStringFromDate1;

public class EnfermeiroDao {
    public void salvar(Enfermeiro enfermeira) {
        Conexao conexao = new Conexao();
        String sql = "INSERT INTO " +
                "enfermeira (cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, senha, cip, codEnd) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, enfermeira.getCpf());
            stmt.setString(2, enfermeira.getNome());
            stmt.setString(3, enfermeira.getSobrenome());
            stmt.setString(4, enfermeira.getSexo());
            stmt.setString(5, getStringFromDate1(enfermeira.getDataNascimento()));
            stmt.setString(6, enfermeira.getTelefone());
            stmt.setString(7, enfermeira.getCelular());
            stmt.setString(8, enfermeira.getEmail());
            stmt.setString(9, enfermeira.getSenha());
            stmt.setString(10, enfermeira.getCip());
            stmt.setString(11, enfermeira.getEndereco().getCodEnd().toString());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            EnderecoController end = new EnderecoController();
            end.controlExcluirEnd(enfermeira.getEndereco());
            e.printStackTrace();
        } catch (Exception ex) {
            EnderecoController end = new EnderecoController();
            end.controlExcluirEnd(enfermeira.getEndereco());
            ex.printStackTrace();
        }
    }
}
