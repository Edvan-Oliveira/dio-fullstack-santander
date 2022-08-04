package modelos.abstratas;

import lombok.Getter;
import modelos.Cliente;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIA = 1;

    protected int agencia = AGENCIA_PADRAO;
    protected int numero;

    @Getter
    protected double saldo;

    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        agencia = Conta.AGENCIA_PADRAO;
        numero = SEQUENCIA++;
    }

    @Override
    public double sacar(double valor) {
        saldo -= valor;
        return valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void trasnferir(double valor, Conta destino) {
        destino.depositar(sacar(valor));
    }

    protected void imprimirInformacoesComuns() {
        System.out.printf("Titular: %s%n", cliente.getNome());
        System.out.printf("Agência: %d%n", agencia);
        System.out.printf("Número: %d%n", numero);
        System.out.printf("Saldo: %.2f%n", saldo);
    }
}
