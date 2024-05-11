package control;

import dao.EnderecoDao;
import dao.EnfermeiroDao;
import model.Endereco;
import model.Enfermeiro;
import view.FormularioFuncionarioPanel;

import java.util.ArrayList;
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

    public ArrayList<Enfermeiro> controlListarEnfermeiros(){
        EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
        EnderecoDao enderecoDao = new EnderecoDao();

        ArrayList<Enfermeiro> res = enfermeiroDao.listarEnfermeiros();

        for (Enfermeiro enfermeiro : res) { //PREENCHE O VETOR DE ENDERECOS RELATIVOS AOS PACIENTES BUSCADOS NA ORDEM
            Endereco endereco = enderecoDao.getEnderecoForId(enfermeiro.getEndereco().getCodEnd());
            enfermeiro.setEndereco(endereco);
        }

        return res;
    }

    public ArrayList<Enfermeiro> controlListarEnfermeirosBusca(String textoBusca){
        EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
        EnderecoDao enderecoDao = new EnderecoDao();

        ArrayList<Enfermeiro> enfermeiros = enfermeiroDao.listarEnfermeirosBusca(textoBusca);

        for (Enfermeiro enfermeiro : enfermeiros) { //PREENCHE O VETOR DE ENDERECOS RELATIVOS AOS PACIENTES BUSCADOS NA ORDEM
            Endereco endereco = enderecoDao.getEnderecoForId(enfermeiro.getEndereco().getCodEnd());
            enfermeiro.setEndereco(endereco);
        }

        return enfermeiros;
    }
}
