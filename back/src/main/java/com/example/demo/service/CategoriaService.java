package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	public Categoria create (Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public List<Categoria> getAllCategorias (){
		return categoriaRepository.findAll();
	}

	public void delete (Categoria categoria) {
		categoriaRepository.delete(categoria);
	}
	
	public Optional<Categoria> findById (Long id) {
		return categoriaRepository.findById(id);
	}
	
	public void update (Categoria categoria) {
		try {
			categoria.setCat_id(null);
			categoriaRepository.save(categoria);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
