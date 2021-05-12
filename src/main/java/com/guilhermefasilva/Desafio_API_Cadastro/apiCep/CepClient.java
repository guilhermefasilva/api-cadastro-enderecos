package com.guilhermefasilva.Desafio_API_Cadastro.apiCep;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cep", url = "https://viacep.com.br/ws")
    public interface CepClient {

        @GetMapping("/{cep}/json")
        CepResponse consultar(@PathVariable String cep);
    }

