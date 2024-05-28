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

import static model.utils.DateUtils.getDateFromString1;
import static model.utils.DateUtils.getTimeFromString;

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

    public EntregaExame controlAtualizarEntrega(FormularioEntregasFrame updatePanel){
        try{
            EntregaExame entrega = new EntregaExame();
            entrega.setCodEntrega(Integer.parseInt(updatePanel.getTfCodEntrega().getText()));
            entrega.setCodResponsavel(Integer.parseInt(updatePanel.getTfCodFuncionario().getText()));
            entrega.setCodExame(Integer.parseInt(updatePanel.getTfCodExame().getText()));
            entrega.setRetiradoPor(updatePanel.getTfRetiradoPor().getText());
            entrega.setDataRetirada(getDateFromString1(updatePanel.getFtfDataRetirada().getText()));
            entrega.setHorarioRetirada(getTimeFromString(updatePanel.getFtfHorarioRetirada().getText()));

            EntregaDao ed = new EntregaDao();
            ed.atualizarEntrega(entrega);
            return entrega;

        }catch(InputMismatchException ime){
            ime.printStackTrace();
            return null;

        }catch(MissingFormatArgumentException mfae){
            mfae.printStackTrace();
            return null;

        }catch (Exception e){
            e.printStackTrace();
            return null;
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

    public void controlExcluirEntrega(EntregaExame entrega){
        EntregaDao entregaDao = new EntregaDao();
        entregaDao.excluirEntrega(entrega.getCodEntrega());
    }

    public void controlExcluirEntregaForExame(Integer codExame){
        EntregaDao entregaDao = new EntregaDao();
        entregaDao.excluirEntregaForExame(codExame);
    }

    public EntregaExame controlBuscarEntregaForId(Integer codEntrega){
        EntregaDao ed = new EntregaDao();
        return ed.getEntregaForId(codEntrega);
    }
}
