package escalonamento_de_disco;

public class C_SCAN {

	DISK disk;

	public C_SCAN() {
		disk = new DISK();	
	}
	
	public void run() {
		for (int i = disk.posicao; i < disk.tamanhoDisco; i++) {
			if (disk.requisicoes.contains(i)) {
				System.out.println("Requisição processada: " + i);
				disk.requisicoes.remove(disk.requisicoes.indexOf(i));
			}
			else
				System.out.println("<<<<< deslocamento no disco >>>>>");
		}
		
		System.out.println("\nFim do Disco\n");
		System.out.println("<<<<< deslocamento no disco para 0 >>>>>");

		for (int i = 0; i < disk.posicao; i++) {
			if (disk.requisicoes.contains(i)) {
				System.out.println("Requisição processada: " + i);
				disk.requisicoes.remove(disk.requisicoes.indexOf(i));
				
				if(disk.requisicoes.size()==0) {
					break;
				}
			}
			else
				System.out.println("<<<<< deslocamento no disco >>>>>");
		}
	}
}
