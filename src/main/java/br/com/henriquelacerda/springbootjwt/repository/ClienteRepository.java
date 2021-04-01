package br.com.henriquelacerda.springbootjwt.repository;

import br.com.henriquelacerda.springbootjwt.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}


