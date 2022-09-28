package br.edu.fateccotia.main;

public class ContaPescador extends Conta{
	
	private Long cpf;
	
	public ContaPescador() {
		setTipoConta("Pescador");
	}
	
	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public void imprimirConta() {
		System.out.println("\nNome: "+ getNome());
		super.imprimirConta();
		System.out.println("CPF: "+ this.cpf);
	}
	
	public void imprimirTipo() {
		super.imprimirTipo();
		System.out.println("Nome: "+ getNome());
		System.out.println("\n");
	}

}
