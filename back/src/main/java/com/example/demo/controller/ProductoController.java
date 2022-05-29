package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;

import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@PostMapping
	@ApiOperation(value = "Agregar producto")
	private ResponseEntity<Producto>guardar (@RequestBody Producto producto){
		Producto temporal= productoService.create(producto);
		
		try {
			return ResponseEntity.created(new URI("/"+temporal.getPro_id())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping
	@ApiOperation(value = "Listar productos")
	private ResponseEntity<List<Producto>>listarProductos (){
		return  ResponseEntity.ok(productoService.getAllProductos());		
	}
	
	@DeleteMapping (value = "/{id}")
	@ApiOperation(value = "Eliminar producto")
	private ResponseEntity<Void>eliminarProducto (@RequestBody Producto producto){
		productoService.delete(producto);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "/{id}")
	@ApiOperation(value = "Mostrar un producto")
	private ResponseEntity<Optional<Producto>> listarProductosPorId (@PathVariable ("id") Long id){
		return  ResponseEntity.ok(productoService.findById(id));		
	}
	
	@PutMapping (value = "/{id}")
	@ApiOperation(value = "Actualizar producto")
	private ResponseEntity<Void>actualizarProducto (@RequestBody Producto producto){
		productoService.update(producto);
		return ResponseEntity.ok().build();
	}
}
