package dao;

import model.exames.Eletrocardiograma;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import static control.EnfermeiroController.controlVerificarEnfermeiro;
import static control.MedicoController.controlVerificarMedico;
import static dao.ExameDao.getNextCodExame;
import static model.utils.DateUtils.getStringFromDate1;
import static model.utils.DateUtils.getStringFromTime;

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
            stmt.setString(8, eletro.getDiagnosticoText());
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
    
}
