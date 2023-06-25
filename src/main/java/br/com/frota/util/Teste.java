package br.com.frota.util;

import br.com.frota.DAO.*;

public class Teste {
    static TipoPessoaDAO tipo_pessoaDAO = new TipoPessoaDAO();
    static PessoaDAO pessoa = new PessoaDAO();
    static RotaDAO rota = new RotaDAO();
    static TarefaRotaDAO tarefaRota = new TarefaRotaDAO();
    static TimeRotaDAO timeRotaDAO = new TimeRotaDAO();
    static FuncionarioDAO funcionario = new FuncionarioDAO();

    public static void main(String[] args) throws Exception {
//        ConexaoDB.criarTabelas(); // Chamada para criar as tabelas

        System.out.println(timeRotaDAO.selectTimeRotaById(0));

        // Restante do código...
    }
}