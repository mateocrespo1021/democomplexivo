package com.example.practicacomplexivo.services;

import com.example.practicacomplexivo.dao.ICategoriaDao;
import com.example.practicacomplexivo.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

    @Autowired
    private ICategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> findAll() {
        return (List<Categoria>) categoriaDao.findAll();
    }

    @Override
    @Transactional
    public Categoria save(Categoria categoria) {
        return categoriaDao.save(categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria findById(Integer id) {
        return categoriaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
       categoriaDao.deleteById(id);
    }
}
