package dao;

import model.Endereco;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

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

    public void atualizarEndereco(Endereco endereco){
        Conexao conexao = new Conexao();
        String sql = "UPDATE endereco " +
                "SET cep = ?, " + "logradouro = ?, " + "bairro = ?, " + "cidade = ?, " +
                "estado = ?, " + "numero = ?, " + "complemento = ? " +
                "WHERE codEnd = ?";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, endereco.getCep().toString());
            stmt.setString(2, endereco.getLogradouro());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getEstado());
            stmt.setString(6, endereco.getNumero().toString());
            stmt.setString(7, endereco.getComplemento());
            stmt.setString(8, endereco.getCodEnd().toString());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirEndereco(Integer codEnd){
        Conexao conexao = new Conexao();
        String sql = "DELETE FROM endereco WHERE codEnd = ?";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, codEnd.toString());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Endereco> listarEndereco() {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;
        ArrayList<Endereco> enderecos;

        try {
            stmt = conexao.getConn().prepareStatement("select * from endereco");

            ResultSet rs = stmt.executeQuery();
            enderecos = new ArrayList<Endereco>();
            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setCep(rs.getInt("cep"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                enderecos.add(endereco);
            }

            rs.close();
            stmt.close();
            return enderecos;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Endereco getEnderecoForId(Integer codEndereco){
        Conexao conexao = new Conexao();
        PreparedStatement stmt;

        try {
            stmt = conexao.getConn().prepareStatement("select * from endereco where codEnd= ?");
            stmt.setString(1, codEndereco.toString());
            ResultSet rs = stmt.executeQuery();

            rs.next();
            Endereco endereco = new Endereco();
            endereco.setCodEnd(codEndereco);
            endereco.setCep(rs.getInt("cep"));
            endereco.setLogradouro(rs.getString("logradouro"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setCidade(rs.getString("cidade"));
            endereco.setEstado(rs.getString("estado"));
            endereco.setNumero(rs.getInt("numero"));
            endereco.setComplemento(rs.getString("complemento"));

            rs.close();
            stmt.close();
            return endereco;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
