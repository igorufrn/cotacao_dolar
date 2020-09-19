package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Cotacao;

public interface CotacaoRepository extends JpaRepository<Cotacao,Long>, CotacaoRepositoryQuery {
	
	//Aqui se coloca métodos que são implementados pelo SpringDataJPA   

}
