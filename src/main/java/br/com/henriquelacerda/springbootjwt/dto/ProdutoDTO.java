package br.com.henriquelacerda.springbootjwt.dto;

import lombok.Data;

@Data
public class ProdutoDTO {

    private long id;
    private String nome;
    private Double precoCusto;
    private Double precoVenda;

}
