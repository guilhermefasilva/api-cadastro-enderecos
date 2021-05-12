package com.guilhermefasilva.Desafio_API_Cadastro.endereco;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.guilhermefasilva.Desafio_API_Cadastro.usuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    @NotBlank
    private String logradouro;

    @Column
    @NotBlank
    private Integer numero;

    @Column
    @NotBlank
    private String complemento;

    @Column
    @NotBlank
    private String bairro;

    @Column
    @NotBlank
    private String cidade;

    @Column
    @NotBlank
    private String estado;

    @Column
    @NotBlank
    private Integer cep;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

    @Deprecated
    public Endereco() {
    }

    public Endereco(@NotBlank  String logradouro, @NotBlank  Integer numero,
                    @NotBlank String complemento, @NotBlank String bairro,
                    @NotBlank String cidade, @NotBlank String estado, @NotBlank Integer cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public Integer getCep() {
        return cep;
    }
}
