package collections.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;
import classe.Pessoa;

class comparatorBoladoNome implements Comparator<Pessoa>{

	@Override
	public int compare(Pessoa o1, Pessoa o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
}

public class TreeSetTest {
	public static void main(String[] args) {
		
		NavigableSet<Pessoa> treeSetPessoa = new TreeSet<>();
		//Como sempre vamos usar a interface em sua instanciacao
		
		//Mas qual e a diferenca de um ArrayList pra um TreeSet? Como caracteristicas dos Set, ele nao tem indice e tambem
		//Nao permitem elementos duplicados, eles usam o hashcode e o equals, o que possivelmente o torna o tipo de
		//Collection mais rapida em alguns casos. Mas qual e caractristica unica do TreeSet? E que ele se organiza sozinho,
		//Ou seja, nao precisamos usar o metodo Collections.sort(), entao caso a gente precise de uma Collection
		//Organizada, preferencialmente usamos o TreeSet que nesse caso ele e o mais rapido. Mas como ele organiza? Se
		//A gente passar nenhum argumento em seu construtor, ele vai procurar o Comparable da propria classe, caso a classe
		//Nao tenha Comparable ele da erro. Caso a gente queira organizar ele de forma diferente da classe, podemos usar
		//Um Comparator em seu construtor, como demonstra o comando abaixo:
		
		@SuppressWarnings("unused")
		NavigableSet<Pessoa> treeSetPessoaComparator = new TreeSet<>(new comparatorBoladoNome());
		
		//Vamos fazer uma comparacao de velocidade em questao de organizacao...
		List<Pessoa> arrayListPessoa = new ArrayList<>();

		Pessoa personOne = new Pessoa("212", "Daniel");
		Pessoa personTwo = new Pessoa("505", "Breno");
		Pessoa personThree = new Pessoa("300", "Augusto");
		Pessoa personFour = new Pessoa("100", "Castanhari");
		
		
		
		long start = System.nanoTime();//Estou usando o nanotime, pois como a gente esta trabalhando com poucos objetos
		//A diferenca de tempo vai ser minima
		
		treeSetPessoa.add(personOne);
		treeSetPessoa.add(personTwo);
		treeSetPessoa.add(personThree);
		treeSetPessoa.add(personFour);
		
		long end = System.nanoTime();
		
		System.out.println("TreeSet:");
		System.out.println(end-start);
		
		start = System.nanoTime();
		
		arrayListPessoa.add(personOne);
		arrayListPessoa.add(personTwo);
		arrayListPessoa.add(personThree);
		arrayListPessoa.add(personFour);
		Collections.sort(arrayListPessoa);//Como o arrayList nao se organiza, ele tem que usar esse metodo
		
		end = System.nanoTime();
		
		System.out.println("ArrayList:");
		System.out.println(end-start);
		
		System.out.println("\nTreeSet Organizado por Id: ");
		for(Pessoa pessoa : treeSetPessoa) {
			System.out.println(pessoa);
		}
		
		System.out.println("\nArrayList Organizado por Id: ");
		for(Pessoa pessoa : arrayListPessoa) {
			System.out.println(pessoa);
		}
		
		//Podemos ver que ficou igual
		
		//Metodos uteis do TreeSet...
		
		//Como o TreeSet ja vem organizado isso nos da a vantagem de ter alguns metodos adicionais...
		
		//first()
		//Retorna o primeiro elemento
		System.out.println("\nFirst:");
		System.out.println(treeSetPessoa.first());
		
		//last()
		//Retorna o ultimo elemento
		
		System.out.println("\nLast:");
		System.out.println(treeSetPessoa.last());
		
		//pollFirst()
		//Retorna o primeiro elemento e o tira da colecao
		
		System.out.println("\npollFirst:");
		System.out.println(treeSetPessoa.pollFirst());
		
		//pollLast()
		//Retorna o ultimo elemento e o tira da colecao
		
		System.out.println("\npollFirst:");
		System.out.println(treeSetPessoa.pollLast());
		
		System.out.println("\nTreeSet:");
		for(Pessoa pessoa : treeSetPessoa) {
			System.out.println(pessoa);
		}
		
		//descendingIterator e descendingSet
		//Um retorna um Iterator ao contrario, e o outro retorna um ele mesmo ao contrario
		
		System.out.println("\nTreeSet:");
		for(Pessoa pessoa : treeSetPessoa.descendingSet()) {
			System.out.println(pessoa);
		}
		
		//E por fim, temos alguns metodos que retornam o objeto que seja igual, maior, menor do objeto passado no
		//Parametro, pode ter ficado confuso, mas olhe o exemplo abaixo:
		
		//lower <
		//floor <=
		//higher >
		//ceiling >=
		
		treeSetPessoa.add(personTwo);
		treeSetPessoa.add(personFour);
		
		System.out.println("\n");
		for (Pessoa pessoa : treeSetPessoa) {
			System.out.println(pessoa);
		}
		
		//Por exemplo, como minha colecao esta organizada pelo Id, posso procurar algo assim...
		
		//Nao preciso passar o nome, porque minha colecao e organizada apenas pelo id
		Pessoa pessoaAnterior = new Pessoa("200", null);
		//Quero achar a primeira pessoa que tem o Id menor que 200
		
		System.out.println("\nId Menor que 200:");
		System.out.println(treeSetPessoa.lower(pessoaAnterior));

		pessoaAnterior.setId("400");
		System.out.println("\nId Maior que 400:");
		System.out.println(treeSetPessoa.higher(pessoaAnterior));
		
		pessoaAnterior.setId("212");
		System.out.println("\nId Maior ou Igual a 212:");
		System.out.println(treeSetPessoa.ceiling(pessoaAnterior));
		
		pessoaAnterior.setId("300");
		System.out.println("\nId Menor ou Igual a 300:");
		System.out.println(treeSetPessoa.floor(pessoaAnterior));
		
		//Mas cuidado, ele retorna apenas a PRIMEIRA pessoa que bater com o solicitado, ou seja, se eu quiser todas as
		//Pessoas que tem o id menor que algo, vou ter que fazer um metodo mais ou menos assim:
		//Obs.: Nao faca isso pf, kkk, se voce quiser algo assim e so pegar do banco de dados, mas caso voce nao tenha
		//Acesso direto ao banco de dados ou qualquer coisa assim, pode fazer mais ou menos isso:
		
		int id = 500;
		NavigableSet<Pessoa> newPessoas = bringPeopleIdLowerThan(treeSetPessoa, id);
		
		System.out.println("\nPessoas com o Id Menor que " + id);
		for (Pessoa pessoa : newPessoas) {
			System.out.println(pessoa);
		}
		
		//Como pode ver ele organiza automaticamente na ordem do id :0
		
		//KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK, acabei de ver que tem o metodo que faz exatamente isso,
		//Mas vamos relevar '-----------'
		
		//headSet()
		//Ele retorna todos os elementos que sao menores do que voce passou
		
		SortedSet<Pessoa> newPessoas2 = treeSetPessoa.headSet(new Pessoa("500", null));
		//Qual e a diferenca entre um SortedSet e pra um TreeSet? Nenhuma kkk, e por que o java retorna um SortedSet
		//E nao um TreeSet? Sla mano, o java e estranho
		System.out.println("\nHeadSet...");
		for(Pessoa pessoa : newPessoas2) {
			System.out.println(pessoa);
		}
		
		//tailSet()
		//Ele retorna todos os elementos que sao maiores do que voce passou
		newPessoas2 = treeSetPessoa.tailSet(new Pessoa("500", null));
		
		System.out.println("\nTailSet...");
		for(Pessoa pessoa : newPessoas2) {
			System.out.println(pessoa);
		}
		
		//Ta, mas eu quero incluir o Numero 500 tambem, como eu faco isso? Apenas coloque o true no metodo que ele
		//Vai incluir, desse jeito:
		
		treeSetPessoa.tailSet(new Pessoa("500", null), true);
		//Se nao colocar nada, o default vai ser false
		
		//subSet()
		//Ele retorna todos os elementos que estao entre o elemento1 e o elemento2
		newPessoas2 = treeSetPessoa.subSet(new Pessoa("200", null), new Pessoa("500", null));
		
		System.out.println("\nSubSet...");
		for(Pessoa pessoa : newPessoas2) {
			System.out.println(pessoa);
		}
		
		
	}
	
	public static NavigableSet<Pessoa> bringPeopleIdLowerThan(NavigableSet<Pessoa> pessoas, int id){
		String idString = Integer.toString(id);
		Pessoa pessoa = new Pessoa(idString, null);
		NavigableSet<Pessoa> newPessoas = new TreeSet<>();
		
		while(pessoas.lower(pessoa) != null) {//Quando ele nao acha nada ele retorna null
			newPessoas.add(pessoas.lower(pessoa));
			pessoa.setId(pessoas.lower(pessoa).getId());
		}
		
		return newPessoas;
	}
}
