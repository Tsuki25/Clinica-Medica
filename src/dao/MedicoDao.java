package dao;

import control.EnderecoController;
import model.Endereco;
import model.Medico;
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

    public void atualizarMedico(Medico medico){
        Conexao conexao = new Conexao();
        String sql = "UPDATE medico " +
                "SET nome = ?, " + "sobrenome = ?, " + "sexo = ?, " + "dataNascimento = ?, " +
                "telefone = ?, " + "celular = ?, " + "email = ?, " +
                "senha = ?, " + "crm = ?, " + "codEnd = ? " +
                "WHERE cpf = ?";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getSobrenome());
            stmt.setString(3, medico.getSexo());
            stmt.setString(4, getStringFromDate1(medico.getDataNascimento()));
            stmt.setString(5, medico.getTelefone());
            stmt.setString(6, medico.getCelular());
            stmt.setString(7, medico.getEmail());
            stmt.setString(8, medico.getSenha());
            stmt.setString(9, medico.getCrm());
            stmt.setString(10, medico.getEndereco().getCodEnd().toString());

            stmt.setString(11, medico.getCpf());// PARAMETRO DE IDENTIFICAÇÃO DA ALTERAÇÃO

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception ex) {
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

    public Medico getMedicoForId(Integer codFuncionario) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;

        try {
            stmt = conexao.getConn().prepareStatement("select * from medico where codFuncionario = ?");
            stmt.setString(1, codFuncionario.toString());
            ResultSet rs = stmt.executeQuery();

            rs.next();
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

            rs.close();
            stmt.close();
            return medico;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void excluirMedico(String cpf) {
        Conexao conexao = new Conexao();
        String sql = "DELETE FROM medico WHERE cpf = ?";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, cpf);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getCodEnderecoForMedico(String cpf) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;

        try {
            stmt = conexao.getConn().prepareStatement("select codEnd from medico where cpf = ?");
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            return rs.getInt("codEnd");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer verificarMedico(Integer codFuncionario) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;

        try {
            stmt = conexao.getConn().prepareStatement("select count(*) as total from medico where codFuncionario = ?");
            stmt.setString(1, codFuncionario.toString());
            ResultSet rs = stmt.executeQuery();

            rs.next();
            return rs.getInt("total");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
