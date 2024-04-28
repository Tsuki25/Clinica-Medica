package control;

import dao.EnderecoDao;
import dao.PacienteDao;
import model.Endereco;
import model.Paciente;
import model.enums.Sexo;
import view.CadastroPacientePanel;

import java.util.Date;
import java.util.HashMap;

public class EnderecoController {
    public Endereco controlSalvar(CadastroPacientePanel cadastroPanel) {
        Endereco endereco = new Endereco();
        endereco.setCep(Integer.parseInt(cadastroPanel.getTfCep().getText()));
        endereco.setLogradouro(cadastroPanel.getTfLogradouro().getText());
        endereco.setBairro(cadastroPanel.getTfBairro().getText());
        endereco.setCidade(cadastroPanel.getTfCidade().getText());
        endereco.setEstado((String) cadastroPanel.getCbEstado().getSelectedItem());
        endereco.setNumero(Integer.parseInt(cadastroPanel.getTfNumero().getText()));
        endereco.setComplemento(cadastroPanel.getTfComplemento().getText());

        EnderecoDao enderecoDao = new EnderecoDao();
        endereco = enderecoDao.salvar(endereco);
        return endereco;
    }

    public void controlExcluirEnd(Endereco endereco){
        EnderecoDao enderecoDao = new EnderecoDao();
        enderecoDao.excluirEndereco(endereco.getCodEnd());
    }
}
