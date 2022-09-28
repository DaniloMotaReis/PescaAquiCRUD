package br.edu.fateccotia.main;

public class BancoDados {
	
	private Conta [] banco = new Conta[10];
	private Reservas [] reserva = new Reservas[10];
	private int total=0, totalReser = 0;
	
	public Conta[] getBanco() {
		return banco;
	}

	public void setBanco(Conta[] banco) {
		this.banco = banco;
	}

	public Reservas[] getReserva() {
		return reserva;
	}

	public void setReserva(Reservas[] reserva) {
		this.reserva = reserva;
	}

	public void adicionarBanco(Conta novaConta) {
		if (total<10) {
			banco[total]= novaConta;
			total++;
		}
		else {
			System.out.println("O Banco esta cheia.");
		}
	}
	
	public void adicionarReserva(Reservas novaReserva) {
		if (total<10) {
			reserva[total]= novaReserva;
			total++;
		}
		else {
			System.out.println("As reservas estão cheias.");
		}
	}
	
	public void mostrarContas() {
		for(int i=0; i<total; i++) {
			banco[i].imprimirConta();
		}
	}
	
	public void mostrarTipos(Boolean pes1, Boolean pes2) {
		for(int i=0; i<total; i++) {
			if(pes1 == true) {
				if(banco[i].getTipoConta() == "Pesqueiro") {
					System.out.println(i+":");
					banco[i].imprimirTipo();
				}
			}
			if(pes2 == true) {
				System.out.println(i+":");
				if(banco[i].getTipoConta() == "Pescador") {
					banco[i].imprimirTipo();
				}
			}
			
		}
	}
	
	public void mostrarReservas(Boolean pes1, Boolean pes2,int conta) {
		for(int i=0; i<total; i++) {
			if(pes1 == true) {
				if(banco[conta].getNome() == reserva[i].getNomePesqueiro()) {
					System.out.println(i+":");
					reserva[i].imprimirReservas();
				}
			}
			if(pes2 == true) {
				if(banco[conta].getNome() == reserva[i].getNomePescador()) {
					System.out.println(i+":");
					banco[i].imprimirTipo();
				}
			}
		}
	}
	
	
	public void removerConta() {
		
	}
	
	public void AtualizarConta() {
		
	}
}
