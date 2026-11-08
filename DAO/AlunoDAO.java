package DAO;

import Dominio.Aluno;
import FakeDB.AlunoFakeDB;
import java.util.ArrayList;

public class AlunoDAO extends BaseGenericaDAO<Aluno> {

    public AlunoDAO() {
        this.FonteDeDados = new AlunoFakeDB();
        this.Repositorio = this.FonteDeDados.getDados();
    }

    @Override
    public Aluno create(Aluno novo) {
        if (novo == null) {
            return null;
        }

        int codigoAtual = 0;
        for (Aluno aluno : this.Repositorio) {
            codigoAtual = Math.max(codigoAtual, aluno.getCodigo());
        }

        novo.setCodigo(codigoAtual + 1);
        this.Repositorio.add(novo);
        return novo;
    }

    @Override
    public Aluno readOne(int codigo) {
        for (Aluno aluno : this.Repositorio) {
            if (aluno.getCodigo() == codigo) {
                return aluno;
            }
        }
        return null;
    }

    @Override
    public Aluno update(Aluno alterado) {
        if (alterado == null) {
            return null;
        }

        Aluno existente = this.readOne(alterado.getCodigo());
        if (existente == null) {
            return null;
        }

        int index = this.Repositorio.indexOf(existente);
        this.Repositorio.set(index, alterado);
        return alterado;
    }

    @Override
    public Aluno deletePorId(int id) {
        Aluno alunoParaDeletar = this.readOne(id);
        if (alunoParaDeletar != null) {
            this.Repositorio.remove(alunoParaDeletar);
            return alunoParaDeletar;
        }
        return null;
    }

    @Override
    public ArrayList<Aluno> readAll() {
        return this.Repositorio;
    }
}
