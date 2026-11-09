package Servico;
import java.util.ArrayList;
import DAO.AlunoDAO;
import Dominio.Aluno;




public class ServicoALUNO extends BaseGenericaSRV<Aluno> {

    public ServicoALUNO() {
        this.DAO = new AlunoDAO();
    }


    @Override 
    public Aluno create(Aluno novo) {

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

        if (novo.getMatricula() == null || novo.getMatricula().isBlank()) {
            return null;
        }

        if (!Double.isFinite(novo.getNota()) || novo.getNota() < 0.0 || novo.getNota() > 10.0) {
            return null;
        }

        return this.DAO.create(novo);
    }

    @Override 

    public Aluno update(Aluno alterado) {

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

        if (alterado.getMatricula() == null || alterado.getMatricula().isBlank()) {
            return null;
        }

        if (!Double.isFinite(alterado.getNota()) || alterado.getNota() < 0.0 || alterado.getNota() > 10.0) {
            return null;
        }

        if (this.DAO.readOne(alterado.getCodigo()) == null) {
            return null;
        }

        return this.DAO.update(alterado);
    }

    @Override 
    public ArrayList<Aluno> readAll() {

        return this.DAO.readAll();
    }

    @Override 

    public Aluno readOne(int codigo) {

        if (codigo <= 0) {
            return null;
        }

        return this.DAO.readOne(codigo);
    }

    @Override 
    public Aluno deletePorId(int id) {

        if (id <= 0) {
            return null;
        }

        return this.DAO.deletePorId(id);
    }
}

