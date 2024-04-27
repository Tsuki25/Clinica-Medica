package control;

import dao.PacienteDao;
import model.Endereco;
import model.Paciente;
import model.enums.Sexo;
import view.CadastroPacientePanel;

import static model.utils.DateUtils.getDateFromString;

public class PacienteController {
    public void controlSalvar(CadastroPacientePanel cadastroPanel, Endereco endereco) {
        Paciente paciente = new Paciente();
        paciente.setCpf(cadastroPanel.getTfCpf().getText());
        paciente.setNome(cadastroPanel.getTfNome().getText());
        paciente.setSobrenome(cadastroPanel.getTfSobrenome().getText());
        paciente.setDataNascimento(getDateFromString(cadastroPanel.getFtfDtNasc().getText()));
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
}
