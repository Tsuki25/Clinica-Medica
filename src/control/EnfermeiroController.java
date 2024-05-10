package control;

import dao.EnfermeiroDao;
import dao.RecepcionistaDao;
import model.Endereco;
import model.Enfermeiro;
import view.FormularioFuncionarioPanel;

import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;

import static model.utils.DateUtils.getDateFromString1;

public class EnfermeiroController {
    public void controlSalvar(FormularioFuncionarioPanel cadastroPanel, Endereco endereco) {
        try {
            Enfermeiro enfermeira = new Enfermeiro();
            enfermeira.setCpf(cadastroPanel.getTfCpf().getText());
            enfermeira.setNome(cadastroPanel.getTfNome().getText());
            enfermeira.setSobrenome(cadastroPanel.getTfSobrenome().getText());
            enfermeira.setDataNascimento(getDateFromString1(cadastroPanel.getFtfDtNasc().getText()));
            enfermeira.setTelefone(cadastroPanel.getTfTelefone().getText());
            enfermeira.setCelular(cadastroPanel.getTfCelular().getText());
            enfermeira.setEmail(cadastroPanel.getTfEmail().getText());
            enfermeira.setSexo(cadastroPanel.getCbSexo());
            char[] senhaChars = cadastroPanel.getTfSenha().getPassword();
            enfermeira.setSenha(new String(senhaChars));
            enfermeira.setCip(cadastroPanel.getTfCip().getText());
            enfermeira.setEndereco(endereco);

            EnfermeiroDao enfermeiraDao = new EnfermeiroDao();
            enfermeiraDao.salvar(enfermeira);

        } catch (InputMismatchException ime) {
            EnderecoController end = new EnderecoController();
            end.controlExcluirEnd(endereco);
            ime.printStackTrace();
        } catch (MissingFormatArgumentException mfae) {
            EnderecoController end = new EnderecoController();
            end.controlExcluirEnd(endereco);
            mfae.printStackTrace();
        } catch (Exception e) {
            EnderecoController end = new EnderecoController();
            end.controlExcluirEnd(endereco);
            e.printStackTrace();
        }
    }
}
