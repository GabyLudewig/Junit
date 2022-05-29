package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Categoria;
import com.example.demo.service.CategoriaService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	public CategoriaService categoriaService;
	
		@ApiOperation(value = "Agregar categoria")
		@PostMapping("")
	private ResponseEntity<Categoria>guardar (@RequestBody Categoria categoria){
		Categoria temporal= categoriaService.create(categoria);
		
		try {
			return ResponseEntity.created(new URI("/"+temporal.getCat_id())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	
	@ApiOperation(value = "Listar categorias")
	@GetMapping()
	private ResponseEntity<List<Categoria>>listarCategorias (){
		return  ResponseEntity.ok(categoriaService.getAllCategorias());		
	}
	
	@ApiOperation(value = "Borrar categorias")
	@DeleteMapping (value = "/{id}")
	private ResponseEntity<Void>eliminarCategoria (@RequestBody Categoria categoria){
		categoriaService.delete(categoria);
		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value = "Mostrar una categoria")
	@GetMapping (value = "/{id}")
	private ResponseEntity<Optional<Categoria>> listarCategoriasPorId (@PathVariable ("id") Long id){
		return  ResponseEntity.ok(categoriaService.findById(id));		
	}
	
	@PutMapping (value = "/{id}")
	@ApiOperation(value = "Actualizar categoria")
	private ResponseEntity<Void>actualizarCategoria (@RequestBody Categoria categoria){
		categoriaService.update(categoria);
		return ResponseEntity.ok().build();
	}
}
