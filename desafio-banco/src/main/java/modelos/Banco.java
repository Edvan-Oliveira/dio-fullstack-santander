package modelos;

import lombok.Getter;
import lombok.Setter;
import modelos.abstratas.Conta;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    @Getter @Setter
    private String nome;
    private final List<Conta> contas = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void impirmirExtratosDasContas() {
        System.out.printf("============== %s ==============%n", nome);
        contas.forEach(Conta::imprimirExtrato);
        System.out.println("===============================");
    }
}
