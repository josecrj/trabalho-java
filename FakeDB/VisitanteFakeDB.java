

package FakeDB;

import java.util.ArrayList;

import Dominio.*;

public class VisitanteFakeDB extends BaseGenericaFakeDB<Visitante>{

    @Override
    public void autoPreencher(){
        this.dados.add(new Visitante(101, "Ana Silva", "123.456.789-00", "ana.silva@email.com", "(11) 98765-4321", "Av. Paulista, 1000", "Reunião Comercial", 12, "Vendas"));
        this.dados.add(new Visitante(102, "Bruno Costa", "987.654.321-11", "bruno.costa@email.com", "(21) 99999-8888", "Rua das Flores, 45", "Entrevista de Emprego", 34, "Recursos Humanos"));
        this.dados.add(new Visitante(103, "Carlos Sousa", "456.789.123-22", "carlos.sousa@email.com", "(31) 98888-7777", "Praça da Liberdade, 12", "Manutenção de Rede", 56, "TI"));

    }

    public VisitanteFakeDB(){

        this.dados = new ArrayList<>();
        this.autoPreencher();
        

    }
    
}
