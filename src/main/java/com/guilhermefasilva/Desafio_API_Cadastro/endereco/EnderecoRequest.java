package com.guilhermefasilva.Desafio_API_Cadastro.endereco;

import javax.validation.constraints.NotBlank;
//dados que serão persistidos no banco

public class EnderecoRequest {


    @NotBlank
    private String logradouro;
    @NotBlank
    private Integer numero;
    @NotBlank
    private String complemento;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;
    @NotBlank
    private Integer cep;


    public EnderecoRequest(@NotBlank String logradouro,@NotBlank Integer numero,@NotBlank String complemento,
                           @NotBlank String bairro, @NotBlank String cidade,@NotBlank String estado,
                           @NotBlank Integer cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public Endereco endereco(){
        return new Endereco(
                this.logradouro,
                this.numero,
                this.complemento,
                this.bairro,
                this.cidade,
                this.estado,
                this.cep
        );
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

    public String getCep() {
        return cep;
    }
}
