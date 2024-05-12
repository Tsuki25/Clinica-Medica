package dao;

import control.EnderecoController;
import model.Agendamento;
import model.Endereco;
import model.Agendamento;
import model.Paciente;
import model.enums.Sexo;
import model.enums.StatusAgendamento;
import model.enums.TipoExame;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static control.EnfermeiroController.controlVerificarEnfermeiro;
import static control.MedicoController.controlVerificarMedico;
import static model.utils.DateUtils.*;

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

    public ArrayList<Agendamento> listarAgendamentos() {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;
        ArrayList<Agendamento> agendamentos;

        try {
            stmt = conexao.getConn().prepareStatement("select * from agendamento");

            ResultSet rs = stmt.executeQuery();
            agendamentos = new ArrayList<Agendamento>();
            while (rs.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setCodAgendamento(rs.getInt("codAgendamento"));
                agendamento.setExame(TipoExame.valueOf(rs.getString("exame").toUpperCase()));
                agendamento.setDataAgendamento(getDateFromString2(rs.getString("dataAgendamento")));
                agendamento.setHorarioAgendamento(getTimeFromString(rs.getString("horarioAgendamento")));
                agendamento.setStatus(StatusAgendamento.valueOf((rs.getString("statusAgendamento").toUpperCase())));
                agendamento.setCodPaciente(rs.getInt("codPaciente"));

                if(rs.getInt("codMedico") > 0)agendamento.setCodFuncionario(rs.getInt("codMedico"));
                else agendamento.setCodFuncionario(rs.getInt("codEnfermeiro"));
                agendamentos.add(agendamento);
            }

            rs.close();
            stmt.close();
            return agendamentos;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Agendamento> listarAgendamentosBusca(String textoBusca) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;
        ArrayList<Agendamento> agendamentos;

        try {
            stmt = conexao.getConn().prepareStatement("SELECT * FROM agendamento WHERE codPaciente = ? OR codAgendamento = ? OR codFuncionario = ? OR exame LIKE ? OR status LIKE ?");
            stmt.setString(1, textoBusca);
            stmt.setString(2, textoBusca);
            stmt.setString(3, textoBusca);
            stmt.setString(4, "%" + textoBusca + "%");
            stmt.setString(5, "%" + textoBusca + "%");

            ResultSet rs = stmt.executeQuery();
            agendamentos = new ArrayList<Agendamento>();
            while (rs.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setCodAgendamento(rs.getInt("codAgendamento"));
                agendamento.setExame(TipoExame.valueOf(rs.getString("exame").toUpperCase()));
                agendamento.setDataAgendamento(getDateFromString2(rs.getString("dataAgendamento")));
                agendamento.setHorarioAgendamento(getTimeFromString(rs.getString("horarioAgendamento")));
                agendamento.setStatus(StatusAgendamento.valueOf((rs.getString("statusAgendamento").toUpperCase())));
                agendamento.setCodPaciente(rs.getInt("codPaciente"));

                if(rs.getInt("codMedico") > 0)agendamento.setCodFuncionario(rs.getInt("codMedico"));
                else agendamento.setCodFuncionario(rs.getInt("codEnfermeiro"));
                agendamentos.add(agendamento);
            }

            rs.close();
            stmt.close();
            return agendamentos;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
