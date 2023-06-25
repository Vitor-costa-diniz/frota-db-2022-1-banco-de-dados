package br.com.frota.model;

import br.com.frota.DAO.ClasseDAO;
import br.com.frota.DAO.ClienteDAO;
import br.com.frota.DAO.MedidorDAO;

import java.sql.Timestamp;

public class Contrato extends GenericModel{
    private String descricao;
    private Timestamp dataInicio;
    private Timestamp dataCriacao;
    private Integer medidorId;
    private Integer classeId;
    private Integer clienteId;
    static private MedidorDAO medidorDao = new MedidorDAO();
    static private ClasseDAO classeDao = new ClasseDAO();
    static private ClienteDAO clienteDao = new ClienteDAO();

    public Contrato(Integer id, String descricao, Timestamp dataInicio, Timestamp dataCriacao, Integer medidorId, Integer classeId, Integer clienteId) {
        super.setId(id);
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataCriacao = dataCriacao;
        this.medidorId = medidorId;
        this.classeId = classeId;
        this.clienteId = clienteId;
    }

    public String getDescricao() {
        return descricao;
    }

    public Timestamp getDataInicio() {
        return dataInicio;
    }

    public Timestamp getDataCriacao() {
        return dataCriacao;
    }

    public Integer getMedidorId() {
        return medidorId;
    }

    public Integer getClasseId() {
        return classeId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "id='" + this.getId() + '\'' +
                "descricao='" + descricao + '\'' +
                ", dataInicio='" + dataInicio + '\'' +
                ", dataCriacao='" + dataCriacao + '\'' +
                ", medidorId=" + medidorDao.selectMedidorById(medidorId) +
                ", classeId=" + classeDao.selectClasseById(classeId) +
                ", clienteId=" + clienteDao.selectClienteById(clienteId) +
                '}';
    }
}