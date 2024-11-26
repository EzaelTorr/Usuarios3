package com.trainibit.usuarios.mapper;

import com.trainibit.usuarios.entity.Usuario;
import com.trainibit.usuarios.request.UsuarioRequest;
import com.trainibit.usuarios.response.UsuarioResponse;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class UsuarioMapper {


    public static UsuarioResponse mapEntityToDto(Usuario usuario) {

        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setUuid(usuario.getUuid());
        usuarioResponse.setName(usuario.getName());
        usuarioResponse.setLastName(usuario.getLastName());
        usuarioResponse.setBirthDate(usuario.getBirthDate());
        usuarioResponse.setEmail(usuario.getEmail());
        usuarioResponse.setPassword(usuario.getPassword());
        usuarioResponse.setUuid(usuario.getUuid());
        usuarioResponse.setEdad(Period.between(usuario.getBirthDate(), LocalDate.now()).getYears());
        return usuarioResponse;
    }
    public static List<UsuarioResponse> mapListEntitytoListDto(List<Usuario> usuarios) {
        List<UsuarioResponse> usuarioResponses = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuarioResponses.add(mapEntityToDto(usuario));
        }
        return usuarioResponses;

    }
    public static UsuarioRequest mapRequestToEntity(UsuarioRequest usuarioRequest) {

        Usuario  usuario = new Usuario();
        usuario.setName(usuario.getName());
        usuario.setLastName(usuario.getLastName());
        usuario.setBirthDate(usuario.getBirthDate());
        usuario.setEmail(usuario.getEmail());
        usuario.setPassword(usuario.getPassword());
        usuario.setUuid(UUID.randomUUID());
        return usuarioRequest;
    }
}
