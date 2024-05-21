package control;

import dao.EletrocardiogramaDao;
import model.exames.Eletrocardiograma;
import view.FormularioEletrocardiogramaFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;

public class EletrocardiogramaController {
    public void controlSalvar(FormularioEletrocardiogramaFrame cadastroPanel) {
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

    public Eletrocardiograma controlAtualizarEletrocardiograma(FormularioEletrocardiogramaFrame updatePanel, Eletrocardiograma eletrocardiogramaEditado){
        try{
            Eletrocardiograma eletro = new Eletrocardiograma();
            eletro.setCodExame(eletrocardiogramaEditado.getCodExame());
            eletro.setCodFuncionario(Integer.parseInt(updatePanel.getTfCodFuncionario().getText()));
            eletro.setCodPaciente(Integer.parseInt(updatePanel.getTfCodPaciente().getText()));
            eletro.setPeso(Double.parseDouble(updatePanel.getTfPeso().getText()));
            eletro.setAltura(Double.parseDouble(updatePanel.getTfAltura().getText()));
            eletro.setConvenio(updatePanel.getTfConvenio().getText());
            eletro.setRitmoCardiaco(updatePanel.getTfRitmoCardiaco().getText());
            eletro.setFuncaoCardiaca(Integer.parseInt(updatePanel.getTfFuncaoCardiaca().getText()));
            eletro.setDiagnostico(updatePanel.getCbDiagnostico());
            eletro.setConclusoes(updatePanel.getTfConclusoes().getText());

            EletrocardiogramaDao eletrocardiogramaDao = new EletrocardiogramaDao();
            eletrocardiogramaDao.atualizarEletrocardiograma(eletro);
            return eletro;


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
    
    public ArrayList<Eletrocardiograma> controlListarEletrocardiogramas(){
        EletrocardiogramaDao eletrocardiogramaDao = new EletrocardiogramaDao();

        return eletrocardiogramaDao.listarEletrocardiogramas();
    }

    public ArrayList<Eletrocardiograma> controlListarEletrocardiogramasBusca(String textoBusca){
        EletrocardiogramaDao eletrocardiogramaDao = new EletrocardiogramaDao();

        return eletrocardiogramaDao.listarEletrocardiogramasBusca(textoBusca);
    }

    public Eletrocardiograma controlBuscarEletrocardiogramaForId(Integer codExame){
        EletrocardiogramaDao pd = new EletrocardiogramaDao();

        return pd.getEletrocardiogramaForId(codExame);
    }

    public void controlExcluirEletrocardiograma(Eletrocardiograma eletrocardiograma){
        EletrocardiogramaDao eletrocardiogramaDao = new EletrocardiogramaDao();
        eletrocardiogramaDao.excluirEletrocardiograma(eletrocardiograma.getCodExame());
    }
}
