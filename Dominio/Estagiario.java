package Dominio;

public class Estagiario extends BasePrestador {
    private Double valorBolsa;
    private int cargaHorariaSemanal;
    private String areaEstagio;

    public Estagiario() {
        super();
    }

    public Estagiario(int codigo, String nome, String cpf, String email,
                     String telefone, String endereco, Double valorBolsa,
                     int cargaHorariaSemanal, String areaEstagio) {
        super(codigo, nome, cpf, email, telefone, endereco);
        this.valorBolsa = valorBolsa;
        this.cargaHorariaSemanal = cargaHorariaSemanal;
        this.areaEstagio = areaEstagio;
    }

    public Double getValorBolsa() {
        return valorBolsa;
    }

    public void setValorBolsa(Double valorBolsa) {
        this.valorBolsa = valorBolsa;
    }

    public int getCargaHorariaSemanal() {
        return cargaHorariaSemanal;
    }

    public void setCargaHorariaSemanal(int cargaHorariaSemanal) {
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }

    public String getAreaEstagio() {
        return areaEstagio;
    }

    public void setAreaEstagio(String areaEstagio) {
        this.areaEstagio = areaEstagio;
    }

    @Override
    public void exibir() {
        System.out.println("[ESTAGIÁRIO] Código: " + codigo);
        System.out.println("| Nome: " + nome);
        System.out.println("| CPF: " + cpf);
        System.out.println("| Email: " + email);
        System.out.println("| Telefone: " + telefone);
        System.out.println("| Endereço: " + endereco);
        System.out.println("| Valor da bolsa: R$ " + valorBolsa);
        System.out.println("| Carga horária semanal: " + cargaHorariaSemanal);
        System.out.println("| Área de estágio: " + areaEstagio);
    }
}
