package Servico;
import java.util.ArrayList;
import DAO.EstagiarioDAO;
import Dominio.Estagiario;




public class ServicoESTAGIARIO extends BaseGenericaSRV<Estagiario> {

    public ServicoESTAGIARIO() {
        this.DAO = new EstagiarioDAO();
    }


    @Override 
    public Estagiario create(Estagiario novo) {

        if (novo == null) {
            throw new IllegalArgumentException("O estagiário não pode ser nulo.");
        }

        if (novo.getCodigo() < 0) {
            throw new IllegalArgumentException("O código do estagiário não pode ser negativo; use zero para gerar automaticamente.");
        }

        if (novo.getNome() == null || novo.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do estagiário não pode ser nulo ou vazio.");
        }

        if (novo.getCpf() == null || novo.getCpf().isBlank()) {
            throw new IllegalArgumentException("O CPF do estagiário não pode ser nulo ou vazio.");
        }

        if (novo.getEmail() == null || novo.getEmail().isBlank()) {
            throw new IllegalArgumentException("O email do estagiário não pode ser nulo ou vazio.");
        }

        if (novo.getTelefone() == null || novo.getTelefone().isBlank()) {
            throw new IllegalArgumentException("O telefone do estagiário não pode ser nulo ou vazio.");
        }

        if (novo.getEndereco() == null || novo.getEndereco().isBlank()) {
            throw new IllegalArgumentException("O endereço do estagiário não pode ser nulo ou vazio.");
        }

        if (novo.getAreaEstagio() == null || novo.getAreaEstagio().isBlank()) {
            throw new IllegalArgumentException("A área de estágio do estagiário não pode ser nulo ou vazio.");
        }

        if (novo.getValorBolsa() == null || !Double.isFinite(novo.getValorBolsa()) || novo.getValorBolsa() < 0) {
            throw new IllegalArgumentException("O valor da bolsa deve ser informado e não pode ser negativo.");
        }

        if (novo.getCargaHorariaSemanal() <= 0 || novo.getCargaHorariaSemanal() > 168) {
            throw new IllegalArgumentException("A carga horária semanal deve estar entre 1 e 168 horas.");
        }

        return this.DAO.create(novo);
    }

    @Override 

    public Estagiario update(Estagiario alterado) {

        if (alterado == null) {
            throw new IllegalArgumentException("O estagiário não pode ser nulo.");
        }

        if (alterado.getCodigo() <= 0) {
            throw new IllegalArgumentException("O código do estagiário deve ser maior que zero.");
        }

        if (alterado.getNome() == null || alterado.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do estagiário não pode ser nulo ou vazio.");
        }

        if (alterado.getCpf() == null || alterado.getCpf().isBlank()) {
            throw new IllegalArgumentException("O CPF do estagiário não pode ser nulo ou vazio.");
        }

        if (alterado.getEmail() == null || alterado.getEmail().isBlank()) {
            throw new IllegalArgumentException("O email do estagiário não pode ser nulo ou vazio.");
        }

        if (alterado.getTelefone() == null || alterado.getTelefone().isBlank()) {
            throw new IllegalArgumentException("O telefone do estagiário não pode ser nulo ou vazio.");
        }

        if (alterado.getEndereco() == null || alterado.getEndereco().isBlank()) {
            throw new IllegalArgumentException("O endereço do estagiário não pode ser nulo ou vazio.");
        }

        if (alterado.getAreaEstagio() == null || alterado.getAreaEstagio().isBlank()) {
            throw new IllegalArgumentException("A área de estágio do estagiário não pode ser nulo ou vazio.");
        }

        if (alterado.getValorBolsa() == null || !Double.isFinite(alterado.getValorBolsa()) || alterado.getValorBolsa() < 0) {
            throw new IllegalArgumentException("O valor da bolsa deve ser informado e não pode ser negativo.");
        }

        if (alterado.getCargaHorariaSemanal() <= 0 || alterado.getCargaHorariaSemanal() > 168) {
            throw new IllegalArgumentException("A carga horária semanal deve estar entre 1 e 168 horas.");
        }

        if (this.DAO.readOne(alterado.getCodigo()) == null) {
            throw new IllegalArgumentException("Estagiário não encontrado.");
        }

        return this.DAO.update(alterado);
    }

    @Override 
    public ArrayList<Estagiario> readAll() {

        ArrayList<Estagiario> registros = this.DAO.readAll();

        if(registros == null || registros.isEmpty()) {
            throw new IllegalStateException("Não existem estagiários cadastrados.");
        }

        return registros;
    }

    @Override 

    public Estagiario readOne(int codigo) {

        if (codigo <= 0) {
            throw new IllegalArgumentException("O código do estagiário deve ser maior que zero.");
        }

        Estagiario registro = this.DAO.readOne(codigo);

        if (registro == null) {
            throw new IllegalArgumentException("Estagiário não encontrado.");
        }

        return registro;
    }

    @Override 
    public Estagiario deletePorId(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException("O código do estagiário deve ser maior que zero.");
        }

        Estagiario registroParaDeletar = this.DAO.readOne(id);

        if (registroParaDeletar == null) {
            throw new IllegalArgumentException("Estagiário não encontrado.");
        }

        return this.DAO.deletePorId(id);
    }
}

