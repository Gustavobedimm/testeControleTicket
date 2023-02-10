package modelo;

public class Ticket {

private Integer Id;
private Integer IdFuncionario;
private Integer Quantidade;
private String Situacao;
private String DataEntrega;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Integer getIdFuncionario() {
        return IdFuncionario;
    }

    public void setIdFuncionario(Integer IdFuncionario) {
        this.IdFuncionario = IdFuncionario;
    }

    public Integer getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(Integer Quantidade) {
        this.Quantidade = Quantidade;
    }

    public String getSituacao() {
        return Situacao;
    }

    public void setSituacao(String Situacao) {
        this.Situacao = Situacao;
    }

    public String getDataEntrega() {
        return DataEntrega;
    }

    public void setDataEntrega(String DataEntrega) {
        this.DataEntrega = DataEntrega;
    }

}
