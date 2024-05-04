package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

public class PacienteFrame extends JFrame {

    private JPanel contentPane;

    public PacienteFrame() {//FRAME DE CADASTRO
        setTitle("Pacientes");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        ListaPacientesFrame pacientesPanel = new ListaPacientesFrame();
        tabbedPane.addTab("Cadastro de Pacientes", new FormularioPacientePanel(PacienteFrame.this));
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public PacienteFrame(Integer codPaciente) {//FRAME DE EDICAO
        setTitle("Pacientes");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        ListaPacientesFrame pacientesPanel = new ListaPacientesFrame();
        tabbedPane.addTab("Cadastro de Pacientes", new FormularioPacientePanel(PacienteFrame.this, codPaciente));
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}