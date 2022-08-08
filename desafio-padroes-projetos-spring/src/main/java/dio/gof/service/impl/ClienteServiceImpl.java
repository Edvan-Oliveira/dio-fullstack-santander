package dio.gof.service.impl;

import dio.gof.model.Cliente;
import dio.gof.model.Endereco;
import dio.gof.repository.ClienteRepository;
import dio.gof.repository.EnderecoRepository;
import dio.gof.service.ClienteService;
import dio.gof.service.ViaCepService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteCep(cliente);
    }

    @Override
    public void atualizar(Integer id, Cliente cliente) {
        Cliente clienteBd = buscarPorId(id);
        if (clienteBd != null) {
            salvarClienteCep(cliente);
        }
    }

    @Override
    public void deletar(Integer id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return enderecoRepository.save(novoEndereco);
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
