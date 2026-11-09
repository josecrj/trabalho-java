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

        if (novo.getAreaEstagio() == null || novo.getAreaEstagio().isBlank()) {
            return null;
        }

        if (novo.getValorBolsa() == null || !Double.isFinite(novo.getValorBolsa()) || novo.getValorBolsa() < 0) {
            return null;
        }

        if (novo.getCargaHorariaSemanal() <= 0 || novo.getCargaHorariaSemanal() > 168) {
            return null;
        }

        return this.DAO.create(novo);
    }

    @Override 

    public Estagiario update(Estagiario alterado) {

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

        if (alterado.getAreaEstagio() == null || alterado.getAreaEstagio().isBlank()) {
            return null;
        }

        if (alterado.getValorBolsa() == null || !Double.isFinite(alterado.getValorBolsa()) || alterado.getValorBolsa() < 0) {
            return null;
        }

        if (alterado.getCargaHorariaSemanal() <= 0 || alterado.getCargaHorariaSemanal() > 168) {
            return null;
        }

        if (this.DAO.readOne(alterado.getCodigo()) == null) {
            return null;
        }

        return this.DAO.update(alterado);
    }

    @Override 
    public ArrayList<Estagiario> readAll() {

        return this.DAO.readAll();
    }

    @Override 

    public Estagiario readOne(int codigo) {

        if (codigo <= 0) {
            return null;
        }

        return this.DAO.readOne(codigo);
    }

    @Override 
    public Estagiario deletePorId(int id) {

        if (id <= 0) {
            return null;
        }

        return this.DAO.deletePorId(id);
    }
}

