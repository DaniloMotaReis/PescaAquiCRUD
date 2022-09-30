package br.edu.fateccotia.main;

public class BancoDados {
	
	private Conta[] banco = new Conta[10];
	private Reservas[] reserva = new Reservas[10];
	int temp[];
	private int total=0, totalReser=0, totalTemp=0;
	
	public Conta getBanco(int i) {
		return banco[i];
	}

	public Reservas getReserva(int i) {
		return reserva[i];
	}

	public int getTotal() {
		return total;
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
	
	public void adicionarTemp(int num) {
			temp[totalTemp]= num;
			totalTemp++;
	}
	
	public void adicionarReserva(Reservas novaReserva) {
		if (totalReser<10) {
			reserva[totalReser]= novaReserva;
			totalReser++;
		}
		else {
			System.out.println("As reservas estão cheias.");
		}
	}
	
	public Boolean verificarDados(int num) {
		Boolean va = false;
		for(int i=0; i<totalTemp; i++) {
			if(temp[i] == num) {
				va = true;
			}
		}
		return va;
		
	}
	
	public void mostrarContas() {
		if( total > 0) {
			for(int i=0; i<total; i++) {
				banco[i].imprimirConta();
			}
		}
		else {
			System.out.println("Não existem contas cadastradas.\n");
		}
		
	}
	
	public void mostrarTipos(Boolean pes1, Boolean pes2) {
		temp = new int[10];
		totalTemp = 0;
		if( total > 0) {
			for(int i=0; i<total; i++) {
				if(pes1 == true) {
					if(banco[i].getTipoConta() == "Pesqueiro") {
						System.out.println(i+":");
						banco[i].imprimirTipo();
						adicionarTemp(i);
					}
				}
				if(pes2 == true) {
					if(banco[i].getTipoConta() == "Pescador") {
						System.out.println(i+":");
						banco[i].imprimirTipo();
						adicionarTemp(i);
					}
				}
				
			}
		}
		else {
			System.out.println("Não existem contas cadastradas.");
		}
		
		
	}
	
	public void mostrarReservas(Boolean pes1, Boolean pes2,int conta) {
		temp = new int[10];
		totalTemp = 0;
		if(totalReser > 0) {
			for(int i=0; i<totalReser; i++) {
				if(pes1 == true) {
					if(banco[conta].getNome() == reserva[i].getNomePesqueiro()) {
						System.out.println(i+":");
						reserva[i].imprimirReservas();
						adicionarTemp(i);
					}
				} 
				else if(pes2 == true) {
					if(banco[conta].getNome() == reserva[i].getNomePescador()) {
						System.out.println(i+":");
						reserva[i].imprimirReservas();
						adicionarTemp(i);
					}
				}
				else {
					System.out.println(i+":");
					reserva[i].imprimirReservas();
				}
			}
			
		}
		else {
			System.out.println("Não existem reservas feitas.\n");
		}
		
	}
	
	public void cancelarReservas(int num) {
		if(totalReser > 0) {
			if(reserva[num].getRePes() == false && reserva[num].getRePes() == false) {
				for(int i=0; i<totalReser;i++) {
					if(reserva[i] == reserva[num]) {
						for(int j = i; j < totalReser - 1;j++) {
							reserva[j] = reserva[j+1];
						}
						System.out.println("Reserva "+ num + " foi cancelada e deletada.");
						totalReser--;
					}
				}
			}
		}
		
	}
	
	public void removerContas(int num) {
		for(int i=0; i<total;i++) {
			if(banco[i] == banco[num]) {
				for(int j = i; j < total - 1;j++) {
					banco[j] = banco[j+1];
				}
				System.out.println("A conta "+ num + " foi deletada.");
				total--;
			}
		}
	}
	
	public void AtualizarConta() {
		
	}
}
