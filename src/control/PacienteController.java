package control;

import model.Endereco;
import model.Paciente;
import model.enums.Sexo;

import java.time.LocalDate;
import java.util.HashMap;

public class PacienteController {
    HashMap listaPacientes = new HashMap<>();// REPRESENTAÇÃO TEMPORARIA DO BANCO DE DADOS - APENAS PARA TESTE
    public Object cadastrarPaciente(String cpf, String nome, String sobrenome, Sexo sexo, LocalDate data_nascimento, String celular, String email, Endereco endereco, String historico, String[] alergias, String[] medicamentosUtilizados, String anotacoes){
        try{
            if(this.listaPacientes.containsKey(cpf)){
                throw new IllegalArgumentException("CPF já cadastrado.");
            }

            if(cpf == null || nome == null || sobrenome == null || sexo == null || data_nascimento == null || celular == null || email == null || endereco == null || historico == null || alergias == null || medicamentosUtilizados == null || anotacoes == null){
                throw new NullPointerException("Um ou mais parâmetros são nulos.");
            }

            Paciente p = new Paciente(cpf, nome, sobrenome, sexo, data_nascimento, celular, email, endereco, listaPacientes.size()+1, historico, alergias, medicamentosUtilizados, anotacoes);
            this.listaPacientes.put(cpf, p);
            return p;

        }catch(NullPointerException ne){
           return ne.getMessage();

        }catch (IllegalArgumentException ie){
            return ie.getMessage();
        }
    }
}
