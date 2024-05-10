package dao;

import control.EnderecoController;
import model.Recepcionista;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static model.utils.DateUtils.getStringFromDate1;

public class RecepcionistaDao {
    public void salvar(Recepcionista recepcionista) {
        Conexao conexao = new Conexao();
        String sql = "INSERT INTO " +
                "recepcionista (cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, senha, codEnd) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, recepcionista.getCpf());
            stmt.setString(2, recepcionista.getNome());
            stmt.setString(3, recepcionista.getSobrenome());
            stmt.setString(4, recepcionista.getSexo());
            stmt.setString(5, getStringFromDate1(recepcionista.getDataNascimento()));
            stmt.setString(6, recepcionista.getTelefone());
            stmt.setString(7, recepcionista.getCelular());
            stmt.setString(8, recepcionista.getEmail());
            stmt.setString(9, recepcionista.getSenha());
            stmt.setString(10, recepcionista.getEndereco().getCodEnd().toString());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            EnderecoController end = new EnderecoController();
            end.controlExcluirEnd(recepcionista.getEndereco());
            e.printStackTrace();
        } catch (Exception ex) {
            EnderecoController end = new EnderecoController();
            end.controlExcluirEnd(recepcionista.getEndereco());
            ex.printStackTrace();
        }
    }
}
