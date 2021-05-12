package com.guilhermefasilva.Desafio_API_Cadastro.usuario;
import com.guilhermefasilva.Desafio_API_Cadastro.endereco.Endereco;
import com.guilhermefasilva.Desafio_API_Cadastro.endereco.EnderecoResponse;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Table(name = "usuario")

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column
    private Integer id;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false, unique = true)
    @CPF
    @NotBlank
    private String cpf;

    @NotNull
    @Column(nullable = false)
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;



    @Deprecated
    public Usuario(@NotBlank String nome, @NotBlank String email,
                   @NotBlank String cpf, @NotNull LocalDate dataNascimento) {
    }

    public Usuario(@NotBlank String nome,@NotBlank String email, @NotBlank String cpf,
                   @NotNull LocalDate dataNascimento, @NotBlank List<Endereco> enderecos) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.enderecos = enderecos;
    }



    public Integer getId() {
        return id;
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

    public List<Endereco> getEnderecos() {
        return enderecos;
    }




    //busca os dados para exibir em uma consulta, dados da classe de response para não acessar tabelas
    //diretamente.
    public UsuarioResponse usuarioResponse(){
        List<EnderecoResponse> enderecoResponse = this.enderecos
                .stream()
                .map(e -> new EnderecoResponse(e.getLogradouro(),
                        e.getNumero(),
                        e.getComplemento(),
                        e.getBairro(),
                        e.getCidade(),
                        e.getEstado(),
                        e.getCep()))
                .collect(Collectors.toList());
        return new UsuarioResponse(this.nome, this.email, this.cpf, this.dataNascimento, enderecoResponse);
    }
}
