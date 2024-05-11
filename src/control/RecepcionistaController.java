package control;

import dao.EnderecoDao;
import dao.RecepcionistaDao;
import dao.RecepcionistaDao;
import model.Endereco;
import model.Recepcionista;
import model.Recepcionista;
import view.FormularioFuncionarioPanel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;

import static model.utils.DateUtils.getDateFromString1;

public class RecepcionistaController {

    public void controlSalvar(FormularioFuncionarioPanel cadastroPanel, Endereco endereco) {
        try{
            Recepcionista recepcionista = new Recepcionista();
            recepcionista.setCpf(cadastroPanel.getTfCpf().getText());
            recepcionista.setNome(cadastroPanel.getTfNome().getText());
            recepcionista.setSobrenome(cadastroPanel.getTfSobrenome().getText());
            recepcionista.setDataNascimento(getDateFromString1(cadastroPanel.getFtfDtNasc().getText()));
            recepcionista.setTelefone(cadastroPanel.getTfTelefone().getText());
            recepcionista.setCelular(cadastroPanel.getTfCelular().getText());
            recepcionista.setEmail(cadastroPanel.getTfEmail().getText());
            recepcionista.setSexo(cadastroPanel.getCbSexo());
            char[] senhaChars = cadastroPanel.getTfSenha().getPassword();
            recepcionista.setSenha(new String(senhaChars));
            recepcionista.setEndereco(endereco);

            RecepcionistaDao recepcionistaDao = new RecepcionistaDao();
            recepcionistaDao.salvar(recepcionista);

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

    public ArrayList<Recepcionista> controlListarRecepcionistas(){
        RecepcionistaDao recepcionistaDao = new RecepcionistaDao();
        EnderecoDao enderecoDao = new EnderecoDao();

        ArrayList<Recepcionista> res = recepcionistaDao.listarRecepcionistas();

        for (Recepcionista recepcionista : res) { //PREENCHE O VETOR DE ENDERECOS RELATIVOS AOS PACIENTES BUSCADOS NA ORDEM
            Endereco endereco = enderecoDao.getEnderecoForId(recepcionista.getEndereco().getCodEnd());
            recepcionista.setEndereco(endereco);
        }

        return res;
    }

    public ArrayList<Recepcionista> controlListarRecepcionistasBusca(String textoBusca){
        RecepcionistaDao recepcionistaDao = new RecepcionistaDao();
        EnderecoDao enderecoDao = new EnderecoDao();

        ArrayList<Recepcionista> recepcionistas = recepcionistaDao.listarRecepcionistasBusca(textoBusca);

        for (Recepcionista recepcionista : recepcionistas) { //PREENCHE O VETOR DE ENDERECOS RELATIVOS AOS PACIENTES BUSCADOS NA ORDEM
            Endereco endereco = enderecoDao.getEnderecoForId(recepcionista.getEndereco().getCodEnd());
            recepcionista.setEndereco(endereco);
        }

        return recepcionistas;
    }
}
