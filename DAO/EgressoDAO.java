package DAO;

import Dominio.Egresso;
import FakeDB.EgressoFakeDB;
import java.util.ArrayList;


public class EgressoDAO extends BaseGenericaDAO<Egresso> {

    public EgressoDAO() {
        this.FonteDeDados = new EgressoFakeDB();
        this.Repositorio = this.FonteDeDados.getDados();
    }

    @Override

    public Egresso create(Egresso novo){
        
        if (novo == null) {
            return null;
        }
        int codigoAtual = this.Repositorio.getLast().getCodigo();
        novo.setCodigo(codigoAtual + 1);
        this.Repositorio.add(novo);
        return novo;

    }

    @Override 

    public ArrayList<Egresso> readAll() {
        return this.Repositorio;
    }


    @Override
    public Egresso readOne(int codigo) {
        for (Egresso egresso : this.Repositorio) {
            if (egresso.getCodigo() == codigo) {
                return egresso;
            }
        }
        return null;
    }

    @Override 

    public Egresso update(Egresso alterado) {
        Egresso existente = this.readOne(alterado.getCodigo());

        if (existente == null) {
            return null;
        }

        int index = this.Repositorio.indexOf(existente);
        this.Repositorio.set(index, alterado);
        return alterado;
    }

    @Override
    public Egresso deletePorId(int id) {    
        
        Egresso egressoParaDeletar = this.readOne(id);
        if (egressoParaDeletar != null) {
            this.Repositorio.remove(egressoParaDeletar);
            return egressoParaDeletar;
        }
        return null; // Retorna null se não encontrar o egresso
    }




}

   