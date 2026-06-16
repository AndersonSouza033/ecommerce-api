package ecommerce.bd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ecommerce.bd.entity.Cliente;
import ecommerce.bd.repository.ClienteRepository;

@Service
public class ClienteService {
    // Métodos auxilares de validação
    public void validarNome(String nome){ if (nome == null || nome.isBlank()) { throw new IllegalArgumentException("Nome Inválido!");} }

    private final ClienteRepository repository;

    // Construtor
    public ClienteService(ClienteRepository repository){ this.repository = repository; }

    // Cadastrar Cliente POST
    public Cliente salvarCliente(Cliente cliente){ return repository.save(cliente); } 

    // Listar Clientes GET
    public List<Cliente> listarClientes(){ return repository.findAll(); }

    // Deletar Cliente 
    public void deletarCliente(String id){
        if(!repository.existsById(id)){ throw new RuntimeException("Cliente não encontrado!"); } 
        repository.deleteById(id); 
    }
    
    // Atualizar Cliente Put
    public Cliente atualizarCliente(String id, Cliente clienteAtualizado){
        Cliente clienteExistente = repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));

        clienteExistente.setNomeCliente(clienteAtualizado.getNomeCliente());
        clienteExistente.setCpf(clienteAtualizado.getCpf());
        clienteExistente.setTelefone(clienteAtualizado.getTelefone());
        clienteExistente.setEnderecos(clienteAtualizado.getEnderecos());

        return repository.save(clienteExistente);
    }

    // Métodos buscar GET
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

    // Métodos buscar com Filtros avançados NoSQL

    public List<Cliente> buscarPorTelefones(List<String> telefones){
        if(telefones == null || telefones.isEmpty()){ throw new IllegalArgumentException("Lista inválida!"); }

        return repository.findByTelefoneIn(telefones);
    }

    public List<Cliente> buscarEmailDiferente(String email){
        if(email == null || email.isBlank()){ throw new IllegalArgumentException("Email inválido!");}

        return repository.findByEmailNot(email);
    }

    public List<Cliente> buscarNomeOuEmail(String nome,String email){
        return repository.findByNomeClienteContainingIgnoreCaseOrEmailContainingIgnoreCase(nome,email);
    }
}
