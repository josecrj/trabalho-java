package DAO;
import Dominio.Colaborador;
import FakeDB.ColaboradorFakeDB;
import java.util.ArrayList;

public class ColaboradorDAO extends BaseGenericaDAO<Colaborador>{

    public ColaboradorDAO() {
    this.FonteDeDados = new ColaboradorFakeDB();
    this.Repositorio = this.FonteDeDados.getDados();
}

    @Override
    public Colaborador create(Colaborador novo) {

        if(novo == null){
            return null; // Retorna null se o objeto novo for nulo
        }

        int codigoAtual = this.Repositorio.getLast().getCodigo();
        novo.setCodigo(codigoAtual + 1);
        this.Repositorio.add(novo);
        return novo;
    }

    @Override

    public Colaborador readOne(int codigo) {
        for (Colaborador colaborador : this.Repositorio) {
            if (colaborador.getCodigo() == codigo) {
                return colaborador;
            }
        }
        return null; // Retorna null se não encontrar o colaborador
    }

    @Override 

    public Colaborador update(Colaborador alterado) {
    Colaborador existente = this.readOne(alterado.getCodigo());

    if (existente == null) {
        return null;
    }

    int index = this.Repositorio.indexOf(existente);
    this.Repositorio.set(index, alterado);
    return alterado;
}

    @Override
    public Colaborador deletePorId(int id) {
        Colaborador colaboradorParaDeletar = this.readOne(id);
        if (colaboradorParaDeletar != null) {
            this.Repositorio.remove(colaboradorParaDeletar);
            return colaboradorParaDeletar;
        }
        return null; // Retorna null se não encontrar o colaborador
    }

    @Override 
    public ArrayList<Colaborador> readAll() {
        return this.Repositorio;
           
        }


    









    






    
}
