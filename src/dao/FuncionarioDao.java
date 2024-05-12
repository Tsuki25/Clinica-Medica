package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class FuncionarioDao {

    public static String getNextCod() {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;

        try {
            Integer nextCod = 0;
            stmt = conexao.getConn().prepareStatement("SELECT MAX(codFuncionario) AS codAtual FROM " +
                    "(" +
                    "SELECT codFuncionario FROM RECEPCIONISTA " +
                    "UNION ALL " +
                    "SELECT codFuncionario FROM ENFERMEIRO " +
                    "UNION ALL " +
                    "SELECT codFuncionario FROM MEDICO" +
                    ") " +
                    "AS todas_tabelas");
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
               nextCod = rs.getInt("codAtual") + 1;
            }

            rs.close();
            stmt.close();
            return nextCod.toString();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getNomeFuncionarioForId(Integer codigoFuncionario) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;

        try {
            String nomeFuncionario = "";
            stmt = conexao.getConn().prepareStatement("SELECT nome, sobrenome FROM " +
                    "(" +
                    "  SELECT nome, sobrenome FROM RECEPCIONISTA WHERE codFuncionario = ? " +
                    "  UNION ALL " +
                    "  SELECT nome, sobrenome FROM ENFERMEIRO WHERE codFuncionario = ? " +
                    "  UNION ALL " +
                    "  SELECT nome, sobrenome FROM MEDICO WHERE codFuncionario = ? " +
                    ") AS todas_tabelas");

            stmt.setString(1, codigoFuncionario.toString());
            stmt.setString(2, codigoFuncionario.toString());
            stmt.setString(3, codigoFuncionario.toString());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
               nomeFuncionario = rs.getString("nome") + " " + rs.getString("sobrenome");
            }

            rs.close();
            stmt.close();
            return nomeFuncionario;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
