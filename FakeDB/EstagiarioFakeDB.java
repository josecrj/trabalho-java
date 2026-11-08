package FakeDB;

import java.util.ArrayList;

import Dominio.*;


public class EstagiarioFakeDB extends BaseGenericaFakeDB<Estagiario> {

    @Override

public void autoPreencher() {
    this.dados.add(new Estagiario(201, "Mariana Oliveira", "234.567.890-11", "mariana.oliveira@email.com", "(11) 97777-6666", "Rua Augusta, 500", 1500.00, 30, "Desenvolvimento de Software"));
    this.dados.add(new Estagiario(202, "Lucas Ribeiro", "876.543.210-99", "lucas.ribeiro@email.com", "(21) 96666-5555", "Av. Rio Branco, 150", 1200.50, 20, "Marketing Digital"));
    this.dados.add(new Estagiario(203, "Beatriz Santos", "345.678.901-22", "beatriz.santos@email.com", "(31) 95555-4444", "Alameda das Graças, 85", 1800.00, 30, "Recursos Humanos"));
}

public EstagiarioFakeDB(){

    this.dados = new ArrayList<>();
    this.autoPreencher();

}


    }
    

