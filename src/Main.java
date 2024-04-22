import control.EnderecoController;
import control.PacienteController;
import model.Endereco;
import model.Paciente;
import model.enums.Sexo;
import model.utils.DateUtils;

import javax.swing.*;

import static model.utils.DateUtils.getDateFromString;

public class Main {
    public static void main(String[] args) {

        // TESTE DE CLASSES
        EnderecoController ec = new EnderecoController();
        Object e = ec.cadastrarEndereco(12345678, "Rua do teste", "String", "Teste dos Pinheiros", "SP", 22, "Casa Gigantesca de esquina");
        if(e instanceof Endereco){
            PacienteController pc = new PacienteController();
            Object paciente = pc.cadastrarPaciente("123.456.789-10", "Testerson", "Silva", Sexo.MASCULINO, getDateFromString("22/09/2004"), "11997645234",
                    "teste@teste.com", (Endereco) e, "Sem historico", new String[]{"Suor", "Amendoin", "Dipirona"}, new String[]{"Dramin"}, "Sem anotações");

            paciente = pc.cadastrarPaciente("123.456.789-10", "Cleverson", "Silva", Sexo.MASCULINO, getDateFromString("22/05/2000"), "11997645234",
                    "teste@teste.com", (Endereco) e, "Sem historico", new String[]{"Suor", "Amendoin", "Dipirona"}, new String[]{"Dramin"}, "Sem anotações");

            if(paciente instanceof Paciente){
                JOptionPane.showMessageDialog(null, paciente.toString());
                JOptionPane.showMessageDialog(null, e.toString());
            }else{
                JOptionPane.showMessageDialog(null, paciente);
            }
        }else{
            JOptionPane.showMessageDialog(null, e);
        }

    }
}