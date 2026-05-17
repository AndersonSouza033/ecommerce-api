package ecommerce.bd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ecommerce.bd.entity.Cliente;
import ecommerce.bd.repository.ClienteRepository;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository){ this.repository = repository; }

    public Cliente salvarCliente(Cliente cliente){ return repository.save(cliente); } 

    public List<Cliente> listarClientes(){ return repository.findAll(); }

    public void deletarCliente(String id){
        if(!repository.existsById(id)){ throw new RuntimeException("Cliente não encontrado!"); } 
        repository.deleteById(id); 
    }
    
    public Cliente atualizarCliente(String id, Cliente clienteAtualizado){
        Cliente clienteExistente = repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));

        clienteExistente.setNomeCliente(clienteAtualizado.getNomeCliente());
        clienteExistente.setCpf(clienteAtualizado.getCpf());
        clienteExistente.setTelefone(clienteAtualizado.getTelefone());
        clienteExistente.setEnderecos(clienteAtualizado.getEnderecos());

        return repository.save(clienteExistente);
    }

    // Métodos auxilares de validação
    public void validarNome(String nome){ if (nome == null || nome.isBlank()) { throw new IllegalArgumentException("Nome Inválido!");} }

    // Métodos buscar
    public Cliente buscarPorId(String id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
    }

    public Cliente buscarPorCpf(String cpf){
        return repository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
    }

    public Cliente buscarPorTelefone(String telefone){
        return repository.findByTelefone(telefone).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
    }

    public Cliente buscarPorEmail(String email){
        return repository.findByEmail(email).orElseThrow(() -> new RuntimeException("Nenhum cliente encontrado!"));
    }

    public List<Cliente> buscarPorNome(String nomeCliente){
        validarNome(nomeCliente);
        
        List<Cliente> clientes = repository.findByNomeClienteIgnoreCaseContaining(nomeCliente);

        if (clientes.isEmpty()) { throw new RuntimeException("Nenhum cliente encontrado!"); }

        return clientes;
    }
}
