package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class IteratorTest {
	public static void main(String[] args) {
		
		List<Produto> produtos = new ArrayList<>();
		
		Produto antena = new Produto("12", "Antena", 30, 12);
		Produto televisao = new Produto("12", "Televisão", 1500, 0);
		Produto computador = new Produto("12", "Computador", 1000, 0);
		Produto celular = new Produto("12", "Celular", 500, 1);
		
		produtos.add(antena);
		produtos.add(televisao);
		produtos.add(computador);
		produtos.add(celular);
		
		//Imagine uma situacao em que eu quero pecorrer uma collection inteira, e se tiver algum objeto com tal atributo
		//Vazio ou 0, que seja removido, como voce faria? Com um foreach ne?
		
//		for(Produto produto : produtos) {
//			if(produto.getQuantidade() == 0) {
//				System.out.println(produto);
//				produtos.remove(produto);
//			}
//		}
		
		//O codigo acima ele quebra, pois nao podemos apagar um elemento do ArrayList quando algo esta usando ele, 
		//Como o proprio Foreach, imagine assim, o foreach passa por cada elemento e imagine que ele esta passando pelo
		//Elemento 1, e agente apaga o elemento 1, ai ele nao consegue mais continuar o codigo porque ele estava usando
		//Ele, ue, entao nao funciona usar em um simples loop for que ele nao necessita do objeto? Sim, podemos e nao
		//Vai quebrar o codigo, mas podemos ter um outro problema, vamos se dizer que eu tenho um loop for que ele
		//Executa enquanto ele for menor que o tamanho do produto (4), e vamos se dizer que eu queira apagar todos os
		//Produtos que a quantidade seja 0, e os produtos que a quantidade sao 0 esta no indice 1 e 2, e enquanto o loop
		//Esta correndo ele vai apagar o produto no indice 1 e o produto do indice 2 vai ficar no indice 1, ou seja, o i do
		//For vai avancar de valor (Para o numero 2), mas o produto que eu queria apagar do indice 2 agora esta no 1, entao
		//O loop for vai pular ele :<, observe o exemplo e seguir e analise com cudaido...

		System.out.println("Antes: ");
		
		for(Produto produto : produtos) {
			System.out.println(produto);
		}
		
		for(int i = 0; i < produtos.size(); i++) {
			System.out.println("\nIndex: " + i);
			if(produtos.get(i).getQuantidade() == 0) {
				System.out.println("Achei no Indice " + i + " :D");
				produtos.remove(produtos.get(i));
			} else {
				System.out.println("Achei nada no indice " + i + " :(");
			}
		}
		
		System.out.println("\nDepois: ");
		
		for(Produto produto : produtos) {
			System.out.println(produto);
		}
		
		//Como pode observar, mesmo eu tendo 2 objetos com a quantidade 0, ele so achou 1, mas pensando nisso e na
		//Perfomance, o java criou a classe Interator que vai ser explicada abaixo caso voce nao saiba o foreach e o
		//Interator e mais rapido para pecorrer uma selecao do que o as buscas lineares (Linear Search), no caso o java 
		//Com a busca pelo i = 0; i < minhaPica; i++.
		
		System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");

		List<Produto> produtos2 = new ArrayList<>();
		
		produtos2.add(antena);
		produtos2.add(televisao);
		produtos2.add(computador);
		produtos2.add(celular);
		
		//Vamos criar um novo array e fazer o mesmo teste.
        
		System.out.println("Antes: ");
		
		for(Produto produto : produtos2) {
			System.out.println(produto);
		}
		
        Iterator<Produto> iterator = produtos2.iterator(); //Criamos um objeto do tipo Iterator e depois chamamos o
        //Metodo do ArrayList iterator, que retorna um iterator, mas nao se preocupe o metodo nao tem apenas no
        //ArrayList, tem em todas as collections
        
    	int i = 0;
        while (iterator.hasNext()) {//Vereficacao para ver se tem proximo...
        	
			System.out.println("\nIndex: " + i);
			
        	//Produto oi = iterator.next(); //Podemos jogar o valor retornado do iterator.next() para dentro de um objeto,
        	//Mas o que o interator.next() faz? E basicamente igual o scanner, ele avanca de valor, basicamente igual ao
        	//Foreach, entao cuidado, porque podemos avancar mais de uma o valor usando esse metodo em apenas uma
        	//Rodada do loop, igual ao foreach que quando ele acaba uma rodada ele avanca de valor, por isso e bom sempre
        	//Atribuir a um objeto igual o comando a cima, pois assim nao fica tao confuso ._.
        	
        	if (iterator.next().getQuantidade() == 0) {
    			
        		iterator.remove();//Este metodo remove o ultimo objeto que veio do iterator.next() da collection que foi
        		//Passada em sua atribuicao, no caso, "produtos2".
        		
        		System.out.println("Achei no indice " + i + " :D");
        	} else {
				System.out.println("Achei nada no indice " + i + " :(");
			}
			i++;
        }
        
        System.out.println("\nDepois: ");
		
		for(Produto produto : produtos2) {
			System.out.println(produto);
		}
		
		//Como pode ver ele conseguiu fazer o que eu queria perfeitamente, ou seja, para pecorrer uma Collections
		//Use o Iterator
	        
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
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)//Aqui como voce pode ver, ele compara
				//Usando o equals da classe objeto, nao muda o resultado se voce usa o equals da classe String ou Object
				
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco)//Usamos esse metodo para
				//A conversao do double em bits, porque numeros com ponto flutuante, ou seja, depois da virgula basicamente
				//Apenas usar um "==", pode ser ruim, pois pode existir numeros em que o ponto flutuante dele seja positivo
				//Ou negativo ao infinito, ou o numero pode ser um NaN, entre outros... E comparando isso usando apenas
				//Os numeros pode ter algum erro, por isso usamos esse metodo que ja tem essas tratativas, e vai conseguir
				//Comparar de forma muito mais precisa.
				
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
