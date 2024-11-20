package com.springboot.edificio_service.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.edificio_service.entity.Edificio;
import com.springboot.edificio_service.entity.Partner;
import com.springboot.edificio_service.repository.PartnerRepository;

@Service
public class PartnerService {

	@Autowired
	private PartnerRepository partnerRepository;
	
	public List<Partner> listar(){
		return partnerRepository.findAll();
	}
	
	 public void save(Partner partner, MultipartFile file, MultipartFile file2) {
	        if (!file.isEmpty()) {
	            String rutaImagen = saveImage(file);  // Guardar la imagen en el sistema de archivos
	            partner.setImg(rutaImagen);       // Asignar la ruta de la imagen al edificio
	            String rutaImagen2 = saveImage(file2);
	            partner.setImg2(rutaImagen2);
	        }
	        partnerRepository.save(partner);
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
	}
