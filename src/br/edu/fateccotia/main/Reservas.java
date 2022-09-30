package br.edu.fateccotia.main;

public class Reservas {
	
	private Boolean rePes, reCli;
	private String nomePesqueiro;
	private String nomePescador;
	private int data;
	
	public Reservas() {
		rePes = true;
		reCli = true;
	}
	
	public Boolean getRePes() {
		return rePes;
	}


	public void setRePes(Boolean rePes) {
		this.rePes = rePes;
	}


	public Boolean getReCli() {
		return reCli;
	}


	public void setReCli(Boolean reCli) {
		this.reCli = reCli;
	}

	public String getNomePesqueiro() {
		return nomePesqueiro;
	}


	public void setNomePesqueiro(String nomePesqueiro) {
		this.nomePesqueiro = nomePesqueiro;
	}


	public String getNomePescador() {
		return nomePescador;
	}


	public void setNomePescador(String nomePescador) {
		this.nomePescador = nomePescador;
	}


	public int getData() {
		return data;
	}


	public void setData(int data) {
		this.data = data;
	}

	public void imprimirReservas() {
		System.out.println("Nome do Pesqueiro: "+ getNomePesqueiro());
		System.out.println("Nome do pescador: "+ getNomePescador());
		System.out.println("Data de Reserva: "+ getData());
		System.out.println("Reserva Status: ");
		if(this.reCli == false) {
			System.out.println("Reserva cancelada pelo Cliente.\n");
		} 
		else if(this.rePes == false) {
			System.out.println("Reserva cancelada pelo Pesqueiro.\n");
		} 
		else {
			System.out.println("Ok\n");
		}
	}
	
}
