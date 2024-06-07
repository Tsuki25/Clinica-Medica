package control;

import dao.*;
import dao.MedicoDao;
import model.*;

import view.FormularioFuncionarioPanel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;

import static model.utils.DateUtils.getDateFromString1;

public class MedicoController {
    public void controlSalvar(FormularioFuncionarioPanel cadastroPanel, Endereco endereco) {
        try{
            Medico medico = new Medico();
            medico.setCpf(cadastroPanel.getTfCpf().getText());
            medico.setNome(cadastroPanel.getTfNome().getText());
            medico.setSobrenome(cadastroPanel.getTfSobrenome().getText());
            medico.setDataNascimento(getDateFromString1(cadastroPanel.getFtfDtNasc().getText()));
            medico.setTelefone(cadastroPanel.getTfTelefone().getText());
            medico.setCelular(cadastroPanel.getTfCelular().getText());
            medico.setEmail(cadastroPanel.getTfEmail().getText());
            medico.setSexo(cadastroPanel.getCbSexo());
            char[] senhaChars = cadastroPanel.getTfSenha().getPassword();
            medico.setSenha(new String(senhaChars));
            medico.setCrm(cadastroPanel.getTfCrm().getText());
            medico.setEndereco(endereco);

            MedicoDao medicoDao = new MedicoDao();
            medicoDao.salvar(medico);

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

    public Medico controlAtualizarMedico(FormularioFuncionarioPanel updatePanel){
        try{
            MedicoDao medicoDao = new MedicoDao();
            EnderecoDao enderecoDao = new EnderecoDao();

            Medico medico = new Medico();
            medico.setCodFuncionario(Integer.parseInt(updatePanel.getTfCodFuncionario().getText()));
            medico.setCpf(updatePanel.getTfCpf().getText());
            medico.setNome(updatePanel.getTfNome().getText());
            medico.setSobrenome(updatePanel.getTfSobrenome().getText());
            medico.setDataNascimento(getDateFromString1(updatePanel.getFtfDtNasc().getText()));
            medico.setTelefone(updatePanel.getTfTelefone().getText());
            medico.setCelular(updatePanel.getTfCelular().getText());
            medico.setEmail(updatePanel.getTfEmail().getText());
            medico.setSexo(updatePanel.getCbSexo());
            char[] senhaChars = updatePanel.getTfSenha().getPassword();
            medico.setSenha(new String(senhaChars));
            medico.setCrm(updatePanel.getTfCrm().getText());

            Endereco endereco = new Endereco();
            endereco.setCodEnd(medicoDao.getCodEnderecoForMedico(medico.getCpf()));//Função que busca no banco o cod de endereço do medico
            endereco.setCep(Integer.parseInt(updatePanel.getTfCep().getText()));
            endereco.setLogradouro(updatePanel.getTfLogradouro().getText());
            endereco.setBairro(updatePanel.getTfBairro().getText());
            endereco.setCidade(updatePanel.getTfCidade().getText());
            endereco.setEstado((String) updatePanel.getCbEstado().getSelectedItem());
            endereco.setNumero(Integer.parseInt(updatePanel.getTfNumero().getText()));
            endereco.setComplemento(updatePanel.getTfComplemento().getText());

            medico.setEndereco(endereco);

            medicoDao.atualizarMedico(medico);
            enderecoDao.atualizarEndereco(medico.getEndereco());
            return medico;

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

    public ArrayList<Medico> controlListarMedicos(){
        MedicoDao medicoDao = new MedicoDao();
        EnderecoDao enderecoDao = new EnderecoDao();

        ArrayList<Medico> res = medicoDao.listarMedicos();

        for (Medico medico : res) { //PREENCHE O VETOR DE ENDERECOS RELATIVOS AOS PACIENTES BUSCADOS NA ORDEM
            Endereco endereco = enderecoDao.getEnderecoForId(medico.getEndereco().getCodEnd());
            medico.setEndereco(endereco);
        }

        return res;
    }

    public ArrayList<Medico> controlListarMedicosBusca(String textoBusca){
        MedicoDao medicoDao = new MedicoDao();
        EnderecoDao enderecoDao = new EnderecoDao();

        ArrayList<Medico> medicos = medicoDao.listarMedicosBusca(textoBusca);

        for (Medico medico : medicos) { //PREENCHE O VETOR DE ENDERECOS RELATIVOS AOS PACIENTES BUSCADOS NA ORDEM
            Endereco endereco = enderecoDao.getEnderecoForId(medico.getEndereco().getCodEnd());
            medico.setEndereco(endereco);
        }

        return medicos;
    }

    public Medico controlBuscarMedicoForId(Integer codFuncionario){
        MedicoDao md = new MedicoDao();
        EnderecoDao ed = new EnderecoDao();

        Medico medico = md.getMedicoForId(codFuncionario);

        Endereco endereco = ed.getEnderecoForId(medico.getEndereco().getCodEnd());
        medico.setEndereco(endereco);

        return medico;
    }

    public void controlExcluirMedico(Medico medico){
        MedicoDao medicoDao = new MedicoDao();
        EnderecoDao ec = new EnderecoDao();
        medicoDao.excluirMedico(medico.getCpf());
        ec.excluirEndereco(medico.getEndereco().getCodEnd());
    }

    public static Integer controlVerificarMedico(Integer codFuncionario){
        MedicoDao medicoDao = new MedicoDao();
        return medicoDao.verificarMedico(codFuncionario);
    }
}
