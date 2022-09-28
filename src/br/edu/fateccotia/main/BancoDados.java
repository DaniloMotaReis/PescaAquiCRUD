package br.edu.fateccotia.main;

public class BancoDados {
	
	private Conta [] banco = new Conta[10];
	private int total=0;
	
	public void adicionarBanco(Conta novaConta) {
		if (total<10) {
			banco[total]= novaConta;
			total++;
		}
		else {
			System.out.println("O Banco esta cheia.");
		}
	}
	
	public void mostrarContas() {
		for(int i=0; i<total; i++) {
			banco[i].imprimirConta();
			System.out.println("\n");
		}
	}
}
