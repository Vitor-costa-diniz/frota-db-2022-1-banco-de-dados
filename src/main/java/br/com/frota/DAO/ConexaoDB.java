package br.com.frota.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoDB {
    private static final String dbName = "conta_de_luz";
    private static final String dbURL = "jdbc:postgresql://localhost:5432/";
    private static final String username = "postgres";
    private static final String password = "123";

    public static Connection conexaoDB() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conexaoDB = DriverManager.getConnection(dbURL.concat(dbName), username, password);

        if (conexaoDB != null) {
            System.out.println("Conexão com o banco de dados gerada com sucesso! ");
            return conexaoDB;
        } else {
            throw new RuntimeException("Ops! Erro ao conectar com o banco de dados. :(");
        }
    }

    public static PreparedStatement prepararSQL(String sql) throws SQLException, ClassNotFoundException {
        return conexaoDB().prepareStatement(sql);
    }

    public void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("Estado do SQL: " + ((SQLException) e).getSQLState());
                System.err.println("Codigo do ERRO: " + ((SQLException) e).getErrorCode());
                System.err.println("Messagem: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Causa: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public static void criarTabelas() {
        String[] createTableQueries = {
                "CREATE TABLE IF NOT EXISTS tipo_fase(" +
                        "id SERIAL PRIMARY KEY," +
                        "descricao VARCHAR(45)" +
                        ");",

                "CREATE TABLE IF NOT EXISTS classe(" +
                        "id SERIAL PRIMARY KEY," +
                        "descricao VARCHAR(45)," +
                        "id_tipo_fase INT REFERENCES tipo_fase(id)" +
                        ");",

                "CREATE TABLE IF NOT EXISTS tarifa(" +
                        "id SERIAL PRIMARY KEY," +
                        "taxa VARCHAR(45)," +
                        "classe INT REFERENCES classe(id)," +
                        "lei VARCHAR(45) NOT NULL," +
                        "data_inicio TIMESTAMP NOT NULL," +
                        "data_final TIMESTAMP NOT NULL" +
                        "aliquota_ICMS VARCHAR(45)" +
                        ");",

                "CREATE TABLE IF NOT EXISTS tipo_pessoa(" +
                        "id SERIAL PRIMARY KEY," +
                        "descricao VARCHAR(45)" +
                        ");",

                "CREATE TABLE IF NOT EXISTS pessoa(" +
                        "id SERIAL PRIMARY KEY," +
                        "nome VARCHAR(45) NOT NULL," +
                        "cpf VARCHAR(45) NOT NULL," +
                        "cnpj VARCHAR(45)," +
                        "tipo_pessoa_id INT REFERENCES tipo_pessoa(id)" +
                        ");",

                "CREATE TABLE IF NOT EXISTS funcionario(" +
                        "id SERIAL PRIMARY KEY," +
                        "codigo_funcional VARCHAR(45) NOT NULL," +
                        "pessoa_id INT REFERENCES pessoa(id)" +
                        ");",

                "CREATE TABLE IF NOT EXISTS cliente (" +
                        "id SERIAL PRIMARY KEY," +
                        "num_documento VARCHAR(45) NOT NULL UNIQUE," +
                        "num_cliente VARCHAR(45) NOT NULL UNIQUE," +
                        "pessoa_id INT REFERENCES pessoa(id)" +
                        ");",

                "CREATE TABLE IF NOT EXISTS rota(" +
                        "id SERIAL PRIMARY KEY," +
                        "descricao VARCHAR(45)" +
                        ");",

                "CREATE TABLE IF NOT EXISTS poste(" +
                        "id SERIAL PRIMARY KEY," +
                        "latitude VARCHAR(45)," +
                        "longitude VARCHAR(45)," +
                        "codigo VARCHAR(45)," +
                        "obervacao VARCHAR(45)" +
                        ");",

                "CREATE TABLE IF NOT EXISTS medidor(" +
                        "id SERIAL PRIMARY KEY," +
                        "descricao VARCHAR(45)," +
                        "rota_id INT REFERENCES rota(id)," +
                        "poste_id INT REFERENCES poste(id)" +
                        ");",

                "CREATE TABLE IF NOT EXISTS tarefa_rota(" +
                        "id SERIAL PRIMARY KEY," +
                        "observacao VARCHAR(45)," +
                        "data_inicio TIMESTAMP," +
                        "data_fim TIMESTAMP," +
                        "tarefa_rotacao VARCHAR (45)," +
                        "rota_id INT REFERENCES rota(id)" +
                        ");",

                "CREATE TABLE IF NOT EXISTS time_rota (" +
                        "id SERIAL PRIMARY KEY," +
                        "funcionario_id INT REFERENCES funcionario(id)," +
                        "tarefa_rota_id INT REFERENCES tarefa_rota(id)" +
                        ");",

                "CREATE TABLE IF NOT EXISTS medicao(" +
                        "id SERIAL PRIMARY KEY," +
                        "mes VARCHAR(45)," +
                        "ano VARCHAR(45)," +
                        "data_medicao TIMESTAMP," +
                        "consumo VARCHAR(45)," +
                        "medidor_id INT REFERENCES medidor(id)," +
                        "time_rota_id INT REFERENCES time_rota(id)" +
                        ");",

                "CREATE TABLE IF NOT EXISTS cobranca(" +
                        "id SERIAL PRIMARY KEY," +
                        "mes_referencia VARCHAR(45)," +
                        "ano_referencia VARCHAR(45)," +
                        "tarifa_id INT REFERENCES tarifa(id)," +
                        "medicao_id INT REFERENCES medicao(id)" +
                        ");",

                "CREATE TABLE IF NOT EXISTS contrato (" +
                        "id SERIAL PRIMARY KEY," +
                        "descricao VARCHAR(45)," +
                        "data_inicio TIMESTAMP," +
                        "data_criacao TIMESTAMP," +
                        "medidor_id INT REFERENCES medidor(id)," +
                        "classe_id INT REFERENCES classe(id)," +
                        "cliente_id INT REFERENCES cliente(id)" +
                        ");"
        };

        try (Connection connection = conexaoDB(); Statement statement = connection.createStatement()) {
            for (String query : createTableQueries) {
                statement.executeUpdate(query);
            }

            System.out.println("Tabelas criadas com sucesso!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
  }

