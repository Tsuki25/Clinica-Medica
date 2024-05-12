package dao;

import control.EnderecoController;
import model.Agendamento;
import model.Paciente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static control.EnfermeiroController.controlVerificarEnfermeiro;
import static control.MedicoController.controlVerificarMedico;
import static model.utils.DateUtils.getStringFromDate1;
import static model.utils.DateUtils.getStringFromTime;

public class AgendamentoDao {
    public void salvar(Agendamento agendamento) {
        Conexao conexao = new Conexao();
        String sql = "INSERT INTO " +
                "agendamento (dataAgendamento, horarioAgendamento, statusAgendamento, exame, codMedico, codEnfermeiro, codPaciente) " +
                "VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, getStringFromDate1(agendamento.getDataAgendamento()));
            stmt.setString(2, getStringFromTime(agendamento.getHorarioAgendamento()));
            stmt.setString(3, agendamento.getStatus().getDescricao());
            stmt.setString(4, agendamento.getExame().getTipo());

            if(controlVerificarMedico(agendamento.getCodFuncionario()) > 0){//CONTOU-SE REGISTROS COM ESTE CODIGO NO MEDICO, PORTANTO É UM MEDICO
                stmt.setString(5, agendamento.getCodFuncionario().toString());
                stmt.setString(6, null);
            }else{//CONTOU-SE REGISTROS COM ESTE CODIGO NO ENFERMEIRO, PORTANTO É UM ENFERMEIRO
                stmt.setString(5, null);
                stmt.setString(6, agendamento.getCodFuncionario().toString());
            }
            stmt.setString(7, agendamento.getCodPaciente().toString());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
