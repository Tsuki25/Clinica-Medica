package dao;

import model.Endereco;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class EnderecoDao {
    public Endereco salvar(Endereco endereco) {
        Conexao conexao = new Conexao();
        String sql = "INSERT INTO " +
                "endereco (cep, logradouro, bairro, cidade, estado, numero, complemento) " +
                "VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, endereco.getCep().toString());
            stmt.setString(2, endereco.getLogradouro());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getEstado());
            stmt.setString(6, endereco.getNumero().toString());
            stmt.setString(7, endereco.getComplemento());

            // Obtendo o ID gerado no banco para o endereco
            if(stmt.executeUpdate() >= 1){
                ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next()) endereco.setCodEnd(rs.getInt(1));//insere o codigo obtido ao objeto endereco
            }
            stmt.close();
            return endereco;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
