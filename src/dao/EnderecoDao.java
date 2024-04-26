package dao;

import model.Endereco;
import model.Paciente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static model.utils.DateUtils.getStringFromDate;

public class EnderecoDao {
    public void salvar(Endereco endereco) {
        Conexao conexao = new Conexao();
        String sql = "INSERT INTO " +
                "endereco (cep, logradouro, bairro, cidade, estado, numero, complemento) " +
                "VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, endereco.getCep().toString());
            stmt.setString(2, endereco.getLogradouro());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getEstado());
            stmt.setString(6, endereco.getNumero().toString());
            stmt.setString(7, endereco.getComplemento());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
