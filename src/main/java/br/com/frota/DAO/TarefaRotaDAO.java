package br.com.frota.DAO;

import br.com.frota.model.TarefaRota;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TarefaRotaDAO extends ConexaoDB{
    private static final String INSERT_TAREFA_ROTA_SQL = "INSERT INTO tarefa_rota (observacao, data_inicio, data_fim, tarefa_rotacao, rota_id) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_TAREFA_ROTA_BY_ID = "SELECT id, observacao, data_inicio, data_fim, tarefa_rotacao, rota_id FROM tarefa_rota WHERE id = ?";
    private static final String SELECT_ALL_TAREFA_ROTA = "SELECT * FROM tarefa_rota;";
    private static final String DELETE_TAREFA_ROTA_SQL = "DELETE FROM tarefa_rota WHERE id = ?;";
    private static final String UPDATE_TAREFA_ROTA_SQL = "UPDATE tarefa_rota SET id = ? observacao = ?, data_inicio = ?, data_fim = ?, tarefa_rotacao = ?, rota_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM tarefa_rota;";

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

    public void insertTarefaRota(TarefaRota entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_TAREFA_ROTA_SQL)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setTimestamp(2, entidade.getDataInicio());
            preparedStatement.setTimestamp(3, entidade.getDataFim());
            preparedStatement.setString(4, entidade.getTarefaRotacao());
            preparedStatement.setInt(5, entidade.getRotaId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public TarefaRota selectTarefaRotaById(int id) {
        TarefaRota entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_TAREFA_ROTA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                Timestamp dataInicio = rs.getTimestamp("data_inicio");
                Timestamp dataFim = rs.getTimestamp("data_fim");
                String tarefaRotacao = rs.getString("tarefa_rotacao");
                Integer rotaId = rs.getInt("rota_id");
                entidade = new TarefaRota(id, observacao, dataInicio, dataFim, tarefaRotacao, rotaId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<TarefaRota> selectAllTarefaRota() {
        List<TarefaRota> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_TAREFA_ROTA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                Timestamp dataInicio = rs.getTimestamp("data_inicio");
                Timestamp dataFim = rs.getTimestamp("data_fim");
                String tarefaRotacao = rs.getString("tarefa_rotacao");
                Integer rotaId = rs.getInt("rota_id");
                entidades.add(new TarefaRota(id, observacao, dataInicio, dataFim, tarefaRotacao, rotaId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteTarefaRota(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_TAREFA_ROTA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateTarefaRota(TarefaRota entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_TAREFA_ROTA_SQL)) {
            statement.setInt(1, entidade.getId());
            statement.setString(2, entidade.getObservacao());
            statement.setTimestamp(3, entidade.getDataInicio());
            statement.setTimestamp(4, entidade.getDataFim());
            statement.setString(5, entidade.getTarefaRotacao());
            statement.setInt(5, entidade.getRotaId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}