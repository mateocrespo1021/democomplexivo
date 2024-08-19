package com.example.practicacomplexivo.dao;

import com.example.practicacomplexivo.entity.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaDao extends CrudRepository<Categoria,Integer> {

}
