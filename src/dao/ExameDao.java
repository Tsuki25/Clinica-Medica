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
}
