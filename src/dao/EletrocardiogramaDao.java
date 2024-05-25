package dao;

import model.exames.Eletrocardiograma;
import model.enums.TipoDiagnosticoPadrao;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import static control.EnfermeiroController.controlVerificarEnfermeiro;
import static control.MedicoController.controlVerificarMedico;
import static dao.ExameDao.getNextCodExame;

public class EletrocardiogramaDao {
    public Boolean salvar(Eletrocardiograma eletro) {
        Conexao conexao = new Conexao();
        String sql = "INSERT INTO " +
                "eletrocardiograma (codExame, codPaciente, peso, altura, convenio, ritmo, fc, diagClinico, conclusoes, codMedico, codEnfermeiro) " +
                "VALUES (?,?,?,?,?,?,?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, getNextCodExame());
            stmt.setString(2, eletro.getCodPaciente().toString());
            stmt.setString(3, eletro.getPeso().toString());
            stmt.setString(4, eletro.getAltura().toString());
            stmt.setString(5, eletro.getConvenio());
            stmt.setString(6, eletro.getRitmoCardiaco());
            stmt.setString(7, eletro.getFuncaoCardiaca().toString());
            stmt.setString(8, eletro.getDiagnostico().toString());
            stmt.setString(9, eletro.getConclusoes());

            if(controlVerificarMedico(eletro.getCodFuncionario()) > 0){//CONTOU-SE REGISTROS COM ESTE CODIGO NO MEDICO, PORTANTO É UM MEDICO
                stmt.setString(10, eletro.getCodFuncionario().toString());
                stmt.setString(11, null);
            }else if(controlVerificarEnfermeiro(eletro.getCodFuncionario()) > 0){//CONTOU-SE REGISTROS COM ESTE CODIGO NO ENFERMEIRO, PORTANTO É UM ENFERMEIRO
                stmt.setString(10, null);
                stmt.setString(11, eletro.getCodFuncionario().toString());
            }

            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLIntegrityConstraintViolationException sqlcve) {
            JOptionPane.showMessageDialog(null, "O codigo de funcionario deve se referenciar a um Médico ou Enfermeiro");
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Dados inválidos");
            e.printStackTrace();
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void atualizarEletrocardiograma(Eletrocardiograma eletro){
        Conexao conexao = new Conexao();
        String sql = "UPDATE eletrocardiograma " +
                "SET codPaciente = ?, " + "peso = ?, " + "altura = ?, " + "convenio = ?, " +
                "ritmo = ?, " + "fc = ?, " + "diagClinico = ?," + "conclusoes = ?," + "codMedico = ?," + "codEnfermeiro = ? " +
                "WHERE codExame = ?";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, eletro.getCodPaciente().toString());
            stmt.setString(2, eletro.getPeso().toString());
            stmt.setString(3, eletro.getAltura().toString());
            stmt.setString(4, eletro.getConvenio());
            stmt.setString(5, eletro.getRitmoCardiaco());
            stmt.setString(6, eletro.getFuncaoCardiaca().toString());
            stmt.setString(7, eletro.getDiagnostico().toString());
            stmt.setString(8, eletro.getConclusoes());

            if(controlVerificarMedico(eletro.getCodFuncionario()) > 0){//CONTOU-SE REGISTROS COM ESTE CODIGO NO MEDICO, PORTANTO É UM MEDICO
                stmt.setString(9, eletro.getCodFuncionario().toString());
                stmt.setString(10, null);
            }else if(controlVerificarEnfermeiro(eletro.getCodFuncionario()) > 0){//CONTOU-SE REGISTROS COM ESTE CODIGO NO ENFERMEIRO, PORTANTO É UM ENFERMEIRO
                stmt.setString(9, null);
                stmt.setString(10, eletro.getCodFuncionario().toString());
            }
            stmt.setString(11, eletro.getCodExame().toString());

            stmt.execute();
            stmt.close();
        } catch (SQLIntegrityConstraintViolationException sqlcve) {
            JOptionPane.showMessageDialog(null, "O codigo de funcionario deve se referenciar a um Médico ou Enfermeiro");

        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Dados inválidos");
            e.printStackTrace();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Eletrocardiograma> listarEletrocardiogramas() {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;
        ArrayList<Eletrocardiograma> eletrocardiogramas;

        try {
            stmt = conexao.getConn().prepareStatement("select * from eletrocardiograma");

            ResultSet rs = stmt.executeQuery();
            eletrocardiogramas = new ArrayList<Eletrocardiograma>();
            while (rs.next()) {
                Eletrocardiograma eletrocardiograma = new Eletrocardiograma();
                eletrocardiograma.setCodExame(rs.getInt("codExame"));
                eletrocardiograma.setCodPaciente(Integer.parseInt(rs.getString("codPaciente")));
                eletrocardiograma.setPeso(Double.parseDouble(rs.getString("peso")));
                eletrocardiograma.setAltura(Double.parseDouble(rs.getString("altura")));
                eletrocardiograma.setConvenio(rs.getString("convenio"));
                eletrocardiograma.setRitmoCardiaco(rs.getString("ritmo"));
                eletrocardiograma.setFuncaoCardiaca(Integer.parseInt(rs.getString("fc")));
                eletrocardiograma.setDiagnostico(TipoDiagnosticoPadrao.valueOf(rs.getString("diagClinico").toUpperCase()));
                eletrocardiograma.setConclusoes(rs.getString("conclusoes"));

                if(rs.getInt("codMedico") > 0)eletrocardiograma.setCodFuncionario(rs.getInt("codMedico"));
                else eletrocardiograma.setCodFuncionario(rs.getInt("codEnfermeiro"));

                eletrocardiogramas.add(eletrocardiograma);
            }

            rs.close();
            stmt.close();
            return eletrocardiogramas;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Eletrocardiograma> listarEletrocardiogramasBusca(String textoBusca) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;
        ArrayList<Eletrocardiograma> eletrocardiogramas;

        try {
            stmt = conexao.getConn().prepareStatement("SELECT * FROM eletrocardiograma WHERE codExame = ? OR codPaciente = ? or codMedico = ? or codEnfermeiro = ? or diagClinico LIKE ?");
            stmt.setString(1, textoBusca);
            stmt.setString(2, textoBusca);
            stmt.setString(3, textoBusca);
            stmt.setString(4, textoBusca);
            stmt.setString(5, "%" + textoBusca + "%");

            ResultSet rs = stmt.executeQuery();
            eletrocardiogramas = new ArrayList<Eletrocardiograma>();
            while (rs.next()) {
                Eletrocardiograma eletrocardiograma = new Eletrocardiograma();
                eletrocardiograma.setCodExame(rs.getInt("codExame"));
                eletrocardiograma.setCodPaciente(Integer.parseInt(rs.getString("codPaciente")));
                eletrocardiograma.setPeso(Double.parseDouble(rs.getString("peso")));
                eletrocardiograma.setAltura(Double.parseDouble(rs.getString("altura")));
                eletrocardiograma.setConvenio(rs.getString("convenio"));
                eletrocardiograma.setRitmoCardiaco(rs.getString("ritmo"));
                eletrocardiograma.setFuncaoCardiaca(Integer.parseInt(rs.getString("fc")));
                eletrocardiograma.setDiagnostico(TipoDiagnosticoPadrao.valueOf(rs.getString("diagClinico").toUpperCase()));
                eletrocardiograma.setConclusoes(rs.getString("conclusoes"));

                if(rs.getInt("codMedico") > 0)eletrocardiograma.setCodFuncionario(rs.getInt("codMedico"));
                else eletrocardiograma.setCodFuncionario(rs.getInt("codEnfermeiro"));

                eletrocardiogramas.add(eletrocardiograma);
            }

            rs.close();
            stmt.close();
            return eletrocardiogramas;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Eletrocardiograma getEletrocardiogramaForId(Integer codExame) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;

        try {
            stmt = conexao.getConn().prepareStatement("SELECT * FROM eletrocardiograma WHERE codExame = ?");
            stmt.setString(1, codExame.toString());
            ResultSet rs = stmt.executeQuery();

            rs.next();
            Eletrocardiograma eletrocardiograma = new Eletrocardiograma();
            eletrocardiograma.setCodExame(codExame);
            eletrocardiograma.setCodPaciente(Integer.parseInt(rs.getString("codPaciente")));
            eletrocardiograma.setPeso(Double.parseDouble(rs.getString("peso")));
            eletrocardiograma.setAltura(Double.parseDouble(rs.getString("altura")));
            eletrocardiograma.setConvenio(rs.getString("convenio"));
            eletrocardiograma.setRitmoCardiaco(rs.getString("ritmo"));
            eletrocardiograma.setFuncaoCardiaca(Integer.parseInt(rs.getString("fc")));
            eletrocardiograma.setDiagnostico(TipoDiagnosticoPadrao.valueOf(rs.getString("diagClinico").toUpperCase()));
            eletrocardiograma.setConclusoes(rs.getString("conclusoes"));

            if(rs.getInt("codMedico") > 0)eletrocardiograma.setCodFuncionario(rs.getInt("codMedico"));
            else eletrocardiograma.setCodFuncionario(rs.getInt("codEnfermeiro"));

            rs.close();
            stmt.close();
            return eletrocardiograma;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void excluirEletrocardiograma(Integer codExame) {
        Conexao conexao = new Conexao();
        String sql = "DELETE FROM eletrocardiograma WHERE codExame = ?";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, codExame.toString());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Integer getPacienteForExame(Integer codExame) {
        Conexao conexao = new Conexao();
        String sql = "SELECT codPaciente FROM eletrocardiograma WHERE codExame = ?";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, codExame.toString());
            ResultSet rs = stmt.executeQuery();

            rs.next();
            Integer codPaciente = Integer.parseInt(rs.getString("codPaciente"));

            stmt.execute();
            stmt.close();
            return codPaciente;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
