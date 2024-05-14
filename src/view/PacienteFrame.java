package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

public class PacienteFrame extends JFrame {

    private JPanel contentPane;

    public PacienteFrame() {//FRAME PRINCIPAL
        setTitle("Pacientes");
        estruturaFrame();

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        ListaPacientesFrame pacientesPanel = new ListaPacientesFrame();
        tabbedPane.addTab("Pacientes", new FormularioPacientePanel(PacienteFrame.this));
        tabbedPane.addTab("Funcionarios", new FormularioFuncionarioPanel(PacienteFrame.this));
        tabbedPane.addTab("Agendamento", new FormularioAgendamentoPanel(PacienteFrame.this));
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public PacienteFrame(Integer codPaciente) {//FRAME DE EDICAO PACIENTE
        setTitle("Pacientes");
        estruturaFrame();

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        ListaPacientesFrame pacientesPanel = new ListaPacientesFrame();
        tabbedPane.addTab("Cadastro de Pacientes", new FormularioPacientePanel(PacienteFrame.this, codPaciente));
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public PacienteFrame(Integer codFuncionario, String crm, String cip) { //FRAME DE EDICAO FUNCIONARIO
        setTitle("Funcionarios");
        estruturaFrame();

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        ListaFuncionariosFrame funcionariosPanel = new ListaFuncionariosFrame();
        tabbedPane.addTab("Edição Funcionarios", new FormularioFuncionarioPanel(PacienteFrame.this, codFuncionario, crm, cip));
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public PacienteFrame(Integer codAgendamento, Integer codFuncionario) { //FRAME DE EDICAO DE AGENDAMENTO
        // O parametro codFuncionario é passado para permitir um novo construtor para essa classe
        // Porém tem também por objetivo identificar a sessão de edição, ou seja, quem é o funcionario realizando a edição
        // Como não houve tempo hábil para construção do sistema de login, segue apenas como um auxiliar
        setTitle("Agendamentos");
        estruturaFrame();

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        ListaAgendamentosFrame agendamentosFrame = new ListaAgendamentosFrame();
        tabbedPane.addTab("Edição de Agendamento", new FormularioAgendamentoPanel(PacienteFrame.this, codAgendamento));
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void estruturaFrame(){
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
    }

}