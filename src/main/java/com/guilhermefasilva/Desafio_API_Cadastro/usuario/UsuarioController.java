package com.guilhermefasilva.Desafio_API_Cadastro.usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<String> salvar(@RequestBody @Valid UsuarioRequest request,
                                         UriComponentsBuilder builder) {
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            //throw new ApiErroException(HttpStatus.BAD_REQUEST, "Email já cadastrado");
            return ResponseEntity.badRequest().body("Email já cadastrado");
        }
        if (usuarioRepository.existsByCpf(request.getCpf())) {
            //throw new ApiErroException(HttpStatus.BAD_REQUEST, "CPF já cadastrado");
            return ResponseEntity.badRequest().body("CPF já cadastrado");
        }
        Usuario usuario = request.usuario();
        usuarioRepository.save(usuario);

        URI uri = builder.path("api/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}/enderecos")
    public ResponseEntity<UsuarioResponse> listar(@PathVariable Long id) {
        Optional<Usuario> usuarioOptinal = usuarioRepository.findById(Math.toIntExact(id));
        if (usuarioOptinal.isEmpty()) {
            //throw new ApiErroException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
            return ResponseEntity.notFound().build();
        }
        Usuario usuario = usuarioOptinal.get();
        UsuarioResponse usuarioResponse = usuario.usuarioResponse();

        return ResponseEntity.ok(usuarioResponse);
    }
}

