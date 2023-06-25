package br.com.frota.model;

import br.com.frota.DAO.PessoaDAO;

public class Cliente extends GenericModel{
    private String numDocumento;
    private String numCliente;
    private Integer pessoaId;
    static private PessoaDAO pessoaDao = new PessoaDAO();

    public Cliente(Integer id, String numDocumento, String numCliente, Integer pessoaId) {
        super.setId(id);
        this.numDocumento = numDocumento;
        this.numCliente = numCliente;
        this.pessoaId = pessoaId;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public String getNumCliente() {
        return numCliente;
    }

    public Integer getPessoaId() {
        return pessoaId;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + this.getId() + '\'' +
                "numDocumento='" + numDocumento + '\'' +
                ", numCliente='" + numCliente + '\'' +
                ", pessoaId=" + pessoaDao.selectPessoaById(pessoaId) +
                '}';
    }
}