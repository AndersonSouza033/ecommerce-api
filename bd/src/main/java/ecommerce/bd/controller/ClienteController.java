package ecommerce.bd.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.bd.entity.Cliente;
import ecommerce.bd.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService service;

    // Construtor
    public ClienteController(ClienteService service){ this.service = service; }

    // CRUD Básico
    @PostMapping
    public Cliente salvarCliente(@RequestBody Cliente cliente){ return service.salvarCliente(cliente); }

    @GetMapping
    public List<Cliente> listarClientes(){ return service.listarClientes(); }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable String id ){ return service.buscarPorId(id); }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable String id,@RequestBody Cliente cliente){ return service.atualizarCliente(id,cliente); }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable String id){ service.deletarCliente(id); }

    // Consultar Básicas com Find
    @GetMapping("/cpf/{cpf}")
    public Cliente buscarPorCpf(@PathVariable String cpf){ return service.buscarPorCpf(cpf); }

    @GetMapping("/nome") 
    public List<Cliente> buscarPorNome(@RequestParam String nome){ return service.buscarPorNome(nome); }

    @GetMapping("/telefone")
    public Cliente buscarPorTelefone(@RequestParam String telefone){ return service.buscarPorTelefone(telefone); }

    @GetMapping("/email")
    public Cliente buscarPorEmail(@RequestParam String email){ return service.buscarPorEmail(email); }

    // Consultas Avançadas GET
    @GetMapping("/telefones")
    public List<Cliente> buscarPorTelefones(@RequestParam List<String> telefones){ return service.buscarPorTelefones(telefones); }

    @GetMapping("/email/ne")
    public List<Cliente> buscarEmailDiferente(@RequestParam String email){ return service.buscarEmailDiferente(email); }

    @GetMapping("/or")
    public List<Cliente> buscarNomeOuEmail(@RequestParam String nome, @RequestParam String email){
        return service.buscarNomeOuEmail(nome,email);
    }
}