package com.springboot.edificio_service.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.edificio_service.entity.Inmueble;
import com.springboot.edificio_service.repository.InmuebleRepository;

import jakarta.transaction.Transactional;

@org.springframework.stereotype.Service
public class InmuebleService {

    @Autowired
    private InmuebleRepository inmuebleRepository;

    public List<Inmueble> listar() {
        return inmuebleRepository.findAll();
    }
    
    public List<Inmueble> listar_disponibilidad(){
    	return inmuebleRepository.findAllByAvailability();
    }
    
    public Optional<Inmueble> findById(int id) {
        return inmuebleRepository.findById(id);
    }

    public void save(Inmueble inmueble, MultipartFile file, MultipartFile file2) {
        if (!file.isEmpty()) {
            String rutaImagen = saveImage(file);  // Guardar la imagen en el sistema de archivos
            inmueble.setImagen(rutaImagen);       // Asignar la ruta de la imagen al edificio
            String rutaImagen2 = saveImage(file2);
            inmueble.setImagen2(rutaImagen2);
        }
        inmuebleRepository.save(inmueble);
    }
    
	 public String saveImage(MultipartFile file) {
	        String ruta = "";

	        if (!file.isEmpty()) {
	            try {
	                // Obtener los bytes de la imagen
	                byte[] bytes = file.getBytes();

	                // Generar un nombre único para la imagen
	                String nombre = System.currentTimeMillis() + "_" + file.getOriginalFilename();

	                // Definir el directorio base
	                Path basePath = Paths.get("src/main/resources/static/img/");

	                // Obtener el tipo de contenido (MIME type)
	                String tipo = file.getContentType();

	                // Definir el directorio y la ruta basados en el tipo MIME
	                Path path;
	                switch (tipo) {
	                    case "image/png":
	                        path = basePath.resolve("png/" + nombre);
	                        ruta = "/img/png/" + nombre;
	                        break;
	                    case "image/jpg":
	                    case "image/jpeg":
	                        path = basePath.resolve("jpg/" + nombre);
	                        ruta = "/img/jpg/" + nombre;
	                        break;
	                    case "image/gif":
	                        path = basePath.resolve("gif/" + nombre);
	                        ruta = "/img/gif/" + nombre;
	                        break;
	                    default:
	                        throw new IOException("Tipo de archivo no soportado: " + tipo);
	                }

	                // Crear los directorios si no existen
	                Files.createDirectories(path.getParent());

	                // Escribir la imagen en la ruta especificada
	                Files.write(path, bytes);

	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }

	        return ruta;  // Devuelve la ruta relativa para guardarla en la base de datos o mostrarla en la vista
	    }
	
    
 	public void delete(int id){
        inmuebleRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return inmuebleRepository.existsById(id);   
    }

    public void update(int id, Inmueble updateInmueble){
        Optional<Inmueble> optionalInmueble= inmuebleRepository.findById(id);
        if (optionalInmueble.isPresent()) {
            Inmueble inmueble = optionalInmueble.get();
            inmueble.setDescripcion(updateInmueble.getDescripcion());
            inmueble.setDisponibilidad(updateInmueble.isDisponibilidad());
            inmueble.setPrecio(updateInmueble.getPrecio());
            inmueble.setN_cuarto(updateInmueble.getN_cuarto());
            inmueble.setImagen(updateInmueble.getImagen());
            inmueble.setImagen2(updateInmueble.getImagen2());
            inmueble.setEdificio(updateInmueble.getEdificio());
            inmuebleRepository.save(inmueble);
        }
    }
}
