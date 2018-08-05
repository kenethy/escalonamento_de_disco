package escalonamento_de_disco;

import java.util.ArrayList;
import java.util.Random;

public class DISK {
	ArrayList<Integer> requisicoes = new ArrayList<Integer>();
	int[] disco = new int[40];
	int posicao;

	public DISK() {
		int[] r = { 16, 9, 36, 12, 1, 34 };
		// int[] r = { 1, 9, 12, 16, 34, 36 };
		for (int i : r)
			requisicoes.add(i);

		Random pos = new Random();
		posicao = pos.nextInt(40);

		System.err.println("Cabeça de gravação na posição: " + posicao);
	}
}
