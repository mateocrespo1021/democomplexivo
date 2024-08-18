package com.example.practicacomplexivo.services;

import com.example.practicacomplexivo.dao.IUsuarioDao;
import com.example.practicacomplexivo.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private final IUsuarioDao userRepository;

    public UsuarioService(IUsuarioDao userRepository) {
        this.userRepository = userRepository;
    }

    public List<Usuario> allUsers() {
        List<Usuario> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }
}
