package br.com.frota.model;

import br.com.frota.DAO.ClasseDAO;

import java.sql.Timestamp;

public class Tarifa extends GenericModel{
    private String taxa;
    private Integer classeId;
    private String lei;
    private Timestamp dataInicio;
    private Timestamp dataFinal;
    static private ClasseDAO classeDao = new ClasseDAO();

    public Tarifa(Integer id, String taxa, Integer classeId, String lei, Timestamp dataInicio, Timestamp dataFinal) {
        super.setId(id);
        this.taxa = taxa;
        this.classeId = classeId;
        this.lei = lei;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }

    public String getTaxa() {
        return taxa;
    }

    public Integer getClasse() {
        return classeId;
    }

    public String getLei() {
        return lei;
    }

    public Timestamp getDataInicio() {
        return dataInicio;
    }

    public Timestamp getDataFinal() {
        return dataFinal;
    }

    @Override
    public java.lang.String toString() {
        return "Tarifa{" +
                "id='" + this.getId() + '\'' +
                "taxa='" + taxa + '\'' +
                ", classe=" + classeDao.selectClasseById(classeId) +
                ", lei='" + lei + '\'' +
                ", dataInicio='" + dataInicio + '\'' +
                ", dataFinal='" + dataFinal + '\'' +
                '}';
    }
}