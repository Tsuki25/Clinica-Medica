package control;

import dao.AgendamentoDao;
import dao.EnderecoDao;
import dao.AgendamentoDao;
import dao.PacienteDao;
import model.Agendamento;
import model.Endereco;
import model.Agendamento;
import model.Paciente;
import model.enums.StatusAgendamento;
import view.FormularioAgendamentoPanel;
import view.FormularioPacientePanel;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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

    public Agendamento controlAtualizarAgendamento(FormularioAgendamentoPanel updatePanel, Agendamento agendamentoEditado){
        try{
            Agendamento agendamento = new Agendamento();
            agendamento.setExame(updatePanel.getCbExames());
            agendamento.setDataAgendamento(getDateFromString1(updatePanel.getFtfDataAgendamento().getText()));
            agendamento.setHorarioAgendamento(getTimeFromString(updatePanel.getFtfHorarioAgendamento().getText()));

            if(agendamento.getDataAgendamento().isBefore(LocalDate.now())){
                JOptionPane.showMessageDialog(null, "A data de agendamento não pode ser anterior a hoje", "Data Inválida", JOptionPane.INFORMATION_MESSAGE);

            }else if(agendamento.getHorarioAgendamento().isBefore(LocalTime.of(8, 0)) || agendamento.getHorarioAgendamento().isAfter(LocalTime.of(18, 0))) {
                JOptionPane.showMessageDialog(null, "Agendamentos permitidos apenas em horário comercial", "Horário Inválido", JOptionPane.INFORMATION_MESSAGE);

            }else{
                agendamento.setCodFuncionario(Integer.parseInt(updatePanel.getTfCodFuncionario().getText()));
                agendamento.setCodPaciente(Integer.parseInt(updatePanel.getTfCodPaciente().getText()));
                agendamento.setStatus(updatePanel.getCbStatus());
                agendamento.setCodAgendamento(agendamentoEditado.getCodAgendamento());

                AgendamentoDao agendamentoDao = new AgendamentoDao();
                agendamentoDao.atualizarAgendamento(agendamento);
                return agendamento;
            }

            return agendamentoEditado; //Assegura um retorno de dados corretos(AGENDAMENTO SENDO EDITADO), independente de possiveis erros de inserção de data e hora

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

    public ArrayList<Agendamento> controlListarAgendamentos(){
        AgendamentoDao agendamentoDao = new AgendamentoDao();
        return agendamentoDao.listarAgendamentos();
    }

    public ArrayList<Agendamento> controlListarAgendamentosBusca(String textoBusca){
        AgendamentoDao agendamentoDao = new AgendamentoDao();
        return agendamentoDao.listarAgendamentosBusca(textoBusca);
    }

    public Agendamento controlBuscarAgendamentoForId(Integer codAgendamento){
        AgendamentoDao pd = new AgendamentoDao();
        return pd.getAgendamentoForId(codAgendamento);
    }

    public void controlExcluirAgendamento(Agendamento agendamento){
        AgendamentoDao agendamentoDao = new AgendamentoDao();
        agendamentoDao.excluirAgendamento(agendamento.getCodAgendamento());
    }
    
}
