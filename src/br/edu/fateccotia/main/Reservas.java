package br.edu.fateccotia.main;

import java.sql.Date;

public class Reservas {
	
	private String nomePesqueiro;
	private String nomePescador;
	private Date data;
	

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


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public void criarReserva(int conta) {
		
		
	}
	public void imprimirReservas() {
		System.out.println("Nome do Pesqueiro: "+ getNomePesqueiro());
		System.out.println("Nome do pescador: "+ getNomePescador());
		System.out.println("Data de Reserva: "+ getData());
	}
}
