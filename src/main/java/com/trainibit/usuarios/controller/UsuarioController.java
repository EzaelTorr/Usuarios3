package com.trainibit.usuarios.controller;
//borrar y modificar
import com.trainibit.usuarios.entity.Usuario;
import com.trainibit.usuarios.request.UsuarioRequest;
import com.trainibit.usuarios.response.UsuarioResponse;
import com.trainibit.usuarios.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

@ComponentScan
@Validated
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> getUsuario() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("{id}") //Permite realizar la busqueda por ID
    public Usuario obtenerUsuarioPorId(@PathVariable UUID id) {
        return usuarioService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest) {
       Usuario nuevoUsuario = usuarioService.save(usuarioRequest);
       return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable long id) {
        try {
            usuarioService.deleteById(id);
            return ResponseEntity.noContent().build();//204, eliminado correctamente
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //404 no enocntrado
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody UsuarioRequest usuarioRequest) {
        try {
            Usuario usuarioActualizado = usuarioService.update(id,usuarioRequest);
            return ResponseEntity.ok(usuarioActualizado);

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}