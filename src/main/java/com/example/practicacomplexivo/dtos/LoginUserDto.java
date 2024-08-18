package com.example.practicacomplexivo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // Genera un constructor con todos los campos
@NoArgsConstructor  // Genera un constructor sin argumentos
public class LoginUserDto {
    private String email;

    private String password;


}
