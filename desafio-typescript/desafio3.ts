const botaoAtualizar = document.getElementById('atualizar-saldo') as HTMLButtonElement
const botaoLimpar = document.getElementById('limpar-saldo') as HTMLButtonElement
const soma = document.getElementById('soma') as HTMLInputElement
const campoSaldo = document.getElementById('campo-saldo') as HTMLSpanElement

let valorExibido = 0

atualizarExibicaoSaldo()

function somarAoSaldo(soma: number) {
    valorExibido += soma
    atualizarExibicaoSaldo()
}

function limparSaldo() {
    valorExibido = 0;
    atualizarExibicaoSaldo()
}

function limparInput() {
    soma.value = ''
}

botaoAtualizar.addEventListener('click', function () {
    somarAoSaldo(Number(soma.value))
    limparInput()
})

botaoLimpar.addEventListener('click', function () {
    limparSaldo()
    limparInput()
})

function atualizarExibicaoSaldo() {
    campoSaldo.innerHTML = valorExibido.toString()
}

/**
    <h4>Valor a ser adicionado: <input id="soma"> </h4>
    <button id="atualizar-saldo">Atualizar saldo</button>
    <button id="limpar-saldo">Limpar seu saldo</button>
    <h1>"Seu saldo é: " <span id="campo-saldo"></span></h1>
 */