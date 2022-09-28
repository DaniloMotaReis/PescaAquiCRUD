package br.edu.fateccotia.main;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		int opcao;
		Scanner entrada = new Scanner(System.in);
		BancoDados dados = new BancoDados();
		ContaPesqueiro pesqueiro;
		ContaPescador pescador;
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
				}
				break;
				
			    
				
			case 3:
				dados.mostrarContas();
				
			}
			
			System.out.println("\nDigite 1: Cadastrar Conta | 2: Entrar Conta | 3: Mostrar Contas | 4: Sair");
			opcao = entrada.nextInt();	
		}

	}
}
