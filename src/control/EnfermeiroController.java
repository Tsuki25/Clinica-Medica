package control;

import dao.*;
import dao.EnfermeiroDao;
import dao.EnfermeiroDao;
import model.*;
import model.Enfermeiro;
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

    public Enfermeiro controlAtualizarEnfermeiro(FormularioFuncionarioPanel updatePanel){
        try{
            EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
            EnderecoDao enderecoDao = new EnderecoDao();

            Enfermeiro enfermeiro = new Enfermeiro();
            enfermeiro.setCpf(updatePanel.getTfCpf().getText());
            enfermeiro.setNome(updatePanel.getTfNome().getText());
            enfermeiro.setSobrenome(updatePanel.getTfSobrenome().getText());
            enfermeiro.setDataNascimento(getDateFromString1(updatePanel.getFtfDtNasc().getText()));
            enfermeiro.setTelefone(updatePanel.getTfTelefone().getText());
            enfermeiro.setCelular(updatePanel.getTfCelular().getText());
            enfermeiro.setEmail(updatePanel.getTfEmail().getText());
            enfermeiro.setSexo(updatePanel.getCbSexo());
            char[] senhaChars = updatePanel.getTfSenha().getPassword();
            enfermeiro.setSenha(new String(senhaChars));
            enfermeiro.setCip(updatePanel.getTfCip().getText());

            Endereco endereco = new Endereco();
            endereco.setCodEnd(enfermeiroDao.getCodEnderecoForEnfermeiro(enfermeiro.getCpf()));//Função que busca no banco o cod de endereço do enfermeiro
            endereco.setCep(Integer.parseInt(updatePanel.getTfCep().getText()));
            endereco.setLogradouro(updatePanel.getTfLogradouro().getText());
            endereco.setBairro(updatePanel.getTfBairro().getText());
            endereco.setCidade(updatePanel.getTfCidade().getText());
            endereco.setEstado((String) updatePanel.getCbEstado().getSelectedItem());
            endereco.setNumero(Integer.parseInt(updatePanel.getTfNumero().getText()));
            endereco.setComplemento(updatePanel.getTfComplemento().getText());

            enfermeiro.setEndereco(endereco);

            enfermeiroDao.atualizarEnfermeiro(enfermeiro);
            enderecoDao.atualizarEndereco(enfermeiro.getEndereco());
            return enfermeiro;

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

    public Enfermeiro controlBuscarEnfermeiroForId(Integer codFuncionario){
        EnfermeiroDao pd = new EnfermeiroDao();
        EnderecoDao ed = new EnderecoDao();
        Enfermeiro enfermeiro = pd.getEnfermeiroForId(codFuncionario);
        Endereco endereco = ed.getEnderecoForId(enfermeiro.getEndereco().getCodEnd());
        enfermeiro.setEndereco(endereco);

        return enfermeiro;
    }

    public void controlExcluirEnfermeiro(Enfermeiro enfermeiro){
        EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
        EnderecoDao ec = new EnderecoDao();
        enfermeiroDao.excluirEnfermeiro(enfermeiro.getCpf());
        ec.excluirEndereco(enfermeiro.getEndereco().getCodEnd());
    }
}
