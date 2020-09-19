package com.example.demo.resource;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.filtros_pesquisa.CotacaoFilter;
import com.example.demo.model.Cotacao;
import com.example.demo.model.CotacaoDTO;
import com.example.demo.model.CotacoesDTO;
import com.example.demo.repository.CotacaoRepository;
import com.example.demo.service.CotacaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="CotacaoResource", description = "Endpoints para buscar informações relacionadas a cotação do dolar" )
@RestController
@RequestMapping("/cotacoes")
public class CotacaoResource {

    private CotacaoRepository cotacaoRepository;
    private ApplicationEventPublisher publisher;
    private CotacaoService cotacaoService;

    public CotacaoResource(CotacaoRepository cotacaoRepository, CotacaoService cotacaoService, ApplicationEventPublisher publisher) {
        this.cotacaoRepository = cotacaoRepository;
        this.cotacaoService = cotacaoService;
        this.publisher = publisher;
    }
    
    @GetMapping("/data")
    @ApiOperation(value = "Recupera a cotação atual do dólar e armazena no banco de dados para futuras análises", notes = "Recupera a cotação atual do dólar e armazena no banco de dados para futuras análises")
    public CotacoesDTO getCotacao(@Valid CotacaoFilter filter) {   	    	
    	DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    	String templateUri = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)?@dataCotacao='DATA_PARAM'&$top=1&$format=json&$select=cotacaoCompra,cotacaoVenda,dataHoraCotacao";
    	templateUri = templateUri.replace("DATA_PARAM", filter.getDataCotacao().format(formatters));    	
    	RestTemplate restTemplate = new RestTemplate();    	 
        CotacoesDTO result = restTemplate.getForObject(templateUri, CotacoesDTO.class);        
        CotacaoDTO dto = result.getValue().get(0);        
        Cotacao cotacao = new Cotacao();
        cotacao.setDataRequisicao(LocalDateTime.now());
        cotacao.setDataCotacao(dto.getDataHoraCotacao());
        cotacao.setCotacaoVenda(dto.getCotacaoVenda());
        cotacao.setCotacaoCompra(dto.getCotacaoCompra());        
        cotacaoService.cadastrar(cotacao);        
    	return result;
    }


    
    
    


    

    

    
    
    
    

    


    

    


}
