package control;

import dao.EnderecoDao;
import dao.RecepcionistaDao;
import model.Endereco;
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

    public Recepcionista controlAtualizarRecepcionista(FormularioFuncionarioPanel updatePanel){
        try{
            RecepcionistaDao recepcionistaDao = new RecepcionistaDao();
            EnderecoDao enderecoDao = new EnderecoDao();

            Recepcionista recepcionista = new Recepcionista();
            recepcionista.setCodFuncionario(Integer.parseInt(updatePanel.getTfCodFuncionario().getText()));
            recepcionista.setCpf(updatePanel.getTfCpf().getText());
            recepcionista.setNome(updatePanel.getTfNome().getText());
            recepcionista.setSobrenome(updatePanel.getTfSobrenome().getText());
            recepcionista.setDataNascimento(getDateFromString1(updatePanel.getFtfDtNasc().getText()));
            recepcionista.setTelefone(updatePanel.getTfTelefone().getText());
            recepcionista.setCelular(updatePanel.getTfCelular().getText());
            recepcionista.setEmail(updatePanel.getTfEmail().getText());
            recepcionista.setSexo(updatePanel.getCbSexo());
            char[] senhaChars = updatePanel.getTfSenha().getPassword();
            recepcionista.setSenha(new String(senhaChars));

            Endereco endereco = new Endereco();
            endereco.setCodEnd(recepcionistaDao.getCodEnderecoForRecepcionista(recepcionista.getCpf()));//Função que busca no banco o cod de endereço do recepcionista
            endereco.setCep(Integer.parseInt(updatePanel.getTfCep().getText()));
            endereco.setLogradouro(updatePanel.getTfLogradouro().getText());
            endereco.setBairro(updatePanel.getTfBairro().getText());
            endereco.setCidade(updatePanel.getTfCidade().getText());
            endereco.setEstado((String) updatePanel.getCbEstado().getSelectedItem());
            endereco.setNumero(Integer.parseInt(updatePanel.getTfNumero().getText()));
            endereco.setComplemento(updatePanel.getTfComplemento().getText());

            recepcionista.setEndereco(endereco);

            recepcionistaDao.atualizarRecepcionista(recepcionista);
            enderecoDao.atualizarEndereco(recepcionista.getEndereco());
            return recepcionista;

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

    public Recepcionista controlBuscarRecepcionistaForId(Integer codFuncionario){
        RecepcionistaDao rd = new RecepcionistaDao();
        EnderecoDao ed = new EnderecoDao();
        Recepcionista recepcionista = rd.getRecepcionistaForId(codFuncionario);
        Endereco endereco = ed.getEnderecoForId(recepcionista.getEndereco().getCodEnd());
        recepcionista.setEndereco(endereco);

        return recepcionista;
    }

    public void controlExcluirRecepcionista(Recepcionista recepcionista){
        RecepcionistaDao recepcionistaDao = new RecepcionistaDao();
        EnderecoDao ec = new EnderecoDao();
        recepcionistaDao.excluirRecepcionista(recepcionista.getCpf());
        ec.excluirEndereco(recepcionista.getEndereco().getCodEnd());
    }
}
