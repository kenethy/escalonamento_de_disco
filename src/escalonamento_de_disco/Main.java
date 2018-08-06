package escalonamento_de_disco;

public class Main {

	public static void main(String[] args) throws InterruptedException {
//		(new SSTF()).run();
//		(new FCFS()).run();
		(new C_LOOK()).run();
//		(new LOOK()).run();
		(new SCAN()).run();
//		(new C_SCAN()).run();
	}
}
