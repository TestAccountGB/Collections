package classe;

import java.util.Objects;

public class Pessoa implements Comparable<Pessoa>{

	private String id;
	private String nome;

	public Pessoa(String id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + "]";
	}

	// Para sobrescrever um metodo equals na classe, precisamos seguir 4 regrinhas:
	//Reflexivo - x.equals(x) tem que ser obviamente true;
	//Simetrico - x.equals(y) = true, logo y.equals(x) tambem tem que retornar true;
	//Transitividade - x.equals(y) = true, y.equals(x) = true e x.equals(z) = true, logo y.equals(z) tambem tem que retornar true;
	//Consistente - se x.equals(y) = true, tem que retornar sempre true, mesmo depois de 100 vezes usando o codigo.
	//Logica(acabei de inventar kk) - x.equals(null), tem que retornar false. Se for o mesmo endereco de memoria
	//Tem que retornar true, se uma classe for comparada com outra classe diferente tem que retornar false.

	@Override
	public boolean equals(Object obj) {
		//Logica:
		if (this == obj) {//Double plus, significa que a gente esta comparando o mesmo endereco de memoria, ou seja,
			//Se this (Pessoa) tiver o mesmo endereco de memoria que o parametro passado, claramente vai ser o mesmo
			//Objeto, por isso tem que retornar true. E basicamente fazer x.equals(x).
			
			//Obs.: This sozinho esta se referenciando a instancia completa do objeto, ou seja, se esse objeto tiver o mesmo 
			//Endereco de memoria que o parametro passado, retorne true.
			return true;
		}
		
		if (obj == null) {//Claramente se o objeto nao tiver nada dentro, nao tem como compara-la, por isso tem que retornar
			//false.
			
			return false;
		}
		
		if (this.getClass() != obj.getClass()) {//Nao tem como comparar uma classe diferente, basicamente nao tem como
			//Comparar uma Pessoa com um Computador, temos que comparar uma Pessoa com uma Pessoa ._.
			
			return false;
		}
		
		//O comando abaixo serve pra transformar o objeto passado no parametro em uma Classe pessoa, pois queremos
		//Comparar apenas o id da pessoa, se x(id).equals(y(id)) for iguais queremos que retorne true.
		Pessoa outraPessoa = (Pessoa) obj;
		return id != null && id.equals(outraPessoa.getId());//Usamos o id.equals() porque o id e uma String e String deve
		//Ser comparada com equals, como foi explicado no EqualsTest
	}
	
	//Agora que apredemos sobre o equals, temos que falar sobre o famoso hashCode que anda junto com o equals.
	
	//Primeiramente vamos dar uma explicacaozinha sobre ele, imagine que temos um ArrayList com 500 pessoas,
	//Como a gente faz pra procurar se a pessoa que a gente vai adicionar nao esta no ArrayList? Com o metodo contains.
	//E como o metodo contains funciona? Ele vai atras do equals da classe que a gente usou pra criar o ArrayList, ou seja,
	//ArrayList<Pessoa>, ele vai atras do equals de Pessoa, e se nao tiver equals? Ele nao vai conseguir fazer a vereficacao.
	//Ta, mas aonde entra o hashCode? Imagine que a gente tem essas 500 pessoas em papel jogados na mesa, como
	//A gente vai achar ela? Ia ser muito dificil, entao o que a gente normalmente faz? Muitos lugares guardam suas
	//Papeladas de pessoas em gavetas que sao seperadas pela primeira letra do nome, ou seja, na gaveta A, vai ta
	//Augusto, Arthur e etc. Esse e o nosso hashCode, um jeito de facilitar o nosso ArrayList ou qualquer outro Array de
	//Colecoes, a fazer a vereficacao do constains/equals, em outra palavras, e basicamente um jeito de guardar os
	//Nossos arquivos em "gavetas (Normalmente, falamos "bucket (Balde)")" para que nosso sistema fique muito mais
	//Rapido. Ta, mas como geramos esse tal de hashCode? Tem muitas pessoas que se especializam em achar melhores
	//Jeitos de fazer um hashCode para seu sistema, mas para a gente que quer uma coisa simples, o java ja fiz isso
	//Automaticamente pra gente
	 
	//Obs.: Sem o hashCode o metodo contains do ArrayList vai funcionar? Sim, pois ele apenas precisa do equals sobreescrito
	//Na classe pra funcionar, mas sem o hashCode vai ser bem mais devagar. E tambem tem um ponto que vale a pena
	//Destacar, que por exemplo: O HashSet, nao funciona sem o hashCode, porque ele basicamente um ArrayList
	//Mas focado em guardar os objetos pelo hashCode. Podemos tambem fazer no hashCode que ele retorne sempre 1,
	//Mas ai todos os objetos vao estar na mesma gaveta e vai demorar pra kraio pra fazer a verificacao.
	
	//Como criar um hashCode? Podemos fazer o nosso, como por exemplo...
//	@Override
//	public int hashCode() {
//		return this.nome.charAt(0);
//	}
	//Esse e um hashCode que guarda os objetos pela primeira letra de seu nome, observe que mesmo eu fazendo um
	//Codigo que deveria retornar um char, ele tranforma em int.
	
	//Mas claro que o hashCode acima e uma porcaria kkk, porque imagine que eu tenha 200 pessoas que comecam com
	//A letra A, e 50 que comeca com a letra B, podemos ver que isso nao ta nada balanceado ._.
	
	//HashCode feito pelo java...
	@Override
	public int hashCode() {
		return Objects.hashCode(id); //A gente usa a classe Objects, que ja faz o hashCode pra gente.
		//Obs.: Objects.hashCode() funciona apenas com um paremetro, para mais parametros devemos usar o codigo abaixo
		
//		return Objects.hash(nome, id);
	}
	
	//Importante: A gente faz o nosso hashCode baseado no equals, no equals eu so uso o id para fazer a vereficacao,
	//Entao no hashCode tenho que usar apenas o id.
	
	@Override
	public int compareTo(Pessoa outraPessoa) {
		//Para criar esse metodo precisamos seguir 3 regras:
		//1 - retornar negativo se thisPessoa < outraPessoa
		//2 - retornar 0 se thisPessoa == outraPessoa
		//3 - retornar positivo se thisPessoa > outraPessoa
		
		//Ate podemos estudar como fazer o nosso compareTo que atende nossas necessidades, mas por enquanto vamos
		//Usar o compareTo do tipo do proprio atributo da classe que vamos comparar, ou seja, se vamos organizar pelo
		//Id vamos usar o compareTo da classe String.
		
		return this.id.compareTo(outraPessoa.getId());
		//Ou seja, estamos usando o compareTo da classe String, comparando o objeto com o parametro passado
		
		//Mas se eu quiser organizar por um tipo primitivo? Temos 2 solucoes, transformar o atributo da classe em uma
		//Classe wrapper do seu tipo primitivo (Essa e a solucao mais recomendada), pois assim podemos tambem usar
		//Alguns metodos da classe que pode nos ser uteis, entao ficaria assim:
		
		//public class Pessoa{
		// Integer oi;
		//
		//public int getOi(){return oi;} (Podemos retornar um int, por causa do AutoUnboxing do Integer)
		//
		//public int compareTo(Pessoa outraPessoa) {return this.oi.compareTo(outraPessoa.getOi())};
		
		//Ou podemos fazer o AutoBoxing dentro do metodo, assim:
		
		//public class Pessoa{
		// int oi;
		//
		//public int getOi(){return oi;}
		//
		//public int compareTo(Pessoa outraPessoa) {Integer oiAux = oi; return oiAux.compareTo(outraPessoa.getOi())};
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

}
