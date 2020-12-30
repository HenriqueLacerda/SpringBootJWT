package br.com.henriquelacerda.springbootjwt.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

    private long id;
    private String nome;
    private String login;
    private String senha;

}
