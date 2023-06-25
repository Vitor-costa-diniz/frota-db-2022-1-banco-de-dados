package br.com.frota.DAO;

import br.com.frota.model.Funcionario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO extends ConexaoDB{
    private static final String INSERT_FUNCIONARIO_SQL = "INSERT INTO funcionario (funcionario_id, tarefa_rota_id) VALUES (?, ?);";
    private static final String SELECT_FUNCIONARIO_BY_ID = "SELECT id, funcionario_id, tarefa_rota_id FROM funcionario WHERE id = ?";
    private static final String SELECT_ALL_FUNCIONARIO = "SELECT * FROM funcionario;";
    private static final String DELETE_FUNCIONARIO_SQL = "DELETE FROM funcionario WHERE id = ?;";
    private static final String UPDATE_FUNCIONARIO_SQL = "UPDATE funcionario SET funcionario_id = ?, tarefa_rota_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM funcionario;";

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

    public void insertFuncionario(Funcionario entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_FUNCIONARIO_SQL)) {
            preparedStatement.setString(1, entidade.getCodigoFuncional());
            preparedStatement.setInt(2, entidade.getPessoaId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Funcionario selectFuncionarioById(int id) {
        Funcionario entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_FUNCIONARIO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String codigoFuncional = rs.getString("codigo_funcional");
                Integer pessoaId = rs.getInt("pessoa_id");
                entidade = new Funcionario(id, codigoFuncional, pessoaId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Funcionario> selectAllFuncionario() {
        List<Funcionario> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_FUNCIONARIO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String codigoFuncional = rs.getString("codigo_funcional");
                Integer pessoaId = rs.getInt("pessoa_id");
                entidades.add(new Funcionario(id, codigoFuncional, pessoaId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteFuncionario(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_FUNCIONARIO_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateFuncionario(Funcionario entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_FUNCIONARIO_SQL)) {
            statement.setInt(1, entidade.getId());
            statement.setString(2, entidade.getCodigoFuncional());
            statement.setInt(3, entidade.getPessoaId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}