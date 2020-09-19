package com.example.demo.filtros_pesquisa;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Filtros para a consulta da cotação do dólar")
public class CotacaoFilter {


	@NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
	@ApiModelProperty(required = true, example = "01-02-2020", value ="Data da cotação a ser levada em consideração")
    private LocalDate dataCotacao;

	public LocalDate getDataCotacao() {
		return dataCotacao;
	}

	public void setDataCotacao(LocalDate dataCotacao) {
		this.dataCotacao = dataCotacao;
	}
    
    

    
}
