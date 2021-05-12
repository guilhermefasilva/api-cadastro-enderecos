package com.guilhermefasilva.Desafio_API_Cadastro.usuario;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


public class UsuarioRequest {

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @CPF
    private String cpf;
    @NotNull
    private LocalDate dataNascimento;


    public UsuarioRequest(@NotBlank String nome, @NotBlank String email,
                          @NotBlank @CPF String cpf, @NotNull LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }
        public Usuario usuario(){
        return new Usuario(this.nome, this.email, this.cpf, this.dataNascimento);
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
}
