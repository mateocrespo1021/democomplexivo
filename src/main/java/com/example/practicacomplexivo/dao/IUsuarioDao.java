package com.example.practicacomplexivo.dao;

import com.example.practicacomplexivo.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioDao extends CrudRepository<Usuario,Integer> {
    Optional<Usuario> findByEmail(String email);
}
