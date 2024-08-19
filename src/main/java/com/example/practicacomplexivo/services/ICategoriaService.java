package com.example.practicacomplexivo.services;

import com.example.practicacomplexivo.entity.Categoria;
import com.example.practicacomplexivo.entity.Producto;

import java.util.List;

public interface ICategoriaService {
    public List<Categoria> findAll();
    public Categoria save(Categoria categoria);
    public Categoria findById(Integer id);
    public void delete(Integer id);
}
