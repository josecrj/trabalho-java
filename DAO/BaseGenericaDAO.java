package DAO;
import FakeDB.BaseGenericaFakeDB;
import java.util.ArrayList;

public abstract class BaseGenericaDAO<T>{

protected BaseGenericaFakeDB<T> FonteDeDados;

protected ArrayList<T> Repositorio;



public abstract T create (T novo);

public abstract T update (T alterado);

public abstract T deletePorId (int id);

public ArrayList<T> readAll(){

return this.Repositorio;
}

public abstract T readOne(int codigo);


}