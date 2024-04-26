package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    Connection conn = null;

    public Conexao() {
        try {
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinica", "root", "ifsp");//FOR IFSP
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinica", "root", "");// FOR HOME
        } catch (SQLException e) {
            System.out.println("Erro na conexão com o banco!");
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
