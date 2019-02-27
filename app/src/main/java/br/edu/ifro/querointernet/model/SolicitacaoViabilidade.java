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

    public String getTipoTecnologiaString() {
        switch (this.tipoTecnologia) {
            case 0:
                return "Nenhum";
            case 1:
                return "Via rádio";
            case 2:
                return "Fibra óptica";
            case 3:
                return "ADSL";
            case 4:
                return "Internet móvel";
            case 5:
                return "Todas as tecnologias";
            default:
                return "Nenhum";
        }
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
        return String.format(" > Tipo de tecnologia: %s;" +
                        "\n > Plano Residencial?  %s;" +
                        "\n > Plano empresarial?  %s;" +
                        "\n > Plano dedicado?  %s;" +
                        "\n > Internet de 1 a 4 Megas?  %s;" +
                        "\n > Internet 5 a 10 Megas? %s;" +
                        "\n > Internet 10 a 50 Megas? %s;" +
                        "\n > Internet acima de 50 Megas? %s;" +
                        "\n > CEP: %s;" +
                        "\n > Logradouro: %s;" +
                        "\n > Número: %s;" +
                        "\n > Complemento: %s;" +
                        "\n > Bairro: %s;" +
                        "\n > Cidade: %s;" +
                        "\n < UF: %s.",
                this.getTipoTecnologiaString(),
                this.isPlanoResidencial() ? "Sim" : "Não",
                this.isPlanoEmpresarial() ? "Sim" : "Não",
                this.isPlanoDedicado() ? "Sim" : "Não",
                this.isDeUmAQuatroMB() ? "Sim" : "Não",
                this.isDeCincoADezMB() ? "Sim" : "Não",
                this.isDeDezACinquentaMB() ? "Sim" : "Não",
                this.isAcimaDeCinquentaMB() ? "Sim" : "Não",
                this.getEndereco().getCep(),
                this.getEndereco().getLogradouro(),
                this.getEndereco().getNumero(),
                this.getEndereco().getComplemento(),
                this.getEndereco().getBairro(),
                this.getEndereco().getLocalidade(),
                this.getEndereco().getUf()
        );
    }

}