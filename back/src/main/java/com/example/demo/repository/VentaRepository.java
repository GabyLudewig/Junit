package com.example.demo.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Producto;

@FeignClient(name = "venta",url = "/localhost:8080")
public interface VentaRepository {
    @GetMapping("/producto")
    public List<Producto> getAll();
}

