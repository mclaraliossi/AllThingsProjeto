package br.com.allthings.allthings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.allthings.allthings.entity.Produto;
import br.com.allthings.allthings.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

   @Autowired
    private ProdutoService produtoService;

    //Método para salvar um produto
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Produto produto){
        produtoService.save(produto);
        return "redirect:/produtos/listar";
    }
}
