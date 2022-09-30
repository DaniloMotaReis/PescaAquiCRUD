package br.edu.fateccotia.main;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		int opcao, conta, reserva;
		Scanner entrada = new Scanner(System.in);
		BancoDados dados = new BancoDados();
		ContaPesqueiro pesqueiro;
		ContaPescador pescador;
		Reservas reservas;
		
		System.out.println("Digite 1: Cadastrar Conta | 2: Entrar Conta | 3: Mostrar Contas | 4: Mostrar Reservas | 5: Sair");
		opcao = entrada.nextInt();
		
		while(opcao != 5) {
			switch(opcao) {
			case 1:
				System.out.println("\nDigite 1: Cadastrar Conta Pesqueiro | 2: Cadastrar Conta Pescador");
				opcao = entrada.nextInt();
				
				switch(opcao) {
				case 1:
					pesqueiro = new ContaPesqueiro();
					System.out.println("\nInforme o nome do Pesqueiro: ");
					pesqueiro.setNome(entrada.next());
					System.out.println("Informe o E-mail de Contato: ");
					pesqueiro.setEmail(entrada.next());
					System.out.println("Informe o Endereço do Local: ");
					pesqueiro.setEndereco(entrada.next());
					System.out.println("Informe O Telefone de Contato: ");
					pesqueiro.setTelefone(entrada.nextLong());
					System.out.println("Informe a quantide de Lagos: ");
					pesqueiro.setQuantide(entrada.nextInt());
					System.out.println("Informe os tipos de peixes: ");
					pesqueiro.setTipoPeixe(entrada.next());
					System.out.println("Informe o nome do proprietario: ");
					pesqueiro.setNomePro(entrada.next());
					System.out.println("Informe o CNPJ: ");
					pesqueiro.setCnpj(entrada.nextLong());
					dados.adicionarBanco(pesqueiro);
					break;
					
				case 2:
			    	pescador = new ContaPescador();
			    	System.out.println("\nInforme o seu nome: ");
					pescador.setNome(entrada.next());
					System.out.println("Informe o E-mail de Contato: ");
					pescador.setEmail(entrada.next());
					System.out.println("Informe o Endereço do Local: ");
					pescador.setEndereco(entrada.next());
					System.out.println("Informe O Telefone de Contato: ");
					pescador.setTelefone(entrada.nextLong());
					System.out.println("Informe o CPF: ");
					pescador.setCpf(entrada.nextLong());
					dados.adicionarBanco(pescador);
					break;
					
				default:
					System.out.println("Opção invalida!");
					
				}
				break;
				
			case 2:
				if(dados.getTotal() > 0) {
					System.out.println("\nDigite 1: Entrar na Conta Pesqueiro | 2: Entrar na Conta Pescador | 3: Voltar");
					opcao = entrada.nextInt();
					while(opcao != 3) {
						switch(opcao) {
						case 1:
							dados.mostrarTipos(true, false);
							System.out.println("Escolha uma conta para entrar: ");
							dados.mostrarTipos(true, false);
							conta = entrada.nextInt();
							
							if (dados.verificarDados(conta) == true) {
								
								System.out.println("\nDigite 1: Mostrar Reservas | 2: Cancelar Reservas");
								opcao = entrada.nextInt();
								switch(opcao) {
								case 1:
									dados.mostrarReservas(true, false, conta);
									break;
									
								case 2:
									dados.mostrarReservas(true, false, conta);
									conta = entrada.nextInt();
									dados.getReserva(conta).setRePes(false);
									dados.cancelarReservas(conta);
									break;
									
								default:
									System.out.println("Opção invalida!\n");
								}
								break;
							}
							else {
								System.out.println("Conta invalida!\n");
							}
							
							break;
							
						case 2:
							System.out.println("\nDigite: ");
							dados.mostrarTipos(false, true);
							conta = entrada.nextInt();
			
							if(dados.verificarDados(conta)) {
								
								System.out.println("Digite 1: Criar Reservas | 2: Mostrar Reservas Feitas | 3: Cancelar Reservas");
								opcao = entrada.nextInt();
								
								switch(opcao) {
								case 1:
									reservas = new Reservas();
									reservas.setNomePescador(dados.getBanco(conta).getNome());
									System.out.println("Escolha qual Pesqueiro deseja realizar a reserva: ");
									System.out.println("\nDigite: ");
									dados.mostrarTipos(true, false);
									conta = entrada.nextInt();
									reservas.setNomePesqueiro(dados.getBanco(conta).getNome());
									System.out.println("Digite a data de Reserva: ");
									reservas.setData(entrada.nextInt());
									dados.adicionarReserva(reservas);
									break;
									
								case 2:
									dados.mostrarReservas(false, true, conta);
									break;
									
								case 3:
									dados.mostrarReservas(false, true, conta);
									conta = entrada.nextInt();
									dados.getReserva(conta).setReCli(false);
									dados.cancelarReservas(conta);
									break;
									
								default:
									System.out.println("Opção invalida!\n");
								}
							} 
							else {
								System.out.println("Conta invalida!\n");
							}
							break;
							
						default:
							System.out.println("Opção invalida!\n");
						}
					
						System.out.println("Digite 1: Entrar na Conta Pesqueiro | 2: Entrar na Conta Pescador | 3: Voltar");
						opcao = entrada.nextInt();
					}
				}
				else {
					System.out.println("Não existem contas cadastradas.\n");
				}
				break;
			    
			case 3:
				dados.mostrarContas();
				break;
				
			case 4:
				dados.mostrarReservas(null, null, 0);
				break;
				
			default:
				System.out.println("Opção invalida!\n");
				
			}
			
			System.out.println("Digite 1: Cadastrar Conta | 2: Entrar Conta | 3: Mostrar Contas | 4: Mostrar Reservas | 5: Sair\"");
			opcao = entrada.nextInt();	
		}

	}
}
