
package modelo;

public class Funcionario {
    
    private Integer Id;
    private String Cpf;
    private String Nome;
    private String Situacao;
    private String Alteracao;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getSituacao() {
        return Situacao;
    }

    public void setSituacao(String Situacao) {
        this.Situacao = Situacao;
    }

    public String getAlteracao() {
        return Alteracao;
    }

    public void setAlteracao(String Alteracao) {
        this.Alteracao = Alteracao;
    }
    
    
    
}
