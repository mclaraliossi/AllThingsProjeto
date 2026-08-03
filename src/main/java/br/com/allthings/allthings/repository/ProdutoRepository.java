package br.com.allthings.allthings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.allthings.allthings.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    
}
