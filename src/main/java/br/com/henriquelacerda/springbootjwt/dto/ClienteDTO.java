package br.com.henriquelacerda.springbootjwt.dto;

import lombok.Data;

@Data
public class ClienteDTO {

    private long id;
    private String nome;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String contato;
    private String email;
    private String telefone;
    private String observacao;

}
