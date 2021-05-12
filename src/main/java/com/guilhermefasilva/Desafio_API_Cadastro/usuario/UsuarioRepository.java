package com.guilhermefasilva.Desafio_API_Cadastro.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
}
