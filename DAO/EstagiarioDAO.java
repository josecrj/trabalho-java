package DAO;

import Dominio.Estagiario;
import FakeDB.EstagiarioFakeDB;
import java.util.ArrayList;

public class EstagiarioDAO extends BaseGenericaDAO<Estagiario> {

    public EstagiarioDAO() {
        this.FonteDeDados = new EstagiarioFakeDB();
        this.Repositorio = this.FonteDeDados.getDados();
    }

    @Override
    public Estagiario create(Estagiario novo) {
        if (novo == null) {
            return null;
        }

        int codigoAtual = 0;
        novo.setCodigo(codigoAtual + 1);
        this.Repositorio.add(novo);
        return novo;
    }

    @Override
    public Estagiario readOne(int codigo) {
        for (Estagiario estagiario : this.Repositorio) {
            if (estagiario.getCodigo() == codigo) {
                return estagiario;
            }
        }
        return null;
    }

    @Override
    public Estagiario update(Estagiario alterado) {
        if (alterado == null) {
            return null;
        }

        Estagiario existente = this.readOne(alterado.getCodigo());
        if (existente == null) {
            return null;
        }

        int index = this.Repositorio.indexOf(existente);
        this.Repositorio.set(index, alterado);
        return alterado;
    }

    @Override
    public Estagiario deletePorId(int id) {
        Estagiario estagiarioParaDeletar = this.readOne(id);
        if (estagiarioParaDeletar != null) {
            this.Repositorio.remove(estagiarioParaDeletar);
            return estagiarioParaDeletar;
        }
        return null;
    }

    @Override
    public ArrayList<Estagiario> readAll() {
        return this.Repositorio;
    }
}
