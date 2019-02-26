package br.edu.ifro.querointernet.model;

import java.io.Serializable;
import java.util.Date;

public class SolicitacaoViabilidade implements Serializable {
    private int id;
    private int tipoTecnologia;
    private boolean planoResidencial;
    private boolean planoEmpresarial;
    private boolean planoDedicado;
    private boolean deUmAQuatroMB;
    private boolean deCincoADezMB;
    private boolean deDezACinquentaMB;
    private boolean acimaDeCinquentaMB;
    private String dataLancamento;
    private Endereco endereco;

    public SolicitacaoViabilidade() {
        this.endereco = new Endereco();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoTecnologia() {
        return tipoTecnologia;
    }

    public void setTipoTecnologia(int tipoTecnologia) {
        this.tipoTecnologia = tipoTecnologia;
    }

    public boolean isPlanoResidencial() {
        return planoResidencial;
    }

    public void setPlanoResidencial(boolean planoResidencial) {
        this.planoResidencial = planoResidencial;
    }

    public boolean isPlanoEmpresarial() {
        return planoEmpresarial;
    }

    public void setPlanoEmpresarial(boolean planoEmpresarial) {
        this.planoEmpresarial = planoEmpresarial;
    }

    public boolean isPlanoDedicado() {
        return planoDedicado;
    }

    public void setPlanoDedicado(boolean planoDedicado) {
        this.planoDedicado = planoDedicado;
    }

    public boolean isDeUmAQuatroMB() {
        return deUmAQuatroMB;
    }

    public void setDeUmAQuatroMB(boolean deUmAQuatroMB) {
        this.deUmAQuatroMB = deUmAQuatroMB;
    }

    public boolean isDeCincoADezMB() {
        return deCincoADezMB;
    }

    public void setDeCincoADezMB(boolean deCincoADezMB) {
        this.deCincoADezMB = deCincoADezMB;
    }

    public boolean isDeDezACinquentaMB() {
        return deDezACinquentaMB;
    }

    public void setDeDezACinquentaMB(boolean deDezACinquentaMB) {
        this.deDezACinquentaMB = deDezACinquentaMB;
    }

    public boolean isAcimaDeCinquentaMB() {
        return acimaDeCinquentaMB;
    }

    public void setAcimaDeCinquentaMB(boolean acimaDeCinquentaMB) {
        this.acimaDeCinquentaMB = acimaDeCinquentaMB;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @Override
    public String toString() {
        return String.format("Solicitação %d%n\nDia %s", this.getId(), this.getDataLancamento());
    }

    public String getAlertDialogMessage() {
        return String.format("> Plano residencial? %s;\n", this.isPlanoResidencial() ? "Sim" : "Não");
    }
}
