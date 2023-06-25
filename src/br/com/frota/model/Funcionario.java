package br.com.frota.model;
import br.com.frota.DAO.PessoaDAO;
public class Funcionario extends GenericModel{
    private String codigoFuncional;
    private Integer pessoaId;
    static  private PessoaDAO pessoaDao = new PessoaDAO();
    public Funcionario(Integer id, String codigoFuncional, Integer pessoaId) {
        super.setId(id);
        this.codigoFuncional = codigoFuncional;
        this.pessoaId = pessoaId;
    }

    public String getCodigoFuncional() {
        return codigoFuncional;
    }

    public Integer getPessoaId() {
        return pessoaId;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id='" + this.getId() + '\'' +
                "codigoFuncional='" + codigoFuncional + '\'' +
                ", pessoaId=" + pessoaDao.selectPessoaById(pessoaId) +
                '}';
    }
}
