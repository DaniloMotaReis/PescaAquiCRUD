package br.edu.fateccotia.main;

public class BancoDados {
	
	private Conta[] bancoPes = new Conta[10];
	private Conta[] bancoCli = new Conta[10];
	private Reservas[] reserva = new Reservas[10];
	int temp[];
	private int totalPes=0, totalCli=0, totalReser=0, totalTemp=0;
	

	public Conta getBancoPes(int i) {
		return bancoPes[i];
	}

	public Conta getBancoCli(int i) {
		return bancoCli[i];
	}

	public Reservas getReserva(int i) {
		return reserva[i];
	}

	public Conta[] getBancoPes() {
		return bancoPes;
	}

	public int getTotalPes() {
		return totalPes;
	}

	public int getTotalCli() {
		return totalCli;
	}

	public void adicionarBanco(Boolean cli, Boolean pes,Conta novaConta) {
		if(cli == true) {
			if (totalCli<10) {
				bancoCli[totalCli]= novaConta;
				totalCli++;
			}
			else {
				System.out.println("O Banco esta cheia.");
			}
		}
		else if(pes == true) {
			if (totalPes<10) {
				bancoPes[totalPes]= novaConta;
				totalPes++;
			}
			else {
				System.out.println("O Banco esta cheia.");
			}
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
	
	public Boolean verificarDados(Boolean op,int num) {
		Boolean va = false;
		if(op == true) {
			for(int i=0; i<totalReser; i++) {
				if(reserva[i].getNomePesqueiro() == bancoPes[num].getNome()) {
					va = true;
				}
			}
		}
		else {
			for(int i=0; i<totalTemp; i++) {
				if(temp[i] == num) {
					va = true;
				}
			}
		}
		return va;
	}
	
	public void mostrarContas() {
		if( totalPes > 0) {
			System.out.println("Contas de Pesqueiros: \n");
			for(int i=0; i<totalPes; i++) {
				bancoPes[i].imprimirConta();
			}
		}
		else {
			System.out.println("Não existem contas de Pesqueiros cadastradas.\n");
		}
		
		if( totalCli > 0) {
			System.out.println("Contas de Pescadores: \n");
			for(int i=0; i<totalCli; i++) {
				bancoCli[i].imprimirConta();
			}
		}
		else {
			System.out.println("Não existem contas de Pescadores cadastradas.\n");
		}
	}
	
	public void mostrarTipos(Boolean pes, Boolean cli) {
		temp = new int[10];
		totalTemp = 0;
		if(pes == true) {
			if(totalPes > 0) {
				for(int i=0; i<totalPes; i++) {
					System.out.println(i+":");
					bancoPes[i].imprimirTipo();
					adicionarTemp(i);
				}
			}
		}
		else if(cli == true) {
			if(totalCli > 0) {
				for(int i=0; i<totalCli; i++) {
					System.out.println(i+":");
					bancoCli[i].imprimirTipo();
					adicionarTemp(i);
				}
			}
		}
	}
	
	public void mostrarReservas(Boolean pes1, Boolean pes2,int conta) {
		temp = new int[10];
		totalTemp = 0;
		if(totalReser > 0) {
			for(int i=0; i<totalReser; i++) {
				if(pes1 == true) {
					if(bancoPes[conta].getNome() == reserva[i].getNomePesqueiro()) {
						System.out.println(i+":");
						reserva[i].imprimirReservas();
						adicionarTemp(i);
					}
				} 
				else if(pes2 == true) {
					if(bancoCli[conta].getNome() == reserva[i].getNomePescador()) {
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
			if(reserva[num].getRePes() == false && reserva[num].getReCli() == false) {
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
	
	public void removerContas(Boolean pes, Boolean cli,int num) {
		if(pes == true) {
			for(int i=0; i<totalPes;i++) {
				if(bancoPes[i] == bancoPes[num]) {
					for(int j = i; j < totalPes - 1;j++) {
						bancoPes[j] = bancoPes[j+1];
					}
					System.out.println("A conta Pesqueiro "+ num + " foi deletada.");
					totalPes--;
				}
			}
		}
		else if(cli == true) {
			for(int i=0; i<totalCli;i++) {
				if(bancoCli[i] == bancoCli[num]) {
					for(int j = i; j < totalCli - 1;j++) {
						bancoCli[j] = bancoCli[j+1];
					}
					System.out.println("A conta Pescador"+ num + " foi deletada.");
					totalCli--;
				}
			}
		}
	}
}
