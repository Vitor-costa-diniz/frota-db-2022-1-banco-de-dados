package br.com.frota.model;

import br.com.frota.DAO.FuncionarioDAO;
import br.com.frota.DAO.TarefaRotaDAO;

public class TimeRota extends GenericModel{
    private Integer funcionarioId;
    private Integer tarefaRotaId;
    static private FuncionarioDAO funcionarioDao = new FuncionarioDAO();
    static private TarefaRotaDAO tarefaRotaDao = new TarefaRotaDAO();

    public TimeRota(Integer id, Integer funcionarioId, Integer tarefaRotaId) {
        super.setId(id);
        this.funcionarioId = funcionarioId;
        this.tarefaRotaId = tarefaRotaId;
    }

    public Integer getFuncionarioId() {
        return funcionarioId;
    }

    public Integer getTarefaRotaId() {
        return tarefaRotaId;
    }

    @Override
    public String toString() {
        return "TimeRota{" +
                "id='" + this.getId() + '\'' +
                "funcionarioId=" + funcionarioDao.selectFuncionarioById(funcionarioId) +
                ", tarefaRotaId=" + tarefaRotaDao.selectTarefaRotaById(tarefaRotaId) +
                '}';
    }
}