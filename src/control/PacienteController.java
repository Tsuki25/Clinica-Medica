package control;

import dao.EnderecoDao;
import dao.PacienteDao;
import model.Endereco;
import model.Paciente;
import model.enums.Sexo;
import view.CadastroPacientePanel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;

import static model.utils.DateUtils.getDateFromString1;

public class PacienteController {
    public void controlSalvar(CadastroPacientePanel cadastroPanel, Endereco endereco) {
        try{
            Paciente paciente = new Paciente();
            paciente.setCpf(cadastroPanel.getTfCpf().getText());
            paciente.setNome(cadastroPanel.getTfNome().getText());
            paciente.setSobrenome(cadastroPanel.getTfSobrenome().getText());
            paciente.setDataNascimento(getDateFromString1(cadastroPanel.getFtfDtNasc().getText()));
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

    public ArrayList<Object[]> controlListarPacientes(){
        PacienteDao pacienteDao = new PacienteDao();
        EnderecoDao enderecoDao = new EnderecoDao();

        ArrayList<Paciente> pacientes = pacienteDao.listarPacientes();
        ArrayList<Endereco> enderecos = enderecoDao.listarEndereco();
        ArrayList<Object[]> resposta = new ArrayList<>();

        for (int i = 0; i < pacientes.size(); i++) {
            Paciente paciente = pacientes.get(i);
            Endereco endereco = enderecos.get(i);
            Object[] dados = new Object[] { paciente, endereco };
            resposta.add(dados);
        }

        return resposta;
    }

    public Paciente controlBuscarPacienteForId(Integer codPaciente){
        PacienteDao pd = new PacienteDao();
        EnderecoDao ed = new EnderecoDao();
        Paciente paciente = pd.getPacienteForId(codPaciente);
        Endereco endereco = ed.getEnderecoForId(paciente.getEndereco().getCodEnd());
        paciente.setEndereco(endereco);

        return paciente;
    }
}
