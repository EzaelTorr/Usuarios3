package com.trainibit.usuarios.response;

import lombok.Data;

@Data

public class   ApiErrorresponse {

    private String message;
    private Integer status;

    public ApiErrorresponse(String message, Integer status) {
        this.message = message;
        this.status = status;
    }
}

