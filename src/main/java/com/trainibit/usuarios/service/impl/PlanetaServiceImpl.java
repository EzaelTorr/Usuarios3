package com.trainibit.usuarios.service.impl;

import com.trainibit.usuarios.response.PlanetaResponse;
import com.trainibit.usuarios.response.SwapiResponse;
import com.trainibit.usuarios.service.PlanetaService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class PlanetaServiceImpl implements PlanetaService {
    private RestTemplate restTemplate;


    @Override
    public PlanetaResponse getPlanetById(Integer id) {
        String url = "https://www.swapi.tech/api/planets/" + id;
        return restTemplate.getForObject(url, PlanetaResponse.class);
    }
}