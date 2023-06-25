package br.com.frota.model;
public class Poste extends GenericModel{
    private String latitude;
    private String longitude;
    private String codigo;
    private String observacao;

    public Poste(Integer id, String latitude, String longitude, String codigo, String observacao) {
        super.setId(id);
        this.latitude = latitude;
        this.longitude = longitude;
        this.codigo = codigo;
        this.observacao = observacao;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getObservacao() {
        return observacao;
    }

    @Override
    public String toString() {
        return "Poste{" +
                "id='" + this.getId() + '\'' +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", codigo='" + codigo + '\'' +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}
