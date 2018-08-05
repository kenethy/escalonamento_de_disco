package escalonamento_de_disco;

import java.util.ArrayList;
import java.util.Collections;

public class C_LOOK {

	DISK disk;

	public C_LOOK() {
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
		System.out.println("<<<<< deslocamento no disco para primeira requisi��o >>>>>");

		for (int i = min; i < disk.posicao; i++) {
			if (disk.requisicoes.contains(i)) {
				System.out.println("Requisi��o processada: " + i);
				disk.requisicoes.remove(disk.requisicoes.indexOf(i));
				
				if(disk.requisicoes.size()==0) {
					break;
				}
			} else
				System.out.println("<<<<< deslocamento no disco >>>>>");
		}
	}
}
