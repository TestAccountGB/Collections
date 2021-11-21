package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConversaoDeListasArrays {
	public static void main(String[] args) {
		
		//Primeiramente vamos criar uma lista para test...
		
		List<Integer> lista = new ArrayList<>();
		
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);
		
		Integer[] arrayInteger = new Integer[lista.size()];
		lista.toArray(arrayInteger);
		
		System.out.println("Lista: " + lista);
		System.out.println("Array: " + Arrays.toString(arrayInteger));
		
		//Simples nao?
		
		System.out.println("--------------------------");
		
		//E como a gente faz ao contrario?
		
		Integer[] arrayInteger2 = new Integer[5];
		
		arrayInteger2[0] = 6;
		arrayInteger2[1] = 7;
		arrayInteger2[2] = 8;
		arrayInteger2[3] = 9;
		arrayInteger2[4] = 10;
		
		//Vamos usar um metodo da classe Arrays...
		
		List<Integer> lista2 = new ArrayList<>();
		
		lista2.addAll(Arrays.asList(arrayInteger2));
		
		System.out.println("Array: " + Arrays.toString(arrayInteger2));
		System.out.println("Lista: " + lista2);
		
		//Ok, mas porque precisamos instanciar um novo ArrayList e tambem usar o metodo addAll? Porque se a gente fazer
		//Assim:
		
		List<Integer> lista3 = Arrays.asList(arrayInteger2);
		
		//Como ele retorna uma Lista entao ele vai criar um novo list e tudo vai funcionar, nao? NOP, porque ele esta o que
		//Isso faz, e basicamente fazer essa lista referenciar o mesmo array normal, ou seja, ele nao criou um objeto novo no
		//Heap, ele esta apontando pro MESMO OBJETO, ou seja, se eu fazer algo nessa lista tambem vai mexer na PORRA
		//Do array normal, OBZERVE:
		
		System.out.println("--------------------------");
		
		lista3.set(0, 100);
		//Estou mudando o primeiro numero para ser 100.
		
		System.out.println("Array: " + Arrays.toString(arrayInteger2));
		System.out.println("Lista: " + lista3);
		
		//E como voce pode ver eu mudei o array e a lista, mas isso pode ser algo ruim? Sim, porque como voce sabe um
		//Array normal nao consegue modificar seu tamanho de forma dinamica como uma lista, e ai voce ja sabe o que pode
		//Acontecer se caso eu fizer isso...
		
		//lista3.add(12); //E isso claro, vai quebrar seu codigo xD
		
		//Mas se eu fizer isso...
		
		lista2.add(12); //Nao vai, porque a lista2 e outro objeto (new), diferente do array normal, por isso ele nao muda o
		//Array :D
		
		//Por isso precisamos instanciar um novo objeto no Heap (new (Objeto)), para que ele referencie um objeto
		//Completamente novo, e depois como o metodo asList, retorna uma lista completa, podemos usar o addAll, que
		//Por acaso consegue adicionar uma lista completa >_>
		
		System.out.println("--------------------------");
		
		System.out.println("Array: " + Arrays.toString(arrayInteger2));
		System.out.println("Lista: " + lista2);
		
	}
}
