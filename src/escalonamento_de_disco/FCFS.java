package escalonamento_de_disco;

public class FCFS {
	int proximaRequisicao;
	int removerRequisicao;
	int distancia;
	DISK disk;

	public FCFS() throws InterruptedException {
		this.disk = new DISK();
	}

	public void run() throws InterruptedException {
		
		System.out.println("-- FCFS --");
		for (Integer requisicao : disk.requisicoes) {

			distancia = Math.abs(requisicao - disk.posicao);

			for (int i = 0; i < distancia; i++) {
				System.out.println("<<<<< deslocamento no disco >>>>>");
				disk.sleep();
			}

			System.err.println("Requisição processada: " + requisicao.intValue());
			disk.posicao = requisicao;
			disk.sleep();
		}
	}
}