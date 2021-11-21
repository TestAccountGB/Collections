package collections;

import classe.Pessoa;

public class EqualsTest {
	public static void main(String[] args) {
		
		//Como voce sabe existe a pool de String, quando criamos duas Strings com a mesma sequencia de chars,
		//Eles vao referenciar a mesma String;
		
		String saudacao = "oi";
		String saudacao2 = "oi";
		
		System.out.println("Comparacao String: " + (saudacao == saudacao2));
		//Como podemos ver ele retornou true, porque eles estao referenciando a mesma String, ou seja, eles tem o mesmo
		//Endereco de memoria
		
		//Mas se a gente criar uma String instanciando ela, olha o que acontece...
		String saudacao3 = new String("oi");

		System.out.println("Comparacao String na Heap: " + (saudacao == saudacao3));
		//Por que retornou false? Porque existe um lugar na memoria do java chamada de "Heap", e ela e aonde guarda
		//Todas as classes instancidas, entao imagine assim: saudacao esta na String pool e a saudacao3 esta na Heap,
		//Mas o Double Plus, tenta vereficar se eles tem o mesmo endereco, e como eles nao tem, retorna false.
		
		System.out.println("Comparacao String Equals: " + saudacao.equals(saudacao3));
		//Por que agora retornou true? Porque o metodo equals nao procura pelo seu endereco, e sim pelo seu conteudo.
		
		Pessoa pessoa1 = new Pessoa("12d", "Augusto");
		Pessoa pessoa2 = new Pessoa("12d", "Augusto");

		System.out.println("Double plus: " + (pessoa1 == pessoa2));
		
		System.out.println("Passando pelas regras basicas...");
		System.out.println(pessoa1.equals(pessoa2));
		System.out.println(pessoa1.equals(pessoa1));
		System.out.println(pessoa2.equals(pessoa2));
		System.out.println(pessoa2.equals(pessoa1));
		
		//Ok, mas como a gente so esta vereficando pelo seu id, vamos criar uma situacao hipotetica (Que nunca vai
		//Acontecer kkk), mas imagine que a pessoa trocou de nome, mas como o nome sistema e uma porcaria kkkk,
		//Ele nao atualizou o objeto, e sim criou um novo, mas ele ainda continua com o mesmo id.
		
		pessoa2.setNome("Augusto César");

		System.out.println("\nComparacao com mudanca de nome: " + pessoa1.equals(pessoa2));
		//Isso pode ser util caso a gente queria encontrar um Objeto Pessoa com tal id, em um array gigante.
		
		//Acontece a mesma coisa com o Integer (e todas as outras classes wrappers), mas a gente não precisa se preocupar,
		//Pois o método equals já esta sobrescrito em cada um dos wrappers.
		
		}
}
