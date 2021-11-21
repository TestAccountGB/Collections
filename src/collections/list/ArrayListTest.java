package collections.list;

import java.util.ArrayList;
import classe.PessoaArrayList;

public class ArrayListTest {
	public static void main(String[] args) {

		// Qual é a diferença entre array e ArrayList? pra kraio amigo, array você ja
		// sabe o que é, então vamos pro ArrayList
		// ArrayList é uma classe da biblioteca "util" do java, que é muito superior do
		// que um array, ele pode guardar
		// informacoes inteiras de objetos, ele crescre e diminui dinamicamente.

		// Criação ----

		// Para criar um ArrayList não podemos usar um tipo primitivos como, boolean,
		// char, int, double... (uma coisa que o array normal consegue ._.),
		// Podemos usar String, porque ela é uma classe e também podemos usar Classes Wrapper .
		
		//ArrayList com Wrapper...
		
		ArrayList<Integer> arrayInt = new ArrayList<>();
		@SuppressWarnings("unused")
		ArrayList<Boolean> arrayBoolean = new ArrayList<>();
		@SuppressWarnings("unused")
		ArrayList<String> arrayString = new ArrayList<>();
		@SuppressWarnings("unused")
		ArrayList<Character> arrayChar = new ArrayList<>();
		//Etc...
		
		arrayInt.add(2);
		
		String valor = "1205";
		arrayInt.add(Integer.valueOf(valor));
		
		System.out.println(arrayInt);
		
		//Com Nossas Classes...
		
		ArrayList<PessoaArrayList> meuArray = new ArrayList<>();
		//Instanciamos com o tipo do dado que a gente quer no ArrayList dentro dos simbolos de maior e menor que (<>).
		
		// Instanciando objetos para por no array...
		PessoaArrayList p = new PessoaArrayList();
		PessoaArrayList p1 = new PessoaArrayList();
		PessoaArrayList p2 = new PessoaArrayList();
		PessoaArrayList p3 = new PessoaArrayList();

		// Setando valores dos objetos...

		p.setNome("César");
		p.setIdade(24);

		p1.setNome("César2");
		p1.setIdade(25);

		p2.setNome("César3");
		p2.setIdade(26);

		p3.setNome("César4");
		p3.setIdade(27);

		// Método add

		// O Método add serve para claramente adicionar um dado do tipo que a gente
		// instanciou la em cima
		// Em um array convencional, precisamos estabelecer o tamanho dele, mas no
		// ArrayList não ele aumenta seu
		// Tamanho sozinho

		System.out.println("----------Método add----------");
		System.out.println("Adicionando...");

		meuArray.add(p);
		meuArray.add(p1);
		meuArray.add(p2);

		// Podemos escolher o index também, é possível escolher porque na criação no
		// ArrayList há uma
		// Sobrecarga de Método

		meuArray.add(3, p3); // Vai ser adicionado na posicao 3

		// Tem como ver a posição do objeto com o indexOf
		System.out.println("----------Método indexOf----------");
		System.out.println(meuArray.indexOf(p));
		meuArray.toArray();

		// Método get

		// O ArrayList tem um método para mostrar os valores do objeto que a gente quer

		System.out.println("----------Método get----------");

		System.out.println(meuArray.get(0)); // O index dele é igual ao do Array. Começa do 0

		System.out.println("----------Método get Com Métodos da Classe----------");

		// O ArrayList já se integra com o objeto e com seus métodos, como por exemplo
		// usar o getIdade do objeto, para
		// Apenas mostrar a idade.

		System.out.println("Idade: " + meuArray.get(0).getIdade());

		// Método size

		// O método size() é igual ao .length, ou seja ele vai mostrar o tamanho, nao
		// podemos usar o length porque o
		// ArrayList é um objeto

		System.out.println("----------Método size----------");
		System.out.println(meuArray.size());

		// Podemos juntar tudo isso em um loop, para pecorrer todo o ArrayList

		System.out.println("----------Loop----------");

		for (int i = 0; i < meuArray.size(); i++) {
			System.out.println("----------");
			System.out.println("Nome: " + meuArray.get(i).getNome());
			System.out.println("Idade: " + meuArray.get(i).getIdade());
		}

		// Também podemos usar o foreach para pecorrer o ArrayList, mas retorna o
		// toString. Por isso é bom sobrescreve-lo

		System.out.println("----------Foreach----------");

		for (PessoaArrayList foreach : meuArray) {
			System.out.println(foreach);
		}

		// Método set

		// O Método set serve para substituir algum dado no ArrayList

		System.out.println("----------Método set----------");

		PessoaArrayList p4 = new PessoaArrayList();
		p4.setNome("Augusto");
		p4.setIdade(16);

		meuArray.set(3, p4);// Passamos primeiramente o index do objeto que a gente quer substituir e depois
							// o objeto que a gente
		// Quer colocar e GG

		for (PessoaArrayList foreach : meuArray) {
			System.out.println(foreach);
		}

		// Método Contains

		// Método contains(), verefica se contém o objeto e retorna true ou false

		System.out.println("----------Método contains----------");

		if (meuArray.contains(p2)) {
			System.out.println("Sim");
		} else {
			System.out.println("Nop");
		}
		System.out.println(meuArray.contains(p2));

		// Método Remove

		// Método remove(), claramente remove '-', ele remove algum objeto pelo seu
		// index

		System.out.println("----------Método remove----------");

		meuArray.remove(2);
		System.out.println("Removendo... Objeto p2 (index 2 (César3))");

		System.out.println(meuArray.contains(p2));

		for (PessoaArrayList foreach : meuArray) {
			System.out.println(foreach);
		}

		// Método isEmpty

		// Método isEmpty(), verefica se o ArrayList está vazio

		System.out.println("----------Método isEmpty----------");

		System.out.println(meuArray.isEmpty());

		// Método clear
		
		// Método clear(), serve para remover TUDO do ArrayList

		System.out.println("----------Método clear----------");

		meuArray.clear();
		System.out.println("Limpando...");

		System.out.println(meuArray.isEmpty());
		
		// Método lastIndexOf
		
		// Método lastIndexOf(), se tiver algum objeto duplicado, ele mostra o index do ultimo
		
		System.out.println("----------Método lastIndexOf----------");
		
		ArrayList<String> meuArrayString = new ArrayList<>();
		
		meuArrayString.add("A");
		meuArrayString.add("B");
		meuArrayString.add("C");
		meuArrayString.add("D");
		meuArrayString.add("A"); // Ultimo "A", está no index 4

		System.out.println(meuArrayString.lastIndexOf("A"));
		
		// Também funciona com Objetos
		
		ArrayList<PessoaArrayList> meuArray2 = new ArrayList<>();
		
		PessoaArrayList pessoa = new PessoaArrayList();
		
		meuArray2.add(pessoa);
		meuArray2.add(pessoa); // Ultima "pessoa", está no index 1
		
		System.out.println(meuArray2.lastIndexOf(pessoa));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// Observações (Para informações adicionais)
		
		System.out.println("============================================");
		System.out.println("OBSERVAÇÕES");
		
		System.out.println("Obs 1:");
		
		for (String foreach : meuArrayString) {
			System.out.println(foreach);
		}
		
		meuArrayString.remove(0); // Pelo Index
		meuArrayString.remove("B"); // Pela String
		
		System.out.println("-----------");
		
		meuArrayString.add(0, "A");
		for (String foreach : meuArrayString) {
			System.out.println(foreach);
		}
		
		System.out.println("--------------");
		
		meuArrayString.remove("A");// Ele vai remover o primeiro, mas se eu quiser remover o ultimo? Por isso é melhor usar o
		// Remove pelo index
		
		for (String foreach : meuArrayString) {
			System.out.println(foreach);
		}
	}
}