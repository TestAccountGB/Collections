package collections;
import classe.Pessoa;

public class HashCodeTest {
	public static void main(String[] args) {
		
		Pessoa personOne = new Pessoa("idb", "Augusto");
		Pessoa personTwo = new Pessoa("idb", "Arthur");
		
		System.out.println("HashCode usando o id: " + personOne.hashCode());
		System.out.println("HashCode usando o id: " + personTwo.hashCode());

		personOne.setId("ida");

		System.out.println("HashCode usando o id: " + personOne.hashCode());
		
		//Podemos ver que o hashCode mudou conforme o id.
		
		//Agora para a realizacao do codigo abaixo, tire o hashCode da primeira letra fora do comentario, e coloque o outro
		//Em comentario
		
		Pessoa personThree = new Pessoa("ida", "Maria");

		System.out.println("HashCode usando a primeira letra: " + personOne.hashCode());
		System.out.println("HashCode usando a primeira letra: " + personTwo.hashCode());
		System.out.println("HashCode usando a primeira letra: " + personThree.hashCode());
		
		//Podemos ver no hashCode do id, que ainda continou igual, mesmo eu mudando o id, porque agora ele esta gerando
		//O hashCode pela primeira letra do nome.
		
		//Se quiser mais fontes de estudo sobre o hashCode:
		//https://blog.algaworks.com/entendendo-o-equals-e-hashcode/
		//https://angeliski.com.br/2014/01/05/equals-e-hashcode/
		
	}
}