package br.edu.fateccotia.main;

public abstract class Conta {
	
	private String tipoConta;
	private String nome;
	private String email;
	private String endereco;
	private Long telefone;
	
	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public void imprimirConta() {
		System.out.println("E-Mail: "+ getEmail());
		System.out.println("Endereço: "+ getEndereco());
		System.out.println("Telefone: "+ getTelefone());		
	}
	
	public void imprimirTipo() {
		System.out.println("Tipo de conta: "+ getTipoConta());
	}

}
