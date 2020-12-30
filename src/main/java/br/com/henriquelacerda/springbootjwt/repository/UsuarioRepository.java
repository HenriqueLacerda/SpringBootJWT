package br.com.henriquelacerda.springbootjwt.repository;

import br.com.henriquelacerda.springbootjwt.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
