package br.com.unipejet.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

// Essa classe é responsável por registrar todas as compras após a sua finalização
@Entity
public class Registro{

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int numero_registro;
	@NotBlank
	private String responsavel;
    @Min(value=1)
	private Integer numero_passagens;
    @NotNull
    private double total;
	@NotNull
	private double total_milhas;
	private String data_hora;
	
	
	
	public String getData_hora() {
		return data_hora;
	}

	public void setData_hora(String data_hora) {
		this.data_hora = data_hora;
	}

	public double getTotal_milhas() {
		return total_milhas;
	}

	public void setTotal_milhas(double total_milhas) {
		this.total_milhas = total_milhas;
	}

	public int getNumero_registro() {
		return numero_registro;
	}

	public void setNumero_registro(int numero_registro) {
		this.numero_registro = numero_registro;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Integer getNumero_passagens() {
		return numero_passagens;
	}

	public void setNumero_passagens(Integer numero_passagens) {
		this.numero_passagens = numero_passagens;
	}




	
}
