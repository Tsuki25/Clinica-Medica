package control;

import model.Endereco;
import model.Paciente;
import model.enums.Sexo;

import java.util.Date;
import java.util.HashMap;

public class EnderecoController {
    HashMap listaEnderecos = new HashMap<>();// REPRESENTAÇÃO TEMPORARIA DO BANCO DE DADOS - APENAS PARA TESTE
    public Object cadastrarEndereco(Integer cep, String logradouro, String bairro, String cidade, String estado, Integer numero, String complemento){
        try{
            if(cep == null || logradouro == null || bairro == null || cidade == null || estado == null || numero == null){
                throw new NullPointerException("Um ou mais parâmetros são nulos.");
            }

            Endereco e = new Endereco(listaEnderecos.size()+1, cep, logradouro, bairro, cidade, estado, numero, complemento);
            this.listaEnderecos.put(listaEnderecos.size()+1, e);
            return e;

        }catch(NullPointerException ne){
            return ne.getMessage();
        }
    }
}
