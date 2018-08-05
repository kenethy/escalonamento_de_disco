package escalonamento_de_disco;

public class SSTF {

	int proximaRequisicao;
	int menorDistancia;
	int distancia;
	int removerRequisicao;
	DISK disk;

	public SSTF() {
		this.disk = new DISK();
	}

	public void run() {
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

			System.out.println();

			for (int i = 0; i < menorDistancia; i++) {
				System.out.println("<<<<< deslocamento no disco >>>>>");
			}

			System.out.println();

			disk.posicao = proximaRequisicao;
			System.out.println("Requisição processada: " + proximaRequisicao);
			disk.requisicoes.remove(removerRequisicao);
		}
		
		System.out.println("\n");
	}

}
