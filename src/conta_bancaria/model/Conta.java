package conta_bancaria.model;

public class Conta {

	// Atributos da Classe

	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;

	// Método Construtor:

	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;// Método Construtor da Classe - Terá [sempre] o mesmo nome da Classe
		this.agencia = agencia; // this: serve armazenar os parâmetros dentro dos atributos do objeto
		this.tipo = tipo; // isso por que eles tem o mesmo nome
		this.titular = titular;
		this.saldo = saldo;
	}
	
	public Conta() {} // Construtor Vazio: cria um objeto sem nenhum atribuitp - mesmo nome, parâmetros diferentes
	//Chamado de sobrecarga de Método: dois métodos, na mesma classe, com parâmetros diferentes
	//Pode ser feito para que seus atributos sejam adicionados posteriormente, ou para fazer teste de aplicação
	
	
// Métodos Get e Set

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean sacar(float valor) {

		if (this.saldo < valor) {
			System.out.println("\nSaldo Insuficiente!");
			return false;
		}

		this.saldo = this.saldo - valor;

		return true;
	}

	public void depositar(float valor) {
		this.saldo = this.saldo + valor;
	}

	public void visualizar() {

		String tipo = " ";

		switch (this.tipo) {
		case 1 -> tipo = "Conta Corrente";
		case 2 -> tipo = "Conta Poupança";
		default -> tipo = "Desconhecido";
		}

		System.out.println("\n********************************************");
		System.out.println("Dados da Conta");
		System.out.println("********************************************");
		System.out.printf("Número da conta: %d%n", this.numero);
		System.out.printf("Número da agência: %d%n", this.agencia);
		System.out.printf("Tipo da conta: %s%n", tipo);
		System.out.printf("Titular da conta: %s%n", this.titular);
		System.out.printf("Saldo da conta: %.2f%n", this.saldo);
	}
}
