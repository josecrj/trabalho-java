package Servico;
import java.util.ArrayList;
import DAO.ColaboradorDAO;
import Dominio.Colaborador;




public class ServicoCOLABORADOR extends BaseGenericaSRV<Colaborador> {

    public ServicoCOLABORADOR() {
        this.DAO = new ColaboradorDAO();
    }


    @Override 
    public Colaborador create(Colaborador novo) {

        if (novo == null) {
            throw new IllegalArgumentException("O colaborador não pode ser nulo.");
        }

        if (novo.getCodigo() < 0) {
            throw new IllegalArgumentException("O código do colaborador não pode ser negativo; use zero para gerar automaticamente.");
        }

        if (novo.getNome() == null || novo.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do colaborador não pode ser nulo ou vazio.");
        }

        if (novo.getCpf() == null || novo.getCpf().isBlank()) {
            throw new IllegalArgumentException("O CPF do colaborador não pode ser nulo ou vazio.");
        }

        if (novo.getCargo() == null || novo.getCargo().isBlank()) {
            throw new IllegalArgumentException("O cargo do colaborador não pode ser nulo ou vazio.");
        }

        return this.DAO.create(novo);
    }

    @Override 

    public Colaborador update(Colaborador alterado) {

        if (alterado == null) {
            throw new IllegalArgumentException("O colaborador não pode ser nulo.");
        }

        if (alterado.getCodigo() <= 0) {
            throw new IllegalArgumentException("O código do colaborador deve ser maior que zero.");
        }

        if (alterado.getNome() == null || alterado.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do colaborador não pode ser nulo ou vazio.");
        }

        if (alterado.getCpf() == null || alterado.getCpf().isBlank()) {
            throw new IllegalArgumentException("O CPF do colaborador não pode ser nulo ou vazio.");
        }

        if (alterado.getCargo() == null || alterado.getCargo().isBlank()) {
            throw new IllegalArgumentException("O cargo do colaborador não pode ser nulo ou vazio.");
        }

        if (this.DAO.readOne(alterado.getCodigo()) == null) {
            throw new IllegalArgumentException("Colaborador não encontrado.");
        }

        return this.DAO.update(alterado);
    }

    @Override 
    public ArrayList<Colaborador> readAll() {

        ArrayList<Colaborador> registros = this.DAO.readAll();

        if(registros == null || registros.isEmpty()) {
            throw new IllegalStateException("Não existem colaboradores cadastrados.");
        }

        return registros;
    }

    @Override 

    public Colaborador readOne(int codigo) {

        if (codigo <= 0) {
            throw new IllegalArgumentException("O código do colaborador deve ser maior que zero.");
        }

        Colaborador registro = this.DAO.readOne(codigo);

        if (registro == null) {
            throw new IllegalArgumentException("Colaborador não encontrado.");
        }

        return registro;
    }

    @Override 
    public Colaborador deletePorId(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException("O código do colaborador deve ser maior que zero.");
        }

        Colaborador registroParaDeletar = this.DAO.readOne(id);

        if (registroParaDeletar == null) {
            throw new IllegalArgumentException("Colaborador não encontrado.");
        }

        return this.DAO.deletePorId(id);
    }
}

