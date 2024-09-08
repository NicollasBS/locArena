package br.com.locarena.api.domain.empresa;

import br.com.locarena.api.domain.endereco.Endereco;
import br.com.locarena.api.domain.quadra.Quadra;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;


@Table(name = "empresas")
@Entity(name = "Empresa")
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Embedded
    private Endereco endereco;
    private String email;
    private String telefone;
    private LocalTime horarioInicio;
    private LocalTime horarioTermino;
    @Enumerated(EnumType.STRING)
    private DayOfWeek diaInicio;
    @Enumerated(EnumType.STRING)
    private DayOfWeek diaTermino;
    private boolean ativo;
    @OneToMany(mappedBy = "empresa" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Quadra> quadras;

//    CONSTRUCTOR
    public Empresa(DadosCadastroEmpresa dados) {
        this.nome = dados.nome();
        this.endereco = new Endereco(dados.endereco());
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.horarioInicio = dados.horarioInicio();
        this.horarioTermino = dados.horarioTermino();
        this.diaInicio = dados.diaInicio();
        this.diaTermino = dados.diaTermino();
        this.ativo = true;
    }

    //    GETTERs
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public LocalTime getHorarioTermino() {
        return horarioTermino;
    }

    public DayOfWeek getDiaInicio() {
        return diaInicio;
    }

    public DayOfWeek getDiaTermino() {
        return diaTermino;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public List<Quadra> getQuadras() {
        return quadras;
    }

    public void atualizar(DadosAtualizacaoEmpresa dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.endereco() != null){
            this.endereco = new Endereco(dados.endereco());
        }
        if (dados.email() != null){
            this.email = dados.email();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if (dados.horarioInicio() != null){
            this.horarioInicio = dados.horarioInicio();
        }
        if (dados.horarioTermino() != null){
            this.horarioTermino = dados.horarioTermino();
        }
        if (dados.diaInicio() != null){
            this.diaInicio = dados.diaInicio();
        }
        if (dados.diaTermino() != null){
            this.diaTermino = dados.diaTermino();
        }
    }

    public void deletar() {
        this.ativo = false;
    }
}
