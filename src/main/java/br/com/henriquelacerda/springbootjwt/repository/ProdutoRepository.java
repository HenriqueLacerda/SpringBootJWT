package br.com.henriquelacerda.springbootjwt.repository;

import br.com.henriquelacerda.springbootjwt.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
