package com.zmpa.eggstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zmpa.eggstore.model.Producto;

@Repository
public interface ProductoDao extends JpaRepository<Producto, Integer>{

}
