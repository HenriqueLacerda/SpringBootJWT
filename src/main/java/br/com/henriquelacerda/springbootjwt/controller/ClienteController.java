package br.com.henriquelacerda.springbootjwt.controller;

import br.com.henriquelacerda.springbootjwt.dto.ClienteDTO;
import br.com.henriquelacerda.springbootjwt.model.Cliente;
import br.com.henriquelacerda.springbootjwt.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listAll() {
        return new ResponseEntity<>(clienteService.listAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@RequestParam long id) {
        return new ResponseEntity<>(clienteService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Cliente> save(@RequestBody ClienteDTO cliente) {
        return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Void> update(@RequestBody ClienteDTO cliente) {
        clienteService.update(cliente);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
