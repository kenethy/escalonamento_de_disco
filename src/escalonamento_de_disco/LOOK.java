package escalonamento_de_disco;

public class LOOK {

	DISK disk;

	public LOOK() {
		disk = new DISK();
	}

	public void run() {
		
		for (int i = disk.posicao; i < disk.tamanhoDisco; i++) {
			if (disk.requisicoes.contains(i)) {
				System.out.println("Requisição processada: " + i);
				disk.requisicoes.remove(disk.requisicoes.indexOf(i));
			} else
				System.out.println("<<<<< deslocamento no disco >>>>>");
		}

		System.out.println("\nFim do Disco\n");

		for (int i = disk.tamanhoDisco; i >= 0; i--) {
			if (disk.requisicoes.contains(i)) {
				System.out.println("Requisição processada: " + i);
				disk.requisicoes.remove(disk.requisicoes.indexOf(i));
			} else
				System.out.println("<<<<< deslocamento no disco >>>>>");
		}
	}
}
