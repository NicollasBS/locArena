package br.com.locarena.api.domain.quadra;

import br.com.locarena.api.domain.empresa.Empresa;
import br.com.locarena.api.domain.endereco.DadosEndereco;
import br.com.locarena.api.domain.endereco.Endereco;
import br.com.locarena.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Table(name="quadras")
@Entity(name="Quadra")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Quadra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Esporte esporte;

    private boolean churrasqueira;
    private float aluguel;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    private boolean ativo;

    public Quadra(DadosCadastroQuadra dados, Empresa empresa) {
        this.esporte = dados.esporte();
        this.churrasqueira = dados.churrasqueira();
        this.aluguel = dados.aluguel();
        this.empresa = empresa;
        this.ativo = true;
    }

    public Long getId() {
        return id;
    }

    public Esporte getEsporte() {
        return esporte;
    }

    public boolean isChurrasqueira() {
        return churrasqueira;
    }

    public float getAluguel() {
        return aluguel;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void atualizarQuadra(DadosAtualizacaoQuadra dados){
        this.aluguel = dados.aluguel();
        this.churrasqueira = dados.churrasqueira();

    }

    public  void excluirQuadra(){
        this.ativo = false;
    }
}
