package com.example.practicacomplexivo.services;

import com.example.practicacomplexivo.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> findAll();

    public Usuario findById(Integer id);
    public void delete(Integer id);
}
