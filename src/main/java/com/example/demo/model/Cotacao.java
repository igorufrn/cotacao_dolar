package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.example.demo.arquitetura.PersistDB;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Cotacao implements PersistDB {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cotacao")
    private long id;    

    @NotNull    
    @Column(name = "cotacao_compra")
    @ApiModelProperty(value = "Cotação de compra", required = true)
    private Double cotacaoCompra;
    
    @NotNull    
    @Column(name = "cotacao_venda")
    @ApiModelProperty(value = "Cotação de venda", required = true)
    private Double cotacaoVenda;
    
    @NotNull
    @Column(name = "dt_requisicao")
    private LocalDateTime dataRequisicao;
    
    @NotNull
    @Column(name = "dt_cotacao")
    private LocalDateTime dataCotacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getCotacaoCompra() {
		return cotacaoCompra;
	}

	public void setCotacaoCompra(Double cotacaoCompra) {
		this.cotacaoCompra = cotacaoCompra;
	}

	public Double getCotacaoVenda() {
		return cotacaoVenda;
	}

	public void setCotacaoVenda(Double cotacaoVenda) {
		this.cotacaoVenda = cotacaoVenda;
	}

	public LocalDateTime getDataRequisicao() {
		return dataRequisicao;
	}

	public void setDataRequisicao(LocalDateTime dataRequisicao) {
		this.dataRequisicao = dataRequisicao;
	}

	public LocalDateTime getDataCotacao() {
		return dataCotacao;
	}

	public void setDataCotacao(LocalDateTime dataCotacao) {
		this.dataCotacao = dataCotacao;
	}	
    
}
