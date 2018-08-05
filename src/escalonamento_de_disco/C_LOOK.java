package escalonamento_de_disco;

import java.util.ArrayList;
import java.util.Collections;

public class C_LOOK {

	DISK disk;

	public C_LOOK() throws InterruptedException {
		disk = new DISK();
	}

	public void run() throws InterruptedException {
		// Ordenar as requisições para verificar o último elemento
		ArrayList<Integer> requisicoesSort = this.disk.requisicoes;
		Collections.sort(requisicoesSort);
		Integer max = requisicoesSort.get(requisicoesSort.size()-1);
		Integer min = requisicoesSort.get(0);
		
		System.out.println("-- C LOOK --");
		
		for (int i = disk.posicao; i <= max; i++) {
			if (disk.requisicoes.contains(i)) {
				System.err.println("Requisição processada: " + i);
				disk.requisicoes.remove(disk.requisicoes.indexOf(i));
			} else
				System.out.println("<<<<< deslocamento no disco >>>>>");
			disk.sleep();
		}

		System.out.println("\nÚltima Requisição");
		disk.sleep();
		System.out.println("<<<<< deslocamento no disco para primeira requisição >>>>>\n");

		for (int i = min; i < disk.posicao; i++) {
			if (disk.requisicoes.contains(i)) {
				System.err.println("Requisição processada: " + i);
				disk.requisicoes.remove(disk.requisicoes.indexOf(i));
				disk.sleep();
				
				if(disk.requisicoes.size()==0) {
					break;
				}
			} else
				System.out.println("<<<<< deslocamento no disco >>>>>");
			disk.sleep();
		}
	}
}
