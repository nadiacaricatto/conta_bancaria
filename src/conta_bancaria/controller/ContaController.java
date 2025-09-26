package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository{

	private List<Conta> listaContas = new ArrayList<Conta>();
	//é privada porque só funciona dentro da classe conta controller
	int numero = 0;
	
	@Override
	public void listarTodas() {
		for(var conta : listaContas) {
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
		
		
	}

	@Override
	public void procurarPorNumero(int numero) {
		
		
	}

	@Override
	public void deletar(int numero) {
	
		
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

}
