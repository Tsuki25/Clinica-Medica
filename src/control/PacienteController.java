package control;

import model.Endereco;
import model.Paciente;
import model.enums.Sexo;

import java.time.LocalDate;
import java.util.HashMap;

public class PacienteController {
    HashMap listaPacientes = new HashMap<>();// REPRESENTAÇÃO TEMPORARIA DO BANCO DE DADOS - APENAS PARA TESTE
    public Object cadastrarPaciente(String cpf, String nome, String sobrenome, Sexo sexo, LocalDate data_nascimento, String celular, String email, Endereco endereco, String historico, String alergias, String medicamentosUtilizados, String anotacoes){
        try{
            if(this.listaPacientes.containsKey(cpf)){
                throw new IllegalArgumentException("CPF já cadastrado.");
            }

            if(cpf == null || nome == null || sobrenome == null || sexo == null || data_nascimento == null || celular == null || email == null || endereco == null || historico == null){
                throw new NullPointerException("Um ou mais parâmetros são nulos.");
            }

            Paciente p = new Paciente(cpf, nome, sobrenome, sexo, data_nascimento, null, celular, email, endereco, listaPacientes.size()+1, historico, alergias, medicamentosUtilizados, anotacoes);
            this.listaPacientes.put(cpf, p);
            return p;

        }catch(NullPointerException ne){
           return ne.getMessage();

        }catch (IllegalArgumentException ie){
            return ie.getMessage();
        }
    }

    public Object editarPaciente(String cpf, String nome, String sobrenome, Sexo sexo, LocalDate data_nascimento, String telefone, String celular, String email, Endereco endereco, String historico, String alergias, String medicamentosUtilizados, String anotacoes){
        try{
            if(nome == null || sobrenome == null || sexo == null || data_nascimento == null || celular == null || email == null || endereco == null || historico == null){
                throw new NullPointerException("Um ou mais parâmetros são nulos.");
            }

            Paciente p = (Paciente) listaPacientes.get(cpf);// Pega o Paciente já cadastrado no 'Banco'
            Integer codPaciente = p.getCodPaciente();// Armazena o codigo deste paciente
            p = new Paciente(cpf, nome, sobrenome, sexo, data_nascimento, telefone, celular, email, endereco, historico, alergias, medicamentosUtilizados, anotacoes); // gera um novo paciente com os dados atualizados
            p.setCodPaciente(codPaciente); // seta o codigo do paciente conforme o já existente anteriormente
            listaPacientes.replace(cpf, p);// substitui o antigo cadastro pelo novo

            return p;

        }catch(NullPointerException ne) {
            return ne.getMessage();
        }
    }

    public Object pesquisarPaciente(String cpf){
        try {
            if (cpf == null || !listaPacientes.containsKey(cpf)) {
                return "Paciente não encontrado para o CPF: " + cpf;
            }

            return listaPacientes.get(cpf);

        } catch (NullPointerException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;

        } catch (ClassCastException e) {
            System.out.println("Erro de cast: " + e.getMessage());
            return null;
        }
    }

    public HashMap getDados(){
        return listaPacientes;
    }
}
