package conta_bancaria.model;

//será uma herança de conta, por isso usaremos a palavra "extend" (extensão/herança)
public class ContaCorrente extends Conta {

	private float limite;

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		// Método Super: somente os atributos que pertencem a superclasse
		this.limite = limite;
		// esse atributo é específico
		// A herança traz todos os atributos de Conta - exceto limite, que é específico
		// de CC
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	@Override
	
	public boolean sacar(float valor) {

		if (this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\nSaldo Insuficiente!");
			return false;
		}

		this.setSaldo(this.getSaldo () - valor);
	
		return true;
	}
	
	@Override //anotação ou indicador para sobrescrever na subclasse um método que já existe na superclasse
	//Sobrescrever um método serve para 
	public void visualizar() {
		super.visualizar();
		System.out.printf("Limite da Conta: R$ %.2f%n", this.limite);
	
	
	
	
//ContaCorrente é uma Subclasse da Classe Conta
	// será uma herança de conta
	 // esse é o único atributo específico de conta corrente
//java não aceita herança múltipla, ou seja, só se herda uma única classe 	

	}
}
