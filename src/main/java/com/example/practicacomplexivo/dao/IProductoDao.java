package com.example.practicacomplexivo.dao;

import com.example.practicacomplexivo.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoDao extends CrudRepository<Producto,Integer> {

}
