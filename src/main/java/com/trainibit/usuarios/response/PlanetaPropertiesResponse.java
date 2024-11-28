package com.trainibit.usuarios.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PlanetaPropertiesResponse implements Serializable {
    private String diameter;
    private String rotation_period;
    private String orbital_period;
    private String gravity;
    private String population;
    private String climate;
    private String terrain;
    private String surface_water;
    private String created;
    private String edited;
    private String NombreDePlaneta;
    private String url;
}
