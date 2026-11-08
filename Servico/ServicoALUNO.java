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
            throw new IllegalArgumentException("O aluno não pode ser nulo.");
        }

        if (novo.getCodigo() < 0) {
            throw new IllegalArgumentException("O código do aluno não pode ser negativo; use zero para gerar automaticamente.");
        }

        if (novo.getNome() == null || novo.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do aluno não pode ser nulo ou vazio.");
        }

        if (novo.getCpf() == null || novo.getCpf().isBlank()) {
            throw new IllegalArgumentException("O CPF do aluno não pode ser nulo ou vazio.");
        }

        if (novo.getMatricula() == null || novo.getMatricula().isBlank()) {
            throw new IllegalArgumentException("A matrícula do aluno não pode ser nulo ou vazio.");
        }

        if (!Double.isFinite(novo.getNota()) || novo.getNota() < 0.0 || novo.getNota() > 10.0) {
            throw new IllegalArgumentException("A nota do aluno deve estar entre 0 e 10.");
        }

        return this.DAO.create(novo);
    }

    @Override 

    public Aluno update(Aluno alterado) {

        if (alterado == null) {
            throw new IllegalArgumentException("O aluno não pode ser nulo.");
        }

        if (alterado.getCodigo() <= 0) {
            throw new IllegalArgumentException("O código do aluno deve ser maior que zero.");
        }

        if (alterado.getNome() == null || alterado.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do aluno não pode ser nulo ou vazio.");
        }

        if (alterado.getCpf() == null || alterado.getCpf().isBlank()) {
            throw new IllegalArgumentException("O CPF do aluno não pode ser nulo ou vazio.");
        }

        if (alterado.getMatricula() == null || alterado.getMatricula().isBlank()) {
            throw new IllegalArgumentException("A matrícula do aluno não pode ser nulo ou vazio.");
        }

        if (!Double.isFinite(alterado.getNota()) || alterado.getNota() < 0.0 || alterado.getNota() > 10.0) {
            throw new IllegalArgumentException("A nota do aluno deve estar entre 0 e 10.");
        }

        if (this.DAO.readOne(alterado.getCodigo()) == null) {
            throw new IllegalArgumentException("Aluno não encontrado.");
        }

        return this.DAO.update(alterado);
    }

    @Override 
    public ArrayList<Aluno> readAll() {

        ArrayList<Aluno> registros = this.DAO.readAll();

        if(registros == null || registros.isEmpty()) {
            throw new IllegalStateException("Não existem alunos cadastrados.");
        }

        return registros;
    }

    @Override 

    public Aluno readOne(int codigo) {

        if (codigo <= 0) {
            throw new IllegalArgumentException("O código do aluno deve ser maior que zero.");
        }

        Aluno registro = this.DAO.readOne(codigo);

        if (registro == null) {
            throw new IllegalArgumentException("Aluno não encontrado.");
        }

        return registro;
    }

    @Override 
    public Aluno deletePorId(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException("O código do aluno deve ser maior que zero.");
        }

        Aluno registroParaDeletar = this.DAO.readOne(id);

        if (registroParaDeletar == null) {
            throw new IllegalArgumentException("Aluno não encontrado.");
        }

        return this.DAO.deletePorId(id);
    }
}

