package com.example.practicacomplexivo.services;

import com.example.practicacomplexivo.entity.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> findAll();
    public Producto save(Producto producto);
    public Producto findById(Integer id);
    public void delete(Integer id);
}
