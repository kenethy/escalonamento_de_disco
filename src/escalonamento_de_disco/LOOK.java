package escalonamento_de_disco;

import java.util.ArrayList;
import java.util.Collections;

public class LOOK {

	DISK disk;

	public LOOK() throws InterruptedException {
		disk = new DISK();
	}

	public void run() throws InterruptedException {
		// Ordenar as requisi��es para verificar o �ltimo elemento
		ArrayList<Integer> requisicoesSort = this.disk.requisicoes;
		Collections.sort(requisicoesSort);
		Integer max = requisicoesSort.get(requisicoesSort.size()-1);
		Integer min = requisicoesSort.get(0);
		
		System.out.println("-- LOOK --");
		
		for (int i = disk.posicao; i <= max; i++) {
			if (disk.requisicoes.contains(i)) {
				System.err.println("Requisi��o processada: " + i);
				disk.requisicoes.remove(disk.requisicoes.indexOf(i));
			} else
				System.out.println("<<<<< deslocamento no disco >>>>>");
			disk.sleep();
		}

		System.out.println("\n�ltima Requisi��o\n");

		for (int i = max-1; i >= min; i--) {
			if (disk.requisicoes.contains(i)) {
				System.err.println("Requisi��o processada: " + i);
				disk.requisicoes.remove(disk.requisicoes.indexOf(i));
			} else
				System.out.println("<<<<< deslocamento no disco >>>>>");
			disk.sleep();
		}
	}
}
