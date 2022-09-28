package br.edu.fateccotia.main;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		int opcao, conta;
		Scanner entrada = new Scanner(System.in);
		BancoDados dados = new BancoDados();
		ContaPesqueiro pesqueiro;
		ContaPescador pescador;
		Reservas reservas;
		
		System.out.println("Digite 1: Cadastrar Conta | 2: Entrar Conta | 3: Mostrar Contas | 4: Sair");
		opcao = entrada.nextInt();
		
		while(opcao != 4) {
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
			    	System.out.println("\nInforme o nome do Pesqueiro: ");
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
				while(opcao != 3) {
					System.out.println("Digite 1: Entrar na Conta Pesqueiro | 2: Entrar na Conta Pescador | 3: Voltar");
					opcao = entrada.nextInt();
					
					switch(opcao) {
					case 1:
						System.out.println("Digite: ");
						dados.mostrarTipos(true, false);
						conta = entrada.nextInt();
		
						System.out.println("Digite 1: Mostrar Reservas | 2: Cancelar Reservas");
						opcao = entrada.nextInt();
						
						switch(opcao) {
						case 1:
							dados.mostrarReservas(true, false, conta);
							break;
							
						case 2:
							break;
							
						default:
							System.out.println("Opção invalida!");
						}
						
						
						
					case 2:
						System.out.println("Digite: ");
						dados.mostrarTipos(false, true);
						conta = entrada.nextInt();
		
						System.out.println("Digite 1: Criar Reservas | 2: Cancelar Reservas");
						opcao = entrada.nextInt();
						
						switch(opcao) {
						case 1:
							dados.mostrarReservas(true, false, conta);
							break;
							
						case 2:
							break;
							
						default:
							System.out.println("Opção invalida!");
						}
						
					default:
						System.out.println("Opção invalida!");
					}
				
					System.out.println("\nDigite 1: Entrar na Conta Pesqueiro | 2: Entrar na Conta Pescador | 3: Voltar");
					opcao = entrada.nextInt();
				}
				break;
			    
			case 3:
				dados.mostrarContas();
				break;
				
			default:
				System.out.println("Opção invalida!");
				
			}
			
			System.out.println("\nDigite 1: Cadastrar Conta | 2: Entrar Conta | 3: Mostrar Contas | 4: Sair");
			opcao = entrada.nextInt();	
		}

	}
}
