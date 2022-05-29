package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;

@EnableFeignClients
@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	
	public Producto create (Producto producto) {
		return productoRepository.save(producto);
	}
	
	public List<Producto> getAllProductos (){
		return productoRepository.findAll();
	}

	public void delete (Producto producto) {
		productoRepository.delete(producto);
	}
	
	public Optional<Producto> findById (Long id) {
		return productoRepository.findById(id);
	}
	
	public void update (Producto producto) {
		try {
			producto.setPro_id(null);
			productoRepository.save(producto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
