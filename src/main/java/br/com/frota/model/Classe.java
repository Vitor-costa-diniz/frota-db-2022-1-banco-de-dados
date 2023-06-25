package br.com.frota.model;

import br.com.frota.DAO.TipoFaseDAO;
import io.github.astrapi69.model.GenericModel;

public class Classe extends GenericModel {
    private String descricao;
    private Integer tipoFaseId;
    private static TipoFaseDAO tipoFaseDao;

    static {
        tipoFaseDao = new TipoFaseDAO();
    }

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
    public String toString() {
        return "Classe{" +
                "id='" + this.getId() + '\'' +
                "descricao='" + descricao + '\'' +
                ", idTipoFase=" + tipoFaseDao.selectTipoFaseById(tipoFaseId) +
                '}';
    }
}