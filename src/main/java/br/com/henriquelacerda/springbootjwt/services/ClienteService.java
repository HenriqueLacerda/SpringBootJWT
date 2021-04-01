package br.com.henriquelacerda.springbootjwt.services;

import br.com.henriquelacerda.springbootjwt.dto.ClienteDTO;
import br.com.henriquelacerda.springbootjwt.model.Cliente;
import br.com.henriquelacerda.springbootjwt.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> listAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não encontrado"));
    }

    public Cliente save(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(0);
        cliente.setNome(clienteDTO.getNome());
        cliente.setEndereco(clienteDTO.getEndereco());
        cliente.setNumero(clienteDTO.getNumero());
        cliente.setBairro(clienteDTO.getBairro());
        cliente.setCidade(clienteDTO.getCidade());
        cliente.setCep(clienteDTO.getCep());
        cliente.setContato(clienteDTO.getContato());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setObservacao(clienteDTO.getObservacao());
        return clienteRepository.save(cliente);
    }

    public void update(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente = findById(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
        cliente.setEndereco(clienteDTO.getEndereco());
        cliente.setNumero(clienteDTO.getNumero());
        cliente.setBairro(clienteDTO.getBairro());
        cliente.setCidade(clienteDTO.getCidade());
        cliente.setCep(clienteDTO.getCep());
        cliente.setContato(clienteDTO.getContato());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setObservacao(clienteDTO.getObservacao());
        clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        clienteRepository.delete(findById(id));
    }

}
