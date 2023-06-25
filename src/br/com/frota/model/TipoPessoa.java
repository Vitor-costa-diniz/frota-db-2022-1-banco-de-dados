package br.com.frota.model;

public class TipoPessoa extends GenericModel {
    private String descricao;

    public TipoPessoa(Integer id, String descricao) {
        super.setId(id);
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "TipoPessoa{" +
                "id='" + this.getId() + '\'' +
                "descricao='" + descricao + '\'' +
                '}';
    }
}