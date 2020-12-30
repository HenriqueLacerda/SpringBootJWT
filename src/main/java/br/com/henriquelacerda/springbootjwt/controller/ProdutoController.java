package br.com.henriquelacerda.springbootjwt.controller;

import br.com.henriquelacerda.springbootjwt.dto.ProdutoDTO;
import br.com.henriquelacerda.springbootjwt.model.Produto;
import br.com.henriquelacerda.springbootjwt.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> listAll() {
        return new ResponseEntity<>(produtoService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@RequestParam long id) {
        return new ResponseEntity<>(produtoService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Produto> save(@RequestBody ProdutoDTO produto) {
        return new ResponseEntity<>(produtoService.save(produto), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Void> update(@RequestBody ProdutoDTO produto) {
        produtoService.update(produto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        produtoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
