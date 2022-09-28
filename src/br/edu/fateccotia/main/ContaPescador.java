package br.edu.fateccotia.main;

public class ContaPescador extends Conta{
	
	private Long cpf;
	
	public void imprimirConta() {
		super.imprimirConta();
		System.out.println("CPF: "+ this.cpf);
	}

}
