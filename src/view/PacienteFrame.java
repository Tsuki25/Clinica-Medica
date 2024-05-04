package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

public class PacienteFrame extends JFrame {

    private JPanel contentPane;

    public PacienteFrame() {
        setTitle("Pacientes");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        ListaPacientesPanel pacientesPanel = new ListaPacientesPanel();
        tabbedPane.addTab("Cadastro de Pacientes", new FormularioPacientePanel(1));
        //tabbedPane.addTab("Editar Paciente", new EditarPacientePanel(1));//APENAS PARA TESTE =============== REMOVER
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}