package control;

import dao.AgendamentoDao;
import model.Agendamento;
import model.enums.StatusAgendamento;
import view.FormularioAgendamentoPanel;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;

import static model.utils.DateUtils.getDateFromString1;
import static model.utils.DateUtils.getTimeFromString;

public class AgendamentoController {
    public void controlSalvar(FormularioAgendamentoPanel cadastroPanel) {
        try{
            Agendamento agendamento = new Agendamento();
            agendamento.setExame(cadastroPanel.getCbExames());
            agendamento.setDataAgendamento(getDateFromString1(cadastroPanel.getFtfDataAgendamento().getText()));
            agendamento.setHorarioAgendamento(getTimeFromString(cadastroPanel.getFtfHorarioAgendamento().getText()));

            if(agendamento.getDataAgendamento().isBefore(LocalDate.now())){
                JOptionPane.showMessageDialog(null, "A data de agendamento não pode ser anterior a hoje", "Data Inválida", JOptionPane.INFORMATION_MESSAGE);

            }else if(agendamento.getHorarioAgendamento().isBefore(LocalTime.of(8, 0)) || agendamento.getHorarioAgendamento().isAfter(LocalTime.of(18, 0))) {
                JOptionPane.showMessageDialog(null, "Agendamentos permitidos apenas em horário comercial", "Horário Inválido", JOptionPane.INFORMATION_MESSAGE);

            }else{
                agendamento.setCodFuncionario(Integer.parseInt(cadastroPanel.getTfCodFuncionario().getText()));
                agendamento.setCodPaciente(Integer.parseInt(cadastroPanel.getTfCodPaciente().getText()));
                agendamento.setStatus(StatusAgendamento.AGENDADO);

                AgendamentoDao agendamentoDao = new AgendamentoDao();
                agendamentoDao.salvar(agendamento);
                JOptionPane.showMessageDialog(null, "Agendamento realizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }

        }catch(InputMismatchException ime){
            ime.printStackTrace();
        }catch(MissingFormatArgumentException mfae){
            mfae.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    
}
