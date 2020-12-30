package br.com.henriquelacerda.springbootjwt.controller;

import br.com.henriquelacerda.springbootjwt.dto.UsuarioDTO;
import br.com.henriquelacerda.springbootjwt.model.Usuario;
import br.com.henriquelacerda.springbootjwt.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listAll() {
        return new ResponseEntity<>(usuarioService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@RequestParam long id) {
        return new ResponseEntity<>(usuarioService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Usuario> save(@RequestBody UsuarioDTO usuario) {
        return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Void> update(@RequestBody UsuarioDTO usuario) {
        usuarioService.update(usuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
