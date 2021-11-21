package collections.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;

import classe.Pessoa;

public class HashMapTest {

	public static void main(String[] args) {
		
		//O que o hashMap? Ele e uma collection organizada por chaves, como assim? Olhe o exemplo abaixo...
		//Obs.: Como ele e um Hash, ele nao aceita elementos repitidos, se houver algum elemento repitido ele vai
		//Sobrescrever o antigo
		
		Map<Integer, String> hashMap = new HashMap<>();
		//Por que dois argumentos? O primeiro e o tipo da chave e o segundo e o valor, vamos ver na pratica...
		
		hashMap.put(1, "Bom dia meu amigo, como vai?");
		//Usamos o metodo put, para inserir um novo valor, o primeiro e sua chave e o segundo o valor
		
		//Podemos chamar o valor apenas pela sua key...
		System.out.println(hashMap.get(1));
		
		//Chaves repitidas...
		
		hashMap.put(1, "Bom dia meu consagrado, como vai?");
		
		System.out.println(hashMap.get(1));
		//Se a gente inserir a mesma chave mas com valor diferente, ele vai substituir o antigo
		
		
		hashMap.put(2, "Good Morning my Friendo");
		hashMap.put(3, "Good Night my Friendo");

		System.out.println();
		//Foreach...
		for (String valores : hashMap.values()) {//Esse metodo retorna os valores, ou seja, se eu tenho as chaves que sao ints
			//E os valores que sao Strings, preciso fazer o foreach com String
			
			System.out.println(valores);
		}
		//Assim retorna todos os valores, mas e se eu quiser retonar a chave e o valor?
		
		//Ai vamos precisar usar uma interface local da interface Map kkk, que consegue puxar pra gente as chaves e os
		//Valores correspondentes
		
		System.out.println();
		for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
			System.out.println("Chave: " + entry.getKey() + ", Valor: " +  entry.getValue());
		}
		
		System.out.println("\ntoString: ");
		for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
			System.out.println(entry);
		}
		
		//Usando classes em suas chaves e valores...
		//Obs.: As Classes precisam ter claramente o codigo hashCode e o equals ._.
		
		Produto antena = new Produto("12", "Antena", 30, 12);
		Produto televisao = new Produto("12", "Televisão", 1500, 10);
		Produto computador = new Produto("12", "Computador", 1000, 12);
		Produto celular = new Produto("12", "Celular", 500, 15);
		
		//Vamos fazer um exemplo bem besta e que nunca vai usar, mas so pra demonstrar um pouco do poder do HashMap
		
		//Vou criar ums carrinhos e fingir que esses produtos foi a compra de alguem
		List<Produto> carrinho1 = new ArrayList<>();
		carrinho1.add(antena);
		carrinho1.add(computador);
		
		List<Produto> carrinho2 = new ArrayList<>();
		carrinho2.add(celular);
		carrinho2.add(televisao);
		
		Map<Pessoa, List<Produto>> compras = new HashMap<>();
		//Vou criar um map com a key da classe Pessoa, porque? Porque vou vincular uma pessoa a um carrinho, tendeu?
		//E o carrinho vai ser uma List(ArrayList) de Produto, porque la vou colocar varios produtos
		
		//Compradores...
		Pessoa comprador1 = new Pessoa("12", "Augusto");
		Pessoa comprador2 = new Pessoa("5", "Cesar");
		
		compras.put(comprador1, carrinho1);
		compras.put(comprador2, carrinho2);
		//Ou seja, o "comprador1" esta vinculado com o arrayList "carrinho1", mas como vou fazer pra mostrar tudo?
		
		System.out.println("\nCompras");
		
		
		for(Map.Entry<Pessoa, List<Produto>> compra : compras.entrySet()) {//Vou fazer o foreach normal que vai me
			//Retornar o comprador e todos os seus produtos
			System.out.print("\nComprador: " + compra.getKey().getNome());//Vou pegar apenas o nome do comprador
			System.out.print(" - Comprou:");
			
			//E como esse comprador tem varios produtos, vou precisar fazer um outro for pra mostrar todos...
			for(Produto produtos : compra.getValue()) {//Esse compra.getValue() vai retornar os valores da Entry, ou seja,
				//A List<Produto>, e como ele retorna uma List de produto e so fazer um foreach com ela tendeu? E a mesma
				//Coisa do que:
				//List<Produto> a = compra.getValue(); for(Produto produtos : a){}, Mas do jeito acima e mais simplificado
				System.out.print(" " + produtos.getNome());
			}
		}
		
		//Tome cuidado!!!
		
		//Olha, como voce sabe, se a gente colocar a mesma chave com o valor diferente, o valor anterior vinculado a essa
		//Chave vai ser substituido, e ai que esta o problema em trabalhar com classe, voce deve ter muito cuidado com
		//O equals dela, observe esse exemplo:
		
		Pessoa comprador3 = new Pessoa("5", "Julio");
		
		compras.put(comprador3, carrinho1);
		//O que ta acontecendo aqui? Pro java, o comprador3 e igual ao comprador2, por que? Porque o equals da classe 
		//Pessoa, fala que se o id for igual entao e o mesmo objeto, entao o que vai acontecer aqui? Ja que o pensa que o
		//comprador3 = comprador2 o valor do comprador2 agora vai ser igual ao carrinho 1, observe...
		
		System.out.println("\n\nTeste...");
		for(Map.Entry<Pessoa, List<Produto>> compra : compras.entrySet()) {
			System.out.print("\nComprador: " + compra.getKey().getNome());
			System.out.print(" - Comprou:");
			for(Produto produtos : compra.getValue()) {
				System.out.print(" " + produtos.getNome());
			}
		}
		
		//Obs.: Como voce deve saber, as Collections que usam o hashCode, nao tem organizacao, mas caso voce queira
		//Pelo menos o minimo de organizacao, voce pode usar o LinkedHashMap, que organiza pela ordem de insercao
		
		Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
		
		linkedHashMap.put(1, "oi");
		linkedHashMap.put(3, "hola");
		linkedHashMap.put(4, "hi");
		linkedHashMap.put(2, "ola");
		linkedHashMap.put(5, "hello");
		
		System.out.println("\n\nLinkedHashMap...\n");
		for(Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
			System.out.println(entry);
		}
		
		//Tambem temos o TreeMap, caso a gente queria organizado pelo Comprable/Comparator
		//Obs.: Para usar o TreeMap, precisamos ter a interface Comparable na key, ou usar um Comparator em seu
		//Construtor
		
		NavigableMap<Integer, String> treeMap = new TreeMap<>();
		//Sempre quando vamos usar o Tree, devemos usar a interface Navigable, pois vai nos dar acesso a metodos
		//Como o ceiling, lower, head, tail, sub e etc. Caso nao saiba ainda o que a Collection Tree faz, olhe no package 
		//"set" e depois leia tudo da classe "TreeSetTest", porque e mais facil pra explicar do que usar o map, mas ainda
		//Sim e a mesma logica do que o TreeSet, mas um pouco mais complexo porque usa o sistema de chaves e etc.
		//Obs.: Todos esses metodos eles se baseiam na key
		
		treeMap.put(1, "oi");
		treeMap.put(3, "hola");
		treeMap.put(4, "hi");
		treeMap.put(2, "ola");
		treeMap.put(5, "hello");
		
		System.out.println("\nTreeMap...\n");
		for(Map.Entry<Integer, String> entry : treeMap.entrySet()) {
			System.out.println(entry);
		}
		
		//Ele se organiza pela key
		
	}
}

class Produto {
	
	private String id;
	private String nome;
	private double preco;
	private double quantidade;
	
	public Produto(String id, String nome, double preco, double quantidade) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, nome, preco, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco)
				&& Double.doubleToLongBits(quantidade) == Double.doubleToLongBits(other.quantidade);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", quantidade=" + quantidade + "]";
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public double getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	
}
