package com.trainibit.usuarios.service.impl;

import com.trainibit.usuarios.entity.Usuario;
import com.trainibit.usuarios.mapper.UsuarioMapper;
import com.trainibit.usuarios.repository.UsuarioRepository; //Ayuda a la consulta de la bases de datos
import com.trainibit.usuarios.request.UsuarioRequest;
import com.trainibit.usuarios.response.UsuarioResponse;
import com.trainibit.usuarios.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@ComponentScan
@Service
public class UsuarioServiceImpl implements UsuarioService {
    //iNYECCIÓN POR CAMPO
    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public List<UsuarioResponse> findAll() {
        return UsuarioMapper.mapListEntitytoListDto(usuarioRepository.findAll());
    }

    @Override
    public Usuario findById(UUID uuid) {
        return usuarioRepository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("Usuario con id " + uuid + " no encontrado"));
    }

    @Override           //tipo de dato  nombre de la variable
        public Usuario save(UsuarioRequest usuarioRequest) {
            Usuario usuario = new Usuario();
            return usuarioRepository.save(usuario);
    }


    @Override
    public Usuario update(Long id, UsuarioRequest usuarioRequest) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario con id " + id + " no encontrado"));
        UsuarioMapper.mapRequestToEntity(usuarioRequest);
        return usuarioRepository.save(usuarioExistente);
    }

    @Override
    public Usuario deleteById(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.borrarByIdActive(id);
        } else {
            throw new EntityNotFoundException("Usuario con id" + id + " no encontrado");
        }
        return null;
    }
}