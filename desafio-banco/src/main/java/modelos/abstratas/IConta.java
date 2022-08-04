package modelos.abstratas;

public interface IConta {

    double sacar(double valor);

    void depositar(double valor);

    void trasnferir(double valor, Conta destino);

    void imprimirExtrato();
}
