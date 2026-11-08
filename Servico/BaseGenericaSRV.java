package Servico;
import java.util.ArrayList;
import DAO.BaseGenericaDAO;



public abstract class BaseGenericaSRV<T> {

    protected BaseGenericaDAO<T> DAO;


    public T create(T novo) {
        return this.DAO.create(novo);
    }

    public T update(T alterado) {
        return this.DAO.update(alterado);
    }

    public T deletePorId(int id) {
        return this.DAO.deletePorId(id);
    }

    public java.util.ArrayList<T> readAll() {
        return this.DAO.readAll();
    }

    public T readOne(int codigo) {
        return this.DAO.readOne(codigo);
    }
    
}
