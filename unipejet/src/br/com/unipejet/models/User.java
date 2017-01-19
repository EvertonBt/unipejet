package br.com.unipejet.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.sql.rowset.serial.SerialArray;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails{

	


	
    @Id
   // @Pattern(regexp = "^[\\w\\-]+(\\.[\\w\\-]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$")
    @Email
    private String login;
    @NotBlank
    private String password;
    @NotBlank
    private String name;
    private String role;
    // CPF
    @NotBlank
    private String documento;
  
	private String tipo_documento;
    @NotNull
    @Min(value=18)	
    private Integer idade;
    @Past
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
	@NotBlank
    private String senha_testa;
    
	// Esse atributo representa os pontos em milhas que o usuário possui, ao efetuar uma compra o valor da kilometragem é 
	//subtraida desse valor.
	private double cartao_credito;
	
	
	//Esse atributo é apenas um numero de indentificação do cartão de milha que é gerado automaticamente pelo sistema, não
	//confundir com o atributo acima que se trata do valor em pontos de milha que o usuário possui.
	private Long cartao_milha;
	
	public double getCartao_credito() {
		return cartao_credito;
	}

	public void setCartao_credito(double cartao_credito) {
		this.cartao_credito = cartao_credito;
	}

	public String getSenha_testa() {
		return senha_testa;
	}

	public void setSenha_testa(String senha_testa) {
		this.senha_testa = senha_testa;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Long getCartao_milha() {
		return cartao_milha;
	}

	public void setCartao_milha(Long cartao_milha) {
		this.cartao_milha = cartao_milha;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles = new ArrayList<>();


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
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

	public void adicionaRole(Role role){
		this.roles.add(role);
	}
	
	
}