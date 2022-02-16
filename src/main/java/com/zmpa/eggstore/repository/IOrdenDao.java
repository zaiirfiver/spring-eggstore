package com.zmpa.eggstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zmpa.eggstore.model.Orden;

@Repository
public interface IOrdenDao extends JpaRepository<Orden, Integer>{
	

}
