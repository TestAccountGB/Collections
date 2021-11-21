package collections.organizacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import classe.Pessoa;

public class OrganizandoCollectionComparable {
	public static void main(String[] args) {
		
		//Antes de comecar a explicar como se organiza uma Collection, primeiramente vou explicar o que e uma Collection
		//Collection e uma interface, e basicamente todos os tipos de Arrays mais "complexos" como o ArrayList, HashSet
		//Entre outros, sao filhos dessa interface, se quiser ver a hierarquia pesquise no google images assim:
		//"java collections hierarchy".
		
		//E uma covencao do java e que a gente nao cria um ArrayList ou qualquer outro tipo de Collection assim:
		@SuppressWarnings("unused")
		ArrayList<Pessoa> pessoaArray = new ArrayList<>();
		
		//Criamos assim:
		@SuppressWarnings("unused")
		List<Pessoa> pessoaList = new ArrayList<>();
		
		//Sim, criamos pela interface, porque assim temos mais flexibilidade e podemos depois trocar por outra Collection
		//Filha da interface List, ou outra interface, mas precisa ser filha da mesma, como o ArrayList que e filha de List.
		
		//Organizando um ArrayList...
		
		List<String> listString = new ArrayList<>();
		
		listString.add("Daniel");
		listString.add("Breno");
		listString.add("Augusto");
		listString.add("Castanhari");

		for(String nome : listString) {
			System.out.println(nome);
		}
		
		//Como se organiza uma String? Pela ordem alfatica claro, mas se tiver numero? A ordem e assim: 0-9 e depois A-Z
		//Ou seja, se tiver 1Zilvan e Augusto, 1Zilvan vai vim primeiro
		
		//Organizacao de tipos simples, como numeros e Strings o java faz a organizacao sozinho, pela classe Collections
		Collections.sort(listString);
		
		System.out.println("\n----------Organizado----------");
		for(String nome : listString) {
			System.out.println(nome);
		}
		
		//Com numeros...
		
		System.out.println("\n----------Com numeros----------");
		List<Double> listDouble = new ArrayList<>();
		
		listDouble.add(2.0);
		listDouble.add(1.1);
		listDouble.add(1.4);
		listDouble.add(0.9);
		//Obs.: Em qualquer lugar que a gente usar double ou float, e sempre bom colocar o ".", mesmo se nao tem nada
		//Depois da virgula, porque assim fica mais facil pra voce e outros progamadores entender
		
		Collections.sort(listDouble);
		
		for(Double nome : listDouble) {
			System.out.println(nome);
		}
		
		//E como organizamos uma classe nossa? Com o metodo compareTo, porque o Collections.sort(), chama o compareTo
		//Da generic passada no <>, ou seja, precisamos criar o nosso, mas antes precisamos implementar a interface
		//Comparable<> na nossa classe, e dentro dos "<>", precisamos colocar a nossa classe, ou seja, Comparable<Pessoa>
		
		Pessoa personOne = new Pessoa("212", "Daniel");
		Pessoa personTwo = new Pessoa("505", "Breno");
		Pessoa personThree = new Pessoa("300", "Augusto");
		Pessoa personFour = new Pessoa("100", "Castanhari");
		
		List<Pessoa> listPessoa = new ArrayList<>();
		
		listPessoa.add(personOne);
		listPessoa.add(personTwo);
		listPessoa.add(personThree);
		listPessoa.add(personFour);
		
		System.out.println("\n----------Com Classe----------");
		
		for(Pessoa pessoa : listPessoa) {
			System.out.println(pessoa);
		}
		
		Collections.sort(listPessoa);

		System.out.println("\n----------Organizado----------");
		
		for(Pessoa pessoa : listPessoa) {
			System.out.println(pessoa);
		}
		
		//Como podemos ver, conseguimos organizar pelo id da pessoa
		
		//Mas esse tipo de organizacao e usando a interface "Comparable", que implementamos na nossa classe, temos
		//Outros tipos de comparacao, como a outra interface "Comparator", que vou explicar em outro lugar xD.
		
	}
}
