package control;

import dao.EletrocardiogramaDao;
import model.exames.Eletrocardiograma;
import view.EletrocardiogramaFrame;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;

import static dao.ExameDao.getNextCodExame;
import static model.utils.DateUtils.getDateFromString1;
import static model.utils.DateUtils.getTimeFromString;

public class EletrocardiogramaController {
    public void controlSalvar(EletrocardiogramaFrame cadastroPanel) {
        try{
            Eletrocardiograma eletro = new Eletrocardiograma();
            eletro.setCodFuncionario(Integer.parseInt(cadastroPanel.getTfCodFuncionario().getText()));
            eletro.setCodPaciente(Integer.parseInt(cadastroPanel.getTfCodPaciente().getText()));
            eletro.setPeso(Double.parseDouble(cadastroPanel.getTfPeso().getText()));
            eletro.setAltura(Double.parseDouble(cadastroPanel.getTfAltura().getText()));
            eletro.setConvenio(cadastroPanel.getTfConvenio().getText());
            eletro.setRitmoCardiaco(cadastroPanel.getTfRitmoCardiaco().getText());
            eletro.setFuncaoCardiaca(Integer.parseInt(cadastroPanel.getTfFuncaoCardiaca().getText()));
            eletro.setDiagnostico(cadastroPanel.getCbDiagnostico());
            eletro.setConclusoes(cadastroPanel.getTfConclusoes().getText());

            EletrocardiogramaDao eletroDao = new EletrocardiogramaDao();
            if(eletroDao.salvar(eletro)){
                JOptionPane.showMessageDialog(null, "Exame registrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }


        }catch(InputMismatchException ime){
            ime.printStackTrace();

        }catch(MissingFormatArgumentException mfae){
            mfae.printStackTrace();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
