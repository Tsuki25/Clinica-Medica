package control;

import dao.EnderecoDao;
import model.Endereco;
import view.FormularioPacientePanel;
import view.FormularioFuncionarioPanel;

import javax.swing.*;

public class EnderecoController {
    public Endereco controlSalvar(FormularioPacientePanel cadastroPanel) {
        try{
            if (verificarCampos(cadastroPanel)){
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
            }else{
                JOptionPane.showMessageDialog(null, "Campos obrigátorios não preenchidos");
                return null;
            }


        }catch(NumberFormatException ne){
            JOptionPane.showMessageDialog(null, "O campo número e CEP não podem ser preenchidos por caracteres e são obrigatórios");
            return null;
        }
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

    public boolean verificarCampos(FormularioPacientePanel cadastroPanel){
        return !cadastroPanel.getTfCep().getText().isEmpty() &&
                !cadastroPanel.getTfLogradouro().getText().isEmpty() &&
                !cadastroPanel.getTfBairro().getText().isEmpty() &&
                !cadastroPanel.getTfCidade().getText().isEmpty() &&
                !cadastroPanel.getCbEstado().getSelectedItem().toString().isEmpty() &&
                !cadastroPanel.getTfNumero().getText().isEmpty();
    }
}
