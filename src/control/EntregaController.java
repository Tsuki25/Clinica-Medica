package control;

import dao.EntregaDao;
import model.EntregaExame;
import view.FormularioEntregasFrame;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;

public class EntregaController {
    public void controlSalvar(FormularioEntregasFrame cadastroPanel) {
        try{
            EntregaExame entrega = new EntregaExame();
            entrega.setCodResponsavel(Integer.parseInt(cadastroPanel.getTfCodFuncionario().getText()));
            entrega.setCodExame(Integer.parseInt(cadastroPanel.getTfCodExame().getText()));
            entrega.setRetiradoPor(cadastroPanel.getTfRetiradoPor().getText());
            entrega.setDataRetirada(LocalDate.now());
            entrega.setHorarioRetirada(LocalTime.now());

            EntregaDao entregaDao = new EntregaDao();
            if(entregaDao.salvar(entrega)){
                JOptionPane.showMessageDialog(null, "Sucesso ao salvar o registro", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }


        }catch(InputMismatchException ime){
            ime.printStackTrace();

        }catch(MissingFormatArgumentException mfae){
            mfae.printStackTrace();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<EntregaExame> controlListarEntregas(){
        EntregaDao entregaDao = new EntregaDao();

        return entregaDao.listarEntregas();
    }

    public ArrayList<EntregaExame> controlListarEntregasBusca(String textoBusca){
        EntregaDao entregaDao = new EntregaDao();

        return entregaDao.listarEntregasBusca(textoBusca);
    }
}
