package br.com.henriquelacerda.springbootjwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String login;
    private String senha;


}
