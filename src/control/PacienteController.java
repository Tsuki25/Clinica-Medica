package control;

import dao.EnderecoDao;
import dao.PacienteDao;
import model.Endereco;
import model.Paciente;
import view.FormularioPacientePanel;

import javax.swing.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;

import static model.utils.DateUtils.getDateFromString1;

public class PacienteController {
    public void controlSalvar(FormularioPacientePanel cadastroPanel, Endereco endereco) {
        try{
            Paciente paciente = new Paciente();
            paciente.setCpf(cadastroPanel.getTfCpf().getText());
            paciente.setNome(cadastroPanel.getTfNome().getText());
            paciente.setSobrenome(cadastroPanel.getTfSobrenome().getText());
            paciente.setDataNascimento(getDateFromString1(cadastroPanel.getFtfDtNasc().getText()));

            if(paciente.getDataNascimento().isAfter(LocalDate.now()) || paciente.getDataNascimento().equals(LocalDate.now())) {
                JOptionPane.showMessageDialog(null, "Data de nascimento inválida", "Data inválido", JOptionPane.INFORMATION_MESSAGE);

            }else{
                paciente.setTelefone(cadastroPanel.getTfTelefone().getText());
                paciente.setCelular(cadastroPanel.getTfCelular().getText());
                paciente.setEmail(cadastroPanel.getTfEmail().getText());
                paciente.setSexo(cadastroPanel.getCbSexo());
                paciente.setHistorico(cadastroPanel.getTfHistorico().getText());
                paciente.setAlergias(cadastroPanel.getTfAlergia().getText());
                paciente.setMedicamentosUtilizados(cadastroPanel.getTfMedicamentosUtilizados().getText());
                paciente.setAnotacoes(cadastroPanel.getTfAnotacoes().getText());
                paciente.setEndereco(endereco);

                PacienteDao pacienteDao = new PacienteDao();
                pacienteDao.salvar(paciente);
            }
        }catch(InputMismatchException ime){
            EnderecoController end = new EnderecoController();
            end.controlExcluirEnd(endereco);
            ime.printStackTrace();
        }catch(MissingFormatArgumentException mfae){
            EnderecoController end = new EnderecoController();
            end.controlExcluirEnd(endereco);
            mfae.printStackTrace();
        }catch (Exception e){
            EnderecoController end = new EnderecoController();
            end.controlExcluirEnd(endereco);
            e.printStackTrace();
        }

    }

    public ArrayList<Paciente> controlListarPacientes(){
        PacienteDao pacienteDao = new PacienteDao();
        EnderecoDao enderecoDao = new EnderecoDao();

        ArrayList<Paciente> pacientes = pacienteDao.listarPacientes();

        for (Paciente paciente : pacientes) { //PREENCHE O VETOR DE ENDERECOS RELATIVOS AOS PACIENTES BUSCADOS NA ORDEM
            Endereco endereco = enderecoDao.getEnderecoForId(paciente.getEndereco().getCodEnd());
            paciente.setEndereco(endereco);
        }

        return pacientes;
    }

    public ArrayList<Paciente> controlListarPacientesBusca(String textoBusca){
        PacienteDao pacienteDao = new PacienteDao();
        EnderecoDao enderecoDao = new EnderecoDao();

        ArrayList<Paciente> pacientes = pacienteDao.listarPacientesBusca(textoBusca);

        for (Paciente paciente : pacientes) { //PREENCHE O VETOR DE ENDERECOS RELATIVOS AOS PACIENTES BUSCADOS NA ORDEM
            Endereco endereco = enderecoDao.getEnderecoForId(paciente.getEndereco().getCodEnd());
            paciente.setEndereco(endereco);
        }

        return pacientes;
    }

    public Paciente controlAtualizarPaciente(FormularioPacientePanel updatePanel, Paciente pacienteAux){
        try{
            PacienteDao pacienteDao = new PacienteDao();
            EnderecoDao enderecoDao = new EnderecoDao();

            Paciente paciente = new Paciente();
            paciente.setCpf(updatePanel.getTfCpf().getText());
            paciente.setNome(updatePanel.getTfNome().getText());
            paciente.setSobrenome(updatePanel.getTfSobrenome().getText());
            paciente.setDataNascimento(getDateFromString1(updatePanel.getFtfDtNasc().getText()));
            if(paciente.getDataNascimento().isAfter(LocalDate.now()) || paciente.getDataNascimento().equals(LocalDate.now())) {
                JOptionPane.showMessageDialog(null, "Data de nascimento inválida", "Data inválido", JOptionPane.INFORMATION_MESSAGE);
                return pacienteAux;
            }else{
                paciente.setTelefone(updatePanel.getTfTelefone().getText());
                paciente.setCelular(updatePanel.getTfCelular().getText());
                paciente.setEmail(updatePanel.getTfEmail().getText());
                paciente.setSexo(updatePanel.getCbSexo());
                paciente.setHistorico(updatePanel.getTfHistorico().getText());
                paciente.setAlergias(updatePanel.getTfAlergia().getText());
                paciente.setMedicamentosUtilizados(updatePanel.getTfMedicamentosUtilizados().getText());
                paciente.setAnotacoes(updatePanel.getTfAnotacoes().getText());

                Endereco endereco = new Endereco();
                endereco.setCodEnd(pacienteDao.getCodEnderecoForPaciente(paciente.getCpf()));//Função que busca no banco o cod de endereço do paciente
                endereco.setCep(Integer.parseInt(updatePanel.getTfCep().getText()));
                endereco.setLogradouro(updatePanel.getTfLogradouro().getText());
                endereco.setBairro(updatePanel.getTfBairro().getText());
                endereco.setCidade(updatePanel.getTfCidade().getText());
                endereco.setEstado((String) updatePanel.getCbEstado().getSelectedItem());
                endereco.setNumero(Integer.parseInt(updatePanel.getTfNumero().getText()));
                endereco.setComplemento(updatePanel.getTfComplemento().getText());

                paciente.setEndereco(endereco);

                pacienteDao.atualizarPaciente(paciente);
                enderecoDao.atualizarEndereco(paciente.getEndereco());
                return paciente;
            }

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

    public Paciente controlBuscarPacienteForId(Integer codPaciente){
        PacienteDao pd = new PacienteDao();
        EnderecoDao ed = new EnderecoDao();
        Paciente paciente = pd.getPacienteForId(codPaciente);
        Endereco endereco = ed.getEnderecoForId(paciente.getEndereco().getCodEnd());
        paciente.setEndereco(endereco);

        return paciente;
    }

    public void controlExcluirPaciente(Paciente paciente){
        PacienteDao pacienteDao = new PacienteDao();
        EnderecoDao ec = new EnderecoDao();
        pacienteDao.excluirPaciente(paciente.getCpf());
        ec.excluirEndereco(paciente.getEndereco().getCodEnd());
    }

    public static String getNomePacienteForId(Integer codPaciente){
        PacienteDao pacienteDao = new PacienteDao();
        return pacienteDao.getNomePacienteForId(codPaciente);
    }
}
