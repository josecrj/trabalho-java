package Servico;
import java.util.ArrayList;
import DAO.VisitanteDAO;
import Dominio.Visitante;




public class ServicoVISITANTE extends BaseGenericaSRV<Visitante> {

    public ServicoVISITANTE() {
        this.DAO = new VisitanteDAO();
    }


    @Override 
    public Visitante create(Visitante novo) {

        if (novo == null) {
            throw new IllegalArgumentException("O visitante não pode ser nulo.");
        }

        if (novo.getCodigo() < 0) {
            throw new IllegalArgumentException("O código do visitante não pode ser negativo; use zero para gerar automaticamente.");
        }

        if (novo.getNome() == null || novo.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do visitante não pode ser nulo ou vazio.");
        }

        if (novo.getCpf() == null || novo.getCpf().isBlank()) {
            throw new IllegalArgumentException("O CPF do visitante não pode ser nulo ou vazio.");
        }

        if (novo.getEmail() == null || novo.getEmail().isBlank()) {
            throw new IllegalArgumentException("O email do visitante não pode ser nulo ou vazio.");
        }

        if (novo.getTelefone() == null || novo.getTelefone().isBlank()) {
            throw new IllegalArgumentException("O telefone do visitante não pode ser nulo ou vazio.");
        }

        if (novo.getEndereco() == null || novo.getEndereco().isBlank()) {
            throw new IllegalArgumentException("O endereço do visitante não pode ser nulo ou vazio.");
        }

        if (novo.getMotivoVisita() == null || novo.getMotivoVisita().isBlank()) {
            throw new IllegalArgumentException("O motivo da visita não pode ser nulo ou vazio.");
        }

        if (novo.getSetorVisita() == null || novo.getSetorVisita().isBlank()) {
            throw new IllegalArgumentException("O setor da visita não pode ser nulo ou vazio.");
        }

        if (novo.getCrachaNumero() <= 0) {
            throw new IllegalArgumentException("O número do crachá deve ser maior que zero.");
        }

        return this.DAO.create(novo);
    }

    @Override 

    public Visitante update(Visitante alterado) {

        if (alterado == null) {
            throw new IllegalArgumentException("O visitante não pode ser nulo.");
        }

        if (alterado.getCodigo() <= 0) {
            throw new IllegalArgumentException("O código do visitante deve ser maior que zero.");
        }

        if (alterado.getNome() == null || alterado.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do visitante não pode ser nulo ou vazio.");
        }

        if (alterado.getCpf() == null || alterado.getCpf().isBlank()) {
            throw new IllegalArgumentException("O CPF do visitante não pode ser nulo ou vazio.");
        }

        if (alterado.getEmail() == null || alterado.getEmail().isBlank()) {
            throw new IllegalArgumentException("O email do visitante não pode ser nulo ou vazio.");
        }

        if (alterado.getTelefone() == null || alterado.getTelefone().isBlank()) {
            throw new IllegalArgumentException("O telefone do visitante não pode ser nulo ou vazio.");
        }

        if (alterado.getEndereco() == null || alterado.getEndereco().isBlank()) {
            throw new IllegalArgumentException("O endereço do visitante não pode ser nulo ou vazio.");
        }

        if (alterado.getMotivoVisita() == null || alterado.getMotivoVisita().isBlank()) {
            throw new IllegalArgumentException("O motivo da visita não pode ser nulo ou vazio.");
        }

        if (alterado.getSetorVisita() == null || alterado.getSetorVisita().isBlank()) {
            throw new IllegalArgumentException("O setor da visita não pode ser nulo ou vazio.");
        }

        if (alterado.getCrachaNumero() <= 0) {
            throw new IllegalArgumentException("O número do crachá deve ser maior que zero.");
        }

        if (this.DAO.readOne(alterado.getCodigo()) == null) {
            throw new IllegalArgumentException("Visitante não encontrado.");
        }

        return this.DAO.update(alterado);
    }

    @Override 
    public ArrayList<Visitante> readAll() {

        ArrayList<Visitante> registros = this.DAO.readAll();

        if(registros == null || registros.isEmpty()) {
            throw new IllegalStateException("Não existem visitantes cadastrados.");
        }

        return registros;
    }

    @Override 

    public Visitante readOne(int codigo) {

        if (codigo <= 0) {
            throw new IllegalArgumentException("O código do visitante deve ser maior que zero.");
        }

        Visitante registro = this.DAO.readOne(codigo);

        if (registro == null) {
            throw new IllegalArgumentException("Visitante não encontrado.");
        }

        return registro;
    }

    @Override 
    public Visitante deletePorId(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException("O código do visitante deve ser maior que zero.");
        }

        Visitante registroParaDeletar = this.DAO.readOne(id);

        if (registroParaDeletar == null) {
            throw new IllegalArgumentException("Visitante não encontrado.");
        }

        return this.DAO.deletePorId(id);
    }
}

