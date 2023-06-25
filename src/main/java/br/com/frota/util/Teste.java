package br.com.frota.util;

import br.com.frota.DAO.*;
import br.com.frota.model.Cliente;
import br.com.frota.model.Funcionario;
import br.com.frota.model.Rota;

public class Teste {
    public static void main(String[] args) throws Exception {
//        ConexaoDB.criarTabelas()

        RotaDAO rotaDAO = new RotaDAO();

        Rota rota01 = new Rota(0, "Fortaleza");
        Rota rota02 = new Rota(0, "Aquiraz");
        Rota rota03 = new Rota(0, "Quixada");

        rotaDAO.insertRota(rota01);
        rotaDAO.insertRota(rota02);
        rotaDAO.insertRota(rota03);

        System.out.println(rotaDAO.selectAllRota());
    }
}