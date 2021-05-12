package com.guilhermefasilva.Desafio_API_Cadastro.endereco;


import com.guilhermefasilva.Desafio_API_Cadastro.apiCep.CepClient;
import com.guilhermefasilva.Desafio_API_Cadastro.apiCep.CepResponse;
import com.guilhermefasilva.Desafio_API_Cadastro.usuario.Usuario;
import com.guilhermefasilva.Desafio_API_Cadastro.usuario.UsuarioRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios/{id}/enderecos")
public class EnderecoController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private CepClient cepClient;

    public EnderecoController(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public ResponseEntity<Void> salvar(@PathVariable Integer id,
                                  @RequestBody @Valid EnderecoRequest enderecoRequest,
                                  UriComponentsBuilder builder){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if(usuarioOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Usuario usuario = usuarioOptional.get();


        try {
            CepResponse cepResponse = cepClient.consultar(enderecoRequest.getCep());

            System.out.println(cepResponse.getCep());
            System.out.println(cepResponse.getLogradouro());
            System.out.println(cepResponse.getComplemento());
            System.out.println(cepResponse.getBairro());
            System.out.println(cepResponse.getLocalidade());
            System.out.println(cepResponse.getUf());
            System.out.println(cepResponse.getIbge());
            System.out.println(cepResponse.getGia());
            System.out.println(cepResponse.getDdd());
            System.out.println(cepResponse.getSiafi());
        } catch (FeignException.UnprocessableEntity e) {
            return ResponseEntity.unprocessableEntity().build();
        }






        Endereco endereco = enderecoRequest.endereco();
        endereco.setUsuario(usuario);
        URI uri = builder.path("/api/usuarios/{id}/enderecos/{id}")
                .buildAndExpand(usuario.getId(), endereco.getId()).toUri();
        return ResponseEntity.created(uri).build();


    }

}
