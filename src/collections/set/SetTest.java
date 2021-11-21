package collections.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import classe.Pessoa;

public class SetTest {
	public static void main(String[] args) {
		
		//Set faz parte das collections, ate agora a gente so viu o List, mas qual e a diferenca? Diferentemente da Interface
		//List, que e focada em usar indices, como por exemplo, adicionar tal indice, remover o objeto em tal indice,
		//Atualizar objeto em tal indice, e a interface Set e focada em PERFORMANCE, e nao tem indice, ele usa o HashCode
		//Mas como eu vou escolher tal objeto para ser removido e etc? A gente consegue porque ele vai usar o equals,
		//Por exemplo, remover o objeto que tem o nome = "Antena", e outros atributos ai. Ele primeiramente vai usar
		//O HashCode pra procurar o objeto, por isso que ele e a colecao mais rapida, e depois vai usar o equals para ver
		//Se esta certo mesmo, ta, mas como eu vou remover um objeto especifico sendo que tem 2 no Set? Voce nao pode
		//Porque essa interface nao deixa ter elementos repitidos ._.
		
		//Usando...
		
		Set<Pessoa> pessoas = new HashSet<>();
		
		//Precisamos usar uma classe que tenha o metodo equals e HashCode
		
		//Tirando essas diferencas, como usar os metodos sao iguais a qualquer outra collection, observe...
		
		Pessoa pessoa1 = new Pessoa("12", "Augusto");
		Pessoa pessoa2 = new Pessoa("22", "Cesar");
		Pessoa pessoa3 = new Pessoa("14", "Julio");
		Pessoa pessoa4 = new Pessoa("5", "Louco");
		Pessoa pessoa5 = new Pessoa("5", "PessoaRepetida :(");
		
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		pessoas.add(pessoa4);
		pessoas.add(pessoa5);//Ele nao vai adicionar, porque ele nao aceita objetos iguais, claro que isso depende de como
		//O equals da classe define o que e ser igual, no meu caso, ser igual e ter apenas o id iguais.
		
		//Como o HashSet nao tem indice, nao tem como usar um for linear, temos que usar um foreach ou um Iterator
		
		for(Pessoa a : pessoas) {
			System.out.println(a);
		}
		
		//E como voce pode ver, como ele nao indice, ele tambem nao consegue se organizar pela ordem de insercao, na
		//Verdade ele nao tem nenhuma ordem kkk
		
		//Removendo...
		
		Pessoa pessoaToRemove = new Pessoa("14", "Julio");
		pessoas.remove(pessoaToRemove);
		
		//Precisamos passar um objeto como parametro, nao tem como passar um indice
		
		System.out.println("--------------------------------------------");
		
		for(Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
		
		//Eu gosto de perfomance, mas tambem gosto de organizacao, o que eu faco? Use o LinkedHashSet my comprade
		//Ele se organiza pela ordem de insercao, claro, isso faz ele ficar mais lento, mas ainda sim, ele e a segunda
		//Collection mais rapida
		
		Set<Pessoa> pessoas2 = new LinkedHashSet<>();
		
		pessoas2.add(pessoa1);
		pessoas2.add(pessoa2);
		pessoas2.add(pessoa3);
		pessoas2.add(pessoa4);
		
		//Essa e a unica diferenca do LinkedHashSet pro HashSet normal, ele consegue se organizar pela ordem de insercao
		
		System.out.println("--------------------------------------------");
		
		for(Pessoa pessoa : pessoas2) {
			System.out.println(pessoa);
		}
		
		System.out.println("--------------------------------------------");
		
		List<Integer> myArray = new ArrayList<>();
		Set<Integer> myLL = new HashSet<>();
		
		for (int i = 0; i < 100000; i++) {
			myArray.add(i);
			myLL.add(i);
		}
		
		long start = System.currentTimeMillis();
		
		myArray.remove(60000);
		myArray.contains(59000);
		
		long end = System.currentTimeMillis();
		
		System.out.println("ArrayList");
		System.out.println(end-start);
		
		start = System.currentTimeMillis();
		
		myLL.remove(60000);
		myLL.contains(59000);
		
		end= System.currentTimeMillis();
		
		System.out.println("HashSet");
		System.out.println(end-start);
		
		//Acabei de testar todos os metodos de um HashSet e um ArrayList, como add, remove, contains, iterator etc.
		//E apenas no REMOVE e CONTAINS o HashSet/LinkedHasSet e mais rapido do que o ArrayList ._., mas no papel
		//Fala que ele e mais rapido em todos os sentidos, vai entender ;-;
		
	}
}
