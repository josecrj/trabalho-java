package Servico;
import DAO.EgressoDAO;
import Dominio.Egresso;
import java.util.ArrayList;




public class ServicoEGRESSO extends BaseGenericaSRV<Egresso> {

    public ServicoEGRESSO() {
        this.DAO = new EgressoDAO();
    }


    @Override 
    public Egresso create(Egresso novo) {

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

        if (novo.getCursoFormacao() == null || novo.getCursoFormacao().isBlank()) {
            return null;
        }

        if (novo.getAreaAtuacao() == null || novo.getAreaAtuacao().isBlank()) {
            return null;
        }

        if (novo.getAnoConclusao() <= 0 || novo.getAnoConclusao() > java.time.Year.now().getValue()) {
            return null;
        }

        return this.DAO.create(novo);
    }

    @Override 

    public Egresso update(Egresso alterado) {

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

        if (alterado.getCursoFormacao() == null || alterado.getCursoFormacao().isBlank()) {
            return null;
        }

        if (alterado.getAreaAtuacao() == null || alterado.getAreaAtuacao().isBlank()) {
            return null;
        }

        if (alterado.getAnoConclusao() <= 0 || alterado.getAnoConclusao() > java.time.Year.now().getValue()) {
            return null;
        }

        if (this.DAO.readOne(alterado.getCodigo()) == null) {
            return null;
        }

        return this.DAO.update(alterado);
    }

    @Override 
    public ArrayList<Egresso> readAll() {

        return this.DAO.readAll();
    }

    @Override 

    public Egresso readOne(int codigo) {

        if (codigo <= 0) {
            return null;
        }

        return this.DAO.readOne(codigo);
    }

    @Override 
    public Egresso deletePorId(int id) {

        if (id <= 0) {
            return null;
        }

        return this.DAO.deletePorId(id);
    }
}

