package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CotacaoRepositoryImpl implements  CotacaoRepositoryQuery {

    @PersistenceContext
    EntityManager em;
    
    //Aqui implementamos nossos próprios métodos

    
}
