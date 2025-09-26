package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);// se posicionarmos aqui o Scanner, ele se torna Global,
	private static final ContaController contaController = new ContaController();
	// e se aplica a qualquer método
	// private: só funciona dentro da classe menu
	// static: tudo que tá dentro do método main precisa ser estático
	// final:

	public static void main(String[] args) {

		int opcao;

		criarContasTeste();

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

			} catch (InputMismatchException e) {
				opcao = -1; // opção = -1
				System.out.println("\nDigite um número inteiro entre 0 e 8!");
				leia.nextLine();

			}

			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBANCO MARMOTTA - VOCÊ É NOSSO CASE DE SUCESSO");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "CRIAR CONTA\n\n");
				cadastrarConta();
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "LISTAR TODAS AS CONTAS\n\n");

				listarContas();

				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "CONSULTAR DADOS DA CONTA - POR NÚMERO\n\n");
				procurarContaPorNumero();
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "ATUALIZAR DADOS DA CONTA\n\n");
				atualizarConta();

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "APAGAR A CONTA\n\n");

				deletarConta();

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "SAQUE\n\n");
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "DEPÓSITO\n\n");
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "TRANSFERÊNCIA ENTRE CONTAS\n\n");
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOPÇÃO INVÁLIDA!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
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

	private static void criarContasTeste() {
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
		contaController.cadastrar(
				new ContaPoupanca(contaController.gerarNumero(), 456, 2, "Marcia Condarco", 1000000.00f, 10));

	}

	private static void listarContas() {
		contaController.listarTodas();
	}

	private static void cadastrarConta() {

		System.out.println("Digite o número da Agência: ");
		int agencia = leia.nextInt();

		System.out.println("Digite o nome do Titular: ");
		leia.skip("\\R");
		String titular = leia.nextLine();

		System.out.println("Digite o tipo da Conta:\n" + "1 - Conta Corrente\n" + "2 - Conta Poupança \n");
		int tipo = leia.nextInt();

		System.out.println("Digite o Saldo inicial: ");
		float saldo = leia.nextFloat();

		switch (tipo) {

		case 1 -> {
			System.out.println("Digite o Limite inicial: ");
			float limite = leia.nextFloat();
			contaController
					.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));

		}
		case 2 -> {
			System.out.println("Digite o dia do aniversário da conta: ");
			int aniversario = leia.nextInt();
			contaController.cadastrar(
					new ContaPoupanca(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));

		}
		default -> System.out.println(Cores.TEXT_RED + "Tipo de conta inválido!" + Cores.TEXT_RESET);

		}

	}

	private static void procurarContaPorNumero() {

		System.out.println("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		contaController.procurarPorNumero(numero);

	}

	private static void deletarConta() {

		System.out.println("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		Conta conta = contaController.buscarNaCollection(numero);

		if (conta != null) {

			System.out.println(
					"Tem certeza que deseja excluir esta conta?\n" + "Digite 1 para SIM\n" + "Digite 2 para VOLTAR\n");
			int confirma = leia.nextInt();

			if (confirma == 1) {
				contaController.deletar(numero);
			} else {
				System.out.println("Que bom que você mudou de ideia! A operação foi cancelada.");
			}

		} else {
			System.out.printf("\nA conta número %d não foi encontrada! Verifique os dados e tente novamente.", numero);
		}
	}
	private static void atualizarConta() {
		 System.out.print("Digite o número da conta: ");
		 int numero = leia.nextInt();
		 leia.nextLine();
		 
		Conta conta = contaController.buscarNaCollection(numero);
		
		if (conta != null) {
			 
			int agencia = conta.getAgencia();
			String titular = conta.getTitular();
			int tipo = conta.getTipo();
			float saldo = conta.getSaldo();
			 
			 //a ? é chamada de if ternário ou operador ternário
			 /*é a mesma coisa 	que fazer um if else, sendo: 
			*if (entrada.isEmpty()) {
			*agencia = agencia
			*}else {
			*System.out.println("Digite a nova agência:)*/ 
			
			System.out.printf("Agência Atual: %d.\n Pressione ENTER para manter a Agência atual"
					+ "\nOU\nInsira a Nova Agência: ", agencia);
			String entrada = leia.nextLine();
			agencia = entrada.isEmpty() ? agencia : Integer.parseInt(entrada);//a ? nesse caso é condição: se entrada for vazia, mantenha agência, senão -> converta para inteiro
			 
			
			System.out.printf("Titular Atual: %s.\n Pressione ENTER para manter o Titular atual"
				 		+ "\nOU\nInsira Novo Titular: ", titular);
			entrada = leia.nextLine();
			titular = entrada.isEmpty() ? titular : entrada;
			
			System.out.printf("Saldo Atual: %.2f\nPressione ENTER para manter o Saldo atual"
					+ "\nOU\nInsira Novo Saldo: ", saldo);
			entrada = leia.nextLine();
			saldo = entrada.isEmpty() ? saldo : Float.parseFloat(entrada);
				
			
			
			switch(tipo) {
			case 1 -> {
					float limite = ((ContaCorrente) conta).getLimite(); //casting - não existe limite na classe conta porque limite pertence a classe Conta Corrente
					/*Com o casting nós transformamos conta em ContaCorrente - essa transformação só é possível pq
					 * ContaCorrente é uma herança de Conta - a partir da conversão, conseguimos acessar o limite.
					 */
					
					System.out.printf("Limite Atual: %.2f\nPressione ENTER para manter o Limite atual"
							+ "\nOU"
							+ "\nInsira Novo Limite: ", limite);
					entrada = leia.nextLine();
					limite = entrada.isEmpty() ? limite : Float.parseFloat(entrada);
					contaController.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
								
				} case 2 -> {
					
					int aniversario = ((ContaPoupanca) conta).getAniversario();
					System.out.printf("Aniversário Atual: %s.\nPressione ENTER para manter o Saldo atual\"\r\n"
							+ "\nOU"
							+ "\nInsira Novo Saldo: ", aniversario);					
					
				entrada = leia.nextLine();
				aniversario = entrada.isEmpty() ? aniversario : Integer.parseInt(entrada);
				contaController.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
				
				} default -> System.out.println(Cores.TEXT_RED + "Tipo de conta inválido!" + Cores.TEXT_RESET);	 
				 
				}	 
		 }else {
			 System.out.printf("\nA conta número %d não foi encontrada! Verifique os dados e tente novamente.", numero);
		 }
	
	
	
	}
	
	
	}

