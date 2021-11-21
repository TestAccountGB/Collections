package collections.list;

import java.util.ArrayList;
import classe.PessoaArrayList;

public class ArrayListTest {
	public static void main(String[] args) {

		// Qual � a diferen�a entre array e ArrayList? pra kraio amigo, array voc� ja
		// sabe o que �, ent�o vamos pro ArrayList
		// ArrayList � uma classe da biblioteca "util" do java, que � muito superior do
		// que um array, ele pode guardar
		// informacoes inteiras de objetos, ele crescre e diminui dinamicamente.

		// Cria��o ----

		// Para criar um ArrayList n�o podemos usar um tipo primitivos como, boolean,
		// char, int, double... (uma coisa que o array normal consegue ._.),
		// Podemos usar String, porque ela � uma classe e tamb�m podemos usar Classes Wrapper .
		
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

		p.setNome("C�sar");
		p.setIdade(24);

		p1.setNome("C�sar2");
		p1.setIdade(25);

		p2.setNome("C�sar3");
		p2.setIdade(26);

		p3.setNome("C�sar4");
		p3.setIdade(27);

		// M�todo add

		// O M�todo add serve para claramente adicionar um dado do tipo que a gente
		// instanciou la em cima
		// Em um array convencional, precisamos estabelecer o tamanho dele, mas no
		// ArrayList n�o ele aumenta seu
		// Tamanho sozinho

		System.out.println("----------M�todo add----------");
		System.out.println("Adicionando...");

		meuArray.add(p);
		meuArray.add(p1);
		meuArray.add(p2);

		// Podemos escolher o index tamb�m, � poss�vel escolher porque na cria��o no
		// ArrayList h� uma
		// Sobrecarga de M�todo

		meuArray.add(3, p3); // Vai ser adicionado na posicao 3

		// Tem como ver a posi��o do objeto com o indexOf
		System.out.println("----------M�todo indexOf----------");
		System.out.println(meuArray.indexOf(p));
		meuArray.toArray();

		// M�todo get

		// O ArrayList tem um m�todo para mostrar os valores do objeto que a gente quer

		System.out.println("----------M�todo get----------");

		System.out.println(meuArray.get(0)); // O index dele � igual ao do Array. Come�a do 0

		System.out.println("----------M�todo get Com M�todos da Classe----------");

		// O ArrayList j� se integra com o objeto e com seus m�todos, como por exemplo
		// usar o getIdade do objeto, para
		// Apenas mostrar a idade.

		System.out.println("Idade: " + meuArray.get(0).getIdade());

		// M�todo size

		// O m�todo size() � igual ao .length, ou seja ele vai mostrar o tamanho, nao
		// podemos usar o length porque o
		// ArrayList � um objeto

		System.out.println("----------M�todo size----------");
		System.out.println(meuArray.size());

		// Podemos juntar tudo isso em um loop, para pecorrer todo o ArrayList

		System.out.println("----------Loop----------");

		for (int i = 0; i < meuArray.size(); i++) {
			System.out.println("----------");
			System.out.println("Nome: " + meuArray.get(i).getNome());
			System.out.println("Idade: " + meuArray.get(i).getIdade());
		}

		// Tamb�m podemos usar o foreach para pecorrer o ArrayList, mas retorna o
		// toString. Por isso � bom sobrescreve-lo

		System.out.println("----------Foreach----------");

		for (PessoaArrayList foreach : meuArray) {
			System.out.println(foreach);
		}

		// M�todo set

		// O M�todo set serve para substituir algum dado no ArrayList

		System.out.println("----------M�todo set----------");

		PessoaArrayList p4 = new PessoaArrayList();
		p4.setNome("Augusto");
		p4.setIdade(16);

		meuArray.set(3, p4);// Passamos primeiramente o index do objeto que a gente quer substituir e depois
							// o objeto que a gente
		// Quer colocar e GG

		for (PessoaArrayList foreach : meuArray) {
			System.out.println(foreach);
		}

		// M�todo Contains

		// M�todo contains(), verefica se cont�m o objeto e retorna true ou false

		System.out.println("----------M�todo contains----------");

		if (meuArray.contains(p2)) {
			System.out.println("Sim");
		} else {
			System.out.println("Nop");
		}
		System.out.println(meuArray.contains(p2));

		// M�todo Remove

		// M�todo remove(), claramente remove '-', ele remove algum objeto pelo seu
		// index

		System.out.println("----------M�todo remove----------");

		meuArray.remove(2);
		System.out.println("Removendo... Objeto p2 (index 2 (C�sar3))");

		System.out.println(meuArray.contains(p2));

		for (PessoaArrayList foreach : meuArray) {
			System.out.println(foreach);
		}

		// M�todo isEmpty

		// M�todo isEmpty(), verefica se o ArrayList est� vazio

		System.out.println("----------M�todo isEmpty----------");

		System.out.println(meuArray.isEmpty());

		// M�todo clear
		
		// M�todo clear(), serve para remover TUDO do ArrayList

		System.out.println("----------M�todo clear----------");

		meuArray.clear();
		System.out.println("Limpando...");

		System.out.println(meuArray.isEmpty());
		
		// M�todo lastIndexOf
		
		// M�todo lastIndexOf(), se tiver algum objeto duplicado, ele mostra o index do ultimo
		
		System.out.println("----------M�todo lastIndexOf----------");
		
		ArrayList<String> meuArrayString = new ArrayList<>();
		
		meuArrayString.add("A");
		meuArrayString.add("B");
		meuArrayString.add("C");
		meuArrayString.add("D");
		meuArrayString.add("A"); // Ultimo "A", est� no index 4

		System.out.println(meuArrayString.lastIndexOf("A"));
		
		// Tamb�m funciona com Objetos
		
		ArrayList<PessoaArrayList> meuArray2 = new ArrayList<>();
		
		PessoaArrayList pessoa = new PessoaArrayList();
		
		meuArray2.add(pessoa);
		meuArray2.add(pessoa); // Ultima "pessoa", est� no index 1
		
		System.out.println(meuArray2.lastIndexOf(pessoa));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// Observa��es (Para informa��es adicionais)
		
		System.out.println("============================================");
		System.out.println("OBSERVA��ES");
		
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
		
		meuArrayString.remove("A");// Ele vai remover o primeiro, mas se eu quiser remover o ultimo? Por isso � melhor usar o
		// Remove pelo index
		
		for (String foreach : meuArrayString) {
			System.out.println(foreach);
		}
	}
}