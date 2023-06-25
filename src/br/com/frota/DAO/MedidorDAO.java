package br.com.frota.DAO;

import br.com.frota.model.Medidor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedidorDAO extends ConexaoDB{
    private static final String INSERT_MEDIDOR_SQL = "INSERT INTO medidor (descricao, rota_id, poste_id) VALUES (?, ?, ?);";
    private static final String SELECT_MEDIDOR_BY_ID = "SELECT id, descricao, rota_id, poste_id FROM medidor WHERE id = ?";
    private static final String SELECT_ALL_MEDIDOR = "SELECT * FROM medidor;";
    private static final String DELETE_MEDIDOR_SQL = "DELETE FROM medidor WHERE id = ?;";
    private static final String UPDATE_MEDIDOR_SQL = "UPDATE medidor SET id = ? descricao = ?, rota_id = ?, poste_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM medidor;";

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

    public void insertMedidor(Medidor entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_MEDIDOR_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setInt(2, entidade.getRotaId());
            preparedStatement.setInt(3, entidade.getPosteId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Medidor selectMedidorById(int id) {
        Medidor entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_MEDIDOR_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                Integer rotaId = rs.getInt("rota_id");
                Integer posteId = rs.getInt("poste_id");
                entidade = new Medidor(id, descricao, rotaId, posteId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Medidor> selectAllMedidor() {
        List<Medidor> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_MEDIDOR)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                Integer rotaId = rs.getInt("rota_id");
                Integer posteId = rs.getInt("poste_id");
                entidades.add(new Medidor(id, descricao, rotaId, posteId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteMedidor(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_MEDIDOR_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateMedidor(Medidor entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_MEDIDOR_SQL)) {
            statement.setInt(1, entidade.getId());
            statement.setString(2, entidade.getDescricao());
            statement.setInt(3, entidade.getRotaId());
            statement.setInt(4, entidade.getPosteId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}