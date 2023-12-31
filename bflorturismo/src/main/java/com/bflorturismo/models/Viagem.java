package com.bflorturismo.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;



@Entity
public class Viagem {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
@Column(name="destino_viagem", length = 50)
    private String destinoViagem;

  @Column(name="valor_passagem")
    private BigDecimal valorPassagem;
  @Column(name="valor_promocional")
    private BigDecimal valorPromocional; 
  private boolean promocao;
    private LocalDate disponibilidade;
    private LocalDate ida;
    private LocalDate volta;
    @Column(name="valor_total")
    private BigDecimal valorTotal;

    
             
@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name="viagem_usuario",
joinColumns=@JoinColumn(name="viagem_id"),
inverseJoinColumns=@JoinColumn(name="usuario_id"))
private Set<Usuario> usuarios = new HashSet<>();


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDestinoViagem() {
		return destinoViagem;
	}



	public void setDestinoViagem(String destinoViagem) {
		this.destinoViagem = destinoViagem;
	}



	public BigDecimal getValorPassagem() {
		return valorPassagem;
	}



	public void setValorPassagem(BigDecimal valorPassagem) {
		this.valorPassagem = valorPassagem;
	}



	public BigDecimal getValorPromocional() {
		return valorPromocional;
	}



	public void setValorPromocional(BigDecimal valorPromocional) {
		this.valorPromocional = valorPromocional;
	}



	public boolean isPromocao() {
		return promocao;
	}



	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}



	public LocalDate getDisponibilidade() {
		return disponibilidade;
	}



	public void setDisponibilidade(LocalDate disponibilidade) {
		this.disponibilidade = disponibilidade;
	}



	public LocalDate getIda() {
		return ida;
	}



	public void setIda(LocalDate ida) {
		this.ida = ida;
	}



	public LocalDate getVolta() {
		return volta;
	}



	public void setVolta(LocalDate volta) {
		this.volta = volta;
	}



	public BigDecimal getValorTotal() {
		return valorTotal;
	}



	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}



	public Set<Usuario> getUsuarios() {
		return usuarios;
	}



	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	

	

}
