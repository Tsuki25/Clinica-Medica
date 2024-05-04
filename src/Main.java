import view.ListaPacientesFrame;
import view.PacienteFrame;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        new Main().iniciarTela();
    }

    private void iniciarTela(){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PacienteFrame pacienteFrame = new PacienteFrame();
                    pacienteFrame.setSize(530,870);
                    pacienteFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}