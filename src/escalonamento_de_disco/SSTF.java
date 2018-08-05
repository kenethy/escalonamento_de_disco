package escalonamento_de_disco;

public class SSTF {

	int proximaRequisicao;
	int menorDistancia;
	int distancia;
	int removerRequisicao;
	DISK disk;

	public SSTF() throws InterruptedException {
		this.disk = new DISK();
	}

	public void run() throws InterruptedException {
		System.out.println("-- SSTF --");

		while (!disk.requisicoes.isEmpty()) {
			menorDistancia = 40;
			for (int i = 0; i < disk.requisicoes.size(); i++) {
				distancia = Math.abs(disk.requisicoes.get(i) - disk.posicao);
				if (distancia < menorDistancia) {
					menorDistancia = distancia;
					proximaRequisicao = disk.requisicoes.get(i);
					removerRequisicao = i;
				}
			}

			for (int i = 0; i < menorDistancia; i++) {
				System.out.println("<<<<< deslocamento no disco >>>>>");
				disk.sleep();
			}

			disk.posicao = proximaRequisicao;
			System.err.println("Requisição processada: " + proximaRequisicao);
			disk.requisicoes.remove(removerRequisicao);
			disk.sleep();
		}
	}
}
