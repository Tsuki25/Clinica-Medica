package control;

import dao.EnderecoDao;
import dao.MedicoDao;
import model.Endereco;
import model.Medico;
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
}
