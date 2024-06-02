import view.MainFrame;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        new Main().iniciarTela();
    }

    private void iniciarTela(){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.setSize(530,870);
                    mainFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}