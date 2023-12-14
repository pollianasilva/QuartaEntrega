package com.bflorturismo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ViagemDTO {

	private String destinoViagem;
    private BigDecimal valorPassagem; 
    private BigDecimal valorPromocional; 
    private boolean promocao;
    private LocalDate disponibilidade;
    private LocalDate ida;
    private LocalDate volta;    
    private BigDecimal valorTotal;
    
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
    
    
}
