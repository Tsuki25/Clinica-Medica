package dao;

import control.EnderecoController;
import model.Endereco;
import model.Medico;
import model.enums.Sexo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static dao.FuncionarioDao.getNextCod;
import static model.utils.DateUtils.getDateFromString2;
import static model.utils.DateUtils.getStringFromDate1;

public class MedicoDao {
    public void salvar(Medico medico) {
        Conexao conexao = new Conexao();
        String sql = "INSERT INTO " +
                "medico (codFuncionario,cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, senha, crm,codEnd) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, getNextCod());
            stmt.setString(2, medico.getCpf());
            stmt.setString(3, medico.getNome());
            stmt.setString(4, medico.getSobrenome());
            stmt.setString(5, medico.getSexo());
            stmt.setString(6, getStringFromDate1(medico.getDataNascimento()));
            stmt.setString(7, medico.getTelefone());
            stmt.setString(8, medico.getCelular());
            stmt.setString(9, medico.getEmail());
            stmt.setString(10, medico.getSenha());
            stmt.setString(11, medico.getCrm());
            stmt.setString(12, medico.getEndereco().getCodEnd().toString());

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

    public ArrayList<Medico> listarMedicos() {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;
        ArrayList<Medico> medicos;

        try {
            stmt = conexao.getConn().prepareStatement("select * from medico");

            ResultSet rs = stmt.executeQuery();
            medicos = new ArrayList<Medico>();
            while (rs.next()) {
                Medico medico = new Medico();
                medico.setCodFuncionario(rs.getInt("codFuncionario"));
                medico.setCpf(rs.getString("cpf"));
                medico.setNome(rs.getString("nome"));
                medico.setSobrenome(rs.getString("sobrenome"));
                medico.setDataNascimento(getDateFromString2(rs.getString("dataNascimento")));
                medico.setTelefone(rs.getString("telefone"));
                medico.setCelular(rs.getString("celular"));
                medico.setEmail(rs.getString("email"));
                medico.setSexo(Sexo.valueOf(rs.getString("sexo").toUpperCase()));
                medico.setSenha(rs.getString("senha"));
                medico.setCrm(rs.getString("crm"));
                medico.setEndereco(new Endereco(rs.getInt("codEnd")));
                medicos.add(medico);
            }

            rs.close();
            stmt.close();
            return medicos;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Medico> listarMedicosBusca(String textoBusca) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;
        ArrayList<Medico> medicos;

        try {
            stmt = conexao.getConn().prepareStatement("SELECT * FROM medico WHERE codFuncionario = ? OR cpf LIKE ? OR nome LIKE ? OR sobrenome LIKE ?");
            stmt.setString(1, textoBusca);
            stmt.setString(2, "%" + textoBusca + "%");
            stmt.setString(3, "%" + textoBusca + "%");
            stmt.setString(4, "%" + textoBusca + "%");

            ResultSet rs = stmt.executeQuery();
            medicos = new ArrayList<Medico>();
            while (rs.next()) {
                Medico medico = new Medico();
                medico.setCodFuncionario(rs.getInt("codFuncionario"));
                medico.setCpf(rs.getString("cpf"));
                medico.setNome(rs.getString("nome"));
                medico.setSobrenome(rs.getString("sobrenome"));
                medico.setDataNascimento(getDateFromString2(rs.getString("dataNascimento")));
                medico.setTelefone(rs.getString("telefone"));
                medico.setCelular(rs.getString("celular"));
                medico.setEmail(rs.getString("email"));
                medico.setSexo(Sexo.valueOf(rs.getString("sexo").toUpperCase()));
                medico.setSenha(rs.getString("senha"));
                medico.setCrm(rs.getString("crm"));
                medico.setEndereco(new Endereco(rs.getInt("codEnd")));
                medicos.add(medico);
            }

            rs.close();
            stmt.close();
            return medicos;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
