package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;

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
			System.out.println("                                                       "+ Cores.TEXT_RESET);
			
			opcao = leia.nextInt();

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
					System.out.println(Cores.TEXT_WHITE_BOLD + "APAGAR A CONTAA\n\n");

					break;
				case 6:
					System.out.println(Cores.TEXT_WHITE_BOLD + "SAQUE\n\n");

					break;
				case 7:
					System.out.println(Cores.TEXT_WHITE_BOLD + "DEPÓSITO\n\n");

					break;
				case 8:
					System.out.println(Cores.TEXT_WHITE_BOLD + "TRANSFERÊNCIA ENTRE CONTASA\n\n");

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

}
