package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Cotacao;
import com.example.demo.repository.CotacaoRepository;

@Service
public class CotacaoService {

    private CotacaoRepository cotacaoRepository;

    public CotacaoService(CotacaoRepository cotacaoRepository) {
        this.cotacaoRepository = cotacaoRepository;
    }
    
    @Transactional
    public Cotacao cadastrar(Cotacao cotacao) {        
        return cotacaoRepository.save(cotacao);    	
    }


    


}
