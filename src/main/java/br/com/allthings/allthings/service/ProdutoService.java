package br.com.allthings.allthings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.allthings.allthings.entity.Produto;
import br.com.allthings.allthings.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public void deleteById(Integer Id){
        produtoRepository.deleteById(Id);
    }

    public Produto findById(Integer id){
        return produtoRepository.findById(id).orElse(null);
    }

}
