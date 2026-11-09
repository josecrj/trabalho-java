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
            return null;
        }

        if (novo.getCodigo() < 0) {
            return null;
        }

        if (novo.getNome() == null || novo.getNome().isBlank()) {
            return null;
        }

        if (novo.getCpf() == null || novo.getCpf().isBlank()) {
            return null;
        }

        if (novo.getEmail() == null || novo.getEmail().isBlank()) {
            return null;
        }

        if (novo.getTelefone() == null || novo.getTelefone().isBlank()) {
            return null;
        }

        if (novo.getEndereco() == null || novo.getEndereco().isBlank()) {
            return null;
        }

        if (novo.getMotivoVisita() == null || novo.getMotivoVisita().isBlank()) {
            return null;
        }

        if (novo.getSetorVisita() == null || novo.getSetorVisita().isBlank()) {
            return null;
        }

        if (novo.getCrachaNumero() <= 0) {
            return null;
        }

        return this.DAO.create(novo);
    }

    @Override 

    public Visitante update(Visitante alterado) {

        if (alterado == null) {
            return null;
        }

        if (alterado.getCodigo() <= 0) {
            return null;
        }

        if (alterado.getNome() == null || alterado.getNome().isBlank()) {
            return null;
        }

        if (alterado.getCpf() == null || alterado.getCpf().isBlank()) {
            return null;
        }

        if (alterado.getEmail() == null || alterado.getEmail().isBlank()) {
            return null;
        }

        if (alterado.getTelefone() == null || alterado.getTelefone().isBlank()) {
            return null;
        }

        if (alterado.getEndereco() == null || alterado.getEndereco().isBlank()) {
            return null;
        }

        if (alterado.getMotivoVisita() == null || alterado.getMotivoVisita().isBlank()) {
            return null;
        }

        if (alterado.getSetorVisita() == null || alterado.getSetorVisita().isBlank()) {
            return null;
        }

        if (alterado.getCrachaNumero() <= 0) {
            return null;
        }

        if (this.DAO.readOne(alterado.getCodigo()) == null) {
            return null;
        }

        return this.DAO.update(alterado);
    }

    @Override 
    public ArrayList<Visitante> readAll() {

        return this.DAO.readAll();
    }

    @Override 

    public Visitante readOne(int codigo) {

        if (codigo <= 0) {
            return null;
        }

        return this.DAO.readOne(codigo);
    }

    @Override 
    public Visitante deletePorId(int id) {

        if (id <= 0) {
            return null;
        }

        return this.DAO.deletePorId(id);
    }
}

