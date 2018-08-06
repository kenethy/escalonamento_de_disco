package escalonamento_de_disco;

public class SCAN {

	DISK disk;

	public SCAN() throws InterruptedException {
		disk = new DISK();
	}

	public void run() throws InterruptedException {
		
		System.out.println("-- SCAN --");
		for (int i = disk.posicao; i < disk.tamanhoDisco; i++) {
			if (disk.requisicoes.contains(i)) {
				System.err.println("Requisição processada: " + i);
				disk.requisicoes.remove(disk.requisicoes.indexOf(i));
			}
			else
				System.out.println("<<<<< deslocamento no disco >>>>>");
			disk.sleep();
		}
		
		System.out.println("\nFim do Disco\n");

		for (int i = disk.tamanhoDisco; i >= 0; i--) {
			if (disk.requisicoes.contains(i)) {
				System.err.println("Requisição processada: " + i);
				disk.requisicoes.remove(disk.requisicoes.indexOf(i));
				disk.sleep();
				
				if(disk.requisicoes.size()==0) {
					break;
				}
			}
			else
				System.out.println("<<<<< deslocamento no disco >>>>>");
			disk.sleep();
		}
	}
}
