package com.trainibit.usuarios.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PlanetaResponse implements Serializable {
    private String message;
    private PlanetaResultResponse result;

}
