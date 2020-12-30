package br.com.henriquelacerda.springbootjwt.services;

import br.com.henriquelacerda.springbootjwt.dto.ProdutoDTO;
import br.com.henriquelacerda.springbootjwt.model.Produto;
import br.com.henriquelacerda.springbootjwt.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public List<Produto> listAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(long id){
        return produtoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto não encontrado"));
    }

    public Produto save(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setId(0);
        produto.setNome(produtoDTO.getNome());
        produto.setPrecoCusto(produtoDTO.getPrecoCusto());
        produto.setPrecoVenda(produtoDTO.getPrecoVenda());
        return produtoRepository.save(produto);
    }

    public void update(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto = findById(produtoDTO.getId());
        produto.setNome(produtoDTO.getNome());
        produto.setPrecoCusto(produtoDTO.getPrecoCusto());
        produto.setPrecoVenda(produtoDTO.getPrecoVenda());
        produtoRepository.save(produto);
    }

    public void delete(Long id) {
        produtoRepository.delete(findById(id));
    }

}
