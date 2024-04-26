import view.CadastroPacientePanel;
import view.CadastroPacienteView;

public class Main {
    public static void main(String[] args) {
        new Main().iniciarTela();
    }

    private void iniciarTela(){
        CadastroPacientePanel cadPacientePanel = new CadastroPacientePanel();
        cadPacientePanel.setSize(500,800);
        cadPacientePanel.setVisible(true);
    }
}