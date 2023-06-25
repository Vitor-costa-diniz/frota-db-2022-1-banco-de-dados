package br.com.frota.util;

import br.com.frota.DAO.*;
import br.com.frota.model.Contrato;

import java.sql.Timestamp;


public class Teste {
    public static void main(String[] args) throws Exception {
//        ConexaoDB.criarTabelas()

        ContratoDAO contratoDAO = new ContratoDAO();

        Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis() + 1);


        Contrato contrato = new Contrato(0, "Mora Solo", timestamp1, timestamp2, 1, 1, 3);

        contratoDAO.insertContrato(contrato);

        System.out.println(contratoDAO.selectAllContrato());

    }
}