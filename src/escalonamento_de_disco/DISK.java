package escalonamento_de_disco;

import java.util.ArrayList;
import java.util.Random;

public class DISK {
	ArrayList<Integer> requisicoes = new ArrayList<Integer>();
	int posicao;
	int tamanhoDisco;

	public DISK() throws InterruptedException {
		tamanhoDisco = 40;

		System.out.println();
		int[] r = { 16, 9, 36, 12, 1, 34 };
		// int[] r = { 1, 9, 12, 16, 34, 36 };

		System.out.print("[ ");
		for (int i : r) {
			requisicoes.add(i);
			System.out.print(i + " ");
		}
		System.out.println("]");
		
		sleep();
		
		Random pos = new Random();
		posicao = pos.nextInt(40);

		System.err.println("Cabeça de gravação na posição: " + posicao);
		sleep();
	}
	
	public void sleep() throws InterruptedException {
		Thread.sleep(300);
	}
	
}
