package Dominio;

public class Visitante extends BasePrestador {
    private String motivoVisita;
    private int crachaNumero;
    private String setorVisita;

    public Visitante() {
        super();
    }

    public Visitante(int codigo, String nome, String cpf, String email,
                    String telefone, String endereco, String motivoVisita,
                    int crachaNumero, String setorVisita) {
        super(codigo, nome, cpf, email, telefone, endereco);
        this.motivoVisita = motivoVisita;
        this.crachaNumero = crachaNumero;
        this.setorVisita = setorVisita;
    }

    public String getMotivoVisita() {
        return motivoVisita;
    }

    public void setMotivoVisita(String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }

    public int getCrachaNumero() {
        return crachaNumero;
    }

    public void setCrachaNumero(int crachaNumero) {
        this.crachaNumero = crachaNumero;
    }

    public String getSetorVisita() {
        return setorVisita;
    }

    public void setSetorVisita(String setorVisita) {
        this.setorVisita = setorVisita;
    }

    @Override
    public void exibir() {
        System.out.println("[VISITANTE] Código: " + codigo);
        System.out.println("| Nome: " + nome);
        System.out.println("| CPF: " + cpf);
        System.out.println("| Email: " + email);
        System.out.println("| Telefone: " + telefone);
        System.out.println("| Endereço: " + endereco);
        System.out.println("| Motivo da Visita: " + motivoVisita);
        System.out.println("| Número do Crachá: " + crachaNumero);
        System.out.println("| Setor de Visita: " + setorVisita);
    }
}
