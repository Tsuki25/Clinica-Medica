package dao;

import model.Agenda;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import static control.EnfermeiroController.controlVerificarEnfermeiro;
import static control.MedicoController.controlVerificarMedico;
import static model.utils.DateUtils.*;

public class AgendaDao {

    public Boolean salvar(Agenda agenda) {
        Conexao conexao = new Conexao();
        String sql = "INSERT INTO " +
                "agenda (dataReserva, horarioInicio, horarioFim, motivo, codMedico, codEnfermeiro) " +
                "VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, getStringFromDate1(agenda.getDataReserva()));
            stmt.setString(2, getStringFromTime(agenda.getHorarioInicio()));
            stmt.setString(3, getStringFromTime(agenda.getHorarioFim()));
            stmt.setString(4, agenda.getMotivo());

            if(controlVerificarMedico(agenda.getCodFuncionario()) > 0){//CONTOU-SE REGISTROS COM ESTE CODIGO NO MEDICO, PORTANTO É UM MEDICO
                stmt.setString(5, agenda.getCodFuncionario().toString());
                stmt.setString(6, null);
            }else if(controlVerificarEnfermeiro(agenda.getCodFuncionario()) > 0){//CONTOU-SE REGISTROS COM ESTE CODIGO NO ENFERMEIRO, PORTANTO É UM ENFERMEIRO
                stmt.setString(5, null);
                stmt.setString(6, agenda.getCodFuncionario().toString());
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

    public void atualizarAgenda(Agenda agenda){
        Conexao conexao = new Conexao();
        String sql = "UPDATE agenda " +
                "SET dataReserva = ?, " + "horarioInicio= ?, " + "horarioFim = ?, " + "motivo= ?, " +
                "codMedico = ?, " + "codEnfermeiro = ? " +
                "WHERE codAgenda = ?";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, getStringFromDate1(agenda.getDataReserva()));
            stmt.setString(2, getStringFromTime(agenda.getHorarioInicio()));
            stmt.setString(3, getStringFromTime(agenda.getHorarioFim()));
            stmt.setString(4, agenda.getMotivo());

            if(controlVerificarMedico(agenda.getCodFuncionario()) > 0){//CONTOU-SE REGISTROS COM ESTE CODIGO NO MEDICO, PORTANTO É UM MEDICO
                stmt.setString(5, agenda.getCodFuncionario().toString());
                stmt.setString(6, null);
            }else if(controlVerificarEnfermeiro(agenda.getCodFuncionario()) > 0){//CONTOU-SE REGISTROS COM ESTE CODIGO NO ENFERMEIRO, PORTANTO É UM ENFERMEIRO
                stmt.setString(5, null);
                stmt.setString(6, agenda.getCodFuncionario().toString());
            }

            stmt.setString(7, agenda.getCodAgenda().toString());

            stmt.execute();
            stmt.close();

        } catch (SQLIntegrityConstraintViolationException sqlcve) {
            JOptionPane.showMessageDialog(null, "O codigo de funcionario deve se referenciar a um Médico ou Enfermeiro");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Dados inválidos");
            e.printStackTrace();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Agenda> listarAgendas() {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;
        ArrayList<Agenda> agendas;

        try {
            stmt = conexao.getConn().prepareStatement("select * from agenda");

            ResultSet rs = stmt.executeQuery();
            agendas = new ArrayList<Agenda>();
            while (rs.next()) {
                Agenda agenda = new Agenda();
                agenda.setCodAgenda(rs.getInt("codAgenda"));
                agenda.setDataReserva(getDateFromString2(rs.getString("dataReserva")));
                agenda.setHorarioInicio(getTimeFromString2(rs.getString("horarioInicio")));
                agenda.setHorarioFim(getTimeFromString2(rs.getString("horarioFim")));
                agenda.setMotivo((rs.getString("motivo")));
                if(rs.getInt("codMedico") > 0)agenda.setCodFuncionario(rs.getInt("codMedico"));
                else agenda.setCodFuncionario(rs.getInt("codEnfermeiro"));

                agendas.add(agenda);
            }

            rs.close();
            stmt.close();
            return agendas;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Agenda getAgendaForId(Integer codAgenda) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;

        try {
            stmt = conexao.getConn().prepareStatement("select * from agenda where codAgenda = ?");
            stmt.setString(1, codAgenda.toString());
            ResultSet rs = stmt.executeQuery();

            rs.next();
            Agenda agenda = new Agenda();
            agenda.setCodAgenda(rs.getInt("codAgenda"));
            agenda.setDataReserva(getDateFromString2(rs.getString("dataReserva")));
            agenda.setHorarioInicio(getTimeFromString2(rs.getString("horarioInicio")));
            agenda.setHorarioFim(getTimeFromString2(rs.getString("horarioFim")));
            agenda.setMotivo((rs.getString("motivo")));
            if(rs.getInt("codMedico") > 0)agenda.setCodFuncionario(rs.getInt("codMedico"));
            else agenda.setCodFuncionario(rs.getInt("codEnfermeiro"));

            rs.close();
            stmt.close();
            return agenda;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Agenda> listarAgendasBusca(String textoBusca) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;
        ArrayList<Agenda> agendas;

        try {
            stmt = conexao.getConn().prepareStatement("SELECT * FROM agenda WHERE " +
                    "codAgenda = ? OR dataReserva = ? OR  horaInicio = ? OR horaFim = ? OR codMedico = ? OR codEnfermeiro = ? OR motivo LIKE ?");
            stmt.setString(1, textoBusca);
            stmt.setString(2, textoBusca);
            stmt.setString(3, textoBusca);
            stmt.setString(4, textoBusca);
            stmt.setString(5, textoBusca);
            stmt.setString(6, textoBusca);
            stmt.setString(7, "%" + textoBusca.toUpperCase() + "%");

            ResultSet rs = stmt.executeQuery();
            agendas = new ArrayList<Agenda>();
            while (rs.next()) {
                Agenda agenda = new Agenda();
                agenda.setCodAgenda(rs.getInt("codAgenda"));
                agenda.setDataReserva(getDateFromString2(rs.getString("dataReserva")));
                agenda.setHorarioInicio(getTimeFromString2(rs.getString("horarioInicio")));
                agenda.setHorarioFim(getTimeFromString2(rs.getString("horarioFim")));
                agenda.setMotivo((rs.getString("motivo")));
                if(rs.getInt("codMedico") > 0)agenda.setCodFuncionario(rs.getInt("codMedico"));
                else agenda.setCodFuncionario(rs.getInt("codEnfermeiro"));

                agendas.add(agenda);
            }

            rs.close();
            stmt.close();
            return agendas;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void excluirAgenda(Integer codAgenda) {
        Conexao conexao = new Conexao();
        String sql = "DELETE FROM agenda WHERE codAgenda = ?";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, codAgenda.toString());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Agenda> listarAgendaFuncDia(Agenda agendaAux){
        Conexao conexao = new Conexao();
        PreparedStatement stmt;
        ArrayList<Agenda> agendas = new ArrayList<>();

        try {
            stmt = conexao.getConn().prepareStatement("select * from agenda where dataReserva = ? and (codMedico = ? or codEnfermeiro = ?)");
            stmt.setString(1, getStringFromDate1(agendaAux.getDataReserva()));
            stmt.setString(2, agendaAux.getCodFuncionario().toString());
            stmt.setString(3, agendaAux.getCodFuncionario().toString());
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Agenda agenda = new Agenda();
                agenda.setCodAgenda(rs.getInt("codAgenda"));
                agenda.setDataReserva(getDateFromString2(rs.getString("dataReserva")));
                agenda.setHorarioInicio(getTimeFromString2(rs.getString("horarioInicio")));
                agenda.setHorarioFim(getTimeFromString2(rs.getString("horarioFim")));
                agenda.setMotivo((rs.getString("motivo")));
                if(rs.getInt("codMedico") > 0)agenda.setCodFuncionario(rs.getInt("codMedico"));
                else agenda.setCodFuncionario(rs.getInt("codEnfermeiro"));
                agendas.add(agenda);

            }
            rs.close();
            stmt.close();
            return agendas;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
