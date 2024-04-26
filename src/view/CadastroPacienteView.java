package view;

import control.EnderecoController;
import control.PacienteController;
import model.Endereco;
import model.Paciente;
import model.enums.Sexo;

import javax.swing.*;

import static model.utils.DateUtils.getDateFromString;

public class CadastroPacienteView {

    public void testeCadastroPaciente(){
        /*
        PacienteController pc = new PacienteController();
        EnderecoController ec = new EnderecoController();
        // TESTE DE CLASSES

        Object e = ec.cadastrarEndereco(12345678, "Rua do teste", "String", "Teste dos Pinheiros", "SP", 22, "Casa Gigantesca de esquina");
        if(e instanceof Endereco){
            Object paciente = pc.cadastrarPaciente("123.456.789-10", "Testerson", "Silva", Sexo.MASCULINO, getDateFromString("22/09/2004"), "11997645234",
                    "teste@teste.com", (Endereco) e, "Sem historico", new String[]{"Suor", "Amendoin", "Dipirona"}, new String[]{"Dramin"}, "Sem anotações");

            paciente = pc.cadastrarPaciente("143.123.569-75", "sei la", "sasas", Sexo.FEMININO, getDateFromString("01/09/2004"), "11997645234",
                    "teste@seila.com", (Endereco) e, "Sem historico", new String[]{"Amendoin", "Dipirona"}, new String[]{"Dramin"}, "Sem anotações");


            if(paciente instanceof Paciente){
                JOptionPane.showMessageDialog(null, "Sucesso!!!");
                JOptionPane.showMessageDialog(null, e.toString());
            }else{
                JOptionPane.showMessageDialog(null, paciente);
            }
        }else{
            JOptionPane.showMessageDialog(null, e);
        }

        for (Object item : pc.getDados().values()) {
            JOptionPane.showMessageDialog(null, item);
        }

        pc.editarPaciente("123.456.789-10", "José", "Silva", Sexo.MASCULINO, getDateFromString("25/09/2004"), null,"11997645235",
                "teste@teste.com", (Endereco) e, "Sem historico", new String[]{"Amendoin", "Dipirona"}, new String[]{"Dramin, Nevralgex"}, "Sem anotações");

         */

    }
}
