package br.com.frota.model;

import java.sql.Timestamp;

public class ContaLuz {
    private int medicaoId;
    private String mes;
    private String ano;
    private Timestamp dataMedicao;
    private String consumo;
    private int medidorIdContrato;
    private int timeRotaId;
    private int cobrancaId;
    private String mesReferencia;
    private String anoReferencia;
    private int tarifaId;
    private int contratoId;
    private String descricao;
    private Timestamp dataInicio;
    private Timestamp dataCriacao;
    private int medidorId;
    private int classeId;
    private int clienteId;

    public ContaLuz(int medicaoId, String mes, String ano, Timestamp dataMedicao, String consumo, int medidorIdContrato,
                    int cobrancaId, String mesReferencia, String anoReferencia, int tarifaId, int contratoId,
                    String descricao, Timestamp dataInicio, Timestamp dataCriacao, int medidorId, int classeId,
                    int clienteId) {
        this.medicaoId = medicaoId;
        this.mes = mes;
        this.ano = ano;
        this.dataMedicao = dataMedicao;
        this.consumo = consumo;
        this.medidorIdContrato = medidorIdContrato;
        this.cobrancaId = cobrancaId;
        this.mesReferencia = mesReferencia;
        this.anoReferencia = anoReferencia;
        this.tarifaId = tarifaId;
        this.contratoId = contratoId;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataCriacao = dataCriacao;
        this.medidorId = medidorId;
        this.classeId = classeId;
        this.clienteId = clienteId;
    }

    // Getters e Setters

    public int getMedicaoId() {
        return medicaoId;
    }

    public void setMedicaoId(int medicaoId) {
        this.medicaoId = medicaoId;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Timestamp getDataMedicao() {
        return dataMedicao;
    }

    public void setDataMedicao(Timestamp dataMedicao) {
        this.dataMedicao = dataMedicao;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public int getMedidorIdContrato() {
        return medidorIdContrato;
    }

    public void setMedidorIdContrato(int medidorIdContrato) {
        this.medidorIdContrato = medidorIdContrato;
    }

    public int getTimeRotaId() {
        return timeRotaId;
    }

    public void setTimeRotaId(int timeRotaId) {
        this.timeRotaId = timeRotaId;
    }

    public int getCobrancaId() {
        return cobrancaId;
    }

    public void setCobrancaId(int cobrancaId) {
        this.cobrancaId = cobrancaId;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public String getAnoReferencia() {
        return anoReferencia;
    }

    public void setAnoReferencia(String anoReferencia) {
        this.anoReferencia = anoReferencia;
    }

    public int getTarifaId() {
        return tarifaId;
    }

    public void setTarifaId(int tarifaId) {
        this.tarifaId = tarifaId;
    }

    public int getContratoId() {
        return contratoId;
    }

    public void setContratoId(int contratoId) {
        this.contratoId = contratoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Timestamp getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Timestamp dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Timestamp getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Timestamp dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getMedidorId() {
        return medidorId;
    }

    public void setMedidorId(int medidorId) {
        this.medidorId = medidorId;
    }

    public int getClasseId() {
        return classeId;
    }

    public void setClasseId(int classeId) {
        this.classeId = classeId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public String toString() {
        return "ContaLuz{" +
                "medicaoId=" + medicaoId +
                ", mes='" + mes + '\'' +
                ", ano='" + ano + '\'' +
                ", dataMedicao=" + dataMedicao +
                ", consumo='" + consumo + '\'' +
                ", medidorIdContrato=" + medidorIdContrato +
                ", timeRotaId=" + timeRotaId +
                ", cobrancaId=" + cobrancaId +
                ", mesReferencia='" + mesReferencia + '\'' +
                ", anoReferencia='" + anoReferencia + '\'' +
                ", tarifaId=" + tarifaId +
                ", contratoId=" + contratoId +
                ", descricao='" + descricao + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataCriacao=" + dataCriacao +
                ", medidorId=" + medidorId +
                ", classeId=" + classeId +
                ", clienteId=" + clienteId +
                '}';
    }
}