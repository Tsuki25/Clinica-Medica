package dao;

import control.EnderecoController;
import model.Endereco;
import model.Enfermeiro;
import model.enums.Sexo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static dao.FuncionarioDao.getNextCod;
import static model.utils.DateUtils.getDateFromString2;
import static model.utils.DateUtils.getStringFromDate1;

public class EnfermeiroDao {
    public void salvar(Enfermeiro enfermeira) {
        Conexao conexao = new Conexao();
        String sql = "INSERT INTO " +
                "enfermeiro (codFuncionario,cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, senha, cip, codEnd) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, getNextCod());
            stmt.setString(2, enfermeira.getCpf());
            stmt.setString(3, enfermeira.getNome());
            stmt.setString(4, enfermeira.getSobrenome());
            stmt.setString(5, enfermeira.getSexo());
            stmt.setString(6, getStringFromDate1(enfermeira.getDataNascimento()));
            stmt.setString(7, enfermeira.getTelefone());
            stmt.setString(8, enfermeira.getCelular());
            stmt.setString(9, enfermeira.getEmail());
            stmt.setString(10, enfermeira.getSenha());
            stmt.setString(11, enfermeira.getCip());
            stmt.setString(12, enfermeira.getEndereco().getCodEnd().toString());

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

    public ArrayList<Enfermeiro> listarEnfermeiros() {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;
        ArrayList<Enfermeiro> enfermeiros;

        try {
            stmt = conexao.getConn().prepareStatement("select * from enfermeiro");

            ResultSet rs = stmt.executeQuery();
            enfermeiros = new ArrayList<Enfermeiro>();
            while (rs.next()) {
                Enfermeiro enfermeiro = new Enfermeiro();
                enfermeiro.setCodFuncionario(rs.getInt("codFuncionario"));
                enfermeiro.setCpf(rs.getString("cpf"));
                enfermeiro.setNome(rs.getString("nome"));
                enfermeiro.setSobrenome(rs.getString("sobrenome"));
                enfermeiro.setDataNascimento(getDateFromString2(rs.getString("dataNascimento")));
                enfermeiro.setTelefone(rs.getString("telefone"));
                enfermeiro.setCelular(rs.getString("celular"));
                enfermeiro.setEmail(rs.getString("email"));
                enfermeiro.setSexo(Sexo.valueOf(rs.getString("sexo").toUpperCase()));
                enfermeiro.setSenha(rs.getString("senha"));
                enfermeiro.setCip(rs.getString("cip"));
                enfermeiro.setEndereco(new Endereco(rs.getInt("codEnd")));
                enfermeiros.add(enfermeiro);
            }

            rs.close();
            stmt.close();
            return enfermeiros;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Enfermeiro> listarEnfermeirosBusca(String textoBusca) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;
        ArrayList<Enfermeiro> enfermeiros;

        try {
            stmt = conexao.getConn().prepareStatement("SELECT * FROM enfermeiro WHERE codFuncionario = ? OR cpf LIKE ? OR nome LIKE ? OR sobrenome LIKE ?");
            stmt.setString(1, textoBusca);
            stmt.setString(2, "%" + textoBusca + "%");
            stmt.setString(3, "%" + textoBusca + "%");
            stmt.setString(4, "%" + textoBusca + "%");

            ResultSet rs = stmt.executeQuery();
            enfermeiros = new ArrayList<Enfermeiro>();
            while (rs.next()) {
                Enfermeiro enfermeiro = new Enfermeiro();
                enfermeiro.setCodFuncionario(rs.getInt("codFuncionario"));
                enfermeiro.setCpf(rs.getString("cpf"));
                enfermeiro.setNome(rs.getString("nome"));
                enfermeiro.setSobrenome(rs.getString("sobrenome"));
                enfermeiro.setDataNascimento(getDateFromString2(rs.getString("dataNascimento")));
                enfermeiro.setTelefone(rs.getString("telefone"));
                enfermeiro.setCelular(rs.getString("celular"));
                enfermeiro.setEmail(rs.getString("email"));
                enfermeiro.setSexo(Sexo.valueOf(rs.getString("sexo").toUpperCase()));
                enfermeiro.setSenha(rs.getString("senha"));
                enfermeiro.setCip(rs.getString("cip"));
                enfermeiro.setEndereco(new Endereco(rs.getInt("codEnd")));
                enfermeiros.add(enfermeiro);
            }

            rs.close();
            stmt.close();
            return enfermeiros;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
