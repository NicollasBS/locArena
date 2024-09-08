package br.com.locarena.api.domain.login;

import com.auth0.jwt.algorithms.Algorithm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Base64;
import java.util.Collection;
import java.util.List;

@Table(name = "login")
@Entity(name = "Login")
@Getter
@NoArgsConstructor      // CONSTRUCTOR sem args
@AllArgsConstructor     // CONSTRUCTOR com args
@EqualsAndHashCode(of = "id")
public class Login implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private Long idEstrangeiro;
    public Long getId() {
        return id;
    }



    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Long getIdEstrangeiro() {
        return idEstrangeiro;
    }

    public void setIdEstrangeiro(Long idEstrangeiro) {
        this.idEstrangeiro = idEstrangeiro;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

//    CONSTRUTOR
    public Login(DadosCriacaoLogin dados){
        this.login = dados.login();
        this.senha = hash(dados.senha());
        this.tipo = dados.tipo();
    }

    public String hash(String senha){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(senha);
    }
}
