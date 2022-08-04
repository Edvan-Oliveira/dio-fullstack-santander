import modelos.Banco;
import modelos.Cliente;
import modelos.ContaCorrente;
import modelos.ContaPoupanca;
import modelos.abstratas.Conta;

public class Main {
    public static void main(String[] args) {
        Cliente maria = new Cliente("Maria");
        Cliente joao = new Cliente("João");

        Conta contaCorrente = new ContaCorrente(maria);
        Conta contaPoupanca = new ContaPoupanca(joao);

        contaCorrente.depositar(12.32);
        contaCorrente.trasnferir(6.0, contaPoupanca);
        contaPoupanca.sacar(1.0);

        Banco santander = new Banco("Santander");
        santander.adicionarConta(contaCorrente);
        santander.adicionarConta(contaPoupanca);
        santander.impirmirExtratosDasContas();
    }
}
