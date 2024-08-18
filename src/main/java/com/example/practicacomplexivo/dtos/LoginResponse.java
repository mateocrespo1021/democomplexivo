package com.example.practicacomplexivo.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Getter
@Setter
@Accessors(chain = true)
public class LoginResponse {
    private String token;

    private long expiresIn;

    private String rol;

    public String getToken() {
        return token;
    }


}
