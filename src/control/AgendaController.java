package control;

import dao.AgendaDao;
import dao.AgendaDao;
import dao.AgendaDao;
import dao.AgendamentoDao;
import model.*;
import model.Agenda;
import model.Agenda;
import view.FormularioAgendaPanel;
import view.FormularioAgendamentoPanel;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;

import static model.utils.DateUtils.getDateFromString1;
import static model.utils.DateUtils.getTimeFromString;

public class AgendaController {
    public Boolean controlSalvar(FormularioAgendaPanel cadastroPanel) {
        try{
            Agenda agenda = new Agenda();
            agenda.setCodFuncionario(Integer.parseInt(cadastroPanel.getTfCodFuncionario().getText()));
            agenda.setDataReserva(getDateFromString1(cadastroPanel.getFtfDataReserva().getText()));
            agenda.setHorarioInicio(getTimeFromString(cadastroPanel.getFtfIntervaloInicio().getText()));
            agenda.setHorarioFim(getTimeFromString(cadastroPanel.getFtfIntervaloFim().getText()));
            agenda.setMotivo(cadastroPanel.getTfMotivo().getText());

            if(verificarDisponibilidadeAgenda(agenda)){ // verifica a validade das dats informadas
                AgendaDao agendaDao = new AgendaDao();
                if(agendaDao.salvar(agenda)){
                    JOptionPane.showMessageDialog(null, "Agendamento realizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
                return true;
            }

            return false;

        }catch(InputMismatchException ime){
            ime.printStackTrace();
            return null;
        }catch(MissingFormatArgumentException mfae){
            mfae.printStackTrace();
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Agenda controlAtualizarAgenda(FormularioAgendaPanel updatePanel, Agenda agendaEditado){
        try{
            Agenda agenda = new Agenda();
            agenda.setCodFuncionario(Integer.parseInt(updatePanel.getTfCodFuncionario().getText()));
            agenda.setDataReserva(getDateFromString1(updatePanel.getFtfDataReserva().getText()));
            agenda.setHorarioInicio(getTimeFromString(updatePanel.getFtfIntervaloInicio().getText()));
            agenda.setHorarioFim(getTimeFromString(updatePanel.getFtfIntervaloFim().getText()));
            agenda.setMotivo(updatePanel.getTfMotivo().getText());
            agenda.setCodAgenda(agendaEditado.getCodAgenda());

            if(verificarValidadeHorarios(agenda)){ // verifica a validade das dats informadas
                AgendaDao agendaDao = new AgendaDao();
                agendaDao.atualizarAgenda(agenda);
                return agenda;
            }

            return agendaEditado; //Assegura um retorno de dados corretos(agenda SENDO EDITADO), independente de possiveis erros de inserção de data e hora

        }catch(InputMismatchException ime){
            ime.printStackTrace();
            return null;

        }catch(MissingFormatArgumentException mfae){
            mfae.printStackTrace();
            return null;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void controlExcluirAgenda(Agenda agenda){
        AgendaDao agendaDao = new AgendaDao();
        agendaDao.excluirAgenda(agenda.getCodAgenda());
    }

    public ArrayList<Agenda> controlListarAgendas(){
        AgendaDao agendaDao = new AgendaDao();
        return agendaDao.listarAgendas();
    }

    public ArrayList<Agenda> controlListarAgendasBusca(String textoBusca){
        AgendaDao agendaDao = new AgendaDao();
        return agendaDao.listarAgendasBusca(textoBusca);
    }

    public Agenda controlBuscarAgendaForId(Integer codAgenda){
        AgendaDao pd = new AgendaDao();
        return pd.getAgendaForId(codAgenda);
    }

    public Boolean verificarDisponibilidadeAgenda(Agenda agenda) {
        AgendaDao agendaDao = new AgendaDao();

        if (agenda.getDataReserva().isBefore(LocalDate.now())) { // VERIFICA SE A DATA É ANTERIOR A HOJE
            JOptionPane.showMessageDialog(null, "A data de agenda não pode ser anterior a hoje", "Data Inválida", JOptionPane.INFORMATION_MESSAGE);
            return false;

        } else if (agenda.getHorarioInicio().isBefore(LocalTime.of(8, 0)) || agenda.getHorarioInicio().isAfter(LocalTime.of(18, 0)) || agenda.getHorarioFim().isBefore(LocalTime.of(8, 0)) || agenda.getHorarioFim().isAfter(LocalTime.of(18, 0))) {
            JOptionPane.showMessageDialog(null, "Apenas em horário comercial", "Horário Inválido", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }else if(agenda.getHorarioFim().isBefore(agenda.getHorarioInicio())){
            JOptionPane.showMessageDialog(null, "O horario de finalização deve ser maior que o de inicio", "Horário Inválido", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        ArrayList<Agenda> agendas = agendaDao.listarAgendaFuncDia(agenda);
        for (Agenda agendaIterator : agendas) {
            if(agenda.getHorarioInicio().isAfter(agendaIterator.getHorarioInicio()) && agenda.getHorarioInicio().isBefore(agendaIterator.getHorarioFim())  || agenda.getHorarioInicio().equals(agendaIterator.getHorarioInicio())) {
                JOptionPane.showMessageDialog(null, "Horario já preenchido, de: " + agendaIterator.getHorarioInicio() + " - até: " + agendaIterator.getHorarioFim(), "Agenda Inválido", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        }

        return true; // cadastro validado para todas as datas possivelmente invalida ou indisponiveis

    }

    public Boolean verificarValidadeHorarios(Agenda agenda) {
        AgendaDao agendaDao = new AgendaDao();

        if (agenda.getDataReserva().isBefore(LocalDate.now())) { // VERIFICA SE A DATA É ANTERIOR A HOJE
            JOptionPane.showMessageDialog(null, "A data de agenda não pode ser anterior a hoje", "Data Inválida", JOptionPane.INFORMATION_MESSAGE);
            return false;

        } else if (agenda.getHorarioInicio().isBefore(LocalTime.of(8, 0)) || agenda.getHorarioInicio().isAfter(LocalTime.of(18, 0)) || agenda.getHorarioFim().isBefore(LocalTime.of(8, 0)) || agenda.getHorarioFim().isAfter(LocalTime.of(18, 0))) {
            JOptionPane.showMessageDialog(null, "Apenas em horário comercial", "Horário Inválido", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        return true; // cadastro validado para todas as datas possivelmente invalida ou indisponiveis

    }
}
