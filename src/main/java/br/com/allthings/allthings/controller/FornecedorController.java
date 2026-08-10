package br.com.allthings.allthings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.allthings.allthings.entity.Fornecedor;
import br.com.allthings.allthings.service.FornecedorService;


@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {
    
    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Fornecedor fornecedor){
        fornecedorService.save(fornecedor);
        return "redirect:/fornecedores/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        List<Fornecedor> fornecedores = fornecedorService.findAll();
        model.addAttribute("fornecedores", fornecedores);
        return "fornecedor/listaFornecedor";
    }

    @GetMapping("/criar")
    public String criarForm(Model model){
        model.addAttribute("fornecedores", new Fornecedor());
        return "fornecedor/formularioFornecedor";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id){
        fornecedorService.deleteById(id);
        return "redirect:/fornecedores/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model){
        Fornecedor fornecedor = fornecedorService.findById(id);
        model.addAttribute("fornecedor", fornecedor);
        return "fornecedor/formularioFornecedor";
    }

}
