package collections.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import classe.Pessoa;

public class PriorityQueueTest {
	public static void main(String[] args) {
		
		//O que uma interface queue? Ele basicamente nos da metodos que segue a regra basica de uma fila, primeiro que
		//Entra, primeiro que sai (FIFO), podemos usar ela com outras Collections, por isso nao e considerada uma Collection
		//Porque ela serve apenas para "Complementar", podemos fazer um LinkedList com Queue
		
		@SuppressWarnings("unused")
		Queue<Integer> queueArrayList = new LinkedList<>();
		
		//Mas vamos falar da PriorityQueue, qual e o conceito da Queue? O primeiro que entra, e o primeiro que sai, entao
		//Qual vai ser o conceito de PriorityQueue? Pelo nome, dever ser igual a Queue, mas com uma "prioridade" ne?
		//Sim, e a prioridade a gente escolhe, como assim? Com o Comparable/Comparator, caso seja o comparator
		//Podemos passar no construtor da classe PriorityQueue
		
		Queue<Pessoa> queue = new PriorityQueue<>();
		
		//Qual e a prioridade da classe Pessoa? Pessoa com o Id mais baixo, primeiro a sair, essa e a nossa prioriadade aqui
		
		Pessoa pessoa1 = new Pessoa("100", "Augusto");
		Pessoa pessoa2 = new Pessoa("300", "Cesar");
		Pessoa pessoa3 = new Pessoa("200", "Noelia");
		Pessoa pessoa4 = new Pessoa("150", "Julio");
		
		queue.add(pessoa1);
		queue.add(pessoa2);
		queue.add(pessoa3);
		queue.add(pessoa4);
		
		for(Pessoa pessoa : queue) {
			System.out.println(pessoa);
		}
		
		//Metodos da interface queue:
		
		//poll()
		//Retorna o primeiro elemento da lista e o remove
		Pessoa pessoaPoll = queue.poll();
		
		System.out.println("\nPoll");
		for(Pessoa pessoa : queue) {
			System.out.println(pessoa);
		}
		
		queue.add(pessoaPoll);
		
		//peek()
		//Retorna o primeiro elemento da lista mas nao o remove
		
		Pessoa pessoaPeek = queue.peek();
		
		System.out.println("\nPeek");
		System.out.println(pessoaPeek);
		
		//element()
		//Igual ao peek, mas quando a fila ta vazia ele joga uma excecao, diferente do peek, que retorna null
		
		Pessoa pessoaElement = queue.element();
		
		System.out.println("\nElement");
		System.out.println(pessoaElement);
		
		//remove()
		//Remove o primeiro elemento da lista, ou um elemento escolhido
		
		queue.remove();
				
		System.out.println("\nRemove");
		for(Pessoa pessoa : queue) {
			System.out.println(pessoa);
		}
		
		//offer()
		//Igual ao metodo add, mas quando a gente tenta adicionar mais do que o tamanho passado no construtor, ele
		//Retorna um false, enquanto o add retorna uma excecao. Caso voce nao saiba, da pra passar o tamanho que a gente
		//Quer em todas as Collections, caso voce saiba o tamanho exato que vai ser usado e muito bom passar no
		//Construtor, pois assim, vai estar poupando memoria :)
		
		queue.offer(new Pessoa("100", "Arthur"));
		
		System.out.println("\nOffer");
		for(Pessoa pessoa : queue) {
			System.out.println(pessoa);
		}
		
		//Essa interface e bem simples, e bem pouco utilizada, apenas util caso a gente queria remover um monte
		//De objeto conforme a logica da fila
		
	}
}
