package Dominio;

public abstract class BasePrestador extends BasePessoa {
    protected String email;
    protected String telefone;
    protected String endereco;

    public BasePrestador() {
        super();
    }

    public BasePrestador(int codigo, String nome, String cpf,
                         String email, String telefone, String endereco) {
        super(codigo, nome, cpf);
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
