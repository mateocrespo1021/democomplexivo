package com.example.practicacomplexivo.controllers;

import com.example.practicacomplexivo.entity.Producto;
import com.example.practicacomplexivo.services.FileStorageService;
import com.example.practicacomplexivo.services.IProductoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/api")
@RestController
public class ProductoController {
    @Autowired
    private IProductoService productoService;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/productos")
    public List<Producto> index() {
        return productoService.findAll();
    }

    @GetMapping("/productos/{id}")
    public Producto show(@PathVariable Integer id) {
        return productoService.findById(id);

    }

    @PostMapping("/productos")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto create(
            @RequestParam("producto") String productoJson,
            @RequestParam("file") MultipartFile file) throws IOException {

        // Convertir el JSON en un objeto Producto
        ObjectMapper objectMapper = new ObjectMapper();
        Producto producto = objectMapper.readValue(productoJson, Producto.class);

        // Guardar la imagen en el sistema de archivos y obtener el nombre del archivo
        String filename = fileStorageService.saveFile(file);

        // Establecer el nombre del archivo en el campo imagen del producto
        producto.setImagen(filename);

        // Guardar el producto en la base de datos
        return productoService.save(producto);
    }


    @PutMapping("/productos/{id}")
    public Producto update(
            @PathVariable Integer id,
            @RequestParam(value = "producto", required = false) String productoJson,
            @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {

        // Buscar el producto existente
        Producto productoActual = productoService.findById(id);

        // Actualizar los campos del producto con los datos del JSON si se proporciona
        if (productoJson != null && !productoJson.isEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
            Producto productoUpdates = objectMapper.readValue(productoJson, Producto.class);

            if (productoUpdates.getNombre() != null) {
                productoActual.setNombre(productoUpdates.getNombre());
            }

            if (productoUpdates.getPrecio() != null) {
                productoActual.setPrecio(productoUpdates.getPrecio());
            }

            if (productoUpdates.getDescripcion() != null) {
                productoActual.setDescripcion(productoUpdates.getDescripcion());
            }

            if (productoUpdates.getStock() != null) {
                productoActual.setStock(productoUpdates.getStock());
            }

            if (productoUpdates.getUbicacion() != null) {
                productoActual.setUbicacion(productoUpdates.getUbicacion());
            }

            if (productoUpdates.getFecha_caducidad() != null) {
                productoActual.setFecha_caducidad(productoUpdates.getFecha_caducidad());
            }

//            if (productoUpdates.getId_categoria() != null) {
//                productoActual.setId_categoria(productoUpdates.getId_categoria());
//            }

        }

        // Actualizar la imagen si se proporciona un archivo
        if (file != null && !file.isEmpty()) {
            String filename = fileStorageService.saveFile(file);
            productoActual.setImagen(filename);
        }

        // Guardar y devolver el producto actualizado
        return productoService.save(productoActual);
    }

    @DeleteMapping("/productos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        productoService.delete(id);
    }
}
