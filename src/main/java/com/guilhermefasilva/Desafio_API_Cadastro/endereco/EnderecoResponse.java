package com.guilhermefasilva.Desafio_API_Cadastro.endereco;

//acesso aos dados do banco de dados, somente os dados especificos
public class EnderecoResponse {

            private String logradouro;
            private Integer numero;
            private String complemento;
            private String bairro;
            private String cidade;
            private String estado;
            private Integer cep;

    public EnderecoResponse(String logradouro, Integer numero, String complemento,
                            String bairro, String cidade, String estado, Integer cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
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
