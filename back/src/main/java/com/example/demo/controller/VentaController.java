package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Producto;
import com.example.demo.repository.VentaRepository;

import io.swagger.annotations.ApiOperation;

@RestController
	@RequestMapping("/")
	@CrossOrigin(origins = "*")
	public class VentaController {
	    @Autowired 
	    private VentaRepository ventaRepository;
	    @ApiOperation(value = "Lista de Venta")
	    @GetMapping("/venta")
		public ResponseEntity<?> getProductos(){
			try {
				List<Producto> getProductos = this.ventaRepository.getAll();
				return new ResponseEntity<>(getProductos, HttpStatus.OK);
			}catch (Exception e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}


