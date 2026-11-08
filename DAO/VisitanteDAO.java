package DAO;

import Dominio.Visitante;
import FakeDB.VisitanteFakeDB;
import java.util.ArrayList;

public class VisitanteDAO extends BaseGenericaDAO<Visitante> {

    public VisitanteDAO() {
        this.FonteDeDados = new VisitanteFakeDB();
        this.Repositorio = this.FonteDeDados.getDados();
    }

    @Override
    public Visitante create(Visitante novo) {
        if (novo == null) {
            return null;
        }
        int codigoAtual = this.Repositorio.getLast().getCodigo();
        novo.setCodigo(codigoAtual + 1);
        this.Repositorio.add(novo);
        return novo;
    }

    @Override
    public Visitante readOne(int codigo) {
        for (Visitante visitante : this.Repositorio) {
            if (visitante.getCodigo() == codigo) {
                return visitante;
            }
        }
        return null;
    }

    @Override
    public Visitante update(Visitante alterado) {
        if (alterado == null) {
            return null;
        }

        Visitante existente = this.readOne(alterado.getCodigo());
        if (existente == null) {
            return null;
        }

        int index = this.Repositorio.indexOf(existente);
        this.Repositorio.set(index, alterado);
        return alterado;
    }

    @Override
    public Visitante deletePorId(int id) {
        Visitante visitanteParaDeletar = this.readOne(id);
        if (visitanteParaDeletar != null) {
            this.Repositorio.remove(visitanteParaDeletar);
            return visitanteParaDeletar;
        }
        return null;
    }

    @Override
    public ArrayList<Visitante> readAll() {
        return this.Repositorio;
    }
}
