package br.com.frota.util;

import br.com.frota.DAO.*;
import br.com.frota.model.Tarifa;

import java.sql.Timestamp;


public class Teste {
    public static void main(String[] args) throws Exception {
//        ConexaoDB.adicionarColunaAliquotaICMS();

        TarifaDAO tarifaDAO = new TarifaDAO();

        Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());

        Tarifa tarifa = new Tarifa(0, "0.1", 1, "PL3260", timestamp1, timestamp2,"0.07");

        tarifaDAO.insertTarifa(tarifa);

        System.out.println(tarifaDAO.selectAllTarifa());

    }
}