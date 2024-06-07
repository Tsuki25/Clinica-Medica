package dao;

import control.EnderecoController;
import model.Endereco;
import model.Recepcionista;
import model.enums.Sexo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static dao.FuncionarioDao.getNextCod;
import static model.utils.DateUtils.getDateFromString2;
import static model.utils.DateUtils.getStringFromDate1;

public class RecepcionistaDao {
    public void salvar(Recepcionista recepcionista) {
        Conexao conexao = new Conexao();
        String sql = "INSERT INTO " +
                "recepcionista (codFuncionario,cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, senha, codEnd) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, getNextCod());
            stmt.setString(2, recepcionista.getCpf());
            stmt.setString(3, recepcionista.getNome());
            stmt.setString(4, recepcionista.getSobrenome());
            stmt.setString(5, recepcionista.getSexo());
            stmt.setString(6, getStringFromDate1(recepcionista.getDataNascimento()));
            stmt.setString(7, recepcionista.getTelefone());
            stmt.setString(8, recepcionista.getCelular());
            stmt.setString(9, recepcionista.getEmail());
            stmt.setString(10, recepcionista.getSenha());
            stmt.setString(11, recepcionista.getEndereco().getCodEnd().toString());

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

    public void atualizarRecepcionista(Recepcionista recepcionista){
        Conexao conexao = new Conexao();
        String sql = "UPDATE recepcionista " +
                "SET nome = ?, " + "sobrenome = ?, " + "sexo = ?, " + "dataNascimento = ?, " +
                "telefone = ?, " + "celular = ?, " + "email = ?, " +
                "senha = ?, " + "codEnd = ? " +
                "WHERE cpf = ?";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, recepcionista.getNome());
            stmt.setString(2, recepcionista.getSobrenome());
            stmt.setString(3, recepcionista.getSexo());
            stmt.setString(4, getStringFromDate1(recepcionista.getDataNascimento()));
            stmt.setString(5, recepcionista.getTelefone());
            stmt.setString(6, recepcionista.getCelular());
            stmt.setString(7, recepcionista.getEmail());
            stmt.setString(8, recepcionista.getSenha());
            stmt.setString(9, recepcionista.getEndereco().getCodEnd().toString());

            stmt.setString(10, recepcionista.getCpf());// PARAMETRO DE IDENTIFICAÇÃO DA ALTERAÇÃO

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Recepcionista> listarRecepcionistas() {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;
        ArrayList<Recepcionista> recepcionistas;

        try {
            stmt = conexao.getConn().prepareStatement("select * from recepcionista");

            ResultSet rs = stmt.executeQuery();
            recepcionistas = new ArrayList<Recepcionista>();
            while (rs.next()) {
                Recepcionista recepcionista = new Recepcionista();
                recepcionista.setCodFuncionario(rs.getInt("codFuncionario"));
                recepcionista.setCpf(rs.getString("cpf"));
                recepcionista.setNome(rs.getString("nome"));
                recepcionista.setSobrenome(rs.getString("sobrenome"));
                recepcionista.setDataNascimento(getDateFromString2(rs.getString("dataNascimento")));
                recepcionista.setTelefone(rs.getString("telefone"));
                recepcionista.setCelular(rs.getString("celular"));
                recepcionista.setEmail(rs.getString("email"));
                recepcionista.setSexo(Sexo.valueOf(rs.getString("sexo").toUpperCase()));
                recepcionista.setSenha(rs.getString("senha"));
                recepcionista.setEndereco(new Endereco(rs.getInt("codEnd")));
                recepcionistas.add(recepcionista);
            }

            rs.close();
            stmt.close();
            return recepcionistas;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Recepcionista> listarRecepcionistasBusca(String textoBusca) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;
        ArrayList<Recepcionista> recepcionistas;

        try {
            stmt = conexao.getConn().prepareStatement("SELECT * FROM recepcionista WHERE codFuncionario = ? OR cpf LIKE ? OR nome LIKE ? OR sobrenome LIKE ?");
            stmt.setString(1, textoBusca);
            stmt.setString(2, "%" + textoBusca + "%");
            stmt.setString(3, "%" + textoBusca + "%");
            stmt.setString(4, "%" + textoBusca + "%");

            ResultSet rs = stmt.executeQuery();
            recepcionistas = new ArrayList<Recepcionista>();
            while (rs.next()) {
                Recepcionista recepcionista = new Recepcionista();
                recepcionista.setCodFuncionario(rs.getInt("codFuncionario"));
                recepcionista.setCpf(rs.getString("cpf"));
                recepcionista.setNome(rs.getString("nome"));
                recepcionista.setSobrenome(rs.getString("sobrenome"));
                recepcionista.setDataNascimento(getDateFromString2(rs.getString("dataNascimento")));
                recepcionista.setTelefone(rs.getString("telefone"));
                recepcionista.setCelular(rs.getString("celular"));
                recepcionista.setEmail(rs.getString("email"));
                recepcionista.setSexo(Sexo.valueOf(rs.getString("sexo").toUpperCase()));
                recepcionista.setSenha(rs.getString("senha"));
                recepcionista.setEndereco(new Endereco(rs.getInt("codEnd")));
                recepcionistas.add(recepcionista);
            }

            rs.close();
            stmt.close();
            return recepcionistas;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Recepcionista getRecepcionistaForId(Integer codFuncionario) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;

        try {
            stmt = conexao.getConn().prepareStatement("SELECT * FROM recepcionista WHERE codFuncionario = ?");
            stmt.setString(1, codFuncionario.toString());
            ResultSet rs = stmt.executeQuery();

            rs.next();
            Recepcionista recepcionista = new Recepcionista();
            recepcionista.setCodFuncionario(rs.getInt("codFuncionario"));
            recepcionista.setCpf(rs.getString("cpf"));
            recepcionista.setNome(rs.getString("nome"));
            recepcionista.setSobrenome(rs.getString("sobrenome"));
            recepcionista.setDataNascimento(getDateFromString2(rs.getString("dataNascimento")));
            recepcionista.setTelefone(rs.getString("telefone"));
            recepcionista.setCelular(rs.getString("celular"));
            recepcionista.setEmail(rs.getString("email"));
            recepcionista.setSexo(Sexo.valueOf(rs.getString("sexo").toUpperCase()));
            recepcionista.setSenha(rs.getString("senha"));
            recepcionista.setEndereco(new Endereco(rs.getInt("codEnd")));

            rs.close();
            stmt.close();
            return recepcionista;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void excluirRecepcionista(String cpf) {
        Conexao conexao = new Conexao();
        String sql = "DELETE FROM recepcionista WHERE cpf = ?";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, cpf);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getCodEnderecoForRecepcionista(String cpf) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;

        try {
            stmt = conexao.getConn().prepareStatement("select codEnd from recepcionista where cpf = ?");
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            return rs.getInt("codEnd");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
