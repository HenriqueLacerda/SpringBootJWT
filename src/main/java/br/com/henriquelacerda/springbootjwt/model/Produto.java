package br.com.henriquelacerda.springbootjwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "produto")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @Column(name = "preco_custo")
    private Double precoCusto;
    @Column(name = "preco_venda")
    private Double precoVenda;

}
