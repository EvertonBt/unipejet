package br.com.unipejet.models;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.transaction.annotation.Transactional;
@Transactional 
@Entity
public class Voos implements Serializable  {

	private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Integer identificador;
	    @NotBlank
	    private String origem;
		@NotBlank
	    private String destino;
	    @NotBlank
	    private String duracao;
	    @NotBlank
	    private String distancia;
	    @Min(value=1)
	    private double preco;
	   @NotNull
	    private Integer capacidade;
	    @NotBlank
	    private String hora_partida;
	    private Integer assentos;
	   @NotBlank
	    private String data;
	    
	    public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
		private Integer status;
	   
		/*Variável que faz o controle de concorrência
	    @Version
	    @Column(columnDefinition = "integer DEFAULT 1")
	    private long version = 1L;
		
	   @Version
	   @Temporal(TemporalType.TIMESTAMP)
	   private Date updateDate;
	    
		*
		*/

	  
		public Integer getAssentos() {
			return assentos;
		}
		public void setAssentos(Integer assentos) {
			this.assentos = assentos;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
	
	    public Integer getIdentificador() {
			return identificador;
		}
		public void setIdentificador(Integer identificador) {
			this.identificador = identificador;
		}
		public String getOrigem() {
			return origem;
		}
		public void setOrigem(String origem) {
			this.origem = origem;
		}
		public String getDestino() {
			return destino;
		}
		public void setDestino(String destino) {
			this.destino = destino;
		}
		public String getDuracao() {
			return duracao;
		}
		public void setDuracao(String duracao) {
			this.duracao = duracao;
		}
		public String getDistancia() {
			return distancia;
		}
		public void setDistancia(String distancia) {
			this.distancia = distancia;
		}
		
		public double getPreco() {
			return preco;
		}
		public void setPreco(double preco) {
			this.preco = preco;
		}
		public Integer getCapacidade() {
			return capacidade;
		}
		public void setCapacidade(Integer capacidade) {
			this.capacidade = capacidade;
		}
		public String getHora_partida() {
			return hora_partida;
		}
		public void setHora_partida(String hora_partida) {
			this.hora_partida = hora_partida;
		}

	
}
