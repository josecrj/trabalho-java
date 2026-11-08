package Servico;
import DAO.EgressoDAO;
import Dominio.Egresso;
import java.util.ArrayList;




public class ServicoEGRESSO extends BaseGenericaSRV<Egresso> {

    public ServicoEGRESSO() {
        this.DAO = new EgressoDAO();
    }


    @Override 
    public Egresso create(Egresso novo) {

        if (novo == null) {
            throw new IllegalArgumentException("O egresso não pode ser nulo.");
        }

        if (novo.getCodigo() < 0) {
            throw new IllegalArgumentException("O código do egresso não pode ser negativo; use zero para gerar automaticamente.");
        }

        if (novo.getNome() == null || novo.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do egresso não pode ser nulo ou vazio.");
        }

        if (novo.getCpf() == null || novo.getCpf().isBlank()) {
            throw new IllegalArgumentException("O CPF do egresso não pode ser nulo ou vazio.");
        }

        if (novo.getCursoFormacao() == null || novo.getCursoFormacao().isBlank()) {
            throw new IllegalArgumentException("O curso de formação do egresso não pode ser nulo ou vazio.");
        }

        if (novo.getAreaAtuacao() == null || novo.getAreaAtuacao().isBlank()) {
            throw new IllegalArgumentException("A área de atuação do egresso não pode ser nulo ou vazio.");
        }

        if (novo.getAnoConclusao() <= 0 || novo.getAnoConclusao() > java.time.Year.now().getValue()) {
            throw new IllegalArgumentException("O ano de conclusão deve ser positivo e não pode estar no futuro.");
        }

        return this.DAO.create(novo);
    }

    @Override 

    public Egresso update(Egresso alterado) {

        if (alterado == null) {
            throw new IllegalArgumentException("O egresso não pode ser nulo.");
        }

        if (alterado.getCodigo() <= 0) {
            throw new IllegalArgumentException("O código do egresso deve ser maior que zero.");
        }

        if (alterado.getNome() == null || alterado.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do egresso não pode ser nulo ou vazio.");
        }

        if (alterado.getCpf() == null || alterado.getCpf().isBlank()) {
            throw new IllegalArgumentException("O CPF do egresso não pode ser nulo ou vazio.");
        }

        if (alterado.getCursoFormacao() == null || alterado.getCursoFormacao().isBlank()) {
            throw new IllegalArgumentException("O curso de formação do egresso não pode ser nulo ou vazio.");
        }

        if (alterado.getAreaAtuacao() == null || alterado.getAreaAtuacao().isBlank()) {
            throw new IllegalArgumentException("A área de atuação do egresso não pode ser nulo ou vazio.");
        }

        if (alterado.getAnoConclusao() <= 0 || alterado.getAnoConclusao() > java.time.Year.now().getValue()) {
            throw new IllegalArgumentException("O ano de conclusão deve ser positivo e não pode estar no futuro.");
        }

        if (this.DAO.readOne(alterado.getCodigo()) == null) {
            throw new IllegalArgumentException("Egresso não encontrado.");
        }

        return this.DAO.update(alterado);
    }

    @Override 
    public ArrayList<Egresso> readAll() {

        ArrayList<Egresso> registros = this.DAO.readAll();

        if(registros == null || registros.isEmpty()) {
            throw new IllegalStateException("Não existem egressos cadastrados.");
        }

        return registros;
    }

    @Override 

    public Egresso readOne(int codigo) {

        if (codigo <= 0) {
            throw new IllegalArgumentException("O código do egresso deve ser maior que zero.");
        }

        Egresso registro = this.DAO.readOne(codigo);

        if (registro == null) {
            throw new IllegalArgumentException("Egresso não encontrado.");
        }

        return registro;
    }

    @Override 
    public Egresso deletePorId(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException("O código do egresso deve ser maior que zero.");
        }

        Egresso registroParaDeletar = this.DAO.readOne(id);

        if (registroParaDeletar == null) {
            throw new IllegalArgumentException("Egresso não encontrado.");
        }

        return this.DAO.deletePorId(id);
    }
}

