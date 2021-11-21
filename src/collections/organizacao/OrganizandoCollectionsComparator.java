package collections.organizacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import classe.Pessoa;

public class OrganizandoCollectionsComparator {
	public static void main(String[] args) {
		
		//Vamos imaginar uma situacao em que estamos usando o comparable para organizar pelo id, mas por algum motivo
		//Do destino o cliente quer organizar agora pelo nome, como voce iria fazer isso? Iria apenas mudar o metodo
		//compareTo do comprable? Isso nao e nem um pouco recomendado, pois voce pode quebrar o codigo de diversas
		//Pessoas que estao usando o codigo, pra isso que serve o comparator, caso a gente queira mais possibilidades
		//De organizacoes das colecoes
		
		//Mas como criamos um? Primeiramente vamos precisar criar outra classe, normalmente pode ser uma classe local
		//Mas tambem nao, depende de sua necessidade
		
		Pessoa personOne = new Pessoa("212", "Daniel");
		Pessoa personTwo = new Pessoa("505", "Breno");
		Pessoa personThree = new Pessoa("300", "Augusto");
		Pessoa personFour = new Pessoa("100", "Castanhari");
		
		List<Pessoa> listPessoa = new ArrayList<>();
		
		listPessoa.add(personOne);
		listPessoa.add(personTwo);
		listPessoa.add(personThree);
		listPessoa.add(personFour);

		Collections.sort(listPessoa);//Usando o compareTo(Comparable) da propria classe
		
		//Usando o compare da nossa classe local, ou seja, podemos criar muitos jeitos de organizar sem mudar nada
		//Na classe
		Collections.sort(listPessoa, new OrganizarPeloNome());
		
		for(Pessoa pessoa : listPessoa) {
			System.out.println(pessoa);
		}
		
		System.out.println("\nArray Normal...\n");
		
		//Usando em um array normal...
		
		Pessoa[] pessoaArray = new Pessoa[4];
		
		pessoaArray[0] = personOne;
		pessoaArray[1] = personTwo;
		pessoaArray[2] = personThree;
		pessoaArray[3] = personFour;
		
		//Como voce sabe nao podemos apenas dar um sysout em um array normal, porque ele so vai mostrar o endereco
		
		System.out.println(pessoaArray);
		
		//Mas o java tem uma classe que tem alguns metodos uteis pra array, que se chama "Arrays" ;-;
		
		System.out.println(Arrays.toString(pessoaArray));
		
		//E essa classe tambem nos deixa organizar um array...
		
		//E e exatamente igual a do Collections
		Arrays.sort(pessoaArray); //Usando o compareTo da classe
		Arrays.sort(pessoaArray, new OrganizarPeloNome()); //Usando o compare da classe local
		
		System.out.println("\nOrganizado...");
		System.out.println(Arrays.toString(pessoaArray));
		
		
	}
}

class OrganizarPeloNome implements Comparator<Pessoa> {//Aqui implementamos a interface e tambem a classe que
	//Vamos usar
	
	//Vamos sobrescrever o metodo compare...
	@Override
	public int compare(Pessoa o1, Pessoa o2) {
		return o1.getNome().compareTo(o2.getNome()); //Usamos o compareTo do proprio tipo do atributo, aqui no caso e
		//A String, igual ao comparaTo
	}
	
	//Aqui e basicamente a mesma coisa que o compareTo, mas aqui usamos 2 parametros, pois nao temos a propria classe
	//Pra fazer um "this.nome"
}
