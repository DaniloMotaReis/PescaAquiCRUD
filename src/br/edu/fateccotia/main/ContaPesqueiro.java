package br.edu.fateccotia.main;

public class ContaPesqueiro extends Conta{
	
	private String nomePro;
	private Long cnpj;
	private int quantide;
	private String tipoPeixe;
	
	public ContaPesqueiro() {
		setTipoConta("Pesqueiro");
	}
	
	public String getNomePro() {
		return nomePro;
	}

	public void setNomePro(String nomePro) {
		this.nomePro = nomePro;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public int getQuantide() {
		return quantide;
	}

	public void setQuantide(int quantide) {
		this.quantide = quantide;
	}

	public String getTipoPeixe() {
		return tipoPeixe;
	}

	public void setTipoPeixe(String tipoPeixe) {
		this.tipoPeixe = tipoPeixe;
	}

	public void imprimirConta() {
		super.imprimirConta();
		System.out.println("Quantidede de Lagos: "+ getQuantide());
		System.out.println("Tipos de Peixes: "+ getTipoPeixe());
		System.out.println("Nome do Proprietario: "+ getNomePro());
		System.out.println("CPNJ: "+ getCnpj());
	}
	
	

}
