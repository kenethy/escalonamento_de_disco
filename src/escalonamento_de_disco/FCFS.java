package escalonamento_de_disco;

public class FCFS {
	int proximaRequisicao;
	int removerRequisicao;
	int distancia;
	DISK disk;

	public FCFS() {
		this.disk = new DISK();
	}

	public void run() {
		for (Integer requisicao : disk.requisicoes) {

			distancia = Math.abs(requisicao - disk.posicao);
			System.out.println();

			for (int i = 0; i < distancia; i++) {
				System.out.println("<<<<< deslocamento no disco >>>>>");
			}

			System.out.println();
			System.out.println("Requisição processada: " + requisicao.intValue());
			disk.posicao = requisicao;
		}
	}
}