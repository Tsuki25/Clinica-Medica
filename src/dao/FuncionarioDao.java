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
}
