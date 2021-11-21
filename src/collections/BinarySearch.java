package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import classe.Pessoa;

public class BinarySearch {
	public static void main(String[] args) {

		// O que e o binarySearch? E o jeito mais rapido de procurar um index de algo em
		// um ArrayList ou um array normal
		// Do que uma forma linear, como usar um constains, que ele usa o for para
		// pecorrer literalmente todo o array
		// Ou seja, se eu tiver um array muito grande, vai demorar pra kraio meu amigo e
		// o sistema vai ficar lento. Mas como
		// Funciona o binarySearch? Ele parte o array no meio e pega o numero do meio, e
		// se pergunta se o numero que
		// A gente quer e maior ou menor do que o numero do meio, se for menor ele
		// apenas vai trabalhar com a parte
		// Menor, e vai repitir o processo de repartir o array ate achar o que aonde a
		// gente quer.

		// Mas claro, para isso precisamos que o array esteja organizado, porque se nao,
		// nao vai funcionar o binarySearch
		// Porque ele nao vai conseguir fazer a vereficacao de maior ou menor da metade
		// do array, mas claro, o processo
		// De organizar um array demora mais do que uma procura de index linear, entao
		// basicamente, e apenas
		// Recomendado usar esse metodo se o array ja vim do banco de dados organizado
		// por ordem crescente, ou voce
		// PRECISAR organizar o array, mas organizar ele por outros motivos alem de so
		// usar o binarySearch, porque ai sim,
		// Vai valer a pena.

		// Se ainda estiver em duvida --> https://www.youtube.com/watch?v=CHCan--pll4&ab_channel=AaronWritesCode

		// Teste...
		int[] arrayIntTest = { 0, 5, 2, 3, 10, 8, 7 };

		// Temos que primeiramente organizar...
		Arrays.sort(arrayIntTest);

		System.out.println(Arrays.toString(arrayIntTest));

		int index = Arrays.binarySearch(arrayIntTest, 5);
		System.out.println("Index: " + index);

		System.out.println("Numero achado: " + arrayIntTest[index]);

		// Mas e se ele nao achar? Ele vai retornar o index + 1 e negativo, daonde a
		// gente tem que botar esse numero, para
		// Que o array ainda esteja organizado, e da pra fazer algumas coisas bem legais
		// com isso, como...

		System.out.println("Numero inexistente: " + Arrays.binarySearch(arrayIntTest, 11));

		// Usando esse numero negativo...

		int[] array = { 1, 2, 5, 10, 0, 12 };
		Arrays.sort(array);
		System.out.println("Array Normal: " + Arrays.toString(array));

		// Gosto muito desse metodo, pois ele consegue retornar um array que vai
		// adicionar outro numero em um array
		// Na ordem certa, e ainda retorna esse array

		int[] newArray = putAnotherNumberInRegularArray(array, 3);
		System.out.println("Array Novo: " + Arrays.toString(newArray));

		// Usando uma collection

		System.out.println("\nCollections...\n");

		List<Pessoa> arrayPessoa = new ArrayList<>();

		Pessoa personOne = new Pessoa("212", "Daniel");
		Pessoa personTwo = new Pessoa("505", "Breno");
		Pessoa personThree = new Pessoa("300", "Augusto");
		Pessoa personFour = new Pessoa("100", "Castanhari");

		arrayPessoa.add(personOne);
		arrayPessoa.add(personTwo);
		arrayPessoa.add(personThree);
		arrayPessoa.add(personFour);

		// Vou organizar pelo id, que ja esta em sua classe para organizar como id,
		// entao nao preciso criar um Comparator
		// Local

		Collections.sort(arrayPessoa);

		System.out.println("Array Organizado por ID: ");
		for (Pessoa pessoa : arrayPessoa) {
			System.out.println(pessoa);
		}

		// Precisamos criar outra pessoa para procurar o index, e basicamente igual ao
		// constains
		Pessoa personTest = new Pessoa("300", "Augusto");
		int indexPessoa = Collections.binarySearch(arrayPessoa, personTest);
		System.out.println("\nIndex: " + indexPessoa);

		// Teste...
		System.out.println("Pessoa achada: " + arrayPessoa.get(indexPessoa));

		Pessoa pessoaParaAdicionar = new Pessoa("102", "Julio");
		System.out.println("Pessoa Inexistente: " + Collections.binarySearch(arrayPessoa, pessoaParaAdicionar));

		// Adicionando a pessoa...

		arrayPessoa = putAnotherNumberInArrayListOfPessoa(arrayPessoa, pessoaParaAdicionar);

		System.out.println("\nPessoa Adicionada Por ID: ");
		for (Pessoa pessoa : arrayPessoa) {
			System.out.println(pessoa);
		}

		// E se caso eu usar um Comparator que seja organizado diferentemente do
		// Comparable da classe, precisa usar
		// No binarySearch tambem, OBZERBE...

		Collections.sort(arrayPessoa, new ComparatorQualquer());

		System.out.println("\nArray Organizado por Nome: ");
		for (Pessoa pessoa : arrayPessoa) {
			System.out.println(pessoa);
		}

		Pessoa pessoaParaAdicionarComparator = new Pessoa("350", "Bernardo");
		System.out.println("Pessoa Inexistente: " + 
		Collections.binarySearch(arrayPessoa, pessoaParaAdicionarComparator, new ComparatorQualquer()));
		
		putAnotherNumberInArrayListOfPessoaWithComparator
		(arrayPessoa, pessoaParaAdicionarComparator, new ComparatorQualquer());
		
		System.out.println("\nPessoa Adicionada Por Nome: ");
		for (Pessoa pessoa : arrayPessoa) {
			System.out.println(pessoa);
		}
		
		//Temos que usar o comparator em tudo
	}

	public static int[] putAnotherNumberInRegularArray(int[] array, int customNumber) {

		Arrays.sort(array);
		int customNumberIndex = (Arrays.binarySearch(array, customNumber) + 1) * -1; // To adicionando mais 1, porque
		// como o numero e negativo, eu estou subtraindo ele, porque ele retorna o index
		// com 1 a mais, e depois estou
		// Multiplicando por -1 para transformar o numero em positivo

		int[] newArray = new int[array.length + 1];
		int index = 0;
		for (int test : array) {
			newArray[index] = test;
			index++;
			if (index == customNumberIndex) {
				newArray[index] = customNumber;
				index++;
			}
		}
		return newArray;
	}

	public static List<Pessoa> putAnotherNumberInArrayListOfPessoa
	(List<Pessoa> arrayList, Pessoa customPessoa) {

		Collections.sort(arrayList);
		int customNumberIndex = (Collections.binarySearch(arrayList, customPessoa) + 1) * -1;
		arrayList.add(customNumberIndex, customPessoa);
		return arrayList;
	}

	public static List<Pessoa> putAnotherNumberInArrayListOfPessoaWithComparator
	(List<Pessoa> arrayList, Pessoa customPessoa, Comparator<Pessoa> comparator) {

		Collections.sort(arrayList, comparator);
		int customNumberIndex = (Collections.binarySearch(arrayList, customPessoa, comparator) + 1) * -1;
		arrayList.add(customNumberIndex, customPessoa);
		return arrayList;
	}
}

class ComparatorQualquer implements Comparator<Pessoa> {

	@Override
	public int compare(Pessoa o1, Pessoa o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
}