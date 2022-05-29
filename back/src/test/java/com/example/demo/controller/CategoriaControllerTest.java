package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CategoriaControllerTest {

	private int id = 4;
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Test
	@Order (1)
	
	public void testGuardar() {
		
		Producto prueba = new Producto();
		prueba.setPro_id((long) id);
		prueba.setPro_nombre("Blusa");
		prueba.setPro_descripcion("Prenda superior con botones y mangas");
		prueba.setPro_existencia((long) 11);
		prueba.setPro_precio("$150.00");
		productoRepository.save(prueba);
		assertNotNull(productoRepository.findById((long) id).get());
	}
	
	@Test
	@Order (2)
	
	public void testListar() {
		
		List<Producto> list = productoRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order (3)
	
	public void testBuscar() {
		
		Producto prueba = productoRepository.findById((long) 4 ).get();
		assertEquals("Blusa", prueba.getPro_nombre());
	}
	
}
