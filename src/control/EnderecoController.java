package control;

import dao.EnderecoDao;
import model.Endereco;
import view.FormularioPacientePanel;
import view.FormularioFuncionarioPanel;

public class EnderecoController {
    public Endereco controlSalvar(FormularioPacientePanel cadastroPanel) {
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

    public Endereco controlSalvar(FormularioFuncionarioPanel cadastroPanel) {
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
