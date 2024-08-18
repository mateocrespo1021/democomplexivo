package com.example.practicacomplexivo.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService {

    private final String storageLocation = "uploads/";

    public FileStorageService() {
        // Verificar si la carpeta existe, si no, crearla
        Path path = Paths.get(storageLocation);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                throw new RuntimeException("No se pudo crear el directorio de almacenamiento", e);
            }
        }
    }

    public String saveFile(MultipartFile file) throws IOException {
        // Generar un nombre único para el archivo
        String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path path = Paths.get(storageLocation + filename);

        // Guardar el archivo en el sistema de archivos
        Files.copy(file.getInputStream(), path);

        return filename;
    }
}
