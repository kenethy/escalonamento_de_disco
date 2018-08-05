package escalonamento_de_disco;

import java.util.ArrayList;
import java.util.Collections;

public class LOOK {

	DISK disk;

	public LOOK() {
		disk = new DISK();
	}

	public void run() {
		// Ordenar as requisi��es para verificar o �ltimo elemento
		ArrayList<Integer> requisicoesSort = this.disk.requisicoes;
		Collections.sort(requisicoesSort);
		Integer max = requisicoesSort.get(requisicoesSort.size()-1);
		Integer min = requisicoesSort.get(0);
		
		for (int i = disk.posicao; i <= max; i++) {
			if (disk.requisicoes.contains(i)) {
				System.out.println("Requisi��o processada: " + i);
				disk.requisicoes.remove(disk.requisicoes.indexOf(i));
			} else
				System.out.println("<<<<< deslocamento no disco >>>>>");
		}

		System.out.println("\n�ltima Requisi��o\n");

		for (int i = max-1; i >= min; i--) {
			if (disk.requisicoes.contains(i)) {
				System.out.println("Requisi��o processada: " + i);
				disk.requisicoes.remove(disk.requisicoes.indexOf(i));
			} else
				System.out.println("<<<<< deslocamento no disco >>>>>");
		}
	}
}
