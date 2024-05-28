package dao;

import model.EntregaExame;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import static model.utils.DateUtils.*;

public class EntregaDao {
    public Boolean salvar(EntregaExame entrega) {
        Conexao conexao = new Conexao();
        String sql = "INSERT INTO " +
                "entrega (codRecepcionista, codExame, dataRetirada, horarioRetirada, retiradoPor) " +
                "VALUES (?,?,?,?,?)";

        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, entrega.getCodResponsavel().toString());
            stmt.setString(2, entrega.getCodExame().toString());
            stmt.setString(3, getStringFromDate1(entrega.getDataRetirada()));
            stmt.setString(4, getStringFromTime(entrega.getHorarioRetirada()));
            stmt.setString(5, entrega.getRetiradoPor());

            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLIntegrityConstraintViolationException sqlcve) {
            JOptionPane.showMessageDialog(null, "O codigo de funcionario deve se referenciar a um Recepcionista");
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Dados inválidos");
            e.printStackTrace();
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void atualizarEntrega(EntregaExame entrega){
        Conexao conexao = new Conexao();
        String sql = "UPDATE entrega " +
                "SET dataRetirada = ?, " + "horarioRetirada= ?, " + "retiradoPor = ?, " + "codRecepcionista = ?" +
                "WHERE codEntrega = ?";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, getStringFromDate1(entrega.getDataRetirada()));
            stmt.setString(2, getStringFromTime(entrega.getHorarioRetirada()));
            stmt.setString(3, entrega.getRetiradoPor());
            stmt.setString(4, entrega.getCodResponsavel().toString());

            stmt.setString(5, entrega.getCodEntrega().toString());

            stmt.execute();
            stmt.close();

        } catch (SQLIntegrityConstraintViolationException sqlcve) {
            JOptionPane.showMessageDialog(null, "O codigo de funcionario deve se referenciar a um Recepcionista");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Dados inválidos");
            e.printStackTrace();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<EntregaExame> listarEntregas() {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;
        ArrayList<EntregaExame> entregas;

        try {
            stmt = conexao.getConn().prepareStatement("select * from entrega");

            ResultSet rs = stmt.executeQuery();
            entregas = new ArrayList<EntregaExame>();
            while (rs.next()) {
                EntregaExame entrega = new EntregaExame();
                entrega.setCodEntrega(rs.getInt("codEntrega"));
                entrega.setCodExame(rs.getInt("codExame"));
                entrega.setCodResponsavel(Integer.parseInt(rs.getString("codRecepcionista")));
                entrega.setDataRetirada(getDateFromString2(rs.getString("dataRetirada")));
                entrega.setHorarioRetirada(getTimeFromString2(rs.getString("horarioRetirada")));
                entrega.setRetiradoPor(rs.getString("retiradoPor"));

                entregas.add(entrega);
            }

            rs.close();
            stmt.close();
            return entregas;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<EntregaExame> listarEntregasBusca(String textoBusca) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;
        ArrayList<EntregaExame> entregas;

        try {
            stmt = conexao.getConn().prepareStatement("SELECT * FROM entrega WHERE codExame = ? OR codRecepcionista = ? or codEntrega = ? or retiradoPor LIKE ? or dataRetirada LIKE ? or horarioRetirada LIKE ?");
            stmt.setString(1, textoBusca);
            stmt.setString(2, textoBusca);
            stmt.setString(3, textoBusca);
            stmt.setString(4, "%" + textoBusca + "%");
            stmt.setString(5, "%" + textoBusca + "%");
            stmt.setString(6, "%" + textoBusca + "%");

            ResultSet rs = stmt.executeQuery();
            entregas = new ArrayList<EntregaExame>();
            while (rs.next()) {
                EntregaExame entrega = new EntregaExame();
                entrega.setCodEntrega(rs.getInt("codEntrega"));
                entrega.setCodExame(rs.getInt("codExame"));
                entrega.setCodResponsavel(Integer.parseInt(rs.getString("codRecepcionista")));
                entrega.setDataRetirada(getDateFromString2(rs.getString("dataRetirada")));
                entrega.setHorarioRetirada(getTimeFromString2(rs.getString("horarioRetirada")));
                entrega.setRetiradoPor(rs.getString("retiradoPor"));

                entregas.add(entrega);
            }

            rs.close();
            stmt.close();
            return entregas;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void excluirEntrega(Integer codEntrega) {
        Conexao conexao = new Conexao();
        String sql = "DELETE FROM entrega WHERE codEntrega = ?";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, codEntrega.toString());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirEntregaForExame(Integer codExame) {
        Conexao conexao = new Conexao();
        String sql = "DELETE FROM entrega WHERE codExame = ?";
        try {
            PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
            stmt.setString(1, codExame.toString());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public EntregaExame getEntregaForId(Integer codEntrega) {
        Conexao conexao = new Conexao();
        PreparedStatement stmt;

        try {
            stmt = conexao.getConn().prepareStatement("select * from entrega where codEntrega = ?");
            stmt.setString(1, codEntrega.toString());
            ResultSet rs = stmt.executeQuery();

            rs.next();
            EntregaExame entrega = new EntregaExame();
            entrega.setCodEntrega(rs.getInt("codEntrega"));
            entrega.setCodExame(rs.getInt("codExame"));
            entrega.setCodResponsavel(Integer.parseInt(rs.getString("codRecepcionista")));
            entrega.setDataRetirada(getDateFromString2(rs.getString("dataRetirada")));
            entrega.setHorarioRetirada(getTimeFromString2(rs.getString("horarioRetirada")));
            entrega.setRetiradoPor(rs.getString("retiradoPor"));

            rs.close();
            stmt.close();
            return entrega;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
