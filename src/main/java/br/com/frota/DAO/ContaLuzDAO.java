package br.com.frota.DAO;

import br.com.frota.model.ContaLuz;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ContaLuzDAO extends ConexaoDB {

    private static final String JOIN_TABLES_QUERY = "SELECT ml.id, ml.mes, ml.ano, ml.data_medicao, ml.consumo, " +
            "cb.id AS cobranca_id, cb.mes_referencia, cb.ano_referencia, cb.tarifa_id, " +
            "ct.id AS contrato_id, ct.descricao, ct.data_inicio, ct.data_criacao, " +
            "ct.medidor_id AS medidor_id_contrato, ct.classe_id, ct.cliente_id " +
            "FROM medicao ml " +
            "INNER JOIN cobranca cb ON ml.id = cb.medicao_id " +
            "INNER JOIN contrato ct ON cb.medicao_id = ct.id " +
            "WHERE ml.id = ? AND ml.mes = ? AND ml.ano = ?";

    public List<ContaLuz> obterContasLuz() {
        List<ContaLuz> contasLuz = new ArrayList<>();

        String query = "SELECT ml.id, ml.mes, ml.ano, ml.data_medicao, ml.consumo, " +
                "cb.id AS cobranca_id, cb.mes_referencia, cb.ano_referencia, cb.tarifa_id, " +
                "ct.id AS contrato_id, ct.descricao, ct.data_inicio, ct.data_criacao, " +
                "ct.medidor_id AS medidor_id_contrato, ct.classe_id, ct.cliente_id " +
                "FROM medicao ml " +
                "INNER JOIN cobranca cb ON ml.id = cb.medicao_id " +
                "INNER JOIN contrato ct ON cb.medicao_id = ct.id";

        try (PreparedStatement preparedStatement = prepararSQL(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int medicaoIdResult = rs.getInt("medicao_id");
                String mesResult = rs.getString("mes");
                String anoResult = rs.getString("ano");
                Timestamp dataMedicao = rs.getTimestamp("data_medicao");
                String consumo = rs.getString("consumo");
                int cobrancaId = rs.getInt("cobranca_id");
                String mesReferencia = rs.getString("mes_referencia");
                String anoReferencia = rs.getString("ano_referencia");
                int tarifaId = rs.getInt("tarifa_id");
                int contratoId = rs.getInt("contrato_id");
                String descricao = rs.getString("descricao");
                Timestamp dataInicio = rs.getTimestamp("data_inicio");
                Timestamp dataCriacao = rs.getTimestamp("data_criacao");
                int medidorIdContrato = rs.getInt("medidor_id_contrato");
                int classeId = rs.getInt("classe_id");
                int clienteId = rs.getInt("cliente_id");

                ContaLuz contaLuz = new ContaLuz(medicaoIdResult, mesResult, anoResult, dataMedicao, consumo, medidorIdContrato,
                        cobrancaId, mesReferencia, anoReferencia, tarifaId, contratoId, descricao,
                        dataInicio, dataCriacao, medidorIdContrato, classeId, clienteId);

                contasLuz.add(contaLuz);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return contasLuz;
    }
}