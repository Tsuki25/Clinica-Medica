import view.CadastroFrame;
import view.CadastroPacientePanel;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        new Main().iniciarTela();
    }

    private void iniciarTela(){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastroFrame cadastroFrame = new CadastroFrame();
                    cadastroFrame.setSize(800,900);
                    cadastroFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}