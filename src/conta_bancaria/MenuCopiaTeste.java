package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class MenuCopiaTeste {

	private static final Scanner leia = new Scanner(System.in);//se posicionarmos aqui o Scanner, ele se torna Global, e se aplica a qualquer método
//private: só funciona dentro da classe menu
	//static: tudo que tá dentro do método main precisa ser estático
	//final: 
	public static void main(String[] args) {

		

		int opcao;

		/*
		 * Conta c1 = new Conta(1, 123, 1, "Cintia Dourado", 500000.00f);
		 * 
		 * Conta c2 = new Conta(2, 123, 2, "Priscila Lins", 500000.00f);
		 * 
		 * System.out.println("O Saldo da conta é: " + c1.getSaldo());
		 * 
		 * c1.setSaldo(600000.00f);
		 * 
		 * System.out.println("O Saldo da conta é: " + c1.getSaldo());
		 * 
		 * c1.visualizar();
		 * 
		 * c2.visualizar();
		 * 
		 * System.out.println(c1.sacar(1000));
		 * 
		 * System.out.println("O Saldo da conta é: " + c1.getSaldo());
		 * 
		 * System.out.println(c2.sacar(1000000));
		 * 
		 * System.out.println("O Saldo da conta é: " + c2.getSaldo());
		 * 
		 * c1.depositar(5000); System.out.println("O Saldo da conta é: " +
		 * c1.getSaldo());
		 */
		// Instanciar objetos da Classe CC

		ContaCorrente cc1 = new ContaCorrente(3, 456, 1, "Thuany Silva", 1000000.00f, 100000.00f);

		// Sacar Conta Corrente:

		cc1.visualizar();
		System.out.println(cc1.sacar(2000000.00f));
		cc1.visualizar();

		System.out.println(cc1.sacar(2000.00f));
		cc1.visualizar();

		cc1.depositar(5000.00f);
		cc1.visualizar();

		// Instanciar Objeto Classe Conta Poupança (CP)

		ContaPoupanca cp1 = new ContaPoupanca(1, 111, 2, "Nádia", 500.00f, 2);

		// Depositar Conta Poupança

		cp1.depositar(1000.00f);
		cp1.visualizar();

		// Sacar Conta Poupança

		// cp1.sacar(100.00f);
		// cp1.visualizar();

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*******************************************************");
			System.out.println("                                                       ");
			System.out.println("                    BANCO MARMOTTA                     ");
			System.out.println("                                                       ");
			System.out.println("*******************************************************");
			System.out.println("                                                       ");
			System.out.println("                1 - CRIAR CONTA                        ");
			System.out.println("                2 - LISTAR TODAS AS CONTAS             ");
			System.out.println("                3 - BUSCAR CONTA POR NÚMERO            ");
			System.out.println("                4 - ATUALIZAR DADOS DA CONTA           ");
			System.out.println("                5 - APAGAR CONTA                       ");
			System.out.println("                6 - SACAR                              ");
			System.out.println("                7 - DEPOSITAR                          ");
			System.out.println("                8 - TRANSFERIR VALORES ENTRE CONTAS    ");
			System.out.println("                0 - SAIR                               ");
			System.out.println("                                                       ");
			System.out.println("*******************************************************");
			System.out.println("              ENTRE COM A OPÇÃO DESEJADA:              ");
			System.out.println("                                                       ");
			System.out.println("                                                       " + Cores.TEXT_RESET);

			try {

				opcao = leia.nextInt();
				leia.nextLine();

			} catch (InputMismatchException e){
				opcao = -1; //opção = -1 
				System.out.println("\nDigite um número inteiro entre 0 e 8!");
				leia.nextLine();
				
			}
			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBANCO MARMOTTA - VOCÊ É NOSSO CASE DE SUCESSO");
				sobre();
				leia.close();
				System.exit(0);

				switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_WHITE_BOLD + "CRIAR CONTA\n\n");

					break;
				case 2:
					System.out.println(Cores.TEXT_WHITE_BOLD + "LISTAR TODAS AS CONTAS\n\n");

					break;
				case 3:
					System.out.println(Cores.TEXT_WHITE_BOLD + "CONSULTAR DADOS DA CONTA - POR NÚMERO\n\n");

					break;
				case 4:
					System.out.println(Cores.TEXT_WHITE_BOLD + "ATUALIZAR DADOS DA CONTA\n\n");

					break;
				case 5:
					System.out.println(Cores.TEXT_WHITE_BOLD + "APAGAR A CONTA\n\n");

					break;
				case 6:
					System.out.println(Cores.TEXT_WHITE_BOLD + "SAQUE\n\n");

					break;
				case 7:
					System.out.println(Cores.TEXT_WHITE_BOLD + "DEPÓSITO\n\n");

					break;
				case 8:
					System.out.println(Cores.TEXT_WHITE_BOLD + "TRANSFERÊNCIA ENTRE CONTAS\n\n");

					break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOPÇÃO INVÁLIDA!\n" + Cores.TEXT_RESET);
					break;
				}
			}
		}
	}

	public static void sobre() {
		System.out.println(Cores.TEXT_CYAN_BOLD + "\n*************************************************");
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Projeto Dsenvolvido por: ");
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Nádia Piccinin Caricatto");
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "nadia.caricatto@outlook.com");
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "https://github.com/nadiacaricatto");
		System.out.println(Cores.TEXT_CYAN_BOLD + "\n*************************************************");

	}

	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione ENTER para continuar!");
		leia.nextLine();
		
	}
	
}
