package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private List<Conta> listaContas = new ArrayList<Conta>();
	// é privada porque só funciona dentro da classe conta controller
	int numero = 0;

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}

	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("Conta cadastrada com sucesso!");

	}

	@Override
	public void atualizar(Conta conta) {

		var buscarConta = buscarNaCollection(conta.getNumero()); // obtém o número

		if (buscarConta != null) {
			listaContas.set(listaContas.indexOf(buscarConta), conta); // alterar o número

			System.out.printf("\nA conta número %d foi atualizada com sucessso!\n", conta.getNumero());
		} else {
			System.out.printf("A conta %d não foi encontrada. Verifique os dados e tente novamente.%n",
					conta.getNumero());
		}
		// Exibir os dados atualizados

	}

	@Override
	public void procurarPorNumero(int numero) {

		var conta = buscarNaCollection(numero);

		if (conta != null) {
			conta.visualizar();
		} else {
			System.out.printf("A conta número %d não foi encontrada!%n", numero);

		}

	}

	@Override
	public void deletar(int numero) {

		var conta = buscarNaCollection(numero);

		if (conta != null) {
			if (listaContas.remove(conta) == true) {
				System.out.printf("\nConta %d foi encerrada com sucesso.%n", numero);
			}
		} else {
			System.out.printf("A conta %d não foi encontrada!%n", numero);

		}
	}

	@Override
	public void depositar() {

	}

	@Override
	public void sacar(int numero, float valor) {

	}

	@Override
	public void depositar(int numero, float valor) {

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {

	}

	// Métodos Auxiliares

	public int gerarNumero() {
		return ++numero; // retorna um número pré incrememtado, ou seja: primeiro encrementa, e depois
							// retorna o resultado

	}

	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;

			}
		}

		return null;

	}
}
