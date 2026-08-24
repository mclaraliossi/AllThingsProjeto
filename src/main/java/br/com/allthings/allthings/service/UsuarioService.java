package br.com.allthings.allthings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.allthings.allthings.entity.Usuario;
import br.com.allthings.allthings.repository.UsuarioRepository;



@Service
public class UsuarioService {
    
  @Autowired
  private UsuarioRepository usuarioRepository;


  public Usuario save(Usuario usuario){
    return usuarioRepository.save(usuario);
  }

  public Usuario findById(Integer id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
        
}


}

