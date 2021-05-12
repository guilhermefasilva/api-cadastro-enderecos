package com.guilhermefasilva.Desafio_API_Cadastro.usuario;

import com.guilhermefasilva.Desafio_API_Cadastro.endereco.EnderecoResponse;

import java.time.LocalDate;
import java.util.List;

public class UsuarioResponse {

    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;

    private List<EnderecoResponse> enderecos;


    public UsuarioResponse(String nome, String email, String cpf,
                           LocalDate dataNascimento, List<EnderecoResponse> enderecos) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.enderecos = enderecos;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public List<EnderecoResponse> getEnderecos() {
        return enderecos;
    }
}
