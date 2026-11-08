package FakeDB;

import java.util.ArrayList;
import Dominio.*;

public class EgressoFakeDB extends BaseGenericaFakeDB<Egresso>{

@Override

public void autoPreencher(){

this.dados.add(new Egresso(11, "Jose Carlos" , "08883116135", 2028, "Engenharia da Computacao", "infrestutura de redes"));
this.dados.add(new Egresso(14, "Ana Oliveira" , "11122233344", 2024, "Sistemas de Informacao", "desenvolvimento web"));
this.dados.add(new Egresso(15 , "Carlos Santos" , "55566677788", 2027, "Ciencia da Computacao", "inteligencia artificial"));

}

public EgressoFakeDB(){
this.dados = new ArrayList<>();
this.autoPreencher();

}


}