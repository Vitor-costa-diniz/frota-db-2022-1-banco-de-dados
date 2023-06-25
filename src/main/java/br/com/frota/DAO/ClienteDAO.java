package br.com.frota.DAO;

import br.com.frota.model.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends ConexaoDB{
    private static final String INSERT_CLIENTE_SQL = "INSERT INTO cliente (num_documento, num_cliente, pessoa_id) VALUES (?, ?, ?);";
    private static final String SELECT_CLIENTE_BY_ID = "SELECT id, num_documento, num_cliente, pessoa_id FROM cliente WHERE id = ?";
    private static final String SELECT_ALL_CLIENTE = "SELECT * FROM cliente;";
    private static final String DELETE_CLIENTE_SQL = "DELETE FROM cliente WHERE id = ?;";
    private static final String UPDATE_CLIENTE_SQL = "UPDATE cliente SET id = ?, num_documento = ?, num_cliente = ?, pessoa_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM cliente;";

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

    public void insertCliente(Cliente entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_CLIENTE_SQL)) {
            preparedStatement.setString(1, entidade.getNumDocumento());
            preparedStatement.setString(2, entidade.getNumCliente());
            preparedStatement.setInt(3, entidade.getPessoaId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente selectClienteById(int id) {
        Cliente entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_CLIENTE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String numDocumento = rs.getString("num_documento");
                String numCliente = rs.getString("num_cliente");
                Integer pessoaId = rs.getInt("pessoa_id");

                entidade = new Cliente(id, numDocumento, numCliente, pessoaId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Cliente> selectAllCliente() {
        List<Cliente> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_CLIENTE)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String numDocumento = rs.getString("num_documento");
                String numCliente = rs.getString("num_cliente");
                Integer pessoaId = rs.getInt("pessoa_id");
                entidades.add(new Cliente(id, numDocumento, numCliente, pessoaId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteCliente(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_CLIENTE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateCliente(Cliente entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_CLIENTE_SQL)) {
            statement.setInt(1, entidade.getId());
            statement.setString(2, entidade.getNumDocumento());
            statement.setString(3, entidade.getNumCliente());
            statement.setInt(4, entidade.getPessoaId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}