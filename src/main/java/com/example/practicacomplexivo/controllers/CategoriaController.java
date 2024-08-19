package com.example.practicacomplexivo.controllers;

import com.example.practicacomplexivo.entity.Categoria;
import com.example.practicacomplexivo.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;;
import java.util.List;

@RequestMapping("/api")
@RestController
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    //Mostrar todas las categorias
    @GetMapping("/categorias")
    public List<Categoria> index() {
        return categoriaService.findAll();
    }

    //Mostrar la categoria por id
    @GetMapping("/categorias/{id}")
    public Categoria show(@PathVariable Integer id) {
        return categoriaService.findById(id);

    }

    //Guardar la categoria
    @PostMapping("/categorias")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria create(@RequestBody Categoria categoria) {
        // Guardar la categoria en la base de datos
        return categoriaService.save(categoria);
    }


    //Editar la categoria
    @PutMapping("/categorias/{id}")
    public Categoria update(
            @RequestBody Categoria categoria,
            @PathVariable Integer id)
            {

        // Buscar la categoria existente
        Categoria categoriaActual = categoriaService.findById(id);

        categoriaActual.setNombre(categoria.getNombre());

        return categoriaService.save(categoriaActual);

    }

    //Eliminar Categoria

    @DeleteMapping("/categorias/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        categoriaService.delete(id);
    }
}
