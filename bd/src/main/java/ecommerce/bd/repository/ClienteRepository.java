package ecommerce.bd.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import ecommerce.bd.entity.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String>{
    Optional<Cliente> findByCpf(String cpf);
    Optional<Cliente> findByTelefone(String telefone);
    Optional<Cliente> findByEmail(String email);
    List<Cliente> findByNomeClienteIgnoreCaseContaining(String nome);
    List<Cliente> findByTelefoneIn(List<String> telefones);
    List<Cliente> findByEmailNot(String email);
    List<Cliente> findByNomeClienteContainingIgnoreCaseOrEmailContainingIgnoreCase(String nome,String email);
}
