package br.edu.fateccotia.main;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		int opcao, conta;
		Long tempL;
		String temp;
		Scanner entradaNum = new Scanner(System.in);
		Scanner entrada = new Scanner(System.in);
		BancoDados dados = new BancoDados();
		ContaPesqueiro pesqueiro;
		ContaPescador pescador;
		Reservas reservas;
		
		System.out.println("Digite 1: Cadastrar Conta | 2: Entrar Conta | 3: Mostrar Contas | 4: Mostrar Reservas | 5: Contas de Exemplo |0: Sair");
		opcao = entradaNum.nextInt();
		
		while(opcao != 0) {
			switch(opcao) {
			case 1:
				System.out.println("\nDigite 1: Cadastrar Conta Pesqueiro | 2: Cadastrar Conta Pescador");
				opcao = entradaNum.nextInt();
				
				switch(opcao) {
				case 1:
					pesqueiro = new ContaPesqueiro();
					System.out.println("Informe o nome do Pesqueiro:");
					pesqueiro.setNome(entrada.nextLine());
					System.out.println("Informe o E-mail de Contato:");
					pesqueiro.setEmail(entrada.nextLine());
					System.out.println("Informe o Endereço do Local:");
					pesqueiro.setEndereco(entrada.nextLine());
					System.out.println("Informe O Telefone de Contato:");
					pesqueiro.setTelefone(Long.parseLong(entrada.nextLine()));
					System.out.println("Informe a quantide de Lagos:");
					pesqueiro.setQuantide(Integer.parseInt(entrada.nextLine()));
					System.out.println("Informe os tipos de peixes:");
					pesqueiro.setTipoPeixe(entrada.nextLine());
					System.out.println("Informe o nome do proprietario:");
					pesqueiro.setNomePro(entrada.nextLine());
					System.out.println("Informe o CNPJ: ");
					pesqueiro.setCnpj(Long.parseLong(entrada.nextLine()));
					dados.adicionarBanco(false, true, pesqueiro);
					break;
					
				case 2:
			    	pescador = new ContaPescador();
			    	System.out.println("\nInforme o seu nome: ");
					pescador.setNome(entrada.nextLine());
					System.out.println("Informe o E-mail de Contato: ");
					pescador.setEmail(entrada.nextLine());
					System.out.println("Informe o Endereço do Local: ");
					pescador.setEndereco(entrada.nextLine());
					System.out.println("Informe o Telefone de Contato: ");
					pescador.setTelefone(Long.parseLong(entrada.nextLine()));
					System.out.println("Informe o CPF: ");
					pescador.setCpf(Long.parseLong(entrada.nextLine()));
					dados.adicionarBanco(true, false, pescador);
					break;
					
				default:
					System.out.println("Opção invalida!");
					
				}
				break;
				
			case 2:
				if(dados.getTotalPes() > 0 || dados.getTotalCli() > 0) {
					System.out.println("\nDigite 1: Entrar na Conta Pesqueiro | 2: Entrar na Conta Pescador | 0: Voltar");
					opcao = entradaNum.nextInt();
					
					while(opcao != 0) {
						switch(opcao) {
						case 1:
							
							if (dados.getTotalPes() > 0) {
								
								dados.mostrarTipos(true, false);
								System.out.println("Escolha uma conta para entrar: ");
								conta = entradaNum.nextInt();
								
								if(dados.verificarDados(false, conta) == true) {
									
									System.out.println("Digite 1: Mostrar Reservas | 2: Cancelar Reservas | 3: Atualizar Dados | 0: Voltar\n");
									opcao = entradaNum.nextInt();
									
									while(opcao != 0) {
										switch(opcao) {
										case 1:
											dados.mostrarReservas(true, false, conta);
											break;
											
										case 2:
											if(dados.verificarDados(true, conta)) {
												dados.mostrarReservas(true, false, conta);
												conta = entradaNum.nextInt();
												
												if(dados.verificarDados(false ,conta) == true) {
													dados.getReserva(conta).setRePes(false);
													dados.cancelarReservas(conta);
													break;
												}
												else {
													System.out.println("Reserva invalida!\n");
												}
											}
											else {
												System.out.println("Esse Pesqueiro não possui reservas.\n");
											}
										
										case 3:
											System.out.println("Digite 1: Nome do Pesqueiro | 2: E-mail | 3: Endereço | 4: Telefone");
											opcao = entradaNum.nextInt();
											
											switch(opcao) {
											case 1:
												temp = dados.getBancoPes(conta).getNome();
												System.out.println("Digite o novo nome do Pesqueiro: ");
												dados.getBancoPes(conta).setNome(entrada.nextLine());
												System.out.println("Antigo nome do pesqueiro: "+ temp);
												System.out.println("Novo nome do pesqueiro: "+ dados.getBancoPes(conta).getNome() + "\n");
												break;
												
											case 2:
												temp = dados.getBancoPes(conta).getEmail();
												System.out.println("Digite o novo e-mail do Pesqueiro: ");
												dados.getBancoPes(conta).setEmail(entrada.nextLine());
												System.out.println("Antigo e-mail do pesqueiro: "+ temp);
												System.out.println("Novo e-mail do pesqueiro: "+ dados.getBancoPes(conta).getEmail() + "\n");
												break;
												
											case 3:
												temp = dados.getBancoPes(conta).getEndereco();
												System.out.println("Digite o novo endereço do Pesqueiro: ");
												dados.getBancoPes(conta).setEndereco(entrada.nextLine());
												System.out.println("Antigo endereço do pesqueiro: "+ temp);
												System.out.println("Novo endereço do pesqueiro: "+ dados.getBancoPes(conta).getEndereco() + "\n");
												break;
												
											case 4:
												tempL = dados.getBancoPes(conta).getTelefone();
												System.out.println("Digite o novo telefone do Pesqueiro: ");
												dados.getBancoPes(conta).setTelefone(Long.parseLong(entrada.nextLine()));
												System.out.println("Antigo telefone do pesqueiro: "+ tempL);
												System.out.println("Novo telefone do pesqueiro: "+ dados.getBancoPes(conta).getTelefone() + "\n");
												break;
												
											default:
												System.out.println("Opção invalida!\n");
											}
											break;
											
										default:
											System.out.println("Opção invalida!\n");
										}
										
										System.out.println("Digite 1: Mostrar Reservas | 2: Cancelar Reservas | 3: Atualizar Dados | 0: Voltar\n");
										opcao = entradaNum.nextInt();
									}
								}
								else {
									System.out.println("Conta invalida!\n");
								}
								
								break;
							}
							else {
								System.out.println("Não existem contas de Pesqueiros cadastradas.\n");
							}
							
							break;
							
						case 2:
							if(dados.getTotalCli() > 0) {
								
								System.out.println("Digite: \n");
								dados.mostrarTipos(false, true);
								conta = entradaNum.nextInt();
								
								if(dados.verificarDados(false, conta) == true) {
									
									System.out.println("Digite 1: Criar Reservas | 2: Mostrar Reservas Feitas | 3: Cancelar Reservas | 4: Atualizar Dados | 0: Voltar");
									opcao = entradaNum.nextInt();
									
									while(opcao != 0) {
										switch(opcao) {
										case 1:
											if(dados.getTotalPes() > 0) {
												
												System.out.println("Escolha qual Pesqueiro deseja realizar a reserva: ");
												System.out.println("\nDigite: ");
												dados.mostrarTipos(true, false);
												conta = entradaNum.nextInt();
												
												if(dados.verificarDados(false, conta) == true) {
													reservas = new Reservas();
													reservas.setNomePescador(dados.getBancoCli(conta).getNome());
													reservas.setNomePesqueiro(dados.getBancoPes(conta).getNome());
													System.out.println("Digite a data de Reserva: ");
													reservas.setData(Integer.parseInt(entrada.nextLine()));
													dados.adicionarReserva(reservas);
												}
												else {
													System.out.println("Pesqueiro invalido!\n");
												}
											}
											else {
												System.out.println("Não existem contas de Pescadores cadastradas.\n");
											}
											break;
											
										case 2:
											dados.mostrarReservas(false, true, conta);
											break;
											
										case 3:
											if(dados.verificarDados(true, conta)) {
												dados.mostrarReservas(false, true, conta);
												conta = entradaNum.nextInt();
												if(dados.verificarDados(false, conta) == true) {
													dados.getReserva(conta).setReCli(false);
													dados.cancelarReservas(conta);
												}
												else {
													System.out.println("Reserva invalida!\n");
												}
											}
											else {
												System.out.println("Esse Pescador não possui reservas.\n");
											}
											
											
											break;
											
										case 4:
											System.out.println("Digite 1: Nome | 2: E-mail | 3: Endereço | 4: Telefone");
											opcao = entradaNum.nextInt();
											
											switch(opcao) {
											case 1:
												temp = dados.getBancoCli(conta).getNome();
												System.out.println("Digite o seu novo nome: ");
												dados.getBancoCli(conta).setNome(entrada.nextLine());
												System.out.println("Nome antigo : "+ temp);
												System.out.println("Nome atual: "+ dados.getBancoCli(conta).getNome() + "\n");
												break;
												
											case 2:
												temp = dados.getBancoCli(conta).getEmail();
												System.out.println("Digite o novo e-mail: ");
												dados.getBancoCli(conta).setEmail(entrada.nextLine());
												System.out.println("E-mail antigo: "+ temp);
												System.out.println("E-mail novo: "+ dados.getBancoCli(conta).getEmail() + "\n");
												break;
												
											case 3:
												temp = dados.getBancoCli(conta).getEndereco();
												System.out.println("Digite o novo endereço: ");
												dados.getBancoCli(conta).setEndereco(entrada.nextLine());
												System.out.println("Endereço antigo: "+ temp);
												System.out.println("Endereço novo: "+ dados.getBancoCli(conta).getEndereco() + "\n");
												break;
											
											case 4:
												tempL = dados.getBancoCli(conta).getTelefone();
												System.out.println("Digite o novo telefone: ");
												dados.getBancoCli(conta).setTelefone(Long.parseLong(entrada.nextLine()));
												System.out.println("Telefone antigo: "+ tempL);
												System.out.println("Telefone novo: "+ dados.getBancoCli(conta).getTelefone() + "\n");
												break;
											}
											break;
											
										default:
											System.out.println("Opção invalida!\n");
										}
										
										System.out.println("Digite 1: Criar Reservas | 2: Mostrar Reservas Feitas | 3: Cancelar Reservas | 4: Atualizar Dados | 0: Voltar");
										opcao = entradaNum.nextInt();
									}
								}
								else {
									System.out.println("Conta invalida!\n");
									
								}
							} 
							else {
								System.out.println("Não existem contas de Pescadores cadastradas.\n");
							}
							break;
							
						default:
							System.out.println("Opção invalida!\n");
						}
					
						System.out.println("Digite 1: Entrar na Conta Pesqueiro | 2: Entrar na Conta Pescador | 0: Voltar");
						opcao = entradaNum.nextInt();
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
				dados.mostrarReservas(false, false, 0);
				break;
				
			case 5:
				System.out.println("Digite 1: Cadastrar Conta Exemplo Pesqueiro | 2: Cadastar Conta Exemplo Pescador ");
				opcao = entradaNum.nextInt();
				
				switch(opcao) {
				case 1:
					pesqueiro = new ContaPesqueiro();
					pesqueiro.setNome("Pesqueiro das Graças");
					pesqueiro.setEmail("gracas@gmail.com");
					pesqueiro.setEndereco("Rua das Graças, 542");
					pesqueiro.setTelefone(Long.parseLong("1140028922"));
					pesqueiro.setQuantide(4);
					pesqueiro.setTipoPeixe("Tilápia, Pirarucu, Corvina.");
					pesqueiro.setNomePro("Crausio Oliveira");
					pesqueiro.setCnpj(Long.parseLong("12345678912300"));
					dados.adicionarBanco(false, true, pesqueiro);
					System.out.println("Conta de Pesqueiro Exemplo Cadastrada.\n");
					break;
					
				case 2:
					pescador = new ContaPescador();
					pescador.setNome("Paulo da Vara");
					pescador.setEmail("paulo@gmail.com");
					pescador.setEndereco("Ruas das Varas, 234");
					pescador.setTelefone(Long.parseLong("11999990000"));
					pescador.setCpf(Long.parseLong("12345678900"));
					dados.adicionarBanco(true, false, pescador);
					System.out.println("Conta de Pescador Exemplo Cadastrada.\n");
					break;
					
				default:
					System.out.println("Opção invalida!\n");
				}
				break;
				
				
			default:
				System.out.println("Opção invalida!\n");
				
			}
			
			System.out.println("Digite 1: Cadastrar Conta | 2: Entrar Conta | 3: Mostrar Contas | 4: Mostrar Reservas | 5: Contas de Exemplo |0: Sair");
			opcao = entradaNum.nextInt();
		}
	}
}
