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

//codigo para mostrar el usuario como usuariorespnse
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
    //còdigo para obtener el còdigo de usuario a usuarioRequest
    public static Usuario mapRequestToEntity(UsuarioRequest usuarioRequest) {
        // Crear una nueva instancia de Usuario
        Usuario usuario = new Usuario();

        // Mapear los datos de UsuarioRequest a Usuario
        usuario.setName(usuarioRequest.getName());
        usuario.setLastName(usuarioRequest.getLastName());
        usuario.setBirthDate(usuarioRequest.getBirthDate());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setPassword(usuarioRequest.getPassword());
        usuario.setUuid(UUID.randomUUID()); // Asignar un UUID aleatorio
       // usuario.setNombrePlaneta(usuarioRequest.getNombreDePlaneta()); // Usar el nombre de planeta del request

        // Retornar el usuario mapeado
        return usuario;
    }

}
