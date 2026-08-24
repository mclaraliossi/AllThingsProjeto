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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.allthings.allthings.entity.Cliente;
import br.com.allthings.allthings.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Cliente cliente, 
            @RequestParam("foto") MultipartFile foto){
        try{
            if(!foto.isEmpty()){
                cliente.setFotoCliente(foto.getBytes());
                cliente.setTipoFotoCliente(foto.getContentType());
            }
            clienteService.save(cliente);
        }catch (Exception e){
            e.printStackTrace();
        }
        clienteService.save(cliente);
        return "redirect:/clientes/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "cliente/listaCliente";
    }

    @GetMapping("/criar")
    public String criarForm(Model model){
        model.addAttribute("cliente", new Cliente());
        return "cliente/formularioCliente";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id){
        clienteService.deleteById(id);
        return "redirect:/clientes/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model){
        Cliente cliente = clienteService.findById(id);
        model.addAttribute("cliente", cliente);
        return "cliente/formularioCliente";
    }
}
