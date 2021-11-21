package collections.list;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		
		//Mano, LinkedList e apenas mais util do que o ArrayList em casos muitos especificos e normalmente nao se vale a
		//Pena usar ele, entao vou deixar um link de um video abaixo, para que eu nao fique muito tempo explicando algo
		//Que nao vai ser utill
		
		//Link mais Explicado: https://www.youtube.com/watch?v=M_0q6rGUsNc&ab_channel=KeepOnCoding
		//Link mais Facil de Compreender: https://www.youtube.com/watch?v=5dscMs2hnDI&ab_channel=CodingwithJohn
		
		
		LinkedList<Integer> linkedList = new LinkedList<>();
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		int numero = 50000;
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		long start = System.nanoTime();
		
		for(int i = 0; i < numero; i++) {
			linkedList.add(numero);
		}
		
		long end = System.nanoTime();
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("LinkedList");
		System.out.println(end-start);
				
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		start = System.nanoTime();
		
		for(int i = 0; i < numero; i++) {
			arrayList.add(numero);
		}
		
		end = System.nanoTime();
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("ArrayList");
		System.out.println(end-start);
		
	}
}
