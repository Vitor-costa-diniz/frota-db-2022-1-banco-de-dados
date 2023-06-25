package br.com.frota.model;

import br.com.frota.DAO.TipoFaseDAO;

public class Classe extends GenericModel {
    private String descricao;
    private Integer tipoFaseId;
    static private TipoFaseDAO tipoFaseDao = new TipoFaseDAO();

    public Classe(Integer id, String descricao, Integer tipoFaseId) {
        super.setId(id);
        this.descricao = descricao;
        this.tipoFaseId = tipoFaseId;
    }


    public String getDescricao() {
        return descricao;
    }
    public Integer getTipoFaseId() {
        return tipoFaseId;
    }
    @Override
    public java.lang.String toString() {
        return "Classe{" +
                "id='" + this.getId() + '\'' +
                "descricao='" + descricao + '\'' +
                ", idTipoFase=" + tipoFaseDao.selectTipoFaseById(tipoFaseId) +
                '}';
    }
}