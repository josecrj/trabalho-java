package Servico;
import java.util.ArrayList;
import DAO.ColaboradorDAO;
import Dominio.Colaborador;




public class ServicoCOLABORADOR extends BaseGenericaSRV<Colaborador> {

    public ServicoCOLABORADOR() {
        this.DAO = new ColaboradorDAO();
    }


    @Override 
    public Colaborador create(Colaborador novo) {

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

        if (novo.getCargo() == null || novo.getCargo().isBlank()) {
            return null;
        }

        return this.DAO.create(novo);
    }

    @Override 

    public Colaborador update(Colaborador alterado) {

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

        if (alterado.getCargo() == null || alterado.getCargo().isBlank()) {
            return null;
        }

        if (this.DAO.readOne(alterado.getCodigo()) == null) {
            return null;
        }

        return this.DAO.update(alterado);
    }

    @Override 
    public ArrayList<Colaborador> readAll() {

        return this.DAO.readAll();
    }

    @Override 

    public Colaborador readOne(int codigo) {

        if (codigo <= 0) {
            return null;
        }

        return this.DAO.readOne(codigo);
    }

    @Override 
    public Colaborador deletePorId(int id) {

        if (id <= 0) {
            return null;
        }

        return this.DAO.deletePorId(id);
    }
}

