package br.com.allthings.allthings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.allthings.allthings.entity.Cliente;
import br.com.allthings.allthings.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente){
        return clienteRepository.save(null);
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public void deleteById(Integer id){
        clienteRepository.deleteById(null);
    }

    public Cliente findById(Integer id){
        return clienteRepository.findById(id).orElse(null);
    }


}
