package conta_bancaria.repository;

import conta_bancaria.model.Conta;

public interface ContaRepository {

	//Métodos do CRUD
	
	//Definindo os métodos do Menu do projeto 
	
	//não precisamos criar método abstract porque importamos da classe Conta que já é abstrata
		
	public void listarTodas();
	public void cadastrar(Conta conta); //objeto conta da classe conta
	public void atualizar(Conta conta);
	public void procurarPorNumero(int numero);
	public void deletar(int numero);
	public void depositar();
	
	//Métodos Bancários - Operações
	
	public void sacar(int numero, float valor); //pelo numero da conta já teremos limite e saldo
	public void depositar(int numero, float valor);
	public void transferir(int numeroOrigem, int numeroDestino, float valor);
	
	/*Os métodos serão implementados em uma classe que existirá somente
	 * para executar as operações definidas pelos métodos
	 *
	 */
	
	
}
