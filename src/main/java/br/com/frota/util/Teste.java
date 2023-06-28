package br.com.frota.util;

import br.com.frota.DAO.*;


public class Teste {
    public static void main(String[] args) throws Exception {

        ContaLuzDAO contaLuzDAO = new ContaLuzDAO();


        System.out.println(contaLuzDAO.obterContasLuz());

    }
}