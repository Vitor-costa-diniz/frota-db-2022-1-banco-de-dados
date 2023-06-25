package br.com.frota.DAO;

import br.com.frota.model.Tarifa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TarifaDAO extends ConexaoDB{
    private static final String INSERT_TARIFA_SQL = "INSERT INTO tarifa (taxa, classe, lei, data_inicio, data_final) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_TARIFA_BY_ID = "SELECT id, taxa, classe, lei, data_inicio, data_final FROM tarifa WHERE id = ?";
    private static final String SELECT_ALL_TARIFA = "SELECT * FROM tarifa;";
    private static final String DELETE_TARIFA_SQL = "DELETE FROM tarifa WHERE id = ?;";
    private static final String UPDATE_TARIFA_SQL = "UPDATE tarifa SET id = ? taxa = ?, classe = ?, lei = ?, data_inicio = ?, data_final = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM tarifa;";

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prepararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public void insertTarifa(Tarifa entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_TARIFA_SQL)) {
            preparedStatement.setString(1, entidade.getTaxa());
            preparedStatement.setInt(2, entidade.getClasse());
            preparedStatement.setString(3, entidade.getLei());
            preparedStatement.setTimestamp(4, entidade.getDataInicio());
            preparedStatement.setTimestamp(5, entidade.getDataFinal());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Tarifa selectTarifaById(int id) {
        Tarifa entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_TARIFA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String taxa = rs.getString("taxa");
                Integer classe = rs.getInt("classe");
                String lei = rs.getString("lei");
                Timestamp dataInicio = rs.getTimestamp("data_inicio");
                Timestamp dataFinal = rs.getTimestamp("data_final");


                entidade = new Tarifa(id, taxa, classe, lei, dataInicio, dataFinal);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Tarifa> selectAllTarifa() {
        List<Tarifa> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_TARIFA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String taxa = rs.getString("taxa");
                Integer classe = rs.getInt("classe");
                String lei = rs.getString("lei");
                Timestamp dataInicio = rs.getTimestamp("data_inicio");
                Timestamp dataFinal = rs.getTimestamp("data_final");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteTarifa(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_TARIFA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateTarifa(Tarifa entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_TARIFA_SQL)) {
            statement.setInt(1, entidade.getId());
            statement.setString(2, entidade.getTaxa());
            statement.setInt(3, entidade.getClasse());
            statement.setString(4, entidade.getLei());
            statement.setTimestamp(5, entidade.getDataInicio());
            statement.setTimestamp(6, entidade.getDataFinal());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}