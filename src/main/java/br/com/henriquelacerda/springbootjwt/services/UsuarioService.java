package br.com.henriquelacerda.springbootjwt.services;

import br.com.henriquelacerda.springbootjwt.dto.UsuarioDTO;
import br.com.henriquelacerda.springbootjwt.model.Usuario;
import br.com.henriquelacerda.springbootjwt.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<Usuario> listAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario não encontrado"));
    }

    public Usuario save(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setId(0);
        usuario.setNome(usuarioDTO.getNome());
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setSenha(usuarioDTO.getSenha());
        return usuarioRepository.save(usuario);
    }

    public void update(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario = findById(usuarioDTO.getId());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setSenha(usuarioDTO.getSenha());
        usuarioRepository.save(usuario);
    }

    public void delete(Long id) {
        usuarioRepository.delete(findById(id));
    }

}
