package br.com.frota.model;

public class Rota extends GenericModel{
    private String descricao;

    public Rota(Integer id, String descricao) {
        super.setId(id);
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Rota{" +
                "id='" + this.getId() + '\'' +
                "descricao='" + descricao + '\'' +
                '}';
    }
}