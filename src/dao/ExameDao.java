package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExameDao {
    public static String getNextCodExame() {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;

        try {
            Integer nextCod = 0;
            stmt = conexao.getConn().prepareStatement("SELECT MAX(codExame) AS codAtual FROM " +
                    "(" +
                    "SELECT codExame FROM ELETROCARDIOGRAMA " +
                    "UNION ALL " +
                    "SELECT codExame FROM ECOCARDIOGRAMA " +
                    "UNION ALL " +
                    "SELECT codExame FROM ERGONOMETRICO " +
                    "UNION ALL " +
                    "SELECT codExame FROM HOLTER" +
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

    public static Integer getPacienteFromExame(Integer codExame) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;

        try {
            Integer codPaciente = null;
            stmt = conexao.getConn().prepareStatement("SELECT codPaciente FROM " +
                    "(" +
                    "  SELECT codPaciente FROM ELETROCARDIOGRAMA WHERE codExame = ? " +
                    "  UNION ALL " +
                    "  SELECT codPaciente FROM ECOCARDIOGRAMA WHERE codExame = ? " +
                    "  UNION ALL " +
                    "  SELECT codPaciente FROM ERGONOMETRICO WHERE codExame = ? " +
                    "  UNION ALL " +
                    "  SELECT codPaciente FROM HOLTER WHERE codExame = ? " +
                    ") AS todas_tabelas");

            stmt.setString(1, codExame.toString());
            stmt.setString(2, codExame.toString());
            stmt.setString(3, codExame.toString());
            stmt.setString(4, codExame.toString());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                codPaciente = rs.getInt("codPaciente");
            }

            rs.close();
            stmt.close();
            return codPaciente;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
